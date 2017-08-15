/*
 * Generic Node class for use with the BST
 */
package cs310wilson;

/** Node class, for either a property or realtor
 *
 * @author Chris Wilson
 * @version java assn6
 * @param <E>
 */
public class Node<E> {
    private E data;
    private String key;
    private Node<E> left;
    private Node<E> right;
    private String type;
    
    /** Constructor
     *
     * @param t, the type - Property or Realtor
     */
    public Node(String t) {
        type = t;
    }
    
    /** Setter, for the key
     *
     * @param license, the key for license
     */
    public void setKey(String license) {
        key = license;
    }
    
    /** Setter, for the key
     *
     * @param mls, the key for mls
     */
    public void setKey(int mls) {
        key = Integer.toString(mls);
    }
    
    /** Getter, for the key
     *
     * @return key, the data field
     */
    public String getKey() {
        return key;
    }
    
    /** Setter, for the object data
     *
     * @param data, the object field
     */
    public void setData(E data) {
        this.data = data;
    }
    
    /** Getter, for the object data
     *
     * @return data, the data field
     */
    public E getData() {
        return data;
    }
    
    /** Setter, for left child node
     *
     * @param leftNode, the node to set left
     */
    public void setLeft(Node<E> leftNode) {
        left = leftNode;
    }
    
    /** Getter, the node left
     *
     * @return left, the data field
     */
    public Node<E> getLeft() {
        return left;
    }
    
    /** Setter, for right child node
     *
     * @param rightNode, the node to set right
     */
    public void setRight(Node<E> rightNode) {
        right = rightNode;
    }
    
    /** Getter, the node right
     *
     * @return right, the data field
     */
    public Node<E> getRight() {
        return right;
    }
    
    /** Method to check if it's a leaf node
     *
     * @return boolean value of operation
     */
    public boolean isLeafNode() {
        return left == null && right == null;
    }
    
    public String toString() {
        if(type == "PROPERTY") {
            Property p = (Property)data;
            return "Property: " + p.getMls();
        }
        else if(type == "REALTOR") {
            Realtor r = (Realtor)data;
            return "Realtor: " + r.getLicenseNum();
        }
        else {
            return "Unkown type";
        }
    }
    
}
