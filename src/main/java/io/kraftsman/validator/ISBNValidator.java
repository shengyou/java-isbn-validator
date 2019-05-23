package io.kraftsman.validator;

public class ISBNValidator {
    public boolean validate(String isbn) {

        isbn = removeNonNumericCharacter(isbn);

        int total = 0;
        for (int i = 0; i < 13; i++) {
            int a = Character.getNumericValue(isbn.charAt(i));
            int b = (i % 2 == 0) ? 1 : 3;

            total += a * b;
        }

        return (total % 10 == 0);
    }

    private String removeNonNumericCharacter(@org.jetbrains.annotations.NotNull String isbn) {
        return isbn.replaceAll("[^0-9]", "");
    }
}
