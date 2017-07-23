/*
 * Class for keeping track of the ArrayList of realtors and it's associated
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
                int weight = current.getNext().getRealtor().compareTo(r);
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
    
    public boolean isNodeGreaterThanTail(RealtorNode r) {
        if(tail != null) {
        int weight = tail.getRealtor().compareTo(r.getRealtor());
        if(weight == -1 || weight == 0) {            
            return true;
        }
        }
        return false;
    }
    
    public void traverseDisplay() {
        current = head;
        for(int i = 0; i < size; i++) {
            current = current.getNext();
            System.out.println(current.toString());
        }
    }
    
    public void clear() {
        head.setNext(null);
        tail = head;
        size = 0;        
    }
    
    
    public int getSize() {
        return size;
    }    
    
    
    /**
     * Method to check if a realtor license is in the list
     * @param license, realtor license to check for
     * @return boolean value of success/failure
     */
    public boolean isLicenseUnique(String license) {
        //TODO: iterate through list with a loop and get the license,
        //  check for if exists
        return true;
    }   
}
