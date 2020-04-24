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
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
 

/**
 *
 * @author Ângela-PC
 */
public class limFatPeriodoCliente extends JFrame implements ActionListener {
    CtrCliente ctrCliente;
    JTextField cpf, dia, mes, ano, diaf, mesf, anof,nroNotas;
    JButton gerar, zerar;
    JTextArea notas;
    JLabel cpfp, diap, mesp, anop, nronp, notap, barra, de, ate;
    limFatPeriodoCliente(CtrCliente pctrcliente) {
        super("Faturamento por Período do Cliente");
        ctrCliente = pctrcliente;
        
        cpf = new JTextField(20);
        dia = new JTextField(3);
        mes = new JTextField(3);
        ano = new JTextField(5);
        diaf = new JTextField(3);
        mesf = new JTextField(3);
        anof = new JTextField(5);
        nroNotas = new JTextField(12);
        notas = new JTextArea(5, 26);
        
        gerar = new JButton("Gerar faturamento");
        zerar = new JButton("Realizar nova consulta");
        
        cpfp = new JLabel("CPF: ");
        diap = new JLabel("Dia: ");
        mesp = new JLabel("Mes: ");
        anop = new JLabel("Ano: ");
        nronp = new JLabel("Numero de notas fiscais: ");
        notap = new JLabel("Valores de notas fiscais: ");
        int x = 30, y = 20;
            
            
        JPanel painel = new JPanel();
        SpringLayout layout = new SpringLayout();
        painel.setLayout(layout);
            
        layout.putConstraint(SpringLayout.NORTH, cpfp , y , SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, cpfp, x+15, SpringLayout.WEST, painel);
        painel.add(cpfp);
        layout.putConstraint(SpringLayout.NORTH, cpf, y, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, cpf, x+75, SpringLayout.WEST, painel);
        painel.add(cpf);
        
        
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
                
        layout.putConstraint(SpringLayout.NORTH, nronp, y+140, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, nronp, x+15, SpringLayout.WEST, painel);
        painel.add(nronp);        
        layout.putConstraint(SpringLayout.NORTH, nroNotas, y + 140, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, nroNotas, x+165 , SpringLayout.WEST, painel);
        painel.add(nroNotas);
        
        layout.putConstraint(SpringLayout.NORTH, notap, y+170, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, notap, x+15, SpringLayout.WEST, painel);
        painel.add(notap);        
        layout.putConstraint(SpringLayout.NORTH, notas, y+200, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, notas, x+15 , SpringLayout.WEST, painel);
        painel.add(notas);
        
        layout.putConstraint(SpringLayout.NORTH, zerar, y+280, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, zerar, x+90 , SpringLayout.WEST, painel);
        painel.add(zerar); 
        
        nroNotas.setBackground(Color.WHITE);
        nroNotas.setEditable(false);
        
        notas.setBackground(Color.WHITE);
        notas.setEditable(false);

        
        gerar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                    //CHAMAR FUNÇÃO DE PEGAR NUMERO DE NOTAS FISCAIS Q O CLIENTE TEM
                    //CHAMAR FUNÇÃO DE BOTAR O VALOR DE CADA NOTA FISCAL IMPRESSO
                
            }
            //FAZER TRY CATCH COM O CPF DO CLIENTE            
        });
        zerar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cpf.setText("");
                dia.setText("");
                mes.setText("");
                ano.setText("");
                diaf.setText("");
                mesf.setText("");
                anof.setText("");
                
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
