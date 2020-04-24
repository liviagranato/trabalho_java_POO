/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.Serializable;


public class EntCliente implements Serializable {
    String nome, endereco, CPF, email;
    
    
    public EntCliente(String pNome, String pEndereco, String pEmail, String pCPF){
        nome = pNome;
        endereco = pEndereco;
        CPF = pCPF;
        email = pEmail;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getEndereco (){
        return endereco;
    }
    
    public String getCPF(){
        return CPF;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setNome(String pNome){
        nome = pNome;
    }
    
    public void setEndereco(String pEndereco){
        endereco = pEndereco;
    }
    
    public void setEmail(String pEmail){
        email = pEmail;
    }
    
    public void setCPF(String pCPF){
        CPF = pCPF;
    }
    
    public String toString(){
       return "Nome: "+this.getNome()+" CPF: "+this.getCPF()+" Endereco: "+this.getEndereco()+" E-mail: "+this.getEmail();
    }
}
