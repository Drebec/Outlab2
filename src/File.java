/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;

/**
 *
 * @author Drew
 */
public class File {
    private BufferedReader in;
    private BufferedWriter out;
    
    public File(String output) {
        try {
            out = new BufferedWriter(new FileWriter("Contacts.txt"));
            out.write(output);
            out.close();
        } catch (IOException e) {
            System.out.println("There was an error");
        }
    }
    
    public File() {
        try {
            in = new BufferedReader(new FileReader("Contacts.txt"));
            while(in.ready()) {
                PhonePanel.getList().addToList(in.readLine(), in.readLine());
            }
            in.close();
        } catch (IOException e) {
            System.out.println("There was an error");
        }
    }
}
