package br.com.dbe.cp2.controller;

import br.com.dbe.cp2.model.entity.itemPedido.DataItemPedido;
import br.com.dbe.cp2.model.entity.itemPedido.ItemPedido;
import br.com.dbe.cp2.model.repository.ItensPedidosRepository;
import br.com.dbe.cp2.service.ItensPedidoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens-pedidos")
public class ItensPedidosController {

    private ItensPedidoService itensPedidoService;

    @Autowired
    public ItensPedidosController(ItensPedidoService itensPedidoService) {
        this.itensPedidoService = itensPedidoService;
    }

    @PostMapping
    @Transactional
    public void criarItemPedido(@RequestBody @Valid DataItemPedido dataItemPedido) {
        System.out.println("DADOS CRIAR ITEM PEDIDO: " + dataItemPedido);
        itensPedidoService.criarItemPedido(dataItemPedido);
    }

    @GetMapping
    public List<ItemPedido> listarItensPedidos() {
//        return itensPedidoService.
        return null;
    }
}
