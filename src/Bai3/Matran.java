/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai3;
import java.io.*;
import java.util.*;
/**
 *
 * @author Linh Nguyen
 */
public class Matran {
    int n, m;
    int [][] A ;

    public void Write() throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter("MaTran.txt",false));
        n = (int)(Math.random() * 10);
        m = (int)(Math.random() * 10);
        A = new int [n][m];
        writer.write(String.valueOf(n));
        writer.newLine();
        writer.write(String.valueOf(m));
        writer.newLine();
        int temp = 1;
        for (int i = 0 ; i < n ; i++)
            for (int j = 0 ; j< m ;j++)
                A[i][j] = (int)(Math.random() * 234);

        for (int i = 0 ; i < n ; i++)
            for (int j = 0 ; j< m ;j++) {
                String t = String.valueOf(A[i][j]);
                writer.write(t);
                if (j == m - 1)
                    writer.newLine();
                else
                    writer.write("\t");

            }

        writer.flush();
        writer.close();

    }

    public void Read() throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader("MaTran.txt"));
        n = Integer.parseInt(reader.readLine());
        m = Integer.parseInt(reader.readLine());
        A = new int[n][m];
        System.out.println(n);
        System.out.println(m);




        for (int i = 0 ; i < n ;i++)
        {
            String readline =reader.readLine();
            String [] temp = readline.split("\t");
            for (int j = 0 ; j < m ;j++)
            {
                A[i][j] = Integer.parseInt(temp[j]);
            }
        }

        for (int i = 0 ; i < n ; i++)
            for (int j = 0 ;j < m; j ++)
            {
                if (j == m -1)
                    System.out.print(A[i][j]+"\n");
                else
                    System.out.print(A[i][j]+"\t");
            }
    }

    public void func() throws Exception {
        int Max = A[0][0];
        int Min = A[0][0];
        int Sum = 0;
        List myList = new ArrayList();
        for (int i = 0 ; i< n ; i++)
            for (int j = 0 ; j < m ; j++)
            {
                if (A[i][j] > Max )
                    Max =A[i][j];

                if (A[i][j] < Min)
                    Min = A[i][j];

                Sum += A[i][j];

                if (this.isPrime(A[i][j]))
                {
                    myList.add(A[i][j]);
                    System.out.print(A[i][j]+"\t");
                }

            }
        BufferedWriter writer = new BufferedWriter(new FileWriter("KetQuaMaTran.txt",false));
        writer.write("Giá trị nhỏ nhất của ma trận = " + String.valueOf(Min)+"\n");
        writer.newLine();
        writer.write("Giá trị lớn nhất của ma trận = " + String.valueOf(Max)+"\n");
        writer.newLine();
        writer.write("Tổng các phần tử trong ma trận = " + String.valueOf(Sum) +"\n");
        if (myList.isEmpty())
            writer.write("Không có số nguyên tố nào");
        else
        {
            writer.newLine();
            writer.write("Các số nguyên tố của ma trận: ");
            for (int i = 0 ; i < myList.size();i++)
                writer.write(String.valueOf(myList.get(i))+ "\t");
        }
        writer.flush();
        writer.close();

        System.out.print("\nXem kết quả ở file KetQuaMaTran.txt");

    }

    public boolean isPrime( int n )
    {
        int dem = 0;
        for (int i = 1 ; i <= n  ;i++)
            if (n%i == 0)
                dem++;
        if (dem == 2)
            return true;
        return false;
    }
}
