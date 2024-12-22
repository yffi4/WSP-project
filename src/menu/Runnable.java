package menu;

import exeptions.InvalidManagerTypeException;
import users.User;

import java.io.IOException;

public interface Runnable {
    void runMenu(User user) throws IOException, InvalidManagerTypeException;
}
