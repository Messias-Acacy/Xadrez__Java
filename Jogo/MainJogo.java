package Jogo;
import Jogador.*;

public class MainJogo {

	public static void main(String[] args) {
		Jogo jogo = new Jogo(new Jogador("Messias","preto"), new Jogador("josé","preto"));
		jogo.BuildGame();
		jogo.CheckJogadores();
		while(true) {
		jogo.PrintTable();
		jogo.movimentarPeca();}
		//System.out.println("\u001B[40m"+"-"+"\u001B[0m");
		//corrigir o check jogadores para fazer sentido. Se um escolhe umacor valida, n tem pq o outro escolher am sm KKKKK
		

	}

}