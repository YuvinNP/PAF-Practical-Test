-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: healthcare
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `payment_card`
--

DROP TABLE IF EXISTS `payment_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `payment_card` (
  `payment_credit_card_id` int(11) NOT NULL AUTO_INCREMENT,
  `cardNo` varchar(16) NOT NULL,
  `expDate` varchar(12) NOT NULL,
  `cardPassCode` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`payment_credit_card_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_card`
--

LOCK TABLES `payment_card` WRITE;
/*!40000 ALTER TABLE `payment_card` DISABLE KEYS */;
INSERT INTO `payment_card` VALUES (1,'8000200030004000','2021-12-12','123'),(2,'4000200050006000','2021-12-12','234');
/*!40000 ALTER TABLE `payment_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `payments` (
  `paymentId` varchar(10) NOT NULL,
  `patientId` varchar(10) NOT NULL,
  `patientName` varchar(45) NOT NULL,
  `appointmentId` varchar(10) NOT NULL,
  `doctorId` varchar(10) NOT NULL,
  `hospitalId` varchar(10) NOT NULL,
  `paymentDate` varchar(15) NOT NULL,
  `paymentTime` varchar(15) NOT NULL,
  `doctorCharges` double NOT NULL,
  `hospitalCharges` double NOT NULL,
  `totalAmount` double NOT NULL,
  `telPhone` char(10) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `paymentStatus` varchar(10) NOT NULL,
  PRIMARY KEY (`paymentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments`
--

LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
INSERT INTO `payments` VALUES ('PY1','P001','Yuvin Perera','APP001','H.D Perera','H001','2020-04-21','20:52:37.245',1500,2000,3500,'0770098395','testuser123@gmail.com','cancel'),('PY10','P101','Yuvin Nimnaka','APP002','D202','H202','2020-05-04','21:11:45.687',1000,1000,2000,'0770098395','yuvinnimnakaperera@gmail.com','cancel'),('PY11','P102','test User','APP002','D203','H203','2020-05-04','22:05:14.914',1000,1000,2000,'0770098395','yuvinnimnaka1998@gmail.com','cancel'),('PY3','101','Yuvi Nimnaka','APP001','D202','H03','2020-04-22','10:39:49.983',1200,500,1700,'0770098395','yuvinn%40gmail.com','cancel'),('PY4','101','Yuvi Nimnaka','APP002','D202','H03','2020-04-22','10:40:54.015',1200,500,1700,'0770098395','yuvin@gmail.com','cancel'),('PY5','101','Y Nimnaka','APP003','D202','H03','2020-04-22','12:38:43.659',1200,500,1700,'0770776654','yuvinpereranimnaka%40gmail.com','cancel'),('PY6','P102','Yuvin Nimnaka','APP001','D203','H203','2020-05-03','18:57:20.857',1000,1000,2000,'0770098392','yuvinnimnaka@gmail.com','active'),('PY7','P102','Yuvin Nimnaka','APP003','D203','H203','2020-05-04','14:59:01.231',1000,1000,2000,'0770098395','yuvinnimnakayn@gmail.com','active'),('PY8','P103','Yuvin Nimnaka','APP001','D203','H203','2020-05-04','15:07:22.097',1000,1000,2000,'0770098395','yuvinnimnaka1998@gmail.com','active'),('PY9','P102','Yuvin Nimnaka','APP001','D204','H202','2020-05-04','15:12:57.287',1000,1000,2000,'0770098392','yuvinnimnaka1998@gmail.com','active');
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'healthcare'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-05  8:17:22
