package io.kraftsman.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ISBNValidatorTest {

    @Test
    void shouldPassWhenEnterAValidate13DigitISBN() {
        // arrange
        ISBNValidator validator = new ISBNValidator();
        String isbn = "9781617293290";

        // act
        boolean actual = validator.validate(isbn);

        // assert
        assertTrue(actual);
    }

    @Test
    void shouldPassIfISBNHasDashCharacter() {
        // arrange
        ISBNValidator validator = new ISBNValidator();
        String isbn = "978-1617293290";

        // act
        boolean actual = validator.validate(isbn);

        // assert
        assertTrue(actual);
    }
}