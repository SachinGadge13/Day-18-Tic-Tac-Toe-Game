package com.bridgelabz.TicTacToe;

public class TicTacToe {
    static char[] board;    // declaring an array
    public static void main(String[] args) {
        System.out.println("Game Initiated.");
        createBoard();
        showBoard();
    }

    // UC1: Creating empty tic-tac-toe board
    public static void createBoard() {
        board = new char[10];   // creating an array

        // initialize an array
        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
    }

    public static void showBoard() {
        System.out.println("Displaying the TicTacToe Board.");
        System.out.println(board[1]+ " | " +board[2]+ "| "+board[3]);
        System.out.println("---------");
        System.out.println(board[4]+ " | " +board[5]+ "| "+board[6]);
        System.out.println("---------");
        System.out.println(board[7]+ " | " +board[8]+ "| "+board[9]);
    }
}