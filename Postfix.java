/**
 * Authors: Diane Zhang, Kayla Dixon
 * Project: CS321 Project 2 Assembler
 * Instructor: Prof. Al Madi
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Postfix{

    //A constructor for Postfix class
    public Postfix (){
        Stack<String> s = new Stack<String>();
    }

    //A method for reading in a file with a list of infix expressions
    //Needed a way to make different arraylists
    public void read (String filename){
        try{
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            int i = 0;
            while (!(line==null)){
                String[]words = line.split(" ");
                ArrayList<String> a = new ArrayList<String>();
                for (int i=0; i<words.length; i++){
                    a.add(words[i]);
                }
                line = bufferedReader.readLine();
                i++;
            }
            bufferedReader.close();
            return;
        }
        catch (FileNotFoundException ex){
            System.out.println("File.read():: unable to open file" + filename);
            return;
        }
        catch (IOException ex){
            System.out.println("File.read():: unable to open file" + filename);
            return;
        }
    }

    //A method for writing a file with a list of postfix expressions
    public void write (){
        return;
    }

}