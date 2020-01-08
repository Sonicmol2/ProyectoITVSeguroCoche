/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import vista.VistaCocheAlta;
import vista.VistaVehiculos;

/**
 *
 * @author samuel 
 */
public class ManejadorVistaPrincipal implements ActionListener{

    JFrame ventana;
    JDialog dialogAltaVehiculo;
    VistaCocheAlta vistaCocheAlta;
    VistaVehiculos vistaVeh;
    
    
    public ManejadorVistaPrincipal(JFrame ventanaPrincipal, VistaCocheAlta vistaCocheAltaInicial, VistaVehiculos vistaVehiculos){
        this.ventana = ventanaPrincipal;
        this.vistaCocheAlta = vistaCocheAltaInicial;
        this.vistaVeh = vistaVehiculos;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String comando = e.getActionCommand();
        
        switch(comando){
            case "Alta":
                dialogAltaVehiculo = new JDialog(ventana, true);
                dialogAltaVehiculo.setTitle("Alta del vehículo.");
                dialogAltaVehiculo.setLocationRelativeTo(null);
                dialogAltaVehiculo.setContentPane(vistaCocheAlta);
                dialogAltaVehiculo.pack();
                dialogAltaVehiculo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                
                dialogAltaVehiculo.setVisible(true);
            break;
            
            case "Consultar":
                dialogAltaVehiculo = new JDialog(ventana, true);
                dialogAltaVehiculo.setTitle("Consulta de vehiculos.");
                dialogAltaVehiculo.setLocationRelativeTo(null);
                dialogAltaVehiculo.setContentPane(vistaVeh);
                dialogAltaVehiculo.pack();
                dialogAltaVehiculo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                
                dialogAltaVehiculo.setVisible(true);
            break;
        }
    }
}
