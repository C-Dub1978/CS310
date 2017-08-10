/*
 * Class used to iterate through the realtor and property tables, and 
 * generate and output file report on all realtor/property data
 */
package cs310wilson;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * PrintImpl class for report generation
 * @author Chris Wilson
 * @version java assn 5
 */
public class PrintImpl {
     private final String outputReport;
     private RealtorLogImpl realtorMap;
     private PropertyLogImpl propertyMap;
    
     /**
      * Constructor
      * @param realtors, the realtor hash table
      * @param properties, the property hash map
      */
     public PrintImpl(RealtorLogImpl realtors, PropertyLogImpl properties) {
         outputReport = "output/assn5SalesReport";
         realtorMap = realtors;
         propertyMap = properties;
     }
     
     /** Method to generate the report
      * 
      * @param input, the input file name 
      */
     public void generateReport(String input) {
         File outputFile = null;
         File inputFile = null;
         Scanner inputScanner = null;
         PrintWriter outputWriter = null;
         try {
             inputFile = new File(input);
             outputFile = new File(outputReport);
             inputScanner = new Scanner(inputFile);
             outputWriter = new PrintWriter(outputFile);
         }
         catch(IOException e) {
             System.out.println("Error opening file " + input);
         }
         while(inputScanner.hasNextLine()) {
             String[] dataLine = inputScanner.nextLine().split(" ");
             if(dataLine.length > 0) {                
                 Realtor r = realtorMap.find(dataLine[0]);
                 if(r != null) {
                     outputWriter.println("Realtor " + r.getLicenseNum() + 
                             ", " + r.getFirstName() + " " + r.getLastName());
                     for(int i = 1; i < dataLine.length; i++) {
                         Property p = propertyMap.
                                 find(Integer.parseInt(dataLine[i]));
                         if(p != null) {
                             String sold = p.isSold() ? " is SOLD" :
                                     " is available for $" + p.getAskingPrice();
                             outputWriter.println("\tProperty " + dataLine[i] +
                                     sold);
                         }
                     }
                 }
             }
         }
         inputScanner.close();
         outputWriter.close();
     }    
    
}
