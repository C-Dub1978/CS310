/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs310wilson;

import java.util.ArrayList;

/**
 *
 * @author klown
 */
public class RealtorLogImpl {
    private ArrayList<Realtor> realtorLog;
    
    public RealtorLogImpl() {
        realtorLog = new ArrayList<>();
    }
    
    public ArrayList<Realtor> getRealtorLog() {
        return realtorLog;
    }
    
    public void add(Realtor obj) {
        
    }
    
    public boolean remove(String license) {
        return true;
    }
    
    public boolean isLicenseUnique(String license) {
        if(realtorLog.isEmpty()) {
            return true;
        }
        if(realtorLog.size() > 0) {
            for(Realtor r: realtorLog) {
                if(license.equals(r.getLicenseNum())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "RealtorLogImpl{" + "realtorLog=" + realtorLog + '}';
    }
    
    
    
}
