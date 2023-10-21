package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import model.AVL;

public class AVLTest {

    public static AVL<Integer, Integer> graph;
   

    @Test
    public void  testCase1(){
        graph = new AVL<>();
        graph.insertNode(2, 0);
        graph.insertNode(3, 0);
        graph.insertNode(4, 0);
        graph.insertNode(-5, 0);
        graph.insertNode(-4, 0);
        graph.delete(4);
        graph.delete(-5);
        assertEquals(graph.printTreeByLevel(), "2 -4 3 ");

    }
    
    @Test
    public void testCase2(){
        graph = new AVL<>();
        graph.insertNode(7, 0);
        graph.insertNode(3, 0);
        graph.insertNode(5, 0);
        graph.insertNode(9, 0);
        graph.delete(5);
        assertEquals("7 3 9 ", graph.printTreeByLevel());

    }

    @Test
    public void testCase3(){
        graph = new AVL<>();
        graph.insertNode(2, 0);
        graph.insertNode(4, 0);
        graph.insertNode(3, 0);
        graph.insertNode(5, 0);
        graph.delete(2);
        assertEquals("4 3 5 ", graph.printTreeByLevel());
    }


    @Test
    public void testCase4(){
        graph = new AVL<>();
        graph.insertNode(20, 0);
        graph.insertNode(17, 0);
        graph.insertNode(7, 0);
        graph.insertNode(2, 0);
        graph.insertNode(3, 0);
        graph.insertNode(1, 0);
        graph.insertNode(0, 0);
        assertEquals("3 1 17 0 2 7 20 ", graph.printTreeByLevel());
    }

    @Test
    public void testCase5(){
        graph = new AVL<>();
        graph.insertNode(9, 0);
        graph.insertNode(18, 0);
        graph.insertNode(1, 0);
        graph.insertNode(-3, 0);
        graph.insertNode(-2, 0);
        graph.delete(18);
        graph.insertNode(5, 0);
        graph.delete(1);
        graph.insertNode(10, 0);
        graph.insertNode(15, 0);
        assertEquals("9 -2 10 -3 5 15 ", graph.printTreeByLevel());
    }
}