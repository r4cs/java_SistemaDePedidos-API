package br.com.dbe.cp2.model.entity.pedido;

import br.com.dbe.cp2.model.entity.itemPedido.ItemPedido;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DataPedido(
//        @NotNull
        Long id,
        @NotEmpty
        List<ItemPedido> itens_pedidos,
        @NotNull
        LocalDateTime dateTime
) {
}
