INSERT INTO companies (id, name)
VALUES (50000, 'Темные'),
    (50001, 'Светлые');

INSERT INTO employment (id, employment_id,x_coordinate, y_coordinate)
VALUES (80000,1, 543, 376),
       (80001,2, 533, 555),
       (79999,0, 0, 0),
       (80002,20, 522, 444),
       (80003, 44,511, 333);
INSERT INTO addresses (id, address)
VALUES (10008, 'Маркса 36 9 этаж'),
       (10009, 'Маркса 36 8 этаж'),
       (10000, 'Админ'),
       (10001, 'Удалённая работа'),
       (10005, 'Маркса 36 5 этаж'),
       (10003, 'Маркса 36 3 этаж');
INSERT INTO users (id, phone, email, first_name, second_name, patronymic,       address_id, company_id,employment_id)
VALUES (60000, 79000000000, 'user0@mail.ru', 'Петр', 'Петров'  , 'Петрович' ,10009,      50000,     80000),
       (60001, 79111111111, 'user1@mail.ru', 'Сидор', 'Сидоров', 'Сидорович',10005,      50000,80001),
       (60002, 79122223228, 'user2@mail.ru', 'Егор', 'В'       , 'П'        ,10000      ,50001,79999),
       (60003, 79122223224, 'user4@mail.ru', 'Иван', 'Касперский'       , 'П'  ,10001   ,50001,79999),
       (60004, 79333333333, 'user3@mail.ru', 'Фирс', 'Фирсов'  , 'Фирсович' ,10003,     50000,80003);


-- TODO сделать еще одну табличку соотношения ролей ?
INSERT INTO user_roles (role, user_id)
VALUES ('USER', 60000),
       ('USER', 60001),
       ('ADMIN', 60002),
       ('USER', 60003),
       ('USER', 60004);

INSERT INTO equipment_type (id, name)
VALUES (90000, 'ПК'),
       (90001, 'Ноутбук'),
       (90002, 'Монитор'),
       (90003, 'Телефон');

INSERT INTO equipment_list (id, name, user_id, equipment_id)
VALUES (70000, 'эл.юз1', 60000, 90000),
       (70001, '700001234', 60000, 90002),
       (70002, '700001235', 60000, 90001),
       (70003, 'б/н', 60000, 90003),
       (70004, 'б/н', 60001, 90003),
       (70005, '700001236', 60001, 90001),
       (70006, 'б/н', 60002, 90003),
       (70007, '700001237', 60002, 90001),
       (70008, '700001238', 60002, 90002);

INSERT INTO requests (id, type, title, date, address, comment, status, client_id)
VALUES (80000, 1, 'Заявка 1', '2021-11-15 17:35:45.000000', '55', 'Сломан ПК ', 1, 60000),
       (80001, 2, 'Заявка 2', '2021-11-17 17:35:17.000000', '60', 'Не горит лампа над РМ 60001', 1, 60001),
       (80002, 2, 'Заявка 60002', '2021-11-17 17:35:17.000000', '60', 'Не горит лампа над РМ 60002', 2, 60002),
       (80003, 2, 'Заявка 80003', '2021-11-17 17:35:17.000000', '59', 'Не горит лампа над РМ 60003', 1, 60003),
       (80004, 3, 'Заявка 3', '2021-10-15 12:22:17.000000', '20', 'Не работает принтер на 9 этаже', 2, 60004);


