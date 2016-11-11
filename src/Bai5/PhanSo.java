/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai5;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Linh Nguyen
 */
public class PhanSo {
    Scanner inp = new Scanner(System.in);
    int Tu ,Mau;
    PhanSo()
    {

    }

    PhanSo( int a, int b)
    {
        Tu =a ;
        Mau = b;
    }


    public void Set(int a, int b)
    {
        Tu =a ;
        Mau = b;
    }
    // Function Swap
    public void Swap(PhanSo b)
    {
        PhanSo temp = new PhanSo();
        temp.Set(this);
        this.Set(b);
        b.Set(temp);
    }
    // Tính tổng hai phân số
    public PhanSo Tong(PhanSo b)
    {
        PhanSo temp = new PhanSo();
        temp.Tu = this.Tu * b.Mau + this.Mau * b.Tu;
        temp.Mau = this.Mau * b.Mau;
        temp.RutGon();
        return temp;
    }

    // Tích hai phân số
    public PhanSo Tich(PhanSo b)
    {
        PhanSo temp = new PhanSo();
        temp.Tu = this.Tu * b.Tu;
        temp.Mau = this.Mau * b.Mau;
        temp.RutGon();
        return temp;
    }

    public boolean SoSanh(PhanSo b)
    {
        float temp = ((float)Tu / (float)Mau )-((float)b.Tu - (float) b.Mau);
        if (temp > 0)
            return true;
        return false;
    }
    public String Get()
    {
        return String.valueOf(Tu)+"/" + String.valueOf(Mau);
    }

    public void Set(PhanSo b)
    {
        this.Tu = b .Tu;
        this.Mau = b.Mau;
    }
    
    public int USCLN(int a, int b)
    {
        a = Math.abs(a);
        b = Math.abs(b);
        while(a!=b)
        {
            if(a>b) a=a-b;
            else b=b-a;
        }
        return a;
    }

    public void RutGon()
    {
        int i=USCLN(this.Tu,this.Mau);
        this.Tu = Tu/ i;
        this.Mau =Mau /i;
    }

}
