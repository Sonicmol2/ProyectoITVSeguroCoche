/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoitvsegurocoche;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import java.text.ParseException;
import javax.swing.JFrame;
import manejador.ManejadorVistaPrincipal;
import modelo.ModeloVehiculos;
import modelo.Vehiculo;

import vista.VistaPrincipal;
import vista.VistaVehiculos;


/**
 *
 * @author DAM-2
 */
public class ProyectoITVSeguroCoche {
    
    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
       
       
        JFrame ventana = new JFrame("Proyecto");
        vista.VistaPrincipal vistaPrincipal = new VistaPrincipal();
        manejador.ManejadorVistaPrincipal manejadorPrincipal = new ManejadorVistaPrincipal(ventana);
        
        vistaPrincipal.addControlador(manejadorPrincipal);
        ventana.setContentPane(vistaPrincipal);
        
        //vistaPrincipal.addControlador(controlador);
        
        ventana.setVisible(true);
        ventana.setSize(600, 400);
        //ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    
}
