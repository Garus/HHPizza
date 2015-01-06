-- MySQL dump 10.13  Distrib 5.5.40, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: pizzadb
-- ------------------------------------------------------
-- Server version	5.5.40-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `juomat`
--

DROP TABLE IF EXISTS `juomat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `juomat` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_7xr9iq9birkm28v2yy312pj7m` FOREIGN KEY (`id`) REFERENCES `tuotteet` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `juomat`
--

LOCK TABLES `juomat` WRITE;
/*!40000 ALTER TABLE `juomat` DISABLE KEYS */;
INSERT INTO `juomat` VALUES (6),(7),(8);
/*!40000 ALTER TABLE `juomat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kategoria_tuotteet`
--

DROP TABLE IF EXISTS `kategoria_tuotteet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kategoria_tuotteet` (
  `kategoriat_kategoriaId` int(11) NOT NULL,
  `tuotteet_id` int(11) NOT NULL,
  UNIQUE KEY `UK_33muf7yy98l2kyv32md59c5n6` (`tuotteet_id`),
  KEY `FK_tbghnyshkenie1fx2o57lmjq5` (`kategoriat_kategoriaId`),
  CONSTRAINT `FK_tbghnyshkenie1fx2o57lmjq5` FOREIGN KEY (`kategoriat_kategoriaId`) REFERENCES `kategoriat` (`kategoriaId`),
  CONSTRAINT `FK_33muf7yy98l2kyv32md59c5n6` FOREIGN KEY (`tuotteet_id`) REFERENCES `tuotteet` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kategoria_tuotteet`
--

LOCK TABLES `kategoria_tuotteet` WRITE;
/*!40000 ALTER TABLE `kategoria_tuotteet` DISABLE KEYS */;
INSERT INTO `kategoria_tuotteet` VALUES (1,1),(1,2),(2,3),(2,4),(2,5),(3,6),(3,7),(3,8);
/*!40000 ALTER TABLE `kategoria_tuotteet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kategoriat`
--

DROP TABLE IF EXISTS `kategoriat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kategoriat` (
  `kategoriaId` int(11) NOT NULL AUTO_INCREMENT,
  `kategoriaNimi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`kategoriaId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kategoriat`
--

LOCK TABLES `kategoriat` WRITE;
/*!40000 ALTER TABLE `kategoriat` DISABLE KEYS */;
INSERT INTO `kategoriat` VALUES (1,'Pizzat'),(2,'Pannupizzat'),(3,'Juomat');
/*!40000 ALTER TABLE `kategoriat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kayttajat`
--

DROP TABLE IF EXISTS `kayttajat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kayttajat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tunnus` varchar(255) NOT NULL,
  `luotu_pvm` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `nimi` varchar(255) NOT NULL,
  `salasana` varchar(255) DEFAULT NULL,
  `rooli_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_sooo6jq1en9l0nbkkbraqqc1a` (`rooli_id`),
  CONSTRAINT `FK_sooo6jq1en9l0nbkkbraqqc1a` FOREIGN KEY (`rooli_id`) REFERENCES `roolit` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kayttajat`
--

LOCK TABLES `kayttajat` WRITE;
/*!40000 ALTER TABLE `kayttajat` DISABLE KEYS */;
INSERT INTO `kayttajat` VALUES (1,'aku','2015-01-06 19:54:11','Ankka Admin',NULL,1),(2,'saku','2015-01-06 19:54:11','Sorsa User',NULL,2),(3,'kissa','2015-01-06 19:54:11','Kissa Käyttäjä',NULL,3);
/*!40000 ALTER TABLE `kayttajat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lisa_aineet`
--

DROP TABLE IF EXISTS `lisa_aineet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lisa_aineet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hinta` double NOT NULL,
  `nimi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lisa_aineet`
--

LOCK TABLES `lisa_aineet` WRITE;
/*!40000 ALTER TABLE `lisa_aineet` DISABLE KEYS */;
INSERT INTO `lisa_aineet` VALUES (1,1.5,'valkosipuli'),(2,0.5,'oregano'),(3,2,'kanamuna');
/*!40000 ALTER TABLE `lisa_aineet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pizzat`
--

DROP TABLE IF EXISTS `pizzat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pizzat` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_kprn50bog6ohc98079frfn2d0` FOREIGN KEY (`id`) REFERENCES `tuotteet` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizzat`
--

LOCK TABLES `pizzat` WRITE;
/*!40000 ALTER TABLE `pizzat` DISABLE KEYS */;
INSERT INTO `pizzat` VALUES (1),(2),(3),(4),(5),(9);
/*!40000 ALTER TABLE `pizzat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roolit`
--

DROP TABLE IF EXISTS `roolit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roolit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rooli` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roolit`
--

LOCK TABLES `roolit` WRITE;
/*!40000 ALTER TABLE `roolit` DISABLE KEYS */;
INSERT INTO `roolit` VALUES (1,'admin'),(2,'superuser'),(3,'kayttaja');
/*!40000 ALTER TABLE `roolit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tilaajat`
--

DROP TABLE IF EXISTS `tilaajat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tilaajat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `kanta_asiakas` bit(1) NOT NULL,
  `nimi` varchar(255) NOT NULL,
  `katuOsoite` varchar(255) DEFAULT NULL,
  `postiNumero` varchar(255) DEFAULT NULL,
  `postiToimiPaikka` varchar(255) DEFAULT NULL,
  `puhelin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tilaajat`
--

LOCK TABLES `tilaajat` WRITE;
/*!40000 ALTER TABLE `tilaajat` DISABLE KEYS */;
/*!40000 ALTER TABLE `tilaajat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tilat`
--

DROP TABLE IF EXISTS `tilat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tilat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nimi` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tilat`
--

LOCK TABLES `tilat` WRITE;
/*!40000 ALTER TABLE `tilat` DISABLE KEYS */;
/*!40000 ALTER TABLE `tilat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tilaukset`
--

DROP TABLE IF EXISTS `tilaukset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tilaukset` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `maksutapa` varchar(255) DEFAULT NULL,
  `osoite` varchar(255) DEFAULT NULL,
  `toimitustapa` varchar(255) NOT NULL,
  `tilaaja_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_djx4b9r91a310h8x1k9r3jtsu` (`tilaaja_id`),
  CONSTRAINT `FK_djx4b9r91a310h8x1k9r3jtsu` FOREIGN KEY (`tilaaja_id`) REFERENCES `tilaajat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tilaukset`
--

LOCK TABLES `tilaukset` WRITE;
/*!40000 ALTER TABLE `tilaukset` DISABLE KEYS */;
/*!40000 ALTER TABLE `tilaukset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tilausloki`
--

DROP TABLE IF EXISTS `tilausloki`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tilausloki` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aikakoodi` datetime NOT NULL,
  `kayttaja_id` int(11) NOT NULL,
  `tilat_id` int(11) NOT NULL,
  `tilaus_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_afq8rodde8l3ut2q6bl34hw2l` (`kayttaja_id`),
  KEY `FK_5324joh474r7lu8mqrjpvmvru` (`tilat_id`),
  KEY `FK_ojbt8e1dbbtqcbl1tl9me3xix` (`tilaus_id`),
  CONSTRAINT `FK_ojbt8e1dbbtqcbl1tl9me3xix` FOREIGN KEY (`tilaus_id`) REFERENCES `tilaukset` (`id`),
  CONSTRAINT `FK_5324joh474r7lu8mqrjpvmvru` FOREIGN KEY (`tilat_id`) REFERENCES `tilat` (`id`),
  CONSTRAINT `FK_afq8rodde8l3ut2q6bl34hw2l` FOREIGN KEY (`kayttaja_id`) REFERENCES `kayttajat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tilausloki`
--

LOCK TABLES `tilausloki` WRITE;
/*!40000 ALTER TABLE `tilausloki` DISABLE KEYS */;
/*!40000 ALTER TABLE `tilausloki` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tilaustuote`
--

DROP TABLE IF EXISTS `tilaustuote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tilaustuote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hinta` float NOT NULL,
  `tilaus_id` int(11) NOT NULL,
  `tuote_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_awfk628mrwdk1nvjtokpjmy4e` (`tilaus_id`),
  KEY `FK_ecuim19wcpykd2m4v5ak5vv6e` (`tuote_id`),
  CONSTRAINT `FK_ecuim19wcpykd2m4v5ak5vv6e` FOREIGN KEY (`tuote_id`) REFERENCES `tuotteet` (`id`),
  CONSTRAINT `FK_awfk628mrwdk1nvjtokpjmy4e` FOREIGN KEY (`tilaus_id`) REFERENCES `tilaukset` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tilaustuote`
--

LOCK TABLES `tilaustuote` WRITE;
/*!40000 ALTER TABLE `tilaustuote` DISABLE KEYS */;
/*!40000 ALTER TABLE `tilaustuote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tuotteet`
--

DROP TABLE IF EXISTS `tuotteet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tuotteet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hinta` double NOT NULL,
  `kuvaus` varchar(255) DEFAULT NULL,
  `nimi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tuotteet`
--

LOCK TABLES `tuotteet` WRITE;
/*!40000 ALTER TABLE `tuotteet` DISABLE KEYS */;
INSERT INTO `tuotteet` VALUES (1,25,'Maistuvia merenherkkuja pizzan muodossa. Jaa vaikka kaverin kanssa!','Mare di Frutti'),(2,20,'Maailman parhaaksi valittu pizza! Savuporo, kantarelli ja pizzapohjan ruiskuitu vakuuttivat niin Amerikan tuomarit kuin italialaisen suomalaisen ruokaosaamisen epäilijänkin.','Berlusconi'),(3,20.5,'Pepperonimakkaraa tonnikalan seurana. Tuhti makuelämys ei jätä ketään nälkäiseksi.','Pepperoni'),(4,21,'Special Operan jokaiseen makuun! Perinteinen, loistokkaan makoisa.','Special Opera'),(5,29,'Kulinaristillekin kelpaa aurinkokuivatulla tomaatilla, salamilla, ananaksella ja mozzarellajuustolla aateloitu erikoisuus. Hienostuneet maut täydentävät toisiaan.','Mozarella'),(6,5.5,'Pepsi-Cola 1,5L','Pepsi'),(7,5,'Coca-Cola 1,5L','Coke'),(8,3.5,'Pepsi-Cola 0,5L','Pepsi'),(9,10,'Reilusti silliii ja haukii.','Sillipitsa');
/*!40000 ALTER TABLE `tuotteet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-01-06 21:56:57
