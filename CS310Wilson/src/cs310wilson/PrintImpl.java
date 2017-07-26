/*
 * Class used to iterate through the realtor and property array, and 
 * generate and output file report on all realtor/property data
 */
package cs310wilson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * PrintImpl class for report generation
 * @author Chris Wilson
 * @version java assn 2
 */
public class PrintImpl {
    private RealtorLogImpl realtorList;
    LinkedList<Property> propertyList;
    int countOfProperties;    
    
    /**
     * Constructor
     * @param realtors, the realtors ArrayList
     * @param properties, the properties array
     * @param count, number of properties total
     */
    public PrintImpl(RealtorLogImpl realtors, LinkedList<Property> properties, 
            int count) {
        realtorList = realtors;
        propertyList = properties;
        countOfProperties = count;        
    }   
    
    /**
     * Method to generate the report by iterating through both logs
     * 
     * @param filename, name of the output file to write to
     */
    public void generateReport(String filename) {
        double totalValueForAll = 0.0D;        
        PrintWriter outputWriter = null;
        try {
            File fileOut = new File(filename);
            outputWriter = new PrintWriter(fileOut);
        } catch(FileNotFoundException e) {
            System.err.println("Error opening output file " +
                    filename);
        }        
        outputWriter.println();        
        for(int i = 0; i < realtorList.getSize(); i++) {
            Realtor realtor = realtorList.getRealtor(i);            
            double allPropertiesValue = 0.0D;
            int allPropertiesCount = 0;
            String realtorLicense = realtor.getLicenseNum();
            String last = realtor.getLastName();
            String first = realtor.getFirstName();
            outputWriter.println(realtorLicense + "\t" + last + ", " + first);            
            outputWriter.println();            
            for(int j = 0; j < propertyList.size(); j++) {
                Property p = propertyList.get(j);                               
                if(p.getRealtorLicenseNum().equals(realtorLicense)) {                    
                    int mls = p.getMls();
                    String address = p.getStreetAddress();
                    String city = p.getCity();
                    String state = p.getState();
                    int zip = p.getZip();
                    int bedrooms = p.getNumBedrooms();
                    double bathrooms = p.getNumBathrooms();
                    double price = p.getAskingPrice();
                    String sold = p.isSold() ? "SOLD" : "";
                    allPropertiesValue += price;
                    allPropertiesCount++;
                    totalValueForAll += price;
                    outputWriter.printf("\t%d\t%20s, %10s, %s %d %d/%.1f %.2f %s\n",
                            mls, address, city, state, zip, bedrooms,
                            bathrooms, price, sold);                      
                }
            }
            outputWriter.println("\n\tNumber of property listings for realtor: " +
                    allPropertiesCount);
            outputWriter.println("\tTotal sales value of property listings for "
                    + "realtor: " + allPropertiesValue);            
            outputWriter.println();            
        }
        outputWriter.println("Total number of properties for all realtors: " +
                            propertyList.size());
        outputWriter.printf("Total value of all realtors: %.2f", totalValueForAll);
        outputWriter.close();        
    }    
    
}
