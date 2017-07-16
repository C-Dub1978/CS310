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
public class PropertyLogImpl {
    private Property[] propertyArray;
    private int numProperties;
    private final int MAX_PROPERTIES;
    
    public PropertyLogImpl() {
        MAX_PROPERTIES = 1000;
        propertyArray = new Property[MAX_PROPERTIES];
        numProperties = 0;
    }
    
    public Property[] getPropertyArray() {
        return propertyArray;
    }
    
    public int getNumProperties() {
        return numProperties;
    }
    
    public boolean add(Property obj) {
        return true;
    }
    
    public boolean remove(String license) {
        return true;
    }
    
    public boolean remove(int mlsNum) {
        return true;
    }
    
    public boolean isMlsUnique(int mlsNum) {
        return true;
    } 
    
    public int numberOfProperties(String license) {
        return 0;
    }
    
    public double totalPropertyValue() {
        return 0.0D;
    }
    
    public double totalPropertyValue(String license) {
        return 0.0D;
    }
    
}
