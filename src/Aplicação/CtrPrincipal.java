/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicação;

import Cliente.CtrCliente;
import Mercadoria.ctrMercadoria;
import Venda.CtrVenda;


public class CtrPrincipal {
    public LimPrincipal limPrincipal;
    public CtrCliente ctrCliente;
    public CtrVenda ctrVenda;
    public ctrMercadoria ctrmercadoria;
    
    
    //CHAMADA E CRIACAO DAS CLASSES//
    public CtrPrincipal() throws Exception{
    	limPrincipal= new LimPrincipal(this);
        ctrCliente = new CtrCliente();
        ctrVenda = new CtrVenda();
        ctrVenda.ctrPrincipal = getInstance();
        ctrmercadoria = new ctrMercadoria();
        
    }
    //CHAMA PRA PODER MANDAR O CTRPRINCIPAL PRA VENDA DEPOIS//
    public final CtrPrincipal getInstance(){
        return this;
    }
    
    public CtrCliente getCtrCliente(){
        return ctrCliente;
    }
    public CtrVenda getCtrVenda(){
        return ctrVenda;
    }
    public ctrMercadoria getCtrMercadoria(){
        return ctrmercadoria;
    }
    

}
