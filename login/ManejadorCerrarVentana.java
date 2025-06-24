/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package login;

import java.awt.event.*;

/**
 *
 * @author melvin
 */
public class ManejadorCerrarVentana extends WindowAdapter
{
	ClosingDialog cerrando = new ClosingDialog();

	public void windowClosing(WindowEvent we)
	{
		cerrando.cerrar();
	}

}