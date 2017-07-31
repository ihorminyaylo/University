package model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import exception.InvalidFormatException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.time.LocalDate;

/**
 * Created by AsusIT on 24.07.2017.
 */

public class Lesson {
    private int idLesson;
    private Subject subject;
    private LocalDate date;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public LocalDate getDate() {
        return date;
    }

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    public void setDate(LocalDate date) throws InvalidFormatException {
        LocalDate today = LocalDate.now();
        if (today.getYear() == date.getYear()) {
            this.date = date;
            Lesson lesson = new Lesson();
        }
        else {
            throw new InvalidFormatException("Classmate couldn't in another year");
        }
    }

    public int getIdLesson() {
        return idLesson;
    }

    public void setIdLesson(int idLesson) {
        this.idLesson = idLesson;
    }

    public Lesson() {}

    public Lesson(Subject subject, LocalDate date) throws InvalidFormatException {
        this.subject = subject;
        setDate(date);
    }

    @Override
    public String toString() {
        return "Subject name - " + subject.getSubjectName() + ". Date : " + date;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Lesson)) {
            return false;
        }
        Lesson lesson = (Lesson) obj;
        return (lesson.getSubject().equals(this.subject) && lesson.getDate().equals(this.date));
    }
}
