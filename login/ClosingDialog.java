/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package login;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author melvin
 */
public class ClosingDialog extends JFrame
{

	public void cerrar()
	{
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame,"Desarrollado Por: Melvin E. Padilla" +
					"\n          Gracias por Utilizar Nuestro Sistema." +
					"\n                    !!! Hasta Luego !!!");
			System.exit(0);

	}
}
