/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mercadoria;

import Cliente.EntCliente;
import Cliente.LimCliente;
import Venda.Venda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class ctrMercadoria {
        
    public LimMercadoria limMercadoria;
    public limFaturamentoMercadoria limFatMerc;
    public limDescricaoMercadoria limDecMerc;
    public ArrayList <Mercadoria> listaMercadoria=new ArrayList();
    public String arquivo = "mercadoria.dat";
    
        public ctrMercadoria (LimMercadoria pLimMercadoria){
            limMercadoria = pLimMercadoria;
        }

        public ctrMercadoria() {
            try {
                recuperarMercadoria();
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    
        public ctrMercadoria(limFaturamentoMercadoria pfatMerc) {
            limFatMerc = pfatMerc;
        }
    
        public ctrMercadoria(limDescricaoMercadoria pDecMerc) {
            limDecMerc = pDecMerc;
        }
    
        //ADD MERCADORIA NOVA
        public void insereMercadoria(int pCodigo, String pDescricao, double pPreco, double pValorVenda, int pQuantidade, int cntVenda)throws Exception{
            listaMercadoria.add(new Mercadoria(pCodigo, pDescricao, pPreco, pValorVenda, pQuantidade, cntVenda));
            salvarMercadoria();
        }
        
        //CONSULTAR PRODUTO PELO CODIGO
        public String consultaProduto(int pCodigo)throws Exception{
            for(Mercadoria m: listaMercadoria){
                    if(m.getCodigo()==pCodigo){
                            return m.toStringMercadoria();
                    }
            }
        return "Nao contem produto com este codigo.";
        }
    
        //PEGA FATURAMENTO DO PRODUTO
        public double CalculaFaturamentoProduto(int pCodigo)throws Exception{  //IMPLEMENTEI CALCULA FATURAMENTO POR PRODUTO
            double total = 0;
            for (Mercadoria m: listaMercadoria){
                if (m.getCodigo()==pCodigo){
                    total += m.getValor(); //FATURAMENTO DE PRODUTO � O PRE�O QUE ELES COMPRAM - O PRE�O QUE ELES VENDEM
                }
            }
        return total;
        }
        
        //PERSISTENCIA DE DADOS
        public void salvarMercadoria() throws Exception {
            FileOutputStream fileOs = new FileOutputStream(arquivo);
            ObjectOutputStream objOs = new ObjectOutputStream(fileOs);
            objOs.writeObject(listaMercadoria);

            objOs.flush();
            objOs.close();
        }
    
        //RECUPERAR DADOS DE ARQUIVO
        public void recuperarMercadoria() throws Exception{
            File arquivo2 = new File(arquivo);
            if(arquivo2.exists()){
                FileInputStream fileIs = new FileInputStream(arquivo);
                ObjectInputStream objIs = new ObjectInputStream(fileIs);
                listaMercadoria = (ArrayList<Mercadoria>)objIs.readObject();
                objIs.close();
            }
        }
    
        public void atualizaCntVendas(){

        }
    
        //FUNCOES PARA CRIAR LIMITES
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
