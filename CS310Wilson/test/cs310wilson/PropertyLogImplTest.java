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
    PropertyLogImpl log;
    
    public PropertyLogImplTest() {
        log = new PropertyLogImpl();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class PropertyLogImpl.
     */
    @Test
    public void testAdd() {
        Property p1 = new Property(12345, "AA123", "12 Main St.", "Denver", "CO", 80229, 3, 3.5, false, 350000);
        Property p2 = new Property(89008, "BB123", "12 East St.", "Denver", "CO", 80229, 3, 3.5, false, 357000);
        Property p3 = new Property(11132, "CC123", "15 None St.", "Denver", "CO", 80229, 3, 3.5, false, 250000);
        Property p4 = new Property(99901, "DD123", "44 Walter St.", "Denver", "CO", 80229, 3, 3.5, false, 550000);
        Property p5 = new Property(7895678, "CC123", "1555 Deleware St.", "Denver", "CO", 80229, 3, 3.5, false, 450000);
        log.add(p1);
        log.add(p2);
        log.add(p3);
        log.add(p4);
        log.add(p5);
        log.traverseDisplay();
    }

    /**
     * Test of find method, of class PropertyLogImpl.
     */
    @Test
    public void testFind() {
    }
    
}
