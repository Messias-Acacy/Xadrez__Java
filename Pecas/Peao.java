package Pecas;

import java.util.ArrayList;

import Jogador.CorPeca;
import Tabuleiro.Campo;


public class Peao extends Peca{
	private int[] posicaoInicial;
	
	public Peao(CorPeca cor, int[] posicao,String letra,int[] posicaoInicial,Campo tabuleiro) {
		super(cor, posicao,letra,tabuleiro);
		this.posicaoInicial =posicaoInicial;

	}

	






	@Override
	public int[][] movimentar(int[] posicoes,CorPeca Peca) {
		int z = 0;
		ArrayList<String> posicoesJovais = new ArrayList<>();
		
		if(Peca == CorPeca.BRANCA) {
			if(posicoes[0] == posicaoInicial[0] && posicoes[1] == posicaoInicial[1]) {
				for(int x = 0;x < 2;x++) {
					z++;
					posicoesJovais.add(posicoes[0]-z+","+0);
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
