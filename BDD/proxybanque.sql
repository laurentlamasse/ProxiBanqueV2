-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Lun 26 Juin 2017 à 23:29
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `proxybanque`
--
CREATE DATABASE IF NOT EXISTS `proxybanque` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `proxybanque`;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `ville` varchar(15) NOT NULL,
  `adresse` varchar(20) NOT NULL,
  `codePostal` int(10) NOT NULL,
  `telephone` varchar(15) NOT NULL,
  `numeroClient` int(10) NOT NULL,
  `numeroConseiller` int(10) NOT NULL,
  `typeClient` varchar(20) NOT NULL DEFAULT 'Particulier'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`nom`, `prenom`, `email`, `ville`, `adresse`, `codePostal`, `telephone`, `numeroClient`, `numeroConseiller`, `typeClient`) VALUES
('Alexandre', 'Pic', 'apic@objis.net', 'Lyon', 'ValFon', 69290, '061870349', 958, 47, 'Particulier'),
('Alexandre', 'Pic', 'apic@objis.net', 'Lyon', 'ValFon', 69290, '061870349', 87587, 8757, 'Particulier'),
('Alexandre', 'Valentin', 'apic@objis.net', 'Lyon', 'Maracas', 69290, '061870349', 999, 999, 'Particulier');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `NumeroCompte` int(15) NOT NULL,
  `Solde` int(15) NOT NULL,
  `NumeroClient` int(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `comptecourant`
--

CREATE TABLE `comptecourant` (
  `numeroCompte` int(10) NOT NULL,
  `plafond` int(10) NOT NULL,
  `idclient` int(10) NOT NULL,
  `solde` int(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `compteepargne`
--

CREATE TABLE `compteepargne` (
  `numeroCompte` int(10) NOT NULL,
  `solde` int(10) NOT NULL,
  `numeroClient` int(10) NOT NULL,
  `remuneration` int(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `conseiller`
--

CREATE TABLE `conseiller` (
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `id` int(10) NOT NULL,
  `login` varchar(20) NOT NULL,
  `mdp` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `conseiller`
--

INSERT INTO `conseiller` (`nom`, `prenom`, `id`, `login`, `mdp`) VALUES
('jean', 'dupont', 0, 'jedu', 'azerty'),
('Jean', 'Hubert', 47, 'plop', 'plip'),
('Jean', 'Hubert', 113, 'plop', 'plip');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`numeroClient`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`NumeroCompte`);

--
-- Index pour la table `comptecourant`
--
ALTER TABLE `comptecourant`
  ADD PRIMARY KEY (`numeroCompte`);

--
-- Index pour la table `compteepargne`
--
ALTER TABLE `compteepargne`
  ADD PRIMARY KEY (`numeroCompte`);

--
-- Index pour la table `conseiller`
--
ALTER TABLE `conseiller`
  ADD PRIMARY KEY (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
