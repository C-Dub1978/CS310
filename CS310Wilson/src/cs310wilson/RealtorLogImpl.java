/*
 * Class for keeping track of the Hash Table of realtors and various
 * functionality
 */
package cs310wilson;

import java.io.UnsupportedEncodingException;

/**
 * Realtor log class
 * @author Chris Wilson
 * @version java assn 5
 */
public class RealtorLogImpl {
    private Realtor[] hashTable;
    private final int TABLE_MAXIMUM_SIZE;
    private final int TABLE_BOUNDARY;
    private int size;
    private int current;
    
    /**
     * Default constructor
     */
    public RealtorLogImpl() {
        TABLE_MAXIMUM_SIZE = 23;
        TABLE_BOUNDARY = TABLE_MAXIMUM_SIZE - 1;
        hashTable = new Realtor[TABLE_MAXIMUM_SIZE];        
        size = 0;
        current = 0;
    }
    
    /** Method to add realtor to the hash table
     *
     * @param r, realtor object to add
     * @return boolean value of operations
     */
    public boolean add(Realtor r) {
        if(size == TABLE_BOUNDARY) {
            System.out.println("Error, hash table is full and no " + 
                    " chaining is implemented!");
            System.out.println("Realtor " + r.getLicenseNum() + " not" +
                    " added");
            return false;
        }
        int index = createHashFromLicense(r.getLicenseNum());
        boolean added = false;        
        if(hashTable[index] == null && index != TABLE_BOUNDARY) {
            hashTable[index] = r;            
            added = true;
            size++;
        }
        else {            
            added = rehash(r, index);
            if(added) {
                size++;                
            }
        }
        return added;
    }    
        
    /** Method to see if the table is empty
     *
     * @return boolean value of size
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Method to get table size
     *
     * @return size, the size of the table
     */
    public int size() {
        return size;
    }

    /** Method to create a hash key from the realtor license
     *
     * @param license, the realtors license
     * @return key
     */
    public int createHashFromLicense(String license) {
        int total = 0;
        byte[] licenseToBytes = null;
        try {
        licenseToBytes = license.getBytes("US-ASCII");
        }
        catch(UnsupportedEncodingException e) {
            System.out.println("Error encoding license to ASCII bytes");
        }
        for(int i = 0; i < license.length(); i++) {
            total += licenseToBytes[i];
        }        
        return total % TABLE_MAXIMUM_SIZE;
    }
    
    /** Method to rehash if there is a collision
     *
     * @param r, the realtor object
     * @param startIndex, the index where the collision took place
     * @return boolean value of operation
     */
    public boolean rehash(Realtor r, int startIndex) {        
        if(startIndex == TABLE_BOUNDARY - 1 || startIndex == TABLE_BOUNDARY) {
            current = 0;
        }
        else {
            current = startIndex + 1;
        }        
        boolean added = false;
        while(!added && current != startIndex) {
            if(hashTable[current] == null) {
                hashTable[current] = r;
                size++;
                added = true;                
                return true;
            }
            else {
                current++;
                if(current == TABLE_MAXIMUM_SIZE) {
                    current = 0;
                }
            }
        }        
        return false;
    }
    
    /** Method to find a realtor based on license number
     *
     * @param license, the realtor license
     * @return the Realtor object, if found, or null
     */
    public Realtor find(String license) {
        int key = createHashFromLicense(license);        
        boolean found = false;
        if(key >= TABLE_BOUNDARY) {
            current = 0;
        }
        else {
            current = key;
            if(hashTable[current] != null) {
                if(hashTable[current].getLicenseNum().equals(license)) {                    
                    return hashTable[current];
                }
                else {
                    current = key + 1;
                }
            }
            else {
                current = key + 1;
            }            
        }        
        while(!found && current != key) {            
            if(current == TABLE_BOUNDARY) {
                current = 0;
            }
            else {
                if(hashTable[current] != null) {
                    if(hashTable[current].getLicenseNum().equals(license)) {
                        found = true;                        
                        return hashTable[current];
                    }
                    else {
                        current++;
                    }
                }
                else {
                    current++;
                }
            }
        }
        System.out.println("Realtor " + license + " not found");
        return null;
    }  
    
    /** Method to display the entire hash table
     *
     */
    public void displayHash() {
        System.out.println("Realtor Hash Table:");
        for(int i = 0; i < TABLE_MAXIMUM_SIZE; i++) {
            String index = hashTable[i] == null ? "is empty" :
                    "contains Realtor " + hashTable[i].getLicenseNum() + 
                    ", " + hashTable[i].getFirstName() + 
                    " " + hashTable[i].getLastName();
            System.out.println("\tIndex " + i + " " + index);
        }
    }

    /** Method to get the table data field
     *
     * @return the table data field
     */
    public Realtor[] getTable() {
        return hashTable;
    }
}
