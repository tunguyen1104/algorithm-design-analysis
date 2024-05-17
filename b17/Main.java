package b17;

import edu.princeton.cs.algs4.Inversions;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(new File("b17/SinhVien.txt")));
        int n = StdIn.readInt();
        SinhVien[] sv = new SinhVien[n+1];
        int count=0;
        while (StdIn.hasNextLine()) {
            // Create an entry from the next line and put on the PQ.
            String line = StdIn.readLine();
            SinhVien a=new SinhVien(line);
            sv[count]=a;
            count++;

        }
        StdOut.println("Truoc Khi Sap Xep :");
        for(int i=0;i<=n;i++)
        {
            StdOut.println(sv[i].getHoTen());
        }
        StdOut.println("\n"+"So Nghich The Ton Tai La : "+ Inversions.count(sv)+"\n");
        Arrays.sort(sv);
        StdOut.println("Sau Khi Sap Xep :");
        for(int i=0;i<=n;i++)
        {
            StdOut.println(sv[i].getHoTen());
        }
    }
}
