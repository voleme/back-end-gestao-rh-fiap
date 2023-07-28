CREATE TABLE `empregados` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cargo` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);