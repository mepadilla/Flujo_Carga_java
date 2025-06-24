/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

/**
 *
 * @author melvin
 */
/**
 *
 * @author melvin
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;



public class Barras extends JFrame  {


	private JLabel label0;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
        private JLabel label7;
        private JLabel label8;

	private JLabel label13;
	private JLabel label14;
	private JLabel label15;
	private JLabel label16;

        private JLabel label18;
	private JLabel label19;
	private JLabel label20;
	private JLabel label21;
        private JLabel label22;


	private JButton boton1;
	private JButton boton2;
	private JButton boton3;
	private JButton boton4;
	private JButton boton5;
        private JButton boton6;
        private JButton boton7;
        private JButton boton8;
        private JButton boton9;
        private JButton boton10;

	private JTextField ID_barra;
/*	private JTextField tipobarra;
*/	private JTextField Pgen;
	private JTextField Qgen;
	private JTextField Pcar;
	private JTextField Qcar;
	private JTextField Tension;
        private JTextField Angulo;
        private JTextField Nota;
        private JTextField Compensa;


	private JTextField buscaId;
	private JTextField buscageneral;
        private JTextField buscaIdmod;
        private JTextField buscaIdeli;

	private JTextField observaciones;

	private Container contenedor;
	private GridBagLayout esquema;
	private GridBagConstraints restricciones;

	private Statement stmt;
	private Statement stmt2;

	private String sentencia;
        private String confirmaeli = "N";

        private String boxTipoBarra[] = {"..","Slack", "PV", "PQ"};
        private JComboBox tipobarra;
        private Integer flagtipobarra = 0;

	private Integer buscarIdsimple;
        private Integer buscarIdsimplemod;
        private Integer buscarIdsimpleeli;
	private Integer buscarnomsimple;
	private Integer verificarsimple;
	private String sentenciaSQL = null;


	private FlowLayout esquemalayout;





// configurar GUI
public Barras()
{

   super( "Modulo de Manejo de Barras " );



   contenedor = getContentPane();
	esquema = new GridBagLayout();
	contenedor.setLayout(esquema);
       // contenedor.setSize(400, 400);
	restricciones = new GridBagConstraints();

	getContentPane().setBackground(Color.lightGray);



	label0 = new JLabel(" Numero de Barra: ");
	label1 = new JLabel(" Tipo de Barra: ");
	label2 = new JLabel(" P Generacion: ");
	label3 = new JLabel(" Q Generacion: ");
	label4 = new JLabel(" P Carga: ");
	label5 = new JLabel(" Q Carga");
	label6 = new JLabel(" Tension: ");
        label7 = new JLabel(" Angulo: ");
        label8 = new JLabel(" Notas: ");

	label13 = new JLabel("-------------------------");
	label14 = new JLabel("-------------------------");
	label15 = new JLabel("-------------------------");
	label16 = new JLabel("-------------------------");


	label18 = new JLabel("-------------------------");
	label19 = new JLabel("-------------------------");
	label20 = new JLabel("-------------------------");
	label21 = new JLabel("-------------------------");
        label22 = new JLabel(" KVAR de Comp: ");


	ID_barra = new JTextField();
	/*tipobarra = new JTextField();
	*/Pgen = new JTextField();
	Qgen = new JTextField();
	Pcar = new JTextField();
	Qcar = new JTextField();
	Tension = new JTextField();
        Angulo = new JTextField();
        Nota = new JTextField();
        tipobarra = new JComboBox(boxTipoBarra);
        Compensa = new JTextField();

	boton1 = new JButton(" NUEVO ");
	boton1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			limpiaceldas();
			activaceldas();

		}
	});

	boton2 = new JButton(" LIMPIAR ");
	boton2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			limpiaceldas();
			desactivaceldas();

		}
	});

	boton3 = new JButton(" AGREGAR ");
	boton3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{

			Conex_Flujos cone = new Conex_Flujos();
			Connection conx2 = cone.conectar();

			Conex_Flujos cone2 = new Conex_Flujos();
			Connection conx3 = cone2.conectar();

			verificarsimple = Integer.parseInt(ID_barra.getText());

			try
			{
				String sql2 = "SELECT Numbarra FROM barras WHERE Numbarra LIKE '" + verificarsimple + "'";
				stmt2 = conx3.createStatement();
				ResultSet rs2 = stmt2.executeQuery( sql2 );
				int bandera2 = 0;

				while (rs2.next())
				{
					bandera2 = 1;
				}

				if (bandera2 == 1)
				{
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame,"     !!! Existen Coincidencias en el Registro !!!"
							+ "\n        !!! El Numero de Barra Esta Registrado !!!"
							+ "\n!!! Verifique Sus Datos he Intente de Nuevo !!!");

				}

				if (bandera2 == 0)
				{


					sentencia = "INSERT INTO barras VALUES('" + Integer.parseInt(ID_barra.getText()) + "','" +
                                        Integer.parseInt(String.valueOf(tipobarra.getSelectedIndex())) + "','"+  Double.parseDouble(Pgen.getText())+"','"+ Double.parseDouble(Qgen.getText())  +"','"+
                                        Double.parseDouble(Pcar.getText())+ "','"+ Double.parseDouble(Qcar.getText())+"','"+ Double.parseDouble(Tension.getText()) + "','" +
                                        Double.parseDouble(Angulo.getText()) + "','"+ Nota.getText() + "','" + Double.parseDouble(Compensa.getText()) + "')";

					stmt = conx2.createStatement();
					stmt.executeUpdate(sentencia);

					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame,"Se ha agregado una Barra al registro");

				}


				conx2.close();
				conx3.close();
			}
			catch(SQLException e2)
			{
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
			}



			limpiaceldas();

			desactivaceldas();



}
	});

	boton4 = new JButton(" BUSCAR ");
	boton4.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			Conex_Flujos cone = new Conex_Flujos();
			Connection conx3 = cone.conectar();

			try
			{
				buscarIdsimple = Integer.parseInt(buscaId.getText());
				limpiaceldas();
				stmt = conx3.createStatement();
				String sql = "SELECT * FROM barras WHERE Numbarra LIKE '" + buscarIdsimple + "'";
				ResultSet rs = stmt.executeQuery( sql );
				limpiaceldas();

				int bandera1 = 0;
				int contador1 = 0;

					while (rs.next())
					{
						bandera1 = 1;
						contador1 ++;
						if (contador1 == 2)
						{
							JFrame frame = new JFrame();
							JOptionPane.showMessageDialog(frame,"     !!! Existen Coincidencias en el Registro !!!"
									+ "\n        !!! Intente una Consulta General. !!!"
									+ "\n!!! Se Muestra el Primer Registro Encontrado !!!");
							break;
						}

						ID_barra.setText(rs.getString("Numbarra"));
						tipobarra.setSelectedIndex(rs.getInt("Tipobarra"));
						Pgen.setText(rs.getString("Pgen"));
						Qgen.setText(rs.getString("Qgen"));
						Pcar.setText(rs.getString("Pcar"));
						Qcar.setText(rs.getString("Qcar"));
						Tension.setText(rs.getString("Tension"));
                                                Angulo.setText(rs.getString("Angle"));
                                                Nota.setText(rs.getString("Coment"));
                                                Compensa.setText(rs.getString("Compensa"));


					}

					if (bandera1 == 0)
					{
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame,"!!! No Se Encuentra el Registro Solicitado !!!" );
					}

				conx3.close();

			}
			catch(SQLException e2)
			{
				System.out.println( "No se pudo establecer conexi�n con la BD " + e2.getMessage());
			}


		}
	  	});

	boton5 = new JButton(" BUSCAR ");
	boton5.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			buscarnomsimple = Integer.parseInt(buscageneral.getText());
			limpiaceldas();
			sentenciaSQL = "SELECT * FROM barras " +
					"WHERE Numbarra LIKE '" + buscarnomsimple + "%'";
			Consulta app = new Consulta(sentenciaSQL);
			app.pack( );
			app.setVisible(true);


		}
	  	});

         boton6 = new JButton(" MOSTRAR ");
         boton6.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
		{

			sentenciaSQL = "SELECT * FROM barras ";
			Consulta app = new Consulta(sentenciaSQL);
			app.pack( );
                        app.setResizable(false);
			app.setVisible(true);


		}
	  	});

        boton7 = new JButton(" BUSCAR ");
	boton7.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			Conex_Flujos cone = new Conex_Flujos();
			Connection conx3 = cone.conectar();

			try
			{
				buscarIdsimplemod = Integer.parseInt(buscaIdmod.getText());
				limpiaceldas();
				stmt = conx3.createStatement();
				String sql = "SELECT * FROM barras WHERE Numbarra LIKE '" + buscarIdsimplemod + "'";
				ResultSet rs = stmt.executeQuery( sql );
				limpiaceldas();

				int bandera1 = 0;
				int contador1 = 0;

					while (rs.next())
					{
						bandera1 = 1;
						contador1 ++;
						if (contador1 == 2)
						{
							JFrame frame = new JFrame();
							JOptionPane.showMessageDialog(frame,"     !!! Existen Coincidencias en el Registro !!!"
									+ "\n        !!! Intente una Consulta General. !!!"
									+ "\n!!! Se Muestra el Primer Registro Encontrado !!!");
							break;
						}

						ID_barra.setText(rs.getString("Numbarra"));
						tipobarra.setSelectedIndex(rs.getInt("Tipobarra"));
						Pgen.setText(rs.getString("Pgen"));
						Qgen.setText(rs.getString("Qgen"));
						Pcar.setText(rs.getString("Pcar"));
						Qcar.setText(rs.getString("Qcar"));
						Tension.setText(rs.getString("Tension"));
                                                Angulo.setText(rs.getString("Angle"));
                                                Nota.setText(rs.getString("Coment"));
                                                Compensa.setText(rs.getString("Compensa"));


					}

					if (bandera1 == 0)
					{
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame,"!!! No Se Encuentra el Registro Solicitado !!!" );
					}

				conx3.close();
                                activaceldas();
                                ID_barra.setEnabled(false);
                                

			}
			catch(SQLException e2)
			{
				System.out.println( "No se pudo establecer conexi�n con la BD " + e2.getMessage());
			}


		}
	  	});

        boton8 = new JButton(" ACTUALIZAR ");
	boton8.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			Conex_Flujos cone = new Conex_Flujos();
			Connection conx4 = cone.conectar();

			try
			{
                             sentencia = "UPDATE barras SET Tipobarra='" + Integer.parseInt(String.valueOf(tipobarra.getSelectedIndex())) +
                                        "', Pgen='" + Double.parseDouble(Pgen.getText()) + "', Qgen='" + Double.parseDouble(Qgen.getText()) +
                                        "', Pcar='" + Double.parseDouble(Pcar.getText()) + "', Qcar='" + Double.parseDouble(Qcar.getText()) +
                                        "', Tension='" + Double.parseDouble(Tension.getText()) + "', Angle='" + Double.parseDouble(Angulo.getText()) +
                                        "', Coment='" + Nota.getText() + "', Compensa='" + Double.parseDouble(Compensa.getText()) +
                                        "' WHERE Numbarra='" + Integer.parseInt(ID_barra.getText())+"'";

					stmt = conx4.createStatement();
					stmt.executeUpdate(sentencia);

					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame,"Se ha actualizado una Barra del registro");

                                        limpiaceldas();
                                        desactivaceldas();

				conx4.close();

			}
			catch(SQLException e2)
			{
				System.out.println( "No se pudo establecer conexi�n con la BD " + e2.getMessage());
			}


		}
	  	});


                boton9 = new JButton(" BUSCAR ");
                boton9.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			Conex_Flujos cone = new Conex_Flujos();
			Connection conx5 = cone.conectar();

			try
			{
				buscarIdsimpleeli = Integer.parseInt(buscaIdeli.getText());
				limpiaceldas();
				stmt = conx5.createStatement();
				String sql = "SELECT * FROM barras WHERE Numbarra LIKE '" + buscarIdsimpleeli + "'";
				ResultSet rs = stmt.executeQuery( sql );
				limpiaceldas();

				int bandera1 = 0;
				int contador1 = 0;

					while (rs.next())
					{
						bandera1 = 1;
						contador1 ++;
						if (contador1 == 2)
						{
							JFrame frame = new JFrame();
							JOptionPane.showMessageDialog(frame,"     !!! Existen Coincidencias en el Registro !!!"
									+ "\n        !!! Intente una Consulta General. !!!"
									+ "\n!!! Se Muestra el Primer Registro Encontrado !!!");
							break;
						}

                                                ID_barra.setText(rs.getString("Numbarra"));
						tipobarra.setSelectedIndex(rs.getInt("Tipobarra"));
						Pgen.setText(rs.getString("Pgen"));
						Qgen.setText(rs.getString("Qgen"));
						Pcar.setText(rs.getString("Pcar"));
						Qcar.setText(rs.getString("Qcar"));
						Tension.setText(rs.getString("Tension"));
                                                Angulo.setText(rs.getString("Angle"));
                                                Nota.setText(rs.getString("Coment"));
                                                Compensa.setText(rs.getString("Compensa"));



					}

					if (bandera1 == 0)
					{
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame,"!!! No Se Encuentra el Registro Solicitado !!!" );
					}

				conx5.close();


			}
			catch(SQLException e2)
			{
				System.out.println( "No se pudo establecer conexi�n con la BD " + e2.getMessage());
			}


		}
	  	});

        boton10 = new JButton(" ELIMINAR ");
	boton10.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			Conex_Flujos cone = new Conex_Flujos();
			Connection conx6 = cone.conectar();

			try
			{

                                        confirmaeli = JOptionPane.showInputDialog(Barras.this,
							"!!! Se dispone a Eliminara el Registro del sistema. !!!" +
							"\n          Esta Seguro ? (S/N) ",
							"Enlighten Enterprise ENENCA C.A.", JOptionPane.QUESTION_MESSAGE);

					if (confirmaeli.equals("S"))
					{
						sentencia = "DELETE FROM barras WHERE Numbarra=" + Integer.parseInt(ID_barra.getText());

					stmt = conx6.createStatement();
					stmt.executeUpdate(sentencia);

					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame,"Se ha Eliminado una Barra del Registro");

					}

                                        limpiaceldas();
                                        desactivaceldas();

				conx6.close();

			}
			catch(SQLException e2)
			{
				System.out.println( "No se pudo establecer conexi�n con la BD " + e2.getMessage());
			}


		}
	  	});

            tipobarra.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
                    flagtipobarra = tipobarra.getSelectedIndex();

                    if (flagtipobarra.equals(0))
                    {
                        desactivaceldas();
                        Pgen.setText("0");
			Qgen.setText("0");
			Pcar.setText("0");
			Qcar.setText("0");
			Tension.setText("0");
                        Angulo.setText("0");
                        Nota.setText("Escoja Tipo de Barra");
                        tipobarra.setEnabled(true);
                        Compensa.setText("0");
                        Compensa.setEnabled(true);
                        
                    }

                    if (flagtipobarra.equals(1))
                    {
                        desactivaceldas();
                        Pgen.setText("0");
			Qgen.setText("0");
			Pcar.setText("0");
			Qcar.setText("0");
			Tension.setText("1");
                        Angulo.setText("0");
                        Nota.setText("");
                        tipobarra.setEnabled(true);
                        Nota.setEnabled(true);
                        Compensa.setEnabled(true);

                    }

                    if (flagtipobarra.equals(2))
                    {
                        desactivaceldas();
                        Pgen.setText("");
			Qgen.setText("");
			Pcar.setText("");
			Qcar.setText("");
			Tension.setText("");
                        Angulo.setText("0");
                        Nota.setText("");
                	tipobarra.setEnabled(true);
                        Pgen.setEnabled(true);
                        Qgen.setEnabled(true);
                        Pcar.setEnabled(true);
                        Qcar.setEnabled(true);
                        Tension.setEnabled(true);
                        Nota.setEnabled(true);
                        Compensa.setEnabled(true);


                    }

                    if (flagtipobarra.equals(3))
                    {
                        desactivaceldas();
                        Pgen.setText("0");
			Qgen.setText("0");
			Pcar.setText("");
			Qcar.setText("");
			Tension.setText("1");
                        Angulo.setText("0");
                        Nota.setText("");
                        tipobarra.setEnabled(true);
                        Pcar.setEnabled(true);
                        Qcar.setEnabled(true);
                        Nota.setEnabled(true);
                        Compensa.setEnabled(true);


                    }

		}

	});



	agregarComponente (label13,1,0,1,1);
	agregarComponente (label14,1,1,1,1);
	agregarComponente (label15,1,2,1,1);
	agregarComponente (label16,1,3,1,1);
	restricciones.fill = GridBagConstraints.HORIZONTAL;
	agregarComponente (label0,2,0,1,1);
	agregarComponente (ID_barra,2,1,1,1);

        agregarComponente (label18,3,0,1,1);
	agregarComponente (label19,3,1,1,1);
	agregarComponente (label20,3,2,1,1);
	agregarComponente (label21,3,3,1,1);

	agregarComponente (label1,4,0,1,1);
	agregarComponente (tipobarra,4,1,1,1);
	agregarComponente (label2,4,2,1,1);
	agregarComponente (Pgen,4,3,1,1);
	agregarComponente (label3,5,0,1,1);
	agregarComponente (Qgen,5,1,1,1);
	agregarComponente (label4,5,2,1,1);
	agregarComponente (Pcar,5,3,1,1);
	agregarComponente (label5,6,0,1,1);
	agregarComponente (Qcar,6,1,1,1);
	agregarComponente (label6,6,2,1,1);
	agregarComponente (Tension,6,3,1,1);
        agregarComponente (label7,7,0,1,1);
	agregarComponente (Angulo,7,1,1,1);
        agregarComponente (label8,7,2,1,1);
	agregarComponente (Nota,7,3,1,1);
        agregarComponente (label22,8,0,1,1);
	agregarComponente (Compensa,8,1,1,1);

   // crear objeto JTabbedPane
   JTabbedPane panelConFichas = new JTabbedPane();

   //esquemalayout = new FlowLayout();
   //panelConFichas.setLayout(esquemalayout);


   // establecer pane11 y agregarlo al objeto JTabbedPane
   JLabel etiqueta1 = new JLabel( "Manejo de Ingreso de Nueva Barra", SwingConstants.CENTER );
   JPanel panel4 = new JPanel();
   JPanel panel4aux = new JPanel();
   panel4.setLayout( new BorderLayout() );
   panel4.add( etiqueta1, BorderLayout.NORTH );
   panel4aux.add(boton1);
   panel4aux.add(boton2);
   panel4aux.add(boton3);
   panel4.add( panel4aux, BorderLayout.SOUTH );
   panelConFichas.addTab( "Nuevo", null, panel4, "Ingresa Nueva Barra" );

   // establecer panel2 y agregarlo al objeto JTabbedPane
   JLabel etiqueta2 = new JLabel( "Manejo de Consulta de Barras", SwingConstants.CENTER );

   buscaId = new JTextField();
   buscageneral = new JTextField();
   JPanel panel5 = new JPanel();
   JPanel panel5aux = new JPanel();
   panel5aux.setLayout( new GridLayout(3,3) );
   panel5.setLayout( new BorderLayout() );
   //panel5.setBackground( Color.YELLOW );
   panel5.add( etiqueta2, BorderLayout.NORTH  );
   panel5aux.add(new JLabel( "Ingrese Numero de Barra a Buscar" ));
   panel5aux.add(buscaId);
   panel5aux.add(boton4);
   panel5aux.add(new JLabel( "Busqueda General Por Barra" ));
   panel5aux.add( buscageneral);
   panel5aux.add(boton5);
   panel5aux.add(new JLabel("Mostrar la lista de Barras completa"));
   panel5aux.add(boton6);
   panel5aux.add(new JLabel(""));
   panel5.add(panel5aux, BorderLayout.SOUTH );

   panelConFichas.addTab( "Consulta", null, panel5, "Consulta Barras Ingresadas" );

   // establecer panel3 y agregarlo al objeto JTabbedPane
   buscaIdmod = new JTextField();

   JPanel panel6 = new JPanel();
   JPanel panel6aux = new JPanel();
   panel6aux.setLayout( new GridLayout(2,3) );
   panel6.setLayout( new BorderLayout() );
   //panel6.setBackground( Color.YELLOW );
   panel6.add( etiqueta2, BorderLayout.NORTH  );
   panel6aux.add(new JLabel( "Ingrese Numero de Barra a Modificar" ));
   panel6aux.add(buscaIdmod);
   panel6aux.add(boton7);
   panel6aux.add(new JLabel( "actualizar la Barra Seleccionado" ));
   panel6aux.add(boton8);

   panel6.add(panel6aux, BorderLayout.SOUTH );

   panelConFichas.addTab( "Modifica", null, panel6, "Edita Valores de una Barra" );

// establecer pane14 y agregarlo al objeto JTabbedPane

   buscaIdeli = new JTextField();

   JPanel panel7 = new JPanel();
   JPanel panel7aux = new JPanel();
   panel7aux.setLayout( new GridLayout(2,3) );
   panel7.setLayout( new BorderLayout() );
   //panel7.setBackground( Color.YELLOW );
   panel7.add( etiqueta2, BorderLayout.NORTH  );
   panel7aux.add(new JLabel( "Ingrese Numero de Barra a Eliminar" ));
   panel7aux.add(buscaIdeli);
   panel7aux.add(boton9);
   panel7aux.add(new JLabel( "Eliminar la barra Seleccionada" ));
   panel7aux.add(boton10);

   panel7.add(panel7aux, BorderLayout.SOUTH );


   panelConFichas.addTab( "Elimina", null, panel7, "Elimina Barras" );

   // agregar objeto JTabbedPane al contenedor

   panelConFichas.setSize(400,300);


   agregarComponente (panelConFichas,0,0,4,1);

   getContentPane();

   pack();
   setResizable(false);
   setVisible( true );

   desactivaceldas();

} // fin del constructor



private void agregarComponente( Component componente,
		int fila, int columna, int anchura, int altura )
{
	restricciones.gridx = columna;
	restricciones.gridy = fila;

	restricciones.gridwidth = anchura;
	restricciones.gridheight = altura;

	esquema.setConstraints( componente, restricciones);
	contenedor.add( componente);

}

private void activaceldas()
{


	ID_barra.setEnabled(true);
	tipobarra.setEnabled(true);
	Pgen.setEnabled(true);
	Qgen.setEnabled(true);
	Pcar.setEnabled(true);
	Qcar.setEnabled(true);
	Tension.setEnabled(true);
        Angulo.setEnabled(true);
        Nota.setEnabled(true);
        Compensa.setEnabled(true);

}

private void limpiaceldas()
{
	ID_barra.setText("");
	tipobarra.setSelectedIndex(0);
	Pgen.setText("");
	Qgen.setText("");
	Pcar.setText("");
	Qcar.setText("");
	Tension.setText("");
        buscaId.setText("");
	buscageneral.setText("");
        Angulo.setText("");
        Nota.setText("");
        Compensa.setText("");

}

private void desactivaceldas()
{
	ID_barra.setEnabled(false);
	tipobarra.setEnabled(false);
	Pgen.setEnabled(false);
	Qgen.setEnabled(false);
	Pcar.setEnabled(false);
	Qcar.setEnabled(false);
        Tension.setEnabled(false);
        Angulo.setEnabled(false);
        Nota.setEnabled(false);
        Compensa.setEnabled(false);


}

} // fin de la clase Barras.
