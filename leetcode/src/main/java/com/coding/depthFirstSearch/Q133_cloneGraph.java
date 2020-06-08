package com.coding.depthFirstSearch;

import java.util.*;

public class Q133_cloneGraph {
    public static void main(String[] args) {
        Q133_cloneGraph q133 = new Q133_cloneGraph();

        /*
            1 --- 2
            |     |
            4 --- 3
         */

        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();

        List<Node> l1 = new LinkedList<>();
        List<Node> l2 = new LinkedList<>();
        List<Node> l3 = new LinkedList<>();
        List<Node> l4 = new LinkedList<>();

        n1.val = 1;
        n1.neighbors = l1;

        n2.val = 2;
        n2.neighbors = l2;

        n3.val = 3;
        n3.neighbors = l3;

        n4.val = 4;
        n4.neighbors = l4;

        l1.add(n2);
        l1.add(n4);
        l2.add(n1);
        l2.add(n3);
        l3.add(n2);
        l3.add(n4);
        l4.add(n1);
        l4.add(n3);

        Node newNode = q133.cloneGraph(n1);

        printGraph(n1);

        System.out.println("--------------------------------");

        printGraph(newNode);
    }

    private static void printGraph(Node node) {
        Set<Node> set = new HashSet<>();
        printGraphHelper(node, set);
    }

    private static void printGraphHelper(Node node, Set<Node> set) {
        if (set.contains(node))
            return;
        set.add(node);

        System.out.print(node.val + " -> ");
        for (int i=0; i<node.neighbors.size(); i++){
            System.out.print(node.neighbors.get(i).val + " ");
        }
        System.out.println();

        for (int i=0; i<node.neighbors.size(); i++){
            printGraphHelper(node.neighbors.get(i), set);
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null)
            return node;

        if (node.neighbors == null)
            return new Node(node.val, null);

        HashMap<Node, Node> map = new HashMap<>();
        return cloneGraphHelper(node, map);
    }

    public Node cloneGraphHelper(Node node,  HashMap<Node, Node> map) {
        if(map.containsKey(node))
            return map.get(node);

        Node newNode = new Node(node.val, new LinkedList<Node>());

        map.put(node, newNode);

        for(int i=0; i<node.neighbors.size(); i++)
            newNode.neighbors.add(cloneGraphHelper(node.neighbors.get(i), map));

        return newNode;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}