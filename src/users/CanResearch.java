package users;

import java.util.Vector;
import papers.ResearchPaper;
import utils.FundingRequest;

import java.util.Comparator;

public interface CanResearch {
	
	Vector<ResearchPaper> printPaper(Comparator<ResearchPaper> comparator);
    int calculateIndex();
    void publishPaper(String title, Vector<Researcher> authors, Vector<String> keywords);
    void proposeProject(String name, Vector<Researcher> team, Vector<String> description);
    FundingRequest requestFunding(double amount);
}
