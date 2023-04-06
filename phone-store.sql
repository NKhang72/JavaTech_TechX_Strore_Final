-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 21, 2023 at 04:07 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `phone-store`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_advertisement`
--

CREATE TABLE `tb_advertisement` (
  `id` int(11) NOT NULL,
  `Title` varchar(200) DEFAULT NULL,
  `Description` varchar(500) DEFAULT NULL,
  `Image` varchar(500) DEFAULT NULL,
  `Type` int(11) DEFAULT NULL,
  `Link` varchar(500) DEFAULT NULL,
  `Meta` varchar(50) DEFAULT NULL,
  `Hide` tinyint(1) DEFAULT NULL,
  `Position` int(11) DEFAULT NULL,
  `CreateDate` datetime DEFAULT NULL,
  `CreateBy` varchar(100) DEFAULT NULL,
  `ModifierDate` datetime DEFAULT NULL,
  `ModifierBy` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_advertisement`
--

INSERT INTO `tb_advertisement` (`id`, `Title`, `Description`, `Image`, `Type`, `Link`, `Meta`, `Hide`, `Position`, `CreateDate`, `CreateBy`, `ModifierDate`, `ModifierBy`) VALUES
(1, 'TechX Flash Sale 3.3\r\n', 'Get up to 30%\r\n', '../Content/images/ads/Adv_1.png\r\n', NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tb_contact`
--

CREATE TABLE `tb_contact` (
  `id` int(11) NOT NULL,
  `Name` varchar(150) DEFAULT NULL,
  `Website` varchar(150) DEFAULT NULL,
  `Email` varchar(150) DEFAULT NULL,
  `Message` varchar(500) DEFAULT NULL,
  `IsRead` tinyint(1) DEFAULT NULL,
  `Meta` varchar(50) DEFAULT NULL,
  `Hide` tinyint(1) DEFAULT NULL,
  `Position` int(11) DEFAULT NULL,
  `CreateDate` datetime DEFAULT NULL,
  `CreateBy` varchar(100) DEFAULT NULL,
  `ModifierDate` datetime DEFAULT NULL,
  `ModifierBy` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tb_deal`
--

CREATE TABLE `tb_deal` (
  `id` int(11) NOT NULL,
  `tiltle` varchar(100) NOT NULL,
  `image` char(100) NOT NULL,
  `createBy` varchar(50) NOT NULL,
  `startTime` date NOT NULL,
  `Hide` tinyint(1) DEFAULT NULL,
  `endTime` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_deal`
--

INSERT INTO `tb_deal` (`id`, `tiltle`, `image`, `createBy`, `startTime`, `Hide`, `endTime`) VALUES
(1, 'Deal buy 1 get 1', '..\\Content\\images\\deal\\deal_2.jpg', 'Admin', '2023-03-03', 1, '2023-03-05');

-- --------------------------------------------------------

--
-- Table structure for table `tb_header`
--

CREATE TABLE `tb_header` (
  `id` int(11) NOT NULL,
  `ads` varchar(1000) DEFAULT NULL,
  `DateCreate` date DEFAULT NULL,
  `Createby` varchar(100) DEFAULT NULL,
  `Link` varchar(100) DEFAULT NULL,
  `EndDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_header`
--

INSERT INTO `tb_header` (`id`, `ads`, `DateCreate`, `Createby`, `Link`, `EndDate`) VALUES
(1, 'Sale 50%', '2022-02-12', 'Admin', NULL, '2022-02-22'),
(2, 'BUY 1 GET 1', '2022-02-22', 'Admin', NULL, '2022-02-21'),
(3, 'Sale 20%', '2022-02-22', 'Admin', NULL, '2022-02-25');

-- --------------------------------------------------------

--
-- Table structure for table `tb_menu`
--

CREATE TABLE `tb_menu` (
  `id` int(11) NOT NULL,
  `Title` varchar(200) DEFAULT NULL,
  `Description` varchar(500) DEFAULT NULL,
  `SeoTitle` varchar(250) DEFAULT NULL,
  `SeoDescription` varchar(500) DEFAULT NULL,
  `SeoKeyword` varchar(250) DEFAULT NULL,
  `Meta` varchar(50) DEFAULT NULL,
  `Hide` tinyint(1) DEFAULT NULL,
  `Position` int(11) DEFAULT NULL,
  `CreateDate` datetime DEFAULT NULL,
  `CreateBy` varchar(100) DEFAULT NULL,
  `ModifierDate` datetime DEFAULT NULL,
  `ModifierBy` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_menu`
--

INSERT INTO `tb_menu` (`id`, `Title`, `Description`, `SeoTitle`, `SeoDescription`, `SeoKeyword`, `Meta`, `Hide`, `Position`, `CreateDate`, `CreateBy`, `ModifierDate`, `ModifierBy`) VALUES
(2, 'HOME', 'Trang chu', ' ', ' ', NULL, 'Home', 1, 1, '2021-02-20 00:00:00', 'Admin', '1900-01-01 00:00:00', ' '),
(3, 'CONTACT', 'Lien He', ' ', ' ', NULL, 'Contact', 1, 1, '2021-02-20 00:00:00', 'Admin', '1900-01-01 00:00:00', ' '),
(4, 'NEWS', 'Tin Tuc', NULL, NULL, NULL, 'News', 1, 1, '2021-02-20 00:00:00', 'Admin', NULL, NULL),
(5, 'FAQ', 'Phan Hoi', NULL, NULL, NULL, 'FAQ', 0, 1, '2022-02-22 00:00:00', 'Admin', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tb_news`
--

CREATE TABLE `tb_news` (
  `id` int(11) NOT NULL,
  `Title` varchar(250) DEFAULT NULL,
  `CategoryId` int(11) DEFAULT NULL,
  `Description` varchar(4000) DEFAULT NULL,
  `Detail` varchar(0) DEFAULT NULL,
  `Image` varchar(500) DEFAULT NULL,
  `SeoTitle` varchar(250) DEFAULT NULL,
  `SeoDesscription` varchar(500) DEFAULT NULL,
  `SeoKeywords` varchar(250) DEFAULT NULL,
  `Meta` varchar(50) DEFAULT NULL,
  `Hide` tinyint(1) DEFAULT NULL,
  `Position` int(11) DEFAULT NULL,
  `CreateDate` datetime DEFAULT NULL,
  `CreateBy` varchar(100) DEFAULT NULL,
  `ModifierDate` datetime DEFAULT NULL,
  `ModifierBy` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_news`
--

INSERT INTO `tb_news` (`id`, `Title`, `CategoryId`, `Description`, `Detail`, `Image`, `SeoTitle`, `SeoDesscription`, `SeoKeywords`, `Meta`, `Hide`, `Position`, `CreateDate`, `CreateBy`, `ModifierDate`, `ModifierBy`) VALUES
(2, 'Cấu hình iPhone 15 còn có gì đáng mong đợi?\r\n', NULL, NULL, NULL, '../Content/images/news/News_1.jpg\r\n', NULL, NULL, NULL, NULL, 1, NULL, '2023-02-25 00:00:00', 'Ngô Tiến Đạt\r\n', NULL, NULL),
(3, 'Đại tiệc đầu tháng Galaxy S21 FE khuyến mãi\r\n', NULL, NULL, NULL, '../Content/images/news/News_2.jpg\r\n', NULL, NULL, NULL, NULL, 1, NULL, '2023-02-27 00:00:00', 'Trần Quang Huy\r\n', NULL, NULL),
(4, '24h công nghệ có gì HOT 1/3\r\n', NULL, NULL, NULL, '../Content/images/news/News_3.jpg\r\n', NULL, NULL, NULL, NULL, 1, NULL, '2023-03-01 00:00:00', 'Trần Quang Huy\r\n', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tb_order`
--

CREATE TABLE `tb_order` (
  `id` int(11) NOT NULL,
  `Code` varchar(50) DEFAULT NULL,
  `CustomerName` varchar(200) DEFAULT NULL,
  `Phone` varchar(15) DEFAULT NULL,
  `Address` varchar(500) DEFAULT NULL,
  `TotalAmount` bigint(20) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `Meta` varchar(50) DEFAULT NULL,
  `Hide` tinyint(1) DEFAULT NULL,
  `Position` int(11) DEFAULT NULL,
  `CreateDate` datetime DEFAULT NULL,
  `CreateBy` varchar(100) DEFAULT NULL,
  `ModifierDate` datetime DEFAULT NULL,
  `ModifierBy` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tb_orderdetail`
--

CREATE TABLE `tb_orderdetail` (
  `id` int(11) NOT NULL,
  `OrderId` int(11) DEFAULT NULL,
  `ProductId` int(11) DEFAULT NULL,
  `Price` bigint(20) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `Meta` varchar(50) DEFAULT NULL,
  `Hide` tinyint(1) DEFAULT NULL,
  `Position` int(11) DEFAULT NULL,
  `CreateDate` datetime DEFAULT NULL,
  `CreateBy` varchar(100) DEFAULT NULL,
  `ModifierDate` datetime DEFAULT NULL,
  `ModifierBy` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tb_product`
--

CREATE TABLE `tb_product` (
  `id` int(11) NOT NULL,
  `Title` varchar(250) DEFAULT NULL,
  `Description` varchar(4000) DEFAULT NULL,
  `Detail` varchar(0) DEFAULT NULL,
  `Image` varchar(500) DEFAULT NULL,
  `Price` decimal(18,2) DEFAULT NULL,
  `PriceSale` decimal(18,2) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `SeoTitle` varchar(250) DEFAULT NULL,
  `SeoDesscription` varchar(500) DEFAULT NULL,
  `SeoKeywords` varchar(250) DEFAULT NULL,
  `Meta` varchar(50) DEFAULT NULL,
  `Hide` tinyint(1) DEFAULT NULL,
  `Position` int(11) DEFAULT NULL,
  `CreateDate` datetime DEFAULT NULL,
  `CreateBy` varchar(100) DEFAULT NULL,
  `ModifierDate` datetime DEFAULT NULL,
  `ModifierBy` varchar(100) DEFAULT NULL,
  `ProductCategory` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_product`
--

INSERT INTO `tb_product` (`id`, `Title`, `Description`, `Detail`, `Image`, `Price`, `PriceSale`, `Quantity`, `SeoTitle`, `SeoDesscription`, `SeoKeywords`, `Meta`, `Hide`, `Position`, `CreateDate`, `CreateBy`, `ModifierDate`, `ModifierBy`, `ProductCategory`) VALUES
(1, 'Điện thoại iPhone 14 Plus 512GB ', 'iPhone 14 Plus 512GB là dòng sản phẩm mới mà Apple cho ra mắt trong năm nay, đây được xem là phiên bản phóng to của iPhone 14 khi máy vẫn giữ được kiểu dáng thiết kế vuông vức thời thượng cùng cụm camera xếp chéo độc đáo ở phần mặt lưng.', NULL, '../Content/images/phone/iPhone-14-plus-thumb-den-600x600.jpg', '28990000.00', '28990000.00', 100, NULL, NULL, NULL, '.phone', 1, NULL, '2023-02-28 00:00:00', NULL, NULL, NULL, 'Phone'),
(2, ' MacBook Pro 14 M1 Pro 2021 8-core CPU', 'MacBook Pro 14 M1 Pro 2021 8-core CPU/16GB/512GB/14-core GPU (MKGR3SA/A) ', NULL, '../Content/images/laptop/macbook-pro-14-m1-pro-2021-8-core-cpu-(33).jpg', '28990000.00', '28990000.00', 100, NULL, NULL, NULL, '.laptop', 1, NULL, '2022-01-28 00:00:00', NULL, NULL, NULL, 'Laptop'),
(3, 'Máy tính bảng iPad Pro M1 11 inch WiFi 2TB (2021)', 'Máy tính bảng iPad Pro M1 11 inch WiFi 2TB (2021)', NULL, '../Content/images/tablet/ipad-pro-m1-11-inch-wifi-2tb-2021-xam-thumb-600x600.jpeg', '44990000.00', '44990000.00', 100, NULL, NULL, NULL, '.tablet', 1, NULL, '2023-02-28 00:00:00', NULL, NULL, NULL, 'Tablet'),
(4, 'Tai nghe Bluetooth AirPods Pro MagSafe Charge Apple MLWK3', 'Tai nghe Bluetooth AirPods Pro MagSafe Charge Apple MLWK3', NULL, '../Content/images/phukien/bluetooth-airpods-pro-magsafe-charge-apple-mlwk3-thumb-600x600.jpeg', '4790000.00', '4790000.00', 100, NULL, NULL, NULL, '.accessories', 1, NULL, '2023-03-01 00:00:00', NULL, NULL, NULL, 'Phụ kiện'),
(5, 'Điện thoại iPhone 14 Pro 128GB', 'Điện thoại iPhone 14 Pro 128GB', NULL, '../Content/images/phone/iphone-14-pro-tim-thumb-600x600.jpg', '44990000.00', '44990000.00', 100, NULL, NULL, NULL, '.phone', 1, NULL, '2023-02-28 00:00:00', NULL, NULL, NULL, 'Phone'),
(6, 'Apple MacBook Air M1 2020', 'Apple MacBook Air M1 2020', NULL, '../Content/images/laptop/macbook-air-m1-2020-gold-600x600.jpg', '27990000.00', '21990000.00', 100, NULL, NULL, NULL, '.laptop', 1, NULL, '2023-03-01 00:00:00', NULL, NULL, NULL, 'Laptop'),
(7, 'Điện thoại iPhone 11 64GB\r\n', 'Điện thoại iPhone 11 64GB\r\n', NULL, '../Content/images/phone/iphone-11-trang-600x600.jpg\r\n', '14990000.00', '12490000.00', 100, NULL, NULL, NULL, '.phone', 1, NULL, '2023-02-18 00:00:00', NULL, NULL, NULL, 'Phone'),
(10, 'Điện thoại iPhone 13 128GB\r\n', 'Điện thoại iPhone 13 128GB\r\n', NULL, '../Content/images/phone/iphone-13-starlight-1-600x600.jpg\r\n', '24990000.00', '20499000.00', 100, NULL, NULL, NULL, '.phone', 1, NULL, '2023-02-05 00:00:00', NULL, NULL, NULL, 'Phone'),
(11, 'Điện thoại iPhone 13 Pro Max 1TB\r\n', 'Điện thoại iPhone 13 Pro Max 1TB\r\n', NULL, '../Content/images/phone/iphone-13-pro-max-graphite-600x600.jpg\r\n../Content/images/laptop/apple-macbook-air-m2-2022-16gb-600x600.jpg\r\n', '35490000.00', '31490000.00', 100, NULL, NULL, NULL, '.phone', 1, NULL, '2022-03-18 00:00:00', NULL, NULL, NULL, 'Phone'),
(12, 'Laptop Apple MacBook Air M2 2022\r\n', 'Laptop Apple MacBook Air M2 2022\r\n', NULL, '../Content/images/laptop/apple-macbook-air-m2-2022-16gb-600x600.jpg\r\n', '46990000.00', '39990000.00', 100, NULL, NULL, NULL, '.laptop', 1, NULL, '2023-01-18 00:00:00', NULL, NULL, NULL, 'Laptop'),
(13, 'Laptop Apple MacBook Air M1 2020\r\n', 'Laptop Apple MacBook Air M1 2020\r\n', NULL, '../Content/images/laptop/apple-macbook-air-m1-2020-8-core-gpu-xam-01-1-600x600.jpg\r\n', '39490000.00', '31590000.00', 100, NULL, NULL, NULL, '.laptop', 1, NULL, '2023-02-01 00:00:00', NULL, NULL, NULL, 'Laptop'),
(14, 'Cáp Type C - Lightning 1m Apple MM0A3 Trắng\r\n', 'Cáp Type C - Lightning 1m Apple MM0A3 Trắng\r\n', NULL, '../Content/images/phukien/cap-type-c-lightning-1m-apple-mm0a3-trang-thumb-1-600x600.jpeg\r\n', '590000.00', '590000.00', 100, NULL, NULL, NULL, '.accessories', 1, NULL, '2023-02-07 00:00:00', NULL, NULL, NULL, 'Phụ kiện'),
(15, 'Adapter Sạc Type C 20W dùng cho iPhone/iPad Apple MHJE3 Trắng\r\n', 'Adapter Sạc Type C 20W dùng cho iPhone/iPad Apple MHJE3 Trắng\r\n', NULL, '../Content/images/phukien/adapter-sac-type-c-20w-cho-iphone-ipad-apple-mhje3-avatar-1-1-600x600.jpeg\r\n', '690000.00', '69000.00', 100, NULL, NULL, NULL, '.accessories', 1, NULL, '2022-12-18 00:00:00', NULL, NULL, NULL, 'Phụ kiện'),
(16, 'Bàn phím Magic Keyboard Apple MK2A3 Trắng\r\n', 'Bàn phím Magic Keyboard Apple MK2A3 Trắng\r\n', NULL, '../Content/images/phukien/\r\nban-phim-magic-keyboard-apple-mk2a3-thumb1-600x600.jpg', '2230000.00', '20499000.00', 100, NULL, NULL, NULL, '.accessories', 1, NULL, '2023-02-13 00:00:00', NULL, NULL, NULL, 'Phụ kiện');

-- --------------------------------------------------------

--
-- Table structure for table `tb_productcategory`
--

CREATE TABLE `tb_productcategory` (
  `id` int(11) NOT NULL,
  `Title` varchar(200) DEFAULT NULL,
  `Description` varchar(500) DEFAULT NULL,
  `Icon` varchar(500) DEFAULT NULL,
  `Meta` varchar(50) DEFAULT NULL,
  `Hide` tinyint(1) DEFAULT NULL,
  `Position` int(11) DEFAULT NULL,
  `CreateDate` datetime DEFAULT NULL,
  `CreateBy` varchar(100) DEFAULT NULL,
  `ModifierDate` datetime DEFAULT NULL,
  `ModifierBy` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_productcategory`
--

INSERT INTO `tb_productcategory` (`id`, `Title`, `Description`, `Icon`, `Meta`, `Hide`, `Position`, `CreateDate`, `CreateBy`, `ModifierDate`, `ModifierBy`) VALUES
(1, 'Phone', 'Trang hiển thị list điện thoại', '../Content/images/iconCategry/smartphone.png', '.phone', 1, NULL, '2023-02-28 00:00:00', 'Admin', NULL, NULL),
(2, 'Laptop', 'Trang hiển thị laptop', '../Content/images/iconCategry/laptop.png', '.laptop', 1, NULL, '2023-02-28 00:00:00', 'Admin', NULL, NULL),
(3, 'Tablet', 'Trang hiện thị Tablet', '../Content/images/iconCategry/tablet.png', '.tablet', 1, NULL, '2023-02-28 00:00:00', 'Admin', NULL, NULL),
(4, 'Phụ kiện', 'Trang hiẻn thị phụ kiện', '../Content/images/iconCategry/earphone.png', '.accessories', 1, NULL, '2023-02-28 00:00:00', 'Admin', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tb_subcribe`
--

CREATE TABLE `tb_subcribe` (
  `id` int(11) NOT NULL,
  `Email` varchar(150) DEFAULT NULL,
  `CreateDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tb_systemsetting`
--

CREATE TABLE `tb_systemsetting` (
  `SettingKey` varchar(50) NOT NULL,
  `SettingValue` varchar(0) DEFAULT NULL,
  `SettingDescription` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_advertisement`
--
ALTER TABLE `tb_advertisement`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_contact`
--
ALTER TABLE `tb_contact`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_deal`
--
ALTER TABLE `tb_deal`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_header`
--
ALTER TABLE `tb_header`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_menu`
--
ALTER TABLE `tb_menu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_news`
--
ALTER TABLE `tb_news`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_order`
--
ALTER TABLE `tb_order`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_orderdetail`
--
ALTER TABLE `tb_orderdetail`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_product`
--
ALTER TABLE `tb_product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_productcategory`
--
ALTER TABLE `tb_productcategory`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_subcribe`
--
ALTER TABLE `tb_subcribe`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_systemsetting`
--
ALTER TABLE `tb_systemsetting`
  ADD PRIMARY KEY (`SettingKey`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
