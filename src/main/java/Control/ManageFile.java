/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.util.Scanner;
import java.io.*;

/**
 *
 * @author EstudianteLIS
 */
public class ManageFile {

    public static void main(String[] args) throws IOException {
        Scanner s = null; //Delimitado por espacios por defecto
//s.useDelimiter(",\\s*");
//s.useDelimiter("\\t");
        try {
            s = new Scanner(new BufferedReader(new FileReader("Pages_1000.csv")));
            while (s.hasNext()) {
                System.out.println(s.next());
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}
