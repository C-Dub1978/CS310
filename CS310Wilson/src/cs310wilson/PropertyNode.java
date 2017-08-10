/*
 *Property Node class for working with the hash map
 */
package cs310wilson;

/** This node class stores a property, and a link to the next node
 *
 * @author Chris Wilson
 * @version java assn 5
 */
public class PropertyNode {
    private Property property;
    private PropertyNode nextNode;
    
    /** Default constructor
     *
     */
    public PropertyNode() {
        property = null;
        nextNode = null;
    }
    
    /** Setter, to set property
     *
     * @param p, the property to set
     */
    public void setProperty(Property p) {
        property = p;
    }
    
    /** Getter, to get the property
     *
     * @return property, the data field
     */
    public Property getProperty() {
        return property;
    }
    
    /** Setter, to set next node
     *
     * @param p, the property node to set next
     */
    public void setNext(PropertyNode p) {
        nextNode = p;
    }
    
    /** Getter, get next property node
     *
     * @return nextNode, the data field
     */
    public PropertyNode getNext() {
        return nextNode;
    }
    
    /** Method to see if there is a next node
     *
     * @return boolean value of operation
     */
    public boolean hasNext() {
        return nextNode != null;
    }
    
}


