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
public class RealtorLogImplTest {
    RealtorNode n1;
    RealtorNode n2;
    RealtorNode n3;
    RealtorNode n4;
    Realtor r1;
    Realtor r2;
    Realtor r3;
    Realtor r4;
    RealtorLogImpl log;
    
    
    public RealtorLogImplTest() {
        log = new RealtorLogImpl();
        r1 = new Realtor();
        r2 = new Realtor();
        r3 = new Realtor();
        r4 = new Realtor();
        r1.setLicenseNum("AB1234567");
        r2.setLicenseNum("FF1234567");
        r3.setLicenseNum("MX1234567");
        r4.setLicenseNum("ZZ1234567");        
    }
    
    @Before
    public void setUp() {
        log.clear();
    }
    

    /**
     * Test of add method, of class RealtorLogImpl.
     */
    @Test
    public void testAdd() {
        boolean t = log.add(r1);
        int size = log.getSize();
        assertEquals(1, size);        
        t = log.add(r2);
        size = log.getSize();
        assertEquals(2, size);
        t = log.add(r3);
        size = log.getSize();
        assertEquals(3, size);
        t = log.add(r4);
        size = log.getSize();
        assertEquals(4, size);
        log.traverseDisplay();
        log.clear();
        size = log.getSize();
        assertEquals(0, size);
        t = log.add(r4);
        t = log.add(r3);
        t = log.add(r2);
        t = log.add(r1);
        size = log.getSize();
        assertEquals(4, size);
        log.traverseDisplay();
        log.clear();
        size = log.getSize();
        assertEquals(0, size);
        t = log.add(r4);
        t = log.add(r2);
        t = log.add(r3);
        t = log.add(r1);
        size = log.getSize();
        assertEquals(4, size);
        log.traverseDisplay();
    }

    /**
     * Test of remove method, of class RealtorLogImpl.
     */
    @Test
    public void testRemove() {
    }

    /**
     * Test of isLicenseUnique method, of class RealtorLogImpl.
     */
    @Test
    public void testIsLicenseUnique() {
    }

    /**
     * Test of traverseDisplay method, of class RealtorLogImpl.
     */
    @Test
    public void testTraverseDisplay() {
    }

    /**
     * Test of clear method, of class RealtorLogImpl.
     */
    @Test
    public void testClear() {
    }

    /**
     * Test of getSize method, of class RealtorLogImpl.
     */
    @Test
    public void testGetSize() {
    }

    /**
     * Test of toString method, of class RealtorLogImpl.
     */
    @Test
    public void testToString() {
    }
    
}
