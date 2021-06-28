/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.enade.converter;

import br.edu.uniacademia.enade.model.Questao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

/**
 *
 * @author COREI7
 */
@FacesConverter("questaoConverter")
@Named
public class QuestaoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            return uic.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value instanceof Questao) {
            Questao obj = (Questao) value;
            if (obj != null) {
                uic.getAttributes().put(obj.getIdQuestao().toString(), obj);
                return obj.getIdQuestao().toString();
            }
            return "";
        }
        return "";
    }

}
