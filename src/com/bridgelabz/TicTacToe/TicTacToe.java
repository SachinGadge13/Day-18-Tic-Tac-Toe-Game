package com.bridgelabz.TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    static char[] board;
    static char playerChoice;
    static char computerChoice;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Game Initiated.");
        createBoard();
        showBoard();
        chooseLetter();
        playerTurn();
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
        System.out.println("Enter the position where you want to make a move : ");
        int playerPosition = sc.nextInt();
        if (board[playerPosition] == ' ') {
            board[playerPosition] = playerChoice;
        }
        showBoard();
    }
}