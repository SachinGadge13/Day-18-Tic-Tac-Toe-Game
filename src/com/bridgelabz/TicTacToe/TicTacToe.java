package com.bridgelabz.TicTacToe;

import java.util.Scanner;

public class TicTacToe  {
    static final int USER = 0;
    static final int COMPUTER = 1;
    static char[] board;
    static char playerChoice;
    static char computerChoice;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Game Initiated.");
        createBoard();
        showBoard();
        chooseLetter();
        whoPlayFirst();
    }

    // UC1: Creating empty tic-tac-toe board
    public static void createBoard() {
        board = new char[10];
        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
    }

    // UC2: Getting user input to choose either X or O
    public static void chooseLetter() {
        System.out.println("Enter the Player Choice between X | O ");
        playerChoice = sc.next().toUpperCase().charAt(0);
        if(playerChoice == 'X') {
            computerChoice = 'O';
            System.out.println("Player Choice is : "+ playerChoice);
            System.out.println("Computer Choice is : "+ computerChoice);
        } else if (playerChoice == 'O'){
            computerChoice = 'X';
            System.out.println("Player Choice is : "+ playerChoice);
            System.out.println("Computer Choice is : "+ computerChoice);
        } else {
            System.out.println("Invalid symbol.");
        }
    }

    // UC3: Show board
    public static void showBoard() {
        System.out.println("Displaying the TicTacToe Board.");
        System.out.println(board[1]+ " | " +board[2]+ "| "+board[3]);
        System.out.println("---------");
        System.out.println(board[4]+ " | " +board[5]+ "| "+board[6]);
        System.out.println("---------");
        System.out.println(board[7]+ " | " +board[8]+ "| "+board[9]);
    }

    // UC4: ability to make move to desired position and ensures index is free
    public static void playerTurn() {
        System.out.println("USER Enter the position where you want to make a move : ");
        int playerPosition = sc.nextInt();
        if (validPosition(playerPosition)) {
            board[playerPosition] = playerChoice;
        }
        showBoard();
    }

    public static void computerTurn() {
        int computerPosition;
        while (true) {
            computerPosition = (int) (Math.floor(Math.random()*10%9)+1);
            if (validPosition(computerPosition)) {
                board[computerPosition] = computerChoice;
                break;
            }
        }
        System.out.println("Computer entered " + computerChoice + " at position : " + computerPosition);
        showBoard();
    }

    // UC5: Ensures the desired position is free or not
    public static boolean validPosition(int position) {
        if (board[position] == ' ')
            return true;
        else {
            return false;
        }
    }

    //UC6: Toss to check who plays first
    public static void whoPlayFirst() {
        int tossWon = (int) (Math.floor(Math.random()*10%2));
        if (tossWon == USER) {
            System.out.println("User/player won the toss.");
            while (true) {
                playerTurn();
                if (isGameFinished())
                    break;
                computerTurn();
                if (isGameFinished())
                    break;
            }
        } else if (tossWon == COMPUTER) {
            System.out.println("Computer won the toss.");
            while (true) {
                computerTurn();
                if (isGameFinished())
                    break;
                playerTurn();
                if (isGameFinished())
                    break;
            }
        }
    }

    // Checks anyone won the game
    public static boolean hasWon(char choice) {
        if ((board[1] == choice && board[2] == choice && board[3] == choice) ||
                (board[4] == choice && board[5] == choice && board[6] == choice) ||
                (board[7] == choice && board[8] == choice && board[9] == choice) ||

                (board[1] == choice && board[4] == choice && board[7] == choice) ||
                (board[2] == choice && board[5] == choice && board[8] == choice) ||
                (board[3] == choice && board[6] == choice && board[9] == choice) ||

                (board[1] == choice && board[5] == choice && board[9] == choice) ||
                (board[3] == choice && board[5] == choice && board[7] == choice)
        ) {
            return true;
        }
        return false;
    }

    public static boolean isGameFinished() {
        if (hasWon(playerChoice)) {
            System.out.println("Player won the game!");
            return true;
        }
        if (hasWon(computerChoice)) {
            System.out.println("Computer won the game!");
            return true;
        }
        for (int i = 1; i < board.length; i++) {
            if (board[i]== ' ') {
                return false;
            }
        }
        showBoard();
        System.out.println("Game tie.");
        return true;
    }
}