package model;
public interface IAVL < K extends Comparable<K>,V> {

    void insertNode(K key,  V value);
    void delete(K key);
    Node<K,V>AVLRebalance(Node<K,V> current);
    Node<K,V>rightRotation(Node<K,V> current);
    Node<K,V>leftRotation(Node<K,V> current);
    String printTreeByLevel();
}
