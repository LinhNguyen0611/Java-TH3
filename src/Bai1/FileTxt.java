/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author Linh Nguyen
 */
public class FileTxt {
    int []A;
    int []B;
    int []C;

    int lengA, lengB, lengC;

    Scanner inp = new Scanner(System.in);

    public void funA() throws Exception{
        // ghi mang int vao a1.txt
        System.out.println("\nNhập mãng A ");
        System.out.print("Bạn muốn nhập bao nhiêu số ? : ");
        lengA  = inp.nextInt();
        A = new int[lengA];
        for (int i = 0 ;i <lengA ;i++)
        {
            System.out.print("A["+i+"] = ") ;
            A[i] = inp.nextInt();
        }
        this.writeArray("a1.txt", "A", A,lengA);

        //đọc từ a1.txt tạo thành chuỗi A và in ra
        BufferedReader reader = new BufferedReader( new FileReader("a1.txt"));
        lengA = Integer.parseInt(reader.readLine());
        A = new int[lengA];
        while (true){
            String readline = reader.readLine();
            if (readline == null)
                break;
            String [] temp = readline.split("\t");
            for (int i = 0 ; i < temp.length ; i++)
            {
                A[i] = Integer.parseInt(temp[i]);
            }
        }

        this.printArray("A",A,lengA);
        reader.close();
        //System.out.print("ok");

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
        this.writeArray("b1.txt", "B", B ,lengB);
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
        this.writeArray("c1.txt", "C", C, lengC);
    }
    public void Write() throws Exception {
        BufferedWriter writer = new BufferedWriter( new FileWriter("demo2.txt",false));
        System.out.println("\nGhi chuỗi vào file demo2.txt");
        System.out.print("Bạn muốn nhập bao nhiêu số ? : ");
        int n  = inp.nextInt();
        String t = String.valueOf(n);

        writer.write(t);
        writer.newLine();
        for (int i = 0 ;i < n ;i++){
            int temp = inp.nextInt();
            String s = String.valueOf(temp);
            writer.write(s);
            writer.write("\t");
        }
        System.out.print("Chương trình đã ghi vào file demo2.txt");
        writer.flush();
        writer.close();
    }

    public void Read() throws Exception {
        BufferedReader reader = new BufferedReader( new FileReader("demo2.txt"));
        System.out.println("\nChương trình đọc nội dung file demo2.txt");
        String t = reader.readLine();
        int n = Integer.valueOf(t);
        System.out.println(n);
        /*while (true){
           String s = reader.readLine();
            if (s ==null)
                break;
            System.out.print(s);
        }*/
        String temp = reader.readLine();
        String[] t2 = temp.split("\t",n);
        for (int i = 0 ; i < t2.length;i++)
            System.out.printf(t2[i]+"\t");
        // Chương trình chưa tối ưu hóa, chưa chuyển mãng String t2 thành mãng Int để xử dụng sau này
        System.out.print("\nChương trình đã đọc file demo2.txt");
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
        BufferedWriter writer = new BufferedWriter( new FileWriter(filename,false));
        writer.write(String.valueOf(leng));
        writer.newLine();
        for (int i = 0 ;i < leng ;i++){
            writer.write(String.valueOf(Arr[i]));
            writer.write("\t");
        }
        writer.flush();
        writer.close();
    }
}
