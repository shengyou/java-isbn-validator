package io.kraftsman.validator;

import org.jetbrains.annotations.NotNull;

import java.util.stream.IntStream;

public class ISBNValidator {
    public boolean validate(String isbn) throws WrongDigitException {

        isbn = removeNonNumericCharacter(isbn);

        if (isWrongDigits(isbn)) throw new WrongDigitException("ISBN should have 10 or 13 digits");

        if (isbn.length() == 10) {
            return validate10DigitsISBN(isbn);
        } else if (isbn.length() == 13) {
            return validate13DigitsISBN(isbn);
        }

        return false;
    }

    private boolean isWrongDigits(@NotNull String isbn) {
        return isbn.length() != 10 && isbn.length() != 13;
    }

    private boolean validate13DigitsISBN(@NotNull String isbn) {

        int x = IntStream.range(1, 14)
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> Character.getNumericValue(isbn.charAt(i - 1))).mapToInt(i -> i)
                .sum();

        int y = IntStream.range(1, 14)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> Character.getNumericValue(isbn.charAt(i - 1)) * 3)
                .mapToInt(i -> i)
                .sum();

        return ((x + y) % 10 == 0);
    }

    private boolean validate10DigitsISBN(String isbn) {
        int total = 0;

        for (int i = 0; i < 10; i++) {
            int a = (i == 9 && isbn.charAt(i) == 'X') ? 10 : Character.getNumericValue(isbn.charAt(i));
            total += a * (10 - i);
        }

        return (total % 11 == 0);
    }

    @NotNull
    private String removeNonNumericCharacter(@NotNull String isbn) {
        return isbn.trim().toUpperCase().replaceAll("[^0-9X]", "");
    }
}
