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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


public class limDescricaoCliente extends JFrame implements ActionListener{
    
    CtrCliente ctrcliente;
    JTextField cpf;
    JButton zerar, gerar;
    JTextArea det;
    JLabel cpfp, detp;
    
    limDescricaoCliente(CtrCliente pctrCliente) {
        super("Descricao do Cliente");
        ctrcliente = pctrCliente;

        cpf = new JTextField(20);
        det = new JTextArea(5,20);
        gerar = new JButton("Exibir Detalhes");
        zerar = new JButton("Realizar nova consulta");
        
        cpfp = new JLabel("Codigo: ");
        detp = new JLabel("Descricao: ");
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
      
        
        //GERA DESCRICAO DO CLIENTE DESEJADO//
        gerar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ctrcliente.recuperarCliente();
                } catch (Exception ex) {
                         JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

                }
                String aux;
				try {
					aux = ctrcliente.consultaCliente(cpf.getText());
					det.setText(aux);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "CPF incorreto");
				}
            }
                  
        });
        //ZERA TODOS OS DADOS PRA REALIZAR NOVA CONSULTA//
        zerar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cpf.setText("");
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
