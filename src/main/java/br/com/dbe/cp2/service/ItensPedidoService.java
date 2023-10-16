package br.com.dbe.cp2.service;

import br.com.dbe.cp2.model.entity.itemPedido.DataItemPedido;
import br.com.dbe.cp2.model.entity.itemPedido.ItemPedido;
import br.com.dbe.cp2.model.repository.ItensPedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItensPedidoService {

    private ItensPedidosRepository itensPedidosRepository;

    public ItensPedidoService(ItensPedidosRepository itensPedidosRepository) {
        this.itensPedidosRepository = itensPedidosRepository;
    }

    public void ItemPedidoService(@Autowired ItensPedidosRepository itensPedidosRepository) {
        this.itensPedidosRepository = itensPedidosRepository;
    }

    public ItemPedido criarItemPedido(DataItemPedido dataItemPedido) {
        ItemPedido itemPedido = new ItemPedido(dataItemPedido);
        return itensPedidosRepository.save(itemPedido);
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

