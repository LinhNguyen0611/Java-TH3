/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;
import javax.crypto.Mac;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Linh Nguyen
 */
public class FileBin {
    int []A;
    int []B;
    int []C;

    int lengA, lengB, lengC;
    Scanner inp = new Scanner(System.in);
    public void funA() throws Exception {
        // ghi mang int vao a.bin
        System.out.println("\nNhập mãng A ");
        System.out.print("Bạn muốn nhập bao nhiêu số ? : ");
        lengA  = inp.nextInt();
        A = new int[lengA];
        for (int i = 0 ;i <lengA ;i++)
        {
            System.out.print("A["+i+"] = ") ;
            A[i] = inp.nextInt();
        }
        this.writeArray("a.bin", "A", A,lengA);


        //đọc từ a.bin tạo thành chuỗi A và in ra
        FileInputStream fin = new FileInputStream("a.bin");
        String StrA ="";
        while (true){
            char temp = (char)fin.read();
            StrA  += temp;
            if (fin.available() == 0)
                break;
        }
        String [] temp = StrA.split("\n",2);
        lengA = Integer.parseInt(temp[0]);
        A = new int[lengA];
        String [] temp2 = temp[1].split("\t");
        for (int i = 0 ; i < temp2.length ; i++)
        {
            A[i] = Integer.parseInt(temp2[i]);
        }
        this.printArray("A",A,lengA);
        fin.close();
    }

    public void funB() throws Exception {
        System.out.println("\nNhập mãng B ");
        System.out.print("Bạn muốn nhập bao nhiêu số ? : ");
        lengB  = inp.nextInt();
        B = new int[lengB];
        for (int i = 0 ;i < lengB ;i++){
            B[i] = (int)(Math.random() * 101);
        }
        this.printArray("B", B,lengB);
    }

    public void funC() throws Exception {
        this.writeArray("b.bin", "B", B ,lengB);
    }

    public void funD() throws Exception {
        lengC = lengA;
        C = new int[lengC];
        for (int i = 0 ; i < lengA ; i++)
            C[i] = A[i];
        printArray("C", C,lengC);
    }

    public void funE() throws Exception {
        System.out.println("\nĐang đảo vị trí ");
        for (int i = 0 ; i < 2 ;i++)
            C[i] = B[lengA - i -1];
        printArray("C", C,lengC);
    }

    public void funF() throws Exception {
        Arrays.sort(C);
        System.out.println("\nĐang sắp xếp :");
        this.printArray("C", C, lengC);
        this.writeArray("c.bin", "C", C, lengC);

    }

    public void printArray( String name, int [] Arr , int leng)
    {
        System.out.printf("\nmãng " + name + " : ");
        for (int i = 0 ; i < leng ; i++)
        {
            System.out.printf(Arr[i]+"\t");
        }
    }

    public void writeArray(String filename,String name, int [] Arr , int leng) throws Exception {
        System.out.printf("\nĐang ghi mãng "+name+ " vào file "+ filename );
        FileOutputStream fos = new FileOutputStream( filename ,false);
        fos.write(String.valueOf(leng).getBytes());
        fos.write("\n".getBytes());
        for (int i = 0 ;i < leng ;i++){
            String s = String.valueOf(Arr[i]);
            fos.write(s.getBytes());
            fos.write("\t".getBytes());
        }
        fos.close();
    }
}
