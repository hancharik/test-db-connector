/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdbconnector;

/**
 *
 * @author mark
 */
public class TestDBConnector {
        public static DBconnector dbc;// = new DBconnector();  // builds the database
        public static GalaxyFrame gf;// = new GalaxyFrame();  // runs jpanel view of database
        public static int mapSize = 21;
    public static void main(String[] args) {
      //  dbc = new DBconnector();  // builds the database
        gf = new GalaxyFrame();  // runs jpanel view of database
    }
    
}
