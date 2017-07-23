/*
 * Class used to iterate through the realtor and property array, and 
 * generate and output file report on all realtor/property data
 */
package cs310wilson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * PrintImpl class for report generation
 * @author Chris Wilson
 * @version java assn 2
 */
public class PrintImpl {
    private ArrayList<Realtor> realtorList;
    Property[] propertyList;
    int countOfProperties;
    final String OUTPUT_FILE_NAME = "output/assn2report.txt";
    
    /**
     * Constructor
     * @param realtors, the realtors ArrayList
     * @param properties, the properties array
     * @param count, number of properties total
     */
    public PrintImpl(ArrayList<Realtor> realtors, Property[] properties, 
            int count) {
        realtorList = realtors;
        propertyList = properties;
        countOfProperties = count;        
    }
    
    /**
     * Method to generate the report by iterating through both logs
     */
    public void generateReport() {
        double totalValueForAll = 0.0D;
        PrintWriter outputWriter = null;
        try {
            File fileOut = new File(OUTPUT_FILE_NAME);
            outputWriter = new PrintWriter(fileOut);
        } catch(FileNotFoundException e) {
            System.err.println("Error opening output file " +
                    OUTPUT_FILE_NAME);
        }        
        outputWriter.println();        
        for(int i = 0; i < realtorList.size(); i++) {
            Realtor realtor = realtorList.get(i);
            double allPropertiesValue = 0.0D;
            int allPropertiesCount = 0;
            String realtorLicense = realtor.getLicenseNum();
            String last = realtor.getLastName();
            String first = realtor.getFirstName();
            outputWriter.println(realtorLicense + "\t" + last + ", " + first);            
            outputWriter.println();
            for(int j = 0; j < propertyList.length; j++) {
                Property property = propertyList[j];
                if(property != null) {                    
                    if(property.getRealtorLicenseNum().equals(
                    realtor.getLicenseNum())) {
                        int mls = property.getMls();
                        String address = property.getStreetAddress();
                        int bedrooms = property.getNumBedrooms();
                        double bathrooms = property.getNumBathrooms();
                        double price = property.getAskingPrice();
                        String sold = property.isSold() == true ?
                                "SOLD" : "";
                        outputWriter.printf("\t%d\t%25s\t%d/%.2f\t$%.2f\t%s",
                                mls, address, bedrooms, bathrooms, price,
                                sold);
                        allPropertiesValue += price;
                        allPropertiesCount++;
                        outputWriter.println();
                    }
                } 
            }
            outputWriter.println("\n\tNumber of property listings for realtor: " +
                    allPropertiesCount);
            outputWriter.println("\tTotal sales value of property listings for "
                    + "realtor: " + allPropertiesValue);            
            outputWriter.println();            
        }        
        outputWriter.close();        
    }    
    
}
