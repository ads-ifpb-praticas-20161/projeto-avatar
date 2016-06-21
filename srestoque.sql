-- Database: srestoque

-- DROP DATABASE srestoque;

CREATE DATABASE srestoque
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;
-- Table: public.produto

-- DROP TABLE public.produto;

CREATE TABLE public.produto
(
  id integer NOT NULL DEFAULT nextval('produto_id_seq'::regclass),
  descricao character varying(255),
  estoque integer NOT NULL,
  valor real NOT NULL,
  CONSTRAINT produto_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.produto
  OWNER TO postgres;