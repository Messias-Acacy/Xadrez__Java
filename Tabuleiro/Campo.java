package Tabuleiro;


import Jogador.CorPeca;
import Pecas.*;
 public class Campo implements Tabuleiro{

	private Peca[][] pecas;
	private boolean isTabuleiroMontado;
	
	
	public Campo() {
		this.pecas = new Peca[8][8];
		isTabuleiroMontado = false;
		
	}

	@Override
	public void MontarTabuleiro( Peca[][] pecas) {
		if(!isTabuleiroMontado) {
			this.pecas = pecas;
			this.isTabuleiroMontado = true;
		}
		
		
	
	}

	@Override
	public void MostrarTabuleiro(int contador,String jogadorAtual,CorPeca corPeca) {
		System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
		System.out.println("TURNO ATUAL: "+contador+"º");
		System.out.println("JOGADOR ATUAL: "+jogadorAtual);
		System.out.println("PEÇA: "+corPeca);
		System.out.println("_______XADREZ_______");
		char letras[] = {'a','b','c','d','e','f','g','h'};
		short numeros[] = {1,2,3,4,5,6,7,8};
		for (int x =0;x < 8;x++) {
			System.out.print(numeros[x]+"| ");
			for (int y = 0;y <8;y++) {
				if(pecas[x][y] == null) {
					
					
					if(y == pecas[x].length-1) {
						System.out.print("-"+" |");
					}
					else {
						System.out.print("-"+" ");
					}
					
				}
				else {
					if(y == pecas[x].length-1) {
						System.out.print(pecas[x][y].getLetra()+" |");
					}
					else {
						System.out.print(pecas[x][y].getLetra()+" ");
					}
					
				}
			
			}
			System.out.println();
		}
		
		
		System.out.print("=-");
		for(int x =0;x < letras.length+1;x++) {
			System.out.print("=-"+"");
		}
		System.out.println();
		System.out.print("   ");
		for(int x =0;x < letras.length;x++) {
			System.out.print(letras[x]+" ");
		}
		System.out.println();
		System.out.println("______________________________________");
	}
	
	public Peca[][] getPecas(){
		return this.pecas;
	}
	

}
