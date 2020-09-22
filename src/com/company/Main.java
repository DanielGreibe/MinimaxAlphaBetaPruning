package com.company;

public class Main {

    public static void main(String[] args) {
        Minimax minimax = new Minimax();
        String[][] board = {{"" , "" , ""} , {"" , "" , ""} , {"" , "" , ""}};
        TicTacToe startPosition = new TicTacToe(board);
        System.out.println("Result from minimax = " + minimax.minimax(startPosition, 3, Integer.MIN_VALUE, Integer.MAX_VALUE, true));
    }

}
