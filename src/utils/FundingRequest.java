package utils;

import users.Researcher;

public class FundingRequest {
    private double amount;
    private Researcher researcher;

    public FundingRequest(double amount, Researcher researcher) {
        this.amount = amount;
        this.researcher = researcher;
    }

    public void setApproved(boolean b) {
    }

    public int getAmount() {
        return 0;
    }

    public String getDescription() {
        return "";
    }

    public boolean isApproved() {
        return true;
    }
}
