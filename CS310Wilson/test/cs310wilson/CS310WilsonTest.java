/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs310wilson;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author klown
 */
public class CS310WilsonTest {     
    
    public CS310WilsonTest() {
       
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of main method, of class CS310Wilson.
     */
    @Test
    public void testMain() {
    }

    /**
     * Test of processDataFile method, of class CS310Wilson.
     */
    @Test
    public void testProcessDataFile() {
    }

    /**
     * Test of addRealtor method, of class CS310Wilson.
     */
    @Test
    public void testAddRealtor() {
        String[] arr1 = {"REALTOR", "ADD", "AB1234567", "JAMES", "HETFIELD", "303-333-3333", "5.6"};        
        CS310Wilson.addRealtor(arr1);
        String[] arr2 = {"REALTOR", "ADD", "AB1234569", "JAMES", "HETFIELD", "303-333-3333", "2.6"};
        CS310Wilson.addRealtor(arr2);
        String[] arr3 = {"REALTOR", "ADD", "AB1234568", "JAMES", "HETFIELD", "303333-3333", "5.6"};
        CS310Wilson.addRealtor(arr3);        
    }

    /**
     * Test of deleteRealtor method, of class CS310Wilson.
     */
    @Test
    public void testDeleteRealtor() {
    }

    /**
     * Test of addProperty method, of class CS310Wilson.
     */
    @Test
    public void testAddProperty() {
    }

    /**
     * Test of deleteProperty method, of class CS310Wilson.
     */
    @Test
    public void testDeleteProperty() {
    }
    
}
