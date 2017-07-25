/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs310wilson;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author klown
 */
public class PropertyLogImplTest {    
    Property p1;
    Property p2;
    Property p3;
    Property p4;
    Property p5;
    Property p6;
    Property p7;
    Property p8;
    Property p9;
    PropertyLogImpl log;
    
    public PropertyLogImplTest() {
        p1 = new Property(123456789, "AB1234567", "810 Essex Dr", "Denver", "CO", 80229, 4, 2.5, false, 100000);
        p2 = new Property(987654321, "FF1234567", "361 Del Norte St", "Denver", "CO", 80229, 3, 1.5, false, 100000);
        p3 = new Property(223456789, "AB1234567", "333 Some Road", "Firestone", "CO", 80520, 5, 3.5, false, 100000);
        p4 = new Property(333456789, "KK1234567", "1234 Big Wok Way", "Thornton", "CO", 80221, 3, 2.5, false, 100000);
        p5 = new Property(444456789, "MM1234567", "666 Hallowed St", "Denver", "CO", 80229, 5, 2.5, false, 100000);
        p6 = new Property(555556789, "XX1234567", "2888 Phoenix Dr", "Denver", "CO", 80221, 6, 4.5, false, 100000);
        p7 = new Property(123456789, "AB1234567", "939 Park Dr", "Denver", "CO", 80331, 4, 2.5, false, 100000);
        p8 = new Property(123456789, "MM1234567", "37992 Reading Rd", "Westminster", "CO", 80521, 2, 1.5, false, 100000);
        p9 = new Property(123456789, "FF1234567", "1255 Dearborn Ave", "Frederick", "CO", 80500, 3, 1.5, false, 100000);
        log = new PropertyLogImpl();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPropertyArray method, of class PropertyLogImpl.
     */
    @Test
    public void testGetPropertyArray() {
    }

    /**
     * Test of getNumProperties method, of class PropertyLogImpl.
     */
    @Test
    public void testGetNumProperties() {
    }

    /**
     * Test of add method, of class PropertyLogImpl.
     */
    @Test
    public void testAdd() {
    }

    /**
     * Test of remove method, of class PropertyLogImpl.
     */
    @Test
    public void testRemove_String() {
    }

    /**
     * Test of remove method, of class PropertyLogImpl.
     */
    @Test
    public void testRemove_int() {
    }

    /**
     * Test of isMlsUnique method, of class PropertyLogImpl.
     */
    @Test
    public void testIsMlsUnique() {
    }

    /**
     * Test of numberOfProperties method, of class PropertyLogImpl.
     */
    @Test
    public void testNumberOfProperties() {
    }

    /**
     * Test of totalPropertyValue method, of class PropertyLogImpl.
     */
    @Test
    public void testTotalPropertyValue_0args() {
    }

    /**
     * Test of totalPropertyValue method, of class PropertyLogImpl.
     */
    @Test
    public void testTotalPropertyValue_String() {
    }

    /**
     * Test of traverseDisplay method, of class PropertyLogImpl.
     */
    @Test
    public void testTraverseDisplay() {
        log.traverseDisplay();
    }
    
}
