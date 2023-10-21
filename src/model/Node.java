package model;
public class Node <K extends Comparable<K>, V>{
	
private  Node<K, V> parent;
private  Node<K, V> right;
private  Node<K, V> left;
private K key;
private V value;

	public Node(K key, V value) {
		this.key = key;
		this.value = value;
		this.parent=null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<K, V> getLeft() {
        return left;
    }

    public void setLeft(Node<K, V> left) {
        this.left = left;
	
    }

    public Node<K, V> getRight() {
       return right;
    }

    public void setRight(Node<K, V> right) {
        this.right = right;
    }

}
