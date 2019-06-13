CREATE DATABASE  IF NOT EXISTS `dreamjob` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `dreamjob`;
-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: contraderjava
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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `usertype` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
	`password` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Insert all users';
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;

CREATE TABLE `company` (
  `companyid` int(11) NOT NULL AUTO_INCREMENT,
  `companyname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `companyinfo` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
     `companylanguage` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
      `companyskills` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
	`companystatus` bool,
  PRIMARY KEY (`companyid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Insert all companyinfo';
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;

CREATE TABLE `users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `surname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `age` int(2) COLLATE utf8_unicode_ci NOT NULL,
  `userinfo` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
   `userlanguage` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
    `usereducation` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
     `userexperience` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
      `userskills` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
	`userstatus` bool,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Insert all userinfo';
/*!40101 SET character_set_client = @saved_cs_client */;