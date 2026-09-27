/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.WebPages; 
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author EstudianteLIS
 */
public interface ManagerPageView {
    List<WebPages> pagesView();
    public void printTable(JTable table, List<WebPages> list);
    public List<WebPages> search(List<WebPages> list, String indexSearch, String pageIDSearch);
    public void clean(JTextField... fields);
    public void register(String index, String pageID, String url, String pageTitle, String pageText, String extractionTask);
    public void delete(String indexSearch, String pageIDSearch);
}

//Cargar los objetos desde display hasta search y eliminar

//Funcion para actualizar datos

//Conservar la interface??

//Agregar el informe PDF

//Validaciones
    //Actualizar: que se cambie almenos un campo, y que el dato seleccionado en la tabla ya aparezca cargargo ahi.