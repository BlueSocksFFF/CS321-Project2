import java.util.Stack;

/**
 * Authors: Diane Zhang, Kayla Dixon
 * Project: CS321 Project 2 Assembler
 * Instructor: Prof. Al Madi
 */

public class Converter{

    public static void main(String[] args) {
        
        //Stack<String> s1 = new Stack<String>();
        if (args.length<1){
            System.out.println("Please add inputs");
            System.exit(0);
        }
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[0]);
        }
        /*
        int i = 0;
        String token = args[i];
        while (i < args.length-1){
            System.out.println(i);
            System.out.println(token);
            while (!token.equals(";")){
                //System.out.println("looped");
                if (token.equals(")")){
                    String right = s1.pop();
                    String oper = s1.pop();
                    String left = s1.pop();
                    s1.push(left+right+oper);
                }
                else{
                    if (!token.equals("(")){
                        s1.push(token);
                    }
                }
                i++;
                token = args[i];
            }
        }
        String result = s1.peek();
        System.out.println(result);
        */
    }
}
 