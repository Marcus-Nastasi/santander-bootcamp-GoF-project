CREATE TABLE address (
    id INT(255) NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR(255) NOT NULL,
    complement VARCHAR(255) NOT NULL,
    neighborhood VARCHAR(255) NOT NULL,
    locale VARCHAR(255) NOT NULL,
    uf VARCHAR(255) NOT NULL
);

INSERT INTO address(street, complement, neighborhood, locale, uf) VALUES ('rua aracajú', '233', 'aparecida', 'São Paulo', 'SP');



