package Venda;

import Cliente.EntCliente;
import Cliente.LimCliente;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Mercadoria.Mercadoria;
import Mercadoria.ctrMercadoria;

public class CtrVenda {
    
	public ArrayList<Venda> listaVenda=new ArrayList();
	public ArrayList<Venda> notaFiscal=new ArrayList();
	public ArrayList <Mercadoria> MaisVendidos=new ArrayList<Mercadoria>();
	public LimVenda limVenda;
        public lim10ProdutosMaisVendidos top10;
        public limLucroLiquidoEmpresa lucli;
        public limFatTotalEmpresa fatEmpresa;
    
	

    public CtrVenda() {
   
    }
        public void addVenda(EntCliente pCliente, ArrayList <Mercadoria> pMercadoria, int pDia, int pMes, int pAno)throws Exception{
            listaVenda.add(new Venda(pCliente, pMercadoria, pDia, pMes, pAno));
            
        }
    
	public void insereVendas(Venda pVenda){
		listaVenda.add(pVenda);
		int diferenca=pVenda.quantidade;
	    Mercadoria m = null;
	    int cod=m.getCodigo();
	    atualizaQuantidade(diferenca,cod);
	    m.atualizaCntVenda();
	    
	}
	
	public void atualizaQuantidade(int pDiferenca,int pCodigo){
		Venda v=null;
		for (Mercadoria m:v.mercadoria){
			if(m.getCodigo()==pCodigo){
				int x= m.getQuantidade();
				x-=pDiferenca;
				m.setQuantidade(x);
			}
		
				
	}
}
	
	public void insereNotaFiscal(String pCpf,int dia,int mes,int ano,int pDia,int pMes,int pAno)throws Exception{
		double total=0;
		for(Venda v1:listaVenda){
			if((v1.ano>=ano)&&(v1.ano<=pAno)){
				if((v1.mes>=mes)&&(v1.mes<=pMes)){
					if((v1.dia>=dia)&&(v1.dia<=pDia)){
						if(v1.getClient().getCPF()==pCpf){
							   notaFiscal.add(v1);
							}
					}
				}
			}
		}
		for(Venda v1:notaFiscal){
			total=v1.CalculaMercadorias();
		}
		
	}
	
	public double faturamentoPeriodo(int dia,int mes,int ano,int pDia,int pMes,int pAno) throws Exception{
		double total=0;
		for(Venda v:listaVenda){
				if((v.ano>=ano)&&(v.ano<=pAno)){
					if((v.mes>=mes)&&(v.mes<=pMes)){
						if((v.dia>=dia)&&(v.dia<=pDia)){
			                total+=v.CalculaMercadorias();
						}
					}
				}
		}
		return total;
	}
	
	public double lucroLiquido(int dia,int mes,int ano,int pDia,int pMes,int pAno)throws Exception{
		double total=0;
		for(Venda v:listaVenda){
				if((v.ano>=ano)&&(v.ano<=pAno)){
					if((v.mes>=mes)&&(v.mes<=pMes)){
						if((v.dia>=dia)&&(v.dia<=pDia)){
			                total+=v.CalculaMercadorias()-v.CalculaCustoMercadoria();
						}
					}
				}
		}
		return total;
	}
	
	
	
	public String toStringNotaFiscal(){
		String saida="";
		for(Venda v: notaFiscal){
			saida+=" "+v.cliente.toString()+" - "+v.mercadoria.toString()+"\n";
		}
		return saida;
	}
	
	public void salvarVendasNotaFiscal() throws Exception {
        FileOutputStream fileOs = new FileOutputStream("dados/vendas.dat");
        ObjectOutputStream objOs = new ObjectOutputStream(fileOs);
        objOs.writeObject(listaVenda);

        fileOs = new FileOutputStream("dados/notafiscal.dat");
        objOs = new ObjectOutputStream(fileOs);
        objOs.writeObject(notaFiscal);

        objOs.flush();
        objOs.close();
    }
	
        public void criaVenda(){
            limVenda = new LimVenda(this);
        }
        public void get10produtosMaisVendidos(){
            top10 = new lim10ProdutosMaisVendidos(this);
        }
        public void getLucroLiquidoEmpresa(){
            lucli = new limLucroLiquidoEmpresa(this);
        }
        public void getFaturamentoTotalEmpresa(){
            fatEmpresa = new limFatTotalEmpresa(this);
        }
        
        public void InsereMaisVendidos(){
 		   for(Venda v:listaVenda){
 		       for(Mercadoria m:v.mercadoria){
 		    		  MaisVendidos.add(m);   
 		    }
 		}
 	}
		
        
     public void ordenaMaisVendidos(){
    	 Mercadoria m1,m2;
    	 for(int i=0;i<MaisVendidos.size();i++){
              m1=MaisVendidos.get(i);
              m2=MaisVendidos.get(i+1);
              if(m1.getCntVenda()>m2.getCntVenda()){
            	  MaisVendidos.add(i, m1);
            	  MaisVendidos.add(i+1, m2);
              }else{
            	  if(m1.getCntVenda()<m2.getCntVenda()){
            		  MaisVendidos.add(i, m2);
            		  MaisVendidos.add(i+1, m1);
            	  }
              }
    	 }
     }
     
     public String toStringMaisVendidos(){
 		String saida="";
 		for(Mercadoria m: MaisVendidos){
 			saida+=" "+m.toStringMercadoria()+"\n";
 		}
 		return saida;
 	}
		
	
}

