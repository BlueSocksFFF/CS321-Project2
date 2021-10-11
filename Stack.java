/**
 * Authors: Diane Zhang, Kayla Dixon
 * Project: CS321 Project 2 Assembler
 * Instructor: Prof. Al Madi
 */

public class Stack<T>{
    
    private Node firstNode;

    public Stack(){
        this.firstNode = null;
    }

    public void push(T d){
        Node newNode = new Node(d);
        if(isEmpty()){
            this.firstNode = newNode;
        }
        else{
            newNode.setNext(this.firstNode);
            this.firstNode = newNode;
        }
    }

    public T pop(){
        Node toPop = this.firstNode;
        this.firstNode = toPop.next;
        T data = (T) toPop.data;
        return data;
    }

    public T peek(){
        Node first = this.firstNode;
        return (T) first.data;
    }

    public boolean isEmpty(){
        if (this.firstNode == null) {
            return true;
        }
        return false;
    }

    public String toString(){
        String str = "";
        Node curNode = this.firstNode;
        while (curNode != null){
            str += curNode.toString();
            curNode = curNode.next;
        }
        return str;
    }

    private class Node<T>{
        T data;
        Node prev;
        Node next;

        public Node(T d){
            this.data = d;
            this.next = null;
            this.prev = null;
        }

        public void setNext(Node n){
            this.next = n;
        }

        public String toString(){
            String str = "";
            str += data.toString() + ", ";
            return str;
        }
    }

    public static void main (String [] args){


    }
}