package b21;

public class Main {
    public static void main(String args[]) {
        WeightedIntervalScheduling scheduler = new WeightedIntervalScheduling();
        int[][] inputJobs = { {0,0,0,0},
                {1, 0, 6, 3},
                {2, 1, 2, 50},
                {3, 3, 10, 20},
                {4, 3, 8, 8},
                {5, 4, 7, 3},
                {6, 5, 9, 7},
                {7, 6, 10, 3},
                {8, 8, 11, 4}
        };
        scheduler.calcSchedule(inputJobs);
    }
}
