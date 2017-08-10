package io;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Student;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AsusIT on 24.07.2017.
 */
public class JSON {
    public static FileOutputStream objectToFile(List<Student> listOfStudent) throws IOException {
        FileOutputStream result = new FileOutputStream("studentList");
        new ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(result, listOfStudent);
        return result;
    }

    public static List<Student> getListFromFile(String filepath) throws IOException {
        List<Student> userList =
                new ObjectMapper().readValue(new File(filepath), new TypeReference<ArrayList<Student>>() {});
        return userList;
    }
}
