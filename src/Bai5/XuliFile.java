/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai5;
import Bai5.PhanSo;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Linh Nguyen
 */
public class XuliFile {
    Scanner inp = new Scanner(System.in);

    ArrayList<PhanSo> A = new ArrayList<PhanSo>();
    ArrayList<PhanSo> B = new ArrayList<PhanSo>();
    ArrayList<PhanSo> C = new ArrayList<PhanSo>();
    ArrayList<PhanSo> D = new ArrayList<PhanSo>();

    public void Read() throws Exception {
        BufferedReader reader = new BufferedReader ( new FileReader("input.txt"));


        String Readline;
        String []temp;

        Readline = reader.readLine();
        Readline = Readline.replace("/","\t");
        Readline = Readline.replace(",","\t");
        temp = Readline.split("\t");

        for (int i = 0 ; i < 3; i++)
        {
            PhanSo ps = new PhanSo();
            ps.Set(Integer.parseInt(temp[i*2]),Integer.parseInt(temp[i*2+1]));
            A.add(ps);
        }

        Readline = reader.readLine();
        Readline = Readline.replace("/","\t");
        Readline = Readline.replace(",","\t");
        temp = Readline.split("\t");

        System.out.println("Đọc file thành công ");

        for (int i = 0 ; i < 3; i++)
        {
            PhanSo ps = new PhanSo();
            ps.Set(Integer.parseInt(temp[i*2]),Integer.parseInt(temp[i*2+1]));
            B.add(ps);
        }
    }

    public void Write() throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt",false));
        String outStr= C.get(0).Get() +","+ C.get(1).Get()+","+ C.get(2).Get()+"\n";
        writer.write(outStr);
        outStr =D.get(0).Get() +"," +D.get(1).Get()+","+ D.get(2).Get()+"\n";
        writer.write(outStr);
        System.out.println("Xem kết quả ở file output.txt ");
        writer.flush();
        writer.close();

    }

    public void Xuli() {
        // Tính tổng hai phân số

        PhanSo temp0 = new PhanSo();
        temp0 = A.get(0).Tong(B.get(0));

        PhanSo temp1 = new PhanSo();
        temp1 = A.get(1).Tong(B.get(1));

        PhanSo temp2 = new PhanSo();
        temp2 = A.get(2).Tong(B.get(2));

        C.add(temp0);
        C.add(temp1);
        C.add(temp2);

        for (int i = 0 ; i< C.size(); i++)
            for (int j = i ; j < C.size();j++)
            {
                if (C.get(i).SoSanh(C.get(j)))
                    C.get(i).Swap(C.get(j));
            }

        // Tính tích hai phân số
        temp0 = A.get(0).Tich(B.get(0));
        temp1 = A.get(1).Tich(B.get(1));
        temp2 = A.get(2).Tich(B.get(2));
        D.add(temp0);
        D.add(temp1);
        D.add(temp2);

        for (int i = 0 ; i< D.size(); i++)
            for (int j = i ; j < D.size();j++)
            {
                if (D.get(i).SoSanh(D.get(j)))
                    //Hoán đổi
                    D.get(i).Swap(D.get(j));
            }
    }
}
