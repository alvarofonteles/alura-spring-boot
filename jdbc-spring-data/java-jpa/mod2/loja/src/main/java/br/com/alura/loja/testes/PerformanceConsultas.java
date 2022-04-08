package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class PerformanceConsultas {

	public static void main(String[] args) {
		popularBancoDeDados();
		EntityManager em = JPAUtil.getEntityManager();

		// Pedido pedido = em.find(Pedido.class, 1l);

		PedidoDao pedidoDao = new PedidoDao(em);
		Pedido pedido = pedidoDao.buscarPedidoComCliente(1l);

		ProdutoDao produtoDao = new ProdutoDao(em);
		// List<Produto> list = produtoDao.buscarPorParametros("Geladeira", null, null);

		List<Produto> list = produtoDao.buscarPorParametrosComCriteria("Geladeira", null, LocalDate.now());

		list.forEach(p -> {
			System.out.println(p.getNome() + " - " + p.getPreco() + " - " + p.getDataCadastro());
		});

		em.close();

		// Mesmo fechado ainda tem o valor
		// System.out.println(pedido.getCliente().getDadosPessoa().getNome());
		// System.out.println(pedido.getCliente().getNome());
	}

	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");
		Categoria eletros = new Categoria("ELETRODOMÉSTICOS");

		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
		Produto eletro = new Produto("Geladeira", "Geladeira Invertida", new BigDecimal("3800"), celulares);

		Cliente cliente = new Cliente("Jane Fonteles", "98765432199");

		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, celular));
		pedido.adicionarItem(new ItemPedido(15, pedido, eletro));

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		PedidoDao pedidoDao = new PedidoDao(em);

		em.getTransaction().begin();

		categoriaDao.cadastrar(celulares);
		categoriaDao.cadastrar(eletros);

		produtoDao.cadastrar(celular);
		produtoDao.cadastrar(eletro);

		clienteDao.cadastrar(cliente);

		pedidoDao.cadastrar(pedido);

		em.getTransaction().commit();
		em.close();
	}

}
