package Venda;

import Cliente.*;
import Mercadoria.*;

import java.io.Serializable;
import java.util.*;

public class Venda implements Serializable {
    
    public EntCliente cliente;
    public ArrayList <Mercadoria> mercadoria=new ArrayList();
    public int dia=0,mes=0,ano=0,quantidade;
	
	public Venda(EntCliente pCliente, ArrayList <Mercadoria> pMercadoria, int pDia, int pMes, int pAno){
            setCliente(pCliente);
            setMercadoria(pMercadoria);
            setDia(pDia);
            setMes(pMes);
            setAno(pAno);
        }

	private void setAno(int pAno) {
            ano=pAno;
	}

	private void setDia(int pDia) {
            dia=pDia;
	}

	private void setMes(int pMes) {
            mes=pMes;
	}

	public void setCliente(EntCliente pCliente){
            cliente=pCliente;
	}
	
	public void setMercadoria(ArrayList<Mercadoria> pMercadoria){
            mercadoria=pMercadoria;
	}	
	
	public EntCliente getClient(){
            return cliente;	
	}

	public ArrayList<Mercadoria> getMercadoria(){
            return mercadoria;
	}
	
	private int getAno() {
            return ano;
	}

	private int getDia() {
            return dia;
	}

	private int getMes() {
            return mes;
	}
	
        //CALCULA O TOTAL DAS MERCADORIAS COMPRADAS
	public double CalculaMercadorias(){
            double total=0;
		for(Mercadoria m: mercadoria){
			total+=m.getValor();
		}
        return total;
	}
	
        //CALCULA O TOTAL DE CUSTO DAS MERCADORIAS COMPRADAS
	public double CalculaCustoMercadoria(){
            double total=0;
		for(Mercadoria m: mercadoria){
			total+=m.getPreco();
		}
        return total;
	}
	
	
}
