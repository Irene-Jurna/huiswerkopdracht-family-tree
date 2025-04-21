package org.example;

public enum Gender {
    VROUW, MAN, NON_BINAIR, ANDERS;

    public static Gender fromString(String genderInput) {
        if (genderInput == null || genderInput.trim().isEmpty()) {
            throw new IllegalArgumentException("Gender mag niet leeg zijn");
        }

        switch (genderInput.trim().toLowerCase()) {
            case "v":
            case "vrouw": return VROUW;
            case "m":
            case "man": return MAN;
            case "nonbinaire":
            case "non-binary":
            case "non-binair": return NON_BINAIR;
            case "x":
            case "overig":
            case "anders": return ANDERS;
            default: throw new IllegalArgumentException("Ongeldig gender. Kies: v / m / x / o");
        }
    }
}
