package br.inatel.labs.labjpa;

import br.inatel.labs.labjpa.entity.Fornecedor;
import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;
import br.inatel.labs.labjpa.entity.Produto;
import br.inatel.labs.labjpa.service.FornecedorService;
import br.inatel.labs.labjpa.service.NotaCompraService;
import br.inatel.labs.labjpa.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//@SpringBootTest
class DataLoader {
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private FornecedorService fornecedorService;
	@Autowired
	private NotaCompraService notaCompraService;

	//@Test
	void load() {

		//1. criando produtos aleatórios
		Produto p1 = new Produto("Furadeira");
		Produto p2 = new Produto("Parafusadeira");
		Produto p3 = new Produto("Martelo");
		Produto p4 = new Produto("Chave de fenda");
		Produto p5 = new Produto("Chave de boca");

		//2. salvando os produtos no banco de dados
		p1 = produtoService.salvar(p1);
		p2 = produtoService.salvar(p2);
		p3 = produtoService.salvar(p3);
		p4 = produtoService.salvar(p4);
		p5 = produtoService.salvar(p5);

		List<Produto> lista = produtoService.listar();
		lista.forEach(System.out::println);

		//3 - criando fornecedores aleatórios
		Fornecedor f1 = new Fornecedor("Gasometro Madeiras");
		Fornecedor f2 = new Fornecedor("Ferreira Ferramentas");

		//4 - salvando os fornecedores no banco de dados
		f1 = fornecedorService.salvar(f1);
		f2 = fornecedorService.salvar(f2);

		List<Fornecedor> listaFornecedor = fornecedorService.listar();
		listaFornecedor.forEach(System.out::println);

		//5 - criando notas de compra aleatórias
		NotaCompra n1 = new NotaCompra(f1, LocalDate.of(2020, 1, 1));
		NotaCompra n2 = new NotaCompra(f2, LocalDate.of(2020, 1, 2));

		//6 - salvando as notas de compra no banco de dados
		n1 = notaCompraService.salvarNotaCompra(n1);
		n2 = notaCompraService.salvarNotaCompra(n2);

		List<NotaCompra> listaNotaCompra = notaCompraService.listarNotaCompra();
		listaNotaCompra.forEach(System.out::println);

		//7 - Criando NotasCompraIten aleatórios
		//4. Nota Compra Item
		NotaCompraItem i1_1 = new NotaCompraItem(n1, p1, new BigDecimal("300.00"), 2);
		NotaCompraItem i1_2 = new NotaCompraItem(n1, p2, new BigDecimal("1000.00"), 1);
		NotaCompraItem i1_3 = new NotaCompraItem(n1, p3, new BigDecimal("500.00"), 3);
		i1_1 = notaCompraService.salvarNotaCompraItem(i1_1);
		i1_2 = notaCompraService.salvarNotaCompraItem(i1_2);
		i1_3 = notaCompraService.salvarNotaCompraItem(i1_3);

		NotaCompraItem i2_1 = new NotaCompraItem(n2, p4, new BigDecimal("400.00"), 7);
		NotaCompraItem i2_2 = new NotaCompraItem(n2, p2, new BigDecimal("1000.00"), 2);
		NotaCompraItem i2_3 = new NotaCompraItem(n2, p5, new BigDecimal("700.00"), 1);
		i2_1 = notaCompraService.salvarNotaCompraItem(i2_1);
		i2_2 = notaCompraService.salvarNotaCompraItem(i2_2);
		i2_3 = notaCompraService.salvarNotaCompraItem(i2_3);

		notaCompraService.listarNotaCompraItem().forEach( System.out::println );
	}

}
