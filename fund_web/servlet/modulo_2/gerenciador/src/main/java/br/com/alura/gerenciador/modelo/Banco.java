package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	private static Integer chaveSequencial = 1;

	static {

		// Empresas
		Empresa empresa1 = new Empresa();
		empresa1.setNome("Hapvida");
		empresa1.setId(chaveSequencial++);

		Empresa empresa2 = new Empresa();
		empresa2.setNome("Unifor");
		empresa2.setId(chaveSequencial++);

		Empresa empresa3 = new Empresa();
		empresa3.setNome("Alura");
		empresa3.setId(chaveSequencial++);

		lista.add(empresa1);
		lista.add(empresa2);
		lista.add(empresa3);

		// Usuários
		Usuario usuario1 = new Usuario();
		usuario1.setLogin("alvarofonteles");
		usuario1.setSenha("123");

		Usuario usuario2 = new Usuario();
		usuario2.setLogin("janefonteles");
		usuario2.setSenha("456");

		// Administrador
		Usuario usuario3 = new Usuario();
		usuario3.setLogin("admin");
		usuario3.setSenha("admin");

		listaUsuarios.add(usuario1);
		listaUsuarios.add(usuario2);
		listaUsuarios.add(usuario3);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {

		Iterator<Empresa> it = lista.iterator();

		while (it.hasNext()) {
			Empresa empresa = it.next();

			if (empresa.getId() == id) {
				it.remove();
			}
		}

//		for (Empresa empresa : lista) {
//			if (empresa.getId() == id) {
//				Banco.lista.remove(empresa);
//			}
//		}
	}

	public Empresa buscaEmpresaPeloId(Integer id) {
		for (Empresa empresa : lista) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : listaUsuarios) {
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}

}
