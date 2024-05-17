package b14;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListStudent list = new ListStudent();
        list.nhapDiemMon();
        System.out.print("\n- Enter hometown: ");
        String que = sc.nextLine();
        list.inDanhSachLopTheoQue(que);
        list.indanhsachSinhvienTheoTBC(7);
        sc.close();
    }
}
