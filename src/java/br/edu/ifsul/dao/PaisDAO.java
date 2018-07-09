/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Pais;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Haylton
 */
//DAO (Data access Object)uma classe que encapsula o acesso aos pela JPA
public class PaisDAO implements Serializable{
    private String menssagem = "";
    private EntityManager em;

    public PaisDAO() {
        em = EntityManagerUtil.getEntityManager();
    }
    
    // método para recuperar todos os paises, salvar, remover e localizar
    
    public List<Pais> getLista(){
        return em.createQuery("from Pais order by nome").getResultList();
    }
    //métodos abaixo para salvar que retorna um booleano se ele conseguiu ou não persistir o objeto
    public  boolean salvarPais(Pais pais){
        try {
            em.getTransaction().begin();
            //se o id é nulo eu vou usar o em.persist, caso não seja eu uso em.merge
            if(pais.getId() == null){
                em.persist(pais);
            }else{
                em.merge(pais);
            }
            em.getTransaction().commit();//TRANSAÇÃO
            menssagem = "Objeto persistido com sucesso!";
            return true;
        } catch (Exception e) {
            //caso ocorrea algum erro, tenho que fazer um rollback e para isso primeiro eu tenho que ver se a TRANSAÇÃO está aberto
            if(em.getTransaction().isActive() == false){
                em.getTransaction().begin(); //faço isso pq preciso que a transação esteja ativa para possibilitar o rollback ali em baixo
            }
            em.getTransaction().rollback();
            menssagem = "Erro ao pessistir o objeto: "+ Util.getMensagemErro(e);
            return false;
        }
    }
    
    
    public  boolean removerPais(Pais pais){
        try {
            em.getTransaction().begin();
            em.remove(pais);
            em.getTransaction().commit();//TRANSAÇÃO
            menssagem = "Objeto removido com sucesso!";
            return true;
        } catch (Exception e) {
            //caso ocorrea algum erro, tenho que fazer um rollback e para isso primeiro eu tenho que ver se a TRANSAÇÃO está aberto
            if(em.getTransaction().isActive() == false){
                em.getTransaction().begin(); //faço isso pq preciso que a transação esteja ativa para possibilitar o rollback ali em baixo
            }
            em.getTransaction().rollback();
            menssagem = "Erro ao remover: "+ Util.getMensagemErro(e);
            return false;
        }
    }
    
    public Pais localizarPais(Integer id){
        return em.find(Pais.class, id); 
    }

    public String getMenssagem() {
        return menssagem;
    }

    public void setMenssagem(String menssagem) {
        this.menssagem = menssagem;
    }
    
    

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
}
