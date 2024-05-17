package b11;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListStudent list = new ListStudent();
        list.nhapDiemMon();
        System.out.println("Tổng kết học kỳ thứ: ");
        int kyThu = Integer.parseInt(sc.nextLine());
        list.tongKetHocKy(kyThu);
        list.inDanhSachLopTheoTen();
        list.inDanhSachLopTheoNgaySinh();
        list.inDanhSachLopTheoQue();
        list.indanhsachSinhvienTheoTBC(7);
        System.out.print("\n- Enter hometown: ");
        String que = sc.nextLine();
        list.inDanhSachLopTheoQue(que);
        sc.close();
    }
}
