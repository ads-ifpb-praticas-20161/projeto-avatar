package com.mycompany.contrloedeestoque.controle.JSF2;

import com.mycompany.contrloedeestoque.util.JsfUtil;
import com.mycompany.contrloedeestoque.util.PaginationHelper;
import com.mycompany.contrloedeestoque.entidades.Itemsaida;

import com.mycompany.contrloedeestoque.facade.ItemsaidaFacade;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("itemsaidaController")
@SessionScoped
public class ItemsaidaController implements Serializable {

    private Itemsaida current;
    private DataModel items = null;
    @EJB
    private ItemsaidaFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public ItemsaidaController() {
    }

    public Itemsaida getSelected() {
        if (current == null) {
            current = new Itemsaida();
            selectedItemIndex = -1;
        }
        return current;
    }

    private ItemsaidaFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Itemsaida) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Itemsaida();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage("Item de Saída criado com sucesso!");
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "Erro ao tentar salvar Item de Saída");
            return null;
        }
    }

    public String prepareEdit() {
        current = (Itemsaida) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage("Item de Saída atualizado com sucesso!");
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "Erro ao tentar atualizar Item de Saída");
            return null;
        }
    }

    public String destroy() {
        current = (Itemsaida) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage("Item de Saída removido com sucesso!");
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "Erro ao tentar remover Item de Saída");
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Itemsaida getItemsaida(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Itemsaida.class)
    public static class ItemsaidaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ItemsaidaController controller = (ItemsaidaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "itemsaidaController");
            return controller.getItemsaida(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Itemsaida) {
                Itemsaida o = (Itemsaida) object;
                return getStringKey(o.getCoditemsaida());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Itemsaida.class.getName());
            }
        }

    }

}
