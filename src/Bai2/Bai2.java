/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
/**
 *
 * @author Linh Nguyen
 */
public class Bai2 {
    int [][]a;
    int n ;

    Scanner sca = new Scanner(System.in);

    public void XuLi() throws  Exception {
        System.out.print("Nhập bậc n = ");
        n = sca.nextInt();
        a = new int[n][n];
        for (int i = 0;i< n;i++)
            for (int  j = 0;j <n;j++)
                a[i][j] = 0;

        for(int i=0; i<n; i++)
            for(int j=0; j<i+1; j++)
                a[i][j] = Pascal(i,j);

        // in
        for (int i = 0;i< n;i++)
            for (int  j = 0;j <n;j++)
            {
                if(a[i][j] != 0)
                    System.out.printf("%d\t",a[i][j]);
                if (j == n-1)
                    System.out.print("\n");
            }

        BufferedWriter writer = new BufferedWriter( new FileWriter("PascalOutput.txt",false));
        for (int i = 0;i< n;i++)
            for (int  j = 0;j <n;j++)
            {
                if(a[i][j] != 0){
                    writer.write(String.valueOf(a[i][j]));
                    writer.write("\t");
                }

                if (j == n-1)
                   writer.newLine();
            }
        writer.flush();
        writer.close();
    }
    public int Pascal(int n, int k)
    {
        if(k>n||k<0) return 0;
        return (k==0||k==n)?1:Pascal(n-1,k)+Pascal(n-1,k-1);
    }
}
