-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.21-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for pizzadb
DROP DATABASE IF EXISTS `pizzadb`;
CREATE DATABASE IF NOT EXISTS `pizzadb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pizzadb`;


-- Dumping structure for table pizzadb.kayttaja
DROP TABLE IF EXISTS `kayttaja`;
CREATE TABLE IF NOT EXISTS `kayttaja` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nimi` varchar(255) NOT NULL,
  `rooli_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK__roolit` (`rooli_id`),
  CONSTRAINT `FK__roolit` FOREIGN KEY (`rooli_id`) REFERENCES `roolit` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table pizzadb.kayttaja: ~4 rows (approximately)
DELETE FROM `kayttaja`;
/*!40000 ALTER TABLE `kayttaja` DISABLE KEYS */;
INSERT INTO `kayttaja` (`id`, `nimi`, `rooli_id`) VALUES
	(1, 'Joni Joutava', 4),
	(2, 'Pepe Paistaja', 2),
	(3, 'Giorgio \'Il Grasso\' Pizzanotte', 1),
	(4, 'Sofia Nopsa', 3);
/*!40000 ALTER TABLE `kayttaja` ENABLE KEYS */;


-- Dumping structure for table pizzadb.roolit
DROP TABLE IF EXISTS `roolit`;
CREATE TABLE IF NOT EXISTS `roolit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rooli` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table pizzadb.roolit: ~4 rows (approximately)
DELETE FROM `roolit`;
/*!40000 ALTER TABLE `roolit` DISABLE KEYS */;
INSERT INTO `roolit` (`id`, `rooli`) VALUES
	(1, 'admin'),
	(2, 'valmistus'),
	(3, 'vastaanotto'),
	(4, 'toimitus');
/*!40000 ALTER TABLE `roolit` ENABLE KEYS */;


-- Dumping structure for table pizzadb.tilaaja
DROP TABLE IF EXISTS `tilaaja`;
CREATE TABLE IF NOT EXISTS `tilaaja` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nimi` varchar(255) NOT NULL,
  `kanta-asiakas` tinyint(4) NOT NULL DEFAULT '0',
  `osoite` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `puhelin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table pizzadb.tilaaja: ~4 rows (approximately)
DELETE FROM `tilaaja`;
/*!40000 ALTER TABLE `tilaaja` DISABLE KEYS */;
INSERT INTO `tilaaja` (`id`, `nimi`, `kanta-asiakas`, `osoite`, `email`, `puhelin`) VALUES
	(1, 'Teppo Tilaaja', 0, NULL, NULL, NULL),
	(2, 'Pipa Pizzansyöjä', 0, NULL, NULL, NULL),
	(3, 'Kero Kantis', 1, 'Kantiskuja 1 B 43/00750/Helsinki', 'kantispub@suomi24.fi', '0405124333'),
	(4, 'Veikko Vakkari', 1, 'Heikkiläntie 24/00760/Helsinki', 'veikko.vakkari@gmail.com', NULL);
/*!40000 ALTER TABLE `tilaaja` ENABLE KEYS */;


-- Dumping structure for table pizzadb.tilat
DROP TABLE IF EXISTS `tilat`;
CREATE TABLE IF NOT EXISTS `tilat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nimi` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table pizzadb.tilat: ~5 rows (approximately)
DELETE FROM `tilat`;
/*!40000 ALTER TABLE `tilat` DISABLE KEYS */;
INSERT INTO `tilat` (`id`, `nimi`) VALUES
	(1, 'vastaanotettu'),
	(2, 'valmistettavana'),
	(3, 'valmis'),
	(4, 'toimitettavana'),
	(5, 'toimitettu');
/*!40000 ALTER TABLE `tilat` ENABLE KEYS */;


-- Dumping structure for table pizzadb.tilaus
DROP TABLE IF EXISTS `tilaus`;
CREATE TABLE IF NOT EXISTS `tilaus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tilaaja_id` int(11) NOT NULL,
  `toimitustapa` varchar(255) NOT NULL,
  `maksutapa` varchar(255) DEFAULT NULL,
  `osoite` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK__tilaaja` (`tilaaja_id`),
  CONSTRAINT `FK__tilaaja` FOREIGN KEY (`tilaaja_id`) REFERENCES `tilaaja` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table pizzadb.tilaus: ~2 rows (approximately)
DELETE FROM `tilaus`;
/*!40000 ALTER TABLE `tilaus` DISABLE KEYS */;
INSERT INTO `tilaus` (`id`, `tilaaja_id`, `toimitustapa`, `maksutapa`, `osoite`) VALUES
	(1, 4, 'toimitus', 'käteinen', 'Heikkiläntie 24/00760/Helsinki'),
	(2, 1, 'nouto', NULL, NULL);
/*!40000 ALTER TABLE `tilaus` ENABLE KEYS */;


-- Dumping structure for table pizzadb.tilausloki
DROP TABLE IF EXISTS `tilausloki`;
CREATE TABLE IF NOT EXISTS `tilausloki` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tilaus_id` int(11) NOT NULL,
  `kayttaja_id` int(11) NOT NULL,
  `tilat_id` int(11) NOT NULL,
  `aikakoodi` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK__tilaus` (`tilaus_id`),
  KEY `FK__kayttaja` (`kayttaja_id`),
  KEY `FK__tilat` (`tilat_id`),
  CONSTRAINT `FK__kayttaja` FOREIGN KEY (`kayttaja_id`) REFERENCES `kayttaja` (`id`),
  CONSTRAINT `FK__tilat` FOREIGN KEY (`tilat_id`) REFERENCES `tilat` (`id`),
  CONSTRAINT `FK__tilaus` FOREIGN KEY (`tilaus_id`) REFERENCES `tilaus` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Dumping data for table pizzadb.tilausloki: ~8 rows (approximately)
DELETE FROM `tilausloki`;
/*!40000 ALTER TABLE `tilausloki` DISABLE KEYS */;
INSERT INTO `tilausloki` (`id`, `tilaus_id`, `kayttaja_id`, `tilat_id`, `aikakoodi`) VALUES
	(1, 1, 2, 2, '2014-10-14 20:20:37'),
	(2, 1, 2, 3, '2014-10-14 20:27:13'),
	(3, 2, 4, 1, '2014-10-14 20:27:46'),
	(4, 1, 1, 4, '2014-10-14 20:28:21'),
	(5, 1, 1, 5, '2014-10-14 20:33:51'),
	(6, 2, 2, 2, '2014-10-14 20:34:19'),
	(7, 2, 2, 3, '2014-10-14 20:38:07'),
	(8, 2, 4, 5, '2014-10-14 20:40:42');
/*!40000 ALTER TABLE `tilausloki` ENABLE KEYS */;


-- Dumping structure for table pizzadb.tilaustuote
DROP TABLE IF EXISTS `tilaustuote`;
CREATE TABLE IF NOT EXISTS `tilaustuote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tilaus_id` int(11) NOT NULL,
  `tuote_id` int(11) NOT NULL,
  `hinta` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK__tuote` (`tuote_id`),
  KEY `FK_tilaustuote_tilaus` (`tilaus_id`),
  CONSTRAINT `FK__tuote` FOREIGN KEY (`tuote_id`) REFERENCES `tuote` (`id`),
  CONSTRAINT `FK_tilaustuote_tilaus` FOREIGN KEY (`tilaus_id`) REFERENCES `tilaus` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table pizzadb.tilaustuote: ~3 rows (approximately)
DELETE FROM `tilaustuote`;
/*!40000 ALTER TABLE `tilaustuote` DISABLE KEYS */;
INSERT INTO `tilaustuote` (`id`, `tilaus_id`, `tuote_id`, `hinta`) VALUES
	(1, 1, 5, 11),
	(2, 1, 2, 12),
	(3, 2, 3, 11.5);
/*!40000 ALTER TABLE `tilaustuote` ENABLE KEYS */;


-- Dumping structure for table pizzadb.tuote
DROP TABLE IF EXISTS `tuote`;
CREATE TABLE IF NOT EXISTS `tuote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kuvaus` varchar(255) DEFAULT NULL,
  `nimi` varchar(255) DEFAULT NULL,
  `hinta` float NOT NULL,
  `tyyppi_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK__tyyppi` (`tyyppi_id`),
  CONSTRAINT `FK__tyyppi` FOREIGN KEY (`tyyppi_id`) REFERENCES `tyyppi` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table pizzadb.tuote: ~5 rows (approximately)
DELETE FROM `tuote`;
/*!40000 ALTER TABLE `tuote` DISABLE KEYS */;
INSERT INTO `tuote` (`id`, `kuvaus`, `nimi`, `hinta`, `tyyppi_id`) VALUES
	(1, 'Maistuvia merenherkkuja pizzan muodossa. Jaa vaikka kaverin kanssa!', 'Frutti di Mare', 10.2, 1),
	(2, 'Maailman parhaaksi valittu pizza! Savuporo, kantarelli ja pizzapohjan ruiskuitu vakuuttivat niin Amerikan tuomarit kuin italialaisen suomalaisen ruokaosaamisen epäilijänkin.', 'Berlusconi', 12, 1),
	(3, 'Pepperonimakkaraa tonnikalan seurana. Tuhti makuelämys ei jätä ketään nälkäiseksi.', 'Pepperoni', 11.5, 1),
	(4, 'Special Operan jokaiseen makuun! Perinteinen, loistokkaan makoisa.', 'Special Opera', 10, 1),
	(5, 'Kulinaristillekin kelpaa aurinkokuivatulla tomaatilla, salamilla, ananaksella ja mozzarellajuustolla aateloitu erikoisuus. Hienostuneet maut täydentävät toisiaan.', 'Mozarella', 11, 1);
/*!40000 ALTER TABLE `tuote` ENABLE KEYS */;


-- Dumping structure for table pizzadb.tyyppi
DROP TABLE IF EXISTS `tyyppi`;
CREATE TABLE IF NOT EXISTS `tyyppi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tuote` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table pizzadb.tyyppi: ~1 rows (approximately)
DELETE FROM `tyyppi`;
/*!40000 ALTER TABLE `tyyppi` DISABLE KEYS */;
INSERT INTO `tyyppi` (`id`, `tuote`) VALUES
	(1, 'Pizza');
/*!40000 ALTER TABLE `tyyppi` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
