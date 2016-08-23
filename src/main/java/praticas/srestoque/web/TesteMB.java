/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author vmvini
 */

@Named
@RequestScoped
public class TesteMB {
    
    private String element;
    
    public TesteMB(){
        element = "elements.xhtml";
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }
    
    
    
}
