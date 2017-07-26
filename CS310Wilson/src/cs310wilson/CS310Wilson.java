/*
 * This program will read a list of realtor and/or property data from a csv file, and try to create 
 * realtor and property objects with said data. It will help a real estate 
 * office in converting data from the csv
 * files into useful information, then it will write the data to a file
 */
package cs310wilson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** Main Class, reads the data from the specified file and builds objects with the data
 * 
 * @author Chris Wilson
 * @version x Java Assn 2
 */
public class CS310Wilson {
    static RealtorLogImpl realtorLogImpl = new RealtorLogImpl();
    static PropertyLogImpl propertyLogImpl = new PropertyLogImpl();
    static final String DIRTY_OUTPUT_FILENAME = "output/assn3initialReport.txt";
    static final String CLEAN_OUTPUT_FILENAME = "output/assn3cleanReport.txt";
    
    /**
     * Main method, entry to program, calls method to process data then
     *  generate report
     * @param args
     */
    public static void main(String[] args) {        
        processDataFile();
        generateReport(DIRTY_OUTPUT_FILENAME);
        realtorLogImpl.cleanUp();
        propertyLogImpl.cleanUp();
        generateReport(CLEAN_OUTPUT_FILENAME);
    }    
    
    /**
     * Method to process the data file
     */
    public static void processDataFile() {
        final String INPUT_FILENAME = "input/assn2input2.txt"; 
        File inputFile = null;
        Scanner inputScanner = null;
        System.out.println("Reading data from file: " + INPUT_FILENAME);
        System.out.println();
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
                System.out.println("\tNeither realtor, nor property in first"
                        + " token");
            }
        }        
    }
    
    /**
     * Method to add a realtor to the realtor log
     * @param attribs, string array from csv file
     */
    public static void addRealtor(String[] attribs) {           
        double commission = Double.parseDouble(attribs[6]);
        Realtor realtor = new Realtor(attribs[2], attribs[3], attribs[4],
        attribs[5], commission);
        boolean validLicense = realtor.checkRealtorLicense();
        boolean validPhone = realtor.checkPhoneNumber();
        boolean uniqueLicense = 
            realtorLogImpl.isLicenseUnique(realtor.getLicenseNum());
        if(!validLicense) {
            System.out.println("\t\tError, license " + realtor.getLicenseNum() +
                " is invalid");
        }
        if(!validPhone) {
            System.out.println("\t\tError, phone " + realtor.getPhoneNum() +
                " is invalid");
        }
        if(uniqueLicense) {
            realtorLogImpl.add(realtor);
            System.out.println("\tRealtor with license number " + 
                    realtor.getLicenseNum() + " added to log");
        } else {
            System.out.println("\t\tError, non-unique license number, " +
                    "realtor will not be added to log");
        }
              
    }
    
    /**
     * Method to attempt to delete a realtor from the log
     * @param license, the realtor license number
     */
    public static void deleteRealtor(String license) {
        boolean isLicenseUnique = realtorLogImpl.isLicenseUnique(license);
        boolean removed = false;
        if(!isLicenseUnique) {
            removed = realtorLogImpl.remove(license);
        }
        if(removed) {
            System.out.println("\tRealtor with license " + license + 
                    " removed from list, deleting all properties " +
                    "associated with that realtor");
            propertyLogImpl.remove(license);
        }
        else {
            System.out.println("\t\tError removing realtor with license " + 
                    license + ", they don't exist");
        }
    }
    
    /**
     * Method to try to add a property to the log
     * @param attribs, string array from csv file
     */
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
            System.out.println("\t\tError, mls " + property.getMls() + " is bad");
        }
        if(!validState) {
            System.out.println("\t\tError, bad state code, " + property.getState()
                + " for mls " + property.getMls());
        }
        if(!validZip) {
            System.out.println("\t\tError, bad zip code, " + property.getZip() +
                    " for mls " + property.getZip());
        }
        boolean isRealtorUnique = realtorLogImpl.isLicenseUnique(attribs[3]);
        boolean isPropertyUnique = propertyLogImpl.isMlsUnique(mls);
        if(!isRealtorUnique && isPropertyUnique) {
            propertyLogImpl.add(property);
            System.out.println("\tProperty with mls number " + mls + " added");
        }
        else {
            String errMsg = "\t\tError, ";
            if(isRealtorUnique) {
                errMsg += "non-existant realtor for this property. ";
            } else if(!isPropertyUnique) {
                errMsg += "Property already exists. ";
            }
            errMsg += " Property will not be added";
            System.out.println(errMsg);
        }
    }
    
    /**
     * Method to try to delete a property from the log
     * @param mls, the property mls number
     */
    public static void deleteProperty(int mls) {
        boolean isPropertyUnique = propertyLogImpl.isMlsUnique(mls);
        if(!isPropertyUnique) {
            boolean removed = propertyLogImpl.remove(mls);
            if(removed) {
                System.out.println("\tProperty with mls " + mls + " removed");
            } else {
                System.out.println("\t\tError removing property with mls " +
                        mls);
            }
        }
        else {
            System.out.println("\t\tError, Property with mls " + mls + 
                    " not found");
        }
    }

    /**
     * Method to generate a report from the PrintImpl class
     * 
     * @param filename, name of the output file name
     */
    public static void generateReport(String filename) {
        PrintImpl printer = new PrintImpl(realtorLogImpl,
            propertyLogImpl.getPropertyLog(), 
                propertyLogImpl.size());
        printer.generateReport(filename);        
    }
    
}
