-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 21, 2018 at 02:14 PM
-- Server version: 10.1.34-MariaDB
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
  `duration` text COLLATE utf8_turkish_ci NOT NULL,
  `rating` double NOT NULL,
  `director` text COLLATE utf8_turkish_ci NOT NULL,
  `actors` text COLLATE utf8_turkish_ci NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `urlPoster` text COLLATE utf8_turkish_ci NOT NULL,
  `summary` text COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Dumping data for table `movies`
--

INSERT INTO `movies` (`id`, `title`, `genre`, `duration`, `rating`, `director`, `actors`, `date`, `time`, `urlPoster`, `summary`) VALUES
(1, 'Incredibles 2 (2018)', 'Animation, Action', '118 min', 8.4, 'Brad Bird', 'Craig T. Nelson, Holly Hunter, Sarah Vowell', '2018-06-21', '10:00:00', 'https://m.media-amazon.com/images/M/MV5BMTEzNzY0OTg0NTdeQTJeQWpwZ15BbWU4MDU3OTg3MjUz._V1_UY209_CR0,0,140,209_AL_.jpg', 'Bob Parr (Mr. Incredible) is left to care for the kids while Helen (Elastigirl) is out saving the world.'),
(2, 'Incredibles 2 (2018)', 'Animation, Action', '118 min', 8.4, 'Brad Bird', 'Craig T. Nelson, Holly Hunter, Sarah Vowell', '2018-06-21', '13:00:00', 'https://m.media-amazon.com/images/M/MV5BMTEzNzY0OTg0NTdeQTJeQWpwZ15BbWU4MDU3OTg3MjUz._V1_UY209_CR0,0,140,209_AL_.jpg', 'Bob Parr (Mr. Incredible) is left to care for the kids while Helen (Elastigirl) is out saving the world.'),
(3, 'Incredibles 2 (2018)', 'Animation, Action', '118 min', 8.4, 'Brad Bird', 'Craig T. Nelson, Holly Hunter, Sarah Vowell', '2018-06-21', '16:00:00', 'https://m.media-amazon.com/images/M/MV5BMTEzNzY0OTg0NTdeQTJeQWpwZ15BbWU4MDU3OTg3MjUz._V1_UY209_CR0,0,140,209_AL_.jpg', 'Bob Parr (Mr. Incredible) is left to care for the kids while Helen (Elastigirl) is out saving the world.'),
(4, 'Incredibles 2 (2018)', 'Animation, Action', '118 min', 8.4, 'Brad Bird', 'Craig T. Nelson, Holly Hunter, Sarah Vowell', '2018-06-21', '21:00:00', 'https://m.media-amazon.com/images/M/MV5BMTEzNzY0OTg0NTdeQTJeQWpwZ15BbWU4MDU3OTg3MjUz._V1_UY209_CR0,0,140,209_AL_.jpg', 'Bob Parr (Mr. Incredible) is left to care for the kids while Helen (Elastigirl) is out saving the world.'),
(5, 'Ocean\'s Eight (2018)', 'Action, Comedy', '110 min', 6.3, 'Gary Ross', 'Sandra Bullock, Cate Blanchett, Anne Hathaway', '2018-06-21', '10:00:00', 'https://m.media-amazon.com/images/M/MV5BMjAyNDEyMzc4Ml5BMl5BanBnXkFtZTgwMjEzNjM0NTM@._V1_UY209_CR0,0,140,209_AL_.jpg', 'Debbie Ocean gathers an all-female crew to attempt an impossible heist at New York City\'s yearly Met Gala.'),
(6, 'Ocean\'s Eight (2018)', 'Action, Comedy', '110 min', 6.3, 'Gary Ross', 'Sandra Bullock, Cate Blanchett, Anne Hathaway', '2018-06-21', '13:00:00', 'https://m.media-amazon.com/images/M/MV5BMjAyNDEyMzc4Ml5BMl5BanBnXkFtZTgwMjEzNjM0NTM@._V1_UY209_CR0,0,140,209_AL_.jpg', 'Debbie Ocean gathers an all-female crew to attempt an impossible heist at New York City\'s yearly Met Gala.'),
(7, 'Ocean\'s Eight (2018)', 'Action, Comedy', '110 min', 6.3, 'Gary Ross', 'Sandra Bullock, Cate Blanchett, Anne Hathaway', '2018-06-21', '16:00:00', 'https://m.media-amazon.com/images/M/MV5BMjAyNDEyMzc4Ml5BMl5BanBnXkFtZTgwMjEzNjM0NTM@._V1_UY209_CR0,0,140,209_AL_.jpg', 'Debbie Ocean gathers an all-female crew to attempt an impossible heist at New York City\'s yearly Met Gala.'),
(8, 'Ocean\'s Eight (2018)', 'Action, Comedy', '110 min', 6.3, 'Gary Ross', 'Sandra Bullock, Cate Blanchett, Anne Hathaway', '2018-06-21', '21:00:00', 'https://m.media-amazon.com/images/M/MV5BMjAyNDEyMzc4Ml5BMl5BanBnXkFtZTgwMjEzNjM0NTM@._V1_UY209_CR0,0,140,209_AL_.jpg', 'Debbie Ocean gathers an all-female crew to attempt an impossible heist at New York City\'s yearly Met Gala.'),
(9, 'Tag (2018)', 'Comedy', '100 min', 7, 'Jeff Tomsic', 'Jeremy Renner, Ed Helms, Jake Johnson', '2018-06-21', '10:00:00', 'https://m.media-amazon.com/images/M/MV5BNzk4NDM3NjkwNF5BMl5BanBnXkFtZTgwNTk5MzkzNTM@._V1_UY209_CR0,0,140,209_AL_.jpg', 'A small group of former classmates organize an elaborate, annual game of tag that requires some to travel all over the country.'),
(10, 'Tag (2018)', 'Comedy', '100 min', 7, 'Jeff Tomsic', 'Jeremy Renner, Ed Helms, Jake Johnson', '2018-06-21', '13:00:00', 'https://m.media-amazon.com/images/M/MV5BNzk4NDM3NjkwNF5BMl5BanBnXkFtZTgwNTk5MzkzNTM@._V1_UY209_CR0,0,140,209_AL_.jpg', 'A small group of former classmates organize an elaborate, annual game of tag that requires some to travel all over the country.'),
(11, 'Tag (2018)', 'Comedy', '100 min', 7, 'Jeff Tomsic', 'Jeremy Renner, Ed Helms, Jake Johnson', '2018-06-21', '16:00:00', 'https://m.media-amazon.com/images/M/MV5BNzk4NDM3NjkwNF5BMl5BanBnXkFtZTgwNTk5MzkzNTM@._V1_UY209_CR0,0,140,209_AL_.jpg', 'A small group of former classmates organize an elaborate, annual game of tag that requires some to travel all over the country.'),
(12, 'Tag (2018)', 'Comedy', '100 min', 7, 'Jeff Tomsic', 'Jeremy Renner, Ed Helms, Jake Johnson', '2018-06-21', '21:00:00', 'https://m.media-amazon.com/images/M/MV5BNzk4NDM3NjkwNF5BMl5BanBnXkFtZTgwNTk5MzkzNTM@._V1_UY209_CR0,0,140,209_AL_.jpg', 'A small group of former classmates organize an elaborate, annual game of tag that requires some to travel all over the country.'),
(13, 'Solo: A Star Wars Story (2018)', 'Action, Adventure', '135 min', 7.2, 'Ron Howard', 'Alden Ehrenreich, Woody Harrelson, Emilia Clarke', '2018-06-21', '10:00:00', 'https://m.media-amazon.com/images/M/MV5BOTM2NTI3NTc3Nl5BMl5BanBnXkFtZTgwNzM1OTQyNTM@._V1_UY209_CR0,0,140,209_AL_.jpg', 'During an adventure into the criminal underworld, Han Solo meets his future copilot Chewbacca and encounters Lando Calrissian years before joining the Rebellion.'),
(14, 'Solo: A Star Wars Story (2018)', 'Action, Adventure', '135 min', 7.2, 'Ron Howard', 'Alden Ehrenreich, Woody Harrelson, Emilia Clarke', '2018-06-21', '13:00:00', 'https://m.media-amazon.com/images/M/MV5BOTM2NTI3NTc3Nl5BMl5BanBnXkFtZTgwNzM1OTQyNTM@._V1_UY209_CR0,0,140,209_AL_.jpg', 'During an adventure into the criminal underworld, Han Solo meets his future copilot Chewbacca and encounters Lando Calrissian years before joining the Rebellion.'),
(15, 'Solo: A Star Wars Story (2018)', 'Action, Adventure', '135 min', 7.2, 'Ron Howard', 'Alden Ehrenreich, Woody Harrelson, Emilia Clarke', '2018-06-21', '16:00:00', 'https://m.media-amazon.com/images/M/MV5BOTM2NTI3NTc3Nl5BMl5BanBnXkFtZTgwNzM1OTQyNTM@._V1_UY209_CR0,0,140,209_AL_.jpg', 'During an adventure into the criminal underworld, Han Solo meets his future copilot Chewbacca and encounters Lando Calrissian years before joining the Rebellion.'),
(16, 'Solo: A Star Wars Story (2018)', 'Action, Adventure', '135 min', 7.2, 'Ron Howard', 'Alden Ehrenreich, Woody Harrelson, Emilia Clarke', '2018-06-21', '21:00:00', 'https://m.media-amazon.com/images/M/MV5BOTM2NTI3NTc3Nl5BMl5BanBnXkFtZTgwNzM1OTQyNTM@._V1_UY209_CR0,0,140,209_AL_.jpg', 'During an adventure into the criminal underworld, Han Solo meets his future copilot Chewbacca and encounters Lando Calrissian years before joining the Rebellion.'),
(17, 'Deadpool 2 (2018)', 'Action, Adventure', '119 min', 8.1, 'David Leitch', 'Ryan Reynolds, Josh Brolin, Morena Baccarin', '2018-06-21', '10:00:00', 'https://m.media-amazon.com/images/M/MV5BMjI3Njg3MzAxNF5BMl5BanBnXkFtZTgwNjI2OTY0NTM@._V1_UY209_CR0,0,140,209_AL_.jpg', 'Foul-mouthed mutant mercenary Wade Wilson (AKA. Deadpool), brings together a team of fellow mutant rogues to protect a young boy with supernatural abilities from the brutal, time-traveling cyborg, Cable.'),
(18, 'Deadpool 2 (2018)', 'Action, Adventure', '119 min', 8.1, 'David Leitch', 'Ryan Reynolds, Josh Brolin, Morena Baccarin', '2018-06-21', '13:00:00', 'https://m.media-amazon.com/images/M/MV5BMjI3Njg3MzAxNF5BMl5BanBnXkFtZTgwNjI2OTY0NTM@._V1_UY209_CR0,0,140,209_AL_.jpg', 'Foul-mouthed mutant mercenary Wade Wilson (AKA. Deadpool), brings together a team of fellow mutant rogues to protect a young boy with supernatural abilities from the brutal, time-traveling cyborg, Cable.'),
(19, 'Deadpool 2 (2018)', 'Action, Adventure', '119 min', 8.1, 'David Leitch', 'Ryan Reynolds, Josh Brolin, Morena Baccarin', '2018-06-21', '16:00:00', 'https://m.media-amazon.com/images/M/MV5BMjI3Njg3MzAxNF5BMl5BanBnXkFtZTgwNjI2OTY0NTM@._V1_UY209_CR0,0,140,209_AL_.jpg', 'Foul-mouthed mutant mercenary Wade Wilson (AKA. Deadpool), brings together a team of fellow mutant rogues to protect a young boy with supernatural abilities from the brutal, time-traveling cyborg, Cable.'),
(20, 'Deadpool 2 (2018)', 'Action, Adventure', '119 min', 8.1, 'David Leitch', 'Ryan Reynolds, Josh Brolin, Morena Baccarin', '2018-06-21', '21:00:00', 'https://m.media-amazon.com/images/M/MV5BMjI3Njg3MzAxNF5BMl5BanBnXkFtZTgwNjI2OTY0NTM@._V1_UY209_CR0,0,140,209_AL_.jpg', 'Foul-mouthed mutant mercenary Wade Wilson (AKA. Deadpool), brings together a team of fellow mutant rogues to protect a young boy with supernatural abilities from the brutal, time-traveling cyborg, Cable.'),
(21, 'Hereditary (2018)', 'Drama, Horror', '127 min', 7.8, 'Ari Aster', 'Toni Collette, Milly Shapiro, Gabriel Byrne', '2018-06-21', '10:00:00', 'https://m.media-amazon.com/images/M/MV5BOTU5MDg3OGItZWQ1Ny00ZGVmLTg2YTUtMzBkYzQ1YWIwZjlhXkEyXkFqcGdeQXVyNTAzMTY4MDA@._V1_UY209_CR0,0,140,209_AL_.jpg', 'After the family matriarch passes away, a grieving family is haunted by tragic and disturbing occurrences, and begin to unravel dark secrets.'),
(22, 'Hereditary (2018)', 'Drama, Horror', '127 min', 7.8, 'Ari Aster', 'Toni Collette, Milly Shapiro, Gabriel Byrne', '2018-06-21', '13:00:00', 'https://m.media-amazon.com/images/M/MV5BOTU5MDg3OGItZWQ1Ny00ZGVmLTg2YTUtMzBkYzQ1YWIwZjlhXkEyXkFqcGdeQXVyNTAzMTY4MDA@._V1_UY209_CR0,0,140,209_AL_.jpg', 'After the family matriarch passes away, a grieving family is haunted by tragic and disturbing occurrences, and begin to unravel dark secrets.'),
(23, 'Hereditary (2018)', 'Drama, Horror', '127 min', 7.8, 'Ari Aster', 'Toni Collette, Milly Shapiro, Gabriel Byrne', '2018-06-21', '16:00:00', 'https://m.media-amazon.com/images/M/MV5BOTU5MDg3OGItZWQ1Ny00ZGVmLTg2YTUtMzBkYzQ1YWIwZjlhXkEyXkFqcGdeQXVyNTAzMTY4MDA@._V1_UY209_CR0,0,140,209_AL_.jpg', 'After the family matriarch passes away, a grieving family is haunted by tragic and disturbing occurrences, and begin to unravel dark secrets.'),
(24, 'Hereditary (2018)', 'Drama, Horror', '127 min', 7.8, 'Ari Aster', 'Toni Collette, Milly Shapiro, Gabriel Byrne', '2018-06-21', '21:00:00', 'https://m.media-amazon.com/images/M/MV5BOTU5MDg3OGItZWQ1Ny00ZGVmLTg2YTUtMzBkYzQ1YWIwZjlhXkEyXkFqcGdeQXVyNTAzMTY4MDA@._V1_UY209_CR0,0,140,209_AL_.jpg', 'After the family matriarch passes away, a grieving family is haunted by tragic and disturbing occurrences, and begin to unravel dark secrets.'),
(25, 'Superfly (2018)', 'Action, Crime', '116 min', 5, 'Director X.', 'Trevor Jackson, Jason Mitchell, Lex Scott Davis', '2018-06-21', '10:00:00', 'https://m.media-amazon.com/images/M/MV5BMWU1Yzc0ZDUtNGFlZC00ZTFkLWIxMTEtZTQ5ZTliYzIxZWI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX140_CR0,0,140,209_AL_.jpg', 'With his sights set on retiring, a successful young drug dealer sets up one last big deal.'),
(26, 'Superfly (2018)', 'Action, Crime', '116 min', 5, 'Director X.', 'Trevor Jackson, Jason Mitchell, Lex Scott Davis', '2018-06-21', '13:00:00', 'https://m.media-amazon.com/images/M/MV5BMWU1Yzc0ZDUtNGFlZC00ZTFkLWIxMTEtZTQ5ZTliYzIxZWI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX140_CR0,0,140,209_AL_.jpg', 'With his sights set on retiring, a successful young drug dealer sets up one last big deal.'),
(27, 'Superfly (2018)', 'Action, Crime', '116 min', 5, 'Director X.', 'Trevor Jackson, Jason Mitchell, Lex Scott Davis', '2018-06-21', '16:00:00', 'https://m.media-amazon.com/images/M/MV5BMWU1Yzc0ZDUtNGFlZC00ZTFkLWIxMTEtZTQ5ZTliYzIxZWI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX140_CR0,0,140,209_AL_.jpg', 'With his sights set on retiring, a successful young drug dealer sets up one last big deal.'),
(28, 'Superfly (2018)', 'Action, Crime', '116 min', 5, 'Director X.', 'Trevor Jackson, Jason Mitchell, Lex Scott Davis', '2018-06-21', '21:00:00', 'https://m.media-amazon.com/images/M/MV5BMWU1Yzc0ZDUtNGFlZC00ZTFkLWIxMTEtZTQ5ZTliYzIxZWI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX140_CR0,0,140,209_AL_.jpg', 'With his sights set on retiring, a successful young drug dealer sets up one last big deal.'),
(29, 'Avengers: Infinity War (2018)', 'Action, Adventure', '149 min', 8.8, 'Anthony Russo Joe Russo', 'Robert Downey Jr., Chris Hemsworth, Mark Ruffalo', '2018-06-21', '10:00:00', 'https://m.media-amazon.com/images/M/MV5BMjMxNjY2MDU1OV5BMl5BanBnXkFtZTgwNzY1MTUwNTM@._V1_UY209_CR0,0,140,209_AL_.jpg', 'The Avengers and their allies must be willing to sacrifice all in an attempt to defeat the powerful Thanos before his blitz of devastation and ruin puts an end to the universe.'),
(30, 'Avengers: Infinity War (2018)', 'Action, Adventure', '149 min', 8.8, 'Anthony Russo Joe Russo', 'Robert Downey Jr., Chris Hemsworth, Mark Ruffalo', '2018-06-21', '13:00:00', 'https://m.media-amazon.com/images/M/MV5BMjMxNjY2MDU1OV5BMl5BanBnXkFtZTgwNzY1MTUwNTM@._V1_UY209_CR0,0,140,209_AL_.jpg', 'The Avengers and their allies must be willing to sacrifice all in an attempt to defeat the powerful Thanos before his blitz of devastation and ruin puts an end to the universe.'),
(31, 'Avengers: Infinity War (2018)', 'Action, Adventure', '149 min', 8.8, 'Anthony Russo Joe Russo', 'Robert Downey Jr., Chris Hemsworth, Mark Ruffalo', '2018-06-21', '16:00:00', 'https://m.media-amazon.com/images/M/MV5BMjMxNjY2MDU1OV5BMl5BanBnXkFtZTgwNzY1MTUwNTM@._V1_UY209_CR0,0,140,209_AL_.jpg', 'The Avengers and their allies must be willing to sacrifice all in an attempt to defeat the powerful Thanos before his blitz of devastation and ruin puts an end to the universe.'),
(32, 'Avengers: Infinity War (2018)', 'Action, Adventure', '149 min', 8.8, 'Anthony Russo Joe Russo', 'Robert Downey Jr., Chris Hemsworth, Mark Ruffalo', '2018-06-21', '21:00:00', 'https://m.media-amazon.com/images/M/MV5BMjMxNjY2MDU1OV5BMl5BanBnXkFtZTgwNzY1MTUwNTM@._V1_UY209_CR0,0,140,209_AL_.jpg', 'The Avengers and their allies must be willing to sacrifice all in an attempt to defeat the powerful Thanos before his blitz of devastation and ruin puts an end to the universe.'),
(33, 'Adrift (2018)', 'Action, Adventure', '96 min', 6.8, 'Baltasar Kormákur', 'Shailene Woodley, Sam Claflin, Grace Palmer', '2018-06-21', '10:00:00', 'https://m.media-amazon.com/images/M/MV5BMTkxMTI2MjE4OF5BMl5BanBnXkFtZTgwMjIyODQzNTM@._V1_UY209_CR0,0,140,209_AL_.jpg', 'Based on the true story of survival, a young couple\'s chance encounter leads them first to love, and then on the adventure of a lifetime as they face one of the most catastrophic hurricanes in recorded history.'),
(34, 'Adrift (2018)', 'Action, Adventure', '96 min', 6.8, 'Baltasar Kormákur', 'Shailene Woodley, Sam Claflin, Grace Palmer', '2018-06-21', '13:00:00', 'https://m.media-amazon.com/images/M/MV5BMTkxMTI2MjE4OF5BMl5BanBnXkFtZTgwMjIyODQzNTM@._V1_UY209_CR0,0,140,209_AL_.jpg', 'Based on the true story of survival, a young couple\'s chance encounter leads them first to love, and then on the adventure of a lifetime as they face one of the most catastrophic hurricanes in recorded history.'),
(35, 'Adrift (2018)', 'Action, Adventure', '96 min', 6.8, 'Baltasar Kormákur', 'Shailene Woodley, Sam Claflin, Grace Palmer', '2018-06-21', '16:00:00', 'https://m.media-amazon.com/images/M/MV5BMTkxMTI2MjE4OF5BMl5BanBnXkFtZTgwMjIyODQzNTM@._V1_UY209_CR0,0,140,209_AL_.jpg', 'Based on the true story of survival, a young couple\'s chance encounter leads them first to love, and then on the adventure of a lifetime as they face one of the most catastrophic hurricanes in recorded history.'),
(36, 'Adrift (2018)', 'Action, Adventure', '96 min', 6.8, 'Baltasar Kormákur', 'Shailene Woodley, Sam Claflin, Grace Palmer', '2018-06-21', '21:00:00', 'https://m.media-amazon.com/images/M/MV5BMTkxMTI2MjE4OF5BMl5BanBnXkFtZTgwMjIyODQzNTM@._V1_UY209_CR0,0,140,209_AL_.jpg', 'Based on the true story of survival, a young couple\'s chance encounter leads them first to love, and then on the adventure of a lifetime as they face one of the most catastrophic hurricanes in recorded history.'),
(37, 'Book Club (2018)', 'Comedy, Drama', '104 min', 6.3, 'Bill Holderman', 'Diane Keaton, Jane Fonda, Candice Bergen', '2018-06-21', '10:00:00', 'https://m.media-amazon.com/images/M/MV5BMTc0MDY2MDI3Ml5BMl5BanBnXkFtZTgwNjU2MzIyNTM@._V1_UX140_CR0,0,140,209_AL_.jpg', 'Four lifelong friends have their lives forever changed after reading 50 Shades of Grey in their monthly book club.'),
(38, 'Book Club (2018)', 'Comedy, Drama', '104 min', 6.3, 'Bill Holderman', 'Diane Keaton, Jane Fonda, Candice Bergen', '2018-06-21', '13:00:00', 'https://m.media-amazon.com/images/M/MV5BMTc0MDY2MDI3Ml5BMl5BanBnXkFtZTgwNjU2MzIyNTM@._V1_UX140_CR0,0,140,209_AL_.jpg', 'Four lifelong friends have their lives forever changed after reading 50 Shades of Grey in their monthly book club.'),
(39, 'Book Club (2018)', 'Comedy, Drama', '104 min', 6.3, 'Bill Holderman', 'Diane Keaton, Jane Fonda, Candice Bergen', '2018-06-21', '16:00:00', 'https://m.media-amazon.com/images/M/MV5BMTc0MDY2MDI3Ml5BMl5BanBnXkFtZTgwNjU2MzIyNTM@._V1_UX140_CR0,0,140,209_AL_.jpg', 'Four lifelong friends have their lives forever changed after reading 50 Shades of Grey in their monthly book club.'),
(40, 'Book Club (2018)', 'Comedy, Drama', '104 min', 6.3, 'Bill Holderman', 'Diane Keaton, Jane Fonda, Candice Bergen', '2018-06-21', '21:00:00', 'https://m.media-amazon.com/images/M/MV5BMTc0MDY2MDI3Ml5BMl5BanBnXkFtZTgwNjU2MzIyNTM@._V1_UX140_CR0,0,140,209_AL_.jpg', 'Four lifelong friends have their lives forever changed after reading 50 Shades of Grey in their monthly book club.');

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
(1, 1, 4),
(1, 1, 5),
(1, 1, 6),
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
(2, 1, 20),
(2, 1, 28),
(2, 1, 29),
(2, 1, 30),
(2, 1, 31),
(2, 1, 35),
(17, 1, 4),
(17, 1, 5),
(17, 1, 6),
(17, 1, 7),
(17, 1, 10),
(17, 1, 11),
(17, 1, 14),
(17, 1, 17),
(17, 1, 20),
(17, 1, 21),
(17, 1, 22),
(17, 1, 23),
(17, 1, 26),
(17, 1, 28),
(17, 1, 29),
(17, 1, 42),
(17, 1, 43),
(17, 1, 44);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
