/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai4;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
/**
 *
 * @author Linh Nguyen
 */
public class NhanVien {
    Scanner inp = new Scanner(System.in);
    String MaNV, HoTen;
    int Tuoi;

    NhanVien(){

    }


    NhanVien(String a, String b, int c)
    {
        MaNV = a;
        HoTen = b;
        Tuoi =c;
    }
    public void Input()
    {
        System.out.print("Nhập MSNV : ");
        this.MaNV = inp.nextLine();
        System.out.print("Nhập họ tên nhân viên : ");
        this.HoTen = inp.nextLine();
        System.out.print("Nhập tuổi nhân viên : ");
        this.Tuoi = inp.nextInt();
    }

    public void Output()
    {
        System.out.println("MSNV : " + this.MaNV);
        System.out.println("Họ Tên : "+this.HoTen);
        System.out.println("Tuổi : "+this.Tuoi);
    }

    public  String getMaNV() {
        return this.MaNV;
    }

    public String getHoTen() {
        return this.HoTen;
    }

    public int getTuoi(){
        return this.Tuoi;
    }
}
