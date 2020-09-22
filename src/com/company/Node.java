package com.company;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public List<Node> children;
    Integer value;

    public Node(Integer value) {
        this.children = new ArrayList<>();
        this.value = value;
    }
    public void addChild(Node child) {
        children.add(child);
    }
}
