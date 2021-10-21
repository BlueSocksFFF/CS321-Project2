/**
 * Authors: Diane Zhang, Kayla Dixon
 * Project: CS321 Project 2 Assembler
 * Instructor: Prof. Al Madi
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import java.io.FileWriter;

public class Postfix{

    private MyStack stack;
    private String[] tokens;
    private String filename;

    //A constructor for Postfix class
    public Postfix (String filename){
        this.stack = new MyStack<String>();
        this.filename = filename;
    }

    //Test method for getting the tokens read
    public String[] getTokens(){
        return this.tokens;
    }

    //A method for reading in a file with a list of infix expressions
    //Not in use now -- could be deleted when the file is complete
    public void read(){
        try{
            FileReader fileReader = new FileReader(this.filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (!(line==null)){
                this.tokens = line.split(" ");
            }
            bufferedReader.close();
            return;
        }
        catch (FileNotFoundException ex){
            System.out.println("File.read():: unable to open file" + this.filename);
            return;
        }
        catch (IOException ex){
            System.out.println("File.read():: unable to open file" + this.filename);
            return;
        }
    }

    //A method for writing a file with a list of postfix expressions
    public void write (String filename){
        Stack<String> writeStack = new Stack<String>();
        while (!this.stack.isEmpty()) {
            writeStack.push((String)this.stack.pop());  
        }
        try {
            FileWriter writer = new FileWriter(filename);
            while (!writeStack.isEmpty()) {
                writer.write((String)writeStack.pop() + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    //Convert Infix tokens to Postfixes and store them in the stack
    public void convert(){
        String token;
        int i = 0;
        token = this.tokens[i];
        while (!token.equals(";")){
            if (token.equals(")")){
                String right = (String)this.stack.pop();
                String oper = (String)this.stack.pop();
                String left = (String)this.stack.pop();
                this.stack.push(left+right+oper);
            }
            else{
                if (!token.equals("(")){
                    this.stack.push(token);
                }
            }
            i++;
            token = this.tokens[i];
        }
    }

    //The test function to print the stack
    public void printStack(){
        MyStack<String> bufferStack = new MyStack<String>();
        String bufferString;
        while (!this.stack.isEmpty()) {
            bufferString =  (String)this.stack.pop();
            System.out.print(bufferString + ", ");
            bufferStack.push(bufferString);
        }
        this.stack = bufferStack;
        
    }

    //The overall process of read-process
    public void process(){
        try{
            FileReader fileReader = new FileReader(this.filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (!(line==null)){
                this.tokens = line.split(" ");
                convert();
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            return;
        }
        catch (FileNotFoundException ex){
            System.out.println("File.read():: unable to open file" + this.filename);
            return;
        }
        catch (IOException ex){
            System.out.println("File.read():: unable to open file" + this.filename);
            return;
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please enter infix file and the output result file name");
            System.exit(0);
        }
        Postfix postfix = new Postfix(args[0]);
        postfix.process();
        postfix.write(args[1]);
        /*
        //Test Read
        postfix.read("Infixes.txt");
        System.out.println(postfix.getTokens());
        //Test Convert
        postfix.convert();
        postfix.printStack();
        
        //Test process
        postfix.process();
        postfix.printStack();
        postfix.write();
        */
    }

}