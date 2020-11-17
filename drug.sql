-- MySQL dump 10.13  Distrib 8.0.22, for osx10.15 (x86_64)
--
-- Host: localhost    Database: drug
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `druglist1`
--

DROP TABLE IF EXISTS `druglist1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `druglist1` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `createdtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `account` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `druglist1`
--

LOCK TABLES `druglist1` WRITE;
/*!40000 ALTER TABLE `druglist1` DISABLE KEYS */;
INSERT INTO `druglist1` VALUES (4,'111','2020-11-17 11:36:04','12345678901'),(5,'123','2020-11-17 11:59:02','12345678901');
/*!40000 ALTER TABLE `druglist1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `druglist2`
--

DROP TABLE IF EXISTS `druglist2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `druglist2` (
  `id` int NOT NULL AUTO_INCREMENT,
  `drugimage` text NOT NULL,
  `drugname` varchar(50) NOT NULL,
  `drugdesc` varchar(200) DEFAULT NULL,
  `drugcreatedtime` timestamp NOT NULL,
  `createdtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id2` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `aaa` (`id2`),
  CONSTRAINT `aaa` FOREIGN KEY (`id2`) REFERENCES `druglist1` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `druglist2`
--

LOCK TABLES `druglist2` WRITE;
/*!40000 ALTER TABLE `druglist2` DISABLE KEYS */;
INSERT INTO `druglist2` VALUES (9,'http://zhx03.run8.top/2020/11/17/904f11b513454b7a83c1af22be5d339e.jpg','33','33333','2020-11-17 13:08:55','2020-11-17 13:09:02',5),(10,'http://zhx03.run8.top/2020/11/17/69821d845c1649ef9efd499c26ef6f89.jpg','1111111','12312312321321','2020-11-17 13:11:43','2020-11-17 13:11:50',4),(11,'http://zhx03.run8.top/2020/11/17/46aa820f650c41ad9b0e350cccd41b71.jpg','2222222','23131312312312321321','2020-11-17 13:57:16','2020-11-17 13:57:23',4);
/*!40000 ALTER TABLE `druglist2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guardianship`
--

DROP TABLE IF EXISTS `guardianship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guardianship` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account` varchar(50) NOT NULL,
  `beaccount` varchar(50) NOT NULL,
  `createdtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `onlyaccount` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `onlyaccount` (`onlyaccount`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guardianship`
--

LOCK TABLES `guardianship` WRITE;
/*!40000 ALTER TABLE `guardianship` DISABLE KEYS */;
INSERT INTO `guardianship` VALUES (1,'12345678901','23456789012','2020-10-24 05:28:45','1234567890123456789012'),(2,'15720989670','12345678901','2020-10-25 01:45:11','1572098967012345678901'),(3,'15720989670','23456789012','2020-10-25 01:52:44','1572098967023456789012'),(4,'23456789012','15720989670','2020-10-25 02:50:07','2345678901215720989670');
/*!40000 ALTER TABLE `guardianship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `remind`
--

DROP TABLE IF EXISTS `remind`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `remind` (
  `id` int NOT NULL AUTO_INCREMENT,
  `drugimage` text,
  `drugname` varchar(20) NOT NULL,
  `drugdesc` varchar(200) NOT NULL,
  `drugcreatedtime` timestamp NOT NULL,
  `drugtaketime` timestamp NOT NULL,
  `drugstatus` tinyint(1) DEFAULT '0',
  `createdtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `account` varchar(50) NOT NULL,
  `emailstatus` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `account` (`account`),
  CONSTRAINT `remind_ibfk_1` FOREIGN KEY (`account`) REFERENCES `userinfo` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `remind`
--

LOCK TABLES `remind` WRITE;
/*!40000 ALTER TABLE `remind` DISABLE KEYS */;
INSERT INTO `remind` VALUES (1,'http://zhx03.run8.top/2020/10/24/b3a0d6ed5a6c40238474679ec8068d11.jpg','板蓝根','不知道','2018-10-24 07:18:17','2020-10-25 07:18:22',0,'2020-10-24 07:18:33','15720989670',0),(2,'http://zhx03.run8.top/2020/10/25/b76a7a9b789944668f77ea9f44f2a3fa.jpg','测试','催你贺岁哦人家都知道啊我在吃饭啊？我不懂什么的啊啊啊啊啊啊啊啊啊啊啊啊','2020-10-25 02:01:40','2020-10-27 02:01:42',0,'2020-10-25 02:01:52','23456789012',0),(3,'http://zhx03.run8.top/2020/11/17/69821d845c1649ef9efd499c26ef6f89.jpg','1111111','12312312321321','2020-11-17 13:11:43','2020-11-17 14:36:32',0,'2020-11-17 14:11:02','12345678901',0),(4,'http://zhx03.run8.top/2020/11/17/46aa820f650c41ad9b0e350cccd41b71.jpg','2222222','23131312312312321321','2020-11-17 13:57:16','2020-11-17 14:49:52',0,'2020-11-17 14:46:13','12345678901',1);
/*!40000 ALTER TABLE `remind` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userinfo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `account` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES (1,'1111','12345678901','1111','634448817@qq.com'),(2,'222','23456789012','222',NULL),(3,'333','34567890123','333',NULL),(4,'四号','15720989670','444',NULL);
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-17 23:22:57
