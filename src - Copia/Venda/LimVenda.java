/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venda;

import java.awt.BorderLayout;
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

import Cliente.CtrCliente;
import Cliente.EntCliente;
import Mercadoria.Mercadoria;
import Mercadoria.ctrMercadoria;

/**
 *
 * @author Ângela-PC
 */
public class LimVenda extends JFrame implements ActionListener{
    CtrVenda ctrVenda;
    CtrCliente cC=null;
    ctrMercadoria cM=null;
    JTextField dia, mes, ano, quantidade, cpf,nome;
    JButton cadastrar,inserirProduto,cancelar;
    Venda v=null;
    
    LimVenda(CtrVenda pctrVenda) {
        super("Cadastrar Vendas");
        ctrVenda = pctrVenda;
        
        dia = new JTextField(2);
        mes = new JTextField(2);
        ano = new JTextField(4);
        cpf = new JTextField(11);
        nome= new JTextField(20);
        
        inserirProduto=new JButton("Inserir Produto");
        cancelar=new JButton("Cancelar Venda");
        cadastrar = new JButton("Registrar Venda");
        
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(2,1));
        
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(7,1));
        p1.add(new JLabel("CPF do cliente:"));
        p1.add(cpf);
        cpf.addActionListener(new ActionListener(){
            
        	public void actionPerformed(ActionEvent e) {
            	try{
            		
            		for(EntCliente c:cC.listaCliente){
            			if(cpf.getText()==c.getCPF()){
            				nome.setText(""+c.getNome());
            			}else{
            	              JOptionPane.showMessageDialog(null, "Cliente não Cadastrado");
            	              }
            		}
            	}catch (Exception e2){
            		
            	}
             }
        });
        p1.add(new JLabel("Nome do cliente:"));
        p1.add(nome);
        nome.setBackground(Color.WHITE);
        nome.setEditable(false);
        p1.add(new JLabel("Dia:"));
        p1.add(dia);
        p1.add(new JLabel("Mês:"));
        p1.add(mes);
        p1.add(new JLabel("Ano:"));
        p1.add(ano);
        p1.add(inserirProduto,BorderLayout.CENTER);
        
        inserirProduto.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
            	try{
            	menuMercadoria();
            	}catch(Exception e3){
            		inserirProduto.setEnabled(false);
            	}
            }
        });
        
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(cadastrar);
        cadastrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) { 
            	
            	for(EntCliente c: cC.listaCliente){
            		if(cpf.getText()==c.getCPF()){
            			try {
							ctrVenda.addVenda(c, v.mercadoria, Integer.parseInt(dia.getText()), Integer.parseInt(mes.getText()), Integer.parseInt(ano.getText()));
	                        
                			} catch (Exception e1) {
				              JOptionPane.showMessageDialog(null, "Erro");

						}
            		}
            	}


            }
        });
        p2.add(cancelar);
        cancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

              //ctrVenda.addVenda(cpf.getText(), Integer.parseInt(codm.getText()), Integer.parseInt(dia.getText()), Integer.parseInt(mes.getText()), Integer.parseInt(ano.getText()), Integer.parseInt(quantidade.getText()));
              JOptionPane.showMessageDialog(null, "Cadastro Efetuado");

            }
        });
        
            painel.add(p1);
            painel.add(p2);
            
            
            pack();
            add(painel);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(500, 300);
            setVisible(true);
            setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
   
    }
    
    public void menuMercadoria(){
    	
    	JLabel cod= new JLabel("Código da Mercadoria:");
    	JLabel qnt= new JLabel("Quantidade:");
    	JTextField tCod=new JTextField(5);
    	JTextField tQnt= new JTextField(3);
    	JButton ok=new JButton(" ok ");
    	
    	JPanel p1=new JPanel();
    	p1.add(cod);
    	p1.add(tCod);
    	
    	JPanel p2=new JPanel();
    	p2.add(qnt);
    	p2.add(tQnt);
    	
    	JPanel painel = new JPanel();
        SpringLayout layout = new SpringLayout();
        painel.setLayout(layout);
        
        painel.add(p1);
		layout.putConstraint(SpringLayout.WEST, p1, 0, SpringLayout.WEST, painel);
		layout.putConstraint(SpringLayout.NORTH, p1, 10, SpringLayout.NORTH,painel);
		
		painel.add(p2);
		layout.putConstraint(SpringLayout.SOUTH, p2, 30, SpringLayout.SOUTH, p1);
		
		painel.add(ok);
		layout.putConstraint(SpringLayout.SOUTH, ok, 60, SpringLayout.SOUTH, p2);
		layout.putConstraint(SpringLayout.EAST, ok, -10, SpringLayout.EAST,painel);
		
		ok.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
            	int x=0,k=0;
            	try{
            		while(k<10){
            		cM=null;
            		int qnt=Integer.parseInt(tQnt.getText());
            		String saida=null;
            		saida=cM.consultaProduto(Integer.parseInt(tCod.getText()));
            		if(saida!="Nao contem produto com este codigo."){
            		   for(Mercadoria m:cM.listaMercadoria){
            			   if(saida==m.getDescricao()){
            				   if(qnt<=m.getQuantidade()){
            					   v.mercadoria.add(m);
            					   m.atualizaCntVenda();
            					   x=0;
            					   k+=1;
            				   }else{
            					   JOptionPane.showMessageDialog(null, "Não contém a quantidade desejada no estoque.");
            				   }
            			   }
            		   }
            		}else{
            			JOptionPane.showMessageDialog(null, "Código Incorreto.");
            		}
            		}
            		
            	}catch(Exception e1){
            		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            		JOptionPane.showMessageDialog(null, "Erro","Erro", JOptionPane.ERROR_MESSAGE);
            	}
            	}
        });

		add(painel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setVisible(true);
        setResizable(false);
        setLocation(470, 250);
    	
    }
    
}

