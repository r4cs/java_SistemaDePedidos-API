package br.com.dbe.cp2.service;

import br.com.dbe.cp2.model.entity.produto.DataProduto;
import br.com.dbe.cp2.model.entity.produto.Produto;
import br.com.dbe.cp2.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(@Autowired ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void criarProduto(DataProduto dataProduto) {
        Produto produto = new Produto(dataProduto);
        produtoRepository.save(produto);
    }

    public List<Produto> listProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> getProdutoById(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto updateProduto(Long id, Produto updatedProduto) {
        Optional<Produto> prev_prod = produtoRepository.findById(id);

        if (prev_prod.isPresent()) {
            Produto produto = prev_prod.get();
            produto.setId(id);
            produto.setNome(updatedProduto.getNome());
            produto.setEstoque(updatedProduto.getEstoque());
            produto.setPreco(updatedProduto.getPreco());

            Produto updatedRepositoryProduto = produtoRepository.save(produto);
            return updatedRepositoryProduto;
        } else {
            //            throw  new ProdutoNotFoundException(id);
            System.out.println("criar classe ProdutoNotFoundException" );
            return null;
        }
    }
    public void deleteProduto  (Long id) {
        produtoRepository.deleteById(id);
    }
}
