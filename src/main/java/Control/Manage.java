/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.WebPages;
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
    public void printTable(JTable table) {
    List<WebPages> list = pagesView();

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
}

