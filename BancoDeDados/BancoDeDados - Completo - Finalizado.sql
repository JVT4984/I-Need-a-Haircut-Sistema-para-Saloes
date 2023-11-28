-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: banco_ineedahaircut_joao
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
-- Table structure for table `agdpedidodoservico`
--

DROP TABLE IF EXISTS `agdpedidodoservico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agdpedidodoservico` (
  `agendamento_id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente_cliente_id` int(11) NOT NULL,
  `servico_servico_id` int(11) NOT NULL,
  `avaliacao_avaliacao_id` int(11) NOT NULL,
  `agenda_agenda_id` int(11) NOT NULL,
  PRIMARY KEY (`agendamento_id`,`agenda_agenda_id`),
  KEY `fk_agdpedidodoservico_cliente1_idx` (`cliente_cliente_id`),
  KEY `fk_agdpedidodoservico_servico1_idx` (`servico_servico_id`),
  KEY `fk_agdpedidodoservico_avaliacao1_idx` (`avaliacao_avaliacao_id`),
  KEY `fk_agdpedidodoservico_agenda1_idx` (`agenda_agenda_id`),
  CONSTRAINT `fk_agdpedidodoservico_agenda1` FOREIGN KEY (`agenda_agenda_id`) REFERENCES `agenda` (`agenda_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_agdpedidodoservico_avaliacao1` FOREIGN KEY (`avaliacao_avaliacao_id`) REFERENCES `avaliacao` (`avaliacao_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_agdpedidodoservico_cliente1` FOREIGN KEY (`cliente_cliente_id`) REFERENCES `cliente` (`cliente_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_agdpedidodoservico_servico1` FOREIGN KEY (`servico_servico_id`) REFERENCES `servico` (`servico_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agdpedidodoservico`
--

LOCK TABLES `agdpedidodoservico` WRITE;
/*!40000 ALTER TABLE `agdpedidodoservico` DISABLE KEYS */;
/*!40000 ALTER TABLE `agdpedidodoservico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agenda`
--

DROP TABLE IF EXISTS `agenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agenda` (
  `agenda_id` int(11) NOT NULL AUTO_INCREMENT,
  `agenda_data` date NOT NULL,
  `hrInicio` time NOT NULL,
  `hrFinal` time NOT NULL,
  `atendente_disponivel` int(11) NOT NULL,
  `salao_salao_id` int(11) NOT NULL,
  PRIMARY KEY (`agenda_id`),
  KEY `fk_agenda_salao1_idx` (`salao_salao_id`),
  CONSTRAINT `fk_agenda_salao1` FOREIGN KEY (`salao_salao_id`) REFERENCES `salao` (`salao_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenda`
--

LOCK TABLES `agenda` WRITE;
/*!40000 ALTER TABLE `agenda` DISABLE KEYS */;
INSERT INTO `agenda` VALUES (1,'2023-06-03','14:30:00','15:30:00',2,3),(3,'2023-04-30','12:34:00','22:50:00',2,3);
/*!40000 ALTER TABLE `agenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avaliacao`
--

DROP TABLE IF EXISTS `avaliacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avaliacao` (
  `avaliacao_id` int(11) NOT NULL AUTO_INCREMENT,
  `avaliacao` int(2) DEFAULT NULL,
  PRIMARY KEY (`avaliacao_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliacao`
--

LOCK TABLES `avaliacao` WRITE;
/*!40000 ALTER TABLE `avaliacao` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidade`
--

LOCK TABLES `cidade` WRITE;
/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
INSERT INTO `cidade` VALUES (3,'Timbó',3);
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
  `cliente_senha` varchar(100) NOT NULL,
  PRIMARY KEY (`cliente_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (11,'João','Tessaroli','123','123','email.teste','123'),(12,'Ana','Perini','456','456','email.teste','456'),(13,'João','Tessaroli','123','123','joao@gmail.com','123'),(14,'Teste','Teste','123','123','Teste','Teste');
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
  `endereco_rua` varchar(45) NOT NULL,
  `endereco_numero` varchar(5) NOT NULL,
  `endereco_complemento` varchar(45) NOT NULL,
  `cidade_cidade_id` int(11) NOT NULL,
  PRIMARY KEY (`endereco_id`),
  KEY `fk_endereco_cidade1_idx` (`cidade_cidade_id`),
  CONSTRAINT `fk_endereco_cidade1` FOREIGN KEY (`cidade_cidade_id`) REFERENCES `cidade` (`cidade_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (3,'Nações','Oscar Piske','870','casa',3);
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
INSERT INTO `estado` VALUES (3,'Santa Catarina','SC');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `login_id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente_cliente_id` int(11) DEFAULT NULL,
  `salao_salao_id` int(11) DEFAULT NULL,
  `token` varchar(36) NOT NULL,
  PRIMARY KEY (`login_id`),
  KEY `fk_login_cliente1_idx` (`cliente_cliente_id`),
  KEY `fk_login_salao1_idx` (`salao_salao_id`),
  CONSTRAINT `fk_login_cliente1` FOREIGN KEY (`cliente_cliente_id`) REFERENCES `cliente` (`cliente_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_login_salao1` FOREIGN KEY (`salao_salao_id`) REFERENCES `salao` (`salao_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,11,NULL,'ola'),(2,11,NULL,'d8d39eac-9d90-42f0-8a95-f1981b12101b'),(3,NULL,3,'b78c6ca1-5399-439a-b87f-e46b5c3094f4'),(4,NULL,3,'9149de93-3050-4a27-b359-4d96d0f7f818'),(5,11,NULL,'2f149adf-3221-45d5-bbff-5707930a9169'),(6,11,NULL,'5399fc02-a4a6-448e-95dd-018ac450f01a'),(7,11,NULL,'2b7e6830-0dff-4a35-bdca-5b84915d539e'),(8,11,NULL,'71cdf57d-b4ca-4a48-9248-9cf6ebcf33f2'),(9,14,NULL,'4f889a5f-a2a1-4753-8f6d-d8e99bf5b65a');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salao`
--

DROP TABLE IF EXISTS `salao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salao` (
  `salao_id` int(11) NOT NULL AUTO_INCREMENT,
  `salao_nome` varchar(100) NOT NULL,
  `salao_cnpj` varchar(14) NOT NULL,
  `salao_telefone` varchar(11) NOT NULL,
  `salao_email` varchar(100) NOT NULL,
  `salao_senha` varchar(100) NOT NULL,
  `endereco_endereco_id` int(11) NOT NULL,
  PRIMARY KEY (`salao_id`),
  KEY `fk_salao_endereco1_idx` (`endereco_endereco_id`),
  CONSTRAINT `fk_salao_endereco1` FOREIGN KEY (`endereco_endereco_id`) REFERENCES `endereco` (`endereco_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salao`
--

LOCK TABLES `salao` WRITE;
/*!40000 ALTER TABLE `salao` DISABLE KEYS */;
INSERT INTO `salao` VALUES (3,'SilCabelos','123','123','email.teste','senha',3);
/*!40000 ALTER TABLE `salao` ENABLE KEYS */;
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
  `servico_valor` decimal(9,2) NOT NULL,
  `salao_salao_id` int(11) NOT NULL,
  PRIMARY KEY (`servico_id`),
  KEY `fk_servico_salao1_idx` (`salao_salao_id`),
  CONSTRAINT `fk_servico_salao1` FOREIGN KEY (`salao_salao_id`) REFERENCES `salao` (`salao_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico`
--

LOCK TABLES `servico` WRITE;
/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
INSERT INTO `servico` VALUES (1,'Corte','Corte','00:15:00',44.99,3);
/*!40000 ALTER TABLE `servico` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-28 16:39:17
