/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DAM-2
 */
public class VistaConsultarTabla extends JScrollPane{
    
    private JTable tabla;
    private DefaultTableModel modeloCoches;
    String[] cabecera = {"CodCoche", "Marca", "Modelo", "Matricula", "Tipo Revision", "Fecha ultima revisión", "Fecha nueva revisión"};
    
    public VistaConsultarTabla(){
        
       tabla = new JTable();
       modeloCoches = new DefaultTableModel();
       tabla.setModel(modeloCoches);
       addcolumnas(cabecera);
       
       this.setViewportView(tabla);
    }
    
    public void listarCoches(DefaultTableModel modelo){
        tabla.setModel(modelo);
    }
    
    public void addcolumnas(String[] cabecera){
        modeloCoches.setColumnIdentifiers(cabecera);
    }
    
    public void addFila(Object[] fila){
        modeloCoches.addRow(fila);
    }
    
    
}
