/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package login;

/**
 *
 * @author melvin
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Starlogin extends JFrame{

	;
	private JPanel jPanel1 = null;
	private JPanel jPanel2 = null;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;

	private JButton boton1;
	private JButton boton2;

	private JTextField texto1;
	private JTextField texto2;

	private String usuarioin = null;
	private String contrasenain = null;



	public Starlogin(){

		super( "FCpowerSys - Autenticacion." );
		this.addWindowListener(new ManejadorCerrarVentana());


		jPanel1 = new JPanel();
		jPanel2 = new JPanel();
		label1 = new JLabel("_____________________Usuario:");
		label2 = new JLabel("_____________________Contraseña:");
		label3 = new JLabel (new ImageIcon("src/imgs/intro.png"));

		boton1 = new JButton("Autenticar");
		boton2 = new JButton("Cancelar");
		texto1 = new JTextField();
		texto2 = new JTextField();

	}

	private void organizarComponentes()
	{

		jPanel1.add(label3);

		jPanel2.setLayout(new GridLayout(3,2));
		jPanel2.add(label1);
		jPanel2.add(texto1);
		jPanel2.add(label2);
		jPanel2.add(texto2);
		jPanel2.add(boton1);
		jPanel2.add(boton2);

		Container c = getContentPane();
		c.add(jPanel1, BorderLayout.NORTH);
		c.add(jPanel2, BorderLayout.SOUTH );


		boton1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
    		{
				usuarioin = texto1.getText();
				contrasenain = texto2.getText();


				if (usuarioin.equals("jefe"))
					{
						if (contrasenain.equals("jefe"))
						{
							StartSys app2 = new StartSys();
							app2.organizarComponentes();
							app2.setSize(900 , 520);
							app2.setResizable(false);
							app2.setVisible(true);
							texto1.setText("");
							texto2.setText("");

						}
						else
						{

							JOptionPane.showMessageDialog(Starlogin.this,
									"!!! Contraseï¿œa Incorrecta !!!" +
									"\nVerifique e intente de nuevo.",
									"Enlighten Enterprise ENENCA C.A.", JOptionPane.ERROR_MESSAGE);

							texto1.setText("");
							texto2.setText("");
						}
					}
				else
				{
					JOptionPane.showMessageDialog(Starlogin.this,
							"!!! Usuario Desconocido !!!" +
							"\nVerifique e intente de nuevo.",
							"Enlighten Enterprise ENENCA C.A.", JOptionPane.ERROR_MESSAGE);
					texto1.setText("");
					texto2.setText("");
				}

    		}
		});

		boton2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
    		{
				JOptionPane.showMessageDialog(Starlogin.this,
						"!!! Contactemos !!!" +
						"\nGustosamente le autorizaremos el producto." +
						"\nContacto: padilla.melvin@gmail.com " +
						"\n0241-6350366.  0412-8441590. " +
						"\nValencia, Edo.Carabobo, Venezuela " +
						"\nEste Software Pertenece a: Melvin E. Padilla.",
						"Melvin E. Padilla.", JOptionPane.WARNING_MESSAGE);
				texto1.setText("");
				texto2.setText("");
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame,"Desarrollado Por: Melvin E. Padilla." );
				System.exit(0);

    		}
		});
	}


	public static void main(String[] args) {

		Starlogin app = new Starlogin();
		app.organizarComponentes();
		app.pack( );
		app.setResizable(false);
		app.setVisible(true);


	}
}