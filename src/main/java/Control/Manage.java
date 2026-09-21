/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.WebPages;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * @author Eliana
 */
public class Manage implements ManagerPageView{
    
    @Override
    public List<WebPages> pagesView() {
        CSV_Reader read = new CSV_Reader();
        return read.readFile("Pages_1000.csv");
    }
    public void printTable(JTable table, List<WebPages> list) {
    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
    tableModel.setRowCount(0); // Limpia filas previas

    for (WebPages page : list) {
        tableModel.addRow(new Object[]{
            page.getIndex(),
            page.getPageID(),
            page.getUrl(),
            page.getPageTitle(),
            page.getPageText(),
            page.getExtractionTask()
        });
    }
}
    public void printTable(JTable table) {
    printTable(table, pagesView()); // Llama al método de arriba pasándole la lista completa
}
    public List<WebPages> search(List<WebPages> list, String indexSearch, String pageTitleSearch){
        List<WebPages> result = new ArrayList();
        
        String index = indexSearch.trim();
        String pageTitle = pageTitleSearch.trim().toLowerCase(); //equalsIgnoreCase
        
        for (WebPages page: list){
            boolean equalsIndex = index.isEmpty() || String.valueOf(page.getIndex()).equals(index);
            boolean equalsPageTitle = pageTitle.isEmpty() || page.getPageTitle().toLowerCase().contains(pageTitle);
            
            if (equalsIndex && equalsPageTitle){
                result.add(page);
            }
        }
        return result;
    }

}

