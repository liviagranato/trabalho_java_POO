/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicação;
import java.util.ArrayList;

import Mercadoria.*;
/**
 *
 * @author Ã‚ngela-PC
 */
public class Aplicacao {
    public static void main(String args[]){
        CtrPrincipal cp = new CtrPrincipal();
        ArrayList <Mercadoria> listaMercadoria=new ArrayList();
        
        listaMercadoria.add(new Mercadoria(123,"Uniforme básico Escolar",10.00,25.00,3,0));
        listaMercadoria.add(new Mercadoria(124,"Uniforme frio Escolar",20.00,40.00,2,0));
        listaMercadoria.add(new Mercadoria(125,"Uniforme básico Empresa",10.00,25.00,3,0));
        listaMercadoria.add(new Mercadoria(126,"Uniforme frio Empresa",20.00,40.00,1,0));
        listaMercadoria.add(new Mercadoria(127,"Casaco",15.00,30.00,4,0));
        listaMercadoria.add(new Mercadoria(128,"Moletom blusa",15.00,35.00,5,0));
        listaMercadoria.add(new Mercadoria(129,"Moletom calça",10.00,25.00,5,0));
        listaMercadoria.add(new Mercadoria(130,"Moletom conjunto",25.00,55.00,5,0));
        listaMercadoria.add(new Mercadoria(131,"Shorts praia",5.00,10.00,3,0));
        listaMercadoria.add(new Mercadoria(132,"Bermuda",7.00,15.00,5,0));
    }
}
