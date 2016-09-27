/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Wellington
 * Created: 24/09/2016
 */

  INSERT INTO usuario(id , email ,nome ,senha ,telefone) VALUES (1,'kiko@gmail.com','Kiko','123','9394-5906');
  INSERT INTO usuario  (id , email ,nome ,senha ,telefone) VALUES (2,'chaves@gmail.com','Chaves','123','9988-5523');
  INSERT INTO usuario  (id , email ,nome ,senha ,telefone) VALUES (3,'chiquinha@gmail.com','Chiquinha','123','9394-2222');

  INSERT INTO categoria VALUES (1, 'Eletrônico');
  INSERT INTO categoria VALUES (2, 'Eletrodoméstico');
  INSERT INTO categoria VALUES (3, 'Informática');
  INSERT INTO categoria VALUES (4, 'Telefonia');
  INSERT INTO categoria VALUES (5, 'Móveis');
  INSERT INTO categoria VALUES (6, 'Limpeza');
   
  INSERT INTO cidade VALUES (1, 'João Pessoa', 'PB');
  INSERT INTO cidade VALUES (2, 'Belo Horizonte', 'MG');
  INSERT INTO cidade VALUES (3, 'Apudi', 'RN');
  INSERT INTO cidade VALUES (4, 'São Paulo', 'SP');
  INSERT INTO cidade VALUES (5, 'Santo André', 'SP');
  INSERT INTO cidade VALUES (6, 'Fortaleza', 'CE');
  INSERT INTO cidade VALUES (7, 'Rio de Janeiro', 'RJ');
  INSERT INTO cidade VALUES (8, 'Recife', 'PE');
  

  INSERT INTO Loja (codloja, cidade_codcidade, nome, endereco, num, bairro, tel, cep, cnpj) VALUES (1, 1, 'Paraíso dos Eletrodomésticos', 'Rua João da Silva', 100, 'Centro', '1111-2222', '123.321.00', '94.405.385/0001-35');
  INSERT INTO Loja (codloja, cidade_codcidade, nome, endereco, num, bairro, tel, cep, cnpj)  VALUES (2, 2, 'Eletromundo', 'Rua 1º de maio', 1500, 'Centro', '1111-2221', '123.456.00', '94.405.385/0002-35');
  INSERT INTO Loja (codloja, cidade_codcidade, nome, endereco, num, bairro, tel, cep, cnpj)  VALUES (3, 3, 'Minaseletro', 'Rua JK', 95, 'Centro', '1111-2223', '654.321.00', '94.405.385/0003-35');
  INSERT INTO Loja (codloja, cidade_codcidade, nome, endereco, num, bairro, tel, cep, cnpj)  VALUES (4, 4, 'SPEletro', 'Rua A', 102, 'Centro', '1111-2224', '123.321.04', '94.405.385/0004-35');
  INSERT INTO Loja (codloja, cidade_codcidade, nome, endereco, num, bairro, tel, cep, cnpj)  VALUES (5, 5, 'Eletrodomésticos e cia.', 'Rua José Junior', 71, 'Centro', '1111-2225', '123.321.05', '94.405.385/0005-35');
  INSERT INTO Loja (codloja, cidade_codcidade, nome, endereco, num, bairro, tel, cep, cnpj)  VALUES (6, 6, 'Vitória Eletrodomésticos', 'Rua Beira Mar', 100, 'Centro', '1111-2226', '123.321.06', '94.405.385/0006-35');
  INSERT INTO Loja (codloja, cidade_codcidade, nome, endereco, num, bairro, tel, cep, cnpj)  VALUES (7, 7, 'GuarapaEletrodomésticos', 'Rua dos Bandeirantes', 149, 'Centro', '1111-2227', '123.321.07', '94.405.385/0007-35');
   
  
  INSERT INTO Fornecedor (codfornecedor ,Cidade_codcidade,fornecedor,endereco,num ,bairro, cep ,contato ,cnpj ,insc ,tel ) VALUES (1, 4, 'LG', 'Av. Brasil', 1, 'Centro', '12000-321', 'Fábio','94.405.385/0007-35', '123.321.07', '1234-4321');
  INSERT INTO Fornecedor (codfornecedor ,Cidade_codcidade,fornecedor,endereco,num ,bairro, cep ,contato ,cnpj ,insc ,tel )VALUES (2, 4, 'Nokia', 'Av. Afonso Pena', 198, 'Centro', '12000-321', 'Carlos', '94.405.385/0007-35', '123.321.07', '1234-4321');
  INSERT INTO Fornecedor (codfornecedor ,Cidade_codcidade,fornecedor,endereco,num ,bairro, cep ,contato ,cnpj ,insc ,tel )VALUES (3, 4, 'Gradiente', 'Av. Paraiso', 3654, 'Centro', '12000-321', 'Felipe', '94.405.385/0007-35', '123.321.07', '1234-4321');
  INSERT INTO Fornecedor (codfornecedor ,Cidade_codcidade,fornecedor,endereco,num ,bairro, cep ,contato ,cnpj ,insc ,tel )VALUES (4, 4, 'Philips', 'Av. Joaquim Gabriel', 24, 'Centro', '12000-321', 'Alex', '94.405.385/0007-35', '123.321.07', '1234-4321');
  INSERT INTO Fornecedor (codfornecedor ,Cidade_codcidade,fornecedor,endereco,num ,bairro, cep ,contato ,cnpj ,insc ,tel )VALUES (5, 4, 'Politorno', 'Av. Manoel de Nobrega', 156, 'Centro', '12000-321', 'Breno', '94.405.385/0007-35', '123.321.07', '1234-4321');
  INSERT INTO Fornecedor (codfornecedor ,Cidade_codcidade,fornecedor,endereco,num ,bairro, cep ,contato ,cnpj ,insc ,tel )VALUES (6, 4, 'HP', 'Rua Santa Efigênia', 1092, 'Centro', '12000-321', 'Vanessa', '94.405.385/0007-35', '123.321.07', '1234-4321');
  INSERT INTO Fornecedor (codfornecedor ,Cidade_codcidade,fornecedor,endereco,num ,bairro, cep ,contato ,cnpj ,insc ,tel )VALUES (7, 4, 'Brastemp', 'Av. Interlagos', 1098, 'Centro', '12000-321', 'Fábio', '94.405.385/0007-35', '123.321.07', '1234-4321');
  INSERT INTO Fornecedor (codfornecedor ,Cidade_codcidade,fornecedor,endereco,num ,bairro, cep ,contato ,cnpj ,insc ,tel )VALUES (8, 1, 'Bombril', 'BR 101 Norte, Km 52 Abreu e Lima', 1098, 'Zona Industrial', '12000-321', 'João', '99.999.385/0007-55', '123.111.08', '1111-4121');


  INSERT INTO Produto(codproduto , Categoria_codcategoria ,Fornecedor_codfornecedor ,descricao ,peso ,qtdemin) VALUES (1, 1, 1, 'TV 50" Plasma 600Hz c/ HDMI, Conversor Digital Integrado ', 39.9, 3);
  INSERT INTO Produto(codproduto , Categoria_codcategoria ,Fornecedor_codfornecedor ,descricao ,peso ,qtdemin) VALUES (2, 1, 4, 'DVD Player c/ karaokê, Entrada USB e DivX - DVP3520KX - Philips', 1.5, 5);
  INSERT INTO Produto(codproduto , Categoria_codcategoria ,Fornecedor_codfornecedor ,descricao ,peso ,qtdemin) VALUES (3, 1, 3,'TV 37" LCD - LCD3730 - (1366 X 768 Pixels) c/ HDTV Ready, Entrada HDMI - Gradiente', 3, 2);
  INSERT INTO Produto(codproduto , Categoria_codcategoria ,Fornecedor_codfornecedor ,descricao ,peso ,qtdemin) VALUES (4, 2, 7, 'Refrigerador Brastemp Ative! Frost Free 403 litros BRM47', 81, 2);
  INSERT INTO Produto(codproduto , Categoria_codcategoria ,Fornecedor_codfornecedor ,descricao ,peso ,qtdemin) VALUES (5, 2, 7, 'Lavadora e Secadora de Roupa 7kg Ative! BWS24 - Prata - Brastemp', 75, 2);
  INSERT INTO Produto(codproduto , Categoria_codcategoria ,Fornecedor_codfornecedor ,descricao ,peso ,qtdemin) VALUES (6, 2, 1, ' Forno de Microondas Solo 30 Litros 110V Branco - LG', 15, 4);
  INSERT INTO Produto(codproduto , Categoria_codcategoria ,Fornecedor_codfornecedor ,descricao ,peso ,qtdemin) VALUES (7, 3, 6, ' Notebook HP G42-245br c/ Intel® Pentium Dual Core T4500 2.3GHz 3GB RAM 500G 14” Windows 7 Premium - HP', 1.5, 2);

  
  INSERT INTO Produto(codproduto , Categoria_codcategoria ,Fornecedor_codfornecedor ,descricao ,peso ,qtdemin) VALUES (8, 3, 6, 'Multifuncional Jato de Tinta Deskjet F4480 (Impressora + Copiadora + Scanner) - HP', 4.9, 4);
  INSERT INTO Produto(codproduto , Categoria_codcategoria ,Fornecedor_codfornecedor ,descricao ,peso ,qtdemin) VALUES (9, 4, 1, 'LG GT360 Messenger Vermelho - GSM c/Câmera 2.0MP c/ zoom 4x, Filmadora, MP3 Player', 0.6, 1);
  INSERT INTO Produto(codproduto , Categoria_codcategoria ,Fornecedor_codfornecedor ,descricao ,peso ,qtdemin) VALUES (10, 4, 2, 'Smartphone Nokia N8 Prata - GSM c/ Sistema Operacional Symbian 3, Tecnologia 3G, Wi-Fi, TouchScreen, GPS, Câm 12MP ,lente Carl Zeiss Flash Xenon e Câmera Chamadas de Video, Filmadora HD', 0.6, 1);
  INSERT INTO Produto(codproduto , Categoria_codcategoria ,Fornecedor_codfornecedor ,descricao ,peso ,qtdemin) VALUES (11, 5, 5, 'Mesa Malta Branca - Politorno', 4.9, 4);
  INSERT INTO Produto(codproduto , Categoria_codcategoria ,Fornecedor_codfornecedor ,descricao ,peso ,qtdemin) VALUES (12, 5, 5, 'Mesa de Estudo Resende - Branca - Politorno', 4.9, 4);
  INSERT INTO Produto(codproduto , Categoria_codcategoria ,Fornecedor_codfornecedor ,descricao ,peso ,qtdemin) VALUES (13, 5, 5, 'Cama de casal 1,60 Colônia - Castanho Escuro com Preto', 4.9, 4);
  INSERT INTO Produto(codproduto , Categoria_codcategoria ,Fornecedor_codfornecedor ,descricao ,peso ,qtdemin) VALUES (14, 6, 8, 'Caixa de esponja de aço Bombril', 1, 10);


  INSERT INTO Transportadora(codtransportadora ,Cidade_codcidade ,transportadora ,endereco ,num ,bairro,cep , cnpj ,insc ,contato, tel) VALUES (1, 7, 'RapiTrans', 'Rua 20 de Maio', 90, 'Centro', '12000-789', '94.405.385/0007-35', '123.321.07', 'Juninho', '1234-4321');
  INSERT INTO Transportadora(codtransportadora ,Cidade_codcidade ,transportadora ,endereco ,num ,bairro,cep , cnpj ,insc ,contato, tel) VALUES (2, 8, 'Graneiro', 'Rua 7 de Setembro', 120, 'Jardim das Flores', '12111-789', '95.555.555/0007-35', '222.221.09', 'Maguila', '1234-1111');


  INSERT INTO Entrada(codentrada, Transportadora_codtransportadora , dataped, dataentr ,total, frete, numnf, imposto ) VALUES (1, 1, '20/02/2010', '01/03/2010', 1539.01, 720.00, 0000001, 153.90);
  INSERT INTO Entrada(codentrada, Transportadora_codtransportadora , dataped, dataentr ,total, frete, numnf, imposto ) VALUES (2, 1, '13/03/2010', '07/04/2010', 2984.00, 832.00, 0000002, 298.40);
  INSERT INTO Entrada(codentrada, Transportadora_codtransportadora , dataped, dataentr ,total, frete, numnf, imposto ) VALUES (3, 1, '28/03/2010', '14/04/2010', 489.00, 218.00, 0000003, 48.90);
  INSERT INTO Entrada(codentrada, Transportadora_codtransportadora , dataped, dataentr ,total, frete, numnf, imposto ) VALUES (4, 1, '27/04/2010', '30/04/2010', 3982.01, 1023.00, 0000004, 398.20);
  INSERT INTO Entrada(codentrada, Transportadora_codtransportadora , dataped, dataentr ,total, frete, numnf, imposto ) VALUES (5, 1, '19/05/2010', '30/05/2010', 1827.00, 291.00, 0000005, 182.70);
  INSERT INTO Entrada(codentrada, Transportadora_codtransportadora , dataped, dataentr ,total, frete, numnf, imposto ) VALUES (6, 1, '03/06/2010', '25/06/2010', 9812.00, 934.00, 0000006, 981.20);
  INSERT INTO Entrada(codentrada, Transportadora_codtransportadora , dataped, dataentr ,total, frete, numnf, imposto ) VALUES (7, 1, '01/08/2010', '01/09/2010', 19876.00, 1034.00, 0000007, 1987.60);



  INSERT INTO Saida(codsaida ,Loja_codloja ,Transportadora_codtransportadora ,total,frete,imposto) VALUES (1, 1, 1, 300.00, 180.00, 30.00);
  INSERT INTO Saida(codsaida ,Loja_codloja ,Transportadora_codtransportadora ,total,frete,imposto) VALUES (2, 1, 1, 1073.00, 180.00, 107.30);
  INSERT INTO Saida(codsaida ,Loja_codloja ,Transportadora_codtransportadora ,total,frete,imposto) VALUES (3, 2, 1, 512.00, 250.00, 51.20);
  INSERT INTO Saida(codsaida ,Loja_codloja ,Transportadora_codtransportadora ,total,frete,imposto) VALUES (4, 3, 1, 793.00, 70.00, 79.30);
  INSERT INTO Saida(codsaida ,Loja_codloja ,Transportadora_codtransportadora ,total,frete,imposto) VALUES (5, 4, 1, 800.00, 0.00, 80.00);
  INSERT INTO Saida(codsaida ,Loja_codloja ,Transportadora_codtransportadora ,total,frete,imposto) VALUES (6, 5, 1, 296.00, 140.00, 29.60);
  INSERT INTO Saida(codsaida ,Loja_codloja ,Transportadora_codtransportadora ,total,frete,imposto) VALUES (7, 6, 1, 724.00, 92.00, 72.40);
  INSERT INTO Saida(codsaida ,Loja_codloja ,Transportadora_codtransportadora ,total,frete,imposto) VALUES (8, 7, 1, 310.00, 153.00, 31.00);


  INSERT INTO ItemEntrada(coditementrada , Produto_codproduto ,Entrada_codentrada ,lote ,qtde,valor) VALUES (1, 7, 1, 'AB0021', 30, 120.00);
  INSERT INTO ItemEntrada(coditementrada , Produto_codproduto ,Entrada_codentrada ,lote ,qtde,valor) VALUES (2, 13, 1, 'AB0022', 49, 160.00);
  INSERT INTO ItemEntrada(coditementrada , Produto_codproduto ,Entrada_codentrada ,lote ,qtde,valor) VALUES (3, 1, 1, 'AB0023', 18, 90.00);
  INSERT INTO ItemEntrada(coditementrada , Produto_codproduto ,Entrada_codentrada ,lote ,qtde,valor) VALUES (4, 4, 2, 'AB0024', 7, 300.00);
  INSERT INTO ItemEntrada(coditementrada , Produto_codproduto ,Entrada_codentrada ,lote ,qtde,valor) VALUES (5, 9, 2, 'AB0025', 21, 169.00);
  INSERT INTO ItemEntrada(coditementrada , Produto_codproduto ,Entrada_codentrada ,lote ,qtde,valor) VALUES (6, 6, 2, 'AB0026', 10, 120.00);
  INSERT INTO ItemEntrada(coditementrada , Produto_codproduto ,Entrada_codentrada ,lote ,qtde,valor) VALUES (7, 7, 2, 'AB0027', 42, 83.00);
  INSERT INTO ItemEntrada(coditementrada , Produto_codproduto ,Entrada_codentrada ,lote ,qtde,valor) VALUES (8, 11, 3, 'AB0028', 90, 187.00);
  INSERT INTO ItemEntrada(coditementrada , Produto_codproduto ,Entrada_codentrada ,lote ,qtde,valor) VALUES (9, 10, 3, 'AB0029', 9, 720.00);
  INSERT INTO ItemEntrada(coditementrada , Produto_codproduto ,Entrada_codentrada ,lote ,qtde,valor) VALUES (10, 3, 3, 'AB0030', 21, 157.00);
  INSERT INTO ItemEntrada(coditementrada , Produto_codproduto ,Entrada_codentrada ,lote ,qtde,valor) VALUES (11, 8, 4, 'AB0031', 100, 800.00);
  INSERT INTO ItemEntrada(coditementrada , Produto_codproduto ,Entrada_codentrada ,lote ,qtde,valor) VALUES (12, 2, 4, 'AB0032', 15, 174.00);
  INSERT INTO ItemEntrada(coditementrada , Produto_codproduto ,Entrada_codentrada ,lote ,qtde,valor) VALUES (13, 10, 4, 'AB0033', 61, 92.00);
  INSERT INTO ItemEntrada(coditementrada , Produto_codproduto ,Entrada_codentrada ,lote ,qtde,valor) VALUES (14, 9, 5, 'AB0034', 19, 48.00);
  INSERT INTO ItemEntrada(coditementrada , Produto_codproduto ,Entrada_codentrada ,lote ,qtde,valor) VALUES (15, 4, 6, 'AB0037', 38, 900.00);
  INSERT INTO ItemEntrada(coditementrada , Produto_codproduto ,Entrada_codentrada ,lote ,qtde,valor) VALUES (16, 1, 6, 'AB0038', 2, 120.00);
  INSERT INTO ItemEntrada(coditementrada , Produto_codproduto ,Entrada_codentrada ,lote ,qtde,valor) VALUES (17, 12, 7, 'AB0040', 83, 539.00);
  INSERT INTO ItemEntrada(coditementrada , Produto_codproduto ,Entrada_codentrada ,lote ,qtde,valor) VALUES (18, 5, 7, 'AB0041', 24, 170.00);
  INSERT INTO ItemEntrada(coditementrada , Produto_codproduto ,Entrada_codentrada ,lote ,qtde,valor) VALUES (19, 3, 7, 'AB0042', 8, 925.00);
   
  INSERT INTO ItemSaida(coditemsaida , Saida_codsaida ,Produto_codproduto ,lote, qtde ,valor ) VALUES (1, 1, 7, 'AB0021', 16, 120.00);
  INSERT INTO ItemSaida(coditemsaida , Saida_codsaida ,Produto_codproduto ,lote, qtde ,valor ) VALUES (2, 1, 13, 'AB0022', 46, 160.00);
  INSERT INTO ItemSaida(coditemsaida , Saida_codsaida ,Produto_codproduto ,lote, qtde ,valor ) VALUES (3, 1, 1, 'AB0023', 16, 90.00);
  INSERT INTO ItemSaida(coditemsaida , Saida_codsaida ,Produto_codproduto ,lote, qtde ,valor ) VALUES (4, 2, 4, 'AB0024', 5, 300.00);
  INSERT INTO ItemSaida(coditemsaida , Saida_codsaida ,Produto_codproduto ,lote, qtde ,valor ) VALUES (5, 2, 9, 'AB0025', 20, 169.00);
  INSERT INTO ItemSaida(coditemsaida , Saida_codsaida ,Produto_codproduto ,lote, qtde ,valor ) VALUES (6, 2, 6, 'AB0026', 10, 120.00);
  INSERT INTO ItemSaida(coditemsaida , Saida_codsaida ,Produto_codproduto ,lote, qtde ,valor ) VALUES (7, 2, 7, 'AB0027', 38, 83.00);
  INSERT INTO ItemSaida(coditemsaida , Saida_codsaida ,Produto_codproduto ,lote, qtde ,valor ) VALUES (8, 3, 11, 'AB0028', 89, 187.00);
  INSERT INTO ItemSaida(coditemsaida , Saida_codsaida ,Produto_codproduto ,lote, qtde ,valor ) VALUES (9, 3, 10, 'AB0029', 9, 720.00);
  INSERT INTO ItemSaida(coditemsaida , Saida_codsaida ,Produto_codproduto ,lote, qtde ,valor ) VALUES (10, 3, 3, 'AB0030', 19, 157.00);
  INSERT INTO ItemSaida(coditemsaida , Saida_codsaida ,Produto_codproduto ,lote, qtde ,valor ) VALUES (11, 4, 8, 'AB0031', 89, 800.00);
  INSERT INTO ItemSaida(coditemsaida , Saida_codsaida ,Produto_codproduto ,lote, qtde ,valor ) VALUES (12, 4, 2, 'AB0032', 13, 174.00);
  INSERT INTO ItemSaida(coditemsaida , Saida_codsaida ,Produto_codproduto ,lote, qtde ,valor ) VALUES (13, 4, 10, 'AB0033', 57, 92.00);
  INSERT INTO ItemSaida(coditemsaida , Saida_codsaida ,Produto_codproduto ,lote, qtde ,valor ) VALUES (14, 5, 9, 'AB0034', 19, 48.00);
  INSERT INTO ItemSaida(coditemsaida , Saida_codsaida ,Produto_codproduto ,lote, qtde ,valor ) VALUES (15, 6, 4, 'AB0037', 38, 900.00);
  INSERT INTO ItemSaida(coditemsaida , Saida_codsaida ,Produto_codproduto ,lote, qtde ,valor ) VALUES (16, 6, 1, 'AB0038', 2, 120.00);
  INSERT INTO ItemSaida(coditemsaida , Saida_codsaida ,Produto_codproduto ,lote, qtde ,valor ) VALUES (17, 7, 12, 'AB0040', 80, 539.00);
  INSERT INTO ItemSaida(coditemsaida , Saida_codsaida ,Produto_codproduto ,lote, qtde ,valor ) VALUES (18, 7, 5, 'AB0041', 22, 170.00);
  INSERT INTO ItemSaida(coditemsaida , Saida_codsaida ,Produto_codproduto ,lote, qtde ,valor ) VALUES (19, 7, 3, 'AB0042', 5, 925.00); 