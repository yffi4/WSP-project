package menu.actions;

import users.User;

public interface MenuAction {
    String getDescription();
    public void execute() throws Exception;
}
