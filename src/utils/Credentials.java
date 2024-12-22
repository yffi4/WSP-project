package utils;


import enums.TeacherType;
import permissions.CanViewCourse;
import permissions.CanViewStudents;


        // TODO

import Database.Database;


import java.io.Serializable;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;


public class Credentials implements Serializable
{
    private String username;
    private String password;
    private static final long serialVersionUID = 9050061191304715588L;

    public Credentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Credentials() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String hashPassword(String s){
        int p = 31;
        int mod = 1000000007;
        long hashValue = 0;
        long pPow = 1;
        for (char c : s.toCharArray()){
            hashValue = (hashValue + (c - 'a' + 1) * pPow) % mod;
            pPow = (pPow * p) % mod;
        }
        return String.valueOf(hashValue);

    }

    public static String generateRandomPassword(){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789! @#$%^&*()-_=+";
        int length = 10;
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++){
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));

        }
        return password.toString();
    }
    public static String generateUserName(String firstName, String lastName){
        firstName = firstName.toLowerCase();
        final String LN = lastName.toLowerCase();
        String username = firstName.charAt(0) + "_" + LN + "@uniresearch.kz";
        int counter = 1;

        String finalUsername = username;
        while (Database.DATA.getUsers().keySet().stream()
                .anyMatch(n -> n.getUsername().equals(finalUsername))){
            username = firstName.charAt(0) + "_" + LN + counter + "@uniresearch.kz";
        }
        return username;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credentials that = (Credentials) o;
        return Objects.equals(username, that.username) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
