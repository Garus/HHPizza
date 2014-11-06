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
-- Table structure for table `kayttaja`
--

DROP TABLE IF EXISTS `kayttaja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kayttaja` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tunnus` varchar(255) NOT NULL,
  `luotu_pvm` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `nimi` varchar(255) NOT NULL,
  `salasana` varchar(255) DEFAULT NULL,
  `rooli_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ckdnd5bereusu0oebg3yqcn5m` (`rooli_id`),
  CONSTRAINT `FK_ckdnd5bereusu0oebg3yqcn5m` FOREIGN KEY (`rooli_id`) REFERENCES `roolit` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kayttaja`
--

LOCK TABLES `kayttaja` WRITE;
/*!40000 ALTER TABLE `kayttaja` DISABLE KEYS */;
INSERT INTO `kayttaja` VALUES (1,'aku','2014-11-06 15:47:42','Ankka Admin',NULL,1),(2,'saku','2014-11-06 15:47:42','Sorsa User',NULL,2),(3,'kissa','2014-11-06 15:47:42','Kissa Käyttäjä',NULL,3);
/*!40000 ALTER TABLE `kayttaja` ENABLE KEYS */;
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
-- Table structure for table `tilaus`
--

DROP TABLE IF EXISTS `tilaus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tilaus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `maksutapa` varchar(255) DEFAULT NULL,
  `osoite` varchar(255) DEFAULT NULL,
  `toimitustapa` varchar(255) NOT NULL,
  `tilaaja_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tilaus`
--

LOCK TABLES `tilaus` WRITE;
/*!40000 ALTER TABLE `tilaus` DISABLE KEYS */;
/*!40000 ALTER TABLE `tilaus` ENABLE KEYS */;
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
  CONSTRAINT `FK_ojbt8e1dbbtqcbl1tl9me3xix` FOREIGN KEY (`tilaus_id`) REFERENCES `tilaus` (`id`),
  CONSTRAINT `FK_5324joh474r7lu8mqrjpvmvru` FOREIGN KEY (`tilat_id`) REFERENCES `tilat` (`id`),
  CONSTRAINT `FK_afq8rodde8l3ut2q6bl34hw2l` FOREIGN KEY (`kayttaja_id`) REFERENCES `kayttaja` (`id`)
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
  CONSTRAINT `FK_awfk628mrwdk1nvjtokpjmy4e` FOREIGN KEY (`tilaus_id`) REFERENCES `tilaus` (`id`)
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tuotteet`
--

LOCK TABLES `tuotteet` WRITE;
/*!40000 ALTER TABLE `tuotteet` DISABLE KEYS */;
INSERT INTO `tuotteet` VALUES (1,20,'Maistuvia merenherkkuja pizzan muodossa. Jaa vaikka kaverin kanssa!','Frutti Di Mare'),(2,20,'Maailman parhaaksi valittu pizza! Savuporo, kantarelli ja pizzapohjan ruiskuitu vakuuttivat niin Amerikan tuomarit kuin italialaisen suomalaisen ruokaosaamisen epäilijänkin.','Berlusconi'),(3,20.5,'Pepperonimakkaraa tonnikalan seurana. Tuhti makuelämys ei jätä ketään nälkäiseksi.','Pepperoni'),(4,21,'Special Operan jokaiseen makuun! Perinteinen, loistokkaan makoisa.','Special Opera'),(5,29,'Kulinaristillekin kelpaa aurinkokuivatulla tomaatilla, salamilla, ananaksella ja mozzarellajuustolla aateloitu erikoisuus. Hienostuneet maut täydentävät toisiaan.','Mozarella'),(6,0,'bar','foo');
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

-- Dump completed on 2014-11-06 17:51:23
