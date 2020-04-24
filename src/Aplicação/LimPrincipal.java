/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicação;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class LimPrincipal extends JFrame implements ActionListener {

	public CtrPrincipal ctrPrincipal;
        
        JMenuBar barraMenu;
        JMenu cadCliente, cadVenda,cadMercadoria, consulta, produto, clientes, empresa, vendas;
        JMenuItem rcliente, rvenda,rmercadoria, pfaturamento,pdescricao,cfaturamento, cdescricao, efaturamentoPeriodo, elucroLiquidoPeriodo,vClientePeriodo, vdescricao, v10maisVendidos;
        Color MarromMenu = new Color(189, 183, 107);
        Color MarromFundo = new Color (184,173,143);
                
	public LimPrincipal(CtrPrincipal pctrPrincipal) {
		super("Sistema de controle e informacao - Itajuba Confeccoes LTDA.");
		ctrPrincipal = pctrPrincipal;
		
                JMenuBar barraMenu = new JMenuBar(); 
                setJMenuBar(barraMenu);  

                //OPCOES DE MENU PRINCIPAIS//
		JMenu cadCliente = new JMenu("Cliente", true);
		JMenu cadMercadoria=new JMenu("Mercadoria",true);                  
		JMenu cadVenda = new JMenu("Venda", true);                  
		JMenu consulta = new JMenu("Consultar", true);
                
                //OPCOES DE MENU SECUNDARIAS DE 'CONSULTAR'//
		JMenu produto = new JMenu("Produtos");
                produto.setMnemonic(KeyEvent.VK_P); //MARCACAO ATALHO LETRA
                
		JMenu clientes = new JMenu("Clientes");
                clientes.setMnemonic(KeyEvent.VK_C);
                
		JMenu empresa = new JMenu("Empresa");
                empresa.setMnemonic(KeyEvent.VK_E);
                
		JMenu vendas = new JMenu("Vendas");
                vendas.setMnemonic(KeyEvent.VK_V);
                
                //OPCAO MENU SECUNDARIA CLIENTE//
		JMenuItem rcliente = new JMenuItem("Cadastrar");
                rcliente.setMnemonic(KeyEvent.VK_C);
                rcliente.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ctrPrincipal.getCtrCliente().criaCliente();
                    }
                }); 
                
                //OPCAO MENU SECUNDARIA MERCADORIA//
                JMenuItem rmercadoria = new JMenuItem("Cadastrar");
                rmercadoria.setMnemonic(KeyEvent.VK_C);
                rmercadoria.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ctrPrincipal.getCtrMercadoria().criaMercadoria();
                    }
                }); 
                
                //OPCAO MENU SECUNDARIA VENDA
                JMenuItem rvenda = new JMenuItem("Cadastrar");
                rvenda.setMnemonic(KeyEvent.VK_C);
                rvenda.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ctrPrincipal.getCtrVenda().criaVenda();
                    }   
                });
                   
                //OPCAO MENU TERCIARIA DE 'CONSULTAR' (8 TOPICOS)//
		JMenuItem pfaturamento=new JMenuItem("Faturamento");
                pfaturamento.setMnemonic(KeyEvent.VK_F);
                pfaturamento.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ctrPrincipal.getCtrMercadoria().criaFatMercadoria();
                    }                  
                });
                
		JMenuItem pdescricao=new JMenuItem("Descricao");
                pdescricao.setMnemonic(KeyEvent.VK_D);
                pdescricao.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ctrPrincipal.getCtrMercadoria().criaDesMercadoria();
                    }   
                });
                
		JMenuItem cfaturamento=new JMenuItem("Faturamento");
                cfaturamento.setMnemonic(KeyEvent.VK_F);
                cfaturamento.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       ctrPrincipal.getCtrCliente().criaFatCliente();
                    }
                });
                
		JMenuItem cdescricao=new JMenuItem("Descricao");
                cdescricao.setMnemonic(KeyEvent.VK_D);
                cdescricao.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       ctrPrincipal.getCtrCliente().criaDecCliente();
                    }
                });
		JMenuItem efaturamentoPeriodo=new JMenuItem("Faturamento por periodo");
                efaturamentoPeriodo.setMnemonic(KeyEvent.VK_F);
                efaturamentoPeriodo.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ctrPrincipal.ctrVenda.getFaturamentoTotalEmpresa();
                    
                    }          
                });
                
		JMenuItem elucroLiquidoPeriodo=new JMenuItem("Lucro liquido por periodo");
                elucroLiquidoPeriodo.setMnemonic(KeyEvent.VK_L);
                elucroLiquidoPeriodo.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ctrPrincipal.ctrVenda.getLucroLiquidoEmpresa();
                    }
                    
                });
                
		JMenuItem vClientePeriodo=new JMenuItem("Faturamento por cliente em um periodo");
                vClientePeriodo.setMnemonic(KeyEvent.VK_F);
                vClientePeriodo.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ctrPrincipal.getCtrCliente().criaFatPeriodoCliente();
                        
                    }
                    
                });
                                 
		JMenuItem v10maisVendidos=new JMenuItem("10 produtos mais vendidos");
                v10maisVendidos.setMnemonic(KeyEvent.VK_P);
		v10maisVendidos.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ctrPrincipal.getCtrVenda().get10produtosMaisVendidos();
                    }
                    
                });
                
                ///DEFINICAO DA JANELA//
                cadVenda.add(rvenda);
                cadCliente.add(rcliente);
                cadMercadoria.add(rmercadoria);
		produto.add(pfaturamento);
		produto.add(pdescricao);
		clientes.add(cfaturamento);
		clientes.add(cdescricao);
		empresa.add(efaturamentoPeriodo);
		empresa.add(elucroLiquidoPeriodo);
		vendas.add(vClientePeriodo);
		vendas.add(v10maisVendidos);
		
		consulta.add(produto);
		consulta.add(clientes);
		consulta.add(empresa);
		consulta.add(vendas);

		barraMenu.add(cadCliente);
		barraMenu.add(cadMercadoria);
		barraMenu.add(cadVenda);
		barraMenu.add(consulta);
	
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(screenSize);
		this.setVisible(true);
                this.setExtendedState(JFrame.MAXIMIZED_BOTH);
                this.setResizable(false);
                this.setForeground(MarromFundo);
	}


    public void actionPerformed(ActionEvent e) {

    } 
}
