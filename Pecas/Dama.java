package Pecas;

import Tabuleiro.Campo;

public class Dama extends Peca {


	/**
	 * @param cor
	 * @param posicao
	 * @param letra
	 */
	public Dama(String cor, int[] posicao, String letra,Campo tabuleiro) {
		super(cor, posicao, letra,tabuleiro);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int[][] movimentar(int[] posicoes,String cor) {
		// TODO Auto-generated method stub
		return new int[][] {{6,0}};
	}

}
