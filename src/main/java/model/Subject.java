package model;

/**
 * Created by AsusIT on 24.07.2017.
 */
public class Subject {
    private int idSubject;
    private String subjectName;

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String nameSubject) {
        this.subjectName = subjectName;
    }

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

}
