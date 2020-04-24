/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venda;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


class limLucroLiquidoEmpresa extends JFrame implements ActionListener {
    CtrVenda ctrVenda;
    JTextField dia, mes, ano, diaf, mesf, anof, ll;
    JButton gerar, zerar;
    JLabel diap, mesp, anop, llp;
    
    limLucroLiquidoEmpresa(CtrVenda pctrvenda) {
        super("Lucro liquido por periodo");
        ctrVenda = pctrvenda;    
        dia = new JTextField(3);
        mes = new JTextField(3);
        ano = new JTextField(5);
        diaf = new JTextField(3);
        mesf = new JTextField(3);
        anof = new JTextField(5);
        ll = new JTextField(26);
        
        gerar = new JButton("Gerar lucro");
        zerar = new JButton("Realizar nova consulta");
        llp = new JLabel("Lucro Liquido: ");
        diap = new JLabel("Dia: ");
        mesp = new JLabel("Mes: ");
        anop = new JLabel("Ano: ");
        int x = 30, y = 20;
                
        JPanel painel = new JPanel();
        SpringLayout layout = new SpringLayout();
        painel.setLayout(layout);
                   
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(new JLabel("De:  "));
        p2.add(new JLabel("Dia: "));
        p2.add(dia);
        p2.add(new JLabel("/"));
        p2.add(new JLabel("Mes: "));
        p2.add(mes);
        p2.add(new JLabel("/"));
        p2.add(new JLabel("Ano: "));
        p2.add(ano);
        
        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout());
        p3.add(new JLabel("Ate: "));
        p3.add(new JLabel("Dia: "));
        p3.add(diaf);
        p3.add(new JLabel("/"));
        p3.add(new JLabel("Mes: "));
        p3.add(mesf);
        p3.add(new JLabel("/"));
        p3.add(new JLabel("Ano: "));
        p3.add(anof);
        
        layout.putConstraint(SpringLayout.NORTH, p2 , y+30 , SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, p2, x+10, SpringLayout.WEST, painel);
        painel.add(p2);
        
        layout.putConstraint(SpringLayout.NORTH, p3 , y+60 , SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, p3, x+10, SpringLayout.WEST, painel);
        painel.add(p3);        
                          
        layout.putConstraint(SpringLayout.NORTH, gerar, y + 100, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, gerar, x+100 , SpringLayout.WEST, painel);
        painel.add(gerar); 
                             
        layout.putConstraint(SpringLayout.NORTH, llp, y+170, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, llp, x+15, SpringLayout.WEST, painel);
        painel.add(llp);        
        layout.putConstraint(SpringLayout.NORTH, ll, y+200, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, ll, x+15 , SpringLayout.WEST, painel);
        painel.add(ll);
        
        layout.putConstraint(SpringLayout.NORTH, zerar, y+230, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, zerar, x+90 , SpringLayout.WEST, painel);
        painel.add(zerar); 
                      
        ll.setBackground(Color.WHITE);
        ll.setEditable(false);
        
        //GERAR LUCRO LIQUIDO EMPRESA
        gerar.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ctrVenda.recuperarVendas();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
                
                
                try {
                    double aux = ctrVenda.lucroLiquido(Integer.parseInt(dia.getText()), Integer.parseInt(mes.getText()), Integer.parseInt(ano.getText()), Integer.parseInt(diaf.getText()), Integer.parseInt(mesf.getText()), Integer.parseInt(anof.getText()));
                    ll.setText(aux+" reais");
                }catch (Exception ex) {
                    Logger.getLogger(limFatTotalEmpresa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }              
        });
        
        //ZERA TODOS OS DADOS PARA REALIZAR NOVA CONSULTA
        zerar.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent e) {
                
                dia.setText("");
                mes.setText("");
                ano.setText("");
                diaf.setText("");
                mesf.setText("");
                anof.setText("");
                ll.setText("");
                
            }        
        });
        
       
        add(painel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);  
        setResizable(false);
        setLocation(470, 150);     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
 
    }
    
}
