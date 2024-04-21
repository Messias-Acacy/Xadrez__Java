package Pecas;
import Jogador.Jogador;
import Jogo.Jogo;
public class MainPeca {

	public static void main(String[] args) {
		
		Jogo j = new Jogo(new Jogador("Messias"), new Jogador("j"));
		// TODO Auto-generated method stub
		Peao p = new Peao("azul",new int[]{1,2},"p",new int[] {6,0},j.getTabuleiro());
		p.movimentar(new int[] {7,0}, "branco");
		p.setCor("verde");
		System.out.println(p.getCor());
		
		
		
		

	}

}
