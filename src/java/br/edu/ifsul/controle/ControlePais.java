/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.PaisDAO;
import br.edu.ifsul.modelo.Pais;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Haylton
 */
@ManagedBean(name="controlePais")
@SessionScoped //as classes controles @ManagedBean servem para responder os comandos da interface, ou seja, do usuário
public class ControlePais implements Serializable{
    private PaisDAO dao; //esse primeiro serve para interação com o banco de dados
    private Pais pais; //esse vai servir para receber a instancia que vou estar editando ou inserindo 

    public ControlePais() {
        dao = new PaisDAO(); // no construtor de qualquer classe controle @Managedbean, é bom iniciar no construtor os objetos do tipo DAO
    }
    
    public String listar(){
        return "/privado/pais/listar?faces-redirect=true";
    }
    
    public String novo(){
        pais = new Pais();
        return "formulario?faces-redirect=true"; 
    }
    
    public String salvar(){
        if(dao.salvarPais(pais)){
            Util.mensagemInformacao(dao.getMenssagem());
            return "listar?faces-redirect=true";
        }else{
            Util.mensagemErro(dao.getMenssagem());
            return "formulario?faces-redirect=true";
        }
    }
    
    public String cancelarEdicao(){
        return "listar?faces-redirect=true";
    }
    
    public String editar(Integer id){
        pais = dao.localizarPais(id);
        return "formulario?faces-redirect-true";
    }
    
    public void remover(Integer id){
        pais = dao.localizarPais(id);
        if(dao.removerPais(pais)){
            Util.mensagemInformacao(dao.getMenssagem());
        }else{
            Util.mensagemErro(dao.getMenssagem()); 
        }
    }

    public PaisDAO getDao() {
        return dao;
    }

    public void setDao(PaisDAO dao) {
        this.dao = dao;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
