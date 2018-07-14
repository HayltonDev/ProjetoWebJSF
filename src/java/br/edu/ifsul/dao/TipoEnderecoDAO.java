package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.TipoEndereco;
import java.io.Serializable;

/**
 *
 * @author Haylton
 */
public class TipoEnderecoDAO<T> extends DAOGenerico<TipoEndereco> implements Serializable{

    public TipoEnderecoDAO() {
        super(); //tenho que iniciar o construtor do pai, que é DAOGenerico
        classePersistente = TipoEndereco.class; //tá assim pq assim eu posso indicar qual é classe persistente. e eu acessei classePersistente pq é protect de  DAOGnerico
        ordem = "descricao";
    }
    
    
}
