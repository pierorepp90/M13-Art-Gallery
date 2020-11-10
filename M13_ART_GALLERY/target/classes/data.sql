CREATE DATABASE  IF NOT EXISTS `data`;
USE `data`;

DROP table IF EXISTS `picture`;
DROP TABLE IF EXISTS `store`;

CREATE TABLE `store` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  `adress` varchar(250) NOT NULL,
  `capacity` int(40) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `picture` (
  `id` int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `title` varchar(250) NOT NULL,
  `author` varchar(250) DEFAULT NULL,
  `date` datetime NOT NULL,
  `store_id` int(5) NOT NULL,
   FOREIGN KEY (`store_id`) REFERENCES `store` (`id`)
);


INSERT INTO store (name,adress,capacity)values('The legal art store','Nosuspiciusstreet 1',9000),
('Stole it, sell it','fake street 123',400);


INSERT INTO picture (title, author, date ,store_id) values ('Mona Lisa','Leonardo Da Vinci', NOW(), 1),
 ('Girl with a Pearl Earring','Johannes Vermeer', NOW(),1),
 ('The Starry Night','Vincent van Gogh', NOW(),2),
 ('Arrangement in Grey and Black','James Abbott McNeill Whistler', NOW(),2),
 ('Africanos de Hollywood','Jean-Michel Basquiat',NOW(),2);
