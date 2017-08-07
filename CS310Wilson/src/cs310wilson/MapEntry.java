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
public class MapEntry {
    private int key;
    private PropertyNode property;    
    
    public MapEntry(int num, PropertyNode prop) {
        key = num;
        property = prop;
    }
    
    public void setKey(int num) {
        key = num;
    }
    
    public int getKey() {
        return key;
    }
    
    public void setPropertyNode(PropertyNode p) {
        property = p;
    }
    
    public PropertyNode getPropertyNode() {
        return property;
    }   
    
}
