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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import utils.Conex_Flujos;
import utils.Consulta;

public class Proveedor extends JFrame  {


	private JLabel label0;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel label10;
	private JLabel label13;
	private JLabel label14;
	private JLabel label15;
	private JLabel label16;
	private JLabel label17;
	private JLabel label18;
	private JLabel label19;
	private JLabel label20;
	private JLabel label21;
	private JLabel label22;
	private JLabel label24;
	private JLabel label25;
	private JLabel label26;


	private JButton boton1;
	private JButton boton2;
	private JButton boton3;
	private JButton boton4;
	private JButton boton5;

	private JTextField ID_Operador;
	private JTextField nom1;
	private JTextField nom2;
	private JTextField apll1;
	private JTextField apll2;
	private JTextField telf;
	private JTextField celTelf;
	private JTextField email;
	private JTextField direcc;
	private JTextField fnac;

	private JTextField buscacedula;
	private JTextField buscageneral;


	private JCheckBox cardio;
	private JCheckBox tension;
	private JCheckBox diabetes;
	private JCheckBox alergia;
	private JCheckBox asma;
	private JCheckBox Hijos;

	private JComboBox nivelTensio;
	private JComboBox generaAlergia;
	private JComboBox numHijos;
	private JComboBox cargo;


	private JTextField observaciones;

	private Container contenedor;
	private GridBagLayout esquema;
	private GridBagConstraints restricciones;

	private Statement stmt;
	private Statement stmt2;

	private String sentencia;

	private String buscarcedsimple;
	private String buscarnomsimple;
	private String verificarsimple;
	private String sentenciaSQL = null;

	private String boxTension[] = {"..","Alto", "Normal", "Bajo"};
	private String boxAlergia[] = {"..","Animales", "Olores", "Alimentos","Medicamentos","Otros"};
	private String boxHijos[] = {"..","01", "02","03","04","05","Mas"};
	private String boxCargo[] = {"..","Obrero", "Operador","Chofer","Tecnico","Montacarguista","Supervisor","Otro"};
	private FlowLayout esquemalayout;


	private String flagcardio = "0";

	private String flagtension = "0";
	private String flagdiabetes = "0";
	private String flagalergia = "0";
	private String flagasma = "0";
	private String flaghijos = "0";

	private String auxflagcardio = "0";

	private String auxflagtension = "0";
	private Integer auxnivelTensio = 0;
	private String auxflagdiabetes = "0";
	private String auxflagalergia = "0";
	private String auxflagasma = "0";
	private String auxflaghijos = "0";
	private Integer auxgeneraAlergia = 0;
	private Integer auxnumHijos = 0;
	private Integer auxcargo = 0;


// configurar GUI
public Proveedor()
{
   super( "Modulo de Manejo de Proveedores " );

   contenedor = getContentPane();
	esquema = new GridBagLayout();
	contenedor.setLayout(esquema);
	restricciones = new GridBagConstraints();



	//getContentPane().setBackground(Color.LIGHT_GRAY);


	label0 = new JLabel(" Numero Cedula: ");
	label1 = new JLabel(" Primer Nombre: ");
	label2 = new JLabel(" Segundo Nombre: ");
	label3 = new JLabel(" Primer Apellido: ");
	label4 = new JLabel(" Segundo Apellido: ");
	label5 = new JLabel(" No. Telefono: ");
	label6 = new JLabel(" No. Celular: ");
	label7 = new JLabel(" e-mail: ");
	label8 = new JLabel(" Direccion: ");
	label9 = new JLabel(" Cargo: ");
	label10 = new JLabel(" Fecha Nacimiento: ");

	label13 = new JLabel("-----------------------------------");
	label14 = new JLabel("-----------------------------------");
	label15 = new JLabel("-----------------------------------");
	label16 = new JLabel("-----------------------------------");
	label17 = new JLabel("-----------------------------------");
	label18 = new JLabel("-----------------------------------");
	label19 = new JLabel("-----------------------------------");
	label20 = new JLabel("-----------------------------------");
	label21 = new JLabel("-----------------------------------");
	label22 = new JLabel("-----------------------------------");
	label25 = new JLabel("-----------------------------------");
	label26 = new JLabel("-----------------------------------");


	label24 = new JLabel("Observaciones:");



	cardio = new JCheckBox ("Cardiopatia", false);
	tension = new JCheckBox ("Tension", false);
	diabetes = new JCheckBox ("Diabetes", false);
	alergia = new JCheckBox ("Alergia", false);
	asma = new JCheckBox ("Asma", false);
	Hijos = new JCheckBox ("Hijos", false);

	observaciones = new JTextField();

	nivelTensio = new JComboBox(boxTension);
	generaAlergia = new JComboBox(boxAlergia);
	numHijos = new JComboBox(boxHijos);
	cargo = new JComboBox(boxCargo);



	nom1 = new JTextField();
	nom2 = new JTextField();
	apll1 = new JTextField();
	apll2 = new JTextField();
	ID_Operador = new JTextField();
	telf = new JTextField();
	celTelf = new JTextField();
	email = new JTextField();
	direcc = new JTextField();
	fnac = new JTextField();

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

			verificarsimple = ID_Operador.getText();

			try
			{
				String sql2 = "SELECT ID_Operador FROM Operador WHERE ID_Operador LIKE '" + verificarsimple + "'";
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
							+ "\n        !!! El Numero de Cedula Esta Registrado !!!"
							+ "\n!!! Verifique Sus Datos he Intente de Nuevo !!!");

				}

				if (bandera2 == 0)
				{


					sentencia = "INSERT INTO Operador VALUES('" + ID_Operador.getText() + "','" + nom1.getText()
					+"','"+nom2.getText()+"','"+ apll1.getText()+"','"+ apll2.getText()+
					"','"+ telf.getText()+"','"+ celTelf.getText()+
					"','"+ email.getText()+"','"+ direcc.getText()+"','"+ String.valueOf(cargo.getSelectedIndex())+
					"','"+ fnac.getText()+"','"+ String.valueOf(flagcardio) +
					"','"+ String.valueOf(flagtension) +"','"+ String.valueOf(nivelTensio.getSelectedIndex()) +
					"','"+ String.valueOf(flagdiabetes) +"','"+ String.valueOf(flagalergia) +
					"','"+ String.valueOf(generaAlergia.getSelectedIndex()) +"','"+ String.valueOf(flagasma) +
					"','"+ String.valueOf(flaghijos) +"','"+ String.valueOf(numHijos.getSelectedIndex()) +
					"','"+  String.valueOf(observaciones.getText()) +
					"')";

					System.out.println(String.valueOf(flagcardio));
					System.out.println(String.valueOf(flagdiabetes));
					//nivelTensio.setSelectedIndex(2);





					stmt = conx2.createStatement();
					stmt.executeUpdate(sentencia);

					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame,"Se ha agregado un actor al registro");

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
				buscarcedsimple = buscacedula.getText();
				limpiaceldas();
				stmt = conx3.createStatement();
				String sql = "SELECT * FROM Operador WHERE ID_Operador LIKE '" + buscarcedsimple + "'";
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

						ID_Operador.setText(rs.getString("ID_Operador"));
						nom1.setText(rs.getString("nom1"));
						nom2.setText(rs.getString("nom2"));
						apll1.setText(rs.getString("apll1"));
						apll2.setText(rs.getString("apll2"));
						telf.setText(rs.getString("telf"));
						celTelf.setText(rs.getString("celTelf"));
						email.setText(rs.getString("email"));
						direcc.setText(rs.getString("direcc"));
						auxcargo = rs.getInt("cargo");
						fnac.setText(rs.getString("fnac"));


						auxflagcardio = rs.getString("flagcardio");

						auxflagtension = rs.getString("flagtension");
						auxnivelTensio = rs.getInt("nivelTensio");
						auxflagdiabetes = rs.getString("flagdiabetes");
						auxflagalergia = rs.getString("flagalergia");
						auxgeneraAlergia= rs.getInt("generaAlergia");
						auxflagasma = rs.getString("flagasma");
						auxflaghijos = rs.getString("flaghijos");
						auxnumHijos = rs.getInt("numHijos");
						observaciones.setText(rs.getString("observaciones"));
						cargo.setSelectedIndex(auxcargo);


						if (auxflagcardio.equals("1"))
							{
								cardio.setSelected(true);

							}
						if (auxflagtension.equals("1"))
							{
								tension.setSelected(true);
								nivelTensio.setSelectedIndex(auxnivelTensio);
							}
						if (auxflagdiabetes.equals("1"))
							{
								diabetes.setSelected(true);
							}
						if (auxflagalergia.equals("1"))
							{
								alergia.setSelected(true);
								generaAlergia.setSelectedIndex(auxgeneraAlergia);
							}
						if (auxflagasma.equals("1"))
							{
								asma.setSelected(true);
							}
						if (auxflaghijos.equals("1"))
							{
							Hijos.setSelected(true);
							numHijos.setSelectedIndex(auxnumHijos);
							}


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
			buscarnomsimple = buscageneral.getText();
			limpiaceldas();
			sentenciaSQL = "SELECT ID_Operador, nom1, nom2, apll1, apll2 FROM Operador " +
					"WHERE nom1 LIKE '" + buscarnomsimple + "%'";
			Consulta app = new Consulta(sentenciaSQL);
			app.pack( );
			app.setVisible(true);


		}
	  	});


	cardio.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			if (flagcardio.equals("0"))
			{
				flagcardio = "1";

			}
			else
			{
				if (flagcardio.equals("1"))
				{
					flagcardio = "0";

				}
			}


		}

	});





tension.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e)
	{
		if (flagtension.equals("0"))
		{
			flagtension = "1";
			nivelTensio.setEnabled(true);

		}
		else
		{
			if (flagtension.equals("1"))
			{
				flagtension = "0";
				nivelTensio.setEnabled(false);

			}
		}


	}
});


diabetes.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e)
	{
		if (flagdiabetes.equals("0"))
		{
			flagdiabetes = "1";

		}
		else
		{
			if (flagdiabetes.equals("1"))
			{
				flagdiabetes = "0";

			}
		}


	}
});


alergia.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e)
	{
		if (flagalergia.equals("0"))
		{
			flagalergia = "1";
			generaAlergia.setEnabled(true);

		}
		else
		{
			if (flagalergia.equals("1"))
			{
				flagalergia = "0";
				generaAlergia.setEnabled(false);

			}
		}


	}
});

asma.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			if (flagasma.equals("0"))
			{
				flagasma = "1";

			}
			else
			{
				if (flagasma.equals("1"))
				{
					flagasma = "0";

				}
			}


		}
	});





	 Hijos.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			if (flaghijos.equals("0"))
			{
				flaghijos = "1";
				numHijos.setEnabled(true);

			}
			else
			{
				if (flaghijos.equals("1"))
				{
					flaghijos = "0";
					numHijos.setEnabled(false);

				}
			}


		}
	});




	agregarComponente (label13,1,0,1,1);
	agregarComponente (label14,1,1,1,1);
	agregarComponente (label15,1,2,1,1);
	agregarComponente (label16,1,3,1,1);
	restricciones.fill = GridBagConstraints.HORIZONTAL;
	agregarComponente (label0,2,1,1,1);
	agregarComponente (ID_Operador,2,2,1,1);
	agregarComponente (label1,3,0,1,1);
	agregarComponente (nom1,3,1,1,1);
	agregarComponente (label2,3,2,1,1);
	agregarComponente (nom2,3,3,1,1);
	agregarComponente (label3,4,0,1,1);
	agregarComponente (apll1,4,1,1,1);
	agregarComponente (label4,4,2,1,1);
	agregarComponente (apll2,4,3,1,1);
	agregarComponente (label5,5,0,1,1);
	agregarComponente (telf,5,1,1,1);
	agregarComponente (label6,5,2,1,1);
	agregarComponente (celTelf,5,3,1,1);
	agregarComponente (label7,6,0,1,1);
	agregarComponente (email,6,1,2,1);
	agregarComponente (label8,7,0,1,1);
	agregarComponente (direcc,7,1,3,1);
	agregarComponente (label9,8,0,1,1);
	agregarComponente (cargo,8,1,3,1);
	agregarComponente (label10,9,0,1,1);
	agregarComponente (fnac,9,1,1,1);
	agregarComponente (label19,12,0,1,1);
	agregarComponente (label20,12,1,1,1);
	agregarComponente (label21,12,2,1,1);
	agregarComponente (label22,12,3,1,1);

	agregarComponente (cardio,15,2,1,1);

	agregarComponente (tension,14,0,1,1);
	agregarComponente (nivelTensio,14,1,1,1);
	agregarComponente (diabetes,14,2,1,1);
	agregarComponente (asma,18,2,1,1);
	agregarComponente (alergia,15,0,1,1);
	agregarComponente (generaAlergia,15,1,1,1);
	agregarComponente (Hijos,18,0,1,1);
	agregarComponente (numHijos,18,1,1,1);
	agregarComponente (label24,20,0,1,1);
	agregarComponente (observaciones,20,1,3,1);
	agregarComponente (label17,21,0,1,1);
	agregarComponente (label18,21,1,1,1);
	agregarComponente (label25,21,2,1,1);
	agregarComponente (label26,21,3,1,1);

	//agregarComponente (boton1,22,1,1,1);
	//agregarComponente (boton2,22,2,1,1);


   // crear objeto JTabbedPane
   JTabbedPane panelConFichas = new JTabbedPane();

   //esquemalayout = new FlowLayout();
   //panelConFichas.setLayout(esquemalayout);


   // establecer pane11 y agregarlo al objeto JTabbedPane
   JLabel etiqueta1 = new JLabel( "Manejo de Ingreso de Nuevo Operador", SwingConstants.CENTER );
   JPanel panel4 = new JPanel();
   JPanel panel4aux = new JPanel();
   panel4.setLayout( new BorderLayout() );
   panel4.add( etiqueta1, BorderLayout.NORTH );
   panel4aux.add(boton1);
   panel4aux.add(boton2);
   panel4aux.add(boton3);
   panel4.add( panel4aux, BorderLayout.SOUTH );
   panelConFichas.addTab( "Nueva", null, panel4, "Ingresa Nueva Ficha" );

   // establecer panel2 y agregarlo al objeto JTabbedPane
   JLabel etiqueta2 = new JLabel( "Manejo de Consulta de Operador", SwingConstants.CENTER );

   buscacedula = new JTextField();
   buscageneral = new JTextField();
   JPanel panel5 = new JPanel();
   JPanel panel5aux = new JPanel();
   panel5aux.setLayout( new GridLayout(2,3) );
   panel5.setLayout( new BorderLayout() );
   //panel5.setBackground( Color.YELLOW );
   panel5.add( etiqueta2, BorderLayout.NORTH  );
   panel5aux.add(new JLabel( "Ingrese Cedula a Buscar" ));
   panel5aux.add(buscacedula);
   panel5aux.add(boton4);
   panel5aux.add(new JLabel( "Busqueda General Por Nombre" ));
   panel5aux.add( buscageneral);
   panel5aux.add(boton5);
   panel5.add(panel5aux, BorderLayout.SOUTH );

   panelConFichas.addTab( "Consulta", null, panel5, "Consulta Fichas Ingresadas" );

   // establecer panel3 y agregarlo al objeto JTabbedPane
   JLabel etiqueta3 = new JLabel( "panel tres");
   JPanel panel6 = new JPanel();
   panel6.setLayout( new BorderLayout() );
   panel6.setBackground( Color.YELLOW );
   panel6.add( etiqueta3 );

   panel6.add( new JButton( "Norte" ), BorderLayout.NORTH );
   panel6.add( new JButton( "Oeste" ), BorderLayout.WEST );
   panel6.add( new JButton( "Este" ), BorderLayout.EAST );
   panel6.add( new JButton( "Sur" ), BorderLayout.SOUTH );

   panelConFichas.addTab( "Modifica", null, panel6, "Edita Valores de Ficha" );

// establecer pane14 y agregarlo al objeto JTabbedPane
   JLabel etiqueta4 = new JLabel( "panel cuatro", SwingConstants.CENTER );
   JPanel panel7 = new JPanel();
   panel7.add( etiqueta4 );
   panelConFichas.addTab( "Elimina", null, panel7, "Elimina Ficha" );

   // agregar objeto JTabbedPane al contenedor

   panelConFichas.setSize(400,300);

   agregarComponente (panelConFichas,0,0,4,1);






   getContentPane();

   pack();
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
	nom1.setEnabled(true);
	nom2.setEnabled(true);
	apll1.setEnabled(true);
	apll2.setEnabled(true);
	ID_Operador.setEnabled(true);
	telf.setEnabled(true);
	celTelf.setEnabled(true);
	email.setEnabled(true);
	direcc.setEnabled(true);
	cargo.setEnabled(true);
	fnac.setEnabled(true);



	cardio.setEnabled(true);
	tension.setEnabled(true);
	diabetes.setEnabled(true);
	alergia.setEnabled(true);
	asma.setEnabled(true);
	Hijos.setEnabled(true);
	nivelTensio.setEnabled(true);
	generaAlergia.setEnabled(true);
	numHijos.setEnabled(true);
	observaciones.setEnabled(true);

}

private void limpiaceldas()
{
nom1.setText("");
nom2.setText("");
apll1.setText("");
apll2.setText("");
ID_Operador.setText("");
telf.setText("");
celTelf.setText("");
email.setText("");
direcc.setText("");
cargo.setSelectedIndex(0);
fnac.setText("");
observaciones.setText("");

buscacedula.setText("");
buscageneral.setText("");



cardio.setSelected(false);
tension.setSelected(false);
diabetes.setSelected(false);
alergia.setSelected(false);
asma.setSelected(false);
Hijos.setSelected(false);
nivelTensio.setSelectedIndex(0);
numHijos.setSelectedIndex(0);
generaAlergia.setSelectedIndex(0);

}

private void desactivaceldas()
{
	nom1.setEnabled(false);
	nom2.setEnabled(false);
	apll1.setEnabled(false);
	apll2.setEnabled(false);
	ID_Operador.setEnabled(false);
	telf.setEnabled(false);
	celTelf.setEnabled(false);
	email.setEnabled(false);
	direcc.setEnabled(false);
	cargo.setEnabled(false);
	fnac.setEnabled(false);


	cardio.setEnabled(false);
	tension.setEnabled(false);
	diabetes.setEnabled(false);
	alergia.setEnabled(false);
	asma.setEnabled(false);
	Hijos.setEnabled(false);

	nivelTensio.setEnabled(false);
	generaAlergia.setEnabled(false);
	numHijos.setEnabled(false);
	observaciones.setEnabled(false);


}

} // fin de la clase Operador.