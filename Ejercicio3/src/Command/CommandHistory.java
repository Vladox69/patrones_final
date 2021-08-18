/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.util.Stack;

/**
 *
 * @author ASUS
 */
class CommandHistory {
    private Stack<Command> history =new Stack<Command>();
    
    public void push(Command c){
        history.push(c);
    }
    
    public Command pop(){
        return history.pop();
    }
    
    public boolean isEmpty(){
        return history.isEmpty();
    }
    
}
