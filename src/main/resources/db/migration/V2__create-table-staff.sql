CREATE TABLE staff (
    id BIGINT NOT NULL AUTO_INCREMENT,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    cpf VARCHAR(20) NOT NULL,
    email VARCHAR(255) NOT NULL,
    age INT NOT NULL CHECK (age >= 0),
    telephone VARCHAR(20) NOT NULL,
    number_registration VARCHAR(6) NOT NULL CHECK (number_registration REGEXP '^[0-9]{4}-[0-9]{1}$'),
    adjutancy ENUM("ATTENDANT", "COOK", "DELIVERY_PERSON ") NOT NULL,

    -- Campos do endereço incorporado
    state VARCHAR(2) NOT NULL CHECK (state REGEXP '^[A-Z]{2}$'),
    city VARCHAR(100) NOT NULL,
    zip_code VARCHAR(9) NOT NULL CHECK (zip_code REGEXP '^\\d{5}-\\d{3}$'),
    road VARCHAR(255),
    district VARCHAR(100),
    house_number VARCHAR(20),

    PRIMARY KEY (id)
);