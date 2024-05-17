package b11;

public class Subject {

    private String tenMonHoc;
    private int hocKy;
    private double diem;
    public Subject(String tenMonHoc, int hocKy, double diem) {
        this.tenMonHoc = tenMonHoc;
        this.hocKy = hocKy;
        this.diem = diem;
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

