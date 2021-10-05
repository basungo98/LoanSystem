/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.presentation.loan_view;

/**
 *
 * @author user
 */

import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import system.logic.Loan;



public class LoanTableModel extends AbstractTableModel implements TableModel {
    String[] cols ={"Plazo", "Saldo", "Interés", "Cuota Mensual", "N° Abonos", "Total Abonos", "Fecha", "Estado" };
    List<Loan> rows;

    public  LoanTableModel(List<Loan> rows){
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
        Loan loan = rows.get(row);
        switch (col){
            case 0: return loan.getTerm();
            case 1: return (int)loan.getAmount();
            case 2: return (loan.getInterestRate() * 100) + "%";
            case 3: return (int)loan.getMonthlyFee();
            case 4: return loan.getExtraordinaryPaymentsSize();
            case 5: return loan.getExtraordinaryPaymentTotal();
            case 6: return loan.getFormatDate();
            case 7: return loan.isActive() ? "Activo" : "Inactivo";
            default: return "";
        }
    }    
}

