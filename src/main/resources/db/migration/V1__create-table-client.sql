CREATE TABLE client (
    id BIGINT NOT NULL auto_increment,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    cpf VARCHAR(20) NOT NULL,
    age INT NOT NULL,
    email  varchar (255) NOT NULL,
    telephone VARCHAR(20) NOT NULL,

    -- Campos do endereço incorporado
    state VARCHAR(2) NOT NULL CHECK (state REGEXP '^[A-Z]{2}$'),
    city VARCHAR(100) NOT NULL,
    zip_code VARCHAR(9) NOT NULL CHECK (zip_code REGEXP '^\\d{5}-\\d{3}$'),
    road VARCHAR(255),
    district VARCHAR(100),
    house_number VARCHAR(20),

    primary key(id)
);
