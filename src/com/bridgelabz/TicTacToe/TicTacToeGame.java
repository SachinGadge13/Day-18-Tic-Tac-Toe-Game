package com.bridgelabz.TicTacToe;

import java.util.Objects;
import java.util.Scanner;

public class TicTacToeGame {
    public static char inputUser;
    public static char inputC;
    public static char[] board = new char[10];
    public static char toss;
    public static Scanner in = new Scanner(System.in);
    public static String status;
    public static String check;
    public static String select = null;
    public static int choice;
    public static String report;

    public static void main(String[] args) {

        for (int i = 1; i < 10; i++) {
            board[i] = ' ';
        }
        inputUser = input();
        if (inputUser == 'X') {
            inputC = 'O';
        } else {
            inputC = 'X';
        }
        TicTacToeGame.showBoard();
        char turn = toss();
        if (turn == 'W') {
            TicTacToeGame.uSelection();
            for (int i = 1; i <= 4; i++) {
                TicTacToeGame.showBoard();
                select = cPlay();
                if (select == null) {
                    TicTacToeGame.cSelection();
                }
                TicTacToeGame.showBoard();
                check = cCheck();
                if (Objects.equals(check, "Done")) {
                    break;
                }
                TicTacToeGame.uSelection();
                TicTacToeGame.showBoard();
                check = check();
                if (Objects.equals(check, "Done")) {
                    break;
                }

            }
        } else {
            TicTacToeGame.cSelection();
            for (int i = 1; i <= 4; i++) {
                TicTacToeGame.showBoard();
                TicTacToeGame.uSelection();
                TicTacToeGame.showBoard();
                check = check();
                if (Objects.equals(check, "Done")) {
                    break;
                }
                select = cPlay();
                if (select == null) {
                    TicTacToeGame.cSelection();
                }
                check = cCheck();
                if (Objects.equals(check, "Done")) {
                    break;
                }
            }
            showBoard();
        }
    }

    public static char input() {
        char inputU = ' ';
        int i = 0;
        while (i < 1) {
            System.out.println("Please enter your input in X / O");
            char U = in.next().charAt(0);
            if ((U == 'X') || (U == 'O')) {
                inputU = U;
                i = 1;
            } else {
                System.out.println("Enter a valid input");
            }
        }
        return inputU;
    }

    public static void showBoard() {
        System.out.println("TicTacToe Board");
        System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println("---------");
        System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("---------");
        System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
    }

    public static void uSelection() {
        int j = 0;
        while (j < 1) {
            System.out.println("Please enter the index from 1 to 9 to make the move");
            int selection = in.nextInt();
            if (board[selection] == ' ') {
                board[selection] = inputUser;
                j = 1;
            } else {
                System.out.println("Seat Occupied, please enter a different input");
            }
        }
    }

    public static void cSelection() {
        int i = 0;
        while (i < 1) {
            choice = (int) ((Math.floor(Math.random() * 10) % 9) + 1);
            if (board[choice] == ' ') {
                board[choice] = inputC;
                i = 1;
            }
        }
    }

    public static char toss() {
        char call = ' ';
        int i = 0;
        while (i < 1) {
            System.out.println("Please enter your call H for Heads/ T for Tails");
            call = in.next().charAt(0);
            if ((call == ('H')) || (call == ('T'))) {
                int choice = (int) ((Math.floor(Math.random() * 10) % 2));
                if (choice == 1) {
                    toss = 'H';
                } else {
                    toss = 'T';
                }
                i = 1;
            } else {
                System.out.println("Please enter a valid input");
            }
        }
        if (toss == (call)) {
            System.out.println("You Won");
            toss = 'W';
        } else {
            System.out.println("You Lose");
            toss = 'L';
        }
        return toss;
    }


    public static String check() {
        if (board[1] == inputUser) {
            if ((board[2] == inputUser) && (board[3] == inputUser)) {
                System.out.println("Player Won");
                status = "Done";
            } else if ((board[5] == inputUser) && (board[9] == inputUser)) {
                System.out.println("PLayer Won");
                status = "Done";
            } else if ((board[4] == inputUser) && (board[7] == inputUser)) {
                System.out.println("Player Won");
                status = "Done";
            }
        }
        if (board[3] == inputUser) {
            if ((board[6] == inputUser) && (board[9] == inputUser)) {
                System.out.println("Player Won");
                status = "Done";
            } else if ((board[5] == inputUser) && (board[7] == inputUser)) {
                System.out.println("PLayer Won");
                status = "Done";
            }
        }
        if (board[7] == inputUser) {
            if ((board[8] == inputUser) && (board[9] == inputUser)) {
                System.out.println("Player Won");
                status = "Done";
            }
        }
        if (board[5] == inputUser) {
            if ((board[2] == inputUser) && (board[8] == inputUser)) {
                System.out.println("Player Won");
                status = "Done";
            } else if ((board[4] == inputUser) && (board[6] == inputUser)) {
                System.out.println("PLayer Won");
                status = "Done";
            }
        }
        return status;
    }

    public static String cCheck() {
        if (board[1] == inputC) {
            if ((board[2] == inputC) && (board[3] == inputC)) {
                System.out.println("Player Lose");
                status = "Done";
            } else if ((board[5] == inputC) && (board[9] == inputC)) {
                System.out.println("PLayer Lose");
                status = "Done";
            } else if ((board[4] == inputC) && (board[7] == inputC)) {
                System.out.println("Player Lose");
                status = "Done";
            }
        }
        if (board[3] == inputC) {
            if ((board[6] == inputC) && (board[9] == inputC)) {
                System.out.println("Player Lose");
                status = "Done";
            } else if ((board[5] == inputC) && (board[7] == inputC)) {
                System.out.println("PLayer Lose");
                status = "Done";
            }
        }
        if (board[7] == inputC) {
            if ((board[8] == inputC) && (board[9] == inputC)) {
                System.out.println("Player Lose");
                status = "Done";
            }
        }
        if (board[5] == inputC) {
            if ((board[2] == inputC) && (board[8] == inputC)) {
                System.out.println("Player Lose");
                status = "Done";
            } else if ((board[4] == inputC) && (board[6] == inputC)) {
                System.out.println("PLayer Lose");
                status = "Done";
            }
        }
        return status;
    }

    public static String cPlay() {
        report = null;
        if (((board[1] == inputC) && (board[2] == inputC)) && ((board[3] == ' '))) {
            board[3] = inputC;
            report="ok";
        } else if (((board[1] == inputC) && (board[3] == inputC)) && ((board[2] == ' '))) {
            board[2] = inputC;
            report="ok";
        } else if (((board[1] == inputC) && (board[4] == inputC)) && ((board[7] == ' '))) {
            board[7] = inputC;
            report="ok";
        } else if (((board[1] == inputC) && (board[7] == inputC)) && ((board[4] == ' '))) {
            board[4] = inputC;
            report="ok";
        } else if (((board[1] == inputC) && (board[9] == inputC)) && ((board[5] == ' '))) {
            board[5] = inputC;
            report="ok";
        } else if (((board[1] == inputC) && (board[5] == inputC)) && ((board[9] == ' '))) {
            board[9] = inputC;
            report="ok";
        } else if (((board[2] == inputC) && (board[3] == inputC)) && ((board[1] == ' '))) {
            board[1] = inputC;
            report="ok";
        } else if (((board[2] == inputC) && (board[8] == inputC)) && ((board[5] == ' '))) {
            board[5] = inputC;
            report="ok";
        } else if (((board[2] == inputC) && (board[5] == inputC)) && ((board[8] == ' '))) {
            board[8] = inputC;
            report="ok";
        } else if (((board[3] == inputC) && (board[2] == inputC)) && ((board[1] == ' '))) {
            board[1] = inputC;
            report="ok";
        } else if (((board[3] == inputC) && (board[1] == inputC)) && ((board[2] == ' '))) {
            board[2] = inputC;
            report="ok";
        } else if (((board[3] == inputC) && (board[6] == inputC)) && ((board[9] == ' '))) {
            board[9] = inputC;
            report="ok";
        } else if (((board[3] == inputC) && (board[9] == inputC)) && ((board[6] == ' '))) {
            board[6] = inputC;
            report="ok";
        } else if (((board[3] == inputC) && (board[5] == inputC)) && ((board[7] == ' '))) {
            board[7] = inputC;
            report="ok";
        } else if (((board[3] == inputC) && (board[7] == inputC)) && ((board[5] == ' '))) {
            board[5] = inputC;
            report="ok";
        } else if (((board[4] == inputC) && (board[1] == inputC)) && ((board[7] == ' '))) {
            board[7] = inputC;
            report="ok";
        } else if (((board[4] == inputC) && (board[7] == inputC)) && ((board[1] == ' '))) {
            board[1] = inputC;
            report="ok";
        } else if (((board[4] == inputC) && (board[5] == inputC)) && ((board[6] == ' '))) {
            board[6] = inputC;
            report="ok";
        } else if (((board[4] == inputC) && (board[6] == inputC)) && ((board[5] == ' '))) {
            board[5] = inputC;
            report="ok";
        } else if (((board[5] == inputC) && (board[1] == inputC)) && ((board[9] == ' '))) {
            board[9] = inputC;
            report="ok";
        } else if (((board[5] == inputC) && (board[9] == inputC)) && ((board[1] == ' '))) {
            board[1] = inputC;
            report="ok";
        } else if (((board[5] == inputC) && (board[2] == inputC)) && ((board[8] == ' '))) {
            board[8] = inputC;
            report="ok";
        } else if (((board[5] == inputC) && (board[8] == inputC)) && ((board[2] == ' '))) {
            board[2] = inputC;
            report="ok";
        } else if (((board[5] == inputC) && (board[3] == inputC)) && ((board[7] == ' '))) {
            board[7] = inputC;
            report="ok";
        } else if (((board[5] == inputC) && (board[7] == inputC)) && ((board[3] == ' '))) {
            board[3] = inputC;
            report="ok";
        } else if (((board[5] == inputC) && (board[4] == inputC)) && ((board[6] == ' '))) {
            board[6] = inputC;
            report="ok";
        } else if (((board[5] == inputC) && (board[6] == inputC)) && ((board[4] == ' '))) {
            board[4] = inputC;
            report="ok";
        } else if (((board[6] == inputC) && (board[9] == inputC)) && ((board[3] == ' '))) {
            board[3] = inputC;
            report="ok";
        } else if (((board[7] == inputC) && (board[8] == inputC)) && ((board[9] == ' '))) {
            board[9] = inputC;
            report="ok";
        } else if (((board[8] == inputC) && (board[9] == inputC)) && ((board[7] == ' '))) {
            board[7] = inputC;
            report="ok";
        } else if (((board[7] == inputC) && (board[9] == inputC)) && ((board[8] == ' '))) {
            board[8] = inputC;
            report="ok";
        }else if (((board[1] == inputUser) && (board[2] == inputUser)) && ((board[3] == ' '))) {
            board[3] = inputC;
            report="ok";
        } else if (((board[1] == inputUser) && (board[3] == inputUser)) && ((board[2] == ' '))) {
            board[2] = inputC;
            report="ok";
        } else if (((board[1] == inputUser) && (board[4] == inputUser)) && ((board[7] == ' '))) {
            board[7] = inputC;
            report="ok";
        } else if (((board[1] == inputUser) && (board[7] == inputUser)) && ((board[4] == ' '))) {
            board[4] = inputC;
            report="ok";
        } else if (((board[1] == inputUser) && (board[9] == inputUser)) && ((board[5] == ' '))) {
            board[5] = inputC;
            report="ok";
        } else if (((board[1] == inputUser) && (board[5] == inputUser)) && ((board[9] == ' '))) {
            board[9] = inputC;
            report="ok";
        } else if (((board[2] == inputUser) && (board[3] == inputUser)) && ((board[1] == ' '))) {
            board[1] = inputC;
            report="ok";
        } else if (((board[2] == inputUser) && (board[8] == inputUser)) && ((board[5] == ' '))) {
            board[5] = inputC;
            report="ok";
        } else if (((board[2] == inputUser) && (board[5] == inputUser)) && ((board[8] == ' '))) {
            board[8] = inputC;
            report="ok";
        } else if (((board[3] == inputUser) && (board[2] == inputUser)) && ((board[1] == ' '))) {
            board[1] = inputC;
            report="ok";
        } else if (((board[3] == inputUser) && (board[1] == inputUser)) && ((board[2] == ' '))) {
            board[2] = inputC;
            report="ok";
        } else if (((board[3] == inputUser) && (board[6] == inputUser)) && ((board[9] == ' '))) {
            board[9] = inputC;
            report="ok";
        } else if (((board[3] == inputUser) && (board[9] == inputUser)) && ((board[6] == ' '))) {
            board[6] = inputC;
            report="ok";
        } else if (((board[3] == inputUser) && (board[5] == inputUser)) && ((board[7] == ' '))) {
            board[7] = inputC;
            report="ok";
        } else if (((board[3] == inputUser) && (board[7] == inputUser)) && ((board[5] == ' '))) {
            board[5] = inputC;
            report="ok";
        } else if (((board[4] == inputUser) && (board[1] == inputUser)) && ((board[7] == ' '))) {
            board[7] = inputC;
            report="ok";
        } else if (((board[4] == inputUser) && (board[7] == inputUser)) && ((board[1] == ' '))) {
            board[1] = inputC;
            report="ok";
        } else if (((board[4] == inputUser) && (board[5] == inputUser)) && ((board[6] == ' '))) {
            board[6] = inputC;
            report="ok";
        } else if (((board[4] == inputUser) && (board[6] == inputUser)) && ((board[5] == ' '))) {
            board[5] = inputC;
            report="ok";
        } else if (((board[5] == inputUser) && (board[1] == inputUser)) && ((board[9] == ' '))) {
            board[9] = inputC;
            report="ok";
        } else if (((board[5] == inputUser) && (board[9] == inputUser)) && ((board[1] == ' '))) {
            board[1] = inputC;
            report="ok";
        } else if (((board[5] == inputUser) && (board[2] == inputUser)) && ((board[8] == ' '))) {
            board[8] = inputC;
            report="ok";
        } else if (((board[5] == inputUser) && (board[8] == inputUser)) && ((board[2] == ' '))) {
            board[2] = inputC;
            report="ok";
        } else if (((board[5] == inputUser) && (board[3] == inputUser)) && ((board[7] == ' '))) {
            board[7] = inputC;
            report="ok";
        } else if (((board[5] == inputUser) && (board[7] == inputUser)) && ((board[3] == ' '))) {
            board[3] = inputC;
            report="ok";
        } else if (((board[5] == inputUser) && (board[4] == inputUser)) && ((board[6] == ' '))) {
            board[6] = inputC;
            report="ok";
        } else if (((board[5] == inputUser) && (board[6] == inputUser)) && ((board[4] == ' '))) {
            board[4] = inputC;
            report="ok";
        } else if (((board[6] == inputUser) && (board[9] == inputUser)) && ((board[3] == ' '))) {
            board[3] = inputC;
            report="ok";
        } else if (((board[7] == inputUser) && (board[8] == inputUser)) && ((board[9] == ' '))) {
            board[9] = inputC;
            report="ok";
        } else if (((board[8] == inputUser) && (board[9] == inputUser)) && ((board[7] == ' '))) {
            board[7] = inputC;
            report="ok";
        } else if (((board[7] == inputUser) && (board[9] == inputUser)) && ((board[8] == ' '))) {
            board[8] = inputC;
            report="ok";
        }
        return report;
    }
}