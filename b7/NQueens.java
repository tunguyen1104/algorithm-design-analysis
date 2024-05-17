package b7;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    private int n;
    private List<List<String>> solutions;

    public NQueens(int n) {
        this.n = n;
        this.solutions = new ArrayList<>();
    }

    public void solve(char[][] board, List<List<String>> allBoards, int col) {

        if(col == board.length) {
            saveBoard(board, allBoards);
            return;
        }
        for(int row=0; row<board.length; row++) {
            if(isSafe(row, col, board)) {
                board[row][col] = 'Q';
                solve(board, allBoards, col+1);
                board[row][col] = '.';
            }
        }
    }
    public void saveBoard(char[][] board, List<List<String>> allBoards) {

        String row = "";
        List<String> newBoard = new ArrayList<>();
        for(int i=0; i<board.length; i++) {
            row = "";
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == 'Q')
                    row += 'Q';
                else
                    row += '.';
            }
            newBoard.add(row);
        }
        allBoards.add(newBoard);
    }
    public boolean isSafe(int row, int col, char[][] board) {
        for(int j=0; j<board.length; j++) {
            if(board[row][j] == 'Q') {
                return false;
            }
        }
        for(int i=0; i<board.length; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }
        int r = row;
        for(int c=col; c>=0 && r>=0; c--, r--) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }
        r = row;
        for(int c=col; c<board.length && r>=0; r--, c++) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }
        r = row;
        for(int c=col; c>=0 && r<board.length; r++, c--) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }
        for(int c=col; c<board.length && r<board.length; c++, r++) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }

        return true;
    }
    public void solution() {
        char[][] board = new char[n][n];
        solve(board, solutions, 0);
        print_the_results();
    }
    public void print_the_results() {
        for(List<String> aboard : solutions){
            for(int i=0; i < aboard.size(); i++){
                System.out.println(aboard.get(i));
            }
            System.out.println("\n");
        }
    }

    public void print_count_results() {
        System.out.println("So luong ket qua: " + solutions.size());
    }
}

