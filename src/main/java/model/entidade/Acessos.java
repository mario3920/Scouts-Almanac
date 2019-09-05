package model.entidade;

public class Acessos {

	private String usuario;
	private int senha;
	private boolean logado = false;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String user) {
		this.usuario = user;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int pass) {
		this.senha = pass;
	}
	public boolean getLogado() {
		return logado;
	}
	public void setLogado(boolean log) {
		this.logado = log;
	}
}
