package Pecas;
import Tabuleiro.Campo;
public abstract class Peca {
	private String cor;
	private int[] posicao;
	private String Letra;
	private Campo tabuleiro;
	//private jogador jogador;
	
	
	public Peca() {
		
	}

	public Peca(String cor, int[] posicao,String letra, Campo tabuleiro) {
		this.cor = cor;
		this.posicao = posicao;
		this.Letra = letra;
		this.tabuleiro = tabuleiro;

	}




	public abstract int[][] movimentar(int[] posicoes,String cor) ;




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
	
	
	public String getLetra() {
		return this.Letra;
	}

	public Campo getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Campo tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	
	
	

}
