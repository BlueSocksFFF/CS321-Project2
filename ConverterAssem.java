import java.util.Arrays;

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
        MyStack<String> stack = new MyStack<String>();
        String[] tokens = postfixExpression.split(" ");
        String[] operators = {"*", "+", "-", "/"};
        int i = 0;
        int tempNum = 1;
        while (i < tokens.length) {
            String t = tokens[i];
            if (!Arrays.asList(operators).contains(t)) {
                stack.push(t);
            } else {
                String right = stack.pop();
                String left = stack.pop();
                stack.push(evaluate(left, t, right, tempNum));
                tempNum++;
            }
            i++;
            
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static String evaluate(String l, String op, String r, int index){
        String result = "";
        result = "LD " + l + "\n";
        switch (op) {
            case "*":
                result += "ML ";
                break;
            case "+":
                result += "AD ";
                break;
            case "-":
                result += "SB ";
                break;
            case "/":
                result += "DV ";
                break;
            default:
                System.out.println("Error");
                break;
        }
        result += r + "\n";
        result += "ST " + "TMP" + Integer.toString(index);
        return result;
    }
}