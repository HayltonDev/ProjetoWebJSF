/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Haylton
 */
@ManagedBean(name = "controleAjax")
@ViewScoped
public class ControleAjax  implements Serializable{
    
    private Double num1;
    private Double num2;
    private Double resultado;

    public ControleAjax() {
    }
    
    public void somar(){
        resultado = num1 + num2;
        num1 = null;
        num2 = null;
    }
    

    public Double getNum1() {
        return num1;
    }

    public void setNum1(Double num1) {
        this.num1 = num1;
    }

    public Double getNum2() {
        return num2;
    }

    public void setNum2(Double num2) {
        this.num2 = num2;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }
    
    
    
}
