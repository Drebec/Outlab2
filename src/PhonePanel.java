/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Drew
 */
public class PhonePanel extends JPanel{
    private static LinkedList list;    
    private JTextField stringField;
    private JTextField numberField;
    JTextArea textArea;
    
    public PhonePanel() {
        
        list = new LinkedList();
        setPreferredSize(new Dimension(260, 130));
        setLayout(new GridLayout(2, 1));       
        
        JPanel fieldPanel = new JPanel();
        stringField = new JTextField(16);
        JLabel nameLabel = new JLabel("Name: ");
        fieldPanel.setLayout(new BorderLayout());
        fieldPanel.add(nameLabel, BorderLayout.WEST);
        fieldPanel.add(stringField, BorderLayout.CENTER);
        
        JPanel numberPanel = new JPanel();
        numberField = new JTextField(16);
        JLabel numLabel = new JLabel("Number: ");
        numberPanel.setLayout(new BorderLayout());
        numberPanel.add(numLabel, BorderLayout.WEST);
        numberPanel.add(numberField, BorderLayout.CENTER);
        
        textArea = new JTextArea("\n");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setBorder(BorderFactory.createLineBorder(Color.black));
        
        JButton addContact = new JButton("Add Contact");
        addContact.addActionListener(new AddContact());
        JButton remove = new JButton("Remove Contact");
        remove.addActionListener(new RemoveContact());
        JButton search = new JButton("Search");
        search.addActionListener(new Search());
        JButton display = new JButton("Display");
        display.addActionListener(new PrintAllContacts());
        
        JPanel topPane = new JPanel(new GridLayout(3, 1));
        topPane.add(textArea);
        topPane.add(fieldPanel);
        topPane.add(numberPanel);
        JPanel bottomPane = new JPanel(new GridLayout(2, 2));
        bottomPane.add(addContact);
        bottomPane.add(remove);
        bottomPane.add(search);
        bottomPane.add(display);
        
        
        add(topPane);
        add(bottomPane);       
    }
    
    public static LinkedList getList() {
        return list;
    }
    
    private class PrintAllContacts implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        JDialog popup = new JDialog();
        JTextArea popText = new JTextArea(list.printAllContacts());
        popText.setLineWrap(false);
        popText.setWrapStyleWord(true);
        popText.setEditable(false);
        popText.setBorder(BorderFactory.createLineBorder(Color.black));
        popup.add(popText);
        popup.pack();
        popup.setLocationRelativeTo(null);
        popup.setVisible(true);
        }
        
    }
    
    private class AddContact implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String value = stringField.getText();
            String number = numberField.getText();
            list.addToList(value, number);  
            textArea.setText("Contact Added: " + value + ", " + number);
        }
    }
    
    private class RemoveContact implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Node removed = list.removeFromList(stringField.getText());
            if(removed != null) {
                textArea.setText("Contact Removed: " + removed.getName() + ", " + removed.getNumber());
            } else {
                textArea.setText("That person is not in your contact list");
            }
        }
    }
    
    private class Search implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Node searched = list.search(stringField.getText());
            if(searched != null) {
                textArea.setText("Contact Informaton: " + searched.getName() + ", " + searched.getNumber());
            } else {
                textArea.setText("That person is not in your contact list");
            }
        }
    }
}
