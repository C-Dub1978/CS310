/*
 * Class for keeping track of the Linked List of realtors and it's associated
 * functionality
 */
package cs310wilson;

import java.io.UnsupportedEncodingException;

/**
 * Realtor log class
 * @author Chris Wilson
 * @version java assn 2
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
        System.out.println("Hash index created : " + index);
        if(hashTable[index] == null && index != TABLE_BOUNDARY) {
            hashTable[index] = r;
            System.out.println("Added realtor " + r.getLicenseNum() +
                    ", " + r.getFirstName() + " " + r.getLastName());
            added = true;
            size++;
        }
        else {            
            added = rehash(r, index);
            if(added) {
                size++;
                System.out.println("Added realtor " + r.getLicenseNum() +
                    ", " + r.getFirstName() + " " + r.getLastName());
            }
        }
        return added;
    }    
        
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }

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
    
    public boolean rehash(Realtor r, int startIndex) {
        System.out.println("Called rehash on index " + startIndex);
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
    
    public Realtor find(Realtor r) {       
        int key = createHashFromLicense(r.getLicenseNum());        
        boolean found = false;
        if(key >= TABLE_BOUNDARY) {
            current = 0;
        }
        else {
            current = key;
            if(hashTable[current] != null) {
                if(hashTable[current].equals(r)) {
                    System.out.println("Realtor " + r.getLicenseNum()
                                + " " + r.getFirstName() + " found at index " + current);
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
                    if(hashTable[current].equals(r)) {
                        found = true;
                        System.out.println("Realtor " + r.getLicenseNum()
                                + " " + r.getFirstName() + " found at index " + current);
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
        System.out.println("Realtor " + r.getLicenseNum() + " not found");
        return null;
    }
    
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

    public Realtor[] getTable() {
        return hashTable;
    }
}
