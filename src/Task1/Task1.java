package Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1 {
    public static int matchBrackets(String brackets) { // method that return number of pair
        int open = 0; // for count open brackets
        int count = 0; // counter of pair
        for (int i = 0; i < brackets.length(); i++) {
            if (brackets.charAt(i) == '(') {
                open++;
            } else if (brackets.charAt(i) == ')') {
                open--;
                if (open >= 0) {
                    count++;
                } else {
                    open++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Please input some parentheses");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String brackets = reader.readLine();
        System.out.println("Number of pair of parentheses: " + matchBrackets(brackets));
    }
}
