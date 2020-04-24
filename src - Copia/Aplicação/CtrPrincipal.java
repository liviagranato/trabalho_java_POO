/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicação;

import Cliente.CtrCliente;
import Mercadoria.ctrMercadoria;
import Venda.CtrVenda;

/**
 *
 * @author Ã‚ngela-PC
 */
public class CtrPrincipal {
    public LimPrincipal limPrincipal;
    public CtrCliente ctrCliente;
    public CtrVenda ctrVenda;
    public ctrMercadoria ctrmercadoria;
    
    
    
    public CtrPrincipal(){
    	limPrincipal= new LimPrincipal(this);
        ctrCliente = new CtrCliente();
        ctrVenda = new CtrVenda();
        ctrmercadoria = new ctrMercadoria();
        
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
