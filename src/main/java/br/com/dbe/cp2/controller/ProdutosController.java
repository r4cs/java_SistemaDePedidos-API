package br.com.dbe.cp2.controller;

import br.com.dbe.cp2.model.entity.produto.DataProduto;
import br.com.dbe.cp2.model.entity.produto.Produto;
import br.com.dbe.cp2.service.ProdutoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutosController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    @Transactional
    public void criarProduto(@RequestBody @Valid DataProduto dataProduto) {
        System.out.println("dados produto: " + dataProduto);
        produtoService.criarProduto(dataProduto);
    }

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listProdutos();
    }

    @GetMapping("/{id}")
    public Optional<Produto> obterProduto(@PathVariable Long id) {
        return produtoService.getProdutoById(id);
    }

    @PatchMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        return produtoService.updateProduto(id, produtoAtualizado);
    }
}
