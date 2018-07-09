/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Pais;
import java.io.Serializable;

/**
 *
 * @author Haylton
 */
//DAO (Data access Object)uma classe que encapsula o acesso aos pela JPA
public class PaisDAO<T> extends DAOGenerico<Pais> implements Serializable{

    public PaisDAO() {
        super(); //chamo o contstrutor do pais (DAOGenerico<Pais>) para inicializar a entityManager
        classePersistente = Pais.class; //classePersistence e ordem estão visivel pra mim pq são atributos protected e não preciso usar get ou set pois estão em nível de pacote e PaisDAO é uma classe filha de DAOGenerico<>
        ordem = "nome";
    }
    
    
}
