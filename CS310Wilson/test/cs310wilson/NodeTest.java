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
public class NodeTest {
    
    public NodeTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        Property p = new Property(1234567, "AA1234567", "33 Pine pl", "Denver", "CO", 80221, 3, 3.5, false, 330000);
        Realtor r = new Realtor("AA1234567", "James", "Dumm", "303-333-3333", 0.18);
        Node<Property> propertyNode = new Node("PROPERTY");
        Node<Realtor> realtorNode = new Node("REALTOR");
        propertyNode.setData(p);
        realtorNode.setData(r);
        System.out.println(propertyNode.toString());
        System.out.println(realtorNode.toString());
    }
    
}
