/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package login;

import utils.DropYbus;
import tools.Matrix;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.DecimalFormat;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import utils.Conex_Flujos;
import javax.swing.JFrame;
import utils.Consulta;
import java.lang.Math;

import tools.Complex;
import tools.ComplexMatrix;
import tools.Fmath;



/**
 *
 * @author melvin
 */
public class Ybusctrl  extends JPanel{

    private Statement stmt;
    private Statement stmt2;
    private Statement stmt3;
    private Statement stmt4;
    private Statement stmt5;
    private Statement stmt8;
    private Statement stmt9;
    private Statement stmt10;
    private Statement stmt11;
    private Statement stmt12;
     private Statement stmt15;
     private Statement stmt20;
    private Statement stmt31;
    private Statement stmt32;
    private Statement stmt33;
    private Statement stmt34;
    private Statement stmt35;
    private Statement stmt36;
    private Statement stmt37;
    private Statement stmt38;
    private Statement stmt39;
    private Statement stmt40;
    private Statement stmt41;
    private Statement stmt42;
    private Statement stmt43;
    private Statement stmt44;
    private Statement stmt45;
    private Statement stmt46;
    private Statement stmt47;
    private Statement stmt49;
    private Statement stmt51;
    private Statement stmtybus;
    private String sentencia;
    private String sentenciaybus;

    private JList list;
    private DefaultListModel model;

    public String n1 = null;
    public String n2 = null;
    public String n5 = null;
    public String n6 = null;
    private int n7 = 1;
    private int nP = 0;
    private int nQ = 0;
    private int VectorP[];
    private int VectorQ[];
    private double VectorPcal[];
    private double VectorQcal[];
    private double VectorV[];
    private double VectorAng[];
    private double VectorPesp[];
    private double VectorQesp[];
    private double VectorPiny[];
    private double VectorQiny[];
    private double DeltaP[];
    private double DeltaQ[];
    private double DeltaPdivV[];
    private double DeltaQdivV[];
    private double DeltaAng[];
    private double DeltaVol[];
    private double SolucionAng[];
    private double SolucionVol[];



    public String nmax = null;
    private String fila = "";
    private String fila2 = "";
    private String real1;
    private String imag1;
    private String completmax;
    private String completmaxybus;
    private String completauxformat1;
    private String realauxformat2;
    private String imagauxformat2;
     private String realauxformat3;
    private String imagauxformat3;
    private String Epsilonstr;
    private String Iterastr;

    private double matrix[][] = null;
    private ComplexMatrix commax[][];
    private ComplexMatrix commaxformat[][];
    private Complex comnum;
    private Complex comnumybus;
    private Complex completauxformat2;
    private Complex auxcomplexformat;


    private double tipbar = 0;

    private int index[] = null;
    private double constan = 0;
    private double realaux = 0;
    private double yshuntaux = 0;
    private double yshuntaux2 = 0;
    private double imaginaux = 0;
    private double realaux2 = 0;
    private double imaginaux2 = 0;
    private double real2 = 0;
    private double imag2 = 0;
    private double real3 = 0;
    private double imag3 = 0;
    private double real4 = 0;
    private double imag4 = 0;
    private double real5 = 0;
    private double imag5 = 0;
     private double real6 = 0;
    private double imag6 = 0;
    private double real7 = 0;
    private double imag7 = 0;
    
    private double real3inv = 0;
    private double imag3inv = 0;
    private double real5inv = 0;
    private double imag5inv = 0;
    private double a = 0;
    private double b = 0;
    private double realauxformat1;
    private double imagauxformat1;
    private double Qi = 0;
    private double ABS = 0;
    private double ARG = 0;
    private double Paux = 0;
    private double Qaux = 0;
    private double error = 0;
    private double err1 = 0;
    private double err2 = 0;
    private double err3 = 0;
    private double err4 = 0;
    private double err5 = 0;
    private double ycompensaux = 0;
    private double ycompensareal = 0;
    private double ycompensaimg = 0;



    JButton botonone = new JButton("Gauss");
    JButton botontwo = new JButton("Gauss-S");
    JButton botonthree = new JButton("Newton-R");
    JButton botonfour = new JButton("Desacoplado");

    public Ybusctrl(){

        Conex_Flujos cone = new Conex_Flujos();
	Connection conx = cone.conectar();

	Conex_Flujos cone2 = new Conex_Flujos();
	Connection conx2 = cone2.conectar();

        Conex_Flujos cone3 = new Conex_Flujos();
	Connection conx3 = cone3.conectar();

        Conex_Flujos cone4 = new Conex_Flujos();
	Connection conx4 = cone4.conectar();

        Conex_Flujos cone5 = new Conex_Flujos();
	final Connection conx5 = cone5.conectar();

        Conex_Flujos cone6 = new Conex_Flujos();
	final Connection conx6 = cone6.conectar();

        Conex_Flujos cone7 = new Conex_Flujos();
	final Connection conx7 = cone7.conectar();

        Conex_Flujos cone8 = new Conex_Flujos();
	final Connection conx8 = cone8.conectar();

        Conex_Flujos cone9 = new Conex_Flujos();
	final Connection conx9 = cone9.conectar();

        Conex_Flujos cone10 = new Conex_Flujos();
	final Connection conx10 = cone10.conectar();

        Conex_Flujos cone11 = new Conex_Flujos();
	final Connection conx11 = cone11.conectar();

        Conex_Flujos cone12 = new Conex_Flujos();
	final Connection conx12 = cone12.conectar();

         Conex_Flujos cone20 = new Conex_Flujos();
	Connection conx20 = cone20.conectar();

        Conex_Flujos cone21 = new Conex_Flujos();
	final Connection conx21 = cone21.conectar();

        Conex_Flujos cone33 = new Conex_Flujos();
	final Connection conx33 = cone33.conectar();

        Conex_Flujos cone34 = new Conex_Flujos();
	final Connection conx34 = cone34.conectar();

         Conex_Flujos cone35 = new Conex_Flujos();
	final Connection conx35 = cone35.conectar();

        Conex_Flujos cone36 = new Conex_Flujos();
	final Connection conx36 = cone36.conectar();

        Conex_Flujos cone37 = new Conex_Flujos();
	final Connection conx37 = cone37.conectar();

        Conex_Flujos cone38 = new Conex_Flujos();
	final Connection conx38 = cone38.conectar();

        Conex_Flujos cone39 = new Conex_Flujos();
	final Connection conx39 = cone39.conectar();

        Conex_Flujos cone40 = new Conex_Flujos();
	final Connection conx40 = cone40.conectar();

        Conex_Flujos cone41 = new Conex_Flujos();
	final Connection conx41 = cone41.conectar();

        Conex_Flujos cone42 = new Conex_Flujos();
	final Connection conx42 = cone42.conectar();

        Conex_Flujos cone43 = new Conex_Flujos();
	final Connection conx43 = cone43.conectar();

        Conex_Flujos cone44 = new Conex_Flujos();
	final Connection conx44 = cone44.conectar();

        Conex_Flujos cone45 = new Conex_Flujos();
	final Connection conx45 = cone45.conectar();

        Conex_Flujos cone46 = new Conex_Flujos();
	final Connection conx46 = cone46.conectar();

        Conex_Flujos cone47 = new Conex_Flujos();
	final Connection conx47 = cone47.conectar();

        Conex_Flujos cone49 = new Conex_Flujos();
	final Connection conx49 = cone49.conectar();

        Conex_Flujos cone51 = new Conex_Flujos();
	final Connection conx51 = cone51.conectar();




        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(6);

        Complex auxcomplex = new Complex(a,b);
        Complex auxcomplex2 = new Complex(a,b);
        Complex auxcomplex3 = new Complex(a,b);
        Complex auxcomplex4 = new Complex(a,b);
        Complex auxcomplexshunt = new Complex(a,b);
        Complex ycompensa = new Complex(a,b);

        DropYbus app = new DropYbus();
	app.borrarYbus();


			try
			{
				String sql = "SELECT MAX(nodini) FROM nodos";
				stmt = conx.createStatement();

                               	ResultSet rs = stmt.executeQuery( sql );

                               		while (rs.next())
					{
						 n1 = rs.getString("MAX(nodini)");
                                                /*JFrame frame2 = new JFrame();
                                                JOptionPane.showMessageDialog(frame2,"Maxino nodo inicio:  " + n1);
                                        */}

                               	conx.close();

			}
			catch(SQLException e1)
			{
				JFrame frame3 = new JFrame();
				JOptionPane.showMessageDialog(frame3,"No se pudo establecer conexi�n con la BD" + e1.getMessage());
			}

                        try
			{
				String sql2 = "SELECT MAX(nodfin) FROM nodos";
				stmt2 = conx2.createStatement();

                               	ResultSet rs2 = stmt2.executeQuery( sql2 );

                               		while (rs2.next())
					{
						n2 = rs2.getString("MAX(nodfin)");
                                                /*JFrame frame5 = new JFrame();
                                                JOptionPane.showMessageDialog(frame5,"Maxino nodo fin:  " + n2);
                                        */}

                               	conx2.close();

			}
			catch(SQLException e2)
			{
				JFrame frame6 = new JFrame();
				JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
			}


                        Integer nn1 = Integer.parseInt(n1);
                        Integer nn2 = Integer.parseInt(n2);

                        Integer nmax = Math.max(nn1, nn2);

                        /*JFrame frame5 = new JFrame();
                        JOptionPane.showMessageDialog(frame5,"Maxino nodo: " + nmax);
*/

                        setLayout(new BorderLayout());
                        model = new DefaultListModel();
                        list = new JList(model);

                        JScrollPane pane = new JScrollPane(list);
                        JPanel botones = new JPanel();

                        ComplexMatrix commax = new ComplexMatrix(nmax,nmax);
                        ComplexMatrix commaxformat = new ComplexMatrix(nmax,nmax);

                        for(int i=0;i<nmax;i++){
                            for(int j=0;j<nmax;j++){
                                if (i == j)
                                    {

                                    try
                                    {
                                        real3inv = 0;
                                        imag3inv  = 0;
                                        yshuntaux = 0;


                                        String sql3 = "SELECT resis, react, yshunt FROM nodos WHERE nodini LIKE " + (i + 1) + " OR nodfin LIKE " + (j + 1);

                                        stmt3 = conx3.createStatement();

                                        ResultSet rs3 = stmt3.executeQuery( sql3 );

                               		while (rs3.next())
					{
						 realaux = Double.parseDouble(rs3.getString("resis"));
                                                 imaginaux = Double.parseDouble(rs3.getString("react"));
                                                 yshuntaux = Double.parseDouble(rs3.getString("yshunt"));

                                                auxcomplex.setReal(realaux);
                                                auxcomplex.setImag(imaginaux);

                                                auxcomplexshunt.setReal(0);
                                                auxcomplexshunt.setImag(yshuntaux);

                                                auxcomplex = auxcomplex.inverse();
                                                /*auxcomplexshunt = auxcomplexshunt.inverse();*/


                                                if (auxcomplex.isNaN())
                                                    {
                                                        auxcomplex.setReal(0);
                                                        auxcomplex.setImag(0);

                                                    }

                                                if (auxcomplexshunt.isNaN())
                                                    {
                                                        auxcomplexshunt.setReal(0);
                                                        auxcomplexshunt.setImag(0);

                                                    }

                                                real3inv = real3inv + auxcomplex.getReal();
                                                imag3inv = imag3inv + auxcomplex.getImag() + auxcomplexshunt.getImag();

                                        }

                                        /*real3 = Double.parseDouble(nf.format(real3));
                                        imag3 = Double.parseDouble(nf.format(imag3));*/

                                        /*real3inv = Double.parseDouble(nf.format(real3inv));
                                        imag3inv = Double.parseDouble(nf.format(imag3inv));*/

                                        ycompensaux = 0;


                                        String sql15 = "SELECT Compensa FROM barras WHERE Numbarra LIKE " + (i+1);

                                        stmt15 = conx3.createStatement();

                                        ResultSet rs15 = stmt15.executeQuery( sql15 );

                               		while (rs15.next())
					{
						 ycompensaux = Double.parseDouble(rs15.getString("Compensa"));

                                                ycompensa.setReal(0);
                                                ycompensa.setImag(ycompensaux);


                                                if (ycompensa.isNaN())
                                                    {
                                                        ycompensa.setReal(0);
                                                        ycompensa.setImag(0);

                                                    }

                                                real3inv = real3inv + ycompensa.getReal();
                                                imag3inv = imag3inv + ycompensa.getImag();

                                        }



                                         commax.setElement(i, j, real3inv, imag3inv);



                                    }
                                    catch(SQLException e1)
                                            {
                                                JFrame frame3 = new JFrame();
                                                   JOptionPane.showMessageDialog(frame3,"No se pudo establecer conexi�n con la BD" + e1.getMessage());
                                            }




                                    }
                                else
                                {
                                     try
                                    {
                                        real5 = 0;
                                        imag5 = 0;

                                        String sql4 = "SELECT resis, react FROM nodos WHERE nodini LIKE " + (i + 1) + " AND nodfin LIKE " + (j + 1);

                                        stmt4 = conx4.createStatement();

                                        ResultSet rs4 = stmt4.executeQuery( sql4 );

                               		while (rs4.next())
					{
						 realaux2 = Double.parseDouble(rs4.getString("resis"));
                                                 imaginaux2 = Double.parseDouble(rs4.getString("react"));



                                                real5 = real5 + realaux2;
                                                imag5 = imag5 + imaginaux2;




                                        }

                                        /*real5 = Double.parseDouble(nf.format(real5));
                                        imag5 = Double.parseDouble(nf.format(imag5));*/


                                        auxcomplex3.setReal(real5);
                                        auxcomplex3.setImag(imag5);

                                        auxcomplex3 = auxcomplex3.inverse();
                                        auxcomplex3 = auxcomplex3.negate();



                                        if (auxcomplex3.isNaN())
                                        {
                                            auxcomplex3.setReal(0);
                                            auxcomplex3.setImag(0);

                                        }


                                        real5inv = auxcomplex3.getReal();
                                        imag5inv = auxcomplex3.getImag();

                                        /*real5inv = Double.parseDouble(nf.format(real5inv));
                                        imag5inv = Double.parseDouble(nf.format(imag5inv));*/

                                        commax.setElement(i, j, real5inv, imag5inv);





                                    }
                                    catch(SQLException e1)
                                            {
                                                JFrame frame3 = new JFrame();
                                                   JOptionPane.showMessageDialog(frame3,"No se pudo establecer conexi�n con la BD" + e1.getMessage());
                                            }



                                }

                                }
                        }

                        for(int i=0;i<nmax;i++)
                        {

                            for(int j=0;j<nmax;j++)
                            {
                              if (i > j)
                              {

                               completmax = "" + commax.getElementReference(j, i);
                               comnum = Complex.parseComplex(completmax);
                               real6 = comnum.getReal();
                               imag6 = comnum.getImag();

                               commax.setElement(i, j, real6, imag6);

                              }

                            }

                        }


                        for(int i=0;i<nmax;i++)
                        {
                            for(int j=0;j<nmax;j++)
                            {
                               completmaxybus = "" + commax.getElementReference(j, i);
                               comnumybus = Complex.parseComplex(completmaxybus);
                               real7 = comnumybus.getReal();
                               imag7 = comnumybus.getImag();

                               try
                               {
                               sentenciaybus = "INSERT INTO Ybus VALUES('"+1+"','" +(i+1)+"','"+(j+1)+"','" +real7 +"','"+ imag7 +"')";
			       stmtybus = conx7.createStatement();
			       stmtybus.executeUpdate(sentenciaybus);
                               }
                                catch(SQLException e1)
                                            {
                                                JFrame frame3 = new JFrame();
                                                   JOptionPane.showMessageDialog(frame3,"No se pudo establecer conexi�n con la BD" + e1.getMessage());
                                            }


                            }
                        }

                        model.addElement("La matriz Ybus con Control de Tension es:");
                        model.addElement(" ");


                        DecimalFormat formateador = new DecimalFormat("#,###.######;-#,###.######");


                        for(int i=0;i<nmax;i++)
                        {
                            fila = "";
                            for(int j=0;j<nmax;j++)
                            {
                               completauxformat1 = "" + commax.getElementReference(i, j);
                               completauxformat2 = Complex.parseComplex(completauxformat1);
                               realauxformat1 = completauxformat2.getReal();
                               imagauxformat1 = completauxformat2.getImag();
                               System.out.println(imagauxformat1);
                               realauxformat2 = formateador.format(realauxformat1);
                               imagauxformat2 = formateador.format(imagauxformat1);
                               System.out.println(imagauxformat2);
                               commaxformat.setElement(i, j, Double.parseDouble(realauxformat2), Double.parseDouble(imagauxformat2));

                               fila = (fila + "    " + "(" + commaxformat.getElementReference(i, j) + ")");
                            }
                             model.addElement(" " + fila);

                             try
                             {
                              conx4.close();
                             }
                             catch(SQLException e1)
                                            {
                                                JFrame frame3 = new JFrame();
                                                   JOptionPane.showMessageDialog(frame3,"No se pudo establecer conexi�n con la BD" + e1.getMessage());
                                            }

                        }
                        model.addElement(" ");

                    botonone.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        model.addElement(" ");
                        model.addElement("Gauss");
                        model.addElement(" ");

                        Epsilonstr = "0.1";
			Epsilonstr = "" + JOptionPane.showInputDialog("Ingrese El Epsilon Deseado");
                        Double Epsilon = Double.parseDouble(Epsilonstr);

                        Iterastr = "1";
			Iterastr = "" + JOptionPane.showInputDialog("Ingrese El Maximo de Iteraciones Deseadas");
                        Integer Itera = Integer.parseInt(Iterastr);




                        try
			{
				String sql5 = "SELECT MAX(Numbarra) FROM barras";
				stmt5 = conx5.createStatement();

                               	ResultSet rs5 = stmt5.executeQuery( sql5 );

                               		while (rs5.next())
					{
						n5 = rs5.getString("MAX(Numbarra)");
                                                /*JFrame frame5 = new JFrame();
                                                JOptionPane.showMessageDialog(frame5,"Maxino nodo fin:  " + n2);
                                        */}

                               	conx5.close();

			}
			catch(SQLException e2)
			{
				JFrame frame6 = new JFrame();
				JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
			}

                         Integer nn5 = Integer.parseInt(n5);
                        Complex[] vectorini = new Complex[nn5];

                        Complex[] vectorresul = new Complex[nn5];

                        Complex[] vectorinyec = new Complex[nn5];

                        Complex[] vectortipo = new Complex[nn5];

                        model.addElement("Vector Inicializacion");
                        /*model.addElement(nn5);*/
                        model.addElement(" ");


                         try
			{
				String sql6 = "SELECT Tipobarra, Tension, Pgen, Qgen, Pcar, Qcar FROM barras";
                                stmt5 = conx6.createStatement();
                                n7=0;
                               	ResultSet rs6 = stmt5.executeQuery( sql6 );

                               		while (rs6.next())
					{
						n6 = rs6.getString("Tipobarra");
                                                Integer nn6 = Integer.parseInt(n6);
                                                Double nn7 = Double.parseDouble(rs6.getString("Tension"));
                                                Double nn8 = Double.parseDouble(rs6.getString("Pgen"));
                                                Double nn9 = Double.parseDouble(rs6.getString("Qgen"));
                                                Double nn10 = Double.parseDouble(rs6.getString("Pcar"));
                                                Double nn11 = Double.parseDouble(rs6.getString("Qcar"));

                                                vectortipo[n7]= new Complex(nn6);


                                                if (nn6 == 1)
                                                {
                                                vectorini[n7] = new Complex(nn7, 0);

                                                vectorinyec[n7]= new Complex(0,0);

                                                model.addElement("V" + (n7 + 1) + ": " + vectorini[n7] + "    " + "P" + (n7 + 1) + " + " + "jQ" + (n7 + 1) + ": " + vectorinyec[n7]);




                                                }

                                                if (nn6 == 2)
                                                {
                                                vectorini[n7] = new Complex(nn7, 0);

                                                vectorinyec[n7] = new Complex((nn8 - nn10),(nn9 - nn11));

                                                model.addElement("V" + (n7 + 1) + ": " + vectorini[n7] + "    " + "P" + (n7 + 1) + " + " + "jQ" + (n7 + 1) + ": " + vectorinyec[n7]);


                                                }

                                                if (nn6 == 3)
                                                {
                                                vectorini[n7] = new Complex(1, 0);

                                                vectorinyec[n7] = new Complex((nn8 - nn10),(nn9 - nn11));

                                                model.addElement("V" + (n7 + 1) + ": " + vectorini[n7] + "    " + "P" + (n7 + 1) + " + " + "jQ" + (n7 + 1) + ": " + vectorinyec[n7]);
                                                }

                                                n7++;
                                                /*JFrame frame5 = new JFrame();
                                                JOptionPane.showMessageDialog(frame5,"Maxino nodo fin:  " + n2);
                                        */}

                             conx6.close();

			}
			catch(SQLException e2)
			{
				JFrame frame6 = new JFrame();
				JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
			}

                        model.addElement(" ");
                        model.addElement("Cantidad de Barras: " + vectortipo.length);


                        /*aqui inicia iteracion con while*/

                        int contador = 1;
                        error = 100;
                        while (contador <= Itera && error >= Epsilon)
                        {

                            model.addElement(" ");
                            model.addElement("Iteracion: " + contador);

                        for(int i=0;i<nn5;i++)
                         {
                            /*model.addElement(vectortipo[i]);*/

                            tipbar = vectortipo[i].getReal();

                            if (tipbar == 1)
                            {
                                /*model.addElement("Barra Slack");*/
                                vectorresul[i] = vectorini[i];
                            }

                            if (tipbar == 2)
                            {
                                /*model.addElement("Barra PV");*/



                                Complex P = new Complex(0,0);
                                Complex Q = new Complex(0,0);
                                Complex Auxx1 = new Complex(0,0);
                                Complex Auxx2 = new Complex(0,0);
                                Complex Auxx3 = new Complex(0,0);
                                Complex Auxx4 = new Complex(0,0);
                                Complex Auxx5 = new Complex(0,0);
                                Complex Auxx6 = new Complex(0,0);
                                Complex Auxx7 = new Complex(0,0);
                                Complex Auxx8 = new Complex(0,0);
                                Complex Auxx9 = new Complex(0,0);
                                Complex Auxx10 = new Complex(0,0);
                                Complex Auxx11 = new Complex(0,0);
                                Qi = 0;
                                ABS = 0;
                                ARG = 0;
                                Complex Vi = new Complex(0,0);
                                Complex Yijaux = new Complex(0,0);
                                Complex Yijaux2 = new Complex(0,0);
                                Complex Yijaux3 = new Complex(0,0);

                                for (int j=0;j<nn5;j++)
                                {

                                    try
                                    {
                                        String sql8 = "SELECT yreal, yimagi FROM Ybus WHERE i LIKE " + (i + 1) + " AND j LIKE " + (j + 1);
                                        stmt8 = conx8.createStatement();

                                        ResultSet rs8 = stmt8.executeQuery( sql8 );

                               		while (rs8.next())
					{
						 Double nn15 = Double.parseDouble(rs8.getString("yreal"));
                                                 Double nn16 = Double.parseDouble(rs8.getString("yimagi"));
                                                 Yijaux.setReal(nn15);
                                                 Yijaux.setImag(nn16);
                                                 Auxx1 = Yijaux.times(vectorini[j]);
                                                 Auxx2.plusEquals(Auxx1);
                                                 /* model.addElement("Vj " + vectorini[j]);
                                                 model.addElement("Yijaux " + Yijaux);
                                                 model.addElement("Auxx1 " + Auxx1);
                                                 model.addElement("Auxx2 " + Auxx2);
                                                 */

                                        }

                                    }
                                    catch(SQLException e2)
                                    {
                                        JFrame frame6 = new JFrame();
                                        JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                    }



                                }

                                    Auxx3 = vectorini[i];
                                    Auxx3.conjugate();
                                    Auxx4 = Auxx3.times(Auxx2);

                                    Qi = (-1)*Auxx4.getImag();

                                    /*model.addElement("Q" + (i + 1) + ": " + Qi);*/


                                 for (int j=0;j<nn5;j++)
                                {
                                    if (j != i)
                                    {
                                        try
                                        {
                                            String sql9 = "SELECT yreal, yimagi FROM Ybus WHERE i LIKE " + (i + 1) + " AND j LIKE " + (j + 1);
                                            stmt9 = conx9.createStatement();

                                            ResultSet rs9 = stmt9.executeQuery( sql9 );

                                            while (rs9.next())
                                            {
						 Double nn17 = Double.parseDouble(rs9.getString("yreal"));
                                                 Double nn18 = Double.parseDouble(rs9.getString("yimagi"));
                                                 Yijaux2.setReal(nn17);
                                                 Yijaux2.setImag(nn18);
                                                 Auxx5 = Yijaux2.times(vectorini[j]);
                                                 Auxx6.plusEquals(Auxx5);
                                                 /*model.addElement("Vj " + vectorini[j]);
                                                 model.addElement("Yijaux2 " + Yijaux2);
                                                 model.addElement("Auxx5 " + Auxx5);
                                                 model.addElement("Auxx6 " + Auxx6);
                                                 */

                                            }

                                        }
                                        catch(SQLException e2)
                                        {
                                            JFrame frame6 = new JFrame();
                                            JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                        }


                                    }
                                }

                                    try
                                        {
                                            String sql10 = "SELECT yreal, yimagi FROM Ybus WHERE i LIKE " + (i + 1) + " AND j LIKE " + (i + 1);
                                            stmt10 = conx10.createStatement();

                                            ResultSet rs10 = stmt10.executeQuery( sql10 );

                                            while (rs10.next())
                                            {
						 Double nn19 = Double.parseDouble(rs10.getString("yreal"));
                                                 Double nn20 = Double.parseDouble(rs10.getString("yimagi"));
                                                 Yijaux3.setReal(nn19);
                                                 Yijaux3.setImag(nn20);
                                                 /* model.addElement("Vj " + vectorini[j]);
                                                 model.addElement("Yijaux3 " + Yijaux3);
                                                 model.addElement("Auxx1 " + Auxx1);
                                                 model.addElement("Auxx2 " + Auxx2);
                                                 */

                                            }

                                        }
                                        catch(SQLException e2)
                                        {
                                            JFrame frame6 = new JFrame();
                                            JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                        }



                                    Auxx7 = Yijaux3.negate();
                                    Auxx8 = Auxx6.times(Auxx7.inverse());
                                    /*model.addElement("Auxx8: " + Auxx8);*/

                                    vectorinyec[i].setImag((-1)*Qi);
                                    /*model.addElement("P" + (i+1) + "+" + "Q" + (i+1) + ": " + vectorinyec[i]);*/

                                    Auxx9 = vectorini[i];
                                    Auxx9.conjugate();
                                    Auxx10 = Yijaux3.times(Auxx9);
                                    Auxx11 = vectorinyec[i].times(Auxx10.inverse());

                                    Vi = Auxx11.plus(Auxx8);

                                    /*model.addElement("V" + (i+1) + ": " + Vi);*/

                                    ABS = Vi.abs();
                                    ARG = 57.2957795131*Vi.arg();

                                    model.addElement("V" + (i+1) + ": " + ABS + " L " + ARG);

                                    vectorresul[i] = Vi;


                            }

                            if (tipbar == 3)
                            {
                                /*model.addElement("Barra PQ");*/

                                Complex P = new Complex(0,0);
                                Complex Q = new Complex(0,0);
                                Complex Auxx1 = new Complex(0,0);
                                Complex Auxx2 = new Complex(0,0);
                                Complex Auxx3 = new Complex(0,0);
                                Complex Auxx4 = new Complex(0,0);
                                Complex Auxx5 = new Complex(0,0);
                                Complex Auxx6 = new Complex(0,0);
                                Complex Auxx7 = new Complex(0,0);
                                Complex Auxx8 = new Complex(0,0);
                                Complex Auxx9 = new Complex(0,0);
                                Complex Auxx10 = new Complex(0,0);
                                Complex Auxx11 = new Complex(0,0);
                                Complex Auxx12 = new Complex(0,0);
                                Qi = 0;
                                ABS = 0;
                                ARG = 0;
                                Complex Vi = new Complex(0,0);
                                Complex Yijaux = new Complex(0,0);
                                Complex Yijaux2 = new Complex(0,0);
                                Complex Yijaux3 = new Complex(0,0);

                                for (int j=0;j<nn5;j++)
                                {
                                    if (j != i)
                                    {
                                        try
                                        {
                                            String sql11 = "SELECT yreal, yimagi FROM Ybus WHERE i LIKE " + (i + 1) + " AND j LIKE " + (j + 1);
                                            stmt11 = conx11.createStatement();

                                            ResultSet rs11 = stmt11.executeQuery( sql11 );

                                            while (rs11.next())
                                            {
						 Double nn17 = Double.parseDouble(rs11.getString("yreal"));
                                                 Double nn18 = Double.parseDouble(rs11.getString("yimagi"));
                                                 Yijaux2.setReal(nn17);
                                                 Yijaux2.setImag(nn18);
                                                 Auxx5 = Yijaux2.times(vectorini[j]);
                                                 Auxx6.plusEquals(Auxx5);
                                                 /*model.addElement("Vj " + vectorini[j]);
                                                 model.addElement("Yijaux2 " + Yijaux2);
                                                 model.addElement("Auxx5 " + Auxx5);
                                                 model.addElement("Auxx6 " + Auxx6);
                                                 */

                                            }

                                        }
                                        catch(SQLException e2)
                                        {
                                            JFrame frame6 = new JFrame();
                                            JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                        }


                                    }
                                }

                                    try
                                        {
                                            String sql12 = "SELECT yreal, yimagi FROM Ybus WHERE i LIKE " + (i + 1) + " AND j LIKE " + (i + 1);
                                            stmt12 = conx12.createStatement();

                                            ResultSet rs12 = stmt12.executeQuery( sql12 );

                                            while (rs12.next())
                                            {
						 Double nn19 = Double.parseDouble(rs12.getString("yreal"));
                                                 Double nn20 = Double.parseDouble(rs12.getString("yimagi"));
                                                 Yijaux3.setReal(nn19);
                                                 Yijaux3.setImag(nn20);
                                                 /* model.addElement("Vj " + vectorini[j]);
                                                 model.addElement("Yijaux3 " + Yijaux3);
                                                 model.addElement("Auxx1 " + Auxx1);
                                                 model.addElement("Auxx2 " + Auxx2);
                                                 */

                                            }

                                        }
                                        catch(SQLException e2)
                                        {
                                            JFrame frame6 = new JFrame();
                                            JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                        }



                                    Auxx7 = Yijaux3.negate();
                                    Auxx8 = Auxx6.times(Auxx7.inverse());
                                    /*model.addElement("Auxx8: " + Auxx8);*/


                                    /*model.addElement("P" + (i+1) + "+" + "Q" + (i+1) + ": " + vectorinyec[i]);*/

                                    Auxx9 = vectorini[i];
                                    Auxx9.conjugate();
                                    Auxx10 = Yijaux3.times(Auxx9);

                                    Paux = vectorinyec[i].getReal();
                                    Qaux = vectorinyec[i].getImag();
                                    Auxx12.setReal(Paux);
                                    Auxx12.setImag((-1)*Qaux);

                                    Auxx11 = Auxx12.times(Auxx10.inverse());

                                    Vi = Auxx11.plus(Auxx8);

                                    /*model.addElement("V" + (i+1) + ": " + Vi);*/

                                    ABS = Vi.abs();
                                    ARG = 57.2957795131*Vi.arg();
                                    vectorresul[i] = Vi;

                                    model.addElement("V" + (i+1) + ": " + ABS + " L " + ARG);


                            }


                         }

                            error = 0;
                            err3 = 0;
                            err4 = 0;
                            for (int x=0;x<nn5;x++)
                            {
                                err1 = Math.abs(vectorresul[x].abs() - vectorini[x].abs());
                                err3 = Math.max(err3, err1);
                            }

                            for (int x=0;x<nn5;x++)
                            {
                                err2 = Math.abs(vectorresul[x].arg() - vectorini[x].arg());
                                err4 = Math.max(err4,err2);
                            }

                            error = Math.max(err3,err4);

                            model.addElement("error: " + error);

                            for (int x=0;x<nn5;x++)
                        {
                            vectorini[x] = vectorresul[x];
                        }

                        contador++;

                        }

                        try
                                        {
                                            conx8.close();
                                            conx9.close();
                                            conx10.close();
                                            conx11.close();
                                            conx12.close();

                                        }
                                        catch(SQLException e2)
                                        {
                                            JFrame frame6 = new JFrame();
                                            JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                        }



                        model.addElement(" ");
                        model.addElement("Resultados de La Iteracion ");
                        model.addElement(" ");
                        model.addElement("Vector de Resultados ");
                        for (int x=0;x<nn5;x++)
                        {

                            ABS = vectorresul[x].abs();
                            ARG = 57.2957795131*vectorresul[x].arg();
                            model.addElement("V" + (x+1) + ": " + ABS + " L " + ARG);

                        }

                        botonone.setEnabled(false);
                         botontwo.setEnabled(false);
                         botonthree.setEnabled(false);
                         botonfour.setEnabled(false);


                    }
                    });

                    botontwo.addActionListener(new ActionListener() {
                     public void actionPerformed(ActionEvent e) {

                         model.addElement(" ");
                         model.addElement("Gauss-Seidel");

                        Epsilonstr = "0.1";
			Epsilonstr = "" + JOptionPane.showInputDialog("Ingrese El Epsilon Deseado");
                        Double Epsilon = Double.parseDouble(Epsilonstr);

                        Iterastr = "1";
			Iterastr = "" + JOptionPane.showInputDialog("Ingrese El Maximo de Iteraciones Deseadas");
                        Integer Itera = Integer.parseInt(Iterastr);




                        try
			{
				String sql5 = "SELECT MAX(Numbarra) FROM barras";
				stmt5 = conx5.createStatement();

                               	ResultSet rs5 = stmt5.executeQuery( sql5 );

                               		while (rs5.next())
					{
						n5 = rs5.getString("MAX(Numbarra)");
                                                /*JFrame frame5 = new JFrame();
                                                JOptionPane.showMessageDialog(frame5,"Maxino nodo fin:  " + n2);
                                        */}

                               	conx5.close();

			}
			catch(SQLException e2)
			{
				JFrame frame6 = new JFrame();
				JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
			}

                         Integer nn5 = Integer.parseInt(n5);
                        Complex[] vectorini = new Complex[nn5];

                        Complex[] vectorinierror = new Complex[nn5];

                        Complex[] vectorresul = new Complex[nn5];

                        Complex[] vectorinyec = new Complex[nn5];

                        Complex[] vectortipo = new Complex[nn5];

                        model.addElement("Vector Inicializacion");
                        /*model.addElement(nn5);*/
                        model.addElement(" ");


                         try
			{
				String sql6 = "SELECT Tipobarra, Tension, Pgen, Qgen, Pcar, Qcar FROM barras";
                                stmt5 = conx6.createStatement();
                                n7=0;
                               	ResultSet rs6 = stmt5.executeQuery( sql6 );

                               		while (rs6.next())
					{
						n6 = rs6.getString("Tipobarra");
                                                Integer nn6 = Integer.parseInt(n6);
                                                Double nn7 = Double.parseDouble(rs6.getString("Tension"));
                                                Double nn8 = Double.parseDouble(rs6.getString("Pgen"));
                                                Double nn9 = Double.parseDouble(rs6.getString("Qgen"));
                                                Double nn10 = Double.parseDouble(rs6.getString("Pcar"));
                                                Double nn11 = Double.parseDouble(rs6.getString("Qcar"));

                                                vectortipo[n7]= new Complex(nn6);


                                                if (nn6 == 1)
                                                {
                                                vectorini[n7] = new Complex(nn7, 0);

                                                vectorinyec[n7]= new Complex(0,0);

                                                model.addElement("V" + (n7 + 1) + ": " + vectorini[n7] + "    " + "P" + (n7 + 1) + " + " + "jQ" + (n7 + 1) + ": " + vectorinyec[n7]);




                                                }

                                                if (nn6 == 2)
                                                {
                                                vectorini[n7] = new Complex(nn7, 0);

                                                vectorinyec[n7] = new Complex((nn8 - nn10),(nn9 - nn11));

                                                model.addElement("V" + (n7 + 1) + ": " + vectorini[n7] + "    " + "P" + (n7 + 1) + " + " + "jQ" + (n7 + 1) + ": " + vectorinyec[n7]);


                                                }

                                                if (nn6 == 3)
                                                {
                                                vectorini[n7] = new Complex(1, 0);

                                                vectorinyec[n7] = new Complex((nn8 - nn10),(nn9 - nn11));

                                                model.addElement("V" + (n7 + 1) + ": " + vectorini[n7] + "    " + "P" + (n7 + 1) + " + " + "jQ" + (n7 + 1) + ": " + vectorinyec[n7]);
                                                }

                                                n7++;
                                                /*JFrame frame5 = new JFrame();
                                                JOptionPane.showMessageDialog(frame5,"Maxino nodo fin:  " + n2);
                                        */}

                             conx6.close();

			}
			catch(SQLException e2)
			{
				JFrame frame6 = new JFrame();
				JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
			}

                        model.addElement(" ");
                        model.addElement("Cantidad de Barras: " + vectortipo.length);


                         for (int x=0;x<nn5;x++)
                        {
                            vectorinierror[x] = vectorini[x];
                        }

                        /*aqui inicia iteracion con while*/

                        int contador = 1;
                        error = 100;
                        while (contador <= Itera && error >= Epsilon)
                        {

                            model.addElement(" ");
                            model.addElement("Iteracion: " + contador);

                        for(int i=0;i<nn5;i++)
                         {
                            /*model.addElement(vectortipo[i]);*/

                            tipbar = vectortipo[i].getReal();

                            if (tipbar == 1)
                            {
                                /*model.addElement("Barra Slack");*/
                                vectorresul[i] = vectorini[i];
                            }

                            if (tipbar == 2)
                            {
                                /*model.addElement("Barra PV");*/



                                Complex P = new Complex(0,0);
                                Complex Q = new Complex(0,0);
                                Complex Auxx1 = new Complex(0,0);
                                Complex Auxx2 = new Complex(0,0);
                                Complex Auxx3 = new Complex(0,0);
                                Complex Auxx4 = new Complex(0,0);
                                Complex Auxx5 = new Complex(0,0);
                                Complex Auxx6 = new Complex(0,0);
                                Complex Auxx7 = new Complex(0,0);
                                Complex Auxx8 = new Complex(0,0);
                                Complex Auxx9 = new Complex(0,0);
                                Complex Auxx10 = new Complex(0,0);
                                Complex Auxx11 = new Complex(0,0);
                                Qi = 0;
                                ABS = 0;
                                ARG = 0;
                                Complex Vi = new Complex(0,0);
                                Complex Yijaux = new Complex(0,0);
                                Complex Yijaux2 = new Complex(0,0);
                                Complex Yijaux3 = new Complex(0,0);

                                for (int j=0;j<nn5;j++)
                                {

                                    try
                                    {
                                        String sql8 = "SELECT yreal, yimagi FROM Ybus WHERE i LIKE " + (i + 1) + " AND j LIKE " + (j + 1);
                                        stmt8 = conx8.createStatement();

                                        ResultSet rs8 = stmt8.executeQuery( sql8 );

                               		while (rs8.next())
					{
						 Double nn15 = Double.parseDouble(rs8.getString("yreal"));
                                                 Double nn16 = Double.parseDouble(rs8.getString("yimagi"));
                                                 Yijaux.setReal(nn15);
                                                 Yijaux.setImag(nn16);
                                                 Auxx1 = Yijaux.times(vectorini[j]);
                                                 Auxx2.plusEquals(Auxx1);
                                                 /* model.addElement("Vj " + vectorini[j]);
                                                 model.addElement("Yijaux " + Yijaux);
                                                 model.addElement("Auxx1 " + Auxx1);
                                                 model.addElement("Auxx2 " + Auxx2);
                                                 */

                                        }

                                    }
                                    catch(SQLException e2)
                                    {
                                        JFrame frame6 = new JFrame();
                                        JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                    }



                                }

                                    Auxx3 = vectorini[i];
                                    Auxx3.conjugate();
                                    Auxx4 = Auxx3.times(Auxx2);

                                    Qi = (-1)*Auxx4.getImag();

                                    /*model.addElement("Q" + (i + 1) + ": " + Qi);*/


                                 for (int j=0;j<nn5;j++)
                                {
                                    if (j != i)
                                    {
                                        try
                                        {
                                            String sql9 = "SELECT yreal, yimagi FROM Ybus WHERE i LIKE " + (i + 1) + " AND j LIKE " + (j + 1);
                                            stmt9 = conx9.createStatement();

                                            ResultSet rs9 = stmt9.executeQuery( sql9 );

                                            while (rs9.next())
                                            {
						 Double nn17 = Double.parseDouble(rs9.getString("yreal"));
                                                 Double nn18 = Double.parseDouble(rs9.getString("yimagi"));
                                                 Yijaux2.setReal(nn17);
                                                 Yijaux2.setImag(nn18);
                                                 Auxx5 = Yijaux2.times(vectorini[j]);
                                                 Auxx6.plusEquals(Auxx5);
                                                 /*model.addElement("Vj " + vectorini[j]);
                                                 model.addElement("Yijaux2 " + Yijaux2);
                                                 model.addElement("Auxx5 " + Auxx5);
                                                 model.addElement("Auxx6 " + Auxx6);
                                                 */

                                            }

                                        }
                                        catch(SQLException e2)
                                        {
                                            JFrame frame6 = new JFrame();
                                            JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                        }


                                    }
                                }

                                    try
                                        {
                                            String sql10 = "SELECT yreal, yimagi FROM Ybus WHERE i LIKE " + (i + 1) + " AND j LIKE " + (i + 1);
                                            stmt10 = conx10.createStatement();

                                            ResultSet rs10 = stmt10.executeQuery( sql10 );

                                            while (rs10.next())
                                            {
						 Double nn19 = Double.parseDouble(rs10.getString("yreal"));
                                                 Double nn20 = Double.parseDouble(rs10.getString("yimagi"));
                                                 Yijaux3.setReal(nn19);
                                                 Yijaux3.setImag(nn20);
                                                 /* model.addElement("Vj " + vectorini[j]);
                                                 model.addElement("Yijaux3 " + Yijaux3);
                                                 model.addElement("Auxx1 " + Auxx1);
                                                 model.addElement("Auxx2 " + Auxx2);
                                                 */

                                            }

                                        }
                                        catch(SQLException e2)
                                        {
                                            JFrame frame6 = new JFrame();
                                            JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                        }



                                    Auxx7 = Yijaux3.negate();
                                    Auxx8 = Auxx6.times(Auxx7.inverse());
                                    /*model.addElement("Auxx8: " + Auxx8);*/

                                    vectorinyec[i].setImag((-1)*Qi);
                                    /*model.addElement("P" + (i+1) + "+" + "Q" + (i+1) + ": " + vectorinyec[i]);*/

                                    Auxx9 = vectorini[i];
                                    Auxx9.conjugate();
                                    Auxx10 = Yijaux3.times(Auxx9);
                                    Auxx11 = vectorinyec[i].times(Auxx10.inverse());

                                    Vi = Auxx11.plus(Auxx8);

                                    /*model.addElement("V" + (i+1) + ": " + Vi);*/

                                    ABS = Vi.abs();
                                    ARG = 57.2957795131*Vi.arg();

                                    model.addElement("V" + (i+1) + ": " + ABS + " L " + ARG);

                                    vectorresul[i] = Vi;
                                    vectorini[i] = vectorresul[i];


                            }

                            if (tipbar == 3)
                            {
                                /*model.addElement("Barra PQ");*/

                                Complex P = new Complex(0,0);
                                Complex Q = new Complex(0,0);
                                Complex Auxx1 = new Complex(0,0);
                                Complex Auxx2 = new Complex(0,0);
                                Complex Auxx3 = new Complex(0,0);
                                Complex Auxx4 = new Complex(0,0);
                                Complex Auxx5 = new Complex(0,0);
                                Complex Auxx6 = new Complex(0,0);
                                Complex Auxx7 = new Complex(0,0);
                                Complex Auxx8 = new Complex(0,0);
                                Complex Auxx9 = new Complex(0,0);
                                Complex Auxx10 = new Complex(0,0);
                                Complex Auxx11 = new Complex(0,0);
                                Complex Auxx12 = new Complex(0,0);
                                Qi = 0;
                                ABS = 0;
                                ARG = 0;
                                Complex Vi = new Complex(0,0);
                                Complex Yijaux = new Complex(0,0);
                                Complex Yijaux2 = new Complex(0,0);
                                Complex Yijaux3 = new Complex(0,0);

                                for (int j=0;j<nn5;j++)
                                {
                                    if (j != i)
                                    {
                                        try
                                        {
                                            String sql11 = "SELECT yreal, yimagi FROM Ybus WHERE i LIKE " + (i + 1) + " AND j LIKE " + (j + 1);
                                            stmt11 = conx11.createStatement();

                                            ResultSet rs11 = stmt11.executeQuery( sql11 );

                                            while (rs11.next())
                                            {
						 Double nn17 = Double.parseDouble(rs11.getString("yreal"));
                                                 Double nn18 = Double.parseDouble(rs11.getString("yimagi"));
                                                 Yijaux2.setReal(nn17);
                                                 Yijaux2.setImag(nn18);
                                                 Auxx5 = Yijaux2.times(vectorini[j]);
                                                 Auxx6.plusEquals(Auxx5);
                                                 /*model.addElement("Vj " + vectorini[j]);
                                                 model.addElement("Yijaux2 " + Yijaux2);
                                                 model.addElement("Auxx5 " + Auxx5);
                                                 model.addElement("Auxx6 " + Auxx6);
                                                 */

                                            }

                                        }
                                        catch(SQLException e2)
                                        {
                                            JFrame frame6 = new JFrame();
                                            JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                        }


                                    }
                                }

                                    try
                                        {
                                            String sql12 = "SELECT yreal, yimagi FROM Ybus WHERE i LIKE " + (i + 1) + " AND j LIKE " + (i + 1);
                                            stmt12 = conx12.createStatement();

                                            ResultSet rs12 = stmt12.executeQuery( sql12 );

                                            while (rs12.next())
                                            {
						 Double nn19 = Double.parseDouble(rs12.getString("yreal"));
                                                 Double nn20 = Double.parseDouble(rs12.getString("yimagi"));
                                                 Yijaux3.setReal(nn19);
                                                 Yijaux3.setImag(nn20);
                                                 /* model.addElement("Vj " + vectorini[j]);
                                                 model.addElement("Yijaux3 " + Yijaux3);
                                                 model.addElement("Auxx1 " + Auxx1);
                                                 model.addElement("Auxx2 " + Auxx2);
                                                 */

                                            }

                                        }
                                        catch(SQLException e2)
                                        {
                                            JFrame frame6 = new JFrame();
                                            JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                        }



                                    Auxx7 = Yijaux3.negate();
                                    Auxx8 = Auxx6.times(Auxx7.inverse());
                                    /*model.addElement("Auxx8: " + Auxx8);*/


                                    /*model.addElement("P" + (i+1) + "+" + "Q" + (i+1) + ": " + vectorinyec[i]);*/

                                    Auxx9 = vectorini[i];
                                    Auxx9.conjugate();
                                    Auxx10 = Yijaux3.times(Auxx9);

                                    Paux = vectorinyec[i].getReal();
                                    Qaux = vectorinyec[i].getImag();
                                    Auxx12.setReal(Paux);
                                    Auxx12.setImag((-1)*Qaux);

                                    Auxx11 = Auxx12.times(Auxx10.inverse());

                                    Vi = Auxx11.plus(Auxx8);

                                    /*model.addElement("V" + (i+1) + ": " + Vi);*/

                                    ABS = Vi.abs();
                                    ARG = 57.2957795131*Vi.arg();
                                    vectorresul[i] = Vi;
                                    vectorini[i] = vectorresul[i];

                                    model.addElement("V" + (i+1) + ": " + ABS + " L " + ARG);


                            }


                         }

                            error = 0;
                            err3 = 0;
                            err4 = 0;
                            for (int x=0;x<nn5;x++)
                            {
                                err1 = Math.abs(vectorresul[x].abs() - vectorinierror[x].abs());
                                err3 = Math.max(err3, err1);
                            }

                            for (int x=0;x<nn5;x++)
                            {
                                err2 = Math.abs(vectorresul[x].arg() - vectorinierror[x].arg());
                                err4 = Math.max(err4,err2);
                            }

                            error = Math.max(err3,err4);

                            model.addElement("error: " + error);

                            for (int x=0;x<nn5;x++)
                        {
                            vectorini[x] = vectorresul[x];
                        }

                            for (int x=0;x<nn5;x++)
                        {
                            vectorinierror[x] = vectorini[x];
                        }

                        contador++;

                        }

                        try
                                        {
                                            conx8.close();
                                            conx9.close();
                                            conx10.close();
                                            conx11.close();
                                            conx12.close();

                                        }
                                        catch(SQLException e2)
                                        {
                                            JFrame frame6 = new JFrame();
                                            JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                        }

                        model.addElement(" ");
                        model.addElement("Resultados de La Iteracion ");
                        model.addElement(" ");
                        model.addElement("Vector de Resultados ");
                        for (int x=0;x<nn5;x++)
                        {

                            ABS = vectorresul[x].abs();
                            ARG = 57.2957795131*vectorresul[x].arg();
                            model.addElement("V" + (x+1) + ": " + ABS + " L " + ARG);

                        }

                        botonone.setEnabled(false);
                         botontwo.setEnabled(false);
                         botonthree.setEnabled(false);
                         botonfour.setEnabled(false);



                    }
                     });

                     botonthree.addActionListener(new ActionListener() {
                     public void actionPerformed(ActionEvent e) {

                         model.addElement(" ");
                         model.addElement("Newton Rahpson");

                         for(int x=0;x<5;x++)
                        {
                           model.addElement(x);
                        }

                         botonone.setEnabled(false);
                         botontwo.setEnabled(false);
                         botonthree.setEnabled(false);
                         botonfour.setEnabled(false);


                     }
                     });

                     botonfour.addActionListener(new ActionListener() {
                     public void actionPerformed(ActionEvent e) {

                         model.addElement(" ");
                         model.addElement("Desacoplado Rapido");




                        Epsilonstr = "0.1";
			Epsilonstr = "" + JOptionPane.showInputDialog("Ingrese El Epsilon Deseado");
                        Double Epsilon = Double.parseDouble(Epsilonstr);

                        Iterastr = "1";
			Iterastr = "" + JOptionPane.showInputDialog("Ingrese El Maximo de Iteraciones Deseadas");
                        Integer Itera = Integer.parseInt(Iterastr);

                        try
			{
				String sql31 = "INSERT INTO Bi SELECT ID_ybus, i, j, yimagi FROM Ybus";
				stmt31 = conx21.createStatement();

                               	stmt31.execute( sql31 );


                                String sql32 = "INSERT INTO Bii SELECT ID_ybus, i, j, yimagi FROM Ybus";
				stmt32 = conx21.createStatement();

                               	stmt32.execute( sql32 );

                               	conx21.close();

			}
			catch(SQLException e1)
			{
				JFrame frame3 = new JFrame();
				JOptionPane.showMessageDialog(frame3,"No se pudo establecer conexi�n con la BD" + e1.getMessage());
			}

                        try
                                        {
                                            String sql33 = "SELECT Numbarra FROM barras WHERE Tipobarra = '1'";
                                            stmt33 = conx33.createStatement();

                                            ResultSet rs33 = stmt33.executeQuery( sql33 );

                                            while (rs33.next())
                                            {
						Integer nn30 = Integer.parseInt(rs33.getString("Numbarra"));

                                                String sql34 = "DELETE FROM Bi WHERE i = '" + nn30 + "' OR j ='" + nn30 + "'";
                                                stmt34 = conx34.createStatement();
                                                stmt34.execute( sql34 );

                                                String sql35 = "DELETE FROM Bii WHERE i = '" + nn30 + "' OR j ='" + nn30 + "'";
                                                stmt35 = conx35.createStatement();
                                                stmt35.execute( sql35 );

                                            }

                                            conx33.close();
                                            conx34.close();
                                            conx35.close();

                                        }
                                        catch(SQLException e2)
                                        {
                                            JFrame frame6 = new JFrame();
                                            JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                        }


                                        try
                                        {
                                            String sql36 = "SELECT Numbarra FROM barras WHERE Tipobarra = '2'";
                                            stmt36 = conx36.createStatement();

                                            ResultSet rs36 = stmt36.executeQuery( sql36 );

                                            while (rs36.next())
                                            {
						Integer nn31 = Integer.parseInt(rs36.getString("Numbarra"));

                                                String sql37 = "DELETE FROM Bii WHERE i = '" + nn31 + "' OR j ='" + nn31 + "'";
                                                stmt37 = conx37.createStatement();
                                                stmt37.execute( sql37 );

                                            }

                                            conx36.close();
                                            conx37.close();


                                        }
                                        catch(SQLException e2)
                                        {
                                            JFrame frame6 = new JFrame();
                                            JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                        }


                        /*
                         * Determinacion de las filas para el calculo de las P y las Q
                         **/


                                        try
                                        {
                                            String sql38 = "SELECT count(DISTINCT i) FROM Bi";
                                            stmt38 = conx38.createStatement();

                                            ResultSet rs38 = stmt38.executeQuery( sql38 );

                                            while (rs38.next())
                                            {
						Integer nn38 = rs38.getInt(1);
                                                nP = nn38;

                                            }

                                           /* model.addElement("cantidad de P: " + nP);
**/
                                            conx38.close();

                                        }
                                        catch(SQLException e2)
                                        {
                                            JFrame frame6 = new JFrame();
                                            JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                        }

                                            int VectorP[] = new int[nP];
                                            for (int x=0;x<VectorP.length;x++)
                                            {
                                                VectorP[x] = 0;

                                            }


                         try
                                        {
                                            String sql39 = "SELECT DISTINCT i FROM Bi";
                                            stmt39 = conx39.createStatement();

                                            ResultSet rs39 = stmt39.executeQuery( sql39 );

                                            int y = 0;
                                            while (rs39.next())
                                            {
						Integer nn39 = Integer.parseInt(rs39.getString("i"));
                                                VectorP[y] = nn39;
                                                y++;

                                            }

                                            conx39.close();



                                        }
                                        catch(SQLException e2)
                                        {
                                            JFrame frame6 = new JFrame();
                                            JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                        }
/*
                            model.addElement(" ");
                            model.addElement("Vector P");
                            model.addElement(" ");

                            for (int x=0;x<VectorP.length;x++)
                                            {
                                                model.addElement("P" + (x + 1) + ": " + VectorP[x]);
                                            }

                            model.addElement(" ");
**/
                            try
                                        {
                                            String sql40 = "SELECT count(DISTINCT i) FROM Bii";
                                            stmt40 = conx40.createStatement();

                                            ResultSet rs40 = stmt40.executeQuery( sql40 );

                                            while (rs40.next())
                                            {
						Integer nn40 = rs40.getInt(1);
                                                nQ = nn40;

                                            }

  /*                                          model.addElement("cantidad de Q: " + nQ);
**/
                                            conx40.close();

                                        }
                                        catch(SQLException e2)
                                        {
                                            JFrame frame6 = new JFrame();
                                            JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                        }

                                            int VectorQ[] = new int[nQ];
                                            for (int x=0;x<VectorQ.length;x++)
                                            {
                                                VectorQ[x] = 0;

                                            }


                         try
                                        {
                                            String sql41 = "SELECT DISTINCT i FROM Bii";
                                            stmt41 = conx41.createStatement();

                                            ResultSet rs41 = stmt41.executeQuery( sql41 );

                                            int y = 0;
                                            while (rs41.next())
                                            {
						Integer nn41 = Integer.parseInt(rs41.getString("i"));
                                                VectorQ[y] = nn41;
                                                y++;

                                            }

                                            conx41.close();



                                        }
                                        catch(SQLException e2)
                                        {
                                            JFrame frame6 = new JFrame();
                                            JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                        }

   /*                         model.addElement(" ");
                            model.addElement("Vector Q");
                            model.addElement(" ");

                            for (int x=0;x<VectorQ.length;x++)
                                            {
                                                model.addElement("Q" + (x + 1) + ": " + VectorQ[x]);
                                            }
**/

                         model.addElement(" ");
                         model.addElement("Matriz B'");

                         int xii = 0;
                         int yii = 0;
                         int nii = 0;
                         int mii = 0;

                         Matrix Bi = new Matrix(nP,nP);

                         for(int i=0;i<nP;i++)
                        {
                            fila = "";
                            mii = 0;
                            xii = VectorP[nii];

                            for(int j=0;j<nP;j++)
                            {
                                yii = VectorP[mii];
                                  try
                                        {
                                            String sql42 = "SELECT Biimagi FROM Bi WHERE i = " + xii + " AND j = " + yii;
                                            stmt42 = conx42.createStatement();

                                            ResultSet rs42 = stmt42.executeQuery( sql42 );

                                            while (rs42.next())
                                            {
						Double nn42 = Double.parseDouble(rs42.getString("Biimagi"));
                                                nn42 = nn42 * (-1);
                                                Bi.setElement(i, j, nn42);

                                            }

                                        }
                                        catch(SQLException e2)
                                        {
                                            JFrame frame6 = new JFrame();
                                            JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                        }

                                  fila = (fila + "    " + "(" + Bi.getElement(i, j) + ")");
                                  mii++;
                            }
                            nii++;
                            model.addElement(" " + fila);
                        }

                           try
                             {
                              conx42.close();
                             }
                             catch(SQLException e1)
                                            {
                                                JFrame frame3 = new JFrame();
                                                   JOptionPane.showMessageDialog(frame3,"No se pudo establecer conexi�n con la BD" + e1.getMessage());
                                            }


                         model.addElement(" ");
                         model.addElement("Matriz B''");

                         Matrix Bii = new Matrix(nQ,nQ);

                         nii = 0;
                        for(int i=0;i<nQ;i++)
                        {
                            mii = 0;
                            xii = VectorQ[nii];

                            fila = "";

                            for(int j=0;j<nQ;j++)
                            {
                                yii = VectorQ[mii];

                                  try
                                        {
                                            String sql43 = "SELECT Biiimagi FROM Bii WHERE i = " + xii + " AND j = " + yii;
                                            stmt43 = conx43.createStatement();

                                            ResultSet rs43 = stmt43.executeQuery( sql43 );

                                            while (rs43.next())
                                            {
						Double nn43 = Double.parseDouble(rs43.getString("Biiimagi"));
                                                nn43 = nn43 * (-1);
                                                Bii.setElement(i, j, nn43);

                                            }

                                        }
                                        catch(SQLException e2)
                                        {
                                            JFrame frame6 = new JFrame();
                                            JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                        }

                                  fila = (fila + "    " + "(" + Bii.getElement(i, j) + ")");
                                  mii++;
                            }

                            nii++;
                            model.addElement(" " + fila);
                        }

                           try
                             {
                              conx43.close();
                             }
                             catch(SQLException e1)
                                            {
                                                JFrame frame3 = new JFrame();
                                                   JOptionPane.showMessageDialog(frame3,"No se pudo establecer conexi�n con la BD" + e1.getMessage());
                                            }

                         /*Calculo de los P y Q
                          *
                          * */
                         int numnodos = 0;

                                        try
                                        {
                                            String sql44 = "SELECT count(Numbarra) FROM barras";
                                            stmt44 = conx44.createStatement();

                                            ResultSet rs44 = stmt44.executeQuery( sql44 );

                                            while (rs44.next())
                                            {
						Integer nn44 = rs44.getInt(1);
                                                numnodos = nn44;

                                            }
   /*                                         model.addElement("");
                                            model.addElement("cantidad de nodos: " + numnodos);
**/
                                            conx44.close();

                                        }
                                        catch(SQLException e2)
                                        {
                                            JFrame frame6 = new JFrame();
                                            JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                        }

                         double VectorPcal[] = new double[nP];
                         double VectorQcal[] = new double[nQ];
                         double VectorV[] = new double[numnodos];
                         double VectorAng[] = new double[numnodos];
                         int d = 0;
                                       try
                                        {
                                            String sql45 = "SELECT Tension FROM barras";
                                            stmt45 = conx45.createStatement();

                                            ResultSet rs45 = stmt45.executeQuery( sql45 );

                                            while (rs45.next())
                                            {
						Double nn45 = Double.parseDouble(rs45.getString("Tension"));
                                                VectorV[d] = nn45;
                                                d++;
                                            }

                                        }
                                        catch(SQLException e2)
                                        {
                                            JFrame frame6 = new JFrame();
                                            JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                        }

                                        d = 0;
                                       try
                                        {
                                            String sql46 = "SELECT Angle FROM barras";
                                            stmt46 = conx46.createStatement();

                                            ResultSet rs46 = stmt46.executeQuery( sql46 );

                                            while (rs46.next())
                                            {
						Double nn46 = Double.parseDouble(rs46.getString("Angle"));
                                                VectorAng[d] = nn46;
                                                d++;
                                            }

                                        }
                                        catch(SQLException e2)
                                        {
                                            JFrame frame6 = new JFrame();
                                            JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                        }
/*
                            for(int a=0;a<numnodos;a++)
                            {
                                model.addElement("");
                                model.addElement("V" + (a+1) + ": " + VectorV[a]);
                                model.addElement("ang" + (a+1) + ": " + VectorAng[a]);

                            }
**/


                         Complex YijauxP = new Complex(0,0);
                         double auxp01 = 0;

                         for(int a = 0; a < VectorP.length; a++)
                         {
                              xii = VectorP[a];
                              auxp01 = 0;

                             for(int b=0;b<numnodos;b++)
                             {

                                try
                                        {
                                            String sql47 = "SELECT yreal, yimagi FROM Ybus WHERE i = '" + xii + "' AND j = '" + (b+1) + "'";
                                            stmt47 = conx47.createStatement();

                                            ResultSet rs47 = stmt47.executeQuery( sql47 );

                                            while (rs47.next())
                                            {
						Double nn47 = Double.parseDouble(rs47.getString("yreal"));
                                                Double nn48 = Double.parseDouble(rs47.getString("yimagi"));
                                                YijauxP.setReal(nn47);
                                                YijauxP.setImag(nn48);

                                            }

                                        }
                                        catch(SQLException e2)
                                        {
                                            JFrame frame6 = new JFrame();
                                            JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                        }


                                double Yang = YijauxP.arg();
                                /*model.addElement("ang: " + 57.2957795131*Yang);**/

                                auxp01 = VectorV[xii-1] * VectorV[b] * YijauxP.abs() * Math.cos(VectorAng[xii-1] - VectorAng[b] - Yang);
                                /*model.addElement("aux: " + auxp01);**/
                                VectorPcal[a] = VectorPcal[a] + auxp01;

                             }


                         }



                         model.addElement("");
                         for(int a=0;a<VectorPcal.length;a++)
                            {
                                model.addElement("Pcal" + VectorP[a] + ": " + VectorPcal[a]);

                            }

                            /* Calculos de las Qcalculadas **/

                         Complex YijauxQ = new Complex(0,0);
                         double auxp02 = 0;

                         for(int a = 0; a < VectorQ.length; a++)
                         {
                              xii = VectorQ[a];
                              auxp02 = 0;

                             for(int b=0;b<numnodos;b++)
                             {

                                try
                                        {
                                            String sql49 = "SELECT yreal, yimagi FROM Ybus WHERE i = '" + xii + "' AND j = '" + (b+1) + "'";
                                            stmt49 = conx49.createStatement();

                                            ResultSet rs49 = stmt49.executeQuery( sql49 );

                                            while (rs49.next())
                                            {
						Double nn49 = Double.parseDouble(rs49.getString("yreal"));
                                                Double nn50 = Double.parseDouble(rs49.getString("yimagi"));
                                                YijauxQ.setReal(nn49);
                                                YijauxQ.setImag(nn50);

                                            }

                                        }
                                        catch(SQLException e2)
                                        {
                                            JFrame frame6 = new JFrame();
                                            JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                        }


                                auxp02 = VectorV[xii-1] * VectorV[b] * YijauxQ.abs() * Math.sin(VectorAng[xii-1] - VectorAng[b] - YijauxQ.arg());

                                VectorQcal[a] = VectorQcal[a] + auxp02;

                             }


                         }


                         model.addElement("");
                         for(int a=0;a<(VectorQcal.length);a++)
                            {
                                model.addElement("Qcal" + VectorQ[a] + ": " + VectorQcal[a]);

                            }


                         double VectorPesp[] = new double[nP];
                         double VectorQesp[] = new double[nQ];
                         double VectorPiny[] = new double[numnodos];
                         double VectorQiny[] = new double[numnodos];
                         double DeltaP[] = new double[nP];
                         double DeltaQ[] = new double[nQ];
                         double DeltaPdivV[] = new double[nP];
                         double DeltaQdivV[] = new double[nQ];
                         double DeltaAng[] = new double[nP];
                         double DeltaVol[] = new double[nQ];
                         double SolucionAng[] = new double[nP];
                         double SolucionVol[] = new double[nQ];


try
                                        {
                                            String sql51 = "SELECT Pgen, Qgen, Pcar, Qcar FROM barras";
                                            stmt51 = conx51.createStatement();

                                            ResultSet rs51 = stmt51.executeQuery( sql51 );

                                            d=0;
                                            while (rs51.next())
                                            {
						Double nn51 = Double.parseDouble(rs51.getString("Pgen"));
                                                Double nn52 = Double.parseDouble(rs51.getString("Qgen"));
                                                Double nn53 = Double.parseDouble(rs51.getString("Pcar"));
                                                Double nn54 = Double.parseDouble(rs51.getString("Qcar"));
                                                VectorPiny[d] = nn51 - nn53;
                                                VectorQiny[d] = nn52 - nn54;
                                                /*model.addElement("Piny: "+ VectorPiny[d] + " Qiny: " + VectorQiny[d]);**/
                                                d++;

                                            }

                                            conx51.close();
                                        }
                                        catch(SQLException e2)
                                        {
                                            JFrame frame6 = new JFrame();
                                            JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                        }

                             for(int a=0; a < VectorPesp.length;a++)
                            {

                                VectorPesp[a] = VectorPiny[a+1];
                                /*model.addElement("Pesp" + (a+1) + ": " + VectorPesp[a]);
                                 **/
                            }

                         for(int a=0; a < VectorQesp.length;a++)
                            {

                                VectorQesp[a] = VectorQiny[VectorQ[a]-1];
                                /*model.addElement("Qesp" + (a+1) + ": " + VectorQesp[a]);
**/
                            }

                         for(int a=0; a < VectorPesp.length;a++)
                            {
                                DeltaP[a] = VectorPesp[a] - VectorPcal[a];
   /*                             model.addElement("DeltaP" + (a+1) + ":" + DeltaP[a]);
**/
                            }

                         for(int a=0; a < VectorQesp.length;a++)
                            {
                                DeltaQ[a] = VectorQesp[a] - VectorQcal[a];
  /*                              model.addElement("DeltaQ" + (a+1) + ": " + DeltaQ[a]);
**/
                            }

                         for(int a=0; a < DeltaP.length;a++)
                            {
                                DeltaPdivV[a] = DeltaP[a] / VectorV[a+1];
   /*                             model.addElement("DeltaP" + (a+1) + "/V" + (a+1) + ": " + DeltaPdivV[a]);
**/
                            }

                        for(int a=0; a < DeltaQ.length;a++)
                            {
                                DeltaQdivV[a] = DeltaQ[a] / VectorV[(VectorQ[a]-1)];
   /*                             model.addElement("DeltaQ" + (a+1) + "/V" + (a+1) + ": " + DeltaQdivV[a]);
**/
                            }

                         /* Resolucion del sistema de ecuaciones matricial **/

                         model.addElement(" ");
                         model.addElement("Resolucion del Modelo Activo ");
                         model.addElement("Mismatch de Fase. Iteracion: 1 ");
                         model.addElement(" ");

                         DeltaAng = Bi.solveLinearSet(DeltaPdivV);

                         for(int a=0; a < DeltaAng.length;a++)
                            {
                                model.addElement("Deltad" + VectorP[a] + ": " + DeltaAng[a]);

                            }

                         model.addElement(" ");
                         model.addElement("Resolucion del Modelo Reactivo ");
                         model.addElement("Mismatch de Tension. Iteracion: 1 ");
                         model.addElement(" ");

                         DeltaVol = Bii.solveLinearSet(DeltaQdivV);

                         for(int a=0; a < DeltaVol.length;a++)
                            {
                                model.addElement("DeltaV" + VectorQ[a] + ": " + DeltaVol[a]);

                            }

                         model.addElement(" ");
                         model.addElement("Solucion del Sistema. Desacoplado. Iteracion: 1 ");
                         model.addElement(" ");

                        for(int a=0; a < SolucionAng.length;a++)
                            {
                                SolucionAng[a]= VectorAng[VectorP[a]-1] + DeltaAng[a];
                                model.addElement("Fase" + VectorP[a] + ": " + 57.2957795131*SolucionAng[a]);

                            }

                         for(int a=0; a < SolucionVol.length;a++)
                            {
                                SolucionVol[a]= VectorV[VectorQ[a]-1] + DeltaVol[a];
                                model.addElement("Tension" + VectorQ[a] + ": " + SolucionVol[a]);

                            }


                         /* Inicion de la iteracion**/
                        int contador = 2;
                        error = 100;
                        while (contador <= Itera && error >= Epsilon)
                        {

                            model.addElement(" ");
                            model.addElement("Iteracion Desacoplado: " + contador);


                            for(int a=0; a < SolucionAng.length;a++)
                            {
                                VectorAng[VectorP[a]-1] = SolucionAng[a];
                                /*model.addElement("Nueva Fase" + (a+1) + ": " + 57.2957795131*VectorAng[VectorP[a]-1]);
**/
                            }

                            for(int a=0; a < SolucionVol.length;a++)
                            {
                                VectorV[VectorQ[a]-1] = SolucionVol[a];
   /*                             model.addElement("Nueva Tension" + (a+1) + ": " + VectorV[VectorQ[a]-1]);
**/
                            }



                            for(int a=0; a < VectorPcal.length;a++)
                            {
                                VectorPcal[a] = 0;
                            }

                            for(int a=0; a < VectorQcal.length;a++)
                            {
                                VectorQcal[a] = 0;
                            }

                            for(int a=0; a < DeltaP.length;a++)
                            {
                                DeltaP[a] = 0;
                            }

                            for(int a=0; a < DeltaQ.length;a++)
                            {
                                DeltaQ[a] = 0;
                            }

                            for(int a=0; a < DeltaPdivV.length;a++)
                            {
                                DeltaPdivV[a] = 0;
                            }

                            for(int a=0; a < DeltaQdivV.length;a++)
                            {
                                DeltaQdivV[a] = 0;
                            }

                            for(int a=0; a < DeltaAng.length;a++)
                            {
                                DeltaAng[a] = 0;
                            }

                            for(int a=0; a < DeltaVol.length;a++)
                            {
                                DeltaVol[a] = 0;
                            }

                            for(int a=0; a < SolucionAng.length;a++)
                            {
                                SolucionAng[a] = 0;
                            }

                            for(int a=0; a < SolucionVol.length;a++)
                            {
                                SolucionVol[a] = 0;
                            }




                            /*for(int a=0; a < VectorAng.length;a++)
                            {
                                model.addElement("Vieja Fase" + (a+1) + ": " + VectorAng[a]);

                            }

                            for(int a=0; a < VectorV.length;a++)
                            {
                                model.addElement("Vieja Tension" + (a+1) + ": " + VectorV[a]);

                            }
                            **/




                         auxp01 = 0;

                         for(int a = 0; a < VectorP.length; a++)
                         {
                              xii = VectorP[a];
                              auxp01 = 0;

                             for(int b=0;b<numnodos;b++)
                             {

                                try
                                        {
                                            String sql47 = "SELECT yreal, yimagi FROM Ybus WHERE i = '" + xii + "' AND j = '" + (b+1) + "'";
                                            stmt47 = conx47.createStatement();

                                            ResultSet rs47 = stmt47.executeQuery( sql47 );

                                            while (rs47.next())
                                            {
						Double nn47 = Double.parseDouble(rs47.getString("yreal"));
                                                Double nn48 = Double.parseDouble(rs47.getString("yimagi"));
                                                YijauxP.setReal(nn47);
                                                YijauxP.setImag(nn48);

                                            }

                                        }
                                        catch(SQLException e2)
                                        {
                                            JFrame frame6 = new JFrame();
                                            JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                        }


                                double Yang = YijauxP.arg();
                                /*model.addElement("ang: " + 57.2957795131*Yang);**/

                                auxp01 = VectorV[xii-1] * VectorV[b] * YijauxP.abs() * Math.cos(VectorAng[xii-1] - VectorAng[b] - Yang);
                                /*model.addElement("aux: " + auxp01);**/
                                VectorPcal[a] = VectorPcal[a] + auxp01;

                             }


                         }


                 /**        model.addElement("");
                         for(int a=0;a<VectorPcal.length;a++)
                            {
                                model.addElement("Pcal" + VectorP[a] + ": " + VectorPcal[a]);

                            }

                            /* Calculos de las Qcalculadas **/

                         auxp02 = 0;

                         for(int a = 0; a < VectorQ.length; a++)
                         {
                              xii = VectorQ[a];
                              auxp02 = 0;

                             for(int b=0;b<numnodos;b++)
                             {

                                try
                                        {
                                            String sql49 = "SELECT yreal, yimagi FROM Ybus WHERE i = '" + xii + "' AND j = '" + (b+1) + "'";
                                            stmt49 = conx49.createStatement();

                                            ResultSet rs49 = stmt49.executeQuery( sql49 );

                                            while (rs49.next())
                                            {
						Double nn49 = Double.parseDouble(rs49.getString("yreal"));
                                                Double nn50 = Double.parseDouble(rs49.getString("yimagi"));
                                                YijauxQ.setReal(nn49);
                                                YijauxQ.setImag(nn50);

                                            }

                                        }
                                        catch(SQLException e2)
                                        {
                                            JFrame frame6 = new JFrame();
                                            JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                        }


                                auxp02 = VectorV[xii-1] * VectorV[b] * YijauxQ.abs() * Math.sin(VectorAng[xii-1] - VectorAng[b] - YijauxQ.arg());

                                VectorQcal[a] = VectorQcal[a] + auxp02;

                             }


                         }


                    /*     model.addElement("");
                         for(int a=0;a<(VectorQcal.length);a++)
                            {
                                model.addElement("Qcal" + VectorQ[a] + ": " + VectorQcal[a]);

                            }
**/
                             for(int a=0; a < VectorPesp.length;a++)
                            {

                                VectorPesp[a] = VectorPiny[a+1];
   /*                             model.addElement("Pesp" + (a+1) + ": " + VectorPesp[a]);
**/
                            }

                         for(int a=0; a < VectorQesp.length;a++)
                            {

                                VectorQesp[a] = VectorQiny[VectorQ[a]-1];
   /*                             model.addElement("Qesp" + (a+1) + ": " + VectorQesp[a]);
**/
                            }

                         for(int a=0; a < VectorPesp.length;a++)
                            {
                                DeltaP[a] = VectorPesp[a] - VectorPcal[a];
   /*                             model.addElement("DeltaP" + (a+1) + ":" + DeltaP[a]);
**/
                            }

                         for(int a=0; a < VectorQesp.length;a++)
                            {
                                DeltaQ[a] = VectorQesp[a] - VectorQcal[a];
   /*                             model.addElement("DeltaQ" + (a+1) + ": " + DeltaQ[a]);
**/
                            }

                         for(int a=0; a < DeltaP.length;a++)
                            {
                                DeltaPdivV[a] = DeltaP[a] / VectorV[a+1];
   /*                             model.addElement("DeltaP" + (a+1) + "/V" + (a+1) + ": " + DeltaPdivV[a]);
**/
                            }

                        for(int a=0; a < DeltaQ.length;a++)
                            {
                                DeltaQdivV[a] = DeltaQ[a] / VectorV[(VectorQ[a]-1)];
   /*                             model.addElement("DeltaQ" + (a+1) + "/V" + (a+1) + ": " + DeltaQdivV[a]);
**/
                            }

                         /* Resolucion del sistema de ecuaciones matricial **/

                         model.addElement(" ");
                         model.addElement("Resolucion del Modelo Activo ");
                         model.addElement("Mismatch de Fase. Iteracion: " + contador);
                         model.addElement(" ");

                         DeltaAng = Bi.solveLinearSet(DeltaPdivV);

                         for(int a=0; a < DeltaAng.length;a++)
                            {
                                model.addElement("Deltad" + VectorP[a] + ": " + DeltaAng[a]);

                            }

                         model.addElement(" ");
                         model.addElement("Resolucion del Modelo Reactivo ");
                         model.addElement("Mismatch de Tension. Iteracion: " + contador);
                         model.addElement(" ");

                         DeltaVol = Bii.solveLinearSet(DeltaQdivV);

                         for(int a=0; a < DeltaVol.length;a++)
                            {
                                model.addElement("DeltaV" + VectorQ[a] + ": " + DeltaVol[a]);

                            }

                         model.addElement(" ");
                         model.addElement("Solucion del Sistema. Desacoplado. Iteracion: " + contador);
                         model.addElement(" ");

                        for(int a=0; a < SolucionAng.length;a++)
                            {
                                SolucionAng[a]= VectorAng[VectorP[a]-1] + DeltaAng[a];
                                model.addElement("Fase" + VectorP[a] + ": " + 57.2957795131*SolucionAng[a]);

                            }

                         for(int a=0; a < SolucionVol.length;a++)
                            {
                                SolucionVol[a]= VectorV[VectorQ[a]-1] + DeltaVol[a];
                                model.addElement("Tension" + VectorQ[a] + ": " + SolucionVol[a]);

                            }

                            error = 0;
                            err3 = 0;
                            err4 = 0;
                            for (int x=0;x<DeltaP.length;x++)
                            {
                                err1 = Math.abs(DeltaP[x]);
                                err3 = Math.max(err3, err1);
                            }

                            for (int x=0;x<DeltaQ.length;x++)
                            {
                                err2 = Math.abs(DeltaQ[x]);
                                err4 = Math.max(err4,err2);
                            }

                            error = Math.max(err3,err4);

                            model.addElement("error: " + error);



                            contador++;
                        }


                        try
                            {
                                conx47.close();
                                conx49.close();
                            }
                            catch(SQLException e2)
                                        {
                                            JFrame frame6 = new JFrame();
                                            JOptionPane.showMessageDialog(frame6,"No se pudo establecer conexi�n con la BD" + e2.getMessage());
                                        }

                         botonone.setEnabled(false);
                         botontwo.setEnabled(false);
                         botonthree.setEnabled(false);
                         botonfour.setEnabled(false);


                     }
                     });


                    add(pane, BorderLayout.NORTH);
                    botones.add(botonone);
                    botones.add(botontwo);
                    botones.add(botonthree);
                    botones.add(botonfour);
                    add(botones, BorderLayout.SOUTH);


    }


}

