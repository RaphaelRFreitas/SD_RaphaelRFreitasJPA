package br.inatel.labs.labjpa.service;

import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;
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

    public NotaCompra salvarNotaCompra(NotaCompra notaCompra){
        return em.merge(notaCompra);
    }

    public NotaCompraItem salvarNotaCompraItem(NotaCompraItem notaCompraItem){
        return em.merge(notaCompraItem);
    }

    public NotaCompra buscarNotaCompraPeloId(Long id){
        return em.find(NotaCompra.class,id);
    }

    public NotaCompra buscarNotaCompraPeloIdComListaDeItens(Long id){
        NotaCompra nota = em.find(NotaCompra.class,id);
        nota.getListaNotaCompraItem().size();
        return nota;
    }

    public NotaCompraItem buscarNotaCompraItemPeloId(Long id){
        return em.find(NotaCompraItem.class,id);
    }

    public List<NotaCompra> listarNotaCompra(){
        return em.createQuery("select p from Produto p", NotaCompra.class).getResultList();
    }

    public List<NotaCompraItem> listarNotaCompraItem(){
        return em.createQuery("select p from Produto p", NotaCompraItem.class).getResultList();
    }

}
