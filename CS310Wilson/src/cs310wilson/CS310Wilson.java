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
    
    /** main method
     *   tries to open the file and the scanner, reads the data line by line, and calls on both realtor or property
     *   constructors to attempt to build the corresponding objects, then verifies the data fields
     * @param args, the command line arguments
     */
    public static void main(String[] args) {     
        
    }    
    
    public static void processDataFile() {
        final String INPUT_FILENAME = "input/assn1input1.txt"; 
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
                    deleteProperty(dataLine[2]);
                }
                else {
                    
                }
            } else {
                // not realtor or property in the first token
            }
        }
    }
    
    public static void addRealtor(String[] attribs) {        
        double commission;
        Realtor realtor = null;
        try {
            commission = Double.parseDouble(attribs[6]);
            realtor = new Realtor(attribs[2], attribs[3], attribs[4],
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
        } catch (NumberFormatException e) {
            System.err.println("Error, couldn't parse commission, realtor " +
                    "with licenseNum " + attribs[2] + " not" +
                    " added");
        }        
    }
    
    public static void deleteRealtor(String license) {
        
    }
    
    public static void addProperty(String[] attribs) {
        
    }
    
    public static void deleteProperty(String mls) {
        
    }

    
}
