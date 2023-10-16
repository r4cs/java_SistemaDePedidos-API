package br.com.dbe.cp2.model.entity.itemPedido;

import br.com.dbe.cp2.model.entity.pedido.Pedido;

import br.com.dbe.cp2.model.entity.produto.Produto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity(name="item_pedido")
@Table(name="item_pedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,
                                generator = "item_pedido_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name="produto_id",
//                referencedColumnName = "produto",
                foreignKey = @ForeignKey(name="FK_PRODUTO_ID"))
    private Produto produto;

    @ManyToOne
    @JoinColumn(name="pedido_id",
//                referencedColumnName = "pedido",
                foreignKey = @ForeignKey(name="FK_PEDIDO_ID"))
    private Pedido pedido;

    private Integer qtde;

    public ItemPedido() {
    }

    public ItemPedido(DataItemPedido data) {
        this.id = data.id();
        this.qtde = data.qtde();
        this.pedido = data.pedido();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public @NotNull Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Integer getQtde() {
        return qtde;
    }

    public void setQtde(Integer qtde) {
        this.qtde = qtde;
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "id=" + id +
                ", produto=" + produto +
                ", pedido=" + pedido +
                ", qtde=" + qtde +
                '}';
    }
}
