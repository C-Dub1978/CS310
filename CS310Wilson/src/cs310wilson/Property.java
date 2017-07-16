/** Class used by the main program to build a property object and store it's data
 * 
 */
package cs310wilson;

import java.util.Objects;

/** Property class object, accepts and stores data about a specific property 
 *
 * @author Chris Wilson
 * @version x Java Assn 1
 */
public class Property {
    private int mls;
    private String realtorLicenseNum;
    private String streetAddress;
    private String city;
    private String state;
    private int zip;
    private int numBedrooms;
    private double numBathrooms;
    private boolean isSold;
    private double askingPrice;

    /** Parameterized constructor to build the object
     *
     * @param mls, the property number
     * @param realtorLicenseNum, the license number of the assigned realtor
     * @param streetAddress, full address of property
     * @param city, city
     * @param state, state, two letters only
     * @param zip, zip code
     * @param numBedrooms, the number of bedrooms
     * @param numBathrooms, the number of bathrooms
     * @param isSold, boolean value of sale status
     * @param askingPrice, the going price of the flat
     */
    public Property(int mls, String realtorLicenseNum, String streetAddress,
                    String city, String state, int zip, int numBedrooms,
                    double numBathrooms, boolean isSold, double askingPrice) {
        this.mls = mls;
        this.realtorLicenseNum = realtorLicenseNum;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state.toUpperCase();
        this.zip = zip;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.isSold = isSold;
        this.askingPrice = askingPrice;
    }

    /** Default constructor
     *
     */
    public Property() {
        this.mls = 0;
        this.realtorLicenseNum = "";
        this.streetAddress = "";
        this.city = "";
        this.state = "";
        this.zip = 0;
        this.numBedrooms = 0;
        this.numBathrooms = 0;
        this.isSold = false;
        this.askingPrice = 0.0D;
    }

    /** Getter, for mls data field
     *
     * @return mls, the data field
     */
    public int getMls() {
        return mls;
    }

    /** Setter, for mls number
     *
     * @param mls, for the data field
     */
    public void setMls(int mls) {
        this.mls = mls;
    }

    /** Getter, for license number data field
     *
     * @return realtorLicenseNum, the data field
     */
    public String getRealtorLicenseNum() {
        return realtorLicenseNum;
    }

    /** Setter, for license number
     *
     * @param realtorLicenseNum, for the data field
     */
    public void setRealtorLicenseNum(String realtorLicenseNum) {
        this.realtorLicenseNum = realtorLicenseNum;
    }

    /** Getter, for address data field
     *
     * @return streetAddress, the data field
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /** Setter, for address
     *
     * @param streetAddress, for the data field
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /** Getter, for city data field
     *
     * @return city, the data field
     */
    public String getCity() {
        return city;
    }

    /** Setter, for city
     *
     * @param city, for the data field
     */
    public void setCity(String city) {
        this.city = city;
    }

    /** Getter, for state data field
     *
     * @return state, the data field
     */
    public String getState() {
        return state;
    }

    /** Setter, for state
     *
     * @param state, the data field
     */
    public void setState(String state) {
        this.state = state.toUpperCase();
    }

    /** Getter, for zip code data field
     *
     * @return zip, the data field
     */
    public int getZip() {
        return zip;
    }

    /** Setter, for zip
     *
     * @param zip, the data field
     */
    public void setZip(int zip) {
        this.zip = zip;
    }

    /** Getter, for bedrooms data field
     *
     * @return numBedrooms, the data field
     */
    public int getNumBedrooms() {
        return numBedrooms;
    }

    /** Setter, for bedrooms
     *
     * @param numBedrooms, the data field
     */
    public void setNumBedrooms(int numBedrooms) {
        this.numBedrooms = numBedrooms;
    }

    /** Getter, for bathrooms data field
     *
     * @return numBathrooms, the data field
     */
    public double getNumBathrooms() {
        return numBathrooms;
    }

    /** Setter, for bathrooms
     *
     * @param numBathrooms, the data field
     */
    public void setNumBathrooms(double numBathrooms) {
        this.numBathrooms = numBathrooms;
    }

    /** Getter, for sold data field
     *
     * @return isSold, the data field
     */
    public boolean isSold() {
        return isSold;
    }

    /** Setter, for sold
     *
     * @param sold, the data field
     */
    public void setSold(boolean sold) {
        isSold = sold;
    }

    /** Getter, for asking price data field
     *
     * @return askingPrice, the data field
     */
    public double getAskingPrice() {
        return askingPrice;
    }

    /** Setter, for askingPrice
     *
     * @param askingPrice, the data field
     */
    public void setAskingPrice(double askingPrice) {
        this.askingPrice = askingPrice;
    }    

    /** Method to validate the mls number data field
     *
     * @return boolean value of validity of mls number
     */
    public boolean checkMlsNum() {
        String mlsString = "";
        try {
            mlsString = Integer.toString(mls);
        } catch(NumberFormatException e) {
            return false;
        }       
        if(mlsString.length() != 7) {
            return false;
        }
        return true;
    }

    /** Method to check that the state is a valid 2 character string, either CO or WY
     *
     * @return boolean value of validity of state
     */
    public boolean checkState() {
        if(!state.equals("CO") && !state.equals("WY")) {
            return false;
        }
        return true;
    }

    /** Method to validate the zip code, making sure its an integer and is 5 digits, starting with only
     *   80, 81, 82, or 83
     *
     * @return boolean value of validity of zip code
     */
    public boolean checkZipCode() {
        String zipString = Integer.toString(zip);
        // Is it 5 digits?
        if(zipString.length() != 5) {
            return false;
        } else {
            // Does it start with an 8?
            if(zipString.charAt(0) != '8') {
                return false;
            } else {
                // Is the second character a 0, 1, 2, or 3?
                if(zipString.charAt(1) != '0' && zipString.charAt(1) != '1' &&
                        zipString.charAt(1) != '2' && zipString.charAt(1)
                        != '3') {
                    return false;
                }
            }
        }
        // All conditionals satisfactory, zip code is valid
        return true;
    }    

    /** Overridden .equals method, checks for object validity with 'this'
     * 
     * @param obj, the object to compare with 'this'
     * @return boolean value of object validity
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Property other = (Property) obj;
        if (this.mls != other.mls) {
            return false;
        }
        if (this.zip != other.zip) {
            return false;
        }
        if (this.numBedrooms != other.numBedrooms) {
            return false;
        }
        if (Double.doubleToLongBits(this.numBathrooms) != Double.doubleToLongBits(other.numBathrooms)) {
            return false;
        }
        if (this.isSold != other.isSold) {
            return false;
        }
        if (Double.doubleToLongBits(this.askingPrice) != Double.doubleToLongBits(other.askingPrice)) {
            return false;
        }
        if (!Objects.equals(this.realtorLicenseNum, other.realtorLicenseNum)) {
            return false;
        }
        if (!Objects.equals(this.streetAddress, other.streetAddress)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        return true;
    }

    /** Overridden .toString method, to display this object's attributes
     * 
     * @return String representation of all object attributes
     */
    @Override
    public String toString() {
        return "Property{" + "mls=" + mls + ", realtorLicenseNum=" + realtorLicenseNum + ", "
                + "streetAddress=" + streetAddress + ", city=" + city + ", state=" + state + ","
                + " zip=" + zip + ", numBedrooms=" + numBedrooms + ", numBathrooms=" + numBathrooms + ", "
                + "isSold=" + isSold + ", askingPrice=" + askingPrice + '}';
    }    
}

