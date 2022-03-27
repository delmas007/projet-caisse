-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 26 mars 2022 à 07:37
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `caisse`
--

-- --------------------------------------------------------

--
-- Structure de la table `bon_reduction`
--

DROP TABLE IF EXISTS `bon_reduction`;
CREATE TABLE IF NOT EXISTS `bon_reduction` (
  `NumBon` int(11) NOT NULL,
  `PrixBon` int(20) NOT NULL,
  `dateExpiration` date NOT NULL,
  PRIMARY KEY (`NumBon`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `bon_reduction`
--

INSERT INTO `bon_reduction` (`NumBon`, `PrixBon`, `dateExpiration`) VALUES
(3249, 10000, '2022-03-30'),
(3435, 5000, '2022-03-29'),
(4356, 15000, '2022-03-31');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `IdProduit` int(5) NOT NULL,
  `NomProduit` varchar(30) NOT NULL,
  `PrixProduit` int(255) NOT NULL,
  PRIMARY KEY (`IdProduit`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`IdProduit`, `NomProduit`, `PrixProduit`) VALUES
(1, 'sac de riz', 20000),
(2, '1 litre huile', 2000),
(3, 'yoplait', 1500),
(4, 'plaquette oeuf', 2500),
(5, 'baguette pain', 150),
(6, 'viande', 6000),
(7, 'jus citron', 1000),
(8, 'coca cola', 3000),
(9, 'Cemoi', 650),
(10, 'javel', 500),
(11, 'savon', 1200);

-- --------------------------------------------------------

--
-- Structure de la table `recu`
--

DROP TABLE IF EXISTS `recu`;
CREATE TABLE IF NOT EXISTS `recu` (
  `NumRecu` int(11) NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `SomTotal` int(11) NOT NULL,
  `produit` varchar(200) NOT NULL,
  `montant` int(50) NOT NULL,
  `monnaie` int(50) NOT NULL,
  PRIMARY KEY (`NumRecu`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `recu`
--

INSERT INTO `recu` (`NumRecu`, `Date`, `SomTotal`, `produit`, `montant`, `monnaie`) VALUES
(31, '2022-03-07', 42000, '\nviande                 6000 				x6			 =36000\nyoplait                 1500 				x4			 =6000', 50000, 18000),
(32, '2022-03-09', 23000, '\njavel                 500 				x4			 =2000\ncoca cola                 3000 				x6			 =18000\njus citron                 1000 				x3			 =3000', 40000, 22000),
(33, '2022-03-16', 23750, '\nbaguette pain                 150 				x5			 =750\njavel                 500 				x4			 =2000\ncoca cola                 3000 				x6			 =18000\njus citron                 1000 				x3			 =3000', 60000, 51250),
(34, '2022-03-23', 182000, '\ncoca cola                 3000 				x6			 =18000\ncoca cola                 3000 				x8			 =24000\nplaquette oeuf                 2500 				x56			 =140000', 200000, 18000);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
