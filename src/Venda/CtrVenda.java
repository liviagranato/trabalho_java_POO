package Venda;

import Aplicação.CtrPrincipal;
import Cliente.CtrCliente;
import Cliente.EntCliente;
import Cliente.LimCliente;
import Mercadoria.LimMercadoria;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JOptionPane;

import Mercadoria.Mercadoria;
import Mercadoria.ctrMercadoria;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrVenda {
    public CtrPrincipal ctrPrincipal;
    public ArrayList<Venda> listaVenda = new ArrayList();
    public ArrayList<NotaFiscal> notaFiscal = new ArrayList();
    public ArrayList<Mercadoria> MaisVendidos = new ArrayList<Mercadoria>();
    public LimVenda limVenda;
    public LimCliente limcliente;
    public LimMercadoria limMerc;
    public lim10ProdutosMaisVendidos top10;
    public limLucroLiquidoEmpresa lucli;
    public limFatTotalEmpresa fatEmpresa;
    public String arquivo = "venda.dat";
    public String arquivo2 = "notafiscal.dat";

	public CtrVenda() throws Exception {
            try {
                    recuperarVendas();
            } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
	}
        
        public CtrPrincipal getCtrPrincipal() {
            return ctrPrincipal;
        }

        //ADD NOVA VENDA
	public void addVenda(EntCliente pCliente, ArrayList<Mercadoria> pMercadoria, int pDia, int pMes, int pAno) throws Exception{
            listaVenda.add(new Venda(pCliente, pMercadoria, pDia, pMes, pAno));
            salvarVendasNotaFiscal();
       	}

        //ADICIONA VENDA NA LISTA
	public void insereVendas(Venda pVenda) {
            listaVenda.add(pVenda);
            int diferenca = pVenda.quantidade;
            Mercadoria m = null;
            int cod = m.getCodigo();
            atualizaQuantidade(diferenca, cod);
            m.atualizaCntVenda();
	}

        //ESTOQUE
	public void atualizaQuantidade(int pDiferenca, int pCodigo) {
            Venda v = null;
            for (Mercadoria m : v.mercadoria) {
                if (m.getCodigo() == pCodigo) {
                    int x = m.getQuantidade();
                    x -= pDiferenca;
                    m.setQuantidade(x);
                }
            }
	}
        
        //CRIAR NOTA FISCAL 
	public void criarNotaFiscal(String pCpf, int dia, int mes, int ano) {
            int i = 0;
            ArrayList<Venda> temp=new ArrayList();
                for (Venda v : listaVenda) {
                    if (v.ano == ano) {
                        if (v.mes == mes) {
                            if (v.dia == dia) {
                                if (pCpf.equals(v.cliente.getCPF())) {
                                    temp.add(v);
                                }
                            }
                        }
                    }
                }
            notaFiscal.add(new NotaFiscal(temp,i));
	}

        //BUSCAR NOTA FISCAL
	public String buscaNotaFiscalPeriodo(String pCpf, int dia, int mes, int ano, int pDia, int pMes, int pAno)throws Exception {
            String saida="";
            String aux="",aux2="";
            double total=0;
            NotaFiscal temp=null;
		for (NotaFiscal nF : notaFiscal) {
                    for(Venda v1:nF.v){
			if ((v1.ano >= ano) && (v1.ano <= pAno)) {
                            if ((v1.mes >= mes) && (v1.mes <= pMes)) {
                                if ((v1.dia >= dia) && (v1.dia <= pDia)) {
                                    if (v1.getClient().getCPF().equals(pCpf)) {
                                        total+=v1.CalculaMercadorias();
                                        aux="Total: "+total;
                                    }
                                }
                            }
			}
                    }
		aux2="Codigo: "+nF.cod;
                }
        return ""+aux2+" "+aux;
	}

        //FATURAMENTO POR PERIODO
	public double faturamentoPeriodo(int dia, int mes, int ano, int pDia, int pMes, int pAno) throws Exception {
            double total = 0;
            for (Venda v : listaVenda) {
                if ((v.ano >= ano) && (v.ano <= pAno)) {
                    if ((v.mes >= mes) && (v.mes <= pMes)) {
                        if ((v.dia >= dia) && (v.dia <= pDia)) {
                            total += v.CalculaMercadorias();
                        }
                    }
                }
            }
        return total;
	}

        //PEGA LUCRO LIQUIDO POR PERIODO
	public double lucroLiquido(int dia, int mes, int ano, int pDia, int pMes, int pAno) throws Exception {
            double total = 0;
		for (Venda v : listaVenda) {
                    if ((v.ano >= ano) && (v.ano <= pAno)) {
                        if ((v.mes >= mes) && (v.mes <= pMes)) {
                            if ((v.dia >= dia) && (v.dia <= pDia)) {
                                total += v.CalculaMercadorias() - v.CalculaCustoMercadoria();
                            }
                        }
                    }
		}
        return total;
	}

        //PEGA A NOTA FISCAL (TEXTO)
	public String toStringNotaFiscal() {
            String saida = "";
            double total=0;
                for (NotaFiscal nf : notaFiscal) {
                    for(Venda v:nf.v){
                        total+=v.CalculaMercadorias();
                        saida = "Total: " +total + "     " + v.dia +"/" + v.mes +"/" + v.ano + "\n";
			}
		}
        return saida;
	}

        //PERSISTENCIA DE DADOS
	public void salvarVendasNotaFiscal() throws Exception {
            FileOutputStream fileOs = new FileOutputStream(arquivo);
            ObjectOutputStream objOs = new ObjectOutputStream(fileOs);
            objOs.writeObject(listaVenda);
            objOs.flush();
            objOs.close();

            FileOutputStream fileOs2 = new FileOutputStream(arquivo2);
            ObjectOutputStream objOs2 = new ObjectOutputStream(fileOs2);
            objOs2.writeObject(notaFiscal);
            objOs2.flush();
            objOs2.close();
	}

        //RECUPERAR DADOS DO ARQUIVO
	public void recuperarVendas() throws Exception {
            File arquivoVenda = new File(arquivo);
            File arquivoNota = new File(arquivo2);

            if (arquivoVenda.exists()) {
                FileInputStream fileIs = new FileInputStream(arquivo);
                ObjectInputStream objIs = new ObjectInputStream(fileIs);
                    listaVenda = (ArrayList<Venda>) objIs.readObject();
			for (int i = 0; i < listaVenda.size(); i++) {
                            listaVenda.add((Venda) listaVenda.get(i));
			}
                    objIs.close();
		}
            if (arquivoNota.exists()) {
                FileInputStream fileIs2 = new FileInputStream(arquivo2);
                ObjectInputStream objIs2 = new ObjectInputStream(fileIs2);
                notaFiscal = (ArrayList<NotaFiscal>) objIs2.readObject();
                objIs2.close();
            }
	}
        
        //LISTA DE MAIS VENDIDOS
	public void InsereMaisVendidos() {
            for (Venda v : listaVenda) {
                for (Mercadoria m : v.mercadoria) {
                    MaisVendidos.add(m);
                }
            }
	}
        
        //ORDENACAO MAIS VENDIDOS
	public void ordenaMaisVendidos() {
            Mercadoria m1, m2;
                for (int i = 0; i < MaisVendidos.size(); i++) {
                    m1 = MaisVendidos.get(i);
                    m2 = MaisVendidos.get(i + 1);
                    if (m1.getCntVenda() > m2.getCntVenda()) {
                        MaisVendidos.add(i, m1);
                        MaisVendidos.add(i + 1, m2);
                    }else {
                        if (m1.getCntVenda() < m2.getCntVenda()) {
                            MaisVendidos.add(i, m2);
                            MaisVendidos.add(i + 1, m1);
                        }
                    }
                }
	}
        
        //MAIS VENDIDOS (TEXTO)
	public String toStringMaisVendidos() {
            String saida = "";
                for (Mercadoria m : MaisVendidos) {
                    saida += " " + m.toStringMercadoria() + "\n";
		}
        return saida;
	}
       
        
        //FUNCOES DE CRIACAO DE LIMITES
	public void criaVenda() {
            CtrCliente c = ctrPrincipal.getCtrCliente();
            ctrMercadoria m = ctrPrincipal.getCtrMercadoria();
            limVenda = new LimVenda(this, c, m);
	}

	public void get10produtosMaisVendidos() {
            top10 = new lim10ProdutosMaisVendidos(this);
	}

	public void getLucroLiquidoEmpresa() {
            lucli = new limLucroLiquidoEmpresa(this);
	}

	public void getFaturamentoTotalEmpresa() {
            fatEmpresa = new limFatTotalEmpresa(this);
	}
      
}
