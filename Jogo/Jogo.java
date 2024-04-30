package Jogo;

import java.util.Scanner;
import Jogador.*;
import Tabuleiro.Campo;
import Pecas.*;


public class Jogo {
	private Campo tabuleiro;
	private Peca[][] pecas;
	Jogador jogadores[] = new Jogador[2];
	private Scanner sr;
	private boolean isGameFeito;
	private boolean isJogadoresChecados;
	private Jogador jogadorAtual;
	private int turnoAtual;
	private boolean isJogando;
	
	{
		System.out.println("Um Jogo foi instanciado");
	}
	



	public Jogo(Jogador J1, Jogador J2) { // ok	
		this.pecas = new Peca[8][8];
		this.jogadores[0] = J1;
		this.jogadores[1] = J2;
		this.sr = new Scanner(System.in);
		this.isGameFeito = false;
		this.isJogadoresChecados=false;
		this.turnoAtual = 1;
		this.isJogando = false;
	}
	
	public void CheckJogadores() { // ok
		
		if(jogadores[0].getCorPeca() == jogadores[1].getCorPeca()) {
			System.out.println("-=-=-=-=-=-=-");
			System.out.println("Os jogadores estão controlando a mesma peça!");
			System.out.println("Digite o nome de quem vai começar primeiro -> ");
			String nome = sr.next();
			
			while(!nome.equals(jogadores[0].getNome()) && !nome.equals(jogadores[1].getNome())) {
				System.out.println("============");
				System.out.println("Digite exatamente o mesmo nome dos jogadores!");
				System.out.println("Lista de jogadores: \n"+jogadores[0].getNome()+"\n"+jogadores[1].getNome());
				System.out.print("Digite um nome válido:->");
				nome = sr.next();
				System.out.println("_________");
			}
			
		}
		

		if(jogadores[0].getCorPeca() == CorPeca.BRANCA) {
			this.setJogadorAtual(jogadores[0]);
			jogadores[0].setCorPeca(CorPeca.BRANCA);
			jogadores[1].setCorPeca(CorPeca.PRETA);
		}
		else {
			this.setJogadorAtual(jogadores[1]);
			jogadores[0].setCorPeca(CorPeca.PRETA);
			jogadores[1].setCorPeca(CorPeca.BRANCA);
		}
		
		this.setJogadoresChecados(true);
		System.out.println("Jogadores checados!");
		System.out.println();
		
		
		
			
		}
	
	

	

	public void JogarTurno() {
		
		int[] posi = this.getJogadorAtual().SelecionarPeca();
		
		while(this.getTabuleiro().getPecas()[posi[0]][posi[1]] == null) {
			System.out.print("Você selecionou uma área inválida! Digite de novo: ");
			posi = this.getJogadorAtual().SelecionarPeca();
		}
		
		if(this.getJogadores()[0].equals(this.getJogadorAtual()) ) {
			while(!this.getTabuleiro().getPecas()[posi[0]][posi[1]].getCor().equals(this.getJogadorAtual().getCorPeca())) {
				System.out.print("Você só  pode controlar as peças "+ this.getJogadorAtual().getCorPeca() +"s Escolha outra posição: ");
				posi = this.getJogadorAtual().SelecionarPeca();
				while(this.getTabuleiro().getPecas()[posi[0]][posi[1]] == null) {
					System.out.print("Você selecionou uma área inválida! Digite de novo: ");
					posi = this.getJogadorAtual().SelecionarPeca();
				}
			
			}

			this.getJogadorAtual().MovimentarPeca(this.getTabuleiro(),posi);
			this.setJogadorAtual(this.getJogadores()[1]);
		}
		else {
			
			while(!this.getTabuleiro().getPecas()[posi[0]][posi[1]].getCor().equals(this.getJogadorAtual().getCorPeca())) {
				System.out.print("Você só  pode controlar as peças "+ this.getJogadorAtual().getCorPeca() +"s Escolha outra posição: ");
				posi = this.getJogadorAtual().SelecionarPeca();
				while(this.getTabuleiro().getPecas()[posi[0]][posi[1]] == null) {
					System.out.print("Você selecionou uma área inválida! Digite de novo: ");
					posi = this.getJogadorAtual().SelecionarPeca();
				}
			}
			this.getJogadorAtual().MovimentarPeca(this.getTabuleiro(),posi);
			this.setJogadorAtual(this.getJogadores()[0]);
		}
		
		this.setTurnoAtual(getTurnoAtual()+1);
		
	}
	

		
	public void BuildGame() { // ok
		
		this.tabuleiro = new Campo();
		for(int x =0;x < pecas.length;x++) {
			this.getPecas()[1][x] = new Peao(CorPeca.PRETA,new int[] {1,x},"\u001B[32m"+"P"+"\u001B[0m",new int[] {1,x},this.getTabuleiro());
			this.getPecas()[6][x] = new Peao(CorPeca.BRANCA,new int[] {6,x},"p",new int[] {6,x},this.getTabuleiro());
			for(int y =0;y < this.getPecas()[x].length;y++) {
				if(x >=2 && x <=5) { this.getPecas()[x][y] = null; }
			}
		}
		this.getPecas()[0][0] = new Torre(CorPeca.PRETA,new int[] {0,0},"\u001B[32m"+"T"+"\u001B[0m",this.getTabuleiro());
		this.getPecas()[0][7] = new Torre(CorPeca.PRETA,new int[] {0,7},"\u001B[32m"+"T"+"\u001B[0m",this.getTabuleiro());
		this.getPecas()[0][1] = new Cavalo(CorPeca.PRETA,new int[] {0,1},"\u001B[32m"+"C"+"\u001B[0m",this.getTabuleiro());
		this.getPecas()[0][6] = new Cavalo(CorPeca.PRETA,new int[] {0,6},"\u001B[32m"+"C"+"\u001B[0m",this.getTabuleiro());
		this.getPecas()[0][2] = new Bispo(CorPeca.PRETA,new int[] {0,2},"\u001B[32m"+"B"+"\u001B[0m",this.getTabuleiro());
		this.getPecas()[0][5] = new Bispo(CorPeca.PRETA,new int[] {0,5},"\u001B[32m"+"B"+"\u001B[0m",this.getTabuleiro());
		this.getPecas()[0][3] = new Rei(CorPeca.PRETA,new int[] {0,3},"\u001B[32m"+"R"+"\u001B[0m",this.getTabuleiro());
		this.getPecas()[0][4] = new Dama(CorPeca.PRETA,new int[] {0,4},"\u001B[32m"+"D"+"\u001B[0m",this.getTabuleiro());
		this.getPecas()[7][0] = new Torre(CorPeca.BRANCA,new int[] {7,0},"t",this.getTabuleiro());
		this.getPecas()[7][7] = new Torre(CorPeca.BRANCA,new int[] {7,7},"t",this.getTabuleiro());
		this.getPecas()[7][1] = new Cavalo(CorPeca.BRANCA,new int[] {7,1},"c",this.getTabuleiro());
		this.getPecas()[7][6] = new Cavalo(CorPeca.BRANCA,new int[] {7,6},"c",this.getTabuleiro());
		this.getPecas()[7][2] = new Bispo(CorPeca.BRANCA,new int[] {7,2},"b",this.getTabuleiro());
		this.getPecas()[7][5] = new Bispo(CorPeca.BRANCA,new int[] {7,5},"b",this.getTabuleiro());
		this.getPecas()[7][3] = new Rei(CorPeca.BRANCA,new int[] {7,3},"r",this.getTabuleiro());
		this.getPecas()[7][4] = new Dama(CorPeca.BRANCA,new int[] {7,4},"d",this.getTabuleiro());
		this.getTabuleiro().MontarTabuleiro(this.getPecas());
	}


	

	public void PrintTable() {
		this.getTabuleiro().MostrarTabuleiro(this.getTurnoAtual(), this.getJogadorAtual().getNome(), this.getJogadorAtual().getCorPeca());
		
	}
	

	public Peca[][] getPecas() {
		return pecas;
	}


	public Campo getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Campo tabuleiro) {
		this.tabuleiro = tabuleiro;
	}


	public Jogador[] getJogadores() {
		return jogadores;
	}


	public void setJogadores(Jogador[] jogadores) {
		this.jogadores = jogadores;
	}

	

	public Scanner getSr() {
		return sr;
	}


	public boolean isGameFeito() {
		return isGameFeito;
	}


	public void setGameFeito(boolean isGameFeito) {
		this.isGameFeito = isGameFeito;
	}


	public void setPecas(Peca[][] pecas) {
		this.pecas = pecas;
	}


	public boolean isJogadoresChecados() {
		return isJogadoresChecados;
	}


	public void setJogadoresChecados(boolean isJogadoresChecados) {
		this.isJogadoresChecados = isJogadoresChecados;
	}

	public Jogador getJogadorAtual() {
		return jogadorAtual;
	}

	public void setJogadorAtual(Jogador jogadorAtual) {
		this.jogadorAtual = jogadorAtual;
	}

	public int getTurnoAtual() {
		return turnoAtual;
	}

	private void setTurnoAtual(int turnoAtual) {
		this.turnoAtual = turnoAtual;
	}

	public boolean isJogando() {
		return isJogando;
	}

	public void setJogando(boolean isJogando) {
		this.isJogando = isJogando;
	}

	
	


}
