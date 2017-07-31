package model;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by AsusIT on 24.07.2017.
 */
public class Journal{
    private List<Mark> listMarks = new ArrayList<>();

    public List<Mark> getListMarks() {
        return listMarks;
    }

    public void setListMarks(List<Student> listStudent) {
        for (Student student : listStudent) {
            listMarks.addAll(student.getListMarks());
        }
    }

    public Journal() {}

    public double getAverageMarkForSubject(Subject subject) {
        return listMarks.stream().filter(mark-> mark.getLesson().getSubject().equals(subject)).collect(Collectors.averagingDouble(Mark::getScore));
    }

    public Set<Subject> getSubjectsOfDate(LocalDate date) {
        Set<Subject> subjects = new HashSet<>();
        listMarks.stream().filter(mark -> mark.getLesson().getDate()
                .equals(date)).forEach(mark -> subjects.add(mark.getLesson().getSubject()));
        return subjects;
    }

    public Set<Lesson> getLessonsOfSubject(Subject subject) {
        Set<Lesson> lessons = new HashSet<>();
        listMarks.stream().filter(mark -> mark.getLesson().getSubject().equals(subject)).forEach(mark -> lessons.add(mark.getLesson()));
        return lessons;
    }
}
