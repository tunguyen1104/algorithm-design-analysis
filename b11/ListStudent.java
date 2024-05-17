package b11;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ListStudent {
    private List<SinhVien> listStudent;
    public ListStudent() {
        try {
            listStudent = docDuLieuTuExcel("b11/list_class.xlsx");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<SinhVien> docDuLieuTuExcel(String fileName) throws IOException {
        List<SinhVien> sinhViens = new ArrayList<>();
        try (FileInputStream inputStream = new FileInputStream(fileName);
             XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {
            XSSFSheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Bỏ qua hàng tiêu đề
                Iterator<Cell> cellIterator = row.cellIterator();

                SinhVien sinhVien = new SinhVien();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                        case 0:
                            sinhVien.setMasv(getStringValue(cell));
                            break;
                        case 1:
                            sinhVien.setTen(getStringValue(cell));
                            break;
                        case 2:
                            sinhVien.setNgaySinh(getStringValue(cell));
                            break;
                        case 3:
                            sinhVien.setQue(getStringValue(cell));
                            break;
                    }
                }
                sinhViens.add(sinhVien);
            }
        }
        return sinhViens;
    }

    private String getStringValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            default:
                return "";
        }
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
//        for(SinhVien sv : listStudent) {
//            sv.getMonHoc().add(new Subject("Toán",1,6));
//            sv.getMonHoc().add(new Subject("Văn",1,4.5));
//            sv.getMonHoc().add(new Subject("Anh",1,8));
//        }
    }
    public void tongKetHocKy(int kyThu) {
        System.out.println("\n___________In 10 sinh viên có điêm TBC cao nhất ___________");
        Collections.sort(listStudent, (s1, s2) -> Double.compare(s2.tinhDiemTBCHocKy(kyThu), s1.tinhDiemTBCHocKy(kyThu)));
        System.out.println(String.format("\t %3s \t\t%9s \t\t %3s \t\t %12s", "Ten" , "Ngay Sinh", "Que", "DiemTBC ky " + kyThu));
        for (int i = 0; i < 10 && i < listStudent.size(); i++) {
            SinhVien sv = listStudent.get(i);
            System.out.println(sv.toString(kyThu));
        }
    }
    public void inDanhSachLopTheoTen() {
        System.out.println("\n___________In danh sách lớp theo tên___________");
        Collections.sort(listStudent, (s1, s2) -> compareNames(s1.getTen(),s2.getTen()));
        for (SinhVien sinhVien : listStudent) {
            System.out.println(sinhVien.toString());
        }
    }
    public void inDanhSachLopTheoNgaySinh() {
        System.out.println("\n__________In danh sách lớp theo ngày sinh____________");
        Collections.sort(listStudent, (s1, s2) -> compareDate(s1.getNgaySinh(),s2.getNgaySinh()));
        for (SinhVien sinhVien : listStudent) {
            System.out.println(sinhVien.toString());
        }
    }
    public void inDanhSachLopTheoQue() {
        System.out.println("\n__________In danh sách lớp theo quê quán____________");
        Collections.sort(listStudent, (s1, s2) -> compareHometown(s1,s2));
        for (SinhVien sinhVien : listStudent) {
            System.out.println(sinhVien.toString());
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
    private int compareNames(String name1, String name2) {
        String[] parts1 = name1.split(" ");
        String[] parts2 = name2.split(" ");

        int lastIndex1 = parts1.length - 1;
        int lastIndex2 = parts2.length - 1;
        if (lastIndex1 >= 0 && lastIndex2 >= 0) {
            int compareLastName = parts1[lastIndex1].compareToIgnoreCase(parts2[lastIndex2]);
            if (compareLastName != 0) {
                return compareLastName;
            }
        }
        return name1.compareToIgnoreCase(name2);
    }
    private int compareDate(String date1, String date2) {
        String[] parts1 = date1.split("/");
        String[] parts2 = date2.split("/");

        int compare = parts1[2].compareToIgnoreCase(parts2[2]);
        if (compare != 0) {
            return compare;
        }
        compare = parts1[1].compareToIgnoreCase(parts2[1]);
        if (compare != 0) {
            return compare;
        }
        return parts1[0].compareToIgnoreCase(parts2[0]);
    }
    public int compareHometown(SinhVien sv1, SinhVien sv2) {
        if(sv1.getQue().equals(sv2.getQue())) {
            return compareNames(sv1.getTen(), sv2.getTen());
        }
        return sv1.getQue().compareTo(sv2.getQue());
    }

}
