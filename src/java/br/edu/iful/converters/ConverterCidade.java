package br.edu.iful.converters;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Cidade;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Haylton
 */
@FacesConverter(value = "converterCidade") //essa anotação facesConverter vai ajudar para chamar o conversor lá na tela
public class ConverterCidade implements Converter, Serializable {

    //esse método serve para converter da tela para o objeto. o Primeiro parametro é context sendo qual é o contexto que vocÊ tá chamando
    @Override //o segundo é qual o componente e o terceiro é a string para quue seja convertida para um Object. Só olhar o retorno que você verá o Object
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        //basicamente o que esse método vai fazer é pegar a string de parâmetro e transforma-lo em um objeto do tipo Cidade
        if (string == null || string.equals("Selecione um registro")) {
            return null;
        } else {
            return EntityManagerUtil.getEntityManager().find(Cidade.class, Integer.parseInt(string));
        }
    }

    //esse converte do objeto para a tela
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null) {
            return null;
        } else { //se não for nulo, vou extrair o pais via casting que veio por parÂmetro
            Cidade obj = (Cidade) o;
            return obj.getId().toString();
        }

    }
    
}
