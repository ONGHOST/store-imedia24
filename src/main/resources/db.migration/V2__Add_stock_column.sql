-- Add stock column
ALTER TABLE products
ADD COLUMN stock INT DEFAULT 0;