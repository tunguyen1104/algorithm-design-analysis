package b10;

public class Main {
    public static void main(String[] args) {
        SinhVien sinhVien1 = new SinhVien("Nguyễn Văn A", "SV123");
        sinhVien1.nhapDiemMonHoc(new Mon("123", "Toan", 1), 8);
        sinhVien1.nhapDiemMonHoc(new Mon("124", "Ly", 1), 9);
        sinhVien1.nhapDiemMonHoc(new Mon("125", "Hoa", 2), 7);
        System.out.println("Điểm TB: " + sinhVien1.tinhDiemTB());
        System.out.println("Điểm TB hk1: " + sinhVien1.tinhDiemTBCHocKy(1));
    }
}
