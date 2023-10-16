-- Create products table
CREATE TABLE products (
    sku VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    price DECIMAL(10, 2)
);

