package b12;

public class Mon {

    private String tenMonHoc;
    private int hocKy;
    private double diem;
    public Mon(String tenMonHoc, int hocKy) {
        this.tenMonHoc = tenMonHoc;
        this.hocKy = hocKy;
        this.diem = -1;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public double getDiem() {
        return diem;
    }

    public int getHocKy() {
        return hocKy;
    }
}

