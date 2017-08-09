package service;

import servicesDB.StudentServiceDB;

public class PaginationService {
    private int countRowOFPages;
    private int current;


    public int getCountRowOFPages() {
        return countRowOFPages;
    }

    public void setCountRowOFPages(int countRowOFPages) {
        this.countRowOFPages = countRowOFPages;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public PaginationService(int current) {
        this.current = current;
    }
    /*public int getCountOfPage() {
        return new StudentServiceDB().getCountOfStudent();
    }*/
    public int getStart() {
        return getEnd() - countRowOFPages;
    }

    public int getEnd() {
        return current*countRowOFPages;
    }
}
