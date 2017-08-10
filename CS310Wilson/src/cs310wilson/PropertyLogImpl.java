/*
 * This class is used to keep a hash map of all properties for all realtors,
 * and has some getters/setters and methods to access data
 */
package cs310wilson;

import java.util.HashMap;


/**
 * PropertyLog class
 * @author Chris Wilson
 * @version java assn 5
 */
public class PropertyLogImpl {
    private HashMap<Integer, MapEntry> map;
    private final int MAP_MAXIMUM_SIZE;
    private int current;
    
    /**
     * Constructor, default
     */
    public PropertyLogImpl() {
          MAP_MAXIMUM_SIZE = 17;          
          map = new HashMap(MAP_MAXIMUM_SIZE);
          current = 0;
    }
    
    /** Method to create hash key from mls number
     *
     * @param mls, the property mls number
     * @return the key
     */
    public int createHashFromMls(int mls) {
        return mls % MAP_MAXIMUM_SIZE;
    }
    
    /** Method to add property to hash map
     *
     * @param p, the property object to add
     * @return boolean value of operation
     */
    public boolean add(Property p) {
        boolean added = false;
        MapEntry newEntry;
        PropertyNode newNode = new PropertyNode();
        newNode.setProperty(p);
        int key = createHashFromMls(p.getMls());
        boolean containsEntry = map.containsKey(key);
        if(containsEntry) {
            MapEntry oldEntry = map.get(key);
            PropertyNode oldNode = oldEntry.getPropertyNode();
            oldNode = linkNodes(oldNode, newNode);
            oldEntry.setPropertyNode(oldNode);
            map.replace(key, oldEntry);
            added = true;
        }
        else {
            newEntry = new MapEntry(key, newNode);
            map.put(key, newEntry);
            added = true;
        }
        return added;
    }

    /** Method to find a property
     *
     * @param mls, the mls number of property
     * @return the property object, if found, or null
     */
    public Property find(int mls) {
        int key = createHashFromMls(mls);  
        boolean found = false;
        PropertyNode walkNode = null;
        if(map.get(key) != null) {
            MapEntry m = map.get(key);
            PropertyNode p = m.getPropertyNode();
            if(p.getProperty().getMls() == mls) {                
                return p.getProperty();
            }
            else {
                if(p.hasNext()) {
                    while(p.getNext() != null && !found) {
                        walkNode = p.getNext();
                        if(walkNode.getProperty().getMls() == mls) {
                            found = true;                            
                            return walkNode.getProperty();
                        }
                    }
                }
                else {
                    System.out.println("Property " + mls + " not found");
                }
            }
        }
        return null;
    }
    
    /** Method to add properties to a linked list if collisions occur
     *
     * @param p, the property node to link to
     * @param addNode, the new node to link to the above node
     * @return the original property node with new links
     */
    public PropertyNode linkNodes(PropertyNode p, PropertyNode addNode) {
        PropertyNode currentNode = p;        
        if(p.getNext() == null) {
            p.setNext(addNode);
            return p;
        }
        else {            
            while(currentNode.getNext() != null) {
                currentNode = p.getNext();
            }
            currentNode.setNext(addNode);
        }
        return p;
    }
    
    /** Method to display the hash map
     *
     */
    public void displayHash() {
        System.out.println("Property Hash Table:");
        for(int i = 0; i < MAP_MAXIMUM_SIZE; i++) {
            System.out.print("\tIndex " + i + ": ");            
            MapEntry entry = map.get(i);
            if(entry == null) {
                System.out.println("is empty");
            } else {
                PropertyNode node = entry.getPropertyNode();
                if(node.getNext() == null) {
                    System.out.println("contains Properties " + node.getProperty()
                    .getMls());
                }
                else {
                    
                   StringBuilder str = new StringBuilder("");
                   str.append(node.getProperty().getMls());
                   PropertyNode currentNode = node;
                   while(currentNode.getNext() != null) {                       
                       currentNode = currentNode.getNext();
                       str.append(" ");
                       str.append(currentNode.getProperty().getMls());
                   }
                    System.out.println("Contains Properties " + 
                            str.toString());
                }
            }
        }
    }    
}
