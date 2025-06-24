/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author melvin
 */
public class DropYbus extends JFrame{

	public void borrarYbus() {

		String sql;
		Connection conx;
		Statement stmt;
		PreparedStatement pstmt;
		int numRowAct;
				try
				{
				String url = "jdbc:mysql://localhost/Flujos";
				String usr = "root";
				String psw = "v63rt67";
				Class.forName( "com.mysql.jdbc.Driver" );

				conx = DriverManager.getConnection( url, usr, psw);

				stmt = conx.createStatement();
				sql = "DROP TABLE Ybus";
				stmt.executeUpdate( sql );

                                sql = "CREATE TABLE  Ybus (ID_ybus INTEGER, i DOUBLE, j DOUBLE, yreal DOUBLE, yimagi DOUBLE)";
				stmt.executeUpdate( sql );
                                conx.close();

				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame,"Base de datos Ybus Reiniciada con exito" );

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


        try
				{
				String url = "jdbc:mysql://localhost/Flujos";
				String usr = "root";
				String psw = "v63rt67";
				Class.forName( "com.mysql.jdbc.Driver" );

				conx = DriverManager.getConnection( url, usr, psw);

				stmt = conx.createStatement();
				sql = "DROP TABLE Bi";
				stmt.executeUpdate( sql );

                                sql = "CREATE TABLE  Bi (ID_Bi INTEGER, i DOUBLE, j DOUBLE, Biimagi DOUBLE)";
				stmt.executeUpdate( sql );
                                conx.close();

				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame,"Base de datos Bi Reiniciada con exito" );

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


                try
				{
				String url = "jdbc:mysql://localhost/Flujos";
				String usr = "root";
				String psw = "v63rt67";
				Class.forName( "com.mysql.jdbc.Driver" );

				conx = DriverManager.getConnection( url, usr, psw);

				stmt = conx.createStatement();
				sql = "DROP TABLE Bii";
				stmt.executeUpdate( sql );

                                sql = "CREATE TABLE  Bii (ID_Bii INTEGER, i DOUBLE, j DOUBLE, Biiimagi DOUBLE)";
				stmt.executeUpdate( sql );
                                conx.close();

				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame,"Base de datos Bii Reiniciada con exito" );

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


        }


}

