package b10;

import java.util.HashSet;

public class SinhVien {

    private String hoTen;
    private String maSV;
    private HashSet<Mon> monHoc;

    public SinhVien(String hoTen, String maSV) {
        this.hoTen = hoTen;
        this.maSV = maSV;
        this.monHoc = new HashSet<>();
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
}
