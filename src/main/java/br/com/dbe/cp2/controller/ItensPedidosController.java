package br.com.dbe.cp2.controller;

import br.com.dbe.cp2.model.entity.itemPedido.DataItemPedido;
import br.com.dbe.cp2.model.entity.itemPedido.ItemPedido;
import br.com.dbe.cp2.model.repository.ItensPedidosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItensPedidosController {

    private ItensPedidosRepository itensPedidosRepository;

//    @Autowired
//    public void criarItemPedido(@RequestBody @Valid DataItemPedido dataItemPedido) {
//        System.out.println("DADOS CRIAR ITEM PEDIDO: ");
//        itensPedidosRepository.save(new ItemPedido(dataItemPedido));
//    }
}
