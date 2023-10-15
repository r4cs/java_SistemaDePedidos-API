create table PEDIDO
(
    ID            NUMBER constraint PEDIDO_PK primary key,
    ITENS_PEDIDOS VARCHAR2(500),
    DATE_TIME     DATE          not null
);

CREATE SEQUENCE pedido_id_seq START WITH 1 INCREMENT BY 1;

create or replace trigger INSERT_PEDIDO
    before insert
    on PEDIDO
    for each row
BEGIN
SELECT pedido_id_seq.NEXTVAL INTO :NEW.ID FROM DUAL;
END;


// ---------- ITEM_PEDIDO ---------
CREATE TABLE ITEM_PEDIDO
(
    ID        NUMBER constraint ITEM_PEDIDO_PK primary key,
--     NOME      VARCHAR2(100) not null,
--     ESTOQUE   NUMBER not null,
--     PRECO     NUMBER not null,
--     QTDE      NUMBER not null,
    PEDIDO_ID NUMBER constraint FK_PEDIDO_ID references PEDIDO
);


CREATE SEQUENCE item_pedido_id_seq START WITH 1 INCREMENT BY 1;


CREATE OR REPLACE TRIGGER item_pedido_insert
    BEFORE INSERT ON ITEM_PEDIDO
    FOR EACH ROW
BEGIN
SELECT item_pedido_id_seq.NEXTVAL INTO :NEW.ID FROM DUAL;
END;



// ------------ PRODUTO ------------
CREATE TABLE PRODUTO
(
    ID        NUMBER constraint PRODUTO_PK primary key,
    NOME      VARCHAR2(100) not null,
    ESTOQUE   NUMBER not null,
    PRECO     NUMBER not null,
);

CREATE SEQUENCE produto_id_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER produto_insert
    BEFORE INSERT ON PRODUTO
    FOR EACH ROW
BEGIN
SELECT produto_id_seq.NEXTVAL INTO :NEW.ID FROM DUAL;
END;