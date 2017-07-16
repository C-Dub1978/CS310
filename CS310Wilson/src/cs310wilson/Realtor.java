
/**
 * This is a class used by the Main program
 */
package cs310wilson;

import java.util.Objects;

/** Realtor class, class object used to store data attributes about the specified realtor
 *
 * @author Chris Wilson
 * @version x Java Assn 1
 */
public class Realtor {
    private String licenseNum;
    private String firstName;
    private String lastName;
    private String phoneNum;
    private double commission;

    /**  Constructor, parameterized
     *
     * @param licenseNum, the realtors license number
     * @param firstName, the first name
     * @param lastName, the last name
     * @param phoneNum, the phone number
     * @param commission, the realtor's commission
     */
    public Realtor(String licenseNum, String firstName, String lastName,
                   String phoneNum, double commission) {
        this.licenseNum = licenseNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.commission = commission;
    }

    /** Default constructor
     *
     */
    public Realtor() {
        this.licenseNum = "";
        this.firstName = "";
        this.lastName = "";
        this.phoneNum = "";
        this.commission = 0.0D;
    }

    /** Getter to return license number data field
     *
     * @return licenseNum, the data field
     */
    public String getLicenseNum() {
        return licenseNum;
    }

    /** Setter for license number
     *
     * @param licenseNum, the license number to set
     */
    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    /** Getter, for first name
     *
     * @return firstName, the data field
     */
    public String getFirstName() {
        return firstName;
    }

    /** Setter, for first name
     *
     * @param firstName, first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /** Getter, for the last name data field
     *
     * @return lastName, the data field
     */
    public String getLastName() {
        return lastName;
    }

    /** Setter, for the last name
     *
     * @param lastName, last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /** Getter, for the phone number
     *
     * @return phoneNum, the data field
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /** Setter, for the phone number
     *
     * @param phoneNum, phone number to set
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    /** Getter, for the commission data field
     *
     * @return commission, the data field
     */
    public double getCommission() {
        return commission;
    }

    /** Setter, for the commission
     *
     * @param commission, commission to set
     */
    public void setCommission(double commission) {
        this.commission = commission;
    }
    
    /** Override .equals method, checks for object equality
     * 
     * @param obj, the object to test for equality with 'this'
     * @return boolean value for equality
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
        final Realtor other = (Realtor) obj;
        if (Double.doubleToLongBits(this.commission) != Double.doubleToLongBits(other.commission)) {
            return false;
        }
        if (!Objects.equals(this.licenseNum, other.licenseNum)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.phoneNum, other.phoneNum)) {
            return false;
        }
        return true;
    }

    /** Overridden .toString method, for converting the object into a readable string form
     * 
     * @return readable string with all data attributes
     */
    @Override
    public String toString() {
        return "Realtor{" + "licenseNum=" + licenseNum + ", firstName=" + firstName + ","
                + " lastName=" + lastName + ", phoneNum=" + phoneNum + ", commission=" + commission + '}';
    }

    /** Method to validate the realtor license in length and format
     *
     * @return boolean value of validity of license
     */
    public boolean checkRealtorLicense() {
        // First check length
        if(licenseNum.length() != 9) {
            return false;
        } else {
            // Length is good, split the first 2 characters into a char
            //  array, and the last 7 into a substring
            char[] letters = licenseNum.substring(0, 2).toCharArray();
            String lastSeven = licenseNum.substring(2, 9);
            // Use Character class method to verify if it's a character
            if(!Character.isLetter(letters[0]) ||
                    !Character.isLetter(letters[1])) {
                return false;
            }
            // Can we parse the last 7 digits as an integer?
            try {
                int parseLastSeven = Integer.parseInt(lastSeven);
                // Nope, catch the exception, and return false
            } catch(NumberFormatException e) {                
                return false;
            }
        }
        // All conditions have passed, the string is 2 letters followed by 7
        //  numbers
        return true;
    }

    /** Method to validate the phone number in length and format
     *
     * @return boolean value of phone number validity
     */
    public boolean checkPhoneNumber() {
        // declare local vars
        int firstParse = 0;
        int secondParse = 0;
        int thirdParse = 0;
        // Is it the right length?
        if(phoneNum.length() != 12) {
            return false;
        } else {
            // Split the string out into 5 substrings, then make sure we have xxx-xxx-xxxx format with valid
            //  integers inbetween the dashes
            String areaCode = phoneNum.substring(0, 3);
            String first3 = phoneNum.substring(4, 7);
            String last4 = phoneNum.substring(8, 12);
            String firstDash = phoneNum.substring(3, 4);
            String secondDash = phoneNum.substring(7, 8);           
            if(!firstDash.equals("-") || !secondDash.equals("-")) {
                return false;
            } else {
                try {
                    firstParse = Integer.parseInt(areaCode);
                } catch(NumberFormatException e) {                    
                    return false;
                }
                try {                    
                    secondParse = Integer.parseInt(first3);
                } catch(NumberFormatException e) {                    
                    return false;
                }
                try {
                    thirdParse = Integer.parseInt(last4);
                } catch(NumberFormatException e) {                    
                    return false;
                }
            }
        }
        // valid phone number in xxx-xxx-xxxx format with no strings inbetween the dashes
        return true;
    }
}

