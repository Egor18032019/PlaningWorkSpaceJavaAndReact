DROP TABLE IF EXISTS requests;
DROP TABLE IF EXISTS request_statuses;
DROP TABLE IF EXISTS equipment_list;
DROP TABLE IF EXISTS equipment_type;
DROP TABLE IF EXISTS addresses CASCADE;
DROP TABLE IF EXISTS employment CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS companies;

DROP SEQUENCE IF EXISTS global_seq CASCADE;

CREATE SEQUENCE global_seq START WITH 100000;
CREATE TABLE companies
(
    id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name VARCHAR(50) NOT NULL
);
-- должно в себя включать:
-- - координаты р.м.
-- - номер р.м.
-- - не удаляться
CREATE TABLE employment
(
    id        INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    employment_id   INTEGER       NOT NULL,
    x_coordinate      INTEGER NOT NULL,
    y_coordinate    INTEGER NOT NULL
-- TODO добавить уникальность
);
CREATE TABLE addresses
(
    id        INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    address   TEXT    NOT NULL

);
CREATE TABLE users
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    phone       BIGINT,
    email       VARCHAR NOT NULL,
    first_name  TEXT    NOT NULL,
    second_name TEXT    NOT NULL,
    patronymic  TEXT    NOT NULL,
    address_id  INTEGER not null ,
    employment_id  INTEGER,
--     рабочего места может не быть(удаленка)
-- TODO         компания должна быть и ее должен ставить админ ?

    company_id  INTEGER  ,
    FOREIGN KEY (company_id) REFERENCES companies (id),
    FOREIGN KEY (address_id) REFERENCES addresses (id),
    CONSTRAINT user_phone UNIQUE (phone)
--     CONSTRAINT user_email UNIQUE (email)
);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR,
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE equipment_type
(
    id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name VARCHAR NOT NULL

);
-- ТМЦ у сотрудника
-- id идешка
-- name инвенатрный номер ? если без номера то передавать б.н
-- user_id идешка Юзера
-- equipment_id тип оборудование(ПК-ноут-Монитор-Телефон)
CREATE TABLE equipment_list
(
    id           INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name         VARCHAR NOT NULL,
    user_id      INTEGER,
    equipment_id INTEGER,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (equipment_id) REFERENCES equipment_type (id) ON DELETE CASCADE
);

CREATE TABLE requests
(
    id        INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    type      INTEGER     NOT NULL,
    title     VARCHAR(50) NOT NULL,
    date      TIMESTAMP   NOT NULL,
--     сотрудник может же сдеалть заявку за другого или общую
    address   VARCHAR     NOT NULL,
    comment   TEXT,
    status    INTEGER     NOT NULL,
    client_id INTEGER     NOT NULL,
    file      VARCHAR(50),
    FOREIGN KEY (client_id) REFERENCES users (id) ON DELETE CASCADE
);

