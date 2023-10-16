package br.com.dbe.cp2.model.entity.pedido;

import br.com.dbe.cp2.model.entity.itemPedido.ItemPedido;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name="pedido")
@Table(name="pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "pedido_seq")
    private Long id;

    private LocalDateTime date_time;

    @OneToMany(mappedBy = "pedido", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itensPedido = new ArrayList<>();


    public Pedido() {
    }

    public Pedido(DataPedido data) {
        this.id = data.id();
        this.date_time = data.dateTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public LocalDateTime getDate_time() {
        return date_time;
    }

    public void setDate_time(LocalDateTime dateTime) {
        this.date_time = dateTime;
    }

    @OneToMany(mappedBy = "pedido", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", dateTime=" + date_time +
                '}';
    }
}
