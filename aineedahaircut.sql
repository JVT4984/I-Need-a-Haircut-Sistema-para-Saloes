-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: aineedahaircut
-- ------------------------------------------------------
-- Server version	11.1.2-MariaDB

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
  `status_serv_status_serv_id` int(11) NOT NULL,
  `avaliacao_avaliacao_id` int(11) NOT NULL,
  `agenda_agendaDiaDisponivel_date1` date NOT NULL,
  `agenda_cadhoraatende_cadhoraatende_id1` int(10) unsigned NOT NULL,
  PRIMARY KEY (`agendamento_id`),
  KEY `fk_agdpedidodoservico_cliente1_idx` (`cliente_cliente_id`),
  KEY `fk_agdpedidodoservico_servico1_idx` (`servico_servico_id`),
  KEY `fk_agdpedidodoservico_status_serv1_idx` (`status_serv_status_serv_id`),
  KEY `fk_agdpedidodoservico_avaliacao1_idx` (`avaliacao_avaliacao_id`),
  KEY `fk_agdpedidodoservico_agenda1_idx` (`agenda_agendaDiaDisponivel_date1`,`agenda_cadhoraatende_cadhoraatende_id1`),
  CONSTRAINT `fk_agdpedidodoservico_agenda1` FOREIGN KEY (`agenda_agendaDiaDisponivel_date1`, `agenda_cadhoraatende_cadhoraatende_id1`) REFERENCES `agenda` (`agendaDiaDisponivel_date`, `cadhoraatende_cadhoraatende_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_agdpedidodoservico_avaliacao1` FOREIGN KEY (`avaliacao_avaliacao_id`) REFERENCES `avaliacao` (`avaliacao_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_agdpedidodoservico_cliente1` FOREIGN KEY (`cliente_cliente_id`) REFERENCES `cliente` (`cliente_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_agdpedidodoservico_servico1` FOREIGN KEY (`servico_servico_id`) REFERENCES `servico` (`servico_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_agdpedidodoservico_status_serv1` FOREIGN KEY (`status_serv_status_serv_id`) REFERENCES `status_serv` (`status_serv_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
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
  `agendaDiaDisponivel_date` date NOT NULL,
  `cadhoraatende_cadhoraatende_id` int(10) unsigned NOT NULL,
  `TotalAtendenteDisponivel` int(11) NOT NULL,
  `hrFaixaAgendadaInicio` time NOT NULL,
  `hrFaixaAgendadaFim` time NOT NULL,
  PRIMARY KEY (`agendaDiaDisponivel_date`,`cadhoraatende_cadhoraatende_id`),
  KEY `fk_agenda_agendaDiaDisponivel1_idx` (`agendaDiaDisponivel_date`),
  KEY `fk_agenda_cadhoraatende1` (`cadhoraatende_cadhoraatende_id`),
  CONSTRAINT `fk_agenda_agendaDiaDisponivel1` FOREIGN KEY (`agendaDiaDisponivel_date`) REFERENCES `agendadiadisponivel` (`date`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_agenda_cadhoraatende1` FOREIGN KEY (`cadhoraatende_cadhoraatende_id`) REFERENCES `cadhoraatende` (`cadhoraatende_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenda`
--

LOCK TABLES `agenda` WRITE;
/*!40000 ALTER TABLE `agenda` DISABLE KEYS */;
INSERT INTO `agenda` VALUES ('2023-10-25',1,3,'08:30:00','09:30:00'),('2023-10-25',2,3,'09:30:00','10:30:00'),('2023-10-25',3,3,'10:30:00','11:30:00'),('2023-10-25',4,3,'11:30:00','12:00:00'),('2023-10-25',5,3,'13:30:00','14:30:00'),('2023-10-25',6,3,'14:30:00','15:30:00'),('2023-10-25',7,3,'15:30:00','16:30:00'),('2023-10-25',8,3,'16:30:00','17:30:00');
/*!40000 ALTER TABLE `agenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agendadiadisponivel`
--

DROP TABLE IF EXISTS `agendadiadisponivel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agendadiadisponivel` (
  `date` date NOT NULL,
  `HoraDiaInicio` time NOT NULL,
  `HoraDiaFim` time NOT NULL,
  PRIMARY KEY (`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agendadiadisponivel`
--

LOCK TABLES `agendadiadisponivel` WRITE;
/*!40000 ALTER TABLE `agendadiadisponivel` DISABLE KEYS */;
INSERT INTO `agendadiadisponivel` VALUES ('2023-10-25','08:30:00','18:30:00'),('2023-10-26','13:30:00','18:30:00');
/*!40000 ALTER TABLE `agendadiadisponivel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agendadiadisponivel_has_cadhoraatende`
--

DROP TABLE IF EXISTS `agendadiadisponivel_has_cadhoraatende`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agendadiadisponivel_has_cadhoraatende` (
  `agendaDiaDisponivel_date` date NOT NULL,
  `cadhoraatende_cadhoraatende_id` int(10) unsigned NOT NULL,
  `TotalAtendenteDisponivel` int(11) NOT NULL,
  `hrFaixaAgendadaInicio` time NOT NULL,
  `hrFaixaAgendadaFim` time NOT NULL,
  PRIMARY KEY (`agendaDiaDisponivel_date`,`cadhoraatende_cadhoraatende_id`),
  KEY `fk_agendaDiaDisponivel_has_cadhoraatende_cadhoraatende1_idx` (`cadhoraatende_cadhoraatende_id`),
  KEY `fk_agendaDiaDisponivel_has_cadhoraatende_agendaDiaDisponive_idx` (`agendaDiaDisponivel_date`),
  CONSTRAINT `fk_agendaDiaDisponivel_has_cadhoraatende_agendaDiaDisponivel1` FOREIGN KEY (`agendaDiaDisponivel_date`) REFERENCES `agendadiadisponivel` (`date`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_agendaDiaDisponivel_has_cadhoraatende_cadhoraatende1` FOREIGN KEY (`cadhoraatende_cadhoraatende_id`) REFERENCES `cadhoraatende` (`cadhoraatende_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agendadiadisponivel_has_cadhoraatende`
--

LOCK TABLES `agendadiadisponivel_has_cadhoraatende` WRITE;
/*!40000 ALTER TABLE `agendadiadisponivel_has_cadhoraatende` DISABLE KEYS */;
/*!40000 ALTER TABLE `agendadiadisponivel_has_cadhoraatende` ENABLE KEYS */;
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
  `descricao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`avaliacao_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliacao`
--

LOCK TABLES `avaliacao` WRITE;
/*!40000 ALTER TABLE `avaliacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `avaliacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cadhoraatende`
--

DROP TABLE IF EXISTS `cadhoraatende`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cadhoraatende` (
  `cadhoraatende_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `atendentes_disponiveis` int(10) unsigned NOT NULL,
  `hrFaixaInicio` time NOT NULL,
  `hrFaixaFinal` time NOT NULL,
  `salao_salao_id` int(11) NOT NULL,
  PRIMARY KEY (`cadhoraatende_id`),
  KEY `fk_horarios_salao1_idx` (`salao_salao_id`),
  CONSTRAINT `fk_horarios_salao1` FOREIGN KEY (`salao_salao_id`) REFERENCES `salao` (`salao_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cadhoraatende`
--

LOCK TABLES `cadhoraatende` WRITE;
/*!40000 ALTER TABLE `cadhoraatende` DISABLE KEYS */;
INSERT INTO `cadhoraatende` VALUES (1,3,'08:30:00','09:30:00',1),(2,3,'09:30:00','10:30:00',1),(3,3,'10:30:00','11:30:00',1),(4,3,'11:30:00','12:00:00',1),(5,3,'13:30:00','14:30:00',1),(6,3,'14:30:00','15:30:00',1),(7,3,'15:30:00','16:30:00',1),(8,3,'16:30:00','17:30:00',1);
/*!40000 ALTER TABLE `cadhoraatende` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidade`
--

LOCK TABLES `cidade` WRITE;
/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
INSERT INTO `cidade` VALUES (1,'Timbó',1),(2,'Blumenau',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'nome1','sobrenome1','123','123','email1',1),(2,'nome2','sobrenome2','456','456','email2',2);
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
  `endereco_numero` int(5) NOT NULL,
  `endereco_complemento` varchar(45) NOT NULL,
  `cidade_cidade_id` int(11) NOT NULL,
  PRIMARY KEY (`endereco_id`),
  KEY `fk_endereco_cidade1_idx` (`cidade_cidade_id`),
  CONSTRAINT `fk_endereco_cidade1` FOREIGN KEY (`cidade_cidade_id`) REFERENCES `cidade` (`cidade_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,'bairro1','rua1',123,'casa',1),(2,'bairro2','rua2',456,'casa',2);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (1,'Santa Catarina','SC'),(2,'Parana','PR');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
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
  `endereco_endereco_id` int(11) NOT NULL,
  PRIMARY KEY (`salao_id`),
  KEY `fk_salao_endereco1_idx` (`endereco_endereco_id`),
  CONSTRAINT `fk_salao_endereco1` FOREIGN KEY (`endereco_endereco_id`) REFERENCES `endereco` (`endereco_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salao`
--

LOCK TABLES `salao` WRITE;
/*!40000 ALTER TABLE `salao` DISABLE KEYS */;
INSERT INTO `salao` VALUES (1,'salao1','123','123','salaoemail1',1);
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
  PRIMARY KEY (`servico_id`,`salao_salao_id`),
  KEY `fk_servico_salao1_idx` (`salao_salao_id`),
  CONSTRAINT `fk_servico_salao1` FOREIGN KEY (`salao_salao_id`) REFERENCES `salao` (`salao_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico`
--

LOCK TABLES `servico` WRITE;
/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
INSERT INTO `servico` VALUES (1,'corte curto','corte','00:15:00',30.00,1),(2,'mãos','manicure','00:20:00',15.00,1),(3,'pés','pédicure','00:20:00',15.00,1);
/*!40000 ALTER TABLE `servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status_serv`
--

DROP TABLE IF EXISTS `status_serv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status_serv` (
  `status_serv_id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao_status` varchar(45) NOT NULL,
  PRIMARY KEY (`status_serv_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status_serv`
--

LOCK TABLES `status_serv` WRITE;
/*!40000 ALTER TABLE `status_serv` DISABLE KEYS */;
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

-- Dump completed on 2023-10-26 21:44:19
