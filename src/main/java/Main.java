import exception.InvalidFormatException;
import io.JSON;
import model.*;
import service.PaginationService;
import service.StudentServices;
import servicesDB.LessonServiceDB;
import servicesDB.MarkServiceDB;
import servicesDB.StudentServiceDB;
import servicesDB.UserServiceDB;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by AsusIT on 24.07.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        List<Student> list = new ArrayList<>();
        list.addAll(new StudentServiceDB().getAllStudents());
        JSON.objectToFile("C:\\Users\\iminiatc\\Desktop\\a.txt", list);
    }
}