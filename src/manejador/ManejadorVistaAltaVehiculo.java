/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;


import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;


import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Vehiculo;
import vista.VistaCocheAlta;



/**
 *
 * @author samuel
 */
public class ManejadorVistaAltaVehiculo implements ActionListener{
    private static final String BD_VEHICULOS = "src/bd/BaseDatosVehiculos.oo";
    JFrame ventana;
    Vehiculo vehiculo;
    VistaCocheAlta vistaAlta;
    JDialog dialogAltaVehiculo;
    
    public ManejadorVistaAltaVehiculo(vista.VistaCocheAlta vistaAltaInicial, JDialog dialogAltaVehiculoInicial){
        this.vistaAlta = vistaAltaInicial;
        this.dialogAltaVehiculo = dialogAltaVehiculoInicial;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String comando = e.getActionCommand();
        Vehiculo vehiculo;
        ObjectContainer db;
        EmbeddedConfiguration configuracion = Db4oEmbedded.newConfiguration();
    
        switch(comando){
            case "Aceptar":
               db = abrirBd(configuracion);
               vehiculo = obtenerDatos();
               insertarVehiculo(db, vehiculo);
               db.close();
            break;
            
            case "Cancelar":
                dialogAltaVehiculo.dispose();
            break;
        }
    }
   
    private static ObjectContainer abrirBd(EmbeddedConfiguration configuracion) {
       
        EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
        ObjectContainer db = Db4oEmbedded.openFile(config, BD_VEHICULOS);

       return db;
    
    }

    private Vehiculo obtenerDatos() {
       
        String marca, modelo, matricula, tipoRevisionITV, fechaRevision, fechaseguro;
        double precioSeguro;
        Vehiculo vehiculo = null;
        
        marca = vistaAlta.getMarca();
        modelo = vistaAlta.getModelo();
        matricula = vistaAlta.getMatricula();
        tipoRevisionITV = vistaAlta.getListaTipoRevision();
        fechaRevision = vistaAlta.getFechaITV();
        fechaseguro = vistaAlta.getFechaSeguro();
        precioSeguro = vistaAlta.getPrecioSeguro();
        
        vehiculo = new Vehiculo(marca, modelo, matricula, tipoRevisionITV, fechaRevision, fechaseguro, precioSeguro);
                
        return vehiculo;
    }

    private void insertarVehiculo(ObjectContainer db, Vehiculo vehiculo) {
        
        Vehiculo vehiculoPatron;
        String matriculaObtenida;
        
        matriculaObtenida = vehiculo.getMatricula();
        
        vehiculoPatron = new Vehiculo(matriculaObtenida);
       
        ObjectSet<Vehiculo> resul= db.queryByExample(vehiculoPatron);
        
        if(resul.size() == 0){
            JOptionPane.showMessageDialog(null, "Registrado correctamente", "Registro", JOptionPane.PLAIN_MESSAGE);
            db.store(vehiculo);
        }else{
            JOptionPane.showMessageDialog(null, "Error. Ya existe un vehiculo con esa matricula", "Registro", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
