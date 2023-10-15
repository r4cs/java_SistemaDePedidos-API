package br.com.dbe.cp2.model.entity.itemPedido;

import br.com.dbe.cp2.model.entity.pedido.Pedido;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
public record DataItemPedido(
//        @NotNull
        Long id,
        @NotEmpty
        String nome,
        @NotEmpty
        Double preco,
        @NotEmpty
        Integer estoque,
        @NotEmpty
        Integer qtde,
        Pedido pedido
) {
        public DataItemPedido(ItemPedido itemPedido) {
                this(
                        itemPedido.getId(),
                        itemPedido.getNome(),
                        itemPedido.getPreco(),
                        itemPedido.getEstoque(),
                        itemPedido.getQtde(),
                        itemPedido.getPedido()
                );
        }
}
