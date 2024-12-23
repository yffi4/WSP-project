package users;

import journal.Journal;
import papers.ResearchPaper;

import java.util.Vector;
import papers.ResearchPaper;
import utils.FundingRequest;

import java.util.Comparator;

public interface CanResearch {
	
	Vector<ResearchPaper> printPaper();
    int calculateIndex();
    void publishPaper(String title, Vector<Researcher> authors, Vector<String> papers, Journal journal);
    void proposeProject(String name, Vector<Researcher> team, Vector<ResearchPaper> description);
    FundingRequest requestFunding(double amount);
}
