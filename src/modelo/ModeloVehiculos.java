/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DAM-2
 */
public class ModeloVehiculos extends DefaultTableModel{
    
    //Formato tabla tipoColumnas = {Integer.class(CodCoche), String.class(Marca), String.class(Modelo), String.class(Matricula), String.class(TipoRevision), String.class(FechaUltimaRevision), String.class(FechaRevisionNueva), String.class(FechaSeguro), Double.class(PrecioSeguro)};
    private Class[] tipoColumnas = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class};

    public Class getColumnClass(int i){
        return tipoColumnas[i];
    }
    
    public boolean isCellEditable(int fila, int column){
        return false;
    }
}
