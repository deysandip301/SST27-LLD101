package com.example.profiles;

import java.util.Objects;

public class ProfileService {

    public UserProfile createMinimal(String id, String email) {
        // validation inside builder
        return new UserProfile.Builder(id, email).build();
    }

    public UserProfile updateDisplayName(UserProfile p, String displayName) {
        Objects.requireNonNull(p, "profile");
        return p.toBuilder().displayName(displayName).build();
    }
}
