CREATE TABLE IF NOT EXISTS airway (
                        id SERIAL UNIQUE PRIMARY KEY,
                        city VARCHAR(255) NOT NULL
);

-- flight tablosu

CREATE TABLE IF NOT EXISTS flight (
                        id SERIAL UNIQUE   PRIMARY KEY,
                        departure_airline VARCHAR(255) NOT NULL,
                        arrival_airline VARCHAR(255) NOT NULL,
                        price INT NOT NULL,
                        departure_date TIMESTAMP NOT NULL,
                        getting_back_date TIMESTAMP
);

INSERT INTO airway (city) VALUES
                              ('Istanbul'),
                              ('Ankara'),
                              ('İzmir'),
                              ('New York'),
                              ('Washington'),
                              ('Paris'),
                              ('Toronto'),
                              ('Madrid'),
                              ('Berlin'),
                              ('Dubai'),
                              ('London'),
                              ('Los Angles'),
                              ('Manchester'),
                              ('Liverpool'),
                              ('Tokyo');

INSERT INTO flight (departure_airline, arrival_airline, price, departure_date, getting_back_date)
VALUES
    ('Istanbul', 'Paris', 500, '2024-02-03 12:00:00', NULL),
    ('New York', 'London', 700, '2024-02-04 15:30:00', '2024-02-10 18:00:00'),
    ('Berlin', 'Tokyo', 900, '2024-02-05 10:45:00', '2024-02-15 22:30:00'),
    ('Dubai', 'Los Angeles', 1200, '2024-02-06 08:15:00', '2024-02-12 14:45:00'),
    ('Ankara', 'Madrid', 600, '2024-02-07 14:00:00', '2024-02-11 16:30:00'),
    ('Paris', 'Toronto', 800, '2024-02-08 17:45:00', '2024-02-14 20:15:00'),
    ('London', 'Berlin', 550, '2024-02-09 20:30:00', '2024-02-13 12:00:00'),
    ('Los Angeles', 'New York', 1000, '2024-02-10 09:30:00', '2024-02-16 16:45:00'),
    ('Tokyo', 'Istanbul', 1100, '2024-02-11 11:15:00', '2024-02-17 14:30:00'),
    ('Madrid', 'Dubai', 950, '2024-02-12 13:45:00', NULL),
    ('Istanbul', 'Washington', 1300, '2024-02-13 16:00:00', '2024-02-19 18:30:00'),
    ('Berlin', 'Paris', 700, '2024-02-14 18:30:00', '2024-02-20 22:00:00'),
    ('Toronto', 'Los Angeles', 850, '2024-02-15 21:00:00', '2024-02-21 14:15:00'),
    ('Los Angeles', 'New York', 1200, '2024-02-16 09:15:00', '2024-02-22 12:45:00'),
    ('New York', 'Paris', 600, '2024-02-17 12:30:00', '2024-02-23 16:00:00'),
    ('Washington', 'London', 950, '2024-02-18 15:45:00', '2024-02-24 18:15:00'),
    ('Istanbul', 'Tokyo', 1100, '2024-02-19 18:00:00', '2024-02-25 21:30:00'),
    ('Paris', 'Dubai', 1300, '2024-02-20 20:30:00', NULL),
    ('Toronto', 'Madrid', 900, '2024-02-21 23:15:00', '2024-02-27 12:45:00'),
    ('London', 'Berlin', 650, '2024-02-22 07:45:00', '2024-02-28 14:00:00');