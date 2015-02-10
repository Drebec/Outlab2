/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Drew
 */
public class Node {
    private String name;
    private String number;
    private Node next;
    
    public Node(String name, Node next) {
        this.name = name;
        this.next = next;
    }
    
    public String getName() {
        return name;
    }
    
    public Node getNext() { 
        return next;
    }
    
    public String getNumber() {
        return number;
    }
    
    public void setNext(Node next) {
        this.next = next;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }
}
