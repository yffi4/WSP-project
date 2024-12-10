package utils;

import Database.Database;


import java.util.Random;
import java.util.stream.Collectors;


public class Credentials {
    private String username;
    private String password;

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
        String password = "";
        for (int i = 0; i < length; i++){
            int index = random.nextInt(characters.length());
            password += characters.charAt(index);

        }
        return password;
    }
    public static String generateUserName(String firstName, String lastName){
        firstName = firstName.toLowerCase();
        final String LN = lastName.toLowerCase();
        String[] username = {""};
        username[0] += firstName.charAt(0);
        int i = 1, j = 1;
        while (Database.DATA.getUsers().keySet().stream()
                .map(n -> n.getUsername())
                .filter(n -> n.equals(username[0] + "_" + LN + "@uniresearch.kz"))
                .collect(Collectors.toSet()).size() != 0){
            if (i >= firstName.length()){
                username[0] = firstName.substring(0, Math.min(i, firstName.length())) + j;
                j++;
                continue;
            }
            username[0] += firstName.charAt(i);
            i++;
        }
        return username[0] + "_" + LN + "@uniresearch.kz";
    }
}
