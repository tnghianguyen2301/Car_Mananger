-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: car_manager
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `car_account`
--

DROP TABLE IF EXISTS `car_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car_account` (
  `account_id` int NOT NULL,
  `account_username` varchar(45) NOT NULL,
  `account_password` varchar(100) NOT NULL,
  `acount_name` varchar(45) NOT NULL,
  `acount_email` varchar(45) DEFAULT NULL,
  `acount_role` int DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car_account`
--

LOCK TABLES `car_account` WRITE;
/*!40000 ALTER TABLE `car_account` DISABLE KEYS */;
INSERT INTO `car_account` VALUES (1,'ducthanh','1000:6ba064a6f3899cea10291d0a11205f9a:e0164198b9400c28902db7672dc6319b','ronthanhyal@gmail.com','ducthanh',0);
/*!40000 ALTER TABLE `car_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car_customer`
--

DROP TABLE IF EXISTS `car_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car_customer` (
  `customer_id` int NOT NULL,
  `customer_name` varchar(45) NOT NULL,
  `customer_date` varchar(45) DEFAULT NULL,
  `customer_address` varchar(100) NOT NULL,
  `customer_phone` varchar(45) NOT NULL,
  `customer_products_id` int NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car_customer`
--

LOCK TABLES `car_customer` WRITE;
/*!40000 ALTER TABLE `car_customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `car_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car_history`
--

DROP TABLE IF EXISTS `car_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car_history` (
  `history_id` int NOT NULL AUTO_INCREMENT,
  `history_name` varchar(45) NOT NULL,
  `history_trademark` varchar(45) NOT NULL,
  `history_type` varchar(45) NOT NULL,
  `history_color` varchar(45) NOT NULL,
  `history_status` varchar(45) NOT NULL,
  `history_add_price` decimal(5,2) NOT NULL,
  `history_export_price` decimal(5,2) NOT NULL,
  `history_add_date` varchar(45) NOT NULL,
  `history_export_date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`history_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car_history`
--

LOCK TABLES `car_history` WRITE;
/*!40000 ALTER TABLE `car_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `car_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car_products`
--

DROP TABLE IF EXISTS `car_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car_products` (
  `products_id` int NOT NULL AUTO_INCREMENT,
  `products_name` varchar(45) NOT NULL,
  `products_trademark` varchar(45) NOT NULL,
  `products_type` varchar(45) NOT NULL,
  `products_color` varchar(45) NOT NULL,
  `products_status` varchar(45) NOT NULL,
  `products_add_price` decimal(5,2) NOT NULL,
  `products_add_date` varchar(45) NOT NULL,
  `products_check` varchar(45) NOT NULL,
  PRIMARY KEY (`products_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car_products`
--

LOCK TABLES `car_products` WRITE;
/*!40000 ALTER TABLE `car_products` DISABLE KEYS */;
/*!40000 ALTER TABLE `car_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car_staff`
--

DROP TABLE IF EXISTS `car_staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car_staff` (
  `staff_id` int NOT NULL,
  `staff_name` varchar(45) NOT NULL,
  `staff_date` varchar(45) NOT NULL,
  `staff_dateofstart` varchar(45) NOT NULL,
  `staff_position` varchar(45) NOT NULL,
  `staff_salary` decimal(5,2) NOT NULL,
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car_staff`
--

LOCK TABLES `car_staff` WRITE;
/*!40000 ALTER TABLE `car_staff` DISABLE KEYS */;
/*!40000 ALTER TABLE `car_staff` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-26 11:57:49
