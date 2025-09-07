package com.example.imports;

import java.nio.file.Path;

public class CsvProfileImporter implements ProfileImporter {
    private final NaiveCsvReader csvReader;
    private final ProfileService profileService;

    public CsvProfileImporter(NaiveCsvReader csvReader, ProfileService profileService) {
        this.csvReader = csvReader;
        this.profileService = profileService;
    }

    @Override
    public int importFrom(Path csvFile) {
        int count = 0;
        var rows = csvReader.read(csvFile);
        if (rows.isEmpty()) return 0;
        // Assume first row is header
        int start = 1;
        for (int i = start; i < rows.size(); i++) {
            String[] row = rows.get(i);
            if (row.length < 3) {
                System.out.println("Row " + (i+1) + ": Skipped (missing fields)");
                continue;
            }
            String id = row[0].trim();
            String email = row[1].trim();
            String displayName = row[2].trim();
            if (id.isEmpty() || email.isEmpty()) {
                System.out.println("Row " + (i+1) + ": Skipped (missing id/email)");
                continue;
            }
            if (!email.contains("@")) {
                System.out.println("Row " + (i+1) + ": Skipped (bad email)");
                continue;
            }
            try {
                profileService.createProfile(id, email, displayName);
                count++;
            } catch (Exception e) {
                System.out.println("Row " + (i+1) + ": Skipped (" + e.getMessage() + ")");
            }
        }
        return count;
    }
}
