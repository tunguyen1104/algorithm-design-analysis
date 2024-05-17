package b13;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import  java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SinhVien implements Comparable<SinhVien>
{
    private String hoten;
    private Date ngaysinh;
    public SinhVien(String hoten,Date date)
    {
        this.hoten=hoten;
        this.ngaysinh=date;
    }
    public String getHoTen(){
        return this.hoten;
    }
    public Date getNgaySinh(){
        return this.ngaysinh;
    }
    @Override
    public int compareTo(SinhVien other)
    {
        String[] thisSV=this.hoten.split(" ");
        String[] otherSV=other.hoten.split(" ");
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
        return 0;//this.ngaysinh.compareTo(other.getNgaySinh());
    }
}