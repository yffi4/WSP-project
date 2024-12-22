package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class UserInput {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String getText(String prompt) {
        try {
            System.out.println(prompt);
            return reader.readLine();
        } catch (Exception e) {
            throw new RuntimeException("Failed to read input", e);
        }
    }

    public static boolean confirmAction(String prompt) {
        String response = getText(prompt + " (y/n)").toLowerCase();
        return response.startsWith("y");
    }

    public static void handleUserInput(String prompt, Consumer<String> handler) {
        try {
            String input = getText(prompt);
            handler.accept(input);
        } catch (Exception e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }
}
