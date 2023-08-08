CREATE TABLE IF NOT EXISTS Continent (
    id INT AUTO_INCREMENT,
    country VARCHAR(50),
    name VARCHAR(30),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS Country (
    id INT AUTO_INCREMENT,
    name VARCHAR(250),
    capital VARCHAR(100),
    emoji VARCHAR(100),
    currency VARCHAR(50),
    code VARCHAR(50),
    phone VARCHAR(50),
    continent_id INTEGER,
    PRIMARY KEY (id)
);