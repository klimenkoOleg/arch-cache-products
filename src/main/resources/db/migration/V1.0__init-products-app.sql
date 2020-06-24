CREATE TABLE product
(
    id               serial       NOT NULL,
    product_name     varchar(255) NULL,
    "position"       varchar(255) NULL,
    store_department varchar(255) NULL,
    CONSTRAINT product_pk PRIMARY KEY (id)
);

-- LOAD DATA LOCAL INFILE './src/main/resources/db/migration/init_data.csv' INTO TABLE product2
--     FIELDS TERMINATED BY ','
--     optionally enclosed by '"'
--     LINES TERMINATED BY '\r\n'
--     IGNORE 1 LINES;