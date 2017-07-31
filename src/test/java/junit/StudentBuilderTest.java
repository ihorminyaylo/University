package junit;

import exception.InvalidFormatException;
import model.Student;
import org.junit.jupiter.api.Test;

public class StudentBuilderTest {
    //@Test(expectedExceptions = InvalidFormatException.class)
    public void testIncorrectFullName() throws InvalidFormatException {
        Student student = new Student();
        student.setFirstName("Anna- Maria");
        student.setLastName("Mihailuk      ");
    }
}
