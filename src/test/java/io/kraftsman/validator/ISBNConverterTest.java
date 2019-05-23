package io.kraftsman.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ISBNConverterTest {
    @Test
    void shouldConvert10DigitsISBNTo13DigitsISBN() {
        // arrange
        ISBNConverter converter = new ISBNConverter();
        String isbn = "1617293296";
        String expected = "9781617293290";

        // act
        String actual = converter.convert(isbn);

        // assert
        assertEquals(expected, actual);
    }
}