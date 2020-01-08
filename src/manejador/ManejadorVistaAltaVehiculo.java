/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import modelo.Vehiculo;


/**
 *
 * @author samuel
 */
public class ManejadorVistaAltaVehiculo implements ActionListener{
    
    JFrame ventana;
    Vehiculo vehiculo;
    
    public ManejadorVistaAltaVehiculo(){
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String comando = e.getActionCommand();
    
        switch(comando){
            case "Aceptar":
                comprobarVehiculo();
            break;
            
            case "Cancelar":
                
            break;
        }
    }

    private void comprobarVehiculo() {
        
    }
    
    
}
