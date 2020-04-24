/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mercadoria;

import java.io.Serializable;

/**
 *
 * @author Livia
 */
public class Mercadoria implements Serializable {
    int codigo,quantidade,cntVenda;
    String descricao;
    double preco, valorVenda;
    
    public Mercadoria(int pCodigo, String pDescricao, double pPreco, double pValorVenda, int pQuantidade, int cntVenda){
        codigo = pCodigo;
        descricao = pDescricao;
        preco = pPreco;
        valorVenda = pValorVenda;
        quantidade=pQuantidade;
        cntVenda=cntVenda;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    public double getPreco (){
        return preco;
    }
    
    public double getValor(){
        return valorVenda;
    }
    
    public int getQuantidade(){
    	return quantidade;
    }
    
    public int getCntVenda(){
    	return cntVenda;
    }
    
    public void setCodigo(int pCodigo){
        codigo = pCodigo;
    }
    
    public void setDescricao(String pDescricao){
        descricao = pDescricao;
    }
    
    public void setPreco(double pPreco){
        preco = pPreco;
    }
    
    public void setValor (double pValorVenda){
        valorVenda = pValorVenda;
    }
    
    public void setQuantidade(int pQuantidade){
    	quantidade=pQuantidade;
    }
    
    public void setCntVenda(int pCntVenda){
    	cntVenda=pCntVenda;
    }
    
    public String toStringMercadoria(){
        return "Codigo: "+this.getCodigo()+ "\nDescricao: "+this.getDescricao()+"\nValor de Venda: "+this.getValor()+"\nValor de Compra: "+this.getPreco()+"\nQuantidade de vendidos: "+this.getCntVenda();
    }
    
    public void atualizaCntVenda(){
    	cntVenda+=1;
    }
}
