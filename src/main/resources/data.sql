---------sector_type----
INSERT INTO SECTOR_TYPE (id, description, name, type)
VALUES (0, 'Without All Inclusive', 'Общий', 'COMMON'),
       (1, 'All Inclusive', 'Люкс', 'LUX'),
       (2, 'room, All Inclusive', 'Делюкс', 'DELUX');

-------sectors-----
INSERT INTO SECTORS (id, is_booked, row_number, seat_number, sector_type_id)
VALUES (1, 0, 5, 34, 0),
       (2, 1, 3, 23, 0),
       (3, 0, 2, 45, 1),
       (4, 1, 2, 23, 1),
       (5, 0, 3, 12, 2),
       (6, 1, 4, 23, 0),
       (7, 0, 3, 34, 2),
       (8, 1, 1, 34, 2),
       (9, 0, 5, 22, 1);

-----prices-----

INSERT INTO RATE (id, price, sector_type_id)
VALUES (0, 15, 0),
       (1, 50, 1),
       (2, 100, 2);

----------customers---------
INSERT INTO CUSTOMER (id,name,balance,birth_date,created,deleted,updated) VALUES
 (0,'Sergio',240,'1990-01-01',null,null,null),
 (1,'Vladymyr',40,'1991-05-01',null,null,null),
 (2,'Ruslan',140,'2000-02-01',null,null,null),
 (3,'Alexandr',100,'1987-02-01',null,null,null),
 (4,'Yulia',2400,'1988-03-02',null,null,null),
 (5,'Olga',1000,'1955-01-01',null,null,null),
 (6,'Kateryna',30,'1990-02-01',null,null,null);

 ------stadiumTicket---------
 INSERT INTO STADIUM_TICKET(id,customer_id,sector_id) VALUES
    (0,2,5),
    (1,4,2),
    (2,1,9),
    (3,6,7);