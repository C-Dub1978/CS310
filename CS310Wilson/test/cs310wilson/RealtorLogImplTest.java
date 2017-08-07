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
    RealtorLogImpl r;
    Realtor bob;
    Realtor dylan;
    Realtor carl;
    Realtor michelle;
    Realtor evie;
    Realtor georgia;
    Realtor anna;
    Realtor ferdinand;
    Realtor david;
    Realtor alice;
    Realtor lonnie;
    Realtor leslie;
    Realtor johnDoe;
    
    public RealtorLogImplTest() {
        
    }
    
    @Before
    public void setUp() {
        r = new RealtorLogImpl();
        bob = new Realtor("BB2222222", "Bob", "Benson", "222-222-2222",
        0.012);
        dylan = new Realtor("B2222222B", "Dylan", "Speer",
        "321-321-3333", 0.5);
        carl = new Realtor("CC3333333", "Carl", "Combs", "333-333-3333",
        0.88);
        michelle = new Realtor("C3333333C", "Michelle", "Ngeachello", 
        "299-299-2929", 2.5);
        evie = new Realtor("EE5555555", "Evie", "Easton", "555-555-5555",
        0.015);
        georgia = new Realtor("GG7777777", "Georgia", "Green", "777-777-7777",
        0.2);
        anna = new Realtor("AA1111111", "Anna", "Astrid", "111-111-1111",
        0.11);
        ferdinand = new Realtor("FF6666666", "Ferdinand", "Freebase", "666-666-6666",
        0.06);
        david = new Realtor("DD4444444", "David", "Donaho", "111-111-1111",
        0.11);
        alice = new Realtor("F6F666666", "Alice", "B.Tokeless", "234-234-2234", 
        0.420);
        lonnie = new Realtor("G7777777G", "Lonnie", "Donaho", "299-999-9999", 
        0.4);
        leslie = new Realtor("B2B222222", "Leslie", "Lavish", "333-999-8888",
        0.5);
        johnDoe = new Realtor("XX1234567", "John", "Doe", "333-333-0000", 0.1);
    }
    
    @After
    public void tearDown() {
    }    

    /**
     * Test of getSize method, of class RealtorLogImpl.
     */
    @Test
    public void testByteArray() {
        String license = "CC1122333";
        System.out.println(r.createHashFromLicense(license));
    }
    
    @Test
    public void testHashMethod() {
        String r1 = "EE5555555"; // 3
        String r2 = "GG7777777"; // 21
        String r3 = "BB2222222"; // 22
        String r4 = "AA1111111"; // 13 
        String r5 = "FF6666666"; // 12
        String r6 = "DD4444444"; // 17
        String r7 = "CC3333333"; // 8
        String r8 = "B2222222B"; // 22
        String r9 = "F6F666666"; // 12
        String r10 = "C3333333C"; // 8
        assertEquals(3, r.createHashFromLicense(r1));
        assertEquals(21, r.createHashFromLicense(r2));
        assertEquals(22, r.createHashFromLicense(r3));
        assertEquals(13, r.createHashFromLicense(r4));
        assertEquals(12, r.createHashFromLicense(r5));
        assertEquals(17, r.createHashFromLicense(r6));
        assertEquals(8, r.createHashFromLicense(r7));
        assertEquals(22, r.createHashFromLicense(r8));
        assertEquals(12, r.createHashFromLicense(r9));
        assertEquals(8, r.createHashFromLicense(r10));
    }
    
    @Test
    public void testAdd() {
        r.add(bob);
        r.displayHash();
        r.add(dylan);
        r.displayHash();
        r.add(carl);
        r.displayHash();
        r.add(michelle);
        r.displayHash();
        r.add(evie);
        r.displayHash();
        r.add(georgia);
        r.displayHash();
        r.add(lonnie);
        r.displayHash();
        r.add(leslie);
        r.displayHash();
    }
    
    @Test
    public void testFind() {
        r.add(bob);        
        r.add(dylan);        
        r.add(carl);        
        r.add(michelle);        
        r.add(evie);       
        r.add(lonnie);       
        r.add(leslie);
        r.displayHash();
        r.find(leslie);
        r.find(bob);
        r.find(dylan);
        r.find(carl);
        r.find(johnDoe);
    }

    
}
