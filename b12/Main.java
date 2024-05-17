package b12;

import edu.princeton.cs.algs4.*;

public class Main
{
    public static void main(String[] args){
        int m = Integer.parseInt(args[0]); 
        MinPQ<SinhVien> pq = new MinPQ<SinhVien>(m+1);
        SinhVien sinhVien1 = new SinhVien("Nguyen Van A", new Date("1/22/2004"));
        sinhVien1.nhapDiemMonHoc(new Mon( "Toan", 1), 8);
        sinhVien1.nhapDiemMonHoc(new Mon("Ly", 1), 9);
        sinhVien1.nhapDiemMonHoc(new Mon( "Hoa", 1), 7);

        SinhVien sinhVien2 = new SinhVien("Nguyen Van B", new Date("1/21/2004"));
        sinhVien2.nhapDiemMonHoc(new Mon( "Toan", 1), 8);
        sinhVien2.nhapDiemMonHoc(new Mon("Ly", 1), 9);
        sinhVien2.nhapDiemMonHoc(new Mon( "Hoa", 1), 7);

        SinhVien sinhVien3 = new SinhVien("Nguyen Thi C", new Date("10/02/2004"));
        sinhVien3.nhapDiemMonHoc(new Mon( "Toan", 1), 8);
        sinhVien3.nhapDiemMonHoc(new Mon("Ly", 1), 9);
        sinhVien3.nhapDiemMonHoc(new Mon( "Hoa", 1), 7);

        SinhVien sinhVien4 = new SinhVien("Nguyen Van D", new Date("11/09/2003"));
        sinhVien4.nhapDiemMonHoc(new Mon( "Toan", 1), 8);
        sinhVien4.nhapDiemMonHoc(new Mon("Ly", 1), 9);
        sinhVien4.nhapDiemMonHoc(new Mon( "Hoa", 1), 7);
        SinhVien[] ts=new SinhVien[4];
        ts[0]=sinhVien1;
        ts[1]=sinhVien2;
        ts[2]=sinhVien3;
        ts[3]=sinhVien4;
        for(int i=0;i<4;i++)
        {
            pq.insert(ts[i]);
            if (pq.size() > m)
                pq.delMin();
        }
        Stack<SinhVien> stack = new Stack<SinhVien>();
        for (SinhVien sv : pq)
            stack.push(sv);
        for (SinhVien sv : stack)
            System.out.println(sv.getHoTen());
    }
}
