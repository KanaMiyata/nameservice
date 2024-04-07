DROP TABLE IF EXISTS names;

CREATE TABLE names (
 id int unsigned AUTO_INCREMENT,
 name VARCHAR(20) NOT NULL,
    age INT,
 PRIMARY KEY(id)
);

INSERT INTO names (name, age) VALUES ('Kana', 32);
INSERT INTO names (name, age) VALUES ('Naoko', 30);
INSERT INTO names (name, age) VALUES ('Cisco', 31);