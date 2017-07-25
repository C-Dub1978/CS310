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
        p1 = new Property(1234567, "AB1234567", "810 Essex Dr", "Denver", "CO", 80229, 4, 2.5, false, 100000);
        p2 = new Property(9876543, "FF1234567", "361 Del Norte St", "Denver", "CO", 80229, 3, 1.5, false, 100000);
        p3 = new Property(22789, "AB1234567", "333 Some Road", "Firestone", "CO", 80520, 5, 3.5, false, 100000);
        p4 = new Property(3334567, "KK1234567", "1234 Big Wok Way", "Thornton", "CO", 80221, 3, 2.5, false, 100000);
        p5 = new Property(444, "MM1234567", "666 Hallowed St", "Denver", "CO", 80229, 5, 2.5, false, 100000);
        p6 = new Property(5555567, "XX1234567", "2888 Phoenix Dr", "Denver", "CO", 80221, 6, 4.5, false, 100000);
        p7 = new Property(1234567, "AB1234567", "939 Park Dr", "Denver", "CO", 80331, 4, 2.5, false, 100000);
        p8 = new Property(156789, "MM1234567", "37992 Reading Rd", "Westminster", "CO", 80521, 2, 1.5, false, 100000);
        p9 = new Property(1234560, "FF1234567", "1255 Dearborn Ave", "Frederick", "CO", 80500, 3, 1.5, false, 100000);
        log = new PropertyLogImpl();
    }
    
    @Before
    public void setUp() {
        log.clearList();
    }
    
    @After
    public void tearDown() {
        log.clearList();
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
        log.add(p1);
        assertEquals(1, log.size());
        log.add(p2);
        assertEquals(2, log.size());
        log.add(p3);
        assertEquals(3, log.size());
        log.add(p4);
        assertEquals(4, log.size());
        //log.traverseDisplay();
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
        //log.traverseDisplay();
    }
    
    @Test
    public void testCleanUp() {
        log.add(p1);
        log.add(p2);
        log.add(p3);
        log.add(p4);
        log.add(p5);
        log.add(p6);
        log.add(p7);
        log.add(p8);
        log.add(p9);
        assertEquals(9, log.size());
        log.traverseDisplay();
        log.cleanUp();
        assertEquals(6, log.size());
        log.traverseDisplay();
    }
    
}
