package menu.actions;

import comporators.CitationResearchPaperComparator;
import comporators.DateResearchPaperComparator;
import comporators.LengthResearchPaperComparartor;
import enums.Format;
import users.User;
import Database.Database;
import journal.Journal;
import papers.ResearchPaper;
import utils.Post;
import utils.UserInput;

import java.util.*;

public class CommonActions {
    protected final User user;

    public CommonActions(User user) {
        this.user = user;
    }

    public MenuAction viewNews() {
        return new MenuAction() {

            public String getDescription() {
                return "View News Feed";
            }

            @Override
            public void execute() throws Exception {
                var news = user.viewNews();
                if (news.isEmpty()) {
                    System.out.println("No news available");
                    return;
                }

                for (int i = 0; i < news.size(); i++) {
                    System.out.printf("%d. %s%n", i + 1, news.get(i));
                }

                UserInput.handleUserInput("Select news to view comments (0 to skip):", input -> {
                    int index = Integer.parseInt(input);
                    if (index == 0) return;

                    var selectedNews = news.get(index - 1);
                    if (selectedNews.getComments().isEmpty()) {
                        System.out.println("No comments");
                    } else {
                        selectedNews.getComments().forEach(System.out::println);
                    }

                    if (UserInput.confirmAction("Add comment?")) {
                        String comment = UserInput.getText("Enter comment:");
                        selectedNews.getComments().add(new Post(comment, user));
                        System.out.println("Comment added");
                    }
                });
            }
        };
    }

    public MenuAction checkNotifications() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Check Notifications";
            }

            @Override
            public void execute() {
                var notifications = user.readNotifications();
                if (notifications.isEmpty()) {
                    System.out.println("No notifications");
                } else {
                    notifications.forEach(System.out::println);
                }
            }
        };
    }

    public MenuAction viewResearchPapers() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Browse Research Papers";
            }

            @Override
            public void execute() throws Exception {
                if (Database.DATA.getResearchPapers().isEmpty()) {
                    System.out.println("No papers available");
                    return;
                }

                System.out.println("Sort by:\n1. Alphabetical\n2. Length\n3. Citations\n4. Publication Date");
                int sortChoice = Integer.parseInt(UserInput.getText("Choose sorting method:"));

                Vector<ResearchPaper> papers;
                switch (sortChoice) {
                    case 2 -> papers = user.printPapers(new LengthResearchPaperComparartor());
                    case 3 -> papers = user.printPapers(new CitationResearchPaperComparator());
                    case 4 -> papers = user.printPapers(new DateResearchPaperComparator());
                    default -> papers = user.printPapers(null);
                }

                for (int i = 0; i < papers.size(); i++) {
                    System.out.printf("%d. %s%n", i + 1, papers.get(i));
                }

                if (UserInput.confirmAction("Would you like to cite a paper?")) {
                    int paperIndex = Integer.parseInt(UserInput.getText("Enter paper number:")) - 1;
                    System.out.println("Citation format:\n1. Plain Text\n2. BibTeX");
                    int formatChoice = Integer.parseInt(UserInput.getText("Choose format:"));
                    Format format = Format.values()[formatChoice - 1];
                    System.out.println(papers.get(paperIndex).getcitation(format));
                }
            }
        };
    }

    public MenuAction manageJournalSubscriptions() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Manage Journal Subscriptions";
            }

            @Override
            public void execute() throws Exception {
                var journals = Database.DATA.getJournals();
                if (journals.isEmpty()) {
                    System.out.println("No journals available");
                    return;
                }

                while (true) {
                    System.out.println("\nAvailable Journals:");
                    for (int i = 0; i < journals.size(); i++) {
                        Journal journal = journals.get(i);
                        String status = journal.getSubscribers().contains(user) ? "[Subscribed]" : "";
                        System.out.printf("%d. %s %s%n", i + 1, journal, status);
                    }

                    int choice = Integer.parseInt(UserInput.getText("Select journal (0 to exit):"));
                    if (choice == 0) break;

                    Journal selectedJournal = journals.get(choice - 1);
                    if (selectedJournal.getSubscribers().contains(user)) {
                        user.unsubscribe(selectedJournal);
                        System.out.println("Unsubscribed successfully");
                    } else {
                        user.subscribe(selectedJournal);
                        System.out.println("Subscribed successfully");
                    }
                }
            }
        };
    }
}
