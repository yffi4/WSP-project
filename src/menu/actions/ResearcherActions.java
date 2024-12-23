package menu.actions;

import Database.Database;
import journal.Journal;
import papers.ResearchPaper;
import users.Researcher;
import users.User;
import utils.FundingRequest;
import utils.UserInput;

import java.util.Vector;

public class ResearcherActions extends CommonActions{
    private final Researcher researcher;

    public ResearcherActions(Researcher researcher) {
        super(researcher);
        this.researcher = researcher;
    }

    public MenuAction publishPaper() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Publish a Research Paper";
            }

            @Override
            public void execute() {
                System.out.println("Publishing a research paper...");

                String title = UserInput.getText("Enter the title of the paper:");
                Vector<Researcher> authors = new Vector<>();
                authors.add(researcher); // Automatically add the current researcher as an author

                String pagesInput = UserInput.getText("Enter pages (comma-separated):");
                Vector<String> pages = new Vector<>();
                for (String page : pagesInput.split(",")) {
                    pages.add(page.trim());
                }

                // Assuming a journal is pre-selected or fetched dynamically
                System.out.println("Select a journal to publish in (not implemented, using placeholder):");
                Journal journal = new Journal("Sample Journal");

                researcher.publishPaper(title, authors, pages, journal);
                System.out.println("Research paper published successfully.");
            }
        };
    }
    public MenuAction printPaper(){
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "";
            }

            @Override
            public void execute() throws Exception {
                Vector<ResearchPaper> papers = researcher.printPaper();
                if (papers.isEmpty()) {
                    System.out.println("You have no research papers published.");
                } else {
                    System.out.println("Your Research Papers:");
                    for (int i = 0; i < papers.size(); i++) {
                        ResearchPaper paper = papers.get(i);
                        System.out.println((i + 1) + ". " + paper.getTitle() + " - Citations: " + paper.getCitations());
                    }
                }

            }
        };
    }

    public MenuAction proposeProject() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Propose a Research Project";
            }

            @Override
            public void execute() {
                System.out.println("Proposing a research project...");

                String name = UserInput.getText("Enter the name of the project:");

                // Gather team members
                Vector<Researcher> team = new Vector<>();
                team.add(researcher); // Add current researcher to the team

                String teamInput = UserInput.getText("Enter additional team members (comma-separated, names):");

                for (String member : teamInput.split(",")) {
                    // Assuming we have a method to find a researcher by name (not implemented)
                    Researcher teamMember = Database.DATA.getResearchers().stream().filter(n->n.getLastName().equalsIgnoreCase(researcher.getLastName())).findFirst().orElse(null);
                    if (teamMember != null) {
                        team.add(teamMember);
                    }
                }

                // Gather published papers
                Vector<ResearchPaper> publishedPapers = researcher.printPaper();
                researcher.proposeProject(name, team, publishedPapers);
                System.out.println("Research project proposed successfully.");
            }
        };
    }

    public MenuAction requestFunding() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Request Funding";
            }

            @Override
            public void execute() {
                System.out.println("Requesting funding...");
                double amount = Double.parseDouble(UserInput.getText("Enter the amount of funding requested:"));

                FundingRequest fundingRequest = researcher.requestFunding(amount);
                if (fundingRequest != null && fundingRequest.isApproved()) {
                    System.out.println("Funding approved: " + fundingRequest.getAmount());
                } else {
                    System.out.println("Funding request denied or not processed.");
                }
            }
        };
    }

    public MenuAction sendRequest() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Send a Request to the Rector";
            }

            @Override
            public void execute() {
                System.out.println("Sending a request to the rector...");
                String request = UserInput.getText("Enter your request:");
                researcher.sendRequest(request);
                System.out.println("Request sent successfully.");
            }
        };
    }
}
