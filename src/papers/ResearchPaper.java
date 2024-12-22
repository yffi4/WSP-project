package papers;

import java.util.Vector;

import enums.Format;
import users.Researcher;

public class ResearchPaper {
    private int doi;
    private String title;
    private Vector<Researcher> authors;
    private Vector<String> pages;
    private int year;
    private int citations;
    private int publisher;

    public ResearchPaper() {
    }
  
    public int getDoi() {
        return doi;
    }

    public void setDoi(int doi) {
        this.doi = doi;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Vector<Researcher> getAuthors() {
        return authors;
    }

    public void setAuthors(Vector<Researcher> authors) {
        this.authors = authors;
    }

    public Vector<String> getPages() {
        return pages;
    }

    public void setPages(Vector<String> pages) {
        this.pages = pages;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCitations() {
        return citations;
    }

    public void setCitations(int citations) {
        this.citations = citations;
    }

    public int getPublisher() {
        return publisher;
    }

    public void setPublisher(int publisher) {
        this.publisher = publisher;
    }

    public String getcitation(Format format) {
        return "";
    }

    public String read() {
        return "";
    }
}
