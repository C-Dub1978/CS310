/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs310wilson;

/**
 *
 * @author klown
 */
public class PropertyNode {
    private Property property;
    private PropertyNode nextNode;
    
    public PropertyNode() {
        property = null;
        nextNode = null;
    }
    
    public void setProperty(Property p) {
        property = p;
    }
    
    public Property getProperty() {
        return property;
    }
    
    public void setNext(PropertyNode p) {
        nextNode = p;
    }
    
    public PropertyNode getNext() {
        return nextNode;
    }
    
    public boolean hasNext() {
        return nextNode != null;
    }
    
}


