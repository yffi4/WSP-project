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

    @Override
    public void sendRequest(String request) {
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
}
