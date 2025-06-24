/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author melvin
 */
public class Conex_Flujos {

	public Connection conectar()
	{

		Connection conx = null;

				try
				{
					String url = "jdbc:mysql://localhost/Flujos";
					String usr = "root";
					String psw = "v63rt67";
					Class.forName( "com.mysql.jdbc.Driver" );

					conx = DriverManager.getConnection( url, usr, psw);


				}
				catch(ClassNotFoundException e1)
				{
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame,"No se pudo localizar el driver...D" + e1.getMessage());

				}
				catch(SQLException e2)
				{
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
				}
				return conx;
	}

}
