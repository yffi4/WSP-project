package menu;

import java.util.Map;
import enums.Options;
import enums.UserType;

public class RoleBasedMenu {

    private Map<Options,Runnable> managerMenu;
    private Map<Options,Runnable> teacherMenu;
    private Map<Options,Runnable> studentMenu;
    private Map<Options,Runnable> adminMenu;
    private Map<Options,Runnable> researcherMenu;

    private Map<Options,Runnable> getManagerMenu() {
        return this.managerMenu;
    }

    private void setManagerMenu(Map<Options,Runnable> managerMenu) {
        this.managerMenu = managerMenu;
    }

    private Map<Options,Runnable> getTeacherMenu() {
        return this.teacherMenu;
    }

    private void setTeacherMenu(Map<Options,Runnable> teacherMenu) {
        this.teacherMenu = teacherMenu;
    }

    private Map<Options,Runnable> getStudentMenu() {
        return this.studentMenu;
    }

    private void setStudentMenu(Map<Options,Runnable> studentMenu) {
        this.studentMenu = studentMenu;
    }

    private Map<Options,Runnable> getAdminMenu() {
        return this.adminMenu;
    }

    private void setAdminMenu(Map<Options,Runnable> adminMenu) {
        this.adminMenu = adminMenu;
    }

    private Map<Options,Runnable> getResearcherMenu() {
        return this.researcherMenu;
    }

    private void setResearcherMenu(Map<Options,Runnable> researcherMenu) {
        this.researcherMenu = researcherMenu;
    }

    public void displayMenu(UserType userType) {
        // TODO: 
    }

    public void processOption(UserType userType, Integer option) {
        // TODO: 
    }

    public Map<Options,Runnable> getMenuRole() {
        // TODO: 
        return null;
    }

    public void views() {
        // TODO: 
    }
}
