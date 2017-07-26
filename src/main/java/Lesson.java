import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by AsusIT on 24.07.2017.
 */

public class Lesson {
    private Subject subject;
    private LocalDate timeClass;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public LocalDate getTimeClass() {
        return timeClass;
    }

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    public void setTimeClass(LocalDate timeClass) throws InvalidFormatException {
        LocalDate today = LocalDate.now();
        if (today.getYear() == timeClass.getYear()) {
            this.timeClass = timeClass;
            Lesson lesson = new Lesson();
        }
        else {
            throw new InvalidFormatException("Classmate couldn't in another year");
        }
    }

    public Lesson() {}

    public Lesson(Subject subject, LocalDate timeClass) throws InvalidFormatException {
        this.subject = subject;
        setTimeClass(timeClass);
    }

    @Override
    public String toString() {
        return "Subject - " + subject + ". Date : " + timeClass;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Lesson)) {
            return false;
        }
        Lesson lesson = (Lesson) obj;
        return (lesson.getSubject().equals(this.subject) && lesson.getTimeClass().equals(this.timeClass));
    }
}
