package br.com.dbe.cp2.model.repository;

import br.com.dbe.cp2.model.entity.pedido.DataPedido;
import br.com.dbe.cp2.model.entity.pedido.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository <Pedido, Long> {
//    Page<Pedido> findAllbyAtivoTrue(Pageable paginacao);
}
