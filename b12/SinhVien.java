package b12;

import edu.princeton.cs.algs4.Date;

import java.util.HashSet;

public class SinhVien implements Comparable<SinhVien>{

    private String hoTen;
    private Date NgaySinh;
    private HashSet<Mon> monHoc;
    public SinhVien(String hoTen,Date ht) {
        this.hoTen = hoTen;
        this.monHoc = new HashSet<>();
        this.NgaySinh = ht;
    }
    public void nhapDiemMonHoc(Mon m, double diem) {
        m.setDiem(diem);
        monHoc.add(m);
    }

    public double tinhDiemTB() {
        double tongDiem = 0;
        int cnt = 0;

        for (Mon mon : monHoc) {
            tongDiem += mon.getDiem();
            cnt++;
        }

        if (cnt == 0) {
            return 0;
        }

        return tongDiem / cnt;
    }

    public double tinhDiemTBCHocKy(int kyThu) {
        double tongDiem = 0;
        int cnt = 0;

        for(Mon mon : monHoc) {
            if(mon.getHocKy() == kyThu) {
                tongDiem += mon.getDiem();
                ++cnt;
            }
        }

        if (cnt == 0) {
            return 0;
        }

        return tongDiem / cnt;
    }
    @Override
    public int compareTo(SinhVien other)
    {
        int CompareTre = this.NgaySinh.compareTo(other.getNgaySinh());
        if(CompareTre!=0)
        return -CompareTre;
        int CompareTBC = Double.compare(this.tinhDiemTB(), other.tinhDiemTB());
        if(CompareTBC!=0)
        return CompareTBC;
        String[] thisSV=this.hoTen.split(" ");
        String[] otherSV=other.hoTen.split(" ");
        int CompareTen = thisSV[0].compareTo(otherSV[0]);
        if(CompareTen !=0)
        return CompareTen;
        if(thisSV.length >=2 && otherSV.length>=2 )
        {
            int CompareHoDem=0;
            int n=Math.min(thisSV.length,otherSV.length);
            for(int i=0;i<n;i++)
            {
                CompareHoDem=thisSV[i].compareTo(otherSV[i]);
                if(CompareHoDem!=0)
                return CompareHoDem;
            }
        }
        return 0;
    }
    public Date getNgaySinh()
    {
        return this.NgaySinh;
    }
    public String getHoTen()
    {
        return this.hoTen;
    }
}
