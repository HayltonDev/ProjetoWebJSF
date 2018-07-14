package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Cidade;
import java.io.Serializable;

/**
 *
 * @author Haylton
 */
public class CidadeDAO<T> extends DAOGenerico<Cidade> implements Serializable{

    public CidadeDAO() {
        super(); //tenho que iniciar o construtor do pai, que é DAOGenerico
        classePersistente = Cidade.class; //tá assim pq assim eu posso indicar qual é classe persistente. e eu acessei classePersistente pq é protect de  DAOGnerico
        ordem = "nome";
    }
    
    
}
