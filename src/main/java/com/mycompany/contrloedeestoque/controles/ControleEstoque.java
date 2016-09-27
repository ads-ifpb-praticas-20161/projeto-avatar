package com.mycompany.contrloedeestoque.controles;

import com.mycompany.contrloedeestoque.classesVO.CategoriaVO;
import com.mycompany.contrloedeestoque.classesVO.EstoqueVO;
import com.mycompany.contrloedeestoque.classesVO.FreteVO;
import com.mycompany.contrloedeestoque.classesVO.LojaSaidaVO;
import com.mycompany.contrloedeestoque.classesVO.PesoVO;
import com.mycompany.contrloedeestoque.classesVO.ProdutoVO;
import com.mycompany.contrloedeestoque.classesVO.ProdutoVO2;
import com.mycompany.contrloedeestoque.facade.ConsultasFachada;
import com.mycompany.contrloedeestoque.util.JsfUtil;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Document ControleCategoria
 *
 * @Date 23/08/2016 @Time 16:18:23
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
@Named
@RequestScoped
public class ControleEstoque implements Serializable {

    private List<EstoqueVO> listaEstoque;
    private List<ProdutoVO> listaProduto;
    private List<LojaSaidaVO> listaLojaSaida;
    private List<PesoVO> listaPeso;
    private List<FreteVO> listaFrete;
    private List<CategoriaVO> listaCategoria;
    
    @EJB
    private ConsultasFachada dao;

    public ControleEstoque() {
        listaEstoque = new ArrayList();
        listaProduto = new ArrayList();
        listaLojaSaida = new ArrayList();
        listaPeso = new ArrayList();
        listaFrete = new ArrayList();
        listaCategoria = new ArrayList();
        
        
    }

    public List<EstoqueVO> todoEstoque() {

        try {
            JsfUtil.addSuccessMessage("Estoque lisatdo com sucesso.");
            return listaEstoque = dao.produtosEmEStoque();

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "Problema ao listar o estoque.");
            return Collections.EMPTY_LIST;
        }
    }

    public List<EstoqueVO> quantidadeMinima() {

        try {
            JsfUtil.addSuccessMessage("Estoque lisatdo com sucesso.");
            return listaEstoque = dao.abaixoDaQuantidadeMinima();

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "Problema ao listar a quantidade minima do produto no estoque.");
            return Collections.EMPTY_LIST;
        }
    }

    public List<ProdutoVO> separadoPorFornecedorDeProduto() {

        try {
            JsfUtil.addSuccessMessage("Produtos separados por fornecedor lisatados com sucesso.");
            return listaProduto = dao.separadosPorFornecedor();

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "Problema ao listar Produtos separados por fornecedor  no estoque.");
            return Collections.EMPTY_LIST;
        }
    }

    public BigDecimal tempoMedioPedidoEntrega() {

        try {
            JsfUtil.addSuccessMessage("Tempo médio retornado com sucesso.");

            return dao.tempoMedio();

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "Problema ao retornar o tempo médio antre o pedido e a entrega  no estoque.");
            return null;
        }
    }

    public List<LojaSaidaVO> totalSaidaLoja() {

        try {
            JsfUtil.addSuccessMessage("Tempo médio retornado com sucesso.");

            return dao.totalDeSaidaDaLoja();

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "Problema ao retornar o tempo médio antre o pedido e a entrega  no estoque.");
            return null;
        }
    }
    public List<PesoVO> totalPeso() {
  
        try {
            JsfUtil.addSuccessMessage("Peso de entrada e saída retornado com sucesso.");

            return dao.totalPesoTotalEntradaSaida();

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "Problema ao retornar peso total de entrada e saída no estoque.");
            return null;
        }
    }
    public List<FreteVO> totalFrete() {

        try {
            JsfUtil.addSuccessMessage("Frete total  retornado com sucesso.");

            return dao.totalFretePorTransportadora();

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "Problema ao retornar frete total do estoque.");
            return null;
        }
    }
    public List<CategoriaVO> quantidadePorCategoria() {
 
        try {
            JsfUtil.addSuccessMessage("Quantidade total  por categoria retornado com sucesso.");

            return dao.totalPorCategoria();

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "Problema ao retornar quantidade por categoria no estoque.");
            return null;
        }
    }
    public List<ProdutoVO2> agruparPorCategoria() {
 
        try {
            JsfUtil.addSuccessMessage("Produto  por categoria retornado com sucesso!.");

            return dao.agrupandoPorCategoria();

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "Problema ao retornar  por categoria no estoque.");
            return null;
        }
    }
} 