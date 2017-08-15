/*
 * Class for keeping track of the BST of realtors and various
 * functionality
 */
package cs310wilson;

/**
 * Realtor log class
 * @author Chris Wilson
 * @version java assn 6
 */
public class RealtorLogImpl {
    private Node<Realtor> rootNode;
    private int size;
    
    /**
     * Default constructor
     */
    public RealtorLogImpl() {
        rootNode = null;
        size = 0;
    }
    
    /** Getter, for the root tree node
     *
     * @return the root node
     */
    public Node<Realtor> getRoot() {
        return rootNode;
    }
    
    /** Add method, to add a realtor to the tree
     *
     * @param r, the realtor object
     * @return boolean value of operation
     */
    public boolean add(Realtor r) {
        Node<Realtor> newNode = new Node("REALTOR");
        newNode.setData(r);
        newNode.setKey(r.getLicenseNum());
        boolean added = false;
        
        if(rootNode == null) {
            rootNode = newNode;
            size++;
            added = true;
        }        
        else {
           added = insert(rootNode, newNode); 
        }
        return added;
    }
    
    /** Helper method for the add method, traverses tree until it finds 
     * a spot for the new node, using recursion
     *
     * @param root, the subtree to compare
     * @param newNode, the node to be inserted
     * @return boolean value of operation
     */
    public boolean insert(Node<Realtor> root, Node<Realtor> newNode) {
        boolean added = false;
        if(root != null) {
            if(root.getData().compareToLicense(newNode.getData()) > 0) {                
                if(root.getLeft() == null) {
                    root.setLeft(newNode);
                    size++;
                    added = true;
                }
                else {
                return insert(root.getLeft(), newNode);
                }
            }
            else if(root.getData().compareToLicense(newNode.getData()) < 0) {                
                if(root.getRight() == null) {
                    root.setRight(newNode);
                    size++;
                    added = true;
                }
                else {
                return insert(root.getRight(), newNode);
                }
            }            
        }
        return added;
    }
    
    /** Method to find a realtor by license
     *
     * @param license, the realtor license to search for
     * @return the Realtor object, if found, or null if not found
     */
    public Realtor find(String license) {
        if(license != null) {
            if(rootNode != null) {
                return find(rootNode, license);                
            }
            
        }
        return null;
    }
    
    /** Helper method for the find method above, overloaded
     *
     * @param root, the subtree to compare
     * @param license, the license to search for
     * @return the Realtor object, if found, or null if not found
     */
    public Realtor find(Node<Realtor> root, String license) {
        if(root != null) {
            if(root.getData().getLicenseNum().equals(license)) {
                return root.getData();
            }
            else {
                if(root.getData().compareToLicense(license) > 0) {
                    return find(root.getLeft(), license);
                }
                else if(root.getData().compareToLicense(license) < 0) {
                    return find(root.getRight(), license);
                }
            }
        }
        return null;
    }
    
    /** Method to traverse the display
     *
     * @param n, root/subtree node
     */
    public void traverseDisplay() {
        System.out.println("Realtor List: ");        
        traverseDisplayHelper(rootNode);
    }
    
    public void traverseDisplayHelper(Node n) {      
        if(n != null) {
             traverseDisplayHelper(n.getLeft());            
            System.out.println("\tData: " + n.getData().toString());        
            traverseDisplayHelper(n.getRight());
        }
    }
    
    /** Method to clear the whole tree
     *
     */
    public void clear() {
        rootNode = null;
        size = 0;
    }
    
    /** Getter, for the size of the tree
     *
     * @return size, the data field
     */
    public int getSize() {
        return size;
    }
}
