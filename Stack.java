/**
 * Authors: Diane Zhang, Kayla Dixon
 * Project: CS321 Project 2 Assembler
 * Instructor: Prof. Al Madi
 */

public class Stack{
    
    private Node firstNode;

    public Stack(){
        this.firstNode = null;
    }

    public void push(T d){
        Node current = this.firstNode;
        while (current.next != null) {
            current = current.next;
        }
        current.addNext(d);
    }

    public T pop(){
        Node toPop = this.firstNode;
        this.firstNode = toPop.next;
        T data = toPop.data;
        return data;
    }

    public T peek(){
        Node first = this.firstNode;
        return first.data;
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
        while (curNode.next != null){
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

        public Node(T d, Node p){
            this.data = d;
            this.next = null;
            this.prev = p;
        }

        public void addNext(T d){
            Node nexNode = new Node(d, p);
            this.next = nexNode;
        }

        public String toString(){
            String str = "";
            str += data.toString() + ", ";
            return str;
        }
    }
}