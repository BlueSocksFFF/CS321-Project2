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
        if(isEmpty()){
            Node newNode = new Node(d);
            this.firstNode = newNode;
        }
        else{
           Node current = this.firstNode;
            while (current.next != null) {
                current = current.next;
            }
            current.addNext(d); 
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

        public void addNext(T d){
            Node nexNode = new Node(d);
            this.next = nexNode;
            nexNode.prev = this;
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