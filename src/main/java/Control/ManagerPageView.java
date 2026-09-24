/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.WebPages; 
import java.util.List;
import javax.swing.JTable;
/**
 *
 * @author EstudianteLIS
 */
public interface ManagerPageView {
    List<WebPages> pagesView();
    public void printTable(JTable table, List<WebPages> list);
    public List<WebPages> search(List<WebPages> list, String indexSearch, String pageIDSearch);
}
