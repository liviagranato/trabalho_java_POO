package Venda;

import java.util.ArrayList;

public class NotaFiscal {
	public int cod;
	public ArrayList<Venda> v=new ArrayList();
	
	public NotaFiscal(ArrayList<Venda> pV,int pCod){
            setVenda(pV);
            setCodigo(pCod);
	}

	private void setCodigo(int pCod) {
            cod=pCod;		
	}

	private void setVenda(ArrayList<Venda> pV) {
            v=pV;
	}
	
	private int getCodigo() {
            return cod;
	}

	private ArrayList<Venda> getVenda() {
            return v;
	}

}
