package Cliente;

import Venda.*;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CtrCliente {
    
	public ArrayList <EntCliente> listaCliente=new ArrayList();
	public LimCliente limCliente;
	public limFaturamentoCliente fatCliente;
        public limDescricaoCliente decCliente;
        public limFatPeriodoCliente fatPerC;

    public CtrCliente() {
   
    }
    
        public void addCliente(String pNome, String pEnd, String pEmail, String pCpf)throws Exception{
            listaCliente.add(new EntCliente(pNome, pEnd, pEmail, pCpf));
        }
    
	public double faturamento(String pCpf)throws Exception{
		double total=0;
		CtrVenda v=null;
		for(Venda v1: v.listaVenda){
			if(v1.getClient().getCPF()==pCpf){
			   total=v1.CalculaMercadorias();
			}
		}
		return total;
	}
	
	public double faturamentoPeriodo(String pCpf,int dia,int mes,int ano,int diaf,int mesf, int anof)throws Exception{
		double total=0;
		CtrVenda v=null;
		for(Venda v1: v.listaVenda){
			if((v1.ano>=ano)&&(v1.ano<=anof)){
				if((v1.mes>=mes)&&(v1.mes<=mesf)){
					if((v1.dia>=dia)&&(v1.dia<=diaf)){
						if(v1.getClient().getCPF()==pCpf){
							   total=v1.CalculaMercadorias();
							}
					}
				}
			}
			
		}
		return total;
	}
	
	public void salvarCliente() throws Exception {
        FileOutputStream fileOs = new FileOutputStream("dados/cliente.dat");
        ObjectOutputStream objOs = new ObjectOutputStream(fileOs);
        objOs.writeObject(listaCliente);
       
        objOs.flush();
        objOs.close();
    }
	
	public String consultaCliente(String pCpf)throws Exception{
		for(EntCliente c:listaCliente){
			if(c.getCPF()==pCpf){
				return c.toString();
			}
		}
                return "Nao contem clientes com este cpf.";
	}
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
