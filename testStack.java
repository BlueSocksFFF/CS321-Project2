/**
 * Authors: Diane Zhang, Kayla Dixon
 * Project: CS321 Project 2 Assembler
 * Instructor: Prof. Al Madi
 */
 

 public class testStack{

    public static void main (String [] args){

        Stack s1 = new Stack();
        s1.push("Hello");
        System.out.println(s1);
        s1.push(5);
        s1.push(7.2);
        System.out.println(s1.peek()); //7.2
        System.out.println(s1.pop()); //7.2
        System.out.println(s1.peek()); //5

    }
 }