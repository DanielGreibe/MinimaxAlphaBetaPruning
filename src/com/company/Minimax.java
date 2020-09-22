package com.company;

public class Minimax {
    public int minimax(TicTacToe ticTacToe, int depth, int alpha, int beta, boolean maximizingPlayer)
    {
        if (depth == 0) {
            return ticTacToe.GetStateValue(maximizingPlayer);
        }

        if(maximizingPlayer) {
            int maxEval = Integer.MIN_VALUE;
            for (int i = 0; i < ticTacToe.freeSpaces; i++) {
                System.out.println("Free spaces" + ticTacToe.freeSpaces);
                ticTacToe.PrintBoard(ticTacToe.board);
                int x = ticTacToe.legalMoves[i].x;
                int y = ticTacToe.legalMoves[i].y;
                TicTacToe child = new TicTacToe(ticTacToe.board, x , y , false);
                int eval = minimax(child, depth - 1, alpha, beta, false);
                maxEval = Math.max(maxEval, eval);
                alpha = Math.max(alpha, eval);
                if (beta <= alpha)
                {
                    break;
                }
            }
            return maxEval;
        }
        else {
            int minEval = Integer.MAX_VALUE;
            for (int i = 0; i < ticTacToe.freeSpaces; i++) {
                int x = ticTacToe.legalMoves[i].x;
                int y = ticTacToe.legalMoves[i].y;
                TicTacToe child = new TicTacToe(ticTacToe.board, x , y , true);
                int eval = minimax(child, depth - 1, alpha, beta, true);
                minEval = Math.min(minEval, eval);
                alpha = Math.min(alpha, eval);
                if (beta <= alpha)
                {
                    break;
                }
            }
            return minEval;
        }
    }
}
