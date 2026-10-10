/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.WebPages;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author eliana
 */
public class PDF {
    public void generarReporteTabla(List<WebPages> listaPaginas, String rutaArchivo) throws Exception {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(rutaArchivo));
        document.open();

        Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
        Font fuenteFecha = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.ITALIC);

        document.add(new Paragraph("Reporte Actualizado de WebPages", fuenteTitulo));
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaTexto = "Fecha de generación: " + ahora.format(formato);

        document.add(new Paragraph(fechaTexto, fuenteFecha));
        document.add(new Paragraph(" "));
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100);

        // Encabezados
        table.addCell("Index");
        table.addCell("Page ID");
        table.addCell("URL");
        table.addCell("Title");
        table.addCell("Text");
        table.addCell("Task");

        for (WebPages p : listaPaginas) {
            table.addCell(String.valueOf(p.getIndex()));
            table.addCell(p.getPageID());
            table.addCell(p.getUrl());
            table.addCell(p.getPageTitle());
            table.addCell(p.getPageText());
            table.addCell(p.getExtractionTask());
        }
        document.add(table);
        document.close();
    }
}

