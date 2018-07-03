create database IF NOT EXISTS superboulangerie;
use superboulangerie;

DROP TABLE IF EXISTS boulanger;
CREATE TABLE IF NOT EXISTS boulanger (
	id int(11) NOT NULL AUTO_INCREMENT,
	nom varchar(50) NOT NULL,
	prenom varchar(50) NOT NULL,
	specialite varchar(50) DEFAULT NULL,
	PRIMARY KEY (id)	
) ENGINE=InnoDB ;