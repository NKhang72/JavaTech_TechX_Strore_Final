-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 17, 2023 at 01:03 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `techxstore`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'Phone'),
(2, 'Laptop'),
(3, 'Tablet'),
(4, 'Accessories');

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL,
  `hide` bit(1) DEFAULT NULL,
  `meta` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`id`, `hide`, `meta`, `name`) VALUES
(1, b'1', 'index', 'Home'),
(2, b'1', 'Phone', 'Phone'),
(3, b'1', 'Tablet', 'Tablet'),
(4, b'1', 'Laptop', 'Laptop'),
(5, b'1', 'Accessories', 'Accessories'),
(6, b'0', 'contact', 'Contact'),
(7, b'0', 'about', 'About');

-- --------------------------------------------------------

--
-- Table structure for table `oder`
--

CREATE TABLE `oder` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `create_day` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `oderdetails`
--

CREATE TABLE `oderdetails` (
  `id` bigint(20) NOT NULL,
  `price` int(11) NOT NULL,
  `quanity` int(11) DEFAULT NULL,
  `oderid` bigint(20) DEFAULT NULL,
  `productid` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `color` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `price` int(11) DEFAULT NULL,
  `quatity` varchar(255) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `categoryid` bigint(20) DEFAULT NULL,
  `image1` varchar(255) DEFAULT NULL,
  `image2` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `back_camera` int(11) DEFAULT NULL,
  `battery` int(11) DEFAULT NULL,
  `front_camera` int(11) DEFAULT NULL,
  `os` varchar(255) DEFAULT NULL,
  `ram` int(11) DEFAULT NULL,
  `rom` int(11) DEFAULT NULL,
  `screen` varchar(255) DEFAULT NULL,
  `screen_type` varchar(255) DEFAULT NULL,
  `cpu` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `color`, `image`, `name`, `price`, `quatity`, `size`, `year`, `categoryid`, `image1`, `image2`, `description`, `back_camera`, `battery`, `front_camera`, `os`, `ram`, `rom`, `screen`, `screen_type`, `cpu`) VALUES
(7, 'White', '637824187249578799_ipad-air-2022-wifi-dd.png', 'iPad Air 5 2022 10.9 inch M1 WiFi 64GB', 14190000, '100', 0, 2019, 3, '637824187249578799_ipad-air-2022-wifi-dd.png', '637824187249578799_ipad-air-2022-wifi-dd.png', 'iPad Air 5 M1 Wifi 64 GB đã được công bố tại sự kiện Peek Performance diễn ra hôm 9/3 (theo giờ Việt Nam). Năm nay Apple đã có những thay đổi lớn về cả hiệu năng và bổ sung màu sắc mới cho thiết bị.', 12, 7587, 12, 'iOS', 8, 64, '1640 x 2360', 'Retina IPS LCD', '\r\nApple M1 8 nhân'),
(3, 'Gold', 'apple-watch-ultra-cao-su-trang-thumbnew-600x600.jpg', 'Đồng hồ thông minh Apple Watch Series 7 GPS 41mm Gold', 9990000, '1000', 0, 2323, 4, 'apple-watch-ultra-cao-su-trang-thumbnew-600x600.jpg', 'apple-watch-ultra-cao-su-trang-thumbnew-600x600.jpg', 'sfasfsd', 0, 265, 0, 'WatchOS', 0, 32, 'OLED', '430 x 352', '\r\nApple S7'),
(6, 'White', '638138668784040702_iphone-14-dd.png', 'Điện thoại iPhone 14 512GB ', 26990000, '1000', 0, 2023, 1, '638138668784040702_iphone-14-dd.png', '638138668784040702_iphone-14-dd.png', 'asdsadsad', 12, 3421, 48, 'iOS', 6, 512, '1920 x 2945', 'Retina IPS LCD', 'Apple A14 Bionic'),
(8, 'White', '638138668784040702_iphone-14-dd.png', 'MacBook Pro 14 2023 M2 Pro 10CPU 16GPU 16GB/512GB ', 49290000, '12', 0, 2023, 2, '637824187249578799_ipad-air-2022-wifi-dd.png', '638096308244034700_macbook-pro-14-2023-m2-pro-10cpu-16gpu-bac-dd.png', 'asdasdas', 5, 24465, 0, 'masOS', 16, 512, 'OLED', '1640 x 2360', 'Apple M1 Pro'),
(11, 'Black', '637901915720184032_macbook-air-m2-2022-den-dd.png', 'MacBook Air M2 2022 13 inch 8CPU 8GPU 8GB 256GB', 27990000, '10', NULL, 2023, 2, '6379399296110578.png', 'fff.png', 'Không chỉ khơi gợi cảm hứng qua việc cách tân thiết kế, MacBook Air M2 2022 còn chứa đựng nguồn sức mạnh lớn lao với chip M2 siêu mạnh, thời lượng pin chạm  ngưỡng 18 giờ, màn hình Liquid Retina tuyệt đẹp và hệ thống camera kết hợp cùng âm thanh tân tiến.', 0, 0, 5, 'masOS', 8, 256, '2560 x 1644', 'Liquid Retina', 'Apple M2');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `email` varchar(45) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `password` varchar(64) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `first_name`, `last_name`, `password`) VALUES
(1, 'khang@gmail.com', 'Khang', 'Tran', '$2a$10$YJh4oMCp7auZv.yA8mL7qOcZr1rIs.HqPh2bmuFuhLDXnBVT/CkKm');

-- --------------------------------------------------------

--
-- Table structure for table `users_roles`
--

CREATE TABLE `users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users_roles`
--

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
(1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `oder`
--
ALTER TABLE `oder`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `oderdetails`
--
ALTER TABLE `oderdetails`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKplfna9wa1uulfdku9mnh02kgr` (`oderid`),
  ADD KEY `FK790jiaan6vw6ury2ufjbauhrl` (`productid`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4ort9abhumpx4t2mlngljr1vi` (`categoryid`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  ADD UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- Indexes for table `users_roles`
--
ALTER TABLE `users_roles`
  ADD KEY `FKt4v0rrweyk393bdgt107vdx0x` (`role_id`),
  ADD KEY `FK2o0jvgh89lemvvo17cbqvdxaa` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `oder`
--
ALTER TABLE `oder`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `oderdetails`
--
ALTER TABLE `oderdetails`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
