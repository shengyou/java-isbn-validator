package io.kraftsman.validator;

public class ISBNConverter {
    public String convert(String isbn) {

        isbn = "978" + isbn.substring(0, isbn.length() - 1);
        int total = 0;

        for (int i = 0; i < 12; i++) {
            int a = Character.getNumericValue(isbn.charAt(i));
            int b = (i % 2 == 0)? 1 : 3;

            total += a * b;
        }

        String lastChar;

        if (total % 10 == 0) {
            lastChar = "0";
        } else {
            lastChar = Integer.toString((10 - (total % 10)));
        }

        return isbn + lastChar;
    }
}
