package br.com.dbe.cp2.model.entity.pedido;

import br.com.dbe.cp2.model.entity.itemPedido.DataItemPedido;
import br.com.dbe.cp2.model.entity.itemPedido.ItemPedido;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name="pedido")
@Table(name="pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "pedido_seq")
    private Long id;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
//    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> itens_pedidos = new ArrayList<>();

    private LocalDateTime date_time;


    public Pedido() {
    }

    public Pedido(DataPedido data) {
        this.id = data.id();
        this.itens_pedidos = data.itens_pedidos();
        this.date_time = data.dateTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemPedido> getProdutos() {
        return itens_pedidos;
    }

    public void setProdutos(List<ItemPedido> itens_pedidos) {
        this.itens_pedidos = itens_pedidos;
    }

    public LocalDateTime getDate_time() {
        return date_time;
    }

    public void setDate_time(LocalDateTime dateTime) {
        this.date_time = dateTime;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", itens_pedidos=" + itens_pedidos +
                ", dateTime=" + date_time +
                '}';
    }
}
