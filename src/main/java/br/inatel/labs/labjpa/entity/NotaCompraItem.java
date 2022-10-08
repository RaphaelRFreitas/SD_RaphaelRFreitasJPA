package br.inatel.labs.labjpa.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class NotaCompraItem {

    public NotaCompraItem(NotaCompra notaCompra, Produto produto, BigDecimal valorCompraProduto, Integer quantidade) {
        this.valorCompraProduto = valorCompraProduto;
        this.quantidade = quantidade;
        this.notaCompra = notaCompra;
        this.produto = produto;
    }

    public NotaCompraItem() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private BigDecimal valorCompraProduto;

    @NotNull
    private Integer quantidade;

    @NotNull
    @ManyToOne
    private NotaCompra notaCompra;

    @NotNull
    @ManyToOne
    private Produto produto;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NotaCompraItem)) return false;
        NotaCompraItem that = (NotaCompraItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public BigDecimal getCalculoTotalItem() {
        return valorCompraProduto.multiply(BigDecimal.valueOf(quantidade));
    }

    @Override
    public String toString() {
        return "NotaCompraItem{" +
                "id=" + id +
                ", valorCompraProduto=" + valorCompraProduto +
                ", quantidade=" + quantidade +
                '}';
    }
}
