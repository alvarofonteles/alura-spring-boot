package br.com.alura.loja.modelo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Embedded
	private DadosPessoais dadosPessoa;

	public Cliente() {
	}

	public Cliente(String nome, String cpf) {
		this.dadosPessoa = new DadosPessoais(nome, cpf);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DadosPessoais getDadosPessoa() {
		return dadosPessoa;
	}

	public String getNome() {
		return this.dadosPessoa.getNome();
	}

	public String getCpf() {
		return this.dadosPessoa.getCpf();
	}

}
