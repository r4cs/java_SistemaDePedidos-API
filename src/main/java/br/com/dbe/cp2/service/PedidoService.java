package br.com.dbe.cp2.service;

import br.com.dbe.cp2.model.entity.pedido.DataPedido;
import br.com.dbe.cp2.model.entity.pedido.Pedido;
import br.com.dbe.cp2.model.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(@Autowired PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido criarPedido(DataPedido dataPedido) {
        Pedido pedido = new Pedido(dataPedido);
//        pedido.getProdutos().forEach(itemPedido -> itemPedido.setPedido(pedido)); // Estabeleça a relação
        return pedidoRepository.save(pedido);
    }


    public List<Pedido> listPedidos() {
        // paginacao entra aqui!!
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> getPedidoById(Long id) {
        return pedidoRepository.findById(id);
//                .orElseThrow(() -> new PedidoNotFoundException(id);
    }

    public Pedido updatePedido(Long id, Pedido updatedPedido) {
        Optional<Pedido> prev_pedido = pedidoRepository.findById(id);

        if (prev_pedido.isPresent()) {
            Pedido pedido = prev_pedido.get();
            pedido.setDate_time(updatedPedido.getDate_time());

            Pedido updatedRepositoryPedido = pedidoRepository.save(pedido);

            return updatedRepositoryPedido;
        } else {
//            throw  new PedidoNotFoundException(id);
            System.out.println("criar classe PedidoNotFoundException" );
            return null;
        }
    }

    public void deletePedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
