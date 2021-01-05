CREATE TABLE artists (id INT PRIMARY KEY, name VARCHAR(30), alias VARCHAR(30) NULL, birthdate DATE, description VARCHAR(300) NULL);
CREATE TABLE projects (id INT PRIMARY KEY, name VARCHAR(50), artist VARCHAR(50), artist_id INT, rating DECIMAL(11,0), reveiws INT, release_date DATE, type ENUM('ALBUM', 'SINGLE', 'EP', 'MIXTAPE'));