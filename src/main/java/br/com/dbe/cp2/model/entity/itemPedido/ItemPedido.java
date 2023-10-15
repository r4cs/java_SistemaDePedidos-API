package br.com.dbe.cp2.model.entity.itemPedido;

import br.com.dbe.cp2.model.entity.pedido.Pedido;

import jakarta.persistence.*;

@Entity(name="item_pedido")
@Table(name="item_pedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "item_pedido_id_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
//    private Pedido pedido = new Pedido();
    private Integer qtde;
    private String nome;
    private Double preco;
    private Integer estoque;

    public ItemPedido() {
    }

    public ItemPedido(DataItemPedido data) {
        this.id = data.id();
        this.nome = data.nome();
        this.estoque = data.estoque();
        this.preco = data.preco();
        this.qtde = data.qtde();
        this.pedido = data.pedido();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQtde() {
        return qtde;
    }

    public void setQtde(Integer qtde) {
        this.qtde = qtde;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "id=" + id +
                ", pedido=" + pedido +
                ", qtde=" + qtde +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", estoque=" + estoque +
                '}';
    }
}
