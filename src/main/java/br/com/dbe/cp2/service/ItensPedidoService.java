package br.com.dbe.cp2.service;

import br.com.dbe.cp2.model.entity.itemPedido.DataItemPedido;
import br.com.dbe.cp2.model.entity.itemPedido.ItemPedido;
import br.com.dbe.cp2.model.entity.pedido.Pedido;
import br.com.dbe.cp2.model.entity.produto.Produto;
import br.com.dbe.cp2.model.repository.ItensPedidosRepository;
import br.com.dbe.cp2.model.repository.PedidoRepository;
import br.com.dbe.cp2.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItensPedidoService {

    private ItensPedidosRepository itensPedidosRepository;
    private ProdutoRepository produtoRepository;
    private PedidoRepository pedidoRepository;
    public ItensPedidoService(ItensPedidosRepository itensPedidosRepository) {
        this.itensPedidosRepository = itensPedidosRepository;
    }

    @Autowired
    public ItensPedidoService(
            ItensPedidosRepository itensPedidosRepository,
            ProdutoRepository produtoRepository,
            PedidoRepository pedidoRepository) {
        this.itensPedidosRepository = itensPedidosRepository;
        this.produtoRepository = produtoRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public void criarItemPedido(DataItemPedido dataItemPedido) {
        Pedido pedido = pedidoRepository.getReferenceById(dataItemPedido.pedido().getId());
        System.out.println("pedido: " + pedido);
        Produto produto = produtoRepository.getReferenceById(dataItemPedido.produto().getId());
        System.out.println("produto: " + produto);

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);
        itemPedido.setQtde(dataItemPedido.qtde());


        itensPedidosRepository.save(itemPedido);
        System.out.println("Item pedido: " + itemPedido);
    }

    public List<ItemPedido> listarItensPedidos() {
        return itensPedidosRepository.findAll();
    }

    public Optional<ItemPedido> getItemPedidoById(Long id) {
        return itensPedidosRepository.findById(id);
    }

    // Method to update the stock of the product in the order
    private void atualizarEstoque(ItemPedido itemPedido) {
        // Fetch the product from your product repository or service based on itemPedido.getId() or other identifier.
        // Update the product's stock by subtracting the quantity ordered.
        // Save the updated product back to the database or update it in your product repository.
        // Example (Assuming you have a ProductRepository or ProductService):
//         Product product = productRepository.findById(itemPedido.getId()).orElse(null);
//         if (itemPedido != null) {
//             int newStock = product.getEstoque() - itemPedido.getQtde();
//             product.setEstoque(newStock);
//             productRepository.save(product);
//         }
    }

    public void deleteItemPedido(Long id) {
        itensPedidosRepository.deleteById(id);
    }
}

