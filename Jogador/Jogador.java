package Jogador;


import java.util.Scanner;
@SuppressWarnings("unused")
public class Jogador {
	private String nome;
	private String controlePeca;
	private boolean isMeuTurno;
	private boolean isRookieFeito;

	
	
	
	public Jogador(String nome, String controlePeca) {
		this.nome = nome;
		this.setControlePeca(controlePeca);
		this.isMeuTurno = false;
		this.isRookieFeito = false;
	}
	



	public boolean isRookieFeito() {
		return isRookieFeito;
	}






	public void setRookieFeito(boolean isRookieFeito) {
		this.isRookieFeito = isRookieFeito;
	}






	public boolean isMeuTurno() {
		return isMeuTurno;
	}



	public void setMeuTurno(boolean isMeuTurno) {
		this.isMeuTurno = isMeuTurno;
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
