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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import Cliente.CtrCliente;
import Cliente.EntCliente;
import Mercadoria.Mercadoria;
import Mercadoria.ctrMercadoria;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LimVenda extends JFrame implements ActionListener {
    CtrVenda ctrVenda;
    CtrCliente cC = null;
    ctrMercadoria cM = null;
    JTextField dia, mes, ano, quantidade, cpf;
    JButton cadastrar, inserirProduto, cancelar, okCliente;
    Venda v = null;
    public int qAtualiza = 0;
    private boolean flag;

	LimVenda(CtrVenda pctrVenda, CtrCliente c, ctrMercadoria m) {
            super("Cadastrar Vendas");
            ctrVenda = pctrVenda;
            cC = c;
            cM = m;

            dia = new JTextField(2);
            mes = new JTextField(2);
            ano = new JTextField(4);
            cpf = new JTextField(10);

            okCliente = new JButton("OK");
            inserirProduto = new JButton("Inserir Produto");
            cancelar = new JButton("Cancelar Venda");
            cadastrar = new JButton("Registrar Venda");

            JPanel p1 = new JPanel();
            p1.add(new JLabel("CPF do cliente:"));
            p1.add(cpf);
            p1.add(okCliente);

            JPanel p2 = new JPanel(new FlowLayout());
            p2.add(new JLabel("Dia:"));
            p2.add(dia);
            p2.add(new JLabel("Mes:"));
            p2.add(mes);
            p2.add(new JLabel("Ano:"));
            p2.add(ano);
		
            JPanel p3 = new JPanel();
            p3.add(inserirProduto);
            p3.setLayout(new FlowLayout());
            p3.add(cadastrar);
            p3.add(cancelar);
                 
            JPanel painel = new JPanel();
            SpringLayout layout = new SpringLayout();
            painel.setLayout(layout);

            painel.add(p1);
            layout.putConstraint(SpringLayout.WEST, p1, 0, SpringLayout.WEST, painel);
            layout.putConstraint(SpringLayout.NORTH, p1, 10, SpringLayout.NORTH, painel);

            painel.add(p2);
            layout.putConstraint(SpringLayout.SOUTH, p2, 30, SpringLayout.SOUTH, p1);

            painel.add(p3);
            layout.putConstraint(SpringLayout.SOUTH, p3,50 , SpringLayout.SOUTH, p2);
            layout.putConstraint(SpringLayout.WEST, p3, 25 , SpringLayout.WEST, painel);

		

            ///////////BOTAO DE PEGAR NOME CLIENTE/////////
            okCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cC.recuperarCliente();
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }

                try {
                    flag = false;
                        for (EntCliente c : cC.listaCliente) {
                            if (cpf.getText().equals(c.getCPF())) {
                                JOptionPane.showMessageDialog(null, "" + c.getNome());
                                flag = true;
                                break;
                            }
                        }
                    if(flag == false){
                    JOptionPane.showMessageDialog(null,"Cliente nao cadastrado");
                    }
                }catch (Exception e2) { 
                JOptionPane.showMessageDialog(null, "Cliente nao Cadastrado");

                }
            }});

            //////////BOTAO DE INSERIR/////////////
            inserirProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                menuMercadoria();

            }});

            /////////BOTAO DE CADASTRAR VENDA////////
            cadastrar.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        cC.recuperarCliente();
                    }
                    catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    try {
                        ctrVenda.recuperarVendas();
                    }
                    catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    try {
                        cM.recuperarMercadoria();
                    }
                    catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }

                        for (EntCliente c : cC.listaCliente) {
                            if (cpf.getText().equals(c.getCPF())) {
                                try {
                                    ctrVenda.addVenda(c, v.mercadoria, Integer.parseInt(dia.getText()),
                                    Integer.parseInt(mes.getText()), Integer.parseInt(ano.getText()));
                                        for (Mercadoria m : v.mercadoria) {
                                            double total = 0;
                                            total += m.getValor();
                                            ctrVenda.atualizaQuantidade(qAtualiza, m.getCodigo());
                                            ctrVenda.criarNotaFiscal(cpf.getText(),Integer.parseInt(dia.getText()), Integer.parseInt(mes.getText()),
                                            Integer.parseInt(ano.getText()));
                                            emissaoNota(total, Integer.parseInt(dia.getText()), Integer.parseInt(mes.getText()),
                                            Integer.parseInt(ano.getText()));

                                        }
                                }
                                catch (Exception e1){
                                    JOptionPane.showMessageDialog(null, "Erro");
                                }
                            }
                        }
                }
            });
		
            //////////BOTAO CANCELAR VENDA////////////
            cancelar.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    JOptionPane.showMessageDialog(null, "Venda Cancelada");
                }
            });

	
            pack();
            add(painel);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(450, 180);
            setVisible(true);
            setResizable(false);
            revalidate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

        /////////MENU DE ADICIONAR MERCADORIA///////////////
	public void menuMercadoria() {
            JLabel cod = new JLabel("Codigo da Mercadoria:");
            JLabel qnt = new JLabel("Quantidade:");
            JTextField tCod = new JTextField(5);
            JTextField tQnt = new JTextField(3);
            JButton ok = new JButton(" ok ");

            JPanel p1 = new JPanel();
            p1.add(cod);
            p1.add(tCod);

            JPanel p2 = new JPanel();
            p2.add(qnt);
            p2.add(tQnt);

            JPanel painelMercadoria = new JPanel();
            SpringLayout layout = new SpringLayout();
            painelMercadoria.setLayout(layout);

            painelMercadoria.add(p1);
            layout.putConstraint(SpringLayout.WEST, p1, 0, SpringLayout.WEST, painelMercadoria);
            layout.putConstraint(SpringLayout.NORTH, p1, 10, SpringLayout.NORTH, painelMercadoria);

            painelMercadoria.add(p2);
            layout.putConstraint(SpringLayout.SOUTH, p2, 30, SpringLayout.SOUTH, p1);

            painelMercadoria.add(ok);
            layout.putConstraint(SpringLayout.SOUTH, ok, 60, SpringLayout.SOUTH, p2);
            layout.putConstraint(SpringLayout.EAST, ok, -10, SpringLayout.EAST, painelMercadoria);

            //BOTAO CONFIRMAR MERCADORIA
            ok.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    int k = 0;
                    try {
                        cM.recuperarMercadoria();
                    }
                    catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }


                    try {
                        qAtualiza = Integer.parseInt(tQnt.getText());
                        String saida = null;
                        saida = cM.consultaProduto(Integer.parseInt(tCod.getText()));
                            if (saida.equals("Nao contem produto com este codigo.")==false) {
                                for (Mercadoria m : cM.listaMercadoria) {
                                    if (saida.equals(m.getDescricao())) {
                                        if (qAtualiza <= m.getQuantidade()) {
                                            v.mercadoria.add(m);
                                            m.atualizaCntVenda(); 
                                            k += 1;
                                        if (k==10) ok.setEnabled(false);
                                        JOptionPane.showMessageDialog(null, saida);
                                        }
                                        else {
                                        JOptionPane.showMessageDialog(null,
                                        "Nao contem a quantidade desejada no estoque.");
                                        }
                                    }
                                }
                            }
                            else {
                            JOptionPane.showMessageDialog(null, "Codigo Incorreto.");
                            }
                        }
                    catch (Exception e1) {
                        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                        JOptionPane.showMessageDialog(null, "Erro", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            JFrame frame = new JFrame();
            frame.add(painelMercadoria);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(400, 250);
            frame.setVisible(true);
            frame.setResizable(false);
            frame.setLocation(470, 250);
        }

        
        //////////////EMISSAO DA NOTA FISCAL///////////////
	public void emissaoNota(double pTotal, int pDia, int pMes, int pAno) throws Exception {

            JPanel p1 = new JPanel();
            JLabel notaFiscal = new JLabel("Nota fiscal referente a compra: ");
            JTextArea descricao = new JTextArea(5,20);
            SpringLayout layout = new SpringLayout();

            ctrVenda.recuperarVendas();
            p1.add(notaFiscal);

            descricao.setText(ctrVenda.toStringNotaFiscal());
            p1.add(descricao);

            JPanel principal = new JPanel();

            principal.add(p1);
            layout.putConstraint(SpringLayout.WEST, p1, 0, SpringLayout.WEST, principal);
            layout.putConstraint(SpringLayout.NORTH, p1, 10, SpringLayout.NORTH, principal);

            JFrame frame = new JFrame();
            frame.add(principal);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(400, 250);
            frame.setVisible(true);
            frame.setResizable(false);
            frame.setLocation(470, 250);

	}

}
