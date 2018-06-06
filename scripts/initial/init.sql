CREATE DATABASE Akuna;
CREATE USER akuna_std WITH PASSWORD 'akuna_std';
GRANT ALL ON DATABASE Akuna to akuna_std;

-- Connect to the distinct DB as postgres

CREATE SCHEMA IF NOT EXISTS akuna_std AUTHORIZATION akuna_std;
GRANT ALL PRIVILEGES ON SCHEMA akuna_std TO akuna_std;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA akuna_std TO akuna_std;