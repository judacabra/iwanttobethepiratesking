-- DB
CREATE DATABASE pirates
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

-- Trigger
CREATE TRIGGER after_insert_character
AFTER INSERT ON `character`
FOR EACH ROW
BEGIN
    INSERT INTO character_crew (id_character, id_crew)
    VALUES ((SELECT MAX(id) FROM `character`), (SELECT crew FROM `character` WHERE id = (SELECT MAX(id) FROM `character`)));
END;

-- Inserts --
--Profile
INSERT INTO `profile` (`id`, `name`) 
VALUES 
(1, 'admin'),
(2, 'client');

-- User
INSERT INTO `user` (`id`, `name`, `password`, `profile`, `username`) 
VALUES 
(1, 'User admin', '1234', 1, 'Administrator'),
(2, 'User client', '5678', 2, 'UserClient');

