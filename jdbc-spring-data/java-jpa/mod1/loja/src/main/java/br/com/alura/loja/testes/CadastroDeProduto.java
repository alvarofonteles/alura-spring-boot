package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		cadastrarProduto();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);

		Produto p = produtoDao.buscarPorId(1l);
		System.out.println("buscarPorId() - Preço: " + p.getPreco());
		
		List<Produto> todos2 = produtoDao.buscarTodos();
		todos2.forEach(p2 -> System.out.println("buscarTodos() - Todos Produto: " + p2.getNome()));
		
		List<Produto> todos3 = produtoDao.buscarPorNome("Xiaomi Redmi");
	    todos3.forEach(p3 -> System.out.println("buscarPorNome() - Produto: " + p3.getNome()));
		
	    List<Produto> todos4 = produtoDao.buscarPorNomeDaCategoria("CELULARES");
	    todos4.forEach(p4 -> System.out.println("buscarPorNomeDaCategoria() - Categoria: " + p4.getCategoria().getNome()));
	    
		//todos.stream().forEach(p2 -> System.out.println(p2.getNome()));
		//todos.stream().forEach(System.out::println);
	    
	    BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("Xiaomi Redmi");
	    System.out.println("Preco do Produto: " + precoDoProduto);
	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
		
		Categoria relogios = new Categoria("RELOGIOS");
		Produto relogio = new Produto("Samsung Activ 2", "Muito legal", new BigDecimal("1600"), relogios);

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		em.getTransaction().begin();

		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		
		categoriaDao.cadastrar(relogios);
		produtoDao.cadastrar(relogio);

		em.getTransaction().commit();
		em.close();
	}
}
