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
    state VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    zip_code VARCHAR(20) NOT NULL,
    road VARCHAR(255),
    district VARCHAR(100),
    house_number VARCHAR(20),

    primary key(id)
);
