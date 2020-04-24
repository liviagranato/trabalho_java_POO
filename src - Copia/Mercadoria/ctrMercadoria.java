/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mercadoria;

import Cliente.EntCliente;
import Cliente.LimCliente;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class ctrMercadoria {
        
        public LimMercadoria limMercadoria;
        public limFaturamentoMercadoria limFatMerc;
        public limDescricaoMercadoria limDecMerc;
        public ArrayList <Mercadoria> listaMercadoria=new ArrayList();
    
    public ctrMercadoria (LimMercadoria pLimMercadoria){
        limMercadoria = pLimMercadoria;
    }

    public ctrMercadoria() {
   
    }
    
    public ctrMercadoria(limFaturamentoMercadoria pfatMerc) {
        limFatMerc = pfatMerc;
    }
    
    public ctrMercadoria(limDescricaoMercadoria pDecMerc) {
        limDecMerc = pDecMerc;
    }
    
    public void insereMercadoria(Mercadoria mercadoria)throws Exception{
        listaMercadoria.add(mercadoria);
    }
    
    public String consultaProduto(int pCodigo)throws Exception{
    	for(Mercadoria m: listaMercadoria){
    		if(m.getCodigo()==pCodigo){
    			return m.toStringMercadoria();
    			
    		}
    	}
    	return "Nao contem produto com este codigo.";
    }
    
    
    public double CalculaFaturamentoProduto(int pCodigo)throws Exception{  //IMPLEMENTEI CALCULA FATURAMENTO POR PRODUTO
        double total = 0;
        for (Mercadoria m: listaMercadoria){
            if (m.getCodigo()==pCodigo){
                total += m.getValor(); //FATURAMENTO DE PRODUTO É O PREÇO QUE ELES COMPRAM - O PREÇO QUE ELES VENDEM
            }
        }
        return total;
    }
    
    public void salvarMercadoria() throws Exception {
        FileOutputStream fileOs = new FileOutputStream("dados/mercadoria.dat");
        ObjectOutputStream objOs = new ObjectOutputStream(fileOs);
        objOs.writeObject(listaMercadoria);

        objOs.flush();
        objOs.close();
    }
    
    public void atualizaCntVendas(){
    	
    }
    
    public void criaMercadoria(){
        limMercadoria = new LimMercadoria(this);
} 
    public void criaFatMercadoria(){
        limFatMerc = new limFaturamentoMercadoria(this);
    }
    public void criaDesMercadoria(){
        limDecMerc = new limDescricaoMercadoria(this);
    }
    
}
