package model.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="atividades")
public class Atividades {
	@Id
	@GeneratedValue
	@Column(name="id")
	protected long id;
	
	@Column(name="ramo")
	protected String ramo;
	
	@Column(name="categoria")
	protected String categoria;
	
	@Column(name="nome")
	protected String nome;
	
	@Column(name="minimo_de_Pessoas")
	protected String minPessoas;
	
	@Column(name="maximo_de_Pessoas")
	protected String maxPessoas;
	
	@Column(name="material")
	protected String material;
	
	@Column(name="descricao")
	protected String descricao;
	
	@Column(name="tempo")
	protected String tempo;
	
	@Column(name="fisico")
	protected boolean fisico;
	
	@Column(name="intelectual")
	protected boolean intelectual;
	
	@Column(name="afetivo")
	protected boolean afetivo;
	
	@Column(name="social")
	protected boolean social;
	
	@Column(name="espiritual")
	protected boolean espiritual;
	
	@Column(name="carater")
	protected boolean carater;
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(Object object) {
		this.categoria = (String) object;
	}
	public String getRamo() {
		return ramo;
	}
	public void setRamo(Object object) {
		this.ramo = (String) object;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMinPessoas() {
		return minPessoas;
	}
	public void setMinPessoas(Object object) {
		this.minPessoas = (String) object;
	}
	public String getMaxPessoas() {
		return maxPessoas;
	}
	public void setMaxPessoas(Object object) {
		this.maxPessoas = (String) object;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean getIntelectual() {
		return intelectual;
	}
	public void setIntelectual(boolean intelectual) {
		this.intelectual = intelectual;
	}
	public boolean getAfetivo() {
		return afetivo;
	}
	public void setAfetivo(boolean afetivo) {
		this.afetivo = afetivo;
	}
	public boolean getSocial() {
		return social;
	}
	public void setSocial(boolean social) {
		this.social = social;
	}
	public boolean getEspiritual() {
		return espiritual;
	}
	public void setEspiritual(boolean espiritual) {
		this.espiritual = espiritual;
	}
	public boolean getCarater() {
		return carater;
	}
	public void setCarater(boolean carater) {
		this.carater = carater;
	}
	public boolean getFisico() {
		return fisico;
	}
	public void setFisico(boolean fisico) {
		this.fisico = fisico;
	}
	public String getTempo() {
		return tempo;
	}
	public void setTempo(String tempo) {
		this.tempo = tempo;
	}
	
	
}
