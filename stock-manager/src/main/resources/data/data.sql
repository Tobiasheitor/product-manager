DROP TABLE IF EXISTS containers;

CREATE TABLE containers (
  id INT AUTO_INCREMENT PRIMARY KEY,
  tracker_id VARCHAR(250) NOT NULL,
  input_date TIMESTAMP with time zone,
  company VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS products;

CREATE TABLE products (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  product_id VARCHAR(250),
  container_id INT,
  type VARCHAR(250),
  quantity INT
);

ALTER TABLE products ADD CONSTRAINT IF NOT EXISTS PRODUCT_ID_FK FOREIGN KEY (container_id) REFERENCES containers(id);
