package service;

import exception.InvalidFormatException;
import model.Lesson;
import model.Mark;
import model.Student;

import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by AsusIT on 25.07.2017.
 */
public class StudentServices {
    private Student student;
    private final static String NAME_PATTERN = "[A-Z][a-z]+";
    Pattern pName = Pattern.compile(NAME_PATTERN);

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentServices() {}

    public StudentServices(Student student) {
        this.student = student;
    }

    public void addMarkForStudent(Mark newMark) throws InvalidFormatException {
        List<Mark> listMarks = student.getListMarks();
        if (listMarks.isEmpty()) {
            listMarks.add(newMark);
        }
        else {
            for (Mark mark : listMarks) {
                if (!mark.getLesson().equals(newMark.getLesson())) {
                    listMarks.add(newMark);
                    return;
                } else {
                    throw new InvalidFormatException("The student has mark of this lesson");
                }
            }
        }
    }

    public void validateName(String name) throws InvalidFormatException {
        Matcher mFirstName = pName.matcher(name);
        if (!mFirstName.matches()) {
            throw new InvalidFormatException("Name isn't correct");
        }
    }

    public double getAverageMarkForStudent(List<Mark> markList) {
        return markList.stream().collect(Collectors.averagingDouble(Mark::getScore));
    }
}
