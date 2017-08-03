package model;

        import exception.InvalidFormatException;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

/**
 * Created by AsusIT on 24.07.2017.
 */
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private List<Mark> listMarks = new ArrayList<>();
    private final static String NAME_PATTERN = "[A-Z][a-z]+";
    Pattern pName = Pattern.compile(NAME_PATTERN);

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws InvalidFormatException {
        Matcher mFirstName = pName.matcher(firstName);
        if (mFirstName.matches()) {
            this.firstName = firstName;
        }
        else {
            throw new InvalidFormatException("First name isn't correct");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws InvalidFormatException {
        Matcher mLastName = pName.matcher(lastName);
        if (mLastName.matches()) {
            this.lastName = lastName;
        }
        else {
            throw new InvalidFormatException("Last name isn't correct");
        }
    }

    public List<Mark> getListMarks() {
        return listMarks;
    }

    public void setListMarks(List<Mark> listMarks) {
        for (Mark mark : listMarks) {

        }
        this.listMarks = listMarks;
    }

    public Student() {
    }

    public Student(String firstName, String lastName) throws InvalidFormatException {
        setFirstName(firstName);
        setLastName(lastName);
    }

    @Override
    public String toString() {
        return "First Name - " + getFirstName() + ". Last Name - " + getLastName() + ". List Marks : " + getListMarks();
    }
}
