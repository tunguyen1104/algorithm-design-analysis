package b7;

public class Main {
    public static void main(String[] args) {
        NQueens queens = new NQueens(8);
        queens.solution();
        queens.print_count_results();
    }
}
