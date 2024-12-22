package office;

import java.util.Vector;

import users.Dean;
import users.Manager;

public class DeanOffice extends Dean {
    private Dean dean;
    private Vector<Manager> managers;

    private Dean getDean() {
        return this.dean;
    }

    private void setDean(Dean dean) {
        this.dean = dean;
    }

    private Vector<Manager> getManagers() {
        return this.managers;
    }

    private void setManagers(Vector<Manager> managers) {
        this.managers = managers;
    }
}
