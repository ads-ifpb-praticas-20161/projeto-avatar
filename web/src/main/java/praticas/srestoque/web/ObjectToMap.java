/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticas.srestoque.web;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanMap;
 

/**
 *
 * @author vmvini
 */
public class ObjectToMap {
    
    private BeanMap toMap(Object o){
        BeanMap map = new BeanMap(o);
        return map;
    }
    
    
    public List<Map> toMapList(List<Object> list){
        List<Map> lista = new ArrayList<Map>();
        for(Object o : list){
           BeanMap bm = toMap(o);
           lista.add(bm);
        }
        return lista;
    }
    
    
}
