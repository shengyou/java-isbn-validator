package io.kraftsman.validator;

public class ISBNValidator {
    public boolean validate(String isbn) throws WrongDigitException {

        isbn = removeNonNumericCharacter(isbn);

        if (isbn.length() != 10 && isbn.length() != 13) throw new WrongDigitException("ISBN should have 10 or 13 digits");

        int total = 0;
        if (isbn.length() == 10) {
            for (int i = 0; i < 10; i++) {
                int a = Character.getNumericValue(isbn.charAt(i));
                total += a * (10 - i);
            }

            return (total % 11 == 0);
        } else {
            for (int i = 0; i < 13; i++) {
                int a = Character.getNumericValue(isbn.charAt(i));
                int b = (i % 2 == 0) ? 1 : 3;

                total += a * b;
            }

            return (total % 10 == 0);
        }
    }

    private String removeNonNumericCharacter(@org.jetbrains.annotations.NotNull String isbn) {
        return isbn.trim().replaceAll("[^0-9]", "");
    }
}
