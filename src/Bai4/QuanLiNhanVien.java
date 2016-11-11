/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai4;
import Bai4.NhanVien;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Linh Nguyen
 */
public class QuanLiNhanVien {
    Scanner sca = new Scanner(System.in);
    ArrayList<NhanVien> myList = new ArrayList<NhanVien>();
    public void Input()
    {
        System.out.print("Số nhân viên : ");
        int n = sca.nextInt();
        for (int i = 1 ; i <= n ; i ++)
        {
            System.out.println("Nhân viên thứ" + i);
            NhanVien x = new NhanVien();
            x.Input();
            myList.add(x);
        }
    }
    
    public void Output()
    {
        System.out.println("Xuất thông tin nhân viên ");
        int dem = 0 ;
        for (NhanVien x : myList)
        {
            System.out.println("Thông tin nhân viên thứ "+ ++dem);
            x.Output();
        }
    }

    public void Write() throws Exception{
        BufferedWriter writer = new BufferedWriter(new FileWriter("NhanVienOutput.txt",false));
        writer.write(String.valueOf(myList.size())+"\n");
        writer.newLine();
        for (NhanVien x : myList)
        {
           writer.write(x.getMaNV()+"\t" + x.getHoTen() +"\t" + String.valueOf(x.getTuoi())+"\n");
           writer.newLine();
        }
        writer.flush();
        writer.close();
    }

    public void Read() throws Exception{
        myList.clear();

        BufferedReader reader = new BufferedReader(new FileReader("NhanVienOutput.txt"));
        int n = Integer.parseInt(reader.readLine());
        for (int i= 0 ; i < n ; i++)
        {
            String Readline = reader.readLine();
            String [] temp = Readline.split("\t");
            NhanVien x = new NhanVien(temp[0],temp[1],Integer.parseInt(temp[2]));
            myList.add(x);
        }
    }
}
