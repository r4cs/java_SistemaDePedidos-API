package br.com.dbe.cp2.model.repository;

import br.com.dbe.cp2.model.entity.itemPedido.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedidosRepository extends JpaRepository<ItemPedido, Long> {
}
