

    CREATE TABLE IF NOT EXISTS  tb_sellers (
       id bigint not null auto_increment,
        name varchar(255),
        primary key (id)
    ) engine=InnoDB;

    CREATE TABLE IF NOT EXISTS  tb_sales (
           idSales bigint not null auto_increment,
            amount double precision,
            date date,
            deals integer,
            visited integer,
            seller_id bigint,
            PRIMARY KEY (idSales),
            FOREIGN KEY (seller_id) REFERENCES tb_sellers(id)
        ) engine=InnoDB;

