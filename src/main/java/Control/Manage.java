/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.WebPages;
import java.io.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *Llena el JTable con los datos provenientes de la lista de WebPages.
 * @author EstudianteLIS
 */
public class Manage {
    
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
    
    public List<WebPages> cargarCSV() {
    List<WebPages> pagesView = new ArrayList<>(); // Instanciamos la lista vacía
    Scanner s = null;

    try {
        // Leemos el archivo CSV
        s = new Scanner(new BufferedReader(new FileReader("Pages_1000.csv")));
        
        // Si el CSV tiene títulos en la primera línea, la saltamos:
        if (s.hasNextLine()) {
            s.nextLine(); 
        }

        // Recorremos el archivo línea por línea
        while (s.hasNextLine()) {
            String linea = s.nextLine();
            
            // Separamos por comas (o usa linea.split(",\\s*") si hay espacios tras la coma)
            String[] columnas = linea.split(","); 

            // Extraemos de forma explícita cada columna por su atributo
            int index = Integer.parseInt(columnas[0].trim());
            String pageID = columnas[1].trim();
            String url = columnas[2].trim();
            String pageTitle = columnas[3].trim();
            String pageText = columnas[4].trim();
            String extractionTask = columnas[5].trim();
            // String columna4 = columnas[3].trim(); // agrega más según las columnas de tu CSV

            // Creamos el objeto WebPages asignando sus atributos
            WebPages pagina = new WebPages(index, pageID, url, pageTitle, pageText, extractionTask);

            // Guardamos el objeto en el ArrayList
            pagesView.add(pagina);
        }

    } catch (IOException e) {
        System.err.println("Error al cargar el archivo: " + e.getMessage());
    }catch (NumberFormatException e){
        System.out.println("Error de formato numérico en la columna index: "+ e.getMessage());
    } finally {
        if (s != null) {
            s.close(); // Cerramos el Scanner explícitamente
        }
    }

    return pagesView; // Retornamos el ArrayList con los objetos guardados
}
    public void printTable(JTable tabla) {
    List<WebPages> lista = cargarCSV();

    DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
    modeloTabla.setRowCount(0); // Limpia filas previas

    for (WebPages page : lista) {
        modeloTabla.addRow(new Object[]{
            page.getIndex(),
            page.getPageID(),
            page.getUrl(),
            page.getPageTitle(),
            page.getPageText(),
            page.getExtractionTask()
        });
    }
}
}

