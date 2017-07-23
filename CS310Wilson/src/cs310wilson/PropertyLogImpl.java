/*
 * This class is used to keep an array of all properties for all realtors,
 * and has some getters/setters and methods to access data
 */
package cs310wilson;

/**
 * PropertyLog class
 * @author Chris Wilson
 * @version java assn 2
 */
public class PropertyLogImpl {
    private Property[] propertyArray;
    private int numProperties;
    private final int MAX_PROPERTIES;
    
    /**
     * Constructor, default
     */
    public PropertyLogImpl() {
        MAX_PROPERTIES = 1000;
        propertyArray = new Property[MAX_PROPERTIES];
        numProperties = 0;
    }
    
    /**
     * Getter, gets the property array data field
     * @return the data field
     */
    public Property[] getPropertyArray() {
        return propertyArray;
    }
    
    /**
     * Getter, gets the number of properties
     * @return the data field
     */
    public int getNumProperties() {
        return numProperties;
    }
    
    /**
     * Method to add property to the array
     * @param obj, Property object to add
     * @return boolean value of success/failure
     */
    public boolean add(Property obj) {
        if(numProperties == MAX_PROPERTIES) {
            return false;
        }
        propertyArray[numProperties] = obj;
        numProperties++;
        return true;
    }
    
    /**
     * Method to remove from the array
     * @param license, realtor license number associated with the property
     * @return boolean value of success/failure
     */
    public boolean remove(String license) {        
        boolean propertyExists = false;
        for(int i = 0; i < propertyArray.length; i++) {
            if(propertyArray[i] != null) {                
                if(propertyArray[i].getRealtorLicenseNum().equals(license)) {
                    System.out.println("\tProperty with mls " + 
                            propertyArray[i].getMls() + " deleted");
                    propertyArray[i] = null;
                    propertyExists = true;
                    numProperties--;
                }
            } 
        }        
        if(propertyExists) {
            return true;
        }
        return false;
    }
    
    /**
     * Overloaded remove method
     * @param mlsNum, the property mls number
     * @return boolean value of success/failure
     */
    public boolean remove(int mlsNum) {        
        boolean propertyRemoved = false;
        for(int i = 0; i < propertyArray.length; i++) {
            if(propertyArray[i] != null) {
                if(propertyArray[i].getMls() == mlsNum) {
                    System.out.println("\tProperty with mls " +
                            propertyArray[i].getMls() + " deleted");
                    propertyArray[i] = null;
                    propertyRemoved = true;
                    numProperties--;
                }
            }            
        }
        if(propertyRemoved) {
            return true;
        }
        return false;
    }
    
    /**
     * Method to see if mls is in the array
     * @param mlsNum, the property mls number
     * @return boolean value of uniqueness
     */
    public boolean isMlsUnique(int mlsNum) {
        if(propertyArray.length == 0) {
            return true;
        }
        // TODO change this to binary search to help time complexity
        for(int i = 0; i < numProperties; i++) {
            if(mlsNum == propertyArray[i].getMls()) {
                return false;
            }
        }
        return true;
    } 
    
    /**
     * Method to get number of properties for a realtor
     * @param license, the realtor license number
     * @return count, number of properties associated with that realtor
     */
    public int numberOfProperties(String license) {
        int count = 0;
        for(int i = 0; i < numProperties; i++) {
            if(propertyArray[i].getRealtorLicenseNum().equals(license)) {
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
        double total = 0.0;
        for(int i = 0; i < numProperties; i++) {
            if(propertyArray[i] != null) {
            total += propertyArray[i].getAskingPrice();
            }
        }
        return total;
    }
    
    /**
     * Method to get all property values from a realtor
     * @param license, the realtor license number
     * @return total, total value for that realtor
     */
    public double totalPropertyValue(String license) {
        double total = 0.0;
        for(int i = 0; i < numProperties; i++) {
            if(propertyArray[i].getRealtorLicenseNum().equals(license)) {
                total += propertyArray[i].getAskingPrice();
            }
        }
        return total;
    }   
    
}
