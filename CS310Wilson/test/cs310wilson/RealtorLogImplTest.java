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
public class RealtorLogImplTest {    
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
        r1.setFirstName("Chris");
        r1.setLastName("Chelios");
        r2.setLicenseNum("FF1234567");
        r2.setFirstName("Jane");
        r2.setLastName("Doe");
        r3.setLicenseNum("MX1234567");
        r3.setFirstName("Keith");
        r3.setLastName("Munoz");
        r4.setLicenseNum("ZZ1234567");
        r4.setFirstName("Aldon");
        r4.setLastName("Alduson");        
    }
    
    @Before
    public void setUp() {
        log.clear();
    }
    
    @After
    public void tearDown() {
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
        //log.traverseDisplay();
        log.clear();
        size = log.getSize();
        assertEquals(0, size);
        t = log.add(r4);
        t = log.add(r3);
        t = log.add(r2);
        t = log.add(r1);
        size = log.getSize();
        assertEquals(4, size);
        //log.traverseDisplay();
        log.clear();
        size = log.getSize();
        assertEquals(0, size);
        t = log.add(r4);
        t = log.add(r2);
        t = log.add(r3);
        t = log.add(r1);
        size = log.getSize();
        assertEquals(4, size);
        //log.traverseDisplay();
    }

    /**
     * Test of remove method, of class RealtorLogImpl.
     */
    @Test
    public void testRemove() {
        boolean t = false;
        t = log.add(r4);
        t = log.add(r2);
        t = log.add(r3);
        t = log.add(r1);
        int size = log.getSize();
        assertEquals(4, size);
        //log.traverseDisplay();
        t = log.remove();
        size = log.getSize();
        assertEquals(3, size);
        //log.traverseDisplay();        
    }

    /**
     * Test of isLicenseUnique method, of class RealtorLogImpl.
     */
    @Test
    public void testIsLicenseUnique() {
        log.add(r1);
        log.add(r2);
        log.add(r3);
        log.add(r4);
        assertEquals(false, log.isLicenseUnique("AB1234567"));
        assertEquals(false, log.isLicenseUnique("FF1234567"));
        assertEquals(false, log.isLicenseUnique("MX1234567"));
        assertEquals(false, log.isLicenseUnique("ZZ1234567"));
        assertEquals(true, log.isLicenseUnique("AX1234567"));
        assertEquals(true, log.isLicenseUnique("aB1234567"));
    }    

    /**
     * Test of clear method, of class RealtorLogImpl.
     */
    @Test
    public void testClear() {
        log.add(r1);
        log.add(r2);
        log.add(r3);
        log.add(r4);
        assertEquals(4, log.getSize());
        log.clear();
        assertEquals(0, log.getSize());
    }

    /**
     * Test of getSize method, of class RealtorLogImpl.
     */
    @Test
    public void testGetSize() {
        log.add(r1);
        assertEquals(1, log.getSize());
        log.add(r2);
        assertEquals(2, log.getSize());
        log.add(r3);
        assertEquals(3, log.getSize());
        log.add(r4);
        assertEquals(4, log.getSize());
    }
    
    @Test
    public void testCleanUp() {
        r1.setLicenseNum("AA1234567");
        r2.setLicenseNum("AB12");
        r3.setLicenseNum("FF1234567");
        r4.setLicenseNum("ZZ123");
        log.add(r1);
        log.add(r2);
        log.add(r3);
        log.add(r4);
        log.traverseDisplay();
        assertEquals(4, log.getSize());
        log.cleanUp();
        log.traverseDisplay();
    }
    
}
