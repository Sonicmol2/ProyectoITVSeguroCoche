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
import vista.VistaVehiculos;

/**
 *
 * @author samuel 
 */
public class ManejadorVistaPrincipal implements ActionListener{
    private static final String BD_VEHICULOS = "src/bd/BaseDatosVehiculos.oo";
    
    JFrame ventana;
    JDialog dialogAltaVehiculo;
    JDialog dialogVistaVehiculo;
    VistaCocheAlta vistaCocheAlta;
    VistaVehiculos vistaVeh;
    modelo.ModeloVehiculos modeloVehiculos;
    ManejadorVistaAltaVehiculo manejadorAlta;
    String[] cabecera = new String[]{"Marca", "Modelo", "Matricula", "Tipo Revision", "Fecha ultima revisión", "Fecha nueva revisión", "Precio Seguro"};
    
    
    public ManejadorVistaPrincipal(JFrame ventanaPrincipal){
        this.ventana = ventanaPrincipal;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String comando = e.getActionCommand();
        
        switch(comando){
            case "Alta":
                dialogAltaVehiculo = new JDialog(ventana, true);
                vistaCocheAlta = new VistaCocheAlta();
                manejadorAlta = new ManejadorVistaAltaVehiculo(vistaCocheAlta, dialogAltaVehiculo);
                vistaCocheAlta.addManejador(manejadorAlta);
                 
                
                dialogAltaVehiculo.setTitle("Alta del vehículo.");
                dialogAltaVehiculo.setLocationRelativeTo(null);
               
                dialogAltaVehiculo.setContentPane(vistaCocheAlta);
                dialogAltaVehiculo.pack();
                dialogAltaVehiculo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
     
                
                dialogAltaVehiculo.setVisible(true);
            break;
            
            case "Consultar":
                dialogVistaVehiculo = new JDialog(ventana, true);
                vistaVeh = new VistaVehiculos();
                vistaVeh.addModelo();
                
                ObjectContainer db;
                EmbeddedConfiguration configuracion = Db4oEmbedded.newConfiguration();
                
                db = abrirBd(configuracion);
                rellenarTabla(db);
                
                dialogVistaVehiculo.setTitle("Consulta de vehiculos.");
                dialogVistaVehiculo.setLocationRelativeTo(null);
                dialogVistaVehiculo.setContentPane(vistaVeh);
                dialogVistaVehiculo.pack();
                dialogVistaVehiculo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                
                dialogVistaVehiculo.setVisible(true);
                
                db.close();
            break;
            
            case "Salir":
                JOptionPane.showMessageDialog(null, "Cerrando", "Salir de la aplicacion", JOptionPane.PLAIN_MESSAGE);
                System.exit(0);
            break;
        }
    }

    private void rellenarTabla(ObjectContainer db) {
        
        rellenarColumnas();
        rellenarFilas(db);
    }

    private void rellenarColumnas() {
        vistaVeh.addcolumnas(cabecera);
    }

    private void rellenarFilas(ObjectContainer db) {
        Object[] fila;
        fila = new Object[cabecera.length];
        
        ObjectSet<Vehiculo> result;
        
        result = db.queryByExample(new Vehiculo());
        
        if(result.size() == 0){
             JOptionPane.showMessageDialog(null, "No hay ningun vehiculo en la lista", "Consultar Vehiculo", JOptionPane.PLAIN_MESSAGE);
        }else{
            for (Vehiculo vehiculo : result) {
                fila[0] = vehiculo.getMarca();
                fila[1] = vehiculo.getModelo();
                fila[2] = vehiculo.getMatricula();
                fila[3] = vehiculo.getTipoRevision();
                fila[4] = vehiculo.getFechaUltimaRevision();
                fila[5] = vehiculo.getFechaUltimoSeguro();
                fila[6] = vehiculo.getPrecioSeguro();
                vistaVeh.addFila(fila);   
            }
        }
    }
    
     private static ObjectContainer abrirBd(EmbeddedConfiguration configuracion) {
       
        EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
        ObjectContainer db = Db4oEmbedded.openFile(config, BD_VEHICULOS);

       return db;
    
    }
}
