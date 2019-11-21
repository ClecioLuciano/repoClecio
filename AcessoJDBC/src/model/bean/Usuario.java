package model.bean;

public class Usuario {

	private int ID;
	private String nome;
	
	public Usuario() {}
	
	public Usuario(int ID, String nome) {
		this.ID = ID;
		this.nome = nome;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Usuario [ID=" + ID + ", nome=" + nome + "]";
	}	
	
	

}
