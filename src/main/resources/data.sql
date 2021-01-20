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
INSERT INTO PRICES (id, price, sector_types_id)
VALUES (0, 15, 0),
       (1, 50, 1),
       (2, 100, 2);
