/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdbconnector;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author mark
 */
public class ButtonPanel extends JPanel{
    
    public ArrayList<Boolean> stars;// = new ArrayList();
    public ArrayList<String> coordinates;// = new ArrayList();
    public int halved;
    public int mapSize;
    
    
    
    
       public ButtonPanel(int rows){
           
           
    super();
    mapSize = rows;
     stars = new ArrayList();
    coordinates = new ArrayList();
     setLayout(new BorderLayout());        
    JPanel p1 = new JPanel(); 
    halved = (rows - 1)/2;
    p1.setLayout(new GridLayout(rows ,rows));
    p1.setSize(400, 400);
    getConnection();
    
    
    
    
    ///////////////////////////////////////
    /////////////////////////////////////////////////////
    
    printGalaxyMap(0,0);  // these are the x and y coordinates of the center of the shown map
    
    
    //////////////////////////////////////////////////
    ////////////////////////////////////////////////////////
    
    
    
    
    
    
    
    JButton[] buttonArray = new JButton[rows*rows];
    
    
    
    for(int i = 0; i < buttonArray.length; i++){
        JButton b = new JButton();
       // b.setText(contents.get(i));
        // b.setText("" + i);
           
                        int R = (int) (Math.random( )*256);
                        int G = (int)(Math.random( )*256);
                        int B= (int)(Math.random( )*256);
                        Color randomButtonColor = new Color(R, G, B);
                        b.setText( coordinates.get(i) );  // this is informativ if you are interested in a particular color, shos the values
                       // b.setName(contents.get(i));
                       //    b.setName(shortenString(rootFolder)+ "\\" + tempFolder + contents.get(i));
                       if(stars.get(i)){
                        b.setBackground(Color.WHITE);   
                       }else{
                       
                        b.setBackground(Color.BLACK);
                       }

                       
                       // int hundred = (int)(Math.random( )*100 + 1);
                       // b.setBackground(intToCol(i*(100/buttonArray.length)));
                       // b.setBackground(intToCol(100)); // test for black
                        // b.setBackground(intToCol(0)); // test for white
                        b.setBorderPainted(false);
                    //    b.addActionListener(new DropPanel2.StudentButtonListener());
                       // buttonArray[i+60] = b;
                        p1.add(b);
    }
     
     
    add(p1);
       
    
              
 }  // end create result buttons 
    
          
          private Connection getConnection() {
        Connection connection = null;
        try
        {
            // if necessary, set the home directory for Derby
          //  String dbDirectory = "c:/murach/java/db";
          //  System.setProperty("derby.system.home", dbDirectory);

            // set the db url, username, and password
            String url = "jdbc:derby://localhost:1527/space";
            String username = "spaceuser";
            String password = "spaceuser";

            connection = DriverManager.getConnection(url, username, password);
			return connection;
                     
                        
        }
        catch(SQLException e)
        {
            System.err.println(e);
			return null;
        }
    }  //end getConnection
          
          
          
           public void createBooleanStarArray(int x, int y, int k)
    {
        Connection connection = getConnection();
        try
        {
            PreparedStatement ps = connection.prepareStatement(
                "SELECT * FROM SPACEUSER.FIELD WHERE X = ? AND Y = ?");
            ps.setInt(1, x);
            ps.setInt(2, y);
            ResultSet rs = ps.executeQuery();
          
            if(rs.next())
            {
                 int xCord = rs.getInt("x");
                int yCord = rs.getInt("y");
                int id = rs.getInt("id");
                boolean star = rs.getBoolean("empty");

              //  System.out.println("id at (" + xCord + "," + yCord + ")  is: " + id + " and star is " + star);
             // String tempCoords = "(" + xCord + "," + yCord + ")";
               String tempCoords =  xCord + "," + yCord ;
                stars.add(star);
                coordinates.add(tempCoords);
                if(star){
                //  System.out.println("there is a solar system there");  
                }else{
               //    System.out.println("empty space");   
                }
                
            }

            rs.close();
            ps.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }  // end sector by vectors 
    
    
              public void printGalaxyMap(int x, int y){
        
               //int mapSize = 30; // 10 is for the 21 map size that we like, you just need an odd number
               int size = 0;
               int k = 0;
               
       for(int i = -mapSize; i < mapSize + 1; i++){
                for(int j = -mapSize; j < mapSize + 1; j++){
                    createBooleanStarArray(i + x,j + y, k);
                    size++;
                    k++;
                } 
            }
       System.out.println("size of array: " + size);
       int shouldBeThisNumber = ( (2 * mapSize + 1) * (2 * mapSize + 1));
       System.out.println("should be: " + shouldBeThisNumber);
    }  // end sector by vectors  
    
} // end program
