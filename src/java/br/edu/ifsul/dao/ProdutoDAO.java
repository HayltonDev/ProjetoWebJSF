package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Produto;
import java.io.Serializable;

/**
 *
 * @author Haylton
 */
public class ProdutoDAO<T> extends DAOGenerico<Produto> implements Serializable{

    public ProdutoDAO() {
        super(); //tenho que iniciar o construtor do pai, que é DAOGenerico
        classePersistente = Produto.class; //tá assim pq assim eu posso indicar qual é classe persistente. e eu acessei classePersistente pq é protect de  DAOGnerico
        ordem = "nome";
    }
    
    
}
