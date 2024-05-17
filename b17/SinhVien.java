package b17;

import edu.princeton.cs.algs4.Inversions;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;

public class SinhVien implements Comparable<SinhVien>
{
    private String hoten;
    public SinhVien(String hoten)
    {
        this.hoten=hoten;
    }
    public String getHoTen(){
        return this.hoten;
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
        return 0;
    }
}