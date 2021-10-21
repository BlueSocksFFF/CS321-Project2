import java.util.Arrays;
import java.util.Stack;

/**
 * Authors: Diane Zhang, Kayla Dixon
 * Project: CS321 Project 2 Assembler
 * Instructor: Prof. Al Madi
 * Increment: 3
 * Issue: 10
 */

public class ConverterAssem{
    public static void main(String[] args) {
        String postfixExpression = "AX BY C * + D4 E - /";
        Stack<String> stack = new Stack<String>();
        String[] tokens = postfixExpression.split(" ");
        String[] operators = {"*", "+", "-", "/"};
        int i = 0;
        int tempNum = 1;
        while (i < tokens.length) {
            t = tokens[i];
            if (!Arrays.asList(operators).contains(t)) {
                stack.push(t);
            } else {
                String right = stack.pop();
                String left = stack.pop();
                stack.push(evaluate(left, t, right, tempNum));
            }
            i++;
        }
        System.out.println(stack);
    }

    public String evaluate(String l, String op, String r, int index){
        String result = "";
        result = "LD " + l + "\n";
        switch (op) {
            case "*":
                result += "ML";
                break;
            case "+":
                result += "AD";
                break;
            case "-":
                result += "SB";
                break;
            case "/":
                result += "DV";
                break;
            default:
                System.out.println("Error");
                break;
        }
        result += "ST " + "TMP" + Integer.toString(index);
        return result;
    }
}