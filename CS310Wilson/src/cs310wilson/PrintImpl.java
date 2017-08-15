/*
 * Class for creating an output report, called on by main
 */
package cs310wilson;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/** Class that sets the logs as it's data fields then calls on one method
 * to write data
 *
 * @author Chris Wilson
 * @version java assn6
 */
public class PrintImpl {
    private RealtorLogImpl realtorLog;
    private PropertyLogImpl propertyLog;
    private final String outputFileName = "output/outputFile.txt";
    
    /** Constructor
     *
     * @param realtor, the realtor tree
     * @param property, the property tree
     */
    public PrintImpl(RealtorLogImpl realtor, PropertyLogImpl property) {
        realtorLog = realtor;
        propertyLog = property;
    }
    
    /** Method to generate and write the output report
     *
     * @param filename, the input file to search the data structures for
     */
    public void generateReport(String filename) {
        File inputFile;
        File outputFile;
        PrintWriter outputWriter = null;
        Scanner inputScanner = null;
        
        try {
            inputFile = new File(filename);
            outputFile = new File(outputFileName);
            outputWriter = new PrintWriter(outputFile);
            inputScanner = new Scanner(inputFile);
        } catch(IOException e) {
            System.out.println("Error with IO, can't create file");
        }
        while(inputScanner.hasNextLine()) {
            String[] line = inputScanner.nextLine().split(" ");
            Realtor realtor = realtorLog.find(line[0]);
            if(realtor != null) {
                outputWriter.println("Realtor " + realtor.getLicenseNum() + ", "
                        + realtor.getFirstName() + " " + realtor.getLastName());
                for(int i = 1; i < line.length; i++) {
                    Property p = propertyLog.find(Integer.parseInt(line[i]));
                    if(p != null) {
                        Double price = p.getAskingPrice();
                        String soldStatus = p.isSold() ? " Is SOLD" :
                                " Is available for $" + price;
                        outputWriter.println("\tProperty " + p.getMls() +
                                soldStatus);
                    }
                    else {
                        outputWriter.println();
                    }
                }
            }
        }
        outputWriter.close();
        inputScanner.close();
    }
}
