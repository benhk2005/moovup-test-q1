package model;

import java.util.ArrayList;

public class Node {

    public String name;
    public ArrayList<String> connectedNodes;

    public Node(String name, ArrayList<String> connectedNodes) {
        this.name = name;
        this.connectedNodes = connectedNodes;
    }

}
