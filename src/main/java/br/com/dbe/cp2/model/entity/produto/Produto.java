package br.com.dbe.cp2.model.entity.produto;

import jakarta.persistence.*;

@Entity(name="produto")
@Table(name="produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "produto_id_seq")
    private Long id;

    private Long estoque;

    private String nome;

    public Produto(DataProduto dataProduto) {
        this.id = dataProduto.id();
        this.estoque = dataProduto.estoque();
        this.nome = dataProduto.nome();
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

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", stock=" + estoque +
                ", nome='" + nome + '\'' +
                '}';
    }
}
