/*
 * This class is used to keep an array of all properties for all realtors,
 * and has some getters/setters and methods to access data
 */
package cs310wilson;

import java.util.HashMap;


/**
 * PropertyLog class
 * @author Chris Wilson
 * @version java assn 2
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
    
    public int createHashFromMls(int mls) {
        return mls % MAP_MAXIMUM_SIZE;
    }
    
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

    public Property find(int mls) {
        int key = createHashFromMls(mls);  
        boolean found = false;
        PropertyNode walkNode = null;
        if(map.get(key) != null) {
            MapEntry m = map.get(key);
            PropertyNode p = m.getPropertyNode();
            if(p.getProperty().getMls() == mls) {
                System.out.println("Property " + p.getProperty().
                        getMls() + " found at index: " + key);
                return p.getProperty();
            }
            else {
                if(p.hasNext()) {
                    while(p.getNext() != null && !found) {
                        walkNode = p.getNext();
                        if(walkNode.getProperty().getMls() == mls) {
                            found = true;
                            System.out.println("Property " + walkNode.
                                    getProperty().getMls() + " found at " +
                                    "index " + key);
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
    
    public PropertyNode linkNodes(PropertyNode p, PropertyNode addNode) {
        PropertyNode currentNode = p;        
        if(p.getNext() == null) {
            p.setNext(addNode);
            return p;
        }
        else {
            System.out.println("Running through linking loop");
            while(currentNode.getNext() != null) {
                currentNode = p.getNext();
            }
            currentNode.setNext(addNode);
        }
        return p;
    }
    
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
