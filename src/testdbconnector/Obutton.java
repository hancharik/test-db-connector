/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdbconnector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;



public class Obutton extends JButton{
   
   // private int number;
   // private ArrayList<String> solarSystemArray  = new ArrayList<String>();
    private int A;
    private int B;
    
    
    /*
    public Obutton(String text, ArrayList<String> ss, int num){
        
        this.setText(text);
        this.solarSystemArray = ss;
        this.number = num;
    }
    
    public Obutton(int i, int j, String text){
        super();
        this.x = i;
        this.y = j;
        this.setText(text);
        this.setVisible(true);
        
    }
    */
    public Obutton(){
        super();
        this.setBackground(Color.black);
        this.setForeground(Color.black);
        this.setSize(20, 20);
        this.setVisible(true);
        
    }
  /*  public String printText(){
      String words = this.solarSystemArray.toString();
        return words;
    }
    
   public int getId(){
       return number;
   }
   
   */ 
   
   public void setA(int a){
       A = a;
   }
   
   public void setB(int b){
       B = b;
   } 
   
   public int getA(){
       return A;
   }
   
   public int getB(){
       return B;
   }
    
}
