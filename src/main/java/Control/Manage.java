/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.WebPages;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

/**
 * @author Eliana
 */
public class Manage implements ManagerPageView{
    
    private List<WebPages> pages;
    
    public Manage(){
        CSV_Reader read = new CSV_Reader();
        this.pages = read.readFile("Pages_1000.csv");
    }
    @Override
    public List<WebPages> pagesView() {
        return this.pages;
    }
    @Override
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
    @Override
    public List<WebPages> search(List<WebPages> list, String indexSearch, String pageIDSearch){
        List<WebPages> result = new ArrayList();
        
        String index = indexSearch.trim();
        String pageID = pageIDSearch.trim().toLowerCase(); 
        
        for (WebPages page: list){
            boolean equalsIndex = index.isEmpty() || String.valueOf(page.getIndex()).equals(index);
            boolean equalsPageID = pageID.isEmpty() || page.getPageID().toLowerCase().contains(pageID);
            
            if (equalsIndex && equalsPageID){
                result.add(page);
            }
        }
        return result;
    }
    @Override
    public void clean(JTextField... fields){
        for (JTextField field : fields){
            if (field != null){
                field.setText("");
            }
        }
    }
    public void register(String index, String pageID, String url, String pageTitle, String pageText, String extractionTask){
        if (index.trim().isEmpty() || pageID.trim().isEmpty() || url.trim().isEmpty() || 
        pageTitle.trim().isEmpty() || pageText.trim().isEmpty() || extractionTask.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required", "EMPTY FIELDS", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            int Index = Integer.parseInt(index);
            for (WebPages page : this.pages){
                if (page.getIndex() == Index){
                    JOptionPane.showMessageDialog(null, "The index (" + Index + ") is already registered, please use a different one", "DUPLICATE INDEX", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            WebPages w = new WebPages(Index, pageID, url, pageTitle, pageText, extractionTask);
            this.pages.add(w);
            this.pages.sort(Comparator.comparingInt(WebPages::getIndex));
            addCSV();
            JOptionPane.showMessageDialog(null, "Data Successfully Added!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "The 'index' field must be a valid integer.", "ERROR", JOptionPane.ERROR_MESSAGE);
            
        } catch (Exception e){
            JOptionPane.showInternalMessageDialog(null, "An error occurred while saving: "+ e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void addCSV(){
        CSV_Reader save = new CSV_Reader();
        save.SaveCSV(this.pages);
    }
    public void delete(String indexSearch, String pageIDSearch) {
        String index = indexSearch.trim();
        String ID = pageIDSearch.trim();
        if (index.isEmpty() && ID.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter at least one piece of information to delete.", "EMPTY FIELDS", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            int parseIndex = -1;
            if (!index.isEmpty()) {
                parseIndex = Integer.parseInt(index);
            }
            final int targetIndex = parseIndex; //Que??
            int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record??", "CONFIRM DELETION", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirmation != JOptionPane.YES_OPTION) {
                return;
            }
            boolean eliminado = this.pages.removeIf(page -> {
                boolean equalsIndex = index.isEmpty() || (page.getIndex() == targetIndex);
                boolean equalsID = ID.isEmpty() || page.getPageID().equalsIgnoreCase(ID);

                return equalsIndex && equalsID;
            });
            if (eliminado) {
                addCSV();
                JOptionPane.showMessageDialog(null,"Record delete  successfully.","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,"No record  was found matching the entered data.","NO MATCHES",JOptionPane.WARNING_MESSAGE);
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"The 'index' field must be a valid integer.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error deleting the record: " + e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
