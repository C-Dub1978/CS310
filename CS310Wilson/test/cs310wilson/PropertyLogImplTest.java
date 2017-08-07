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
    PropertyLogImpl p;
    Property p1;
    Property p2;
    Property p3;
    
    public PropertyLogImplTest() {
        p = new PropertyLogImpl();
        p1 = new Property(1234567, "AA1111111", "12 big wok way", "denver", "CO",
        80221, 2, 2.5, true, 350000);
        p2 = new Property(1324565, "AB1111111", "34 haight st.", "denver", "CO",
        80229, 3, 3.5, true, 290000);
        p3 = new Property(1111111, "AZ1111111", "434 hello world rd", "denver",
        "CO", 80520, 3, 3, false, 3333333);
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createHashFromMls method, of class PropertyLogImpl.
     */
    @Test
    public void testCreateHashFromMls() {
    }

    /**
     * Test of add method, of class PropertyLogImpl.
     */
    @Test
    public void testAdd() {
        p.add(p1);
        p.displayHash();
        p.add(p2);
        p.displayHash();
        p.add(p3);
        Property prop = p.find(1324565);
        
    }

    /**
     * Test of linkNodes method, of class PropertyLogImpl.
     */
    @Test
    public void testLinkNodes() {
    }

    /**
     * Test of displayHash method, of class PropertyLogImpl.
     */
    @Test
    public void testDisplayHash() {
    }
    
}
