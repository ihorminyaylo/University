import exception.InvalidFormatException;
import model.*;
import service.StudentServices;
import servicesDB.LessonServiceDB;
import servicesDB.MarkServiceDB;
import servicesDB.StudentServiceDB;

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
        System.out.println(new StudentServiceDB().getCountOfStudent());
    }
}