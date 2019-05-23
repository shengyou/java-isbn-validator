package io.kraftsman.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ISBNValidatorTest {

    @Test
    void shouldPassWhenEnterAValidate13DigitISBN() throws WrongDigitException {
        // arrange
        ISBNValidator validator = new ISBNValidator();
        String isbn = "9781617293290";

        // act
        boolean actual = validator.validate(isbn);

        // assert
        assertTrue(actual);
    }

    @Test
    void shouldPassIfISBNHasDashCharacter() throws WrongDigitException {
        // arrange
        ISBNValidator validator = new ISBNValidator();
        String isbn = "978-1617293290";

        // act
        boolean actual = validator.validate(isbn);

        // assert
        assertTrue(actual);
    }

    @Test
    void shouldPassIfISBNHasSpace() throws WrongDigitException {
        // arrange
        ISBNValidator validator = new ISBNValidator();
        String isbn = " 978-1 6172932 90 ";

        // act
        boolean actual = validator.validate(isbn);

        // assert
        assertTrue(actual);
    }

    @Test
    void shouldThrowExceptionWhenISBNIsNot13Digit() {
        // assume
        assertThrows(WrongDigitException.class, () -> {
            // arrange
            ISBNValidator validator = new ISBNValidator();
            String isbn = "978161729329";

            // act
            validator.validate(isbn);
        });
    }
}