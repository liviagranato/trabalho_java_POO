/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mercadoria;

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

import Cliente.CtrCliente;
import javax.swing.SpringLayout;

/**
 *
 * @author Ã‚ngela-PC
 */
public class LimMercadoria extends JFrame implements ActionListener {
	ctrMercadoria CtrMercadoria;
    JTextField codigo, descricao, preco, valorVenda, quantidade;
    JButton adicionar;
    JLabel codp, descp, precp, valorvendap, quantip;
    
        public LimMercadoria(ctrMercadoria pCtrMercadoria){
            super("Cadastrar Mercadoria");
            CtrMercadoria = pCtrMercadoria;
            
            codigo = new JTextField(20);
            descricao = new JTextField(20);
            preco = new JTextField(20);
            valorVenda = new JTextField(20);
            quantidade = new JTextField(20);
            adicionar=new JButton("Cadastrar");
            codp = new JLabel("Codigo: ");
            descp = new JLabel("Descrição: ");
            precp = new JLabel("Preço: ");
            valorvendap = new JLabel("Valor de Venda: ");
            quantip = new JLabel("Quantidade: ");
            int x = 30, y = 20;
            
            
            JPanel painel = new JPanel();
            SpringLayout layout = new SpringLayout();
            painel.setLayout(layout);
            
        layout.putConstraint(SpringLayout.NORTH, codp , y+10 , SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, codp, x-20, SpringLayout.WEST, painel);
        painel.add(codp);
        layout.putConstraint(SpringLayout.NORTH, codigo, y+10, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, codigo, x+80, SpringLayout.WEST, painel);
        painel.add(codigo);
        
        layout.putConstraint(SpringLayout.NORTH, descp , y+40 , SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, descp, x-20, SpringLayout.WEST, painel);
        painel.add(descp);
        layout.putConstraint(SpringLayout.NORTH, descricao, y+40, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, descricao, x+80, SpringLayout.WEST, painel);
        painel.add(descricao);
        
        layout.putConstraint(SpringLayout.NORTH, precp , y+70 , SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, precp, x-20, SpringLayout.WEST, painel);
        painel.add(precp);
        layout.putConstraint(SpringLayout.NORTH, preco, y+70, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, preco, x+80, SpringLayout.WEST, painel);
        painel.add(preco);
        
        layout.putConstraint(SpringLayout.NORTH, valorvendap , y + 100 , SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, valorvendap, x -20, SpringLayout.WEST, painel);
        painel.add(valorvendap);
        layout.putConstraint(SpringLayout.NORTH, valorVenda, y + 100, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, valorVenda, x + 80, SpringLayout.WEST, painel);
        painel.add(valorVenda);

        layout.putConstraint(SpringLayout.NORTH, quantip , y + 130 , SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, quantip, x -20, SpringLayout.WEST, painel);
        painel.add(quantip);
        layout.putConstraint(SpringLayout.NORTH, quantidade, y + 130, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, quantidade, x + 80, SpringLayout.WEST, painel);
        painel.add(quantidade);        
        
        layout.putConstraint(SpringLayout.NORTH, adicionar, y + 160, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, adicionar, x +120, SpringLayout.WEST, painel);
        painel.add(adicionar);
            
            
            adicionar.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                  Mercadoria m=new Mercadoria(Integer.parseInt(codigo.getText()), descricao.getText(), Double.parseDouble(preco.getText()), Double.parseDouble(valorVenda.getText()), Integer.parseInt(quantidade.getText()),0);
                  try {
					CtrMercadoria.insereMercadoria(m);
					JOptionPane.showMessageDialog(null, "Cadastro Efetuado");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Cadastro não foi efetuado");
				}
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
