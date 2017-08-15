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
    RealtorLogImpl log;
    
    public RealtorLogImplTest() {
        log = new RealtorLogImpl();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class RealtorLogImpl.
     */
    @Test
    public void testAdd() {
        Realtor r1 = new Realtor("AZ1234567", "Hanz", "Brix", "303-333-3333", 0.15);
        Realtor r2 = new Realtor("ZZ1234567", "Jane", "Doe", "720-399-9999", 0.7);
        Realtor r3 = new Realtor("MX1234567", "John", "Doe", "444-444-4444", 1.2);
        Realtor r4 = new Realtor("DB1234567", "Alice", "B.Tokeless", "333-333-3333", 1.2);        
        log.add(r1);
        log.add(r2);
        log.add(r3);
        log.add(r4);
        assertEquals(4, log.getSize());
        log.traverseDisplay(log.getRoot());
        System.out.println();
        System.out.println();
        Realtor test1 = log.find("AZ1234567");
        Realtor test2 = log.find("ZZ1234567");
        Realtor test3 = log.find("MX1234567");
        Realtor test4 = log.find("DB1234567");
        Realtor test5 = log.find("DL1234");
        Realtor test6 = log.find("LO12345");
        Realtor test7 = log.find("LLL4444");
        assertEquals(r1, test1);
        assertEquals(r2, test2);
        assertEquals(r3, test3);
        assertEquals(r4, test4);
        assertEquals(null, test5);
        assertEquals(null, test6);
        assertEquals(null, test7);
    }

    /**
     * Test of insert method, of class RealtorLogImpl.
     */
    @Test
    public void testInsert() {
    }

    /**
     * Test of clear method, of class RealtorLogImpl.
     */
    @Test
    public void testClear() {
    }
    
}
