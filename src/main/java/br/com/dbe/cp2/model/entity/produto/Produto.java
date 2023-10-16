package br.com.dbe.cp2.model.entity.produto;

import br.com.dbe.cp2.model.entity.itemPedido.ItemPedido;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name="produto")
@Table(name="produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "produto_seq")
    private Long id;

    private String nome;
    private Long estoque;
    private Double preco;

    @OneToMany(mappedBy = "produto", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<ItemPedido> itensPedido = new ArrayList<>();


    public Produto(DataProduto dataProduto) {
        this.id = dataProduto.id();
        this.estoque = dataProduto.estoque();
        this.nome = dataProduto.nome();
        this.preco = dataProduto.preco();
    }

    public Produto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEstoque() {
        return estoque;
    }

    public void setEstoque(Long stock) {
        this.estoque = stock;
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

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", estoque=" + estoque +
                ", preco=" + preco +
                '}';
    }
}
