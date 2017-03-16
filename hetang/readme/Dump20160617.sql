-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hetang
-- ------------------------------------------------------
-- Server version	5.7.10-log

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` varchar(40) NOT NULL,
  `num` varchar(40) NOT NULL,
  `name` varchar(20) NOT NULL,
  `remark` varchar(200) DEFAULT '',
  `state` tinyint(1) DEFAULT '0' COMMENT '0是未封锁,1是封锁',
  `createdTime` bigint(20) DEFAULT NULL,
  `lastAccessTime` bigint(20) DEFAULT '0',
  `userType` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `num` (`num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1d146546-1375-49ff-97ff-9e6fdfc42005','num','weidiaohaha','战无不胜,攻无不克',1,1466073355044,2134,0),('320d837b-af06-4e77-af89-81e6e49ad02c','8977867','孙悟空','悟空',1,1466137562224,0,0),('324','asdf','魏印福','春江潮水连海平',1,234523452345,2345,0),('4565','fd','fg','滟滟随波千万里',1,4353452534,456,1),('62f90d92-4350-4eb5-8cd1-5a684d13bcc6','sadjkflsdadf','为什么','哈哈哈',0,1466137747348,0,0),('79ea4f78-07c9-4e8d-a7f4-742b76fba41d','asdfsdafasdfasdf','李周五 ','阿萨德飞洒发',0,1466137487271,0,0),('ab941a4b-724d-4072-b5b5-b2d3219d0e57','asdfsdaf','赵钱孙','阿萨德飞洒发',0,1466137259372,0,0),('e2acd4a7-aa33-44ca-a5a2-2aecb47c2fab','sadfa','为','什么',0,1466137674752,0,0),('ec355f9a-d481-4284-8c53-eb2ec10a1e31','32434','way in fool','独孤求败',0,1466137804735,0,2),('sdf','da','df','何处春江无月明',0,234523454656,4356,2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'hetang'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-17 13:34:08
