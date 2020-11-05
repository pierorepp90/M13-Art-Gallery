DROP TABLE IF EXISTS `store`;

CREATE TABLE `store` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  `adress` varchar(250) NOT NULL,
  `capacity` int(40) NOT NULL,
  PRIMARY KEY (`id`)
);

DROP table IF EXISTS `picture`;

CREATE TABLE `picture` (
  `id` int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `title` varchar(250) NOT NULL,
  `author` varchar(250) DEFAULT NULL,
  `date` datetime NOT NULL,
  `store_id` int(5) NOT NULL,
   FOREIGN KEY (`store_id`) REFERENCES `store` (`id`)
);

