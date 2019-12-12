/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoitvsegurocoche;

import javax.swing.JFrame;
import javax.swing.JPanel;
import modelo.ModeloCoches;
import vista.VistaConsultar;
import vista.VistaPrincipal;

/**
 *
 * @author DAM-2
 */
public class ProyectoITVSeguroCoche {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame ventana = new JFrame("Proyecto");
        VistaConsultar vistaConsultar = new VistaConsultar();
        ModeloCoches modelo = new ModeloCoches();
        
        //ControladorPrincipal controlador = new ControladorPrincipal(ventana, new ContenedorUsuarios());
        ventana.add(vistaConsultar);
        
        //vistaPrincipal.addControlador(controlador);
        
        ventana.setVisible(true);
        ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
