package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Node root = new Node(null);
        Node node2 = new Node(null);
        Node node3 = new Node(null);
        Node node4 = new Node(null);
        Node node5 = new Node(null);
        Node node6 = new Node(null);
        Node node7 = new Node(null);
        Node node8 = new Node(-1);
        Node node9 = new Node(3);
        Node node10 = new Node(5);
        Node node11 = new Node(100);
        Node node12 = new Node(-6);
        Node node13 = new Node(-4);
        Node node14 = new Node(20);
        Node node15 = new Node(-200);

        root.addChild(node2);
        root.addChild(node3);

        node2.addChild(node4);
        node2.addChild(node5);

        node3.addChild(node6);
        node3.addChild(node7);

        node4.addChild(node8);
        node4.addChild(node9);

        node5.addChild(node10);
        node5.addChild(node11);

        node6.addChild(node12);
        node6.addChild(node13);

        node7.addChild(node14);
        node7.addChild(node15);

        System.out.println("Result from minimax = " + minimax(root, 3, Integer.MIN_VALUE, Integer.MAX_VALUE, true));
    }

    public static int minimax(Node position, int depth, int alpha, int beta, boolean maximizingPlayer)
    {
        if (depth == 0) {
            return position.value;
        }

        if(maximizingPlayer) {
            int maxEval = Integer.MIN_VALUE;
            for (Node child : position.children) {
                int eval = minimax(child, depth - 1, alpha, beta, false);
                maxEval = Math.max(maxEval, eval);
                alpha = Math.max(alpha, eval);
                if (beta <= alpha)
                {
                    break;
                }
                return maxEval;
            }
        }
        else {
            int minEval = Integer.MAX_VALUE;
            for (Node child : position.children) {
                int eval = minimax(child, depth - 1, alpha, beta, true);
                minEval = Math.min(minEval, eval);
                alpha = Math.min(alpha, eval);
                if (beta <= alpha)
                {
                    break;
                }
                return minEval;
            }
        }
        System.out.println("Should never reach this point");
        return position.value;
    }

    public static class Node {
        private List<Node> children;
        Integer value;

        public Node(Integer value) {
            this.children = new ArrayList<>();
            this.value = value;
        }
        public void addChild(Node child) {
            children.add(child);
        }
    }
}
