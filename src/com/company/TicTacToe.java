package com.company;

import java.awt.*;

public class TicTacToe {
    String[][] board;
    int[][] pointboard;
    int freeSpaces;
    Point[] legalMoves;

    public TicTacToe(String[][] board) {
        this.board = board;
        this.pointboard = new int[][] {{ 3 , 2 , 3} , { 2 , 4 , 2 } , { 3 , 2 , 3 }};
        this.freeSpaces = NumberOfFreeSpaces(board);
        this.legalMoves = findLegalMoves(board);
    }

    public TicTacToe(String[][] board, int x, int y, boolean isPlayerX) {
        this.pointboard = new int[][] {{ 3 , 2 , 3} , { 2 , 4 , 2 } , { 3 , 2 , 3 }};
        this.board = board;
        Move(x, y, isPlayerX);
        this.freeSpaces = NumberOfFreeSpaces(board);
        this.legalMoves = findLegalMoves(board);
    }

    public int GetStateValue(boolean IsPlayerX) {
        int SumPlayerX = 0;
        int SumPlayerO = 0;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j].equals("X"))
                {
                    SumPlayerX += pointboard[i][j];
                }
                else if (board[i][j].equals("O")) {
                    SumPlayerO += pointboard[i][j];
                }
            }
        }
        if(IsPlayerX) {
            return SumPlayerX;
        } else {
            return SumPlayerO;
        }
    }

    public void Move(int x, int y, boolean IsPlayerX) {
        if(IsPlayerX) {
            this.board[x][y] = "X";
        }
        else {
            this.board[x][y] = "O";
        }
    }

    public boolean HasGameEnded(String[][] board) {
        boolean allFieldsUsed = 9 == NumberOfFreeSpaces(board);

        if(board[0][0].equals("X") && board[0][1].equals("X") && board[0][2].equals("X") ||
           board[0][0].equals("O") && board[0][1].equals("O") && board[0][2].equals("O")) {
            return true;
        }
        if(board[1][0].equals("X") && board[1][1].equals("X") && board[1][2].equals("X") ||
           board[1][0].equals("O") && board[1][1].equals("O") && board[1][2].equals("O")) {
            return true;
        }
        if(board[2][0].equals("X") && board[2][1].equals("X") && board[2][2].equals("X") ||
           board[2][0].equals("O") && board[2][1].equals("O") && board[2][2].equals("O")) {
            return true;
        }


        if(board[0][0].equals("X") && board[1][0].equals("X") && board[2][0].equals("X") ||
           board[0][0].equals("O") && board[1][0].equals("O") && board[2][0].equals("O")) {
            return true;
        }
        if(board[0][1].equals("X") && board[1][1].equals("X") && board[2][1].equals("X") ||
           board[0][1].equals("O") && board[1][1].equals("O") && board[2][1].equals("O")) {
            return true;
        }
        if(board[0][2].equals("X") && board[1][2].equals("X") && board[2][2].equals("X") ||
           board[0][2].equals("O") && board[1][2].equals("O") && board[2][2].equals("O")) {
            return true;
        }

        if(board[0][0].equals("X") && board[1][1].equals("X") && board[2][2].equals("X") ||
           board[0][0].equals("O") && board[1][1].equals("O") && board[2][2].equals("O")) {
            return true;
        }
        if(board[2][0].equals("X") && board[1][1].equals("X") && board[0][2].equals("X") ||
           board[2][0].equals("O") && board[1][1].equals("O") && board[0][2].equals("O")) {
            return true;
        }
        return allFieldsUsed;
    }

    public int NumberOfFreeSpaces(String[][] board) {
        int freeSpaces = 0;
        for (String[] strings : board) {
            for (String string : strings) {
                if (string.equals("")) {
                    freeSpaces++;
                }
            }
        }
        return freeSpaces;
    }

    public Point[] findLegalMoves(String[][] board) {
        int freeSpaces = NumberOfFreeSpaces(board);
        int iterator = 0;
        Point[] legalMoves = new Point[freeSpaces];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j].equals("")) {
                    legalMoves[iterator] = new Point(i,j);
                    iterator++;
                }
            }
        }
        return legalMoves;
    }

    public void PrintBoard(String[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
