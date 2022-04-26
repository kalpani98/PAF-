-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 26, 2022 at 10:30 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lab`
--

-- --------------------------------------------------------

--
-- Table structure for table `Billing`
--

CREATE TABLE `Billing` (
  `AccNo` int(11) NOT NULL,
  `CustomerName` varchar(11) NOT NULL,
  `BillAmount` varchar(11) NOT NULL,
  `Date` varchar(11) NOT NULL,
  `Email` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Billing`
--

INSERT INTO `Billing` (`AccNo`, `CustomerName`, `BillAmount`, `Date`, `Email`) VALUES
(7, 'admin', 'admin', '2002', '120@gmail');

-- --------------------------------------------------------

--
-- Table structure for table `bills`
--

CREATE TABLE `bills` (
  `billID` int(11) NOT NULL,
  `userID` varchar(10) NOT NULL,
  `date` varchar(10) NOT NULL,
  `reading` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bills`
--

INSERT INTO `bills` (`billID`, `userID`, `date`, `reading`) VALUES
(2, '7', 'asdas', 123),
(3, '7', 'kumar', 120);

-- --------------------------------------------------------

--
-- Table structure for table `emp`
--

CREATE TABLE `emp` (
  `eID` int(11) NOT NULL,
  `eName` varchar(10) NOT NULL,
  `eRole` varchar(10) NOT NULL,
  `ePass` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `emp`
--

INSERT INTO `emp` (`eID`, `eName`, `eRole`, `ePass`) VALUES
(8, 'kumar', 'Employee', '123'),
(9, 'pranavan', 'admin', '123'),
(10, 'pranavan', 'admin', '143'),
(11, 'admin', 'admin', '143'),
(12, 'admin12', 'admin', '143');

-- --------------------------------------------------------

--
-- Table structure for table `feed`
--

CREATE TABLE `feed` (
  `fID` int(11) NOT NULL,
  `fName` varchar(10) NOT NULL,
  `eMail` varchar(15) NOT NULL,
  `feedBack` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `feed`
--

INSERT INTO `feed` (`fID`, `fName`, `eMail`, `feedBack`) VALUES
(3, 'kumar', 'aishu@gmail.com', 'not good for all');

-- --------------------------------------------------------

--
-- Table structure for table `Pay`
--

CREATE TABLE `Pay` (
  `PaymentID` int(11) NOT NULL,
  `CustomerName` varchar(15) NOT NULL,
  `BillAmount` varchar(15) NOT NULL,
  `AccountNo` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Pay`
--

INSERT INTO `Pay` (`PaymentID`, `CustomerName`, `BillAmount`, `AccountNo`) VALUES
(3, 'admin', 'admin', '2002'),
(4, 'admin', 'admin', '2002');

-- --------------------------------------------------------

--
-- Table structure for table `Power`
--

CREATE TABLE `Power` (
  `billID` int(11) NOT NULL,
  `AccountNo` varchar(12) NOT NULL,
  `CustomerName` varchar(15) NOT NULL,
  `District` varchar(10) NOT NULL,
  `Time` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Power`
--

INSERT INTO `Power` (`billID`, `AccountNo`, `CustomerName`, `District`, `Time`) VALUES
(1, 'admin', 'admin', 'col-2', '1300hr');

-- --------------------------------------------------------

--
-- Table structure for table `units`
--

CREATE TABLE `units` (
  `unitID` int(11) NOT NULL,
  `dist` varchar(5) NOT NULL,
  `unitp` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `units`
--

INSERT INTO `units` (`unitID`, `dist`, `unitp`) VALUES
(1, 'kand', '130'),
(2, 'col\n', '120');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `nID` int(11) NOT NULL,
  `nic` varchar(12) NOT NULL,
  `tele` varchar(12) NOT NULL,
  `address` varchar(20) NOT NULL,
  `meterNo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`nID`, `nic`, `tele`, `address`, `meterNo`) VALUES
(2, '992083', '07725996', '99.mainstreet', 120);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `UserName` varchar(12) NOT NULL,
  `Password` varchar(12) NOT NULL,
  `Name` varchar(12) NOT NULL,
  `EmailID` varchar(116) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `UserName`, `Password`, `Name`, `EmailID`) VALUES
(1, 'admin', '071850', 'Amal', 'Amal@123'),
(2, 'admin', '123', 'kumar', 'as@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Billing`
--
ALTER TABLE `Billing`
  ADD PRIMARY KEY (`AccNo`);

--
-- Indexes for table `bills`
--
ALTER TABLE `bills`
  ADD PRIMARY KEY (`billID`);

--
-- Indexes for table `emp`
--
ALTER TABLE `emp`
  ADD PRIMARY KEY (`eID`);

--
-- Indexes for table `feed`
--
ALTER TABLE `feed`
  ADD PRIMARY KEY (`fID`);

--
-- Indexes for table `Pay`
--
ALTER TABLE `Pay`
  ADD PRIMARY KEY (`PaymentID`);

--
-- Indexes for table `Power`
--
ALTER TABLE `Power`
  ADD PRIMARY KEY (`billID`);

--
-- Indexes for table `units`
--
ALTER TABLE `units`
  ADD PRIMARY KEY (`unitID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`nID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bills`
--
ALTER TABLE `bills`
  MODIFY `billID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `emp`
--
ALTER TABLE `emp`
  MODIFY `eID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `feed`
--
ALTER TABLE `feed`
  MODIFY `fID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `units`
--
ALTER TABLE `units`
  MODIFY `unitID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `nID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
