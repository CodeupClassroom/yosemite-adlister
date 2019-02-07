
USE quotes_db;
DROP TABLE IF EXISTS quotes;

CREATE TABLE IF NOT EXISTS quotes (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  author VARCHAR(255) NOT NULL,
  quote VARCHAR(2048),
  PRIMARY KEY (id)
);
