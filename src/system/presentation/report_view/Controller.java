package system.presentation.report_view;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import system.Application;
import system.logic.Client;
import system.logic.Loan;
import system.logic.MonthlyPayment;
import system.logic.Report;
import system.logic.Service;

public class Controller {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        // invoke Model sets for initialization before linking to the view
        // problably get the data from Service
        view.setModel(model);
        view.setController(this);
    }
    
    public void getClient(String id){
        try {
            Client client = Service.instance().getClient(id);
            model.setClient(client);
            model.commit();
        } catch (Exception ex) {
            model.setClient(new Client());
            model.commit();
        }
    }
    
    public boolean userExist(String id) {
        return Service.instance().userExist(id);
    }
    
    public void show() {
        this.view.setVisible(true);
    }
    
    public void hide() {
        this.view.setVisible(false);
    }
    
    public void exit() {
        Service.instance().store();
    }
    
    public void showClientView(){
        this.hide();
        Application.CLIENT_VIEW.show();
    }    
    
    private Table getLoanTable( List<Loan> loans, Report report){
        List<String> headers= Arrays.asList("Plazo", "Saldo", "Interés", "Cuota Mensual", "N° Abonos", "Total Abonos", "Fecha", "Estado");
        Table table = new Table(headers.size(), true);
        report.setHeaderRow(table, headers, ColorConstants.CYAN, ColorConstants.BLACK);

        for (int i = 0; i < loans.size(); i++) {
            Loan loan = loans.get(i);
            List<String> row = new ArrayList<>();
            row.add(Integer.toString(loan.getTerm()));
            row.add(Integer.toString((int)loan.getAmount()));
            row.add((loan.getInterestRate() * 100) + "%");
            row.add(Integer.toString((int)loan.getMonthlyFee()));
            row.add(Integer.toString(loan.getExtraordinaryPaymentsSize()));
            row.add(Integer.toString((int)loan.getExtraordinaryPaymentTotal()));
            row.add(loan.getFormatDate());
            row.add(loan.isActive() ? "Activo" : "Inactivo");

            if(i%2 == 0) {
                report.setRow(table, row, ColorConstants.LIGHT_GRAY, ColorConstants.BLACK);
            } else {
                report.setRow(table, row, ColorConstants.WHITE, ColorConstants.BLACK);
            }
        }
        
        return table;
    }
    
    public boolean generateClientReport(){
        try {
            List<Client> clients = Service.instance().getClients();
            
            if(clients != null && clients.size() > 0){
                Report report = new Report("ClientsReport.pdf");
                report.setImage("/system/assets/report/logo.png");
                report.setParagraph("SISTEMA DE PRÉSTAMOS");
                report.setParagraph("Reporte de clientes");
                List<String> headers= Arrays.asList("Nombre", "Cédula", "Provincia", "Cantón", "Distrito");
                Table table = new Table(headers.size(), true);
                report.setHeaderRow(table, headers, ColorConstants.CYAN, ColorConstants.BLACK);
                
                for (int i = 0; i < clients.size(); i++) {
                    Client client = clients.get(i);
                    List<String> row = new ArrayList<>();
                    row.add(client.getName());
                    row.add(client.getId());
                    row.add(client.getProvince().getName());
                    row.add(client.getCanton().getName());
                    row.add(client.getDistrict().getName());
                    
                    if(i%2 == 0) {
                        report.setRow(table, row, ColorConstants.LIGHT_GRAY, ColorConstants.BLACK);
                    } else {
                        report.setRow(table, row, ColorConstants.WHITE, ColorConstants.BLACK);
                    }
                }
                
                report.addTable(table);
                report.close();
                
            } else {
                return false;
            }
            
        } catch (Exception ex) {
           return false;
        }
        return true;
    }
    
    
    public boolean generateLoanReport(String clientId){
        try {
            Client client = Service.instance().getClient(clientId);
            if (client != null) {
                List<Loan> loans = client.getLoans();
                if(loans != null && loans.size() > 0){
                    Report report = new Report("LoansReport.pdf");
                    report.setImage("/system/assets/report/logo.png");
                    report.setParagraph("SISTEMA DE PRÉSTAMOS");
                    report.setParagraph("Reporte de Préstamos del cliente: " + client.getName());
                    Table table = getLoanTable(loans, report);
                    report.addTable(table);
                    report.close();
                }
                
            }
        } catch (Exception ex) {
           return false;
        }
        
        return true;
    }
    
    
    public boolean generateMonthlyPaymentReport(String clientId, int selectedRow){
        try {
            Client client = Service.instance().getClient(clientId);
            if (client != null) {
                List<Loan> loans = client.getLoans();
                if(loans != null && loans.size() > 0){
                   Loan loan = loans.get(selectedRow);
                   List<MonthlyPayment> monthlyPayment = loan.getMonthlyPayments();
                    if(monthlyPayment != null && monthlyPayment.size() > 0){
                        Report report = new Report("MonthlyPaymentReport.pdf");
                        report.setImage("/system/assets/report/logo.png");
                        report.setParagraph("SISTEMA DE PRÉSTAMOS");
                        report.setParagraph("Cliente: " + client.getName());
                        report.setParagraph("Información del préstamo. ");
                        Table loanTable = getLoanTable(Arrays.asList(loan), report);
                        report.addTable(loanTable);
                        report.setParagraph("Reporte de mensualidades. ");
                        List<String> headers= Arrays.asList("N°", "Saldo", "Interés", "Amortización", "Cuota", "Fecha", "Estado");
                        Table table = new Table(headers.size(), true);
                        report.setHeaderRow(table, headers, ColorConstants.CYAN, ColorConstants.BLACK);
                        
                        for (int i = 0; i < monthlyPayment.size(); i++) {
                           MonthlyPayment mp = monthlyPayment.get(i);
                            List<String> row = new ArrayList<>();
                            row.add(Integer.toString(mp.getNumber()));
                            row.add(Integer.toString((int)mp.getBalance()));
                            row.add(Integer.toString((int)mp.getInterest()));
                            row.add(Integer.toString((int)mp.getAmortization()));
                            row.add(Integer.toString((int)mp.getFee()));
                            row.add(mp.getFormatDate());
                            row.add(mp.isPaid() ? "Cancelado" : "Pendiente");
                          

                            if(i%2 == 0) {
                                report.setRow(table, row, ColorConstants.LIGHT_GRAY, ColorConstants.BLACK);
                            } else {
                                report.setRow(table, row, ColorConstants.WHITE, ColorConstants.BLACK);
                            }
                        }

                        report.addTable(table);
                        report.close();
                    
                    } 
                    
                }
                
            }
        } catch (Exception ex) {
           return false;
        }
        
        return true;
    }
}