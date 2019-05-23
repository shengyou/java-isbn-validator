import io.kraftsman.validator.ISBNValidator;
import io.kraftsman.validator.WrongDigitException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws IOException, WrongDigitException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter a ISBN: ");
        String isbn = reader.readLine();
        ISBNValidator validator = new ISBNValidator();
        if (validator.validate(isbn)) {
            System.out.println("This ISBN is valid");
        } else {
            System.out.println("This ISBN is NOT valid");
        }
    }
}
