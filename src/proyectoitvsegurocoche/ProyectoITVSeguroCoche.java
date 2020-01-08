/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoitvsegurocoche;

import java.text.ParseException;
import javax.swing.JFrame;
import modelo.ModeloVehiculos;
;
import vista.VistaConsultarTabla;
import vista.VistaVehiculos;import vista.VistaConsultarTabla;
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
        VistaConsultarTabla vistaConsultar = new VistaConsultarTabla();
        vista.VistaVehiculos vistaVehiculo = new VistaVehiculos();
        
        ModeloVehiculos modelo = new ModeloVehiculos();
        
        //ControladorPrincipal controlador = new ControladorPrincipal(ventana, new ContenedorUsuarios());
        ventana.add(vistaVehiculo);
        
        //vistaPrincipal.addControlador(controlador);
        
        ventana.setVisible(true);
        ventana.setSize(600, 400);
        //ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
