package br.inatel.labs.labjpa.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class NotaCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Fornecedor fornecedor;

    @NotNull
    private LocalDate dataEmissao;

    @OneToMany(mappedBy = "notaCompra")
    private List<NotaCompraItem> listaNotaCompraItem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NotaCompra)) return false;
        NotaCompra that = (NotaCompra) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public BigDecimal getCalculoTotalNota() {
        BigDecimal total = this.listaNotaCompraItem.stream()
                .map( i -> i.getCalculoTotalItem() )
                .reduce( BigDecimal.ZERO, BigDecimal::add);
        return total;
    }
}
