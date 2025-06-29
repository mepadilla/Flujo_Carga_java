/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tools;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author melvin
 */

public class Listar extends JPanel {

  JList list;

  DefaultListModel model;

  int counter = 15;

  public Listar() {
    setLayout(new BorderLayout());
    model = new DefaultListModel();
    list = new JList(model);
    JScrollPane pane = new JScrollPane(list);
    JButton addButton = new JButton("Add Element");
    JButton removeButton = new JButton("Remove Element");
    for (int i = 0; i < 15; i++)
      model.addElement("Element " + i);

    addButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        model.addElement("Element " + counter);
        counter++;
      }
    });
    removeButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (model.getSize() > 0)
          model.removeElementAt(0);
      }
    });

    add(pane, BorderLayout.NORTH);
    add(addButton, BorderLayout.WEST);
    add(removeButton, BorderLayout.EAST);
  }

  public static void main(String s[]) {
    JFrame frame = new JFrame("List Model");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(new Listar());
    frame.setSize(200, 200);
    frame.pack();
    frame.setResizable(false);
    frame.setVisible(true);
  }
}