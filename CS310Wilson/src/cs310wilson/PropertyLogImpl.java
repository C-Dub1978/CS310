/*
 * This class is used to keep a tree map of all properties for all realtors,
 * and has some getters/setters and methods to access data
 */
package cs310wilson;

import java.util.Collection;
import java.util.TreeMap;

/**
 * PropertyLog class
 * @author Chris Wilson
 * @version java assn 6
 */
public class PropertyLogImpl {
    private TreeMap<Integer, Property> treeMap;
    
    /**
     * Constructor, default
     */
    public PropertyLogImpl() {
        treeMap = new TreeMap();
    }
    
    /** Add method, to push a property object into the treemap
     *
     * @param p, the property object
     * @return boolean value of operation
     */
    public boolean add(Property p) {
        Property returnProperty = treeMap.put(p.getMls(), p);
        return returnProperty == null;
    }
    
    /** Find method, to search the tree for an mls instance
     *
     * @param mls, the key to search for
     * @return the value associated with the key, if exists
     */
    public Property find(int mls) {
        return treeMap.get(mls);
    }    
    
    /** Method to traverse the display
     *
     */
    public void traverseDisplay() {
        System.out.println("Property List: ");        
        Collection<Property> values = treeMap.values();
        for(Property p: values) {
            System.out.println("\tProperty: " + p.toString());
        }
    }
}
