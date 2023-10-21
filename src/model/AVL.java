package model;

import java.util.LinkedList;
import java.util.Queue;

public class AVL<K extends Comparable<K>, V> implements IAVL<K, V> {
	private Node<K,V> root;
	
	
	@Override
	public void insertNode(K key, V value) {
		root = insertNode(root, key, value);
	}
	
    public Node<K, V> insertNode(Node<K, V> node, K key, V value) {
        if (node == null) {
            return new Node<>(key, value);
        }

        if (key.compareTo(node.getKey()) < 0) {
            node.setLeft(insertNode(node.getLeft(), key, value));
        } else if (key.compareTo(node.getKey()) > 0) {
            node.setRight(insertNode(node.getRight(), key, value));
        } else {
            // Si la clave ya existe, actualiza el valor
            node.setValue(value);
            return node;
        }

        // Realizar el rebalanceo si es necesario
        node = AVLRebalance(node);

        return node;
    }

	@Override
	public void delete(K key) {
		root = delete(root, key);
	}
	
	private Node<K, V> delete(Node<K, V> node, K key) {
	    if (node == null) {
	        return null;
	    }

	    if (key.compareTo(node.getKey()) < 0) {
	        node.setLeft(delete(node.getLeft(), key));
	    } else if (key.compareTo(node.getKey()) > 0) {
	        node.setRight(delete(node.getRight(), key));
	    } else {
	        // Caso 1: Nodo con uno o ningún hijo
	        if (node.getLeft() == null || node.getRight() == null) {
	            Node<K, V> temp = null;
	            if (node.getLeft() != null) {
	                temp = node.getLeft();
	            } else {
	                temp = node.getRight();
	            }

	            if (temp == null) {
	                // Caso Nodo hoja
	                temp = node;
	                node = null;
	            } else {
	                // Caso Nodo con un hijo
	                node = temp;
	            }
	        } else {
	            // Caso Nodo con ddos hijos
	            Node<K, V> successor = findMin(node.getRight());
	            node.setKey(successor.getKey());
	            node.setValue(successor.getValue());
	            node.setRight(delete(node.getRight(), successor.getKey()));
	        }
	    }

	    if (node != null) {
	        node = AVLRebalance(node);
	    }

	    return node;
	}

	public Node<K, V> findMin(Node<K, V> node) {
	    while (node.getLeft() != null) {
	        node = node.getLeft();
	    }
	    return node;
	}

	@Override
	public Node<K, V> AVLRebalance(Node<K, V> node) {
	    int balance = getBalance(node);

	    if (balance > 1) {
	        if (getHeight(node.getLeft().getLeft()) >= getHeight(node.getLeft().getRight())) {
	            node = rightRotation(node);
	        } else {
	            node.setLeft(leftRotation(node.getLeft()));
	            node = rightRotation(node);
	        }
	    } else if (balance < -1) {
	        if (getHeight(node.getRight().getRight()) >= getHeight(node.getRight().getLeft())) {
	            node = leftRotation(node);
	        } else {
	            node.setRight(rightRotation(node.getRight()));
	            node = leftRotation(node);
	        }
	    }

	    return node;
	}
	
	private int getHeight(Node<K, V> node) {
	    return (node == null) ? 0 : 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
	}

	private int getBalance(Node<K, V> node) {
	    return (node == null) ? 0 : getHeight(node.getLeft()) - getHeight(node.getRight());
	}

	public Node<K, V> rightRotation(Node<K, V> y) {
	    Node<K, V> x = y.getLeft();
	    Node<K, V> T = x.getRight();

	    x.setRight(y);
	    y.setLeft(T);

	    return x;
	}

	public Node<K, V> leftRotation(Node<K, V> x) {
	    Node<K, V> y = x.getRight();
	    Node<K, V> T = y.getLeft();

	    y.setLeft(x);
	    x.setRight(T);

	    return y;
	}

	@Override
	public String printTreeByLevel() {
        if (root == null) return "";

        StringBuilder result = new StringBuilder();
        Queue<Node<K, V>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node<K, V> current = queue.poll();
                result.append("(").append(current.getKey()).append(", ").append(current.getValue()).append(") ");
                if (current.getLeft() != null) queue.add(current.getLeft());
                if (current.getRight() != null) queue.add(current.getRight());
            }
            result.append("\n");
        }

        return result.toString();
    }


}