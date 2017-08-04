package model;

import exception.InvalidFormatException;

/**
 * Created by AsusIT on 24.07.2017.
 */
public class Mark {
    private int idMark;
    private Student student;
    private Lesson lesson;
    private double score;

    public int getIdMark() {
        return idMark;
    }

    public void setIdMark(int idMark) {
        this.idMark = idMark;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) throws InvalidFormatException {
        if (score >= 0 && score <= 100) {
            this.score = score;
        }
        else {
            throw new InvalidFormatException("Score isn't correct");
        }
    }

    public Mark() {}

    public Mark(Lesson lesson, double score) {
        this.lesson = lesson;
        this.score = score;
    }

    public Mark(Lesson lesson, Student student, int score) {
        this.lesson = lesson;
        this.student = student;
        this.score = score;
    }

    @Override
    public String toString() {
        return "id lesson - " + lesson.getIdLesson() + ". Date - " + lesson.getSubject() + ", date - " + lesson.getDate() + ", score - " + score;
    }
}
