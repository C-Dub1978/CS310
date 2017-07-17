/*
 * This program will read a list of realtor and/or property data from a csv file, and try to create 
 * realtor and property objects with said data. It will help a real estate office in converting data from the csv
 * files into useful information
 */
package cs310wilson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** Main Class, reads the data from the specified file and builds objects with the data
 * 
 * @author Chris Wilson
 * @version x Java Assn 1
 */
public class CS310Wilson {
    static RealtorLogImpl realtorLogImpl = new RealtorLogImpl();
    static PropertyLogImpl propertyLogImpl = new PropertyLogImpl();
    
    
    public static void main(String[] args) {        
        processDataFile();
    }    
    
    public static void processDataFile() {
        final String INPUT_FILENAME = "input/assn2input1.txt"; 
        File inputFile = null;
        Scanner inputScanner = null;
        try {
            inputFile = new File(INPUT_FILENAME);
            inputScanner = new Scanner(inputFile);
        } catch(FileNotFoundException e) {
            System.err.println("Error opening file " + INPUT_FILENAME);
        }
        while(inputScanner.hasNext()) {
            String[] dataLine = inputScanner.nextLine().split(",");
            // Is the first token "REALTOR"?
            if(dataLine[0].toUpperCase().equals("REALTOR")) {
                if(dataLine[1].toUpperCase().equals("ADD")) {
                    addRealtor(dataLine);
                }
                else if(dataLine[1].toUpperCase().equals("DEL")) {
                    deleteRealtor(dataLine[2]);
                }
                else {
                    
                }
            }
            // Is the first token "PROPERTY"?
            else if(dataLine[0].toUpperCase().equals("PROPERTY")) {
                if(dataLine[1].toUpperCase().equals("ADD")) {
                    addProperty(dataLine);
                }
                else if(dataLine[1].toUpperCase().equals("DEL")) {
                    deleteProperty(Integer.parseInt(dataLine[2]));
                }
                else {
                    
                }
            } else {
                // not realtor or property in the first token
            }
        }
    }
    
    public static void addRealtor(String[] attribs) {           
        double commission = Double.parseDouble(attribs[6]);
        Realtor realtor = new Realtor(attribs[2], attribs[3], attribs[4],
        attribs[5], commission);
        boolean validLicense = realtor.checkRealtorLicense();
        boolean validPhone = realtor.checkPhoneNumber();
        boolean uniqueLicense = 
            realtorLogImpl.isLicenseUnique(realtor.getLicenseNum());
        if(!validLicense) {
            System.out.println("Error, license " + realtor.getLicenseNum() +
                " is invalid");
        }
        if(!validPhone) {
            System.out.println("Error, phone " + realtor.getPhoneNum() +
                " is invalid");
        }
        if(uniqueLicense) {
            realtorLogImpl.add(realtor);
            System.out.println("Realtor with license number " + 
                    realtor.getLicenseNum() + " added to log");
        } else {
            System.out.println("Error, non-unique license number, " +
                    "realtor will not be added to log");
        }
              
    }
    
    public static void deleteRealtor(String license) {
        boolean isLicenseUnique = realtorLogImpl.isLicenseUnique(license);
        boolean removed = false;
        if(!isLicenseUnique) {
            removed = realtorLogImpl.remove(license);
        }
        if(removed) {
            System.out.println("Realtor with license " + license + 
                    " removed from list, deleting all properties " +
                    "associated with that realtor");
            
        }
        else {
            System.out.println("Error removing realtor with license " + 
                    license);
        }
    }
    
    public static void addProperty(String[] attribs) {
        int mls = Integer.parseInt(attribs[2]);        
        int zip = Integer.parseInt(attribs[7]);
        int numBedrooms = Integer.parseInt(attribs[8]);
        double numBathrooms = Double.parseDouble(attribs[9]);
        boolean isSold;
        if(attribs[10].toUpperCase().equals("Y")) {
            isSold = true;
        } else {
            isSold = false;
        }
        double askingPrice = Double.parseDouble(attribs[11]);
        Property property = new Property(mls, attribs[3], attribs[4],
            attribs[5], attribs[6], zip, numBedrooms, numBathrooms, isSold,
            askingPrice);
        boolean validMls = property.checkMlsNum();
        boolean validState = property.checkState();
        boolean validZip = property.checkZipCode();
        if(!validMls) {
            System.out.println("Error, mls " + property.getMls() + " is bad");
        }
        if(!validState) {
            System.out.println("Error, bad state code, " + property.getState()
                + " for mls " + property.getMls());
        }
        if(!validZip) {
            System.out.println("Error, bad zip code, " + property.getZip() +
                    " for mls " + property.getZip());
        }
        boolean isRealtorUnique = realtorLogImpl.isLicenseUnique(attribs[3]);
        boolean isPropertyUnique = propertyLogImpl.isMlsUnique(mls);
        if(!isRealtorUnique && isPropertyUnique) {
            propertyLogImpl.add(property);
            System.out.println("Property with mls number " + mls + " added");
        }
        else {
            String errMsg = "Error, ";
            if(isRealtorUnique) {
                errMsg += "non-existant realtor for this property. ";
            } else if(!isPropertyUnique) {
                errMsg += "Property already exists. ";
            }
            errMsg += " Property will not be added";
            System.out.println(errMsg);
        }
    }
    
    public static void deleteProperty(int mls) {
        boolean isPropertyUnique = propertyLogImpl.isMlsUnique(mls);
        if(!isPropertyUnique) {
            propertyLogImpl.remove(mls);
        }
        else {
            System.out.println("Property with mls " + mls + " not found");
        }
    }

    
}
