package b13;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(new File("b13/SinhVien1.txt")));
        int n = StdIn.readInt();
        SinhVien[] sv = new SinhVien[n];
        int count = 0;
        while (StdIn.hasNextLine()) {
            // Create an entry from the next line and put on the PQ.
            String line = StdIn.readLine();
            String[] input = line.split(" , ");
            if (input.length > 1) {
                SinhVien a = new SinhVien(input[0], new Date(input[1]));
                sv[count] = a;
                count++;
            }
        }
        for (int i = 0; i < n; i++) {
            StdOut.println(sv[i].getHoTen() + " sinh ngay " + sv[i].getNgaySinh());
        }
        Arrays.sort(sv);
        StdOut.println("\n Sau khi sap xep \n");
        for (int i = 0; i < n; i++) {
            StdOut.println(sv[i].getHoTen() + " sinh ngay " + sv[i].getNgaySinh());
        }
        HashMap<SinhVien, masv> myHashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            myHashMap.put(sv[i], new masv(201230 + i));
        }
        Set<Map.Entry<SinhVien, masv>> setHashMap = myHashMap.entrySet();
        StdOut.println("\n Sau Khi put vao bang bam HashMap \n");
        for (Map.Entry<SinhVien, masv> i : setHashMap) {
            System.out.println(i.getKey().getHoTen() + "   -->   " + i.getValue().getMa());
        }
    }
}
