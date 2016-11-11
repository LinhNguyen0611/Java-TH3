/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai5;

/**
 *
 * @author Linh Nguyen
 */
public class MainBai5 {
    public static void main(String[] args) throws Exception {
        XuliFile file = new XuliFile();
        // Đọc file input
        file.Read();
        // Xử lí
        file.Xuli();
        // Ghi lại vào file output
        file.Write();
    }
}
