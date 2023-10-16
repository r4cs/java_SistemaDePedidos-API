package br.com.dbe.cp2.model.repository;

import br.com.dbe.cp2.model.entity.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
