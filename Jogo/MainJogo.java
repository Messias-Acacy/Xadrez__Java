package Jogo;
import Jogador.*;

public class MainJogo {

	public static void main(String[] args) {
		Jogo jogo = new Jogo(new Jogador("Messias",CorPeca.BRANCA), new Jogador("André",CorPeca.PRETA));
		jogo.BuildGame();
		jogo.CheckJogadores();
		while(true) {
		jogo.PrintTable();
		jogo.JogarTurno();
		//corrigir o check jogadores para fazer sentido. Se um escolhe umacor valida, n tem pq o outro escolher am sm KKKKK
		

	}

}
	
}
