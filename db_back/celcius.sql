-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 27, 2013 at 06:18 PM
-- Server version: 5.5.8-log
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `celcius`
--

-- --------------------------------------------------------

--
-- Table structure for table `bedsheets`
--

CREATE TABLE IF NOT EXISTS `bedsheets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `size` varchar(255) NOT NULL,
  `smv` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `smv` (`smv`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `bedsheets`
--

INSERT INTO `bedsheets` (`id`, `size`, `smv`) VALUES
(1, '110X110', 78),
(2, '100X100', 69),
(3, '92X100', 62.5),
(4, '80X95', 56.5),
(5, '68X95', 48),
(6, '54X95', 45);

-- --------------------------------------------------------

--
-- Table structure for table `bedsheet_accessories`
--

CREATE TABLE IF NOT EXISTS `bedsheet_accessories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `bedsheet_accessories`
--

INSERT INTO `bedsheet_accessories` (`id`, `name`, `description`, `price`) VALUES
(1, 'Seal Bag', 'per unit', 11),
(2, 'Lable', 'per unit', 14),
(3, 'Thread', 'per unit', 5),
(4, 'Tag', 'per unit', 1.5),
(5, 'Cardboard', 'per unit', 17);

-- --------------------------------------------------------

--
-- Table structure for table `bolsters`
--

CREATE TABLE IF NOT EXISTS `bolsters` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `range` varchar(255) NOT NULL,
  `size` varchar(255) NOT NULL,
  `smv` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `bolsters`
--

INSERT INTO `bolsters` (`id`, `range`, `size`, `smv`) VALUES
(1, 'Classic', '3.5X16', 15),
(2, 'Classic', '4X18', 25),
(3, 'Classic', '8X24', 37),
(4, 'Classic', '8X40', 55),
(5, 'Classic', '8X18', 38);

-- --------------------------------------------------------

--
-- Table structure for table `bolster_accessories`
--

CREATE TABLE IF NOT EXISTS `bolster_accessories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `bolster_accessories`
--

INSERT INTO `bolster_accessories` (`id`, `name`, `description`, `price`) VALUES
(1, 'PE Bag', '', 10),
(2, 'Lable', '', 10),
(3, 'Tag', '', 10),
(4, 'Thread', '', 10);

-- --------------------------------------------------------

--
-- Table structure for table `bolster_fiber_weights`
--

CREATE TABLE IF NOT EXISTS `bolster_fiber_weights` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `3p5_16` double NOT NULL,
  `4_18` double NOT NULL,
  `8_18` double NOT NULL,
  `8_24` double NOT NULL,
  `8_40` double NOT NULL,
  `10_30` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `bolster_fiber_weights`
--

INSERT INTO `bolster_fiber_weights` (`id`, `name`, `3p5_16`, `4_18`, `8_18`, `8_24`, `8_40`, `10_30`) VALUES
(1, 'Gel Fiber', 0, 0, 0, 0, 0, 0),
(2, 'Feather Fiber', 0, 0, 0, 0, 0, 0),
(3, 'Goose Feather Fiber', 0, 0, 0, 0, 0, 0),
(4, 'New Fiber', 0.09, 0.18, 0.35, 0.4, 0.7, 1.58);

-- --------------------------------------------------------

--
-- Table structure for table `cotsheets`
--

CREATE TABLE IF NOT EXISTS `cotsheets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `size` varchar(255) NOT NULL,
  `smv` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `cotsheets`
--

INSERT INTO `cotsheets` (`id`, `size`, `smv`) VALUES
(1, '18X27', 30),
(2, '18X35', 38.5),
(3, '28X37', 42);

-- --------------------------------------------------------

--
-- Table structure for table `cotsheet_accessories`
--

CREATE TABLE IF NOT EXISTS `cotsheet_accessories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL DEFAULT 'no description',
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `cotsheet_accessories`
--

INSERT INTO `cotsheet_accessories` (`id`, `name`, `description`, `price`) VALUES
(1, 'Lable', 'per unit', 15),
(2, 'Tag', 'per unit', 4.5),
(3, 'Thread', 'per unit', 10),
(4, 'Elastic', 'per yard', 30),
(5, 'PE Bag', 'per unit', 15);

-- --------------------------------------------------------

--
-- Table structure for table `cushions`
--

CREATE TABLE IF NOT EXISTS `cushions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `range` varchar(255) NOT NULL,
  `size` varchar(255) NOT NULL,
  `smv` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `cushions`
--

INSERT INTO `cushions` (`id`, `range`, `size`, `smv`) VALUES
(1, 'Classic', '16X16', 12),
(2, 'Calssic', '17X17', 16.5),
(3, 'Classic', '18X18', 20),
(4, 'Classic', '20X20', 25);

-- --------------------------------------------------------

--
-- Table structure for table `cushion_accessories`
--

CREATE TABLE IF NOT EXISTS `cushion_accessories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `cushion_accessories`
--

INSERT INTO `cushion_accessories` (`id`, `name`, `description`, `price`) VALUES
(1, 'PE Bag', '', 10),
(2, 'Thread', '', 4),
(3, 'Tag', '', 5),
(4, 'Lable', '', 3);

-- --------------------------------------------------------

--
-- Table structure for table `cushion_fiber_weights`
--

CREATE TABLE IF NOT EXISTS `cushion_fiber_weights` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `16_16` double NOT NULL,
  `17_17` double NOT NULL,
  `18_18` double NOT NULL,
  `20_20` double NOT NULL,
  `24_24` double NOT NULL,
  `30_30` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `cushion_fiber_weights`
--

INSERT INTO `cushion_fiber_weights` (`id`, `name`, `16_16`, `17_17`, `18_18`, `20_20`, `24_24`, `30_30`) VALUES
(1, 'Gel Fiber', 0, 0, 0, 0, 0, 0),
(2, 'Feather Fiber', 0, 0, 0, 0, 0, 0),
(3, 'Goose Feather Fiber', 0, 0, 0, 0, 0, 0),
(4, 'New Fiber', 1, 1.2, 1.7, 2.2, 2.5, 3.8);

-- --------------------------------------------------------

--
-- Table structure for table `duvetcovers`
--

CREATE TABLE IF NOT EXISTS `duvetcovers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `size` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `smv` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `duvetcovers`
--

INSERT INTO `duvetcovers` (`id`, `size`, `type`, `smv`) VALUES
(1, '48X75', 'button', 57.75),
(2, '48X75', 'envelope', 57.75),
(3, '48X75', 'zipper', 57.75),
(4, '90X110', 'envelope', 121),
(5, '90X110', 'zipper', 121),
(6, '90X110', 'button', 121),
(7, '80X80', 'zipper', 95.75),
(8, '80X80', 'button', 95.75),
(9, '80X80', 'envelope', 95.75);

-- --------------------------------------------------------

--
-- Table structure for table `duvetcover_accessories`
--

CREATE TABLE IF NOT EXISTS `duvetcover_accessories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL DEFAULT 'per unit',
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `duvetcover_accessories`
--

INSERT INTO `duvetcover_accessories` (`id`, `name`, `description`, `price`) VALUES
(1, 'Seal Bag', 'per unit', 5),
(2, 'Lable', 'per unit', 10),
(3, 'Tag', 'per unit', 10),
(4, 'Cardboard', 'per unit', 5),
(5, 'Velco', 'per yard', 10),
(6, 'Thread', 'per unit', 20),
(7, 'Zipper', 'per yard', 60),
(8, 'Button', 'per unit', 2);

-- --------------------------------------------------------

--
-- Table structure for table `duvets`
--

CREATE TABLE IF NOT EXISTS `duvets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `size` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `smv` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `duvets`
--

INSERT INTO `duvets` (`id`, `size`, `type`, `smv`) VALUES
(1, '18X27', 'Baby', 24.5),
(2, '25X35', 'Baby', 28),
(3, '27X47', 'Baby', 31.75),
(4, '48X75', 'Normal', 42),
(5, '80X80', 'Normal', 54),
(6, '90X110', 'Normal', 67),
(7, '48X75', 'Gel/Feather', 84.8),
(8, '80X80', 'Gel/Feather', 126.5),
(9, '90X110', 'Gel/Feather', 190.25);

-- --------------------------------------------------------

--
-- Table structure for table `duvet_accessories`
--

CREATE TABLE IF NOT EXISTS `duvet_accessories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL DEFAULT 'per unit',
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `duvet_accessories`
--

INSERT INTO `duvet_accessories` (`id`, `name`, `description`, `price`) VALUES
(1, 'Lable', 'per unit', 15),
(2, 'Tag', 'per unit', 8),
(3, 'PE Bag', 'per unit', 9),
(4, 'Thread', 'per unit', 10),
(5, 'Non Woven', 'per yard', 300),
(6, 'Zipper', 'per yard', 30),
(7, 'Transparent Sheet', 'per yard', 400),
(8, 'Piping', 'per yard', 15),
(9, 'Zipper Head', 'per unit', 2);

-- --------------------------------------------------------

--
-- Table structure for table `fabrics`
--

CREATE TABLE IF NOT EXISTS `fabrics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `width` int(11) NOT NULL,
  `width_shrinkage` int(11) NOT NULL,
  `height_shrinkage` int(11) NOT NULL,
  `Classic` tinyint(1) NOT NULL,
  `Super` tinyint(1) NOT NULL,
  `Premium` tinyint(1) NOT NULL,
  `Other` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `fabrics`
--

INSERT INTO `fabrics` (`id`, `name`, `price`, `width`, `width_shrinkage`, `height_shrinkage`, `Classic`, `Super`, `Premium`, `Other`) VALUES
(1, '250TC 1cm satin stripe', 522.47, 120, 3, 5, 1, 0, 0, 0),
(2, '250TC 4 mm satin stripe', 547.5, 120, 3, 5, 1, 0, 0, 0),
(3, '350TC plain satin', 622, 120, 4, 6, 0, 0, 1, 0),
(4, '300TC plain satin', 548, 120, 3, 5, 0, 0, 1, 0),
(5, '400TC tencil', 733, 112, 4, 6, 0, 0, 1, 0),
(6, '150TC 100% cotton', 331, 120, 2, 3, 0, 1, 0, 0),
(7, '180TC poly cotton', 400, 120, 2, 3, 0, 1, 0, 0),
(8, 'down proof', 500, 120, 0, 0, 0, 0, 0, 1),
(10, 'down proof 2', 785, 120, 3, 3, 0, 0, 0, 1),
(11, 'Non Woven', 345.7, 120, 1, 1, 0, 1, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `fibers`
--

CREATE TABLE IF NOT EXISTS `fibers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `classic` tinyint(1) NOT NULL,
  `super` tinyint(1) NOT NULL,
  `gelfeather` tinyint(1) NOT NULL,
  `kapokorganic` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `fibers`
--

INSERT INTO `fibers` (`id`, `name`, `price`, `classic`, `super`, `gelfeather`, `kapokorganic`) VALUES
(1, 'Gel Fiber', 700, 0, 0, 1, 0),
(2, 'Feather Fiber', 1200, 0, 0, 1, 0),
(3, 'Goose Feather Fiber', 1100, 1, 0, 1, 0),
(4, 'New Fiber', 188, 0, 1, 1, 1);

--
-- Triggers `fibers`
--
DROP TRIGGER IF EXISTS `after_delete_fiber`;
DELIMITER //
CREATE TRIGGER `after_delete_fiber` AFTER DELETE ON `fibers`
 FOR EACH ROW begin
	delete from pillows_fiber_weights where pillows_fiber_weights.name = old.name; 
	delete from cushion_fiber_weights where cushion_fiber_weights.name = old.name;
        delete from bolster_fiber_weights where bolster_fiber_weights.name = old.name;
end
//
DELIMITER ;
DROP TRIGGER IF EXISTS `after_new_fiber`;
DELIMITER //
CREATE TRIGGER `after_new_fiber` AFTER INSERT ON `fibers`
 FOR EACH ROW begin
	insert into pillows_fiber_weights(name) values(new.name);
	insert into cushion_fiber_weights(name) values(new.name);
	insert into bolster_fiber_weights(name) values(new.name);
end
//
DELIMITER ;
DROP TRIGGER IF EXISTS `after_update_fiber`;
DELIMITER //
CREATE TRIGGER `after_update_fiber` AFTER UPDATE ON `fibers`
 FOR EACH ROW begin
	if( new.name != old.name)then
		update pillows_fiber_weights set pillows_fiber_weights.name = new.name where pillows_fiber_weights.name = old.name;
		update cushion_fiber_weights set cushion_fiber_weights.name = new.name where cushion_fiber_weights.name = old.name;
		update bolster_fiber_weights set bolster_fiber_weights.name = new.name where bolster_fiber_weights.name = old.name;
end if;
end
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `mattresprotectors`
--

CREATE TABLE IF NOT EXISTS `mattresprotectors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `size` varchar(255) NOT NULL,
  `smv` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `mattresprotectors`
--

INSERT INTO `mattresprotectors` (`id`, `size`, `smv`) VALUES
(1, '36X78', 62),
(2, '48X78', 71),
(4, '60X78', 81),
(5, '72X78', 90);

-- --------------------------------------------------------

--
-- Table structure for table `mattresprotector_accessories`
--

CREATE TABLE IF NOT EXISTS `mattresprotector_accessories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL DEFAULT 'per unit',
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `mattresprotector_accessories`
--

INSERT INTO `mattresprotector_accessories` (`id`, `name`, `description`, `price`) VALUES
(1, 'Lable', 'per unit', 10),
(2, 'Tag', 'per unit', 10),
(3, 'Thread', 'per unit', 10),
(4, 'PE Bag', 'per unit', 30),
(5, 'Elastic', 'per yard', 20),
(6, 'Non Woven', 'per yard', 300),
(7, 'Piping', 'per yard', 10),
(8, 'Zipper', 'per yard', 40),
(9, 'Transparent Sheet', 'per yard', 300),
(10, 'Zipper Head', 'per unit', 10);

-- --------------------------------------------------------

--
-- Table structure for table `paddings`
--

CREATE TABLE IF NOT EXISTS `paddings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `width` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `paddings`
--

INSERT INTO `paddings` (`id`, `name`, `price`, `width`) VALUES
(1, '80 gsm', 350, 58),
(2, '60 gsm', 450, 45);

-- --------------------------------------------------------

--
-- Table structure for table `parameters`
--

CREATE TABLE IF NOT EXISTS `parameters` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `value` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `parameters`
--

INSERT INTO `parameters` (`id`, `name`, `value`) VALUES
(1, 'cost per labour minute', 2.3),
(2, 'POH per minute', 2);

-- --------------------------------------------------------

--
-- Table structure for table `pillowcases`
--

CREATE TABLE IF NOT EXISTS `pillowcases` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL,
  `size` varchar(50) NOT NULL,
  `smv` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `pillowcases`
--

INSERT INTO `pillowcases` (`id`, `type`, `size`, `smv`) VALUES
(1, 'normal', '18X27', 24),
(2, 'normal', '20X30', 26),
(5, 'frill', '18X27', 30),
(6, 'frill', '20X30', 35);

-- --------------------------------------------------------

--
-- Table structure for table `pillowcase_accessories`
--

CREATE TABLE IF NOT EXISTS `pillowcase_accessories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(255) NOT NULL DEFAULT 'per unit',
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `pillowcase_accessories`
--

INSERT INTO `pillowcase_accessories` (`id`, `name`, `description`, `price`) VALUES
(1, 'Seal Bag', 'per unit', 10),
(2, 'Lable', 'per unit', 1.5),
(3, 'Thread', 'per unit', 6),
(4, 'Cardboard', 'per unit', 15),
(5, 'Tag', 'per unit', 9);

-- --------------------------------------------------------

--
-- Table structure for table `pillows`
--

CREATE TABLE IF NOT EXISTS `pillows` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `range` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `size` varchar(255) NOT NULL,
  `smv` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `pillows`
--

INSERT INTO `pillows` (`id`, `range`, `type`, `size`, `smv`) VALUES
(1, 'Classic', 'Normal', '12X18', 45),
(2, 'Classic', 'Vacume', '12X18', 48),
(3, 'Classic', 'Normal', '18X20', 50),
(4, 'Classic', 'Vacume', '18X20', 55);

-- --------------------------------------------------------

--
-- Table structure for table `pillows_fiber_weights`
--

CREATE TABLE IF NOT EXISTS `pillows_fiber_weights` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `8_12` double NOT NULL,
  `10_14` double NOT NULL,
  `11_15` double NOT NULL,
  `12_18` double NOT NULL,
  `16_24` double NOT NULL,
  `18_27` double NOT NULL,
  `20_30` double NOT NULL,
  `20_40` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `pillows_fiber_weights`
--

INSERT INTO `pillows_fiber_weights` (`id`, `name`, `8_12`, `10_14`, `11_15`, `12_18`, `16_24`, `18_27`, `20_30`, `20_40`) VALUES
(1, 'Gel Fiber', 100, 200, 300, 400, 500, 600, 700, 800),
(2, 'Feather Fiber', 1, 2.5, 3.5, 4.5, 5.5, 6.5, 7.5, 9.5),
(3, 'Goose Feather Fiber', 120, 150, 45, 780, 890, 900, 990, 1000);

-- --------------------------------------------------------

--
-- Table structure for table `pillow_accessories`
--

CREATE TABLE IF NOT EXISTS `pillow_accessories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `pillow_accessories`
--

INSERT INTO `pillow_accessories` (`id`, `name`, `description`, `price`) VALUES
(1, 'Lable', 'per unit', 0),
(2, 'Tag', 'per unit', 0),
(4, 'PE Bag', 'per unit', 0),
(5, 'Piping', 'per yard', 0),
(6, 'Thread', 'per unit', 0);

-- --------------------------------------------------------

--
-- Table structure for table `ranges`
--

CREATE TABLE IF NOT EXISTS `ranges` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `ranges`
--

INSERT INTO `ranges` (`id`, `name`) VALUES
(1, 'Classic'),
(2, 'Premium'),
(3, 'Super');

-- --------------------------------------------------------

--
-- Table structure for table `taffatas`
--

CREATE TABLE IF NOT EXISTS `taffatas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `width` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `taffatas`
--

INSERT INTO `taffatas` (`id`, `name`, `price`, `width`) VALUES
(1, 'taffata 1', 400, 58),
(2, 'taffata 2', 420, 60);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`) VALUES
(1, 'admin', '');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
