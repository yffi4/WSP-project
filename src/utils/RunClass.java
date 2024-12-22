package utils;

import Database.Database;
import users.Admin;

import java.io.IOException;

public class RunClass {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        new Wsp().run();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Perform cleanup or any necessary actions
            try {
                Database.write();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Shutdown hook executed");
        }));


    }
}
