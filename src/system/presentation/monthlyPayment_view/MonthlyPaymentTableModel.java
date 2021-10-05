/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.presentation.monthlyPayment_view;

import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import system.logic.MonthlyPayment;

/**
 *
 * @author user
 */
public class MonthlyPaymentTableModel extends AbstractTableModel implements TableModel {
    String[] cols ={"N°", "Saldo", "Interés", "Amortización", "Cuota", "Fecha", "Estado"};
    List<MonthlyPayment> rows;

    public  MonthlyPaymentTableModel(List<MonthlyPayment> rows){
        this.rows = rows;
    }

    public int getColumnCount() {
        return cols.length;
    }

    public String getColumnName(int col){
        return cols[col];
    }

    public int getRowCount() {
        return rows.size();
    }
    
    public Object getValueAt(int row, int col) {
        MonthlyPayment mp = rows.get(row);
        switch (col){
            case 0: return mp.getNumber();
            case 1: return (int)mp.getBalance();
            case 2: return (int)mp.getInterest();
            case 3: return (int)mp.getAmortization();
            case 4: return (int)mp.getFee();
            case 5: return mp.getFormatDate();
            case 6: return mp.isPaid() ? "Cancelado" : "Pendiente";
            default: return "";
        }
    }    
}
