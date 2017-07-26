import java.util.List;

/**
 * Created by AsusIT on 25.07.2017.
 */
public class MarkServices {
    private Student student;

    public void setStudent(Student student) {
        this.student = student;
    }

    public MarkServices() {}

    public MarkServices(Student student) {
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
}
