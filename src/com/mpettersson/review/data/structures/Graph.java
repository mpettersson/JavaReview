package com.mpettersson.review.data.structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

enum State {Unvisited, Visited, Visiting;}

public class Graph {
    public ArrayList<GNode> graph;

    public Graph(){
        graph = new ArrayList<>();
    }

    public ArrayList<GNode> getNodes(){
        return graph;
    }

    public void addNode(GNode node){
        graph.add(node);
    }

    public void addNodes(ArrayList<GNode> nodes){
        graph.addAll(nodes);
    }

}

class GNode {
    public State state;
    public String name;
    public ArrayList<GNode> children;

    public GNode(String name){
        this.name = name;
        children = new ArrayList<>();
    }

    public ArrayList<GNode> getAdjacent(){
        return children;
    }

    public void addAdjacent(GNode n){
        children.add(n);
    }

    public void addAdjacent(ArrayList<GNode> nodes){
        children.addAll(nodes);
    }
}

class GraphDriver{
    public static void main(String[] args) {
        Graph graph = new Graph();
        GNode node0 = new GNode("node0");
        GNode node1 = new GNode("node1");
        GNode node2 = new GNode("node2");
        GNode node3 = new GNode("node3");
        GNode node4 = new GNode("node4");
        GNode node5 = new GNode("node5");
        node0.addAdjacent(node1);
        node0.addAdjacent(node4);
        node0.addAdjacent(node5);
        node1.addAdjacent(node3);
        node1.addAdjacent(node4);
        node2.addAdjacent(node1);
        node3.addAdjacent(node2);
        node3.addAdjacent(node4);
        graph.addNodes(new ArrayList<>(Arrays.asList(new GNode[]{node0, node1, node2, node3, node4, node5})));


        // TestClass Search
        System.out.println(search(graph, node0, node0));
        System.out.println(search(graph, node0, node3));
        System.out.println(search(graph, node3, node1));
        System.out.println(search(graph, node3, node0));

    }

    public static boolean search(Graph g, GNode start, GNode end){
        if(start == end) return true;

        // BFS Operates as Queue
        LinkedList<GNode> q = new LinkedList<>();

        for(GNode u : g.getNodes()){
            u.state = State.Unvisited;
        }
        start.state = State.Visiting;
        q.add(start);
        GNode u;
        while(!q.isEmpty()){
            u = q.removeFirst(); // i.e., Dequeue
            if(u != null){
                for(GNode v : u.getAdjacent()){
                    if(v.state == State.Unvisited){
                        if(v == end){
                            return true;
                        }else{
                            v.state = State.Visiting;
                            q.add(v);
                        }
                    }
                }
                u.state = State.Visited;
            }
        }
        return false;
    }
}
