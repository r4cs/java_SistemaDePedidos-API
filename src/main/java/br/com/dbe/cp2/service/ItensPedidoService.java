package br.com.dbe.cp2.service;

import br.com.dbe.cp2.model.entity.itemPedido.ItemPedido;
import br.com.dbe.cp2.model.repository.ItensPedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItensPedidoService {

    private ItensPedidosRepository itensPedidosRepository;

    public ItensPedidoService(ItensPedidosRepository itensPedidosRepository) {
        this.itensPedidosRepository = itensPedidosRepository;
    }

    public void ItemPedidoService(@Autowired ItensPedidosRepository itensPedidosRepository) {
        this.itensPedidosRepository = itensPedidosRepository;
    }

    public ItemPedido criarItemPedido(ItemPedido itemPedido) {
        // Save the itemPedido to the database
        ItemPedido savedItemPedido = itensPedidosRepository.save(itemPedido);

        // Update the stock of the product in the order
        atualizarEstoque(itemPedido);

        return savedItemPedido;
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
}

