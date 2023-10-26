-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: agendasalaodb
-- ------------------------------------------------------
-- Server version	5.6.12-log

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
-- Table structure for table `agdpedidoservico`
--

DROP TABLE IF EXISTS `agdpedidoservico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agdpedidoservico` (
  `agenda_id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente_cliente_id` int(11) NOT NULL,
  `avaliacao_avaliacao_id` int(11) NOT NULL,
  `status_serv_status_ser_id` int(11) NOT NULL,
  `horarios_vaga_id` int(11) NOT NULL,
  `salao_servico_ofer_servico_servico_id` int(11) NOT NULL,
  PRIMARY KEY (`agenda_id`,`horarios_vaga_id`),
  KEY `fk_horario_cliente1_idx` (`cliente_cliente_id`),
  KEY `fk_agendamentopedido_avaliacao1_idx` (`avaliacao_avaliacao_id`),
  KEY `fk_agdpedidoservico_status_serv1_idx` (`status_serv_status_ser_id`),
  KEY `fk_agdpedidoservico_horarios1_idx` (`horarios_vaga_id`),
  KEY `fk_agdpedidoservico_salao_servico_ofer1_idx` (`salao_servico_ofer_servico_servico_id`),
  CONSTRAINT `fk_horario_cliente1` FOREIGN KEY (`cliente_cliente_id`) REFERENCES `cliente` (`cliente_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_agendamentopedido_avaliacao1` FOREIGN KEY (`avaliacao_avaliacao_id`) REFERENCES `avaliacao` (`avaliacao_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_agdpedidoservico_status_serv1` FOREIGN KEY (`status_serv_status_ser_id`) REFERENCES `status_serv` (`status_ser_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_agdpedidoservico_horarios1` FOREIGN KEY (`horarios_vaga_id`) REFERENCES `horarios` (`vaga_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_agdpedidoservico_salao_servico_ofer1` FOREIGN KEY (`salao_servico_ofer_servico_servico_id`) REFERENCES `salao_servico_ofer` (`servico_servico_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agdpedidoservico`
--

LOCK TABLES `agdpedidoservico` WRITE;
/*!40000 ALTER TABLE `agdpedidoservico` DISABLE KEYS */;
INSERT INTO `agdpedidoservico` VALUES (1,1,1,1,1,1),(2,2,1,3,2,2),(3,3,1,2,3,4),(4,4,1,2,4,5);
/*!40000 ALTER TABLE `agdpedidoservico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avaliacao`
--

DROP TABLE IF EXISTS `avaliacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avaliacao` (
  `avaliacao_id` int(11) NOT NULL AUTO_INCREMENT,
  `avaliacao` int(1) NOT NULL,
  PRIMARY KEY (`avaliacao_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliacao`
--

LOCK TABLES `avaliacao` WRITE;
/*!40000 ALTER TABLE `avaliacao` DISABLE KEYS */;
INSERT INTO `avaliacao` VALUES (1,3),(2,5),(3,6),(4,2),(5,7);
/*!40000 ALTER TABLE `avaliacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cidade`
--

DROP TABLE IF EXISTS `cidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cidade` (
  `cidade_id` int(11) NOT NULL AUTO_INCREMENT,
  `cidade_nome` varchar(75) NOT NULL,
  `estado_estado_id` int(11) NOT NULL,
  PRIMARY KEY (`cidade_id`),
  KEY `fk_cidade_estado_idx` (`estado_estado_id`),
  CONSTRAINT `fk_cidade_estado` FOREIGN KEY (`estado_estado_id`) REFERENCES `estado` (`estado_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidade`
--

LOCK TABLES `cidade` WRITE;
/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
INSERT INTO `cidade` VALUES (1,'cidade1',1),(2,'cidade2',1),(3,'cidade3',2),(4,'cidade4',2),(5,'cidade5',3),(6,'cidade6',3);
/*!40000 ALTER TABLE `cidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `cliente_id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente_nome` varchar(75) NOT NULL,
  `cliente_sobrenome` varchar(75) NOT NULL,
  `cliente_cpf` varchar(11) NOT NULL,
  `cliente_telefone` varchar(11) NOT NULL,
  `cliente_email` varchar(100) NOT NULL,
  `endereco_endereco_id` int(11) NOT NULL,
  PRIMARY KEY (`cliente_id`),
  KEY `fk_cliente_endereco1_idx` (`endereco_endereco_id`),
  CONSTRAINT `fk_cliente_endereco1` FOREIGN KEY (`endereco_endereco_id`) REFERENCES `endereco` (`endereco_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'cliente1','sobrenome1','123','123','email1',8),(2,'cliente2','sobrenome2','456','456','email2',9),(3,'cliente3','sobrenome3','789','789','email3',11),(4,'cliente4','sobrenome4','012','012','email4',13);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `endereco_id` int(11) NOT NULL AUTO_INCREMENT,
  `endereco_bairro` varchar(45) NOT NULL,
  `endereco_rua` varchar(75) NOT NULL,
  `endereco_numero` int(5) NOT NULL,
  `endereco_complemento` varchar(75) NOT NULL,
  `cidade_cidade_id` int(11) NOT NULL,
  PRIMARY KEY (`endereco_id`),
  KEY `fk_endereco_cidade1_idx` (`cidade_cidade_id`),
  CONSTRAINT `fk_endereco_cidade1` FOREIGN KEY (`cidade_cidade_id`) REFERENCES `cidade` (`cidade_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (8,'bairro1','rua1',123,'casa1',1),(9,'bairro2','rua2',456,'casa2',1),(10,'bairro3','rua3',789,'casa3',1),(11,'bairro4','rua4',12,'casa4',2),(12,'bairro5','rua5',345,'casa5',2),(13,'bairro6','rua6',678,'casa6',3);
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado` (
  `estado_id` int(11) NOT NULL AUTO_INCREMENT,
  `estado_nome` varchar(75) NOT NULL,
  `estado_codigo` varchar(2) NOT NULL,
  PRIMARY KEY (`estado_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (1,'Santa Catarina','SC'),(2,'Parana','PR'),(3,'Rio Grande do Sul','RS');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horarios`
--

DROP TABLE IF EXISTS `horarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horarios` (
  `vaga_id` int(11) NOT NULL AUTO_INCREMENT,
  `vaga_inicil` datetime NOT NULL,
  `vaga_final` datetime NOT NULL,
  `salao_salao_id` int(11) NOT NULL,
  PRIMARY KEY (`vaga_id`),
  KEY `fk_horarios_salao1_idx` (`salao_salao_id`),
  CONSTRAINT `fk_horarios_salao1` FOREIGN KEY (`salao_salao_id`) REFERENCES `salao` (`salao_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horarios`
--

LOCK TABLES `horarios` WRITE;
/*!40000 ALTER TABLE `horarios` DISABLE KEYS */;
INSERT INTO `horarios` VALUES (1,'2023-10-24 13:30:00','2023-10-24 14:30:00',1),(2,'2023-10-24 14:30:00','2023-10-24 15:30:00',1),(3,'2023-10-24 13:30:00','2023-10-24 14:30:00',2),(4,'2023-10-24 14:30:00','2023-10-24 15:30:00',2);
/*!40000 ALTER TABLE `horarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salao`
--

DROP TABLE IF EXISTS `salao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salao` (
  `salao_id` int(11) NOT NULL AUTO_INCREMENT,
  `salao_nome` varchar(75) NOT NULL,
  `salao_cnpj` varchar(14) NOT NULL,
  `salao_telefone` varchar(11) NOT NULL,
  `salao_email` varchar(100) NOT NULL,
  `endereco_endereco_id` int(11) NOT NULL,
  PRIMARY KEY (`salao_id`),
  KEY `fk_salao_endereco1_idx` (`endereco_endereco_id`),
  CONSTRAINT `fk_salao_endereco1` FOREIGN KEY (`endereco_endereco_id`) REFERENCES `endereco` (`endereco_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salao`
--

LOCK TABLES `salao` WRITE;
/*!40000 ALTER TABLE `salao` DISABLE KEYS */;
INSERT INTO `salao` VALUES (1,'salao1','123','123','salaoemail1',10),(2,'salao2','456','456','salaoemail2',12);
/*!40000 ALTER TABLE `salao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salao_servico_ofer`
--

DROP TABLE IF EXISTS `salao_servico_ofer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salao_servico_ofer` (
  `servico_servico_id` int(11) NOT NULL,
  `salao_salao_id` int(11) NOT NULL,
  `valorservico` decimal(9,2) NOT NULL,
  PRIMARY KEY (`servico_servico_id`,`salao_salao_id`),
  KEY `fk_servico_has_salao_salao1_idx` (`salao_salao_id`),
  KEY `fk_servico_has_salao_servico1_idx` (`servico_servico_id`),
  CONSTRAINT `fk_servico_has_salao_servico1` FOREIGN KEY (`servico_servico_id`) REFERENCES `servico` (`servico_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_servico_has_salao_salao1` FOREIGN KEY (`salao_salao_id`) REFERENCES `salao` (`salao_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salao_servico_ofer`
--

LOCK TABLES `salao_servico_ofer` WRITE;
/*!40000 ALTER TABLE `salao_servico_ofer` DISABLE KEYS */;
INSERT INTO `salao_servico_ofer` VALUES (1,1,30.00),(2,1,40.00),(3,1,50.00),(4,2,100.00),(5,2,120.00),(6,2,140.00);
/*!40000 ALTER TABLE `salao_servico_ofer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servico`
--

DROP TABLE IF EXISTS `servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servico` (
  `servico_id` int(11) NOT NULL AUTO_INCREMENT,
  `servico_nome` varchar(100) NOT NULL,
  `tipo_servico` varchar(75) NOT NULL,
  `servico_tempo` time NOT NULL,
  PRIMARY KEY (`servico_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico`
--

LOCK TABLES `servico` WRITE;
/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
INSERT INTO `servico` VALUES (1,'corte curto','corte','00:30:00'),(2,'corte medio','corte','00:45:00'),(3,'corte longo','corte','01:00:00'),(4,'penteado curto','penteado','01:00:00'),(5,'penteado medio','penteado','01:15:00'),(6,'penteado longo','penteado','01:30:00');
/*!40000 ALTER TABLE `servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status_serv`
--

DROP TABLE IF EXISTS `status_serv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status_serv` (
  `status_ser_id` int(11) NOT NULL AUTO_INCREMENT,
  `decricao_status` varchar(45) NOT NULL,
  PRIMARY KEY (`status_ser_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status_serv`
--

LOCK TABLES `status_serv` WRITE;
/*!40000 ALTER TABLE `status_serv` DISABLE KEYS */;
INSERT INTO `status_serv` VALUES (1,'agendado'),(2,'cancelado'),(3,'para confirmar');
/*!40000 ALTER TABLE `status_serv` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-24 15:59:36
