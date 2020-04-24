package Cliente;

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

public class LimCliente extends JFrame implements ActionListener {

    CtrCliente ctrCliente;
    JTextField nome, end, email, cpf;
    JButton adicionar;
    JLabel nomep, endp, emailp, cpfp;
    
        public LimCliente(CtrCliente pCtrCliente){
            
        	super("Cadastrar Cliente");
            ctrCliente = pCtrCliente;
            
            nome = new JTextField(20);
            end = new JTextField(20);
            email = new JTextField(20);
            cpf = new JTextField(20);
            adicionar = new JButton("Cadastrar");
            nomep = new JLabel("Nome: ");
            endp = new JLabel("Endereço: ");
            emailp = new JLabel("Email: ");
            cpfp = new JLabel("CPF: ");
            int x = 30, y = 20;
            
            JPanel painel = new JPanel();
            SpringLayout layout = new SpringLayout();
            painel.setLayout(layout);
            
                
            
        layout.putConstraint(SpringLayout.NORTH, nomep , y+10 , SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, nomep, x-20, SpringLayout.WEST, painel);
        painel.add(nomep);
        layout.putConstraint(SpringLayout.NORTH, nome, y+10, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, nome, x+80, SpringLayout.WEST, painel);
        painel.add(nome);
        
        layout.putConstraint(SpringLayout.NORTH, endp , y+40 , SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, endp, x-20, SpringLayout.WEST, painel);
        painel.add(endp);
        layout.putConstraint(SpringLayout.NORTH, end, y+40, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, end, x+80, SpringLayout.WEST, painel);
        painel.add(end);
        
        layout.putConstraint(SpringLayout.NORTH, emailp , y+70 , SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, emailp, x-20, SpringLayout.WEST, painel);
        painel.add(emailp);
        layout.putConstraint(SpringLayout.NORTH, email, y+70, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, email, x+80, SpringLayout.WEST, painel);
        painel.add(email);
        
        layout.putConstraint(SpringLayout.NORTH, cpfp , y + 100 , SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, cpfp, x -20, SpringLayout.WEST, painel);
        painel.add(cpfp);
        layout.putConstraint(SpringLayout.NORTH, cpf, y + 100, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, cpf, x + 80, SpringLayout.WEST, painel);
        painel.add(cpf);

        layout.putConstraint(SpringLayout.NORTH, adicionar, y + 130, SpringLayout.NORTH, painel);
        layout.putConstraint(SpringLayout.WEST, adicionar, x +120, SpringLayout.WEST, painel);
        painel.add(adicionar);
                    
            
            adicionar.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                  try{
                  ctrCliente.addCliente(nome.getText(), email.getText(), end.getText(), cpf.getText());
                  JOptionPane.showMessageDialog(null, "Cadastro Efetuado");
                  }catch(Exception exc){
                	  JOptionPane.showMessageDialog(null, "Cadastro não efetuado");
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

	@Override
	public void actionPerformed(ActionEvent e) {
           
                  
	}
    
}
