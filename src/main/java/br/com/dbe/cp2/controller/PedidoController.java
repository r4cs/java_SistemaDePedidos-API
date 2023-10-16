package br.com.dbe.cp2.controller;

import br.com.dbe.cp2.model.entity.pedido.DataPedido;
import br.com.dbe.cp2.model.entity.pedido.Pedido;
import br.com.dbe.cp2.service.PedidoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

  private final PedidoService pedidoService;

  @Autowired
  public PedidoController(PedidoService pedidoService) {
    this.pedidoService = pedidoService;
  }

  @PostMapping
  @Transactional
  public void criarPedido(@RequestBody @Valid DataPedido dataPedido) {
    System.out.println("dados: "+ dataPedido);
    pedidoService.criarPedido(dataPedido);
//    pedidoService.criarPedido(new Pedido(dataPedido));
  }

  @GetMapping // funciona
  public List<Pedido> listarPedidos() {
    return pedidoService.listPedidos();
  }

  @GetMapping("/{id}") // funciona
  public Optional<Pedido> obterPedido(@PathVariable Long id) {
    return pedidoService.getPedidoById(id);
  }

  @PatchMapping("/{id}")
  public Pedido atualizarPedido(@PathVariable Long id, @RequestBody Pedido pedidoAtualizado) {
    return pedidoService.updatePedido(id, pedidoAtualizado);
  }

  @DeleteMapping("/{id}")
  public void excluirPedido(@PathVariable Long id) {
    pedidoService.deletePedido(id);
  }
}
