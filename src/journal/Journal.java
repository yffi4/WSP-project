package journal;


import java.util.Date;
import java.util.List;
import java.util.Vector;



public class Journal {

    private String title;
    private Integer journalId;
    private String publisher;
    private Date publicationDate;
    private List<Article> articles;
    private Publish publish;


 
    
    
    
 
    private Vector<Subscriber> subscribers;


    public Vector<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Vector<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }


    


    public Journal(String title, Integer journalId, String publisher, Date publicationDate, Publish publish) {
        this.title = title;
        this.journalId = journalId;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.publish = publish;
        this.articles = new Vector<>();
    }


    public Integer getJournalId() {
        return journalId;
    }

    public void setJournalId(Integer journalId) {
        this.journalId = journalId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }


    public Vector<Article> getArticles() {
        return new Vector<>(articles);
    }


    public void setArticles(Vector<Article> articles) {
        this.articles = articles;
    }


    public void addArticle(Article article) {
        if (article != null) {
            this.articles.add(article);
        }
    }


    public void removeArticle(Article article) {
        this.articles.remove(article);
    }

    public Publish getPublish() {
        return publish;
    }

    public void setPublish(Publish publish) {
        this.publish = publish;
    }


    @Override
    public String toString() {
        return "Journal{" +
                "title='" + title + '\'' +
                ", journalId=" + journalId +
                ", publisher='" + publisher + '\'' +
                ", publicationDate=" + publicationDate +
                ", articles=" + articles +
                ", publish=" + publish +
                '}';
    }
}
