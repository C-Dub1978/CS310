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
 * @version x Java Assn 6
 */
public class CS310Wilson {
    static RealtorLogImpl realtorLogImpl = new RealtorLogImpl();
    static PropertyLogImpl propertyLogImpl = new PropertyLogImpl();
    static final String REQUESTS_FILE = "input/realtorRequests.txt";
    
    /**
     * Main method, entry to program, calls method to process data then
     *  generate report
     * @param args
     */
    public static void main(String[] args) {        
        processDataFile();
        realtorLogImpl.traverseDisplay();
        System.out.println();
        propertyLogImpl.traverseDisplay();
        System.out.println();
        generateReport();
    }    
    
    /**
     * Method to process the data file
     */
    public static void processDataFile() {
        final String INPUT_FILENAME = "input/assn6input1.txt";
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
                    //deleteRealtor(dataLine[2]);
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
                    //deleteProperty(Integer.parseInt(dataLine[2]));
                }
                else {
                    
                }
            } else {
                // not realtor or property in the first token
                System.out.println("\tNeither realtor, nor property in first"
                        + " token");
            }
        }
        inputScanner.close();
    }
    
    /**
     * Method to add a realtor to the realtor log
     * @param attribs, string array from csv file
     */
    public static void addRealtor(String[] attribs) {           
        double commission = Double.parseDouble(attribs[6]);
        Realtor realtor = new Realtor(attribs[2], attribs[3], attribs[4],
        attribs[5], commission);        
        String added = realtorLogImpl.add(realtor) ? "added" : "not added";
        System.out.println("Realtor " + added);        
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
        String added = propertyLogImpl.add(property) ? "added" : "not added";
        System.out.println("Property " + added);
    }
    
   

    /**
     * Method to generate a report from the PrintImpl class
     * 
     * @param filename, name of the output file name
     */
    public static void generateReport() {
            PrintImpl printer = new PrintImpl(realtorLogImpl, propertyLogImpl);
            printer.generateReport(REQUESTS_FILE);
    }
    
}
