Create database testeBD2;

-- 1
CREATE USER 'AdminBancoII';

-- 2
GRANT CONNECT TO 'AdminBancoII';

-- 3
GRANT SELECT ON comprador, vendedor TO 'AdminBancoII';

-- 4
GRANT INSERT, UPDATE ON oferta, imovel TO 'AdminBancoII';

-- 5
GRANT DELETE ON cidade, estado, bairro TO 'AdminBancoII';

-- 6
REVOKE DELETE FROM 'AdminBancoII';

-- 7 
create table cust
(   id int auto_increment primary key,
    theValue int not null,
    theText varchar(50) not null,
    cname varchar(50) not null,
    cid int not null
);

INSERT into cust (theValue,theText,cname,cid) values(111,'aaa','a',1); 

start transaction;

    savepoint B1;

    INSERT into cust (theValue,theText,cname,cid) values(666,'aaa','a',1); 
    
    savepoint B2;

    INSERT into cust (theValue,theText,cname,cid) values(777,'aaa','a',1); 
    -- Vai sumir
    
    ROLLBACK to B2;
    
    select * from cust;

commit;

-- 8


