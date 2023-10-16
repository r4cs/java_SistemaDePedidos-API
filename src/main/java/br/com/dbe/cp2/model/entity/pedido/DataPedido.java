package br.com.dbe.cp2.model.entity.pedido;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DataPedido(
//        @NotNull
        Long id,
        @NotNull
        LocalDateTime dateTime
) {
        public DataPedido(Pedido pedido) {
                this(
                        pedido.getId(),
                        pedido.getDate_time()
                );
        }
}
