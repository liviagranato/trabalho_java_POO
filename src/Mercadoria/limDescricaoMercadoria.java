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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;

/**
 *
 * @author �ngela-PC
 */
public class limDescricaoMercadoria extends JFrame implements ActionListener{
    
    ctrMercadoria ctrmercadoria;
    JTextField cod;
    JTextArea det;
    JButton gerar, zerar;
    JLabel codp, detp;

    limDescricaoMercadoria(ctrMercadoria pctrMercadoria) {
        super("Descricao de Mercadoria");
        ctrmercadoria = pctrMercadoria;
        
        cod = new JTextField(20);
        det = new JTextArea(5,20);
        gerar = new JButton ("Exibir Detalhes");
        zerar = new JButton("Realizar nova consulta");
        codp = new JLabel("Codigo: ");
        detp = new JLabel("Descricao: ");
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
        
        layout.putConstraint(SpringLayout.NORTH, detp , y+40 , SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, detp, x-20, SpringLayout.WEST, painel);
        painel.add(detp);
        layout.putConstraint(SpringLayout.NORTH, det, y+40, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, det, x+80, SpringLayout.WEST, painel);
        painel.add(det);             
        
        layout.putConstraint(SpringLayout.NORTH, gerar, y + 170, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, gerar, x , SpringLayout.WEST, painel);
        painel.add(gerar); 
        
        layout.putConstraint(SpringLayout.NORTH, zerar, y + 170, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, zerar, x + 170, SpringLayout.WEST, painel);
        painel.add(zerar); 
       
  
        det.setEditable(false);
        det.setBackground(Color.WHITE);
        det.setLineWrap(true);
                
        //GERAR DESCRICAO MERCADORIA
        gerar.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ctrmercadoria.recuperarMercadoria();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
                
                String aux;
				
                try {
                    aux = ctrmercadoria.consultaProduto(Integer.parseInt(cod.getText()));
                    det.setText(aux);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null,"O codigo da mercadoria esta incorreto");
                }
        }});
        
        
        //ZERAR DADOS PARA REALIZAR NOVA CONSULTA
        zerar.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent e) {
                    cod.setText("");
                    det.setText("");
            }        
        });
        
        
        pack();
        add(painel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);      
        setResizable(false);
        setLocation(470, 250);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
 
    }
    
}
