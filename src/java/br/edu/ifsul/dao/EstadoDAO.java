package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Estado;
import java.io.Serializable;

/**
 *
 * @author Haylton
 */
public class EstadoDAO<T> extends DAOGenerico<Estado> implements Serializable{

    public EstadoDAO() {
        super(); //tenho que iniciar o construtor do pai, que é DAOGenerico
        classePersistente = Estado.class; //tá assim pq assim eu posso indicar qual é classe persistente. e eu acessei classePersistente pq é protect de  DAOGnerico
        ordem = "nome";
    }
    
    
}
