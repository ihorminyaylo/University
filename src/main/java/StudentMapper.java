import java.util.List;

/**
 * Created by AsusIT on 26.07.2017.
 */
public interface StudentMapper {
    Student getStudentById(Integer id);
    List<Student> getStudent();
}
