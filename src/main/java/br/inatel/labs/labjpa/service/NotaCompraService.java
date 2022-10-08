package br.inatel.labs.labjpa.service;

import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class NotaCompraService {

    @PersistenceContext
    private EntityManager em;


    //Nota Compra ------------------------------------------------------------
    public NotaCompra salvarNotaCompra(NotaCompra notaCompra) {
        return em.merge(notaCompra);
    }

    public NotaCompra buscarNotaCompraPorId(Long id) {
        return em.find(NotaCompra.class, id);
    }

    public List<NotaCompra> listarNotaCompra() {
        List<NotaCompra> listaNotaCompra = em.createQuery("select n from NotaCompra n", NotaCompra.class).getResultList();
        return listaNotaCompra;
    }


    // Nota Compra Item ---------------------------------------------------------
    public NotaCompraItem salvarNotaCompraItem(NotaCompraItem notaCompraItem) {
        return em.merge(notaCompraItem);
    }

    public NotaCompraItem buscarNotaCompraItemPorId(Long id) {
        return em.find(NotaCompraItem.class, id);
    }

    public List<NotaCompraItem> listarNotaCompraItem() {
        List<NotaCompraItem> listaNotaCompraItem = em.createQuery("select n from NotaCompraItem n", NotaCompraItem.class).getResultList();
        return listaNotaCompraItem;
    }
}
