/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package login;

/**
 *
 * @author melvin
 */

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import utils.CreateTable;
import utils.DropTables;
import utils.elementos;
import utils.Barras;
import utils.DropYbus;



public class StartSys extends JFrame {


	private JPanel jPanel = null;
	private JLabel fondodesktop = null;
	private JMenuBar barramenudesktop = null;
	private JMenuItem ManejElemt = null;
	private JMenuItem ManejYbus = null;
        private JMenuItem ManejYbusctrl = null;
        private JMenuItem ManejBarra = null;
	private JMenuItem ManejCliente = null;
	private JMenuItem creartablas = null;
	private JMenuItem borrartablas = null;
	private JMenuItem borrarybus = null;
        private JMenuItem salir = null;
	private JMenuItem acerca = null;
	private JMenuItem Report = null;
	private JMenuItem ManeCompra = null;
	private JMenuItem ManeVenta = null;
	private JMenuItem AjusComVen = null;
	private JMenuItem Plani = null;
	private String salida = "N";
	private String contrasenadmin = "xxxxxxx";




	public StartSys () {

		super ("FCpowerSys - Analisis de Sistemas de Potencia. - Flujo de Carga");
		this.addWindowListener(new ManejadorCerrarVentana());



		jPanel = new JPanel();

		fondodesktop = new JLabel (new ImageIcon("src/imgs/fondo.png"));

		barramenudesktop = new JMenuBar();

		JMenu menudesk1 = new JMenu("General");
		menudesk1.setMnemonic('G');
		barramenudesktop.add(menudesk1);

			salir = new JMenuItem("Cerrar Sistema");
			salir.setMnemonic('e');
			salir.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
	    		{
					salida = JOptionPane.showInputDialog(StartSys.this,
							"!!! Se dispone a salir del sistema. !!!" +
							"\n          Esta Seguro ? (S/N) ",
							"Fcpowersys - Sistemas de Potencia II", JOptionPane.QUESTION_MESSAGE);

					if (salida.equals("S"))
					{
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame,"Desarrollado Por: Melvin E. Padilla" );
						System.exit(0);
					}

	    		}
			});
			menudesk1.add(salir);

		JMenu menudesk2 = new JMenu("Manejos");
		menudesk2.setMnemonic('C');
		barramenudesktop.add(menudesk2);

			ManejElemt = new JMenuItem("Manejo de Elementos");
			ManejElemt.setMnemonic('M');
			ManejElemt.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
	    		{
					JFrame frame = new JFrame();
					//JOptionPane.showMessageDialog(frame,"Pulsada opcion Manejo de Elementos.");

					elementos app = new elementos();
					app.pack( );
					app.setVisible(true);

	    		}
			});

			menudesk2.add(ManejElemt);


			ManejBarra = new JMenuItem("Manejo de Barras");
			ManejBarra.setMnemonic('a');
			ManejBarra.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
	    		{
					JFrame frame = new JFrame();
					//JOptionPane.showMessageDialog(frame,"Pulsada opcion Manejo de Elementos.");

					Barras app = new Barras();
					app.pack( );
					app.setVisible(true);

	    		}
			});

			menudesk2.add(ManejBarra);


			ManejYbus = new JMenuItem("Generar Ybus");
			ManejYbus.setMnemonic('G');
			ManejYbus.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
	    		{
					/*JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame,"Pulsada opcion Ybus.");

					 Ybus app = new Ybus();
                                         app.genybus(); */
                                        
                                        JFrame frame = new JFrame("Mostrar YBus");
                                        frame.setContentPane(new Ybus());
                                        frame.setSize(200, 200);
                                        frame.pack();
                                        frame.setResizable(false);
                                        frame.setVisible(true);

	    		}
			});

			menudesk2.add(ManejYbus);


                        ManejYbusctrl = new JMenuItem("Generar Ybusctrl");
			ManejYbusctrl.setMnemonic('Y');
			ManejYbusctrl.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
	    		{
					/*JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame,"Pulsada opcion Ybus.");

					 Ybus app = new Ybus();
                                         app.genybus(); */

                                        JFrame frame = new JFrame("Mostrar YBusctrl");
                                        frame.setContentPane(new Ybusctrl());
                                        frame.setSize(200, 200);
                                        frame.pack();
                                        frame.setResizable(false);
                                        frame.setVisible(true);

	    		}
			});

			menudesk2.add(ManejYbusctrl);


                        /* ManejCliente = new JMenuItem("Manejo de Cliente");
			ManejCliente.setMnemonic('n');
			ManejCliente.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
	    		{
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame,"Pulsada opcion Manejo de Cliente.");

					Cliente app = new Cliente();
					app.pack( );
					app.setVisible(true);

	    		}
			});

			menudesk2.add(ManejCliente);
*/

			JMenu menudesk3 = new JMenu("Datos");
			menudesk3.setMnemonic('D');

			ManeCompra = new JMenuItem("Generar Ybus");
			ManeCompra.setMnemonic('G');
			ManeCompra.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
	    		{
					
                                       /* Ybus app = new Ybus();
					app.genybus();
                                    */
                                       /* JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame,"Pulsada opcion Generar Ybus.");
*/
                                        
					
	    		}
			});

			//menudesk3.add(ManeCompra);
/*
			ManeVenta = new JMenuItem("Manejo de Ventas");
			ManeVenta.setMnemonic('a');
			ManeVenta.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
	    		{
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame,"Pulsada opcion Manejo de Ventas.");

					/*Ficha app = new Ficha();
					app.pack( );
					app.setVisible(true);
					*/
	/*    		}
			});

			menudesk3.add(ManeVenta);

			AjusComVen = new JMenuItem("Ajustes");
			AjusComVen.setMnemonic('j');
			AjusComVen.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
	    		{
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame,"Pulsada opcion Ajustes.");

					/*Ficha app = new Ficha();
					app.pack( );
					app.setVisible(true);
					*/
	    	/*	}
			});

			menudesk3.add(AjusComVen);
*/
			barramenudesktop.add(menudesk3);

/*
		JMenu menudesk8 = new JMenu("Planillas");
		menudesk8.setMnemonic('P');
		barramenudesktop.add(menudesk8);

			Plani = new JMenuItem("Planillas");
			Plani.setMnemonic('P');
			menudesk8.add(Plani);
			Plani.addActionListener( new ActionListener() {

					public void actionPerformed( ActionEvent evento)
					{
						JOptionPane.showMessageDialog(StartSys.this,"Pulsada opcion Planillas.");
					}
				}

	);

			JMenu menudesk7 = new JMenu("Reportes");
			menudesk7.setMnemonic('R');
			barramenudesktop.add(menudesk7);

				Report = new JMenuItem("Reportes");
				Report.setMnemonic('A');
				menudesk7.add(Report);
				Report.addActionListener( new ActionListener() {

						public void actionPerformed( ActionEvent evento)
						{
							JOptionPane.showMessageDialog(StartSys.this,"Pulsada opcion Reportes.");
						}
					}

		);
*/

		JMenu menudesk5 = new JMenu("Mantenimiento");
		menudesk5.setMnemonic('M');

		creartablas = new JMenuItem("Crear Base de Datos");
		creartablas.setMnemonic('B');
		menudesk5.add(creartablas);
		creartablas.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
    		{
				contrasenadmin = null;
				contrasenadmin = "" + JOptionPane.showInputDialog("Ingrese la Contraseña de Administrador");



				if (contrasenadmin.equals(""))
				{
					contrasenadmin = "xxxxxxx";
					JOptionPane.showMessageDialog(StartSys.this,
							"                !!! Usted ha Cancelado la Operacion !!!" +
							"\n!! Comuniquese con el Administrador del Sistema !!!",
							"Fcpowersys. - Sistemas de Potencia II", JOptionPane.ERROR_MESSAGE);
				}

				if (contrasenadmin.equals("jefe"))
				{
					CreateTable app = new CreateTable();
					app.tabla();
				}
				else
				{
					JOptionPane.showMessageDialog(StartSys.this,
							"                !!! Contraseï¿œa Incorrecta !!!" +
							"\n!! Usted No Esta Autorizado a Realizar Esta Operacion !!!",
							"Fcpowersys. - Sistemas de Potencia II", JOptionPane.ERROR_MESSAGE);

				}

    		}
		});

		borrartablas = new JMenuItem("Borrar Base de Datos");
		borrartablas.setMnemonic('o');
		menudesk5.add(borrartablas);
		borrartablas.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
    		{
				contrasenadmin = null;
				contrasenadmin = "" + JOptionPane.showInputDialog("Ingrese la Contrase#a de Administrador");



				if (contrasenadmin.equals(""))
				{
					contrasenadmin = "xxxxxxx";
					JOptionPane.showMessageDialog(StartSys.this,
							"                !!! Usted ha Cancelado la Operacion !!!" +
							"\n!! Comuniquese con el Administrador del Sistema !!!",
							"Fcpowersys. - Sistemas de Potencia II", JOptionPane.ERROR_MESSAGE);
				}

				if (contrasenadmin.equals("jefe"))
				{
						DropTables app = new DropTables();
						app.borrarTablas();
		    	}
				else
				{
					JOptionPane.showMessageDialog(StartSys.this,
							"                !!! Contraseï¿œa Incorrecta !!!" +
							"\n!! Usted No Esta Autorizado a Realizar Esta Operacion !!!",
							"Fcpowersys. - Sistemas de Potencia II", JOptionPane.ERROR_MESSAGE);

				}

    		}
		});

                borrarybus = new JMenuItem("Reiniciar Ybus");
		borrarybus.setMnemonic('o');
		menudesk5.add(borrarybus);
		borrarybus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
    		{
				contrasenadmin = null;
				contrasenadmin = "" + JOptionPane.showInputDialog("Ingrese la Contrase#a de Administrador");



				if (contrasenadmin.equals(""))
				{
					contrasenadmin = "xxxxxxx";
					JOptionPane.showMessageDialog(StartSys.this,
							"                !!! Usted ha Cancelado la Operacion !!!" +
							"\n!! Comuniquese con el Administrador del Sistema !!!",
							"Fcpowersys. - Sistemas de Potencia II", JOptionPane.ERROR_MESSAGE);
				}

				if (contrasenadmin.equals("jefe"))
				{
						DropYbus app = new DropYbus();
						app.borrarYbus();
		    	}
				else
				{
					JOptionPane.showMessageDialog(StartSys.this,
							"                !!! Contraseï¿œa Incorrecta !!!" +
							"\n!! Usted No Esta Autorizado a Realizar Esta Operacion !!!",
							"Fcpowersys. - Sistemas de Potencia II", JOptionPane.ERROR_MESSAGE);

				}

    		}
		});


		barramenudesktop.add(menudesk5);


		JMenu menudesk6 = new JMenu("Ayuda");
		menudesk6.setMnemonic('A');
		barramenudesktop.add(menudesk6);

			acerca = new JMenuItem("Acerca de...");
			acerca.setMnemonic('A');
			menudesk6.add(acerca);
			acerca.addActionListener( new ActionListener() {

					public void actionPerformed( ActionEvent evento)
					{
						JOptionPane.showMessageDialog(StartSys.this,
								"FcpowerSys. " +
								"\nFlujo de carga. " +
								"\nContacto: padilla.melvin@gmail.com " +
								"\n0241-6350366.  0412-8441590. " +
								"\nValencia, Edo.Carabobo, Venezuela " +
								"\nEste Software Pertenece a: Melvin E. Padilla" +
								"\nSe Autoriza su uso a: ",
								"Fcpowersys. - Sistemas de Potencia II", JOptionPane.INFORMATION_MESSAGE);
					}
				});







		setJMenuBar(barramenudesktop);


	}

	public void organizarComponentes() {


		jPanel.add(fondodesktop);


		Container c = getContentPane();
		c.add(jPanel);



	}




}