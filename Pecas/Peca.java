package Pecas;

public abstract class Peca {
	private String cor;
	private int[] posicao;
	private char Letra;
	//private jogador jogador;
	
	
	public Peca() {
		
	}

	public Peca(String cor, int[] posicao,char letra) {
		this.cor = cor;
		this.posicao = posicao;
		this.Letra = letra;

	}




	public abstract int movimentar(int posicaoX, int posicaoY) ;




	public String getCor() {
		return cor;
	}




	public void setCor(String cor) {
		this.cor = cor;
	}




	public int[] getPosicao() {
		return posicao;
	}




	public void setPosicao(int[] posicao) {
		this.posicao = posicao;
	}
	
	
	public char getLetra() {
		return this.Letra;
	}
	
	

}
