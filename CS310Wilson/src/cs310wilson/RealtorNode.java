/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs310wilson;

import java.util.Objects;

/**
 *
 * @author klown
 */
public class RealtorNode {
    private RealtorNode nextNode;
    private Realtor realtor;
    
    public RealtorNode(Realtor r) {
        realtor = r;
        nextNode = null;
    }
    
    public RealtorNode(Realtor r, RealtorNode next) {
        realtor = r;
        nextNode = next;
    }
    
    public RealtorNode() {
        realtor = null;
        nextNode = null;
    }
    
    public Realtor getRealtor() {
        return realtor;
    }
    
    public void setRealtor(Realtor r) {
        realtor = r;
    }
    
    public RealtorNode getNext() {
        return nextNode;
    }
    
    public void setNext(RealtorNode r) {
        nextNode = r;
    }
    
    @Override
    public String toString() {
        return "Realtor: " + realtor.getLastName() + ", " + 
               realtor.getFirstName() + "\n\t" + "License: " + 
               realtor.getLicenseNum();        
    }    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RealtorNode other = (RealtorNode) obj;
        if (!Objects.equals(this.nextNode, other.nextNode)) {
            return false;
        }
        if (!Objects.equals(this.realtor, other.realtor)) {
            return false;
        }
        return true;
    }
    
    
}
