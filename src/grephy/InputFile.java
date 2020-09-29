/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template input, choose Tools | Templates
 * and open the template in the editor.
 */

package grephy;

import java.io.*;

/**
 *
 * @author reynaldoalvarez
 */
public class InputFile {
    private String input;
    private int charCount = 0;

    public int getCharCount() {
        return charCount;
    }
    
    
    public void InputFile() {}
    
    public String Input() {
        try (BufferedReader buffReader = new BufferedReader(new FileReader("InputFile.txt"))) { // Create the bufferedReader and take in an txt input
            while(buffReader.ready()) { // While there is still input left
                input = buffReader.readLine();
            }
        } catch(IOException e) {
            System.out.println("Could not read file.");
        }
        for(int i = 0; i < input.length(); i++) {
            charCount++;
        }
        return input;
    }
    
}
