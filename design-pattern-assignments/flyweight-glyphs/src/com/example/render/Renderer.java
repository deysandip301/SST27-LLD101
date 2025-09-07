package com.example.render;

public class Renderer {
    public int render(String text) {
        int cost = 0;
        for (char c : text.toCharArray()) {
            // Style is shared via flyweight
            boolean bold = (c % 7 == 0);
            TextStyle style = TextStyleFactory.getTextStyle("Inter", 14, bold);
            Glyph g = new Glyph(c, style);
            cost += g.drawCost();
        }
        return cost;
    }
}
