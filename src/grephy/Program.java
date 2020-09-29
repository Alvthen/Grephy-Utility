/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grephy;

import java.io.*;

/**
 *
 * @author reynaldoalvarez
 */
public class Program {
    public Program() {}
    
    public void StartProgram() throws IOException {        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int helpCount = 0;
        String regexSelected;
        
        WelcomeGrephy(); // Displays the welcome sign
        String input = in.readLine();
        while(input != null) {
            
            // Ending the program
            if(input.toLowerCase().contains("exit") || input.toLowerCase().contains("quit") || 
                input.toLowerCase().contains("end") || input.toLowerCase().contains("done")) {
                break;
                
            } else if(input.toLowerCase().contains("help")) {
                if(helpCount > 0) {
                    input = in.readLine();
                    if(input.toLowerCase().contains("exit") || input.toLowerCase().contains("quit") || 
                        input.toLowerCase().contains("end") || input.toLowerCase().contains("done")) { // Ending the program
                        break;
                        
                    } else if(input.toLowerCase().contains("info")) { // Info about the program
                        DisplayInfo();
                        input = "help";
                        
                    } else if(input.toLowerCase().contains("rules")) { // Instructions on how to use program
                        DisplayRules();
                        input = "help";
                        
                    } else if(input.toLowerCase().contains("examples")) { // List of regex test cases
                        DisplayExamples();
                        input = "help";
                        
                    } else if(input.toLowerCase().contains("home")) { // Return to welcome screen
                        helpCount--;
                        WelcomeGrephy();
                        input = in.readLine();
                        
                    } else { // Error message incorrect input
                        HelpErrorMessage(); // Calls the error message for the help menu
                        input = "help";
                    }
                } else {
                    helpCount++;
                    HelpMenu(); // Displays Help menu sign
                    input = in.readLine();
                    if(input.toLowerCase().contains("exit") || input.toLowerCase().contains("quit") || 
                        input.toLowerCase().contains("end") || input.toLowerCase().contains("done")) { // Ending the program
                        break;
                        
                    } else if(input.toLowerCase().contains("info")) { // Info about the program
                        DisplayInfo();
                        input = "help";
                        
                    } else if(input.toLowerCase().contains("rules")) { // Instructions on how to use program
                        DisplayRules();
                        input = "help";
                        
                    } else if(input.toLowerCase().contains("examples")) { // List of regex test cases
                        DisplayExamples();
                        input = "help";
                        
                    } else if(input.toLowerCase().contains("home")) { // Return to welcome screen
                        helpCount--;
                        WelcomeGrephy();
                        input = in.readLine();
                        
                    } else { // Error message incorrect input
                        HelpErrorMessage(); // Calls the error message for the help menu
                        input = "help";
                    }
                }
            } else if(input.toLowerCase().contains("1")) {
                System.out.println("\nYou selected Regex: (a+b)*\n");
                ConvertOrOutput();
                input = in.readLine();
                if(input.toLowerCase().contains("exit") || input.toLowerCase().contains("quit") || 
                    input.toLowerCase().contains("end") || input.toLowerCase().contains("done")) { // Ending the program
                    break;
                } else if(input.toLowerCase().contains("convert")) { // Info about the program
                    regexSelected = "(a+b)*";
                    RegexToNFA convert = new RegexToNFA(regexSelected);                    
                } else if(input.toLowerCase().contains("output")) { // Instructions on how to use program
                    Regex output = new Regex();
                    WelcomeGrephy();
                    input = in.readLine();
                } else if(input.toLowerCase().contains("home")) { // Return to welcome screen
                    WelcomeGrephy();
                    input = in.readLine();
                } else { // Error message incorrect input
                    InvalidCommand();
                    input = "1";
                }
            } else {
                MainErrorMessage(); // Displays error message for the main screen
                input = in.readLine();
            }
        }
    }
    
    
    /**
     * Provides the error message when in the help screen
     * Gives commands for the users
     * They provide descriptions with information about the commands
     */
    private void HelpErrorMessage() {
        System.out.println("\n-----------------------------------\n"
                    + "~~~~~~~~~~~[HELP MENU]~~~~~~~~~~~~~\n"
                    + "-----------------------------------\n"
                + "Invalid \"help\" command entered.\n\n"
                + "List of commands:\n"
                + "info      : Gives information about Grephy.\n"
                + "rules     : Instructions on how to use Grephy.\n"
                + "examples  : Contains sample Regex Test Cases.\n"
                + "home      : Return to the Welcome screen\n\n"
                + "Enter a command to continue...");
    }
    
    
    /**
     * Provides the error message when in the help screen
     * Gives commands for the users
     * They provide descriptions with information about the commands
     */
    private void MainErrorMessage() {
        System.out.println("\n-----------------------------------\n" 
                + "~~~~~~~~~[ERROR DETECTED]~~~~~~~~~~\n"
                + "-----------------------------------\n"
                + "Invalid command typed.\n\n"
                + "List of commands:\n"
                + "1                          : (a+b)*\n"
                + "help                       : Takes you to the help menu\n"
                + "exit | end | quit | done   : Ends the program\n\n"
                + "Enter a command to continue...");
    }
    
    /**
     * Main screen. First Thing users see
     */
    private void WelcomeGrephy() {
        System.out.println("\n-----------------------------------\n"
                + "~~~~~~~~WELCOME TO GREPHY!~~~~~~~~~\n"
                + "-----------------------------------\n"
                + "Enter a command to begin:"); // Introduction
    }
    
    
    /**
     * Help menu screen
     */
    private void HelpMenu() {
        System.out.println("\n-----------------------------------\n"
                + "~~~~~~~~~~~[HELP MENU]~~~~~~~~~~~~~\n"
                + "-----------------------------------\n"
                + "Enter a \"help\" command:");
    }
    
    
    /**
     * Help menu screen
     */
    private void DisplayInfo() {
        System.out.println("\n-----------------------------------\n"
                + "~~~~~~~~~~[Grephy Info]~~~~~~~~~~~~\n"
                + "-----------------------------------\n"
                + "Grephy is a version of the grep utility.\n"
                + "This program searches files for regular expression pattern matches and produces dot graph file\n" 
                + "output for the automata used in the matching computation.\n\n"
                + "Grephy allows the user to decide wether they would like to convert their Regex into an NFA"
                + "or their NFA into a DFA, before they begin the match process read from the input file.\n\n"
                + "Enter \"home\" to exit the Help Menu.");
    }
    
    
    /**
     * Help menu screen
     */
    private void DisplayRules() {
        System.out.println("\n-----------------------------------\n"
                + "~~~~~~~~~~[Grephy Rules]~~~~~~~~~~~\n"
                + "-----------------------------------\n"
                + "Info not yet available...\n\n"
                + "Enter \"home\" to exit the Help Menu.");
    }
    
    /**
     * Help menu screen
     */
    private void DisplayExamples() {
        System.out.println("\n-----------------------------------\n"
                + "~~~~~~~~~~[Grephy Cases]~~~~~~~~~~~\n"
                + "-----------------------------------\n"
                + "Info not yet available...\n\n"
                + "Enter \"home\" to exit the Help Menu.");
    }
    
    
    /**
     * Main screen. First Thing users see
     */
    private void ConvertOrOutput() {
        System.out.println("List of commands:\n"
                + "convert  : Execute a Regex to NFA conversion\n"
                + "output   : Display the results\n"
                + "home     : Return to the Welcome screen\n"
                + "exit | end | quit | done   : Ends the program.\n\n" 
                + "Enter a command to continue...");
    }
    
    /**
     * User enters wrong command
     */
    private void InvalidCommand() {
        System.out.println("Invalid command entered. Please try again.\n");
    }
    
}
