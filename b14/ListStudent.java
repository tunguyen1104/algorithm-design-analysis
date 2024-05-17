package b14;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ListStudent {
    private List<SinhVien> listStudent;
    public ListStudent() {
        try {
            listStudent = docDuLieuTuCSV("b14/sinhvien.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<SinhVien> docDuLieuTuCSV(String fileName) throws IOException {
        List<SinhVien> sinhViens = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean firstLine = true; // Để bỏ qua hàng tiêu đề
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] values = line.split(",");
                SinhVien sinhVien = new SinhVien();
                sinhVien.setMasv(values[0]);
                sinhVien.setTen(values[1]);
                sinhVien.setNgaySinh(values[2]);
                sinhVien.setQue(values[3]);
                sinhViens.add(sinhVien);
            }
        }
        return sinhViens;
    }
    public void nhapDiemMon() {
        Scanner sc = new Scanner(System.in);
        int chon;
        for(SinhVien sv : listStudent) {
            System.out.println("Nhập (Tên môn,học kỳ, điểm) sinh viên " + sv.getMasv() + " - " + sv.getTen() + ": ");
            do {
                String tenMonHoc = sc.next();
                int hocKy = Integer.parseInt(sc.next());
                double diem = Double.parseDouble(sc.next());
                sv.getMonHoc().add(new Subject(tenMonHoc,hocKy,diem));
                System.out.println("=> Bạn muốn nhập thêm môn khác không (1): Đồng ý (2): Từ chối ");
                chon = Integer.parseInt(sc.next());
            } while (chon != 2);
        }
    }
    public void inDanhSachLopTheoQue(String que) {
        System.out.println("\n__________In danh sách các sinh viên quê ở " + que + "____________");
        for (SinhVien sinhVien : listStudent) {
            if(sinhVien.getQue().equals(que))
                System.out.println(sinhVien.toString());
        }
    }
    public void indanhsachSinhvienTheoTBC(double diem) {
        System.out.println("\n__________In danh sách các sinh viên có điểm TBC >= " + diem + "____________");
        Collections.sort(listStudent, (s1, s2) -> comparePointAVG(s1.tinhDiemTB(),s2.tinhDiemTB()));
        for (SinhVien sinhVien : listStudent) {
            if(sinhVien.tinhDiemTB() < diem) return;
            System.out.println(sinhVien.toString());
        }
    }
    public int comparePointAVG(double diem1, double diem2) {
        if (diem1 > diem2) {
            return -1;
        } else if (diem1 < diem2) {
            return 1;
        } else {
            return 0;
        }
    }
}
