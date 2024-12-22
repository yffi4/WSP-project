package utils;

import Database.Database;
import enums.Language;
import enums.UserType;

import users.Admin;
import users.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Date;

public class Wsp  {

    private Language language = Language.EN;
    private User loggedUser;

    public Wsp() {
    }

    public void save() throws IOException {
        Database.write();
    }

    public  void addSuperAdmin() {
        try {
            if (Database.DATA.getUsers().isEmpty()) { // Проверяем, пустая ли база данных
                Credentials adminCredentials = new Credentials("admin", "12345");
                Admin superAdmin = new Admin("Ilya", "Kuleshov");

                Database.DATA.getUsers().put(adminCredentials, superAdmin); // Добавляем супер-админа
                System.out.println("Super admin added to the system.");

                Database.write(); // Сохраняем данные в файл
                System.out.println("Database updated with super admin.");
            }
        } catch (Exception e) {
            System.err.println("Failed to add super admin: " + e.getMessage());
        }
    }
    public void run() throws IOException, ClassNotFoundException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Database.read();
        try {

            while (true) {
                System.out.println("\uD83C\uDF93 Welcome to the UniResearch Hub \uD83C\uDF93");

                System.out.println("Please enter your username: ");
                String username = br.readLine();


                System.out.println("Please enter your temporary password: ");
                String tempPassword = br.readLine();

                Credentials tempCred = new Credentials(username, tempPassword);
                if (Database.DATA.getUsers().containsKey(new Credentials(username, tempPassword))) {

                    loggedUser = Database.DATA.getUsers().get(new Credentials(username, tempPassword));
                    System.out.println("You've logged succesfully");
                    Database.DATA.getLogs().add(loggedUser + " logged into system at " + new Date());
                    loggedUser.run();
                } else {
                    System.out.println("Incorrect username of password. Please, try again.");
                }
            }
        }catch (Exception e){
            System.out.println("Wrong");
            System.out.println(e.getMessage());
            save();
        }
    }






}

