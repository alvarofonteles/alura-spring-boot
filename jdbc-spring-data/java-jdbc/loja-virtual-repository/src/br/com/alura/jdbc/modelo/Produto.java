package br.com.alura.jdbc.modelo;

public class Produto {

	public Produto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public Produto(Integer id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	private Integer id;
	private String nome;
	private String descricao;
	private Integer cagtegoriaId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCagtegoria_id() {
		return cagtegoriaId;
	}

	public void setCategoriaId(Integer cagtegoria_id) {
		this.cagtegoriaId = cagtegoria_id;
	}

	@Override
	public String toString() {
		return String.format("O Produto criado é: %d, %s, %s", this.id, this.nome, this.descricao);
	}

}
