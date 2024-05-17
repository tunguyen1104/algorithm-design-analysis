package b11;

import java.util.HashSet;

public class SinhVien {
    private String masv;
    private String ten;
    private String ngaySinh;
    private String que;
    private HashSet<Subject> monHoc;
    public SinhVien() {
        this.masv = "";
        this.ten = "";
        this.ngaySinh = "";
        this.que = "";
        monHoc = new HashSet<>();
    }
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getMasv() {
        return masv;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public HashSet<Subject> getMonHoc() {
        return monHoc;
    }
    public double tinhDiemTBCHocKy(int kyThu) {
        double tongDiem = 0;
        int cnt = 0;

        for(Subject mon : monHoc) {
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
    public double tinhDiemTB() {
        double tongDiem = 0;
        int cnt = 0;

        for (Subject mon : monHoc) {
            tongDiem += mon.getDiem();
            cnt++;
        }

        if (cnt == 0) {
            return 0;
        }

        return tongDiem / cnt;
    }
    public String toString(int kyThu) {
        String formattedTen = String.format("%-15s", ten);
        String formattedNgaySinh = String.format("%10s", ngaySinh);
        String formattedQue = String.format("%10s", que);
        return formattedTen + "\t" + formattedNgaySinh + "\t" + formattedQue + "\t\t" + this.tinhDiemTBCHocKy(kyThu);
    }
    @Override
    public String toString() {
        String formattedTen = String.format("%-15s", ten);
        String formattedNgaySinh = String.format("%10s", ngaySinh);
        String formattedQue = String.format("%10s", que);
        return formattedTen + "\t" + formattedNgaySinh + "\t" + formattedQue;
    }
}

