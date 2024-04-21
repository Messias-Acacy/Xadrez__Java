package Jogador;


import java.util.Scanner;
import Tabuleiro.Campo;
public class Jogador {
	private String nome;
	private String controlePeca;
	private boolean isRookieFeito;
	private Scanner sr;

	
	
	
	public Jogador(String nome) {
		this.nome = nome.toLowerCase();
		this.sr =  new Scanner(System.in);

		this.isRookieFeito = false;
	}
	
	
public int[] SelecionarPeca() {
		int posicaoX = -1;
		int posicaoY = -1;
		System.out.println();
		boolean isPrimeiroLoop = true;
		String getPosicao ="";
		
		do {
			if(!isPrimeiroLoop) {
				System.out.println("Você digitou uma posição inválida! digite outra vez: ");
				System.out.print("Digite a posicao[numberLine]: ");
				getPosicao = sr.next();
				
			}
			else {
				System.out.print("Digite a posicao[numberLine]: ");
				getPosicao = sr.next();
			}
			
		
		
		posicaoX = Integer.parseInt(getPosicao.substring(0,1))-1;
		String letra = getPosicao.substring(1).toLowerCase();
		
		String[]letras = {"a","b","c","d","e","f","g","h"};
		for (int i = 0; i < letras.length; i++) {
			if(letras[i].equals(letra)) {
				posicaoY = i;
				break;
			}
		}
		if(isPrimeiroLoop) {
			isPrimeiroLoop = false;
		}
		} while ((posicaoY < 0 || posicaoY >= 8) || (posicaoX < 0 || posicaoX >= 8));
		
		
		
		return new int[] {posicaoX,posicaoY};
	
	}
	
	
public void MovimentarPeca(Campo tabuleiro, int[] pos) {
	
	
	int[] posicoes =pos;
	
	while (tabuleiro.getPecas()[posicoes[0]][posicoes[1]] == null) {
		System.out.print("Você selecionou uma posição vazia! Digite outra vez: ");
		posicoes =this.SelecionarPeca();
		}
	
		int[] retorno = tabuleiro.getPecas()[posicoes[0]][posicoes[1]].movimentar(posicoes,getControlePeca())[0];
		System.out.println(retorno[0]+","+retorno[1]+" - <- Tá em jogador");
		//necessidade de poder mostrar na tela o array e dps fazer o jogador digitar a posição que ele
		//uqer jogar
		
		
	//Codigo funcional
	//int[] retorno = this.SelecionarPeca();
	tabuleiro.getPecas()[retorno[0]][retorno[1]] =tabuleiro.getPecas()[posicoes[0]][posicoes[1]];
	tabuleiro.getPecas()[posicoes[0]][posicoes[1]] = null;
	tabuleiro.getPecas()[retorno[0]][retorno[1]].setPosicao(new int[] {retorno[0],retorno[1]});

	
	}
	



	public boolean isRookieFeito() {
		return isRookieFeito;
	}






	public void setRookieFeito(boolean isRookieFeito) {
		this.isRookieFeito = isRookieFeito;
	}








	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getControlePeca() {
		return controlePeca;
	}



	public void setControlePeca(String controlePeca) {

			this.controlePeca = controlePeca;
			
		
		
	}
	
	




	


}
