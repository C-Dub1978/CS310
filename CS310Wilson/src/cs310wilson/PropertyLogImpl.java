/*
 * This class is used to keep an array of all properties for all realtors,
 * and has some getters/setters and methods to access data
 */
package cs310wilson;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * PropertyLog class
 * @author Chris Wilson
 * @version java assn 2
 */
public class PropertyLogImpl {
    private LinkedList<Property> propertyList;    
    private int numProperties;
    private final int MAX_PROPERTIES;
    
    
    /**
     * Constructor, default
     */
    public PropertyLogImpl() {
        MAX_PROPERTIES = 1000;
        propertyList = new LinkedList<>();        
    }
    
    /**
     * Getter, gets the property list data field
     * @return the data field
     */
    public LinkedList<Property> getPropertyLog() {
        return propertyList;
    }
    
    
    /**
     * Getter, gets the number of properties
     * @return the data field
     */
    public int size() {
        return propertyList.size();
    }
    
    /**
     * Method to add property to the list
     * @param obj, Property object to add
     * @return boolean value of success/failure
     */
    public boolean add(Property obj) {
        if(numProperties == MAX_PROPERTIES) {
            return false;
        }
        propertyList.add(obj);
        return true;
    }
    
    /**
     * Method to remove from the list
     * @param license, realtor license number associated with the property
     * @return boolean value of success/failure
     */
    public boolean remove(String license) {
        ListIterator<Property> iterator = propertyList.listIterator();
        boolean licenseExists = false;
        while(iterator.hasNext()) {
            if(iterator.next().getRealtorLicenseNum().equals(license)) {
                propertyList.remove(iterator.next());
                licenseExists = true;
            }
        }
        return licenseExists;
    }
    
    /**
     * Overloaded remove method
     * @param mlsNum, the property mls number
     * @return boolean value of success/failure
     */
    public boolean remove(int mlsNum) {
        ListIterator<Property> iterator = propertyList.listIterator();
        boolean mlsExists = false;        
        while(iterator.hasNext()) {
            if(iterator.next().getMls() == mlsNum) {
                propertyList.remove(iterator.next());
                mlsExists = true;
            }
        }
        return mlsExists;
    }
    
    /**
     * Method to see if mls is in the array
     * @param mlsNum, the property mls number
     * @return boolean value of uniqueness
     */
    public boolean isMlsUnique(int mlsNum) {
        ListIterator<Property> iterator = propertyList.listIterator();
        boolean unique = true;
        if(numProperties == 0) {
            return unique;
        }
        while(iterator.hasNext()) {
            if(iterator.next().getMls() == mlsNum) {
                unique = false;
            }
        }
        return unique;
    } 
    
    /**
     * Method to get number of properties for a realtor
     * @param license, the realtor license number
     * @return count, number of properties associated with that realtor
     */
    public int numberOfProperties(String license) {
        ListIterator<Property> iterator = propertyList.listIterator();
        int count = 0;
        while(iterator.hasNext()) {
            if(iterator.next().getRealtorLicenseNum().equals(license)) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Method to get total property value of all
     * @return total, the total value of all properties
     */
    public double totalPropertyValue() {
        ListIterator<Property> iterator = propertyList.listIterator();
        double total = 0.0;
        while(iterator.hasNext()) {
            total += iterator.next().getAskingPrice();
        }
        return total;
    }
    
    /**
     * Method to get all property values from a realtor
     * @param license, the realtor license number
     * @return total, total value for that realtor
     */
    public double totalPropertyValue(String license) {
        ListIterator<Property> iterator = propertyList.listIterator();
        double total = 0.0;
        while(iterator.hasNext()) {
            if(iterator.next().getRealtorLicenseNum().equals(license)) {
                total += iterator.next().getAskingPrice();
            }
        }
        return total;
    }
    
    public void traverseDisplay() {
        ListIterator<Property> iterator = propertyList.listIterator();
        System.out.println("Property log: ");
        if(propertyList.isEmpty()) {
            System.out.println("\tEmpty log");
        }
        else {
            while(iterator.hasNext()) {
                System.out.println("\t" + iterator.next().toString() + "\n");
            }
        }
        System.out.println();
    }
    
    public boolean cleanUp() {        
        boolean removed = false;        
        ListIterator<Property> iterator = propertyList.listIterator();
        while(iterator.hasNext()) {
            if(!iterator.next().checkMlsNum()) {
                iterator.remove();
                removed = true;                
            }
        }
        return removed;
    }
    
    public void clearList() {
        propertyList.clear();
    }
    
}
