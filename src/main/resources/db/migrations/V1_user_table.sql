CREATE TABLE users(
    id INT(255) NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    address_id INT(255) NOT NULL,
    FOREIGN KEY (address_id) REFERENCES address(id)
);

INSERT INTO users(name, email, address_id) VALUES ('Ryan Meel', 'meel.02@gmail.com', '1');

