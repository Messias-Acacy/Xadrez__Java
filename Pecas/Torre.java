package Pecas;

import Jogador.CorPeca;
import Tabuleiro.Campo;

public class Torre  extends Peca{

	
	/**
	 * @param cor
	 * @param posicao
	 * @param letra
	 */
	public Torre(CorPeca cor, int[] posicao, String letra,Campo tabuleiro) {
		super(cor, posicao, letra,tabuleiro);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int[][] movimentar(int[] posicoes,CorPeca Peca) {
		// TODO Auto-generated method stub
		return new int[][] {{6,0}};
	}

}
