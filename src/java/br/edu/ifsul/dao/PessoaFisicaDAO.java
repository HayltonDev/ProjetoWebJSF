package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.PessoaFisica;
import java.io.Serializable;

/**
 *
 * @author Haylton
 */
public class PessoaFisicaDAO<T> extends DAOGenerico<PessoaFisica> implements Serializable{

    public PessoaFisicaDAO() {
        super(); //tenho que iniciar o construtor do pai, que é DAOGenerico
        classePersistente = PessoaFisica.class; //tá assim pq assim eu posso indicar qual é classe persistente. e eu acessei classePersistente pq é protect de  DAOGnerico
        ordem = "nome";
    }
    
    
}
