-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 28, 2022 at 07:02 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lms`
--

-- --------------------------------------------------------

--
-- Table structure for table `addbooks`
--

CREATE TABLE `addbooks` (
  `ID` int(25) NOT NULL,
  `NAME` varchar(25) NOT NULL,
  `ISBN` varchar(25) NOT NULL,
  `PUBLISHER` varchar(25) NOT NULL,
  `EDITION` varchar(25) NOT NULL,
  `PRICE` varchar(25) NOT NULL,
  `PAGES` varchar(25) NOT NULL,
  `DATE` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `addbooks`
--

INSERT INTO `addbooks` (`ID`, `NAME`, `ISBN`, `PUBLISHER`, `EDITION`, `PRICE`, `PAGES`, `DATE`) VALUES
(1, 'Java', 'ABC1', 'Asmita', '1st', '300', '200', '2022-08-11'),
(2, 'DotNet', 'ABC2', 'Asmita', '3rd', '1200', '500', '2022-08-27'),
(3, 'Mobile Programming', 'ABC3', 'Asmita', '5th', '400', '300', '2022-08-27'),
(4, 'Network Programming', 'ABC4', 'Kalika', '3rd', '900', '500', '2022-08-27'),
(5, 'Distributed System', 'ABC5', 'Taleju', '7th', '1300', '400', '2022-08-27'),
(6, 'Javascript', 'ABC6', 'Encoder', '4th', '2550', '900', '2022-08-27');

-- --------------------------------------------------------

--
-- Table structure for table `addstudents`
--

CREATE TABLE `addstudents` (
  `ID` int(25) NOT NULL,
  `NAME` varchar(25) NOT NULL,
  `NUMBER` varchar(25) NOT NULL,
  `EMAIL` varchar(25) NOT NULL,
  `COURSE` varchar(25) NOT NULL,
  `YEAR` varchar(25) NOT NULL,
  `SEMESTER` varchar(25) NOT NULL,
  `DATE` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `addstudents`
--

INSERT INTO `addstudents` (`ID`, `NAME`, `NUMBER`, `EMAIL`, `COURSE`, `YEAR`, `SEMESTER`, `DATE`) VALUES
(1, 'Suman Pandey', '9840890123', 'sumanpandey977n@gmail.com', 'BCA', '-', '7th', '2022-08-14'),
(2, 'Subash Lama', '9813332847', 'subashlama111@gmail.com', 'BBS', 'Fourth', '-', '2022-08-27'),
(3, 'Sneha Poudel', '9812434823', 'sneha@gmail.com', 'BBM', 'Second', '-', '2022-08-27'),
(4, 'Radha Pandey', '9840890123', 'radha@gmail.com', 'MBS', 'Fourth', '-', '2022-08-27'),
(5, 'Salman Khan', '9831536523', 'salmanbhai@gmail.com', 'MBS', 'Fourth', '-', '2022-08-27'),
(6, 'Sharukh Khan', '9831254252', 'khan@gmail.com', 'MBS', 'Fourth', '-', '2022-08-27');

-- --------------------------------------------------------

--
-- Table structure for table `bookissue`
--

CREATE TABLE `bookissue` (
  `SID` int(25) NOT NULL,
  `SNAME` varchar(25) NOT NULL,
  `BID` int(25) NOT NULL,
  `BNAME` varchar(25) NOT NULL,
  `DATE` varchar(25) NOT NULL,
  `EXPIRY` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bookissue`
--

INSERT INTO `bookissue` (`SID`, `SNAME`, `BID`, `BNAME`, `DATE`, `EXPIRY`) VALUES
(6, 'Sharukh Khan', 4, 'Network Programming', '2022-08-27', '2022-9-11');

-- --------------------------------------------------------

--
-- Table structure for table `bookreturn`
--

CREATE TABLE `bookreturn` (
  `SID` int(25) NOT NULL,
  `SNAME` varchar(25) NOT NULL,
  `BID` int(25) NOT NULL,
  `BNAME` varchar(25) NOT NULL,
  `DATE` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bookreturn`
--

INSERT INTO `bookreturn` (`SID`, `SNAME`, `BID`, `BNAME`, `DATE`) VALUES
(1, 'Suman Pandey', 2, 'DotNet', '2022-08-27'),
(4, 'Radha Pandey', 1, 'Java', '2022-08-27'),
(2, 'Subash Lama', 3, 'Mobile Programming', '2022-08-27');

-- --------------------------------------------------------

--
-- Table structure for table `log`
--

CREATE TABLE `log` (
  `LOG` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `log`
--

INSERT INTO `log` (`LOG`) VALUES
('Java Book Is Added Successfully'),
('Suman Pandey Is Registered Successfully'),
('DotNet Book Is Added Successfully'),
('Mobile Programming Book Is Added Successfully'),
('Subash Lama Is Registered Successfully'),
('Sneha Poudel Is Registered Successfully'),
('Suman Pandey Issue The Book DotNet'),
('Subash Lama Issue The Book Mobile Programming'),
('Suman Pandey Returned The Book DotNet'),
('Network Programming Book Is Added Successfully'),
('Distributed System Book Is Added Successfully'),
('Radha Pandey Is Registered Successfully'),
('Salman Khan Is Registered Successfully'),
('Subash Lama Issue The Book Distributed System'),
('Radha Pandey Issue The Book Java'),
('Radha Pandey Returned The Book Java'),
('Javascript Book Is Added Successfully'),
('Sharukh Khan Is Registered Successfully'),
('Sharukh Khan Issue The Book Network Programming'),
('Subash Lama Returned The Book Mobile Programming');

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `id` int(25) NOT NULL,
  `uname` varchar(25) NOT NULL,
  `name` varchar(25) NOT NULL,
  `pwd` varchar(25) NOT NULL,
  `num` varchar(25) NOT NULL,
  `secretkey` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`id`, `uname`, `name`, `pwd`, `num`, `secretkey`) VALUES
(1, 'admin', 'Suman Pandey', 'Nepal@123', '9818291035', 'myKey');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `addbooks`
--
ALTER TABLE `addbooks`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `addstudents`
--
ALTER TABLE `addstudents`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `addbooks`
--
ALTER TABLE `addbooks`
  MODIFY `ID` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `addstudents`
--
ALTER TABLE `addstudents`
  MODIFY `ID` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
