DROP TABLE IF EXISTS products;

CREATE TABLE products (

    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    description VARCHAR(250) NOT NULL,
    value DOUBLE(10, 3) NOT NULL

)