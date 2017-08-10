/*
 * Map Entry class used with the property log hash map
 */
package cs310wilson;

/**
 *
 * @author Chris Wilson
 * @version java assn 5
 */
public class MapEntry {
    private int key;
    private PropertyNode property;    
    
    /** Constructor
     *
     * @param num, the key to store
     * @param prop, the property node
     */
    public MapEntry(int num, PropertyNode prop) {
        key = num;
        property = prop;
    }
    
    /** Setter, set the key
     *
     * @param num, the key
     */
    public void setKey(int num) {
        key = num;
    }
    
    /** Getter, get the key
     *
     * @return key, the data field
     */
    public int getKey() {
        return key;
    }
    
    /** Setter, to set property node
     *
     * @param p, the property node
     */
    public void setPropertyNode(PropertyNode p) {
        property = p;
    }
    
    /** Getter, get the property node
     *
     * @return property, the data field
     */
    public PropertyNode getPropertyNode() {
        return property;
    }   
    
}
