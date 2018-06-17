-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 17, 2018 at 04:01 PM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cinema`
--

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `id` int(11) NOT NULL,
  `name` text COLLATE utf8_turkish_ci NOT NULL,
  `surname` text COLLATE utf8_turkish_ci NOT NULL,
  `email` text COLLATE utf8_turkish_ci NOT NULL,
  `password` text COLLATE utf8_turkish_ci NOT NULL,
  `birthdate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`id`, `name`, `surname`, `email`, `password`, `birthdate`) VALUES
(1, 'admin', 'admin', 'admin', 'admin', '1997-01-01'),
(2, 'Bora', 'Tanrikulu', 'boratanrikulu@gmail.com', 'asd', '1997-04-11'),
(3, 'Asya', 'Turk', 'asyaturk@gmail.com', 'asd', '1998-05-23'),
(4, 'Lagertha', 'Ragnar', 'nord@gmail.com', 'asd', '1100-01-01'),
(5, 'Ahmet', 'Mehmet', 'ahmetmehmet@gmail.com', 'asd', '1999-01-01'),
(6, 'Ayşe', 'Fatma', 'aysefatma@gmail.com', 'asd', '1999-01-01'),
(7, 'Bahar', 'Kartal', 'bahar@gmail.com', 'asd', '1997-01-01'),
(8, 'Kuzey', 'Batı', 'kuzeybati@gmail.com', 'asd', '1990-01-01'),
(9, 'Einar', 'Selvik', 'einarselvik@gmail.com', 'asd', '1979-01-01'),
(10, 'Mehmet', 'Yücel', 'mehmetyucel@gmail.com', 'asd', '1995-01-01'),
(11, 'Osman', 'Dede', 'osmandede@gmail.com', 'asd', '1889-05-23'),
(12, 'Yılmaz', 'Aslan', 'yilmazaslan@gmail.com', 'asd', '1885-05-05'),
(13, 'Varol', 'Kaya', 'varolkaya@gmail.com', 'asd', '1975-04-23'),
(14, 'Ali', 'Veli', 'aliveli@gmail.com', 'asd', '1960-01-01'),
(15, 'Goerge', 'Orwell', 'orwell@gmail.com', 'asd', '1950-06-21'),
(16, 'Bilge', 'Çetin', 'bilgecetin@gmail.com', 'asd', '1988-07-29'),
(17, 'Onur', 'Cengiz', 'onurcengiz@gmail.com', 'asd', '1997-06-06'),
(18, 'Mustafa', 'Tüfekçi', 'tufekci@gmail.com', 'asd', '1977-06-21'),
(20, 'testing', 'testing', 'testing', 'testing', '2000-01-01'),
(21, 'asd', 'asd', 'asd', 'asd', '1231-12-12'),
(22, 'sdfsdf', 'sdfsdf', 'sdsdfsdf', 'sdfsdf', '1233-11-11'),
(23, '234234', '234', '234', '2342', '1999-01-01'),
(25, 'asda', 'sdasd', 'asdasd', 'asda', '1999-01-01'),
(26, '123', '123', '23', '23', '0123-01-01');

-- --------------------------------------------------------

--
-- Table structure for table `movies`
--

CREATE TABLE `movies` (
  `id` int(11) NOT NULL,
  `title` text COLLATE utf8_turkish_ci NOT NULL,
  `genre` text COLLATE utf8_turkish_ci NOT NULL,
  `rate` double NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `urlPoster` text COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Dumping data for table `movies`
--

INSERT INTO `movies` (`id`, `title`, `genre`, `rate`, `date`, `time`, `urlPoster`) VALUES
(1, 'Me and Earl and the Dying Girl', 'Comedy / Drama', 7.8, '2015-07-01', '18:00:00', 'https://m.media-amazon.com/images/M/MV5BNTA1NzUzNjY4MV5BMl5BanBnXkFtZTgwNDU0MDI0NTE@._V1_UX182_CR0,0,182,268_AL_.jpg'),
(2, 'Ex Machina', 'Mystery, Sci-Fi', 7.7, '2015-04-24', '20:00:00', 'https://m.media-amazon.com/images/M/MV5BMTUxNzc0OTIxMV5BMl5BanBnXkFtZTgwNDI3NzU2NDE@._V1_UX182_CR0,0,182,268_AL_.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `sold_tickets`
--

CREATE TABLE `sold_tickets` (
  `movieID` int(11) NOT NULL,
  `customerID` int(11) NOT NULL,
  `seatNumber` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Dumping data for table `sold_tickets`
--

INSERT INTO `sold_tickets` (`movieID`, `customerID`, `seatNumber`) VALUES
(1, 1, 7),
(1, 1, 8),
(1, 1, 9),
(1, 1, 17),
(1, 1, 18),
(1, 1, 19),
(1, 1, 20),
(1, 1, 21),
(1, 1, 26),
(1, 1, 27),
(1, 1, 28),
(1, 1, 30),
(1, 1, 31),
(1, 1, 32),
(1, 1, 33),
(1, 1, 34),
(1, 1, 43),
(1, 1, 44),
(1, 1, 45),
(2, 1, 5),
(2, 1, 6),
(2, 1, 7),
(2, 1, 9),
(2, 1, 11),
(2, 1, 15),
(2, 1, 16),
(2, 1, 17),
(2, 1, 18),
(2, 1, 19),
(2, 1, 28),
(2, 1, 29),
(2, 1, 30),
(2, 1, 31),
(2, 1, 35);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`(200));

--
-- Indexes for table `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sold_tickets`
--
ALTER TABLE `sold_tickets`
  ADD UNIQUE KEY `movieID` (`movieID`,`seatNumber`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `movies`
--
ALTER TABLE `movies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
