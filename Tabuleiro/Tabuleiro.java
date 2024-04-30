package Tabuleiro;


import Jogador.CorPeca;
import Pecas.Peca;

public interface Tabuleiro {

	public abstract void MontarTabuleiro( Peca[][] pecas);
	public abstract void MostrarTabuleiro(int contador,String nomeJogador,CorPeca corPeca);
	
}
 