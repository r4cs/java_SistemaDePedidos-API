package br.com.dbe.cp2.model.entity.produto;

public record DataProduto(
        Long id,
        Long estoque,
        String nome

) {
    public DataProduto(Produto produto) {
        this(
                produto.getId(),
                produto.getEstoque(),
                produto.getNome()
        );
    }
}
