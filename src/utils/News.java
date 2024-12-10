package utils;

import Database.Database;
import enums.NewsTopic;
import papers.ResearchPaper;
import users.Researcher;
import users.User;

import java.util.*;


/**
* @generated
*/
public class News extends Post {
    

    
    /**
    * @generated
    */
    private NewsTopic topic;


    private Vector<Post> comments;

    public News(NewsTopic topic, String content, User author){
        super.setDate(new Date());
        super.setContent(content);
        super.setAuthor(author);
        this.topic = topic;
    }

    public NewsTopic getTopic() {
        return topic;
    }

    public void setTopic(NewsTopic topic) {
        this.topic = topic;
    }

    public Vector<Post> getComments() {
        return comments;
    }

    public void setComments(Vector<Post> comments) {
        this.comments = comments;
    }
    //                          Operations



    public News autoGenerate() {
        List<ResearchPaper> researchPapers = Database.DATA.getResearchPapers();



        if (researchPapers.isEmpty()) {
            return new News(NewsTopic.GENERAL, "No research papers found.", null);
        }

        // Подсчет цитирований для каждого автора
        Map<User, Integer> authorCitations = new HashMap<>();
        for (ResearchPaper paper : researchPapers) {
            for (User author : paper.getAuthors()) {
                authorCitations.put(
                        author,
                        authorCitations.getOrDefault(author, 0) + paper.getCitations()
                );
            }
        }

        // Поиск топового исследователя
        Map.Entry<User, Integer> topAuthorEntry = authorCitations.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        if (topAuthorEntry != null) {
            User topAuthor = topAuthorEntry.getKey();
            int totalCitations = topAuthorEntry.getValue();


            String content = "Top Researcher: " + topAuthor.getName() +
                    " has achieved " + totalCitations + " citations.";
            return new News(NewsTopic.RESEARCH, content, topAuthor);
        }


        return new News(NewsTopic.GENERAL, "No top researcher could be identified.", null);

    }

	
}
