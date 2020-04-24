package Cliente;

import Venda.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Mercadoria.Mercadoria;

public class CtrCliente {
    
	public ArrayList <EntCliente> listaCliente=new ArrayList();
	public LimCliente limCliente;
	public limFaturamentoCliente fatCliente;
        public limDescricaoCliente decCliente;
        public limFatPeriodoCliente fatPerC;
        String arquivo = "cliente.dat";

        public CtrCliente() {
            try {
                recuperarCliente();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    
        //ADD CLIENTE NOVO//
        public void addCliente(String pNome, String pEnd, String pEmail, String pCpf)throws Exception{
            listaCliente.add(new EntCliente(pNome, pEnd, pEmail, pCpf));
            salvarCliente();
        }
               
        //PEGA O ARRAY CRIADO
        public ArrayList <EntCliente> getListaClientes(){
            return listaCliente;
        }
        
        //PEGA O FATURAMENTO POR CPF//
	public double faturamento(String pCpf)throws Exception{
            double total=0;
            CtrVenda v=null;
            for(Venda v1: v.listaVenda){
                if(v1.getClient().getCPF().equals(pCpf)){
                   total=v1.CalculaMercadorias();
                }
            }
	return total;
	}
	
        //PEGA FATURAMENTO POR PERIODO//
	public double faturamentoPeriodo(String pCpf,int dia,int mes,int ano,int diaf,int mesf, int anof)throws Exception{
            double total=0;
            CtrVenda v=null;
		for(Venda v1: v.listaVenda){
                    if((v1.ano>=ano)&&(v1.ano<=anof)){
                        if((v1.mes>=mes)&&(v1.mes<=mesf)){
                            if((v1.dia>=dia)&&(v1.dia<=diaf)){
                                if(v1.getClient().getCPF().equals(pCpf)){
                                    total=v1.CalculaMercadorias();
                                                    }
					}
				}
			}			
		}
        return total;
	}
	
        //PERSISTENCIA DOS DADOS
	public void salvarCliente() throws Exception {
            FileOutputStream fileOs = new FileOutputStream(arquivo);
            ObjectOutputStream objOs = new ObjectOutputStream(fileOs);
            objOs.writeObject(listaCliente);

            objOs.flush();
            objOs.close();
        }
	
        //RECUPERAR DADOS ARQUIVOS
	public void recuperarCliente() throws Exception{
            File objFile = new File(arquivo);
        
            if(objFile.exists()){
            FileInputStream fileIs = new FileInputStream(arquivo);
            ObjectInputStream objIs = new ObjectInputStream(fileIs);
            listaCliente = (ArrayList<EntCliente>)objIs.readObject();
            objIs.close();
            }
        }
	
        //CONSULTAR DADOS CLIENTE
	public String consultaCliente(String pCpf)throws Exception{
            for(EntCliente c:listaCliente){
                if(c.getCPF().equals(pCpf)){
                    return c.toString();
                }
            }
        return "Nao contem clientes com este cpf.";
	}
        
        //CHAMADAS DE CRIAR LIMITES
	public void criaCliente(){
            limCliente = new LimCliente(this);
    } 
        public void criaFatCliente(){
            fatCliente = new limFaturamentoCliente(this);
        }
        public void criaDecCliente(){
            decCliente = new limDescricaoCliente(this);
        }
        public void criaFatPeriodoCliente(){
            fatPerC = new limFatPeriodoCliente(this);
        }
}
