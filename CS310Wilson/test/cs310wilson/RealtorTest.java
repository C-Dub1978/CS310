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
public class RealtorTest {   
    
    
    public RealtorTest() {
        
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getLicenseNum method, of class Realtor.
     */
    @Test
    public void testGetLicenseNum() {
    }

    /**
     * Test of setLicenseNum method, of class Realtor.
     */
    @Test
    public void testSetLicenseNum() {
    }

    /**
     * Test of getFirstName method, of class Realtor.
     */
    @Test
    public void testGetFirstName() {
    }

    /**
     * Test of setFirstName method, of class Realtor.
     */
    @Test
    public void testSetFirstName() {
    }

    /**
     * Test of getLastName method, of class Realtor.
     */
    @Test
    public void testGetLastName() {
    }

    /**
     * Test of setLastName method, of class Realtor.
     */
    @Test
    public void testSetLastName() {
    }

    /**
     * Test of getPhoneNum method, of class Realtor.
     */
    @Test
    public void testGetPhoneNum() {
    }

    /**
     * Test of setPhoneNum method, of class Realtor.
     */
    @Test
    public void testSetPhoneNum() {
    }

    /**
     * Test of getCommission method, of class Realtor.
     */
    @Test
    public void testGetCommission() {
    }

    /**
     * Test of setCommission method, of class Realtor.
     */
    @Test
    public void testSetCommission() {
    }

    /**
     * Test of equals method, of class Realtor.
     */
    @Test
    public void testEquals() {
    }

    /**
     * Test of toString method, of class Realtor.
     */
    @Test
    public void testToString() {
    }

    /**
     * Test of checkRealtorLicense method, of class Realtor.
     */
    @Test
    public void testCheckRealtorLicense() {
    }

    /**
     * Test of checkPhoneNumber method, of class Realtor.
     */
    @Test
    public void testCheckPhoneNumber() {
    }

    /**
     * Test of compareTo method, of class Realtor.
     */
    @Test
    public void testCompareTo() {
        Realtor n1 = new Realtor();
        n1.setLicenseNum("AB1234567");
        Realtor n2 = new Realtor();
        n2.setLicenseNum("FX1234567");
        Realtor n3 = new Realtor();
        n3.setLicenseNum("ZZ1234567");
        Realtor n4 = new Realtor();
        n4.setLicenseNum("AB1234567");
        Realtor n5 = new Realtor();
        n5.setLicenseNum("AB12345");
        Realtor n6 = new Realtor();
        n6.setLicenseNum("AB123456789");
        
//        System.out.println("n2 compared to n1: " + n1.compareTo(n2));
//        System.out.println("n3 compared to n1: " + n1.compareTo(n3));
//        System.out.println("n1 compared to n2: " + n2.compareTo(n1));
//        System.out.println("n3 compared to n2: " + n2.compareTo(n3));
//        System.out.println("n4 compared to n1: " + n1.compareTo(n4));
//        System.out.println();
//        System.out.println("n5 compared to n1: " + n1.compareTo(n5));
//        System.out.println("n6 compared to n1: " + n1.compareTo(n6));
    }
    
}
