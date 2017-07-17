/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs310wilson;

import java.util.ArrayList;
import java.util.Collections;

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
        realtorLog.add(obj);
        Collections.sort(realtorLog);
    }
    
    public boolean remove(String license) {
        int count = 0;
        for(Realtor r : realtorLog) {
            if(r.getLicenseNum().equals(license)) {
                realtorLog.remove(count);
                return true;
            }
            count++;
        }
        return false;
    }
    
    public boolean isLicenseUnique(String license) {
        if(realtorLog.isEmpty()) {
            return true;
        }        
        for(Realtor r: realtorLog) {
            if(license.equals(r.getLicenseNum())) {
                return false;
            }
        }        
        return true;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        int count = 0;
        for(Realtor r : realtorLog) {
            str.append(r.getLicenseNum());
            str.append(" - index ");
            str.append(count);
            str.append("\n");
            count++;
        }
        return str.toString();
    }
    
    
    
}
