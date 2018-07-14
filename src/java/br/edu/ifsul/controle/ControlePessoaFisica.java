/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CidadeDAO;
import br.edu.ifsul.dao.PessoaFisicaDAO;
import br.edu.ifsul.dao.PaisDAO;
import br.edu.ifsul.dao.ProdutoDAO;
import br.edu.ifsul.dao.TipoEnderecoDAO;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Endereco;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.Pais;
import br.edu.ifsul.modelo.Produto;
import br.edu.ifsul.modelo.TipoEndereco;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Haylton
 */
@ManagedBean(name = "controlePessoaFisica")//a maioria das ações(métodos) tem que ser void por se estar usando ajax com o viewscoped, pois não irei navegar entre telas com o ajax, usarei modals
@ViewScoped//as classes controles @ManagedBean servem para responder os comandos da interface, ou seja, do usuário. To usando viewscoped pq toda a manutenção de pessoafisica vai funcionar com ajax
public class ControlePessoaFisica implements Serializable {

    private PessoaFisicaDAO<PessoaFisica> dao; //esse primeiro serve para interação com o banco de dados
    private PessoaFisica pessoafisica; //esse vai servir para receber a instancia que vou estar editando ou inserindo 
    private CidadeDAO<Cidade> daoCidade;
    private TipoEnderecoDAO<TipoEndereco> daoTipoEndereco;
    private ProdutoDAO<ProdutoDAO> daoProduto;
    private Produto produto; //em algum momento eu vou ter que selecionar o produto então vou criar esse "atributo"
    private Endereco endereco;
    boolean novoEndereco; //tenho que saber se é um novo endereco ou nao

    public ControlePessoaFisica() {
        dao = new PessoaFisicaDAO<>(); // no construtor de qualquer classe controle @Managedbean, é bom iniciar no construtor os objetos do tipo DAO
        daoCidade = new CidadeDAO<>();
        daoTipoEndereco = new TipoEnderecoDAO<>();
        daoProduto = new ProdutoDAO<>();
    }

    //é o único que vai continuar usando o retorno string para voltar a tela de listar
    public String listar() {
        return "/privado/pessoafisica/listar?faces-redirect=true";
    }
    
    public void adicionarDesejo(){
        if(produto != null){ //se o produto não for nulo, é pq ele já selecionou alguém
            if(!pessoafisica.getDesejos().contains(produto)){ //se a lista de desejos da pessoa fisica não conter um produto, então é adicionado o produto que ele selecionou
                pessoafisica.getDesejos().add(produto);
                Util.mensagemInformacao("Desejo adicionado com sucesso!");
            }else{
                Util.mensagemErro("Esse desejo já existe na sua lista!");
            }
        }
    }
    
    public void removerDesejo(int index){
        produto = pessoafisica.getDesejos().get(index);
        pessoafisica.getDesejos().remove(produto);
        Util.mensagemInformacao("Desejo removido com sucesso!");
        
    }

    public void novoEndereco() {
        endereco = new Endereco();
        novoEndereco = true;
    }

    public void alterarEndereco(int index) {
        endereco = pessoafisica.getEnderecos().get(index);
        novoEndereco = false;
    }

    public void salvarEndereco() {
        if (novoEndereco) {
            pessoafisica.adicionarEndereco(endereco);
        }
        Util.mensagemInformacao("Endereço " + endereco.getEndereco() + " salvo com sucesso!!");
    }

    public void removerEndereco(int index) {
        pessoafisica.removerEndereco(index);
        Util.mensagemInformacao("Endereço removido com sucesso!");
    }

    public void novo() {
        pessoafisica = new PessoaFisica();

    }

    public void salvar() {
        boolean persistiu = false;
        if (pessoafisica.getId() == null) {
            persistiu = dao.persistGenerico(pessoafisica);
        } else {
            persistiu = dao.mergeGenerico(pessoafisica);
        }

        if (persistiu) {
            Util.mensagemInformacao(dao.getMenssagem());

        } else {
            Util.mensagemErro(dao.getMenssagem());

        }
    }

    public void editar(Integer id) {
        pessoafisica = dao.localizarGenerico(id);

    }

    public void remover(Integer id) {
        pessoafisica = dao.localizarGenerico(id);
        if (dao.removeGenerico(pessoafisica)) {
            Util.mensagemInformacao(dao.getMenssagem());
        } else {
            Util.mensagemErro(dao.getMenssagem());
        }
    }

    public PessoaFisicaDAO getDao() {
        return dao;
    }

    public void setDao(PessoaFisicaDAO dao) {
        this.dao = dao;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoafisica;
    }

    public void setPessoaFisica(PessoaFisica pessoafisica) {
        this.pessoafisica = pessoafisica;
    }

    public CidadeDAO<Cidade> getDaoCidade() {
        return daoCidade;
    }

    public void setDaoCidade(CidadeDAO<Cidade> daoCidade) {
        this.daoCidade = daoCidade;
    }

    public TipoEnderecoDAO<TipoEndereco> getDaoTipoEndereco() {
        return daoTipoEndereco;
    }

    public void setDaoTipoEndereco(TipoEnderecoDAO<TipoEndereco> daoTipoEndereco) {
        this.daoTipoEndereco = daoTipoEndereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public boolean isNovoEndereco() {
        return novoEndereco;
    }

    public void setNovoEndereco(boolean novoEndereco) {
        this.novoEndereco = novoEndereco;
    }

    public ProdutoDAO<ProdutoDAO> getDaoProduto() {
        return daoProduto;
    }

    public void setDaoProduto(ProdutoDAO<ProdutoDAO> daoProduto) {
        this.daoProduto = daoProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
