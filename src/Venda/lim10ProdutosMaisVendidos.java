/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venda;

import java.awt.Color;
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

public class lim10ProdutosMaisVendidos extends JFrame implements ActionListener{
    CtrVenda ctrVenda;
    JTextArea det;
    JButton gerar;
    
    lim10ProdutosMaisVendidos(CtrVenda pctrVenda) {
        super("Top 10 produtos mais vendidos");
        ctrVenda = pctrVenda;
        det = new JTextArea(10,40);
        gerar = new JButton("Atualizar lista");
        
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(1,1));

        JPanel p2 = new JPanel();
        p2.add(new JLabel("Produtos: "));
        p2.add(det);
        det.setEditable(false);
        det.setBackground(Color.WHITE);
        p2.add(gerar);
        
        //GERA O TOP 10 DOS PRODUTOS MAIS VENDIDOS
        gerar.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ctrVenda.recuperarVendas();
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
                    String aux = ctrVenda.toStringMaisVendidos();
                    det.setText(aux);
            }

        });
        
        painel.add(p2);
        
        pack();
        add(painel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 300);
        setVisible(true);
        setResizable(false);
        setLocation(460, 200);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
  
    }
}

