/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author Drew
 */
public class LinkedList {

    private int size;
    private Node head;

    public LinkedList() {

    }

    public void addToList(String value, String number) {
        Node current = head;
        Node temp = head;
        Node newNode = new Node(value, null);

        if (size < 1) {
            head = newNode;
            newNode.setNumber(number);
        } else if (value.compareToIgnoreCase(head.getName()) <= 0) {
            newNode.setNext(head);
            head = newNode;
            newNode.setNumber(number);
        } else {
            while (current != null && value.compareToIgnoreCase(current.getName()) > 0) {
                temp = current;
                current = current.getNext();
            }
            temp.setNext(newNode);
            newNode.setNext(current);
            newNode.setNumber(number);
        }
        size++;
    }

    public Node removeFromList(String value) {
        Node current = head;
        Node temp = head;

        if (head != null && head.getName().equalsIgnoreCase(value)) {
            head = head.getNext();
            size--;
            return current;
        } else if (size > 0) {
            while (current != null && !current.getName().equalsIgnoreCase(value)) {
                temp = current;
                current = current.getNext();
            }
            if(current != null) {
                temp.setNext(current.getNext());
                size--;
                return current;
            }
        }
        return null;
    }

    public Node search(String value) {
        Node current = head;
        if (size > 0) {
            while (current != null && !current.getName().equalsIgnoreCase(value)) {
                current = current.getNext();
            }
            return current;
        }
        return null;
    }

    public String printAllContacts() {
        Node current = head;
        String output = "";

        while (current != null) {
            output += (current.getName() + ": " + current.getNumber() + "\n");
            current = current.getNext();
        }
        return output;
    }
    
    public String printToFile() {
        Node current = head;
        String output = "";

        while (current != null) {
            output += (current.getName() + "\n" + current.getNumber() + "\n");
            current = current.getNext();
        }
        return output;
    }
}
