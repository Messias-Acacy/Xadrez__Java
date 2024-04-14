package Jogo;

import java.util.Scanner;
import Jogador.Jogador;
import Tabuleiro.Campo;
import Pecas.*;

public class Jogo {
	private Campo tabuleiro;
	private Peca[][] pecas;
	Jogador jogadores[] = new Jogador[2];
	String jogadorAtual;
	private Scanner sr;
	private boolean isGameFeito;
	private boolean isJogadoresChecados;


	public Jogo(Jogador J1, Jogador J2) { // ok	
		this.pecas = new Peca[8][8];
		this.jogadores[0] = J1;
		this.jogadores[1] = J2;
		this.sr = new Scanner(System.in);
		this.isGameFeito = false;
		this.isJogadoresChecados=false;
	}
	
	public void CheckJogadores() { // ok
		
		while((!(this.getJogadores()[0].getControlePeca().equals("branco")) && !(this.getJogadores()[0].getControlePeca().equals("preto"))) && (!(this.getJogadores()[1].getControlePeca().equals("branco")) &&!(this.getJogadores()[1].getControlePeca().equals("preto")))) {
			
			
			while(!(this.getJogadores()[0].getControlePeca().equals("branco")) && !(this.getJogadores()[0].getControlePeca().equals("preto"))) {
				System.out.println("O jogador: "+this.getJogadores()[0].getNome()+" Está com um input inválido! ");
				System.out.print("Digite branco ou preto: ");
				this.getJogadores()[0].setControlePeca(sr.next());
			}
			System.out.println();
			
			while(!(this.getJogadores()[1].getControlePeca().equals("branco")) && !(this.getJogadores()[1].getControlePeca().equals("preto"))) {
				System.out.println("O jogador: "+this.getJogadores()[1].getNome()+" Está com um input inválido! ");
				System.out.print("Digite branco ou preto: ");
				this.getJogadores()[1].setControlePeca(sr.next());
			}
			System.out.println();
			
			while(this.getJogadores()[0].getControlePeca().equals(this.getJogadores()[1].getControlePeca())) {
				System.out.println("Os  jogadores estão controlando a mesma peça! ");
				System.out.println("(obs.: O Outro jogador vai adquirir a peça contrária)");
				System.out.print("Digite branco ou preto para o jogador "+this.getJogadores()[0].getNome()+" ->");
				this.getJogadores()[0].setControlePeca(sr.next());
				
				while (!(this.getJogadores()[0].getControlePeca().equals("branco")) && !(this.getJogadores()[0].getControlePeca().equals("preto")) ) {
					System.out.print("Digite branco ou preto para o jogador "+this.getJogadores()[0].getNome()+" ->");
					this.getJogadores()[0].setControlePeca(sr.next());
				}
				
				if(this.getJogadores()[0].getControlePeca().equals("branco")) {
					this.getJogadores()[1].setControlePeca("preto");
				}
				else{
					this.getJogadores()[1].setControlePeca("branco");
				}
				
				System.out.println();
				
				
				
				if(this.getJogadores()[0].getControlePeca().equals("branco")) {
					this.getJogadores()[0].setMeuTurno(true);
				}
				else {
					this.getJogadores()[1].setMeuTurno(true);
				}
				
			}
			
			
			
			
			
			
		}
		
		
	
		
		this.setJogadoresChecados(true);
		System.out.println("Jogadores checados!");
		System.out.println();
		
		
		
	}

		
	public void BuildGame() { // ok
		
		this.tabuleiro = new Campo();
		for(int x =0;x < pecas.length;x++) {
			this.getPecas()[1][x] = new Peao("Preto",new int[] {1,x},'P');
			this.getPecas()[6][x] = new Peao("Branco",new int[] {6,x},'p');
			for(int y =0;y < this.getPecas()[x].length;y++) {
				if(x >=2 && x <=5) { this.getPecas()[x][y] = null; }
			}
		}
		this.getPecas()[0][0] = new Torre("preto",new int[] {0,0},'T');
		this.getPecas()[0][7] = new Torre("preto",new int[] {0,7},'T');
		this.getPecas()[0][1] = new Cavalo("preto",new int[] {0,1},'C');
		this.getPecas()[0][6] = new Cavalo("preto",new int[] {0,6},'C');
		this.getPecas()[0][2] = new Bispo("preto",new int[] {0,2},'B');
		this.getPecas()[0][5] = new Bispo("preto",new int[] {0,5},'B');
		this.getPecas()[0][3] = new Rei("preto",new int[] {0,3},'R');
		this.getPecas()[0][4] = new Dama("preto",new int[] {0,4},'D');
		this.getPecas()[7][0] = new Torre("branco",new int[] {7,0},'t');
		this.getPecas()[7][7] = new Torre("branco",new int[] {7,7},'t');
		this.getPecas()[7][1] = new Cavalo("branco",new int[] {7,1},'c');
		this.getPecas()[7][6] = new Cavalo("branco",new int[] {7,6},'c');
		this.getPecas()[7][2] = new Bispo("branco",new int[] {7,2},'b');
		this.getPecas()[7][5] = new Bispo("branco",new int[] {7,5},'b');
		this.getPecas()[7][3] = new Rei("branco",new int[] {7,3},'r');
		this.getPecas()[7][4] = new Dama("branco",new int[] {7,4},'d');
		getTabuleiro().MontarTabuleiro(this.getPecas());
	}


	private int[] SelecionarPeca() {
		
		System.out.println();
		System.out.print("Digite a posicao[numberLine]: ");
		String getPosicao ="";
		getPosicao = sr.next();
		
		int posicaoX = Integer.parseInt(getPosicao.substring(0,1))-1;
		String letra = getPosicao.substring(1).toLowerCase();
		
		int posicaoY = -1;
		String[]letras = {"a","b","c","d","e","f","g","h"};
		for (int i = 0; i < letras.length; i++) {
			if(letras[i].equals(letra)) {
				posicaoY = i;
				break;
			}
		}
		
		return new int[] {posicaoX,posicaoY};
		

	}


	public void movimentarPeca() { //em desenvolvimento - estou usando uma versão provisória
		
		
		int[] posicoes =this.SelecionarPeca();
		
		while((posicoes[0] < 0 || posicoes[0] > 8) && (posicoes[1] < 0 || posicoes[1] > 8)) {
			System.out.print("você digitou uma posição que não existe! Digite outra vez: ");
			posicoes =this.SelecionarPeca();
		}
		while (this.getTabuleiro().getPecas()[posicoes[0]][posicoes[1]] == null) {
			System.out.print("Você selecionou uma posição vazia! Digite outra vez: ");
			posicoes =this.SelecionarPeca();
		}
		//int[] retorno = this.getTabuleiro().getPecas()[posicoes[0]][posicoes[1]].movimentar(posicoes[0],posicoes[1]);
		//imitando o retorno
		

		
		
		
		int[] retorno = this.SelecionarPeca();
		
		this.getTabuleiro().getPecas()[retorno[0]][retorno[1]] =getTabuleiro().getPecas()[posicoes[0]][posicoes[1]];
		getTabuleiro().getPecas()[posicoes[0]][posicoes[1]] = null;
		this.getTabuleiro().getPecas()[retorno[0]][retorno[1]].setPosicao(new int[] {retorno[0],retorno[1]});
	
	
	
	
		
	}
	

	public void PrintTable() {
		getTabuleiro().MostrarTabuleiro();
		
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

	
	public String getJogadorAtual() {
		return jogadorAtual;
	}


	public void setJogadorAtual(String jogadorAtual) {
		this.jogadorAtual = jogadorAtual;
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


}
