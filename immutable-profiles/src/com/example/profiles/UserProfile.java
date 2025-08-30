package com.example.profiles;

public final class UserProfile {
    private final String id;
    private final String email;
    private final String phone;
    private final String displayName;
    private final String address;
    private final boolean marketingOptIn;
    private final String twitter;
    private final String github;

    private UserProfile(Builder b) {
        this.id = b.id;
        this.email = b.email;
        this.phone = b.phone;
        this.displayName = b.displayName;
        this.address = b.address;
        this.marketingOptIn = b.marketingOptIn;
        this.twitter = b.twitter;
        this.github = b.github;
    }

    public static class Builder {
        private String id;
        private String email;
        private String phone;
        private String displayName;
        private String address;
        private boolean marketingOptIn;
        private String twitter;
        private String github;

        public Builder(String id, String email) {
            this.id = id;
            this.email = email;
        }

        public Builder(UserProfile p) {
            this.id = p.id;
            this.email = p.email;
            this.phone = p.phone;
            this.displayName = p.displayName;
            this.address = p.address;
            this.marketingOptIn = p.marketingOptIn;
            this.twitter = p.twitter;
            this.github = p.github;
        }

        public Builder id(String id) { this.id = id; return this; }
        public Builder email(String email) { this.email = email; return this; }
        public Builder phone(String phone) { this.phone = phone; return this; }
        public Builder displayName(String displayName) { this.displayName = displayName; return this; }
        public Builder address(String address) { this.address = address; return this; }
        public Builder marketingOptIn(boolean marketingOptIn) { this.marketingOptIn = marketingOptIn; return this; }
        public Builder twitter(String twitter) { this.twitter = twitter; return this; }
        public Builder github(String github) { this.github = github; return this; }

        public UserProfile build() {
            // centralize validation
            Validation.requireNonBlank(id, "id");
            Validation.requireEmail(email);
            // normalize/trim display name to a sane max length
            if (displayName != null && displayName.length() > 100) {
                displayName = displayName.substring(0, 100);
            }
            return new UserProfile(this);
        }
    }

    public Builder toBuilder() { return new Builder(this); }

    // getters
    public String getId() { return id; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getDisplayName() { return displayName; }
    public String getAddress() { return address; }
    public boolean isMarketingOptIn() { return marketingOptIn; }
    public String getTwitter() { return twitter; }
    public String getGithub() { return github; }
}
