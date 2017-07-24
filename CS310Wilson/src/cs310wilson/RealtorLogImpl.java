/*
 * Class for keeping track of the Linked List of realtors and it's associated
 * functionality
 */
package cs310wilson;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Realtor log class
 * @author Chris Wilson
 * @version java assn 2
 */
public class RealtorLogImpl {
    private RealtorNode head;
    private RealtorNode tail;
    private RealtorNode current;
    private int size;
    
    /**
     * Default constructor
     */
    public RealtorLogImpl() {
        head = new RealtorNode();        
        tail = head;
        current = null;
        size = 0;
    }
    
    public int getSize() {
        return size;
    } 

    public boolean add(Realtor r) {
        current = head;
        RealtorNode n = new RealtorNode(r);
        if(size == 0) {
            head.setNext(n);
            tail = n;
            size++;
            return true;
        }        
        else if(size > 0) {
            if(isNodeGreaterThanTail(n)) {
                addToTail(r);
                return true;
            }
            current = head;
            while(current.getNext() != null) {
                int weight = current.getNext().getRealtor().compareToLicense(r);
                if(weight == -1) {
                    current = current.getNext();
                }
                else if(weight >= 0) {
                    RealtorNode temp = current.getNext();
                    current.setNext(n);
                    n.setNext(temp);                    
                    size++;
                    return true;
                }                
            }
        }
        return false;
    }
    
    public boolean addToTail(Realtor r) {
        RealtorNode n = new RealtorNode(r);
        tail.setNext(n);
        tail = n;
        size++;
        return true;
    }
    
    public boolean remove(Realtor r) {
        if(size == 0) {
            return false;
        }        
        current = head;
        while(current.getNext() != null) {
            if(current.getNext().getRealtor().equals(r)) {
                if(size == 1) {
                    head.setNext(null);
                    size--;
                    tail = head;
                    return true;
                }
                else {
                    if(current.getNext().getNext() == null) {
                        current.setNext(null);
                        size--;
                        tail = current;
                        return true;
                    }
                    else {
                        current.setNext(current.getNext().getNext());
                        tail = current.getNext();
                        size--;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean remove() {        
        if(size == 0) {
            return false;
        }
        else if(size == 1) {
            head.setNext(null);
            size--;
            return true;
        }
        else {               
        current = head;        
        while(current.getNext().getNext() != null) {
            current = current.getNext();
        }        
        current.setNext(null);
        size--;
        tail = current;
        return true;
        }
    }
    
    public boolean isNodeGreaterThanTail(RealtorNode r) {
        if(tail != null) {
        int weight = tail.getRealtor().compareToLicense(r.getRealtor());
        if(weight == -1 || weight == 0) {            
            return true;
        }
        }
        return false;
    }
    
    public void traverseDisplay() {
        System.out.println("Realtor Log:");
        if(size == 0) {
            System.out.println("\tEmpty log");
        }
        else {
        current = head;
        while(current.getNext() != null) {
            current = current.getNext();
            System.out.println("\t" + current.toString());
        }        
        System.out.println();
        }
    }
    
    public void clear() {
        head.setNext(null);
        tail = head;
        size = 0;        
    }   
    
    /**
     * Method to check if a realtor license is in the list
     * @param license, realtor license to check for
     * @return boolean value of success/failure
     */
    public boolean isLicenseUnique(String license) {
        current = head;
        if(size == 0) {
            return true;
        }
        if(size == 1) {
            if(tail.getRealtor().getLicenseNum().equals(license)) {
                return false;
            }
        }
        else {
            while(current.getNext() != null) {                
                current = current.getNext();
                if(current.getRealtor().getLicenseNum().equals(license)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean cleanUp() {
        current = head;
        if(size == 0) {
            return true;
        }
        if(size == 1) {
            if(!current.getNext().getRealtor().checkRealtorLicense()) {
                this.clear();
                return true;
            }
        }
        else {
            while(current.getNext() != null) {
                if(!current.getNext().getRealtor().checkRealtorLicense()) {
                    current.setNext(current.getNext().getNext());
                    size--;
                    if(current.getNext() == tail) {
                        if(!current.getNext().getRealtor()
                                .checkRealtorLicense()) {
                            tail = current;
                            size--;
                            current.setNext(null);
                            return true;
                        }
                    }                  
                }
                current = current.getNext();
            }
        }
        return false;
    }
}
