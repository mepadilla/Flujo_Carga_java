/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

/**
 *
 * @author melvin
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import utils.ResultSetTableModel;

public class Consulta extends JFrame {

// controlador JDBC y URL de la base de datos
static final String CONTROLADOR_JDBC = "com.mysql.jdbc.Driver";
static final String URL_BASEDEDATOS = "jdbc:mysql://localhost/Flujos";
static final String usr = "root";
static final String psw = "v63rt67";

// la consulta predeterminada recupera todos los datos de la tabla autores
public String CONSULTA_PREDETERMINADA = "SELECT * FROM Operador";

private ResultSetTableModel modeloTabla;
private JTextArea areaConsulta;

// crear objeto ResultSetTableModel y GUI
public Consulta(String CadenaConsulta)
{
   super( "Modulo de Consulta y Visualizacion" );


   if (CadenaConsulta.equals(CONSULTA_PREDETERMINADA))
   	{
   	CONSULTA_PREDETERMINADA = "SELECT * FROM Operador";
   	}
   else
   {
   		CONSULTA_PREDETERMINADA = CadenaConsulta;
   };

   // crear objeto ResultSetTableModel y mostrar tabla de la base de datos
   try {

      // especificar la ubicaci�n de la base de datos en el sistema de archivos
      //System.setProperty( "db2j.system.home", "C:/Cloudscape_5.1" );

      // crear objeto TableModel para los resultados del a consulta SELECT * FROM autores
      modeloTabla = new ResultSetTableModel( CONTROLADOR_JDBC, URL_BASEDEDATOS,
         CONSULTA_PREDETERMINADA, usr, psw);

      // establecer objeto JTextArea en el que el usuario escribe las consultas
      areaConsulta = new JTextArea( CONSULTA_PREDETERMINADA, 3, 100 );
      areaConsulta.setWrapStyleWord( true );
      areaConsulta.setLineWrap( true );

      JScrollPane panelDesplazable = new JScrollPane( areaConsulta,
         ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
         ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );

      // establecer objeto JButton para enviar las consultas
      JButton botonEnviar = new JButton( "Enviar consulta" );

      // crear objeto Box para manejar la colocaci�n de areaConsulta y
      // botonEnviar en la GUI
      Box cuadro = Box.createHorizontalBox();
      //cuadro.add( panelDesplazable );
      //cuadro.add( botonEnviar );

      // crear delegado de JTable para modeloTabla
      JTable tablaResultados = new JTable( modeloTabla );

      // colocar componentes de GUI en el panel de contenido
      Container c = getContentPane();
      c.add( cuadro, BorderLayout.NORTH );
      c.add( new JScrollPane( tablaResultados ), BorderLayout.CENTER );

      // crear componente de escucha de eventos para botonEnviar
      botonEnviar.addActionListener(

         new ActionListener() {

            // pasar consulta al modelo de la tabla
            public void actionPerformed( ActionEvent evento )
            {
               // realizar una nueva consulta
               try {
                  modeloTabla.establecerConsulta( areaConsulta.getText() );
               }

               // atrapar posibles excepciones SQLException al realizar una nueva consulta
               catch ( SQLException excepcionSQL ) {
                  JOptionPane.showMessageDialog( null,
                     excepcionSQL.getMessage(), "Error en la base de datos",
                     JOptionPane.ERROR_MESSAGE );

                  // tratar de recuperarse de una consulta inv�lida del usuario
                  // ejecutando la consulta predeterminada
                  try {
                     modeloTabla.establecerConsulta( CONSULTA_PREDETERMINADA );
                     areaConsulta.setText( CONSULTA_PREDETERMINADA );
                  }

                  // atrapar posible excepcion SQLException al realizar consulta predeterminada
                  catch ( SQLException excepcionSQL2 ) {
                     JOptionPane.showMessageDialog( null,
                        excepcionSQL2.getMessage(), "Error en la base de datos",
                        JOptionPane.ERROR_MESSAGE );

                     // asegurar que la conexi�n a la base de datos est� cerrada
                     modeloTabla.desconectarDeLaBaseDeDatos();

                     System.exit( 1 );   // terminar la aplicaci�n

                  }  // fin de bloque catch interno

               } // fin de bloque catch externo

            }  // fin de actionPerformed

         }  // fin de la clase interna ActionListener

      ); // fin de la llamada a addActionListener

      // establecer tama�o de ventana y mostrarla en pantalla
      //setSize( 500, 250 );
      setVisible( true );

   }  // fin de bloque try

   // atrapar la excepci�n ClassNotFoundException lanzada por el
   // objeto ResultSetTableModel si no se encuentra el controlador de la base de datos
   catch ( ClassNotFoundException claseNoEncontrada ) {
      JOptionPane.showMessageDialog( null,
         "No se encontro el controlador de Cloudscape", "No se encontro el controlador",
         JOptionPane.ERROR_MESSAGE );

      System.exit( 1 );   // terminar la aplicaci�n
   } // fin de bloque catch

   // atrapar la excepci�n SQLException lanzada por el objeto ResultSetTableModel
   // si ocurren problemas al establecer la conexi�n a la base de datos
   // y realizar la consulta en la misma
   catch ( SQLException excepcionSQL ) {
      JOptionPane.showMessageDialog( null, excepcionSQL.getMessage(),
         "Error en la base de datos", JOptionPane.ERROR_MESSAGE );

      // asegurar que la conexi�n a la base de datos est� cerrada
      modeloTabla.desconectarDeLaBaseDeDatos();

      //System.exit( 1 );   // terminar la aplicaci�n
   }

   // desechar la ventana cuando el usuario salga de la aplicaci�n
   // (esta opci�n sobrescribe a la opci�n predeterminada de HIDE_ON_CLOSE)
   setDefaultCloseOperation( DISPOSE_ON_CLOSE );

   // asegurar que la conexi�n a la base de datos est� cerrada cuando el usuario salga de la aplicaci�n
   addWindowListener(

      new WindowAdapter() {

         // desconectarse de la base de datos y salir cuando se haya cerrado la ventana
         public void windowClosed( WindowEvent evento )
         {
            modeloTabla.desconectarDeLaBaseDeDatos();
            //System.exit( 1 );
         }
      }
   );

}  // fin del constructor de MostrarResultadosConsulta

// ejecutar la aplicaci�n
/*public static void main( String args[] )
{
   new Consulta();
}*/


}  // fin de la clase MostrarResultadosConsulta
