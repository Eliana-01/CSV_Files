/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import Model.WebPages;
import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author eliana
 */
public class CSV_Reader {
    
    public List<WebPages> readFile(String fileName){
        List<WebPages> list = new ArrayList<>();
        Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader(fileName)));
            
            if (s.hasNextLine()) {
                s.nextLine(); // Omitir encabezado
            }

            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] columnas = line.split(","); 

                int index = Integer.parseInt(columnas[0].trim());
                String pageID = columnas[1].trim();
                String url = columnas[2].trim();
                String pageTitle = columnas[3].trim();
                String pageText = columnas[4].trim();
                String extractionTask = columnas[5].trim();

                WebPages page = new WebPages(index, pageID, url, pageTitle, pageText, extractionTask);
                list.add(page);
            }

        } catch (IOException e) {
            System.err.println("Error al cargar el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error de formato numérico en la columna index: " + e.getMessage());
        } finally {
            if (s != null) {
                s.close();
            }
        }

        return list;
    }
    
    public void SaveCSV(List<WebPages> newList){
       try (PrintWriter pw = new PrintWriter(new FileWriter("Pages_1000.csv", false))) {
           for (WebPages obj : newList){
               pw.println(obj.toString()); //Mi metodo cual es el nombre
           }   
        }catch (IOException e){
            System.out.println("Error al guardar en el archivo: "+ e.getMessage());
        }
    }
    public static void main(String[] args) throws IOException { //Verificacion que todo esta bien con el archivo csv
        Scanner s = null; 
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
