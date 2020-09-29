/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grephy;

import grephy.Regex.*;

/**
 *
 * @author reynaldoalvarez
 */
public class RegexToNFA {
    public int currentState, nextState;
    public char transitionSymbol;
    public TestCase regex;
    
    //public RegexToNFA() {}
    
    public RegexToNFA(int currentState, int nextState, char transitionSymbol) {
        this.currentState = currentState;
        this.nextState = nextState;
        this.transitionSymbol = transitionSymbol;
    }
    
    public RegexToNFA(String regex) {
        
        for(int i = 0; i < regex.length(); i++) {
            transitionSymbol = regex.charAt(i);
            System.out.println(transitionSymbol);
        }  
    }
}
