package office;

import java.util.Vector;

import users.Manager;

public class OR {
    private Vector<Manager> managers;

    private Vector<Manager> getManagers() {
        return this.managers;
    }

    private void setManagers(Vector<Manager> managers) {
        this.managers = managers;
    }
}
