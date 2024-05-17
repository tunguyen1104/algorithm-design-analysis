package b6;

import java.util.Scanner;

public class BaLo {
    private int n;
    private int W;
    private int[] w;
    private int[] v;

    public BaLo() {}

    public void createBaLo() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("- Nhap so luong do vat: ");
            n = Integer.parseInt(sc.nextLine());
            System.out.println("- Suc chua cua balo: ");
            W = Integer.parseInt(sc.nextLine());
            w = new int[n];
            v = new int[n];
            System.out.println("- Nhap weight " + n + " do vat: ");
            for (int i = 0; i < n; i++) {
                w[i] = Integer.parseInt(sc.next());
            }
            System.out.println("- Nhap value " + n + " do vat: ");
            for (int i = 0; i < n; i++) {
                v[i] = Integer.parseInt(sc.next());
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid input format: " + e.getMessage());
        }
    }

    public void dovat() {
        for (int i = 0; i < n; ++i) {
            System.out.println("Weight : Value do vat thu " + (i + 1) + ": ");
            System.out.println(w[i] + " : " + v[i]);
        }
    }

    public int sumValue() {
        if (n <= 0 || W <= 0) {
            return 0;
        }

        int[][] m = new int[n + 1][W + 1];
        for (int[] row : m) {
            for (int j = 0; j <= W; j++) {
                row[j] = 0;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (w[i - 1] > j) {
                    m[i][j] = m[i - 1][j];
                } else {
                    m[i][j] = Math.max(m[i - 1][j], m[i - 1][j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        return m[n][W];
    }
}
