package Pecas;

import Tabuleiro.Campo;


public class Peao extends Peca{
	private int[] posicaoInicial;
	
	public Peao(String cor, int[] posicao,String letra,int[] posicaoInicial,Campo tabuleiro) {
		super(cor, posicao,letra,tabuleiro);
		this.posicaoInicial =posicaoInicial;
		// TODO Auto-generated constructor stub
	}

	






	@Override
	public int[][] movimentar(int[] posicoes,String cor) {
		int z = 0;
		if(cor == "branca") {
			if(posicoes[0] == posicaoInicial[0] && posicoes[1] == posicaoInicial[1]) {
				for(int x = 0;x < 2;x++) {
					z++;
				}
			}
			else {
				for(int x = 0;x < 1;x++) {
						z++; }
			}
			return new int[][] {{posicoes[0]-z,0}};
		}
		else {
			if(posicoes[0] == posicaoInicial[0] && posicoes[1] == posicaoInicial[1]) {
				for(int x = 0;x < 2;x++) {
					z++;
				}
			}
			else {
				for(int x = 0;x < 1;x++) {
						z++;
				}
				
				
			}
			
			return new int[][] {{posicoes[0]+z,0}};
			
			
		}
		
		
		
		
	
		
		
		
		

	}








	@SuppressWarnings("unused")
	private int[] getPosicaoInicial() {
		return posicaoInicial;
	}








	@SuppressWarnings("unused")
	private void setPosicaoInicial(int[] posicaoInicial) {
		this.posicaoInicial = posicaoInicial;
	}
	
	
	
	
	

}
