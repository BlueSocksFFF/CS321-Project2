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
            //System.out.println("Iteration "+ i);
            //System.out.println(stack);

        }
        if (stack.isEmpty()) {
            System.out.println("Error");
        }
    }

    public static String evaluate(String l, String op, String r, int index){
        String str = "LD " + l;
        System.out.println(str);
        switch (op) {
            case "*":
                str = "ML ";
                break;
            case "+":
                str = "AD ";
                break;
            case "-":
                str = "SB ";
                break;
            case "/":
                str = "DV ";
                break;
            default:
                System.out.println("Error");
                System.exit(0);
        }
        str += r;
        System.out.println(str);
        str= "ST " + "TMP" + Integer.toString(index);
        System.out.println(str);
        return("TMP" + Integer.toString(index));
    }
}