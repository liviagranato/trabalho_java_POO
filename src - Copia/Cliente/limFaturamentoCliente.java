/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

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
public class limFaturamentoCliente extends JFrame implements ActionListener{
    CtrCliente ctrcliente;
    JTextField cpf, fat;
    JButton gerar, zerar;
    JLabel cpfp, fatp;
    limFaturamentoCliente(CtrCliente pctrCliente) {
        super("Faturamento do Cliente");
        ctrcliente = pctrCliente;
    
        cpf = new JTextField(20);
        fat = new JTextField(20);
        gerar = new JButton("Gerar faturamento");
        zerar = new JButton("Realizar nova consulta");
        
        cpfp = new JLabel("CPF: ");
        fatp = new JLabel("Faturamento: ");
        int x = 30, y = 20;
            
            
        JPanel painel = new JPanel();
        SpringLayout layout = new SpringLayout();
        painel.setLayout(layout);
            
        layout.putConstraint(SpringLayout.NORTH, cpfp , y+10 , SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, cpfp, x-20, SpringLayout.WEST, painel);
        painel.add(cpfp);
        layout.putConstraint(SpringLayout.NORTH, cpf, y+10, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, cpf, x+80, SpringLayout.WEST, painel);
        painel.add(cpf);
        
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
					aux = ctrcliente.faturamento(cpf.getText());
					fat.setText(aux+" reais.");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "CPF está incorreto");
				}
                
            }
            //FAZER TRY CATCH COM O CPF DO CLIENTE            
        });
        zerar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cpf.setText("");
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
