/**
 * Authors: Diane Zhang, Kayla Dixon
 * Project: CS321 Project 2 Assembler
 * Instructor: Prof. Al Madi
 * Increment: 3
 * Issue: 10
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.FileWriter;

public class Assembler{

    public static void main (String[] args){
        try{
            if (args.length != 2) {
                System.out.println("Enter input file and output filename");
                System.exit(0);
            }
            FileWriter writer = new FileWriter(args[1]);
            FileReader fileReader = new FileReader(args[0]);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (!(line==null)){
                //reading and printing the infix expression
                System.out.println ("Infix Expression: " + line);
                //System.out.println(args.length);
                writer.write("Infix Expression: " + line + '\n');
                
                //taking infix expression, converting it to postfix expression, and printing postfix expression
                String[] tokens = line.split(" ");
                String token;
                MyStack<String> stack = new MyStack<String>();
                int i = 0;
                token = tokens[i];
                while (!token.equals(";")){
                    if (token.equals(")")){
                        String right = (String)stack.pop();
                        String oper = (String)stack.pop();
                        String left = (String)stack.pop();
                        stack.push(left+" "+right+" "+oper);
                    }
                    else{
                        if (!token.equals("(")){
                            stack.push(token);
                        }
                    }
                    i++;
                    token = tokens[i];
                }
                String postfixExpression = (String)stack.pop();
                System.out.println("Postfix Expression: " + postfixExpression);
                writer.write("Postfix Expression: " + postfixExpression + '\n');
                
                //taking postfix expression, converting to assembly, and printing assembly
                MyStack<String> stack2 = new MyStack<String>();
                String[] tokens2 = postfixExpression.split(" ");
                String[] operators = {"*", "+", "-", "/"};
                String t;
                i = 0;
                int tempNum = 1;
                while (i < tokens2.length) {
                    t = tokens2[i];
                    if (!Arrays.asList(operators).contains(t)) {
                        stack2.push(t);  
                    } else {
                        String right = stack2.pop();
                        String left = stack2.pop();
                        String str = "LD " + left;
                        System.out.println(str);
                        writer.write(str + '\n');
                        switch (t) {
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
                        }
                        str += right;
                        System.out.println(str);
                        writer.write(str + '\n');
                        str= "ST " + "TMP" + Integer.toString(tempNum);
                        System.out.println(str);
                        writer.write(str + '\n');
                        stack2.push("TMP" + Integer.toString(tempNum));
                        tempNum++;
                    }
                    i++;
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            writer.close();
            return;
        }
        catch (FileNotFoundException ex){
            System.out.println("File.read():: unable to open file" + args[0]);
            return;
        }
        catch (IOException ex){
            System.out.println("File.read():: unable to open file" + args[0]);
            return;
        }
    }
}