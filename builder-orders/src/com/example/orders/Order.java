package com.example.orders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderLine> lines; // internal, not exposed directly
    private final Integer discountPercent; // 0..100
    private final boolean expedited;
    private final String notes;

    private Order(String id, String customerEmail, List<OrderLine> lines, Integer discountPercent, boolean expedited, String notes) {
        this.id = id;
        this.customerEmail = customerEmail;
        // store defensive copies internally
        List<OrderLine> copy = new ArrayList<>();
        if (lines != null) {
            for (OrderLine l : lines) {
                copy.add(new OrderLine(l.getSku(), l.getQuantity(), l.getUnitPriceCents()));
            }
        }
        this.lines = Collections.unmodifiableList(copy);
        this.discountPercent = discountPercent;
        this.expedited = expedited;
        this.notes = notes;
    }

    // Builder
    public static class Builder {
        private final String id;
        private final String customerEmail;
        private final List<OrderLine> lines = new ArrayList<>();
        private Integer discountPercent;
        private boolean expedited;
        private String notes;

        public Builder(String id, String customerEmail) {
            this.id = id;
            this.customerEmail = customerEmail;
        }

        public Builder addLine(OrderLine line) {
            if (line != null) this.lines.add(line);
            return this;
        }

        public Builder addLines(List<OrderLine> lines) {
            if (lines != null) for (OrderLine l : lines) if (l != null) this.lines.add(l);
            return this;
        }

        public Builder discountPercent(Integer d) { this.discountPercent = d; return this; }
        public Builder expedited(boolean e) { this.expedited = e; return this; }
        public Builder notes(String n) { this.notes = n; return this; }

        public Order build() {
            // required fields
            if (id == null || id.isEmpty()) throw new IllegalStateException("id is required");
            if (customerEmail == null || customerEmail.isEmpty()) throw new IllegalStateException("customerEmail is required");
            // validation
            if (!PricingRules.isValidEmail(customerEmail)) throw new IllegalArgumentException("invalid email");
            if (!PricingRules.isValidDiscount(discountPercent)) throw new IllegalArgumentException("invalid discount");
            if (lines.isEmpty()) throw new IllegalStateException("order must have at least one line");
            return new Order(id, customerEmail, lines, discountPercent, expedited, notes);
        }
    }

    // only getters
    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }

    public List<OrderLine> getLines() {
        List<OrderLine> copy = new ArrayList<>();
        for (OrderLine l : lines) copy.add(new OrderLine(l.getSku(), l.getQuantity(), l.getUnitPriceCents()));
        return Collections.unmodifiableList(copy);
    }

    public Integer getDiscountPercent() { return discountPercent; }
    public boolean isExpedited() { return expedited; }
    public String getNotes() { return notes; }

    public int totalBeforeDiscount() {
        int sum = 0;
        for (OrderLine l : lines) sum += l.getQuantity() * l.getUnitPriceCents();
        return sum;
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null) return base;
        return base - (base * discountPercent / 100);
    }
}
