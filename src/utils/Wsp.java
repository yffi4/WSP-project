package utils;


import Database.Database;
import enums.Language;
import enums.UserType;
import menu.RoleBasedMenu;
import users.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class Wsp {

    private Language language = Language.EN;

    private User loggedUser;
    public Wsp(){

    }

    public void save() throws IOException {
        Database.write();
    }

    public void run() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input;
        String str1, str2;
        try{
            login :while (true){
                System.out.println("\uD83C\uDF93Welcome to best university system - UniResearch Hub\uD83C\uDF93");
                System.out.println("Please enter your username: ");
                str1 = br.readLine();
                System.out.println("Please enter your password: ");
                str2 = br.readLine();
                if (Database.DATA.getUsers().containsKey(new Credentials(str1, str2))){
                    loggedUser = Database.DATA.getUsers().get(new Credentials(str1, str2));
                    System.out.println("You've logged succesfully!");
                    Database.DATA.getLogs().add(loggedUser + "logged into system at " + new Date());

                    RoleBasedMenu menu = new RoleBasedMenu();
                    menu.run(loggedUser);
                    break;
                }else System.out.println("Invalid credentials. Try again!");
            }
        }catch (Exception e){
            System.out.println("Oops...");
            System.out.println(e.getMessage());
            save();
        }
    }
    public static void main(String[] args) throws IOException{
        new Wsp().run();
    }
}
