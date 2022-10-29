package br.inatel.labs.labjpa.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
public class Produto {

    public Produto(String descricao) {
        this.descricao = descricao;
    }

    public Produto(Long id) {
        this.id = id;
    }

    public Produto() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String descricao;

    @ManyToMany(mappedBy = "listaProduto")
    private List<Fornecedor> listaFornecedor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public String getDescricao() {
        return descricao;
    }
}
