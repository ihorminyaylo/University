package io;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Student;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AsusIT on 24.07.2017.
 */
public class JSON {
    public static void objectToFile(String filepath, List<Student> listOfStudent) throws IOException {
        new ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(new File(filepath), listOfStudent);
    }

    public static List<Student> getListFromFile(String filepath) throws IOException {
        List<Student> userList =
                new ObjectMapper().readValue(new File(filepath), new TypeReference<ArrayList<Student>>() {});
        return userList;
        /*return filepath.endsWith(".txt") ?
                new ObjectMapper().readValue(new File(filepath), new TypeReference<ArrayList<model.Student>>() {}) : new ArrayList<>();*/
    }
}
