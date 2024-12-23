package menu.actions;
import users.Dean;
import users.Employee;
import utils.Complaint;
import utils.Proposal;
import utils.Request;
import utils.UserInput;

import java.util.Vector;

public class DeanActors extends EmployeeActions{
    private final Dean dean;



    public DeanActors( Dean dean) {
        super(dean);
        this.dean = dean;
    }


    public MenuAction viewRequests() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "View Requests";
            }

            @Override
            public void execute() {
                Vector<Request> requests = dean.viewRequests();
                if (requests.isEmpty()) {
                    System.out.println("No requests available");
                    return;
                }

                System.out.println("\nPending Requests:");
                for (int i = 0; i < requests.size(); i++) {
                    System.out.printf("%d. %s%n", i + 1, requests.get(i).getContent());
                }
            }
        };
    }

    public MenuAction signRequest() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Sign Request";
            }

            @Override
            public void execute() throws Exception {
                Vector<Request> requests = dean.getRequests();
                if (requests.isEmpty()) {
                    System.out.println("No requests available");
                    return;
                }

                System.out.println("\nPending Requests:");
                for (int i = 0; i < requests.size(); i++) {
                    System.out.printf("%d. %s%n", i + 1, requests.get(i).getContent());
                }

                int requestIndex = Integer.parseInt(UserInput.getText("Select request to sign (0 to cancel):")) - 1;
                if (requestIndex == -1) return;

                if (requestIndex >= 0 && requestIndex < requests.size()) {
                    Request selectedRequest = requests.get(requestIndex);
                    dean.SignRequest(selectedRequest);
                    System.out.println("Request signed successfully");
                } else {
                    System.out.println("Invalid request selection");
                }
            }
        };
    }

    public MenuAction rejectRequest() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Reject Request";
            }

            @Override
            public void execute() throws Exception {
                Vector<Request> requests = dean.getRequests();
                if (requests.isEmpty()) {
                    System.out.println("No requests available");
                    return;
                }

                System.out.println("\nPending Requests:");
                for (int i = 0; i < requests.size(); i++) {
                    System.out.printf("%d. %s%n", i + 1, requests.get(i).getContent());
                }

                int requestIndex = Integer.parseInt(UserInput.getText("Select request to reject (0 to cancel):")) - 1;
                if (requestIndex == -1) return;

                if (requestIndex >= 0 && requestIndex < requests.size()) {
                    Request selectedRequest = requests.get(requestIndex);
                    dean.rejectRequest(selectedRequest);
                    System.out.println("Request rejected successfully");
                } else {
                    System.out.println("Invalid request selection");
                }
            }
        };
    }

    public MenuAction verifyProposal() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Verify Proposal";
            }

            @Override
            public void execute() throws Exception {
                Vector<Proposal> proposals = dean.getProposals();
                if (proposals.isEmpty()) {
                    System.out.println("No proposals available");
                    return;
                }

                System.out.println("\nPending Proposals:");
                for (int i = 0; i < proposals.size(); i++) {
                    Proposal proposal = proposals.get(i);
                    System.out.printf("%d. Title: %s%n", i + 1, proposal.getTitle());
                }

                int proposalIndex = Integer.parseInt(UserInput.getText("Select proposal to verify (0 to cancel):")) - 1;
                if (proposalIndex == -1) return;

                if (proposalIndex >= 0 && proposalIndex < proposals.size()) {
                    Proposal selectedProposal = proposals.get(proposalIndex);
                    boolean verified = dean.verifyProposal(selectedProposal);
                    if (verified) {
                        System.out.println("Proposal verified and approved successfully");
                    } else {
                        System.out.println("Proposal verification failed - requirements not met");
                    }
                } else {
                    System.out.println("Invalid proposal selection");
                }
            }
        };
    }

    public MenuAction viewComplaints() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "View Complaints";
            }

            @Override
            public void execute() {
                Vector<Complaint> complaints = dean.viewComplaint();
                if (complaints.isEmpty()) {
                    System.out.println("No complaints available");
                    return;
                }

                System.out.println("\nComplaints (sorted):");
                for (int i = 0; i < complaints.size(); i++) {
                    System.out.printf("%d. %s%n", i + 1, complaints.get(i));
                }
            }
        };
    }
}
