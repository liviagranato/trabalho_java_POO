/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mercadoria;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author Ângela-PC
 */
public class limFaturamentoMercadoria extends JFrame implements ActionListener{
    ctrMercadoria ctrmercadoria;
    JTextField cod, fat;
    JButton gerar,zerar;
    JLabel codp, fatp;
    
    limFaturamentoMercadoria(ctrMercadoria pctrMercadoria) {
        super("Faturamento por Mercadoria");
        ctrmercadoria = pctrMercadoria;
        
        cod = new JTextField(20);
        fat = new JTextField(20);
        gerar = new JButton ("Gerar faturamento");
        zerar = new JButton("Realizar nova consulta");
        
        codp = new JLabel("Codigo: ");
        fatp = new JLabel("Faturamento: ");
        int x = 30, y = 20;
            
            
        JPanel painel = new JPanel();
        SpringLayout layout = new SpringLayout();
        painel.setLayout(layout);
            
        layout.putConstraint(SpringLayout.NORTH, codp , y+10 , SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, codp, x-20, SpringLayout.WEST, painel);
        painel.add(codp);
        layout.putConstraint(SpringLayout.NORTH, cod, y+10, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, cod, x+80, SpringLayout.WEST, painel);
        painel.add(cod);
        
        layout.putConstraint(SpringLayout.NORTH, gerar, y + 40, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, gerar, x+120 , SpringLayout.WEST, painel);
        painel.add(gerar); 
        
        layout.putConstraint(SpringLayout.NORTH, fatp , y+90 , SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, fatp, x-20, SpringLayout.WEST, painel);
        painel.add(fatp);
        layout.putConstraint(SpringLayout.NORTH, fat, y+90, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, fat, x+80, SpringLayout.WEST, painel);
        painel.add(fat);
        
        layout.putConstraint(SpringLayout.NORTH, zerar, y + 120, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, zerar, x+110 , SpringLayout.WEST, painel);
        painel.add(zerar); 
        
        fat.setEditable(false);
        fat.setBackground(Color.WHITE);
       
        
        gerar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                double aux;
				try {
					aux = ctrmercadoria.CalculaFaturamentoProduto(Integer.parseInt(cod.getText()));
					fat.setText(aux+" reais.");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"O código da mercadoria está incorreto");
					}
            }
            });
        
                zerar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cod.setText("");
                fat.setText("");
            }        
        });
       
        
        pack();
        add(painel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setVisible(true);   
        setResizable(false);
        setLocation(470, 250);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
 
    }
    
}
