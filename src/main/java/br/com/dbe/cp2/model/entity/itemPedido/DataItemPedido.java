package br.com.dbe.cp2.model.entity.itemPedido;

import br.com.dbe.cp2.model.entity.pedido.Pedido;
import br.com.dbe.cp2.model.entity.produto.Produto;
import jakarta.validation.constraints.NotNull;

public record DataItemPedido(
//        @NotNull
        Long id,
        @NotNull
        Pedido pedido,
        @NotNull
        Produto produto,
        Integer qtde
) {
        public DataItemPedido(ItemPedido itemPedido) {
                this(
                        itemPedido.getId(),
                        itemPedido.getPedido(),
                        itemPedido.getProduto(),
                        itemPedido.getQtde()
                );
        }
}
