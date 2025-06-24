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
public class CreateTable extends JFrame
{
	public void tabla()
	{
	String sql;
	Connection conx;
	Statement stmt;
	PreparedStatement pstmt;
	int numRowAct;
			try
			{
			String url = "jdbc:mysql://localhost/";
			String usr = "root";
			String psw = "v63rt67";
			Class.forName( "com.mysql.jdbc.Driver" );
			conx = DriverManager.getConnection( url, usr, psw);
			stmt = conx.createStatement();
			sql = "CREATE DATABASE Flujos";
			stmt.executeUpdate( sql );
			conx.close();

			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame,"Base de Datos flujos Creada con Exito.");


			}
			catch(ClassNotFoundException e1) {

				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame,"No se pudo localizar el driver..." + e1.getLocalizedMessage());

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
				sql = "CREATE TABLE  nodos (ID_reg INTEGER, nodini INTEGER, nodfin INTEGER, resis DOUBLE, react DOUBLE, yshunt DOUBLE, element VARCHAR(50))";
				stmt.executeUpdate( sql );
				conx.close();

				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame,"Tabla nodos creada con Exito.");

			}
			catch(ClassNotFoundException e1)
			{
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame,"No se pudo localizar el driver..." + e1.getLocalizedMessage());

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
				sql = "CREATE TABLE  barras (Numbarra INTEGER, Tipobarra INTEGER, Pgen DOUBLE, Qgen DOUBLE," +
						"Pcar DOUBLE, Qcar DOUBLE, Tension DOUBLE, Angle DOUBLE, Coment VARCHAR(50), Compensa DOUBLE )";
				stmt.executeUpdate( sql );
				conx.close();

				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame,"Tabla Barras Creada con Exito.");

			}
			catch(ClassNotFoundException e1)
			{
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame,"No se pudo localizar el driver..." + e1.getLocalizedMessage());

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
				sql = "CREATE TABLE  Ybus (ID_ybus INTEGER, i DOUBLE, j DOUBLE, yreal DOUBLE, yimagi DOUBLE)";
				stmt.executeUpdate( sql );
				conx.close();

				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame,"Tabla Ybus creada con Exito.");

			}
			catch(ClassNotFoundException e1)
			{
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame,"No se pudo localizar el driver..." + e1.getLocalizedMessage());

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
				sql = "CREATE TABLE  Bi (ID_Bi INTEGER, i DOUBLE, j DOUBLE, Biimagi DOUBLE)";
				stmt.executeUpdate( sql );
				conx.close();

				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame,"Tabla Bi creada con Exito.");

			}
			catch(ClassNotFoundException e1)
			{
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame,"No se pudo localizar el driver..." + e1.getLocalizedMessage());

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
				sql = "CREATE TABLE  Bii (ID_Bii INTEGER, i DOUBLE, j DOUBLE, Biiimagi DOUBLE)";
				stmt.executeUpdate( sql );
				conx.close();

				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame,"Tabla Bii creada con Exito.");

			}
			catch(ClassNotFoundException e1)
			{
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame,"No se pudo localizar el driver..." + e1.getLocalizedMessage());

			}
			catch(SQLException e2)
			{
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame,"No se pudo establecer conexi�n con la BD" + e2.getMessage());

			}



        }
}





