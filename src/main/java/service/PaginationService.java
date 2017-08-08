package service;

public class PaginationService {
    private int showPages;
    private int countPages;
    private int current;

    public int getShowPages() {
        return showPages;
    }

    public void setShowPages(int showPages) {
        this.showPages = showPages;
    }

    public int getCountPages() {
        return countPages;
    }

    public void setCountPages(int countPages) {
        this.countPages = countPages;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public PaginationService(int showPages, int countPages, int current) {
        this.showPages = showPages;
        this.countPages = countPages;
        this.current = current;
    }
}
