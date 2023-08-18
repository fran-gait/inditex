DROP TABLE IF EXISTS brand;

CREATE TABLE brand
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS prices;

CREATE TABLE prices
(
    id         LONG AUTO_INCREMENT PRIMARY KEY,
    brand_id   INT,
    start_date datetime,
    end_date   datetime,
    price_list INT,
    product_id INT,
    priority   INT,
    price      DECIMAL(10, 2),
    curr       VARCHAR(3)
);

ALTER TABLE prices
    ADD FOREIGN KEY (brand_id)
        REFERENCES brand (id);

INSERT INTO brand (name)
VALUES ('Zara'),
       ('H&M');

INSERT INTO prices (id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
VALUES (1, 1, '2020-06-14 00.00.00', '2020-12-31 23.59.59', 35455, 1, 0, 35.50, 'EUR'),
       (2, 1, '2020-06-14 15.00.00', '2020-06-14 18.30.00', 35455, 2, 1, 25.45, 'EUR'),
       (3, 1, '2020-06-15 00.00.00', '2020-06-15 11.00.00', 35455, 3, 1, 30.50, 'EUR'),
       (4, 1, '2020-06-15 16.00.00', '2020-12-31 23.59.59', 35455, 4, 1, 38.95, 'EUR');
