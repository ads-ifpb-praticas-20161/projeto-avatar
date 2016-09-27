package com.mycompany.contrloedeestoque.facade;

import com.mycompany.contrloedeestoque.classesVO.CategoriaVO;
import com.mycompany.contrloedeestoque.classesVO.EstoqueVO;
import com.mycompany.contrloedeestoque.classesVO.FreteVO;
import com.mycompany.contrloedeestoque.classesVO.LojaSaidaVO;
import com.mycompany.contrloedeestoque.classesVO.PesoVO;
import com.mycompany.contrloedeestoque.classesVO.ProdutoVO;
import com.mycompany.contrloedeestoque.classesVO.ProdutoVO2;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Document ConsultasFachada
 *
 * @Date 04/09/2016
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
@Stateless
public class ConsultasFachada {

    @PersistenceContext(unitName = "com.mycompany_ContrloeDeEstoque_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private List<EstoqueVO> estoqueVOs;
    private List<ProdutoVO> produtoVOs;
    private List<ProdutoVO2> produtoVO2s;
    private List<LojaSaidaVO> lojaSaidaVOs;
    private List<PesoVO> pesoVOs;
    private List<FreteVO> freteVOs;
    private List<CategoriaVO> categoriaVOs;

    public List<EstoqueVO> produtosEmEStoque() {
        estoqueVOs = new ArrayList();

        String SQL = "  SELECT Produto_codproduto, "
                + "  ((SELECT SUM(qtde) FROM ItemEntrada as item "
                + "  WHERE itens.Produto_codproduto=item.Produto_codproduto)-SUM(qtde)), "
                + "  ((SELECT descricao from Produto WHERE codproduto = itens.Produto_codproduto )) "
                + "  FROM ItemSaida as itens "
                + "  GROUP BY Produto_codproduto; ";

        Query q = em.createNativeQuery(SQL);

        List<Object[]> pesquisa = q.getResultList();

        for (Object[] a : pesquisa) {
            EstoqueVO estoqueVO = new EstoqueVO((Integer) a[0], (Long) a[1], (String) a[2]);
            estoqueVOs.add(estoqueVO);

        }

        return estoqueVOs;

    }

    public List<EstoqueVO> abaixoDaQuantidadeMinima() {
        estoqueVOs = new ArrayList();

        String SQL = "  SELECT Produto_codproduto, p.descricao "
                + "  FROM ItemSaida as itms "
                + "  INNER JOIN Produto p ON p.codproduto=itms.Produto_codproduto "
                + "  GROUP BY p.descricao, itms.Produto_codproduto, p.qtdemin "
                + "  HAVING ((SELECT SUM(qtde) "
                + "  FROM ItemEntrada as itme "
                + "  WHERE itms.Produto_codproduto=itme.Produto_codproduto)-SUM(qtde))<= p.qtdemin; ";

        Query q = em.createNativeQuery(SQL);

        List<Object[]> pesquisa = q.getResultList();

        for (Object[] a : pesquisa) {
            EstoqueVO estoqueVO = new EstoqueVO((Integer) a[0], (String) a[1]);
            estoqueVOs.add(estoqueVO);

        }

        return estoqueVOs;

    }

    public List<ProdutoVO> separadosPorFornecedor() {
        produtoVOs = new ArrayList();

        String SQL = " SELECT p.codproduto, p.descricao, p.peso, p.qtdemin, f.fornecedor "
                + "FROM Produto p INNER JOIN "
                + "Fornecedor f ON f.codfornecedor=p.Fornecedor_codfornecedor order by f.fornecedor;";

        Query q = em.createNativeQuery(SQL);

        List<Object[]> pesquisa = q.getResultList();

        for (Object[] a : pesquisa) {
            ProdutoVO produtoVO = new ProdutoVO((Integer) a[0], (String) a[1], (Double) a[2], (Integer) a[3], (String) a[4]);
            produtoVOs.add(produtoVO);

        }

        return produtoVOs;

    }

    public BigDecimal tempoMedio() {
        System.out.println("com.mycompany.contrloedeestoque.facade.ConsultasFachada.tempoMedio()");
        BigDecimal tempo = new BigDecimal(0);

        String SQL = "SELECT AVG(dataentr-dataped) FROM Entrada;";

        Query q = em.createNativeQuery(SQL);

        tempo = (BigDecimal) q.getSingleResult();

        System.out.println(tempo);
        return tempo;

    }

    public List<LojaSaidaVO> totalDeSaidaDaLoja() {
        lojaSaidaVOs = new ArrayList();

        String SQL = " SELECT Nome, SUM(total) FROM saida s INNER JOIN "
                + "loja l ON s.Loja_codloja=l.codloja group by(l.nome);";

        Query q = em.createNativeQuery(SQL);

        List<Object[]> pesquisa = q.getResultList();

        for (Object[] a : pesquisa) {
            LojaSaidaVO lojaSaidaVO = new LojaSaidaVO((String) a[0], (Double) a[1]);
            lojaSaidaVOs.add(lojaSaidaVO);

        }

        return lojaSaidaVOs;
    }

    public List<PesoVO> totalPesoTotalEntradaSaida() {
        pesoVOs = new ArrayList();

        String SQL = "   SELECT ie.Entrada_codentrada, SUM(p.peso*ie.qtde), 'Entrada' "
                + "  FROM ItemEntrada ie "
                + "  INNER JOIN produto p ON p.codproduto=ie.Produto_codproduto "
                + "  GROUP BY ie.Entrada_codentrada "
                + "  union "
                + "  SELECT itms.Saida_codsaida, SUM(p.peso*itms.qtde), 'Saída' "
                + "  FROM ItemSaida itms "
                + "  INNER JOIN produto p ON p.codproduto=itms.Produto_codproduto "
                + "  GROUP BY itms.Saida_codsaida";

        Query q = em.createNativeQuery(SQL);

        List<Object[]> pesquisa = q.getResultList();

        for (Object[] a : pesquisa) {
            PesoVO pesoVO = new PesoVO((Integer) a[0], (Double) a[1], (String) a[2]);
            pesoVOs.add(pesoVO);

        }

        return pesoVOs;
    }

    public List<FreteVO> totalFretePorTransportadora() {
        freteVOs = new ArrayList();

        String SQL = "  SELECT t.transportadora, SUM(e.frete), 'Entrada' "
                + "  FROM transportadora t "
                + "  INNER JOIN entrada e ON e.Transportadora_codtransportadora=t.codtransportadora "
                + "  GROUP BY t.transportadora "
                + "  union "
                + "  SELECT t.transportadora, SUM(s.frete), 'Saída' "
                + "  FROM transportadora t "
                + "  INNER JOIN saida s ON s.Transportadora_codtransportadora=t.codtransportadora "
                + "  GROUP BY t.transportadora;";

        Query q = em.createNativeQuery(SQL);

        List<Object[]> pesquisa = q.getResultList();

        for (Object[] a : pesquisa) {
            FreteVO freteVO = new FreteVO((String) a[0], (Double) a[1], (String) a[2]);
            freteVOs.add(freteVO);

        }

        return freteVOs;
    }

    public List<CategoriaVO> totalPorCategoria() {
        categoriaVOs = new ArrayList();

        String SQL = "SELECT c.categoria, COUNT(*) FROM produto p "
                + "INNER JOIN Categoria c  ON p.Categoria_codcategoria=c.codcategoria"
                + " GROUP BY c.categoria; ";

        Query q = em.createNativeQuery(SQL);

        List<Object[]> pesquisa = q.getResultList();

        for (Object[] a : pesquisa) {
            CategoriaVO categoriaVO = new CategoriaVO((String) a[0], (Long) a[1]);
            categoriaVOs.add(categoriaVO);
        }

        return categoriaVOs;
    }

    public List<ProdutoVO2> agrupandoPorCategoria() {
        produtoVO2s = new ArrayList();

        String SQL = " SELECT p.codproduto, p.descricao, p.peso, p.qtdemin, f.categoria "
                + "FROM Produto p INNER JOIN "
                + "Categoria f ON f.codcategoria = p.categoria_Codcategoria order by f.categoria;";

        Query q = em.createNativeQuery(SQL);

        List<Object[]> pesquisa = q.getResultList();

        for (Object[] a : pesquisa) {
            ProdutoVO2 produtoVO = new ProdutoVO2((Integer) a[0], (String) a[1], (Double) a[2], (Integer) a[3], (String) a[4]);
            produtoVO2s.add(produtoVO);

        }

        return produtoVO2s;

    }

}
