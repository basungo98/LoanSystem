/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.logic;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.kernel.colors.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author user
 */
public class Report {
    Document document;

    public Report(String pdfName) throws FileNotFoundException {
        PdfWriter writer = new PdfWriter(pdfName);
        PdfDocument pdf = new PdfDocument(writer);
        document = new Document(pdf, PageSize.A4.rotate());
        document.setMargins(20, 20, 20, 20);
    }
   
    public boolean setImage(String name){ 
        try {
            ImageData data = ImageDataFactory.create(getClass().getResource(name));
            Image img = new Image(data);
            document.add(img);
        } catch (Error e) {
           return false;
        }
        
        return true;
    }
    
    public boolean setParagraph(String paragraph){
        try {
            PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
            document.add(new Paragraph(paragraph).setFont(font).setBold().setFontSize(20f));
        } catch (IOException ex) {
            return false;
        }
        
        return true;
    }
    
    public boolean setHeaderRow (Table table, List<String> content,  Color background, Color textColor){
        try {
            for (int i = 0; i < content.size(); i++) {
                String head = content.get(i);
                Cell cell = new Cell();
                cell.add(new Paragraph(head)).setBackgroundColor(background).setFontColor(textColor);
                table.addHeaderCell(cell); 

            }   
        } catch (Exception e) {
            return false;
        }
       
        return true;
    }
    
    public boolean setRow (Table table, List<String> content,  Color background, Color textColor){
        try {
            for (int i = 0; i < content.size(); i++) {
                String head = content.get(i);
                Cell cell = new Cell();
                cell.add(new Paragraph(head)).setBackgroundColor(background).setFontColor(textColor);
                table.addCell(cell); 

            }   
        } catch (Exception e) {
            return false;
        }
       
        return true;
    }
    
    public void addTable(Table table){
         document.add(table);
    }
    
    public void close(){
        document.close();
    }
    
}
