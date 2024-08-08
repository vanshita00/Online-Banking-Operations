INSERT INTO clients (username, password, name, date_of_birth, initial_balance, current_balance, max_balance)
VALUES ('john_doe', 'password', 'John Doe', '1980-01-01', 1000.00, 1000.00, 2070.00);

INSERT INTO contacts (client_id, type, value)
VALUES (1, 'phone', '123-456-7890');

INSERT INTO contacts (client_id, type, value)
VALUES (1, 'email', 'john.doe@example.com');
