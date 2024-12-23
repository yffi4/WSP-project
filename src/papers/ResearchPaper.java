package papers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;
import java.util.stream.Collectors;

import Database.Database;
import enums.Format;
import journal.Journal;
import users.Researcher;

public class ResearchPaper implements Serializable, Comparable<ResearchPaper>{
    private String doi;
    private String title;
    private Vector<Researcher> authors;
    private Vector<String> pages;
    private int year;
    private int citations;
    private Journal publisher;




    public ResearchPaper(String title, Vector<Researcher> authors, Vector<String> pages, Journal publisher) {
        this();
        this.title = title;
        this.authors = authors;
        this.pages = pages;
        this.publisher = publisher;
    }
    public ResearchPaper() {
        this.doi = "DOI"+ Database.DATA.getResearchPapers().size();
        this.year = Database.DATA.getYear();
    }
    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
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

    public Journal getPublisher() {
        return publisher;
    }

    public void setPublisher(Journal publisher) {
        this.publisher = publisher;
    }

    public String getcitation(Format format) {

        String citation ="";
        if(format==Format.BIB_TEX) {
            citation+="author={";
            citation += authors.stream().map(n->n.toString())
                    .collect(Collectors.joining(", "));
            citation+="},\ntitle={" + title + "},\nyear={"+year + "},\ndoi={" + doi +"}";

        }else {
            citation += authors.stream().map(n->n.toString())
                    .collect(Collectors.joining(", "));
            citation+=", " + title + ", "+year + ", " + publisher+ ", " + doi;
        }
        citations++;
        return citation;
    }

    public String read() {

        return pages.stream().collect(Collectors.joining("\n\n"));
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ResearchPaper other = (ResearchPaper) obj;
        return Objects.equals(doi, other.doi);
    }
    public int compareTo(ResearchPaper o) {
        return title.compareTo(o.getTitle());
    }
    public int hashCode() {
        return Objects.hash(doi);
    }
}
