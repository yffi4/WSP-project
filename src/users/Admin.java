package users;

import java.util.Vector;

public class Admin extends Employee implements CanSendRequests, CanBecomeResearcher {
    private Vector<String> userLogs;

    private Vector<String> getUserLogs() {
        return this.userLogs;
    }

    private void setUserLogs(Vector<String> userLogs) {
        this.userLogs = userLogs;
    }

    public void addUser() {
        // TODO
    }

    public boolean removeUser() {
        // TODO
        return false;
    }

    public boolean updateUser() {
        // TODO
        return false;
    }

    public String viewLogs() {
        // TODO
        return "";
    }

    @Override
    public void sendRequest(String request) {
        // TODO
    }

    @Override
    public void becomeResearcher() {
        // TODO
    }
}
