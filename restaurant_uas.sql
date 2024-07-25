-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 25, 2024 at 05:50 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `restaurant_uas`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `no_telp` varchar(30) NOT NULL,
  `agama` varchar(30) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `username`, `password`, `gender`, `email`, `no_telp`, `agama`, `alamat`) VALUES
(1, 'admin', 'ac9689e2272427085e35b9d3e3e8bed88cb3434828b43b86fc0596cad4c6e270', 'Laki-laki', 'admin@resto.com', '081355249826', 'Islam', 'Jl. Kemerdekaan No. 45'),
(2, 'agung', '933594b02025150a9eef39600171e55372e01e3e92a9c4ffcebae896eddf4fbf', 'Perempuan', 'agung@resto.com', '082355487615', 'Islam', ''),
(3, 'yuda', '616c01cf3450e77b4d5d2aed9464c31da007242cbe07ece09e68a21e15e659ab', 'Perempuan', 'yuda@resto.com', '123456789', 'Islam', '');

-- --------------------------------------------------------

--
-- Table structure for table `tb_hitung_jual`
--

CREATE TABLE `tb_hitung_jual` (
  `id_hitung` int(11) NOT NULL,
  `nama_makanan` varchar(50) NOT NULL,
  `harga_satuan` int(11) NOT NULL,
  `total_harga` int(11) NOT NULL,
  `jumlah_jual` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tb_penjualan`
--

CREATE TABLE `tb_penjualan` (
  `id_penjualan` int(11) NOT NULL,
  `no_faktur` varchar(11) NOT NULL,
  `nama_makanan` varchar(50) NOT NULL,
  `harga_satuan` int(11) NOT NULL,
  `jumlah_makanan` int(11) NOT NULL,
  `total_harga` int(11) NOT NULL,
  `bayar` int(11) NOT NULL,
  `kembalian` int(11) NOT NULL,
  `tanggal_penjualan` date NOT NULL,
  `no_meja_makan` int(11) NOT NULL,
  `nama_pelanggan` varchar(50) NOT NULL,
  `pajak` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tb_penjualan`
--

INSERT INTO `tb_penjualan` (`id_penjualan`, `no_faktur`, `nama_makanan`, `harga_satuan`, `jumlah_makanan`, `total_harga`, `bayar`, `kembalian`, `tanggal_penjualan`, `no_meja_makan`, `nama_pelanggan`, `pajak`) VALUES
(1, 'F0001', 'Ikan Gurame', 80000, 2, 160000, 250000, 8000, '2024-07-21', 20, 'Agus Wicaksono', 22000),
(2, 'F0001', 'Ayam Bakar', 60000, 1, 60000, 250000, 8000, '2024-07-21', 20, 'Agus Wicaksono', 22000),
(3, 'F0002', 'Dimsum', 15000, 4, 60000, 140000, 8000, '2024-07-21', 10, 'Cita Lestari', 12000),
(4, 'F0002', 'Kimchi', 15000, 4, 60000, 140000, 8000, '2024-07-21', 10, 'Cita Lestari', 12000),
(5, 'F0003', 'Ramen', 42000, 2, 84000, 160000, 1600, '2024-07-21', 35, 'Asep Gandar', 14400),
(6, 'F0003', 'Croissant', 30000, 2, 60000, 160000, 1600, '2024-07-21', 35, 'Asep Gandar', 14400),
(7, 'F0004', 'Ikan Gurame', 80000, 2, 160000, 400000, 9500, '2024-07-22', 40, 'Mugi Jaya', 35500),
(8, 'F0004', 'Ayam Bakar', 60000, 2, 120000, 400000, 9500, '2024-07-22', 40, 'Mugi Jaya', 35500),
(9, 'F0004', 'Croissant', 30000, 1, 30000, 400000, 9500, '2024-07-22', 40, 'Mugi Jaya', 35500),
(10, 'F0004', 'Dimsum', 15000, 3, 45000, 400000, 9500, '2024-07-22', 40, 'Mugi Jaya', 35500);

-- --------------------------------------------------------

--
-- Table structure for table `tb_penjualan2`
--

CREATE TABLE `tb_penjualan2` (
  `id_penjualan` int(11) NOT NULL,
  `no_faktur` varchar(50) NOT NULL,
  `nama_makanan` varchar(50) NOT NULL,
  `harga_satuan` int(11) NOT NULL,
  `jumlah_makanan` int(11) NOT NULL,
  `total_harga` int(11) NOT NULL,
  `bayar` int(11) NOT NULL,
  `kembalian` int(11) NOT NULL,
  `tanggal_penjualan` date NOT NULL,
  `nama_pelanggan` varchar(50) NOT NULL,
  `fee_packaging` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tb_penjualan2`
--

INSERT INTO `tb_penjualan2` (`id_penjualan`, `no_faktur`, `nama_makanan`, `harga_satuan`, `jumlah_makanan`, `total_harga`, `bayar`, `kembalian`, `tanggal_penjualan`, `nama_pelanggan`, `fee_packaging`) VALUES
(1, 'F0001', 'Matcha Latte', 25000, 1, 25000, 85000, 2500, '2024-07-21', 'Dinda Asri', 7500),
(2, 'F0001', 'Infused Water', 25000, 2, 50000, 85000, 2500, '2024-07-21', 'Dinda Asri', 7500),
(3, 'F0002', 'Matcha Latte', 25000, 1, 25000, 100000, 39500, '2024-07-21', 'Reza Arap', 5500),
(4, 'F0002', 'Croissant', 30000, 1, 30000, 100000, 39500, '2024-07-21', 'Reza Arap', 5500),
(5, 'F0003', 'Americano', 20000, 1, 20000, 50000, 3650, '2024-07-22', 'Syukur', 1350),
(6, 'F0003', 'Matcha Latte', 25000, 1, 25000, 50000, 3650, '2024-07-22', 'Syukur', 1350),
(7, 'F0004', 'Americano', 20000, 1, 20000, 75000, 2900, '2024-07-22', 'Siska Amalia', 2100),
(8, 'F0004', 'Matcha Latte', 25000, 1, 25000, 75000, 2900, '2024-07-22', 'Siska Amalia', 2100),
(9, 'F0004', 'Infused Water', 25000, 1, 25000, 75000, 2900, '2024-07-22', 'Siska Amalia', 2100),
(10, 'F0005', 'Matcha Latte', 25000, 1, 25000, 100000, 17600, '2024-07-22', 'Sinta Sarah Ningsih', 2400),
(11, 'F0005', 'Infused Water', 25000, 1, 25000, 100000, 17600, '2024-07-22', 'Sinta Sarah Ningsih', 2400),
(12, 'F0005', 'Dimsum', 15000, 2, 30000, 100000, 17600, '2024-07-22', 'Sinta Sarah Ningsih', 2400),
(13, 'F0006', 'Americano', 20000, 3, 60000, 150000, 41850, '2024-07-22', 'Bagus Jaya Mukti', 3150),
(14, 'F0006', 'Kimchi', 15000, 3, 45000, 150000, 41850, '2024-07-22', 'Bagus Jaya Mukti', 3150),
(15, 'F0007', 'Infused Water', 25000, 1, 25000, 50000, 8800, '2024-07-22', 'Agung', 1200),
(16, 'F0007', 'Dimsum', 15000, 1, 15000, 50000, 8800, '2024-07-22', 'Agung', 1200),
(17, 'F0008', 'Matcha Latte', 25000, 2, 50000, 60000, 8500, '2024-07-22', 'Nia Agustina', 1500);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_hitung_jual`
--
ALTER TABLE `tb_hitung_jual`
  ADD PRIMARY KEY (`id_hitung`);

--
-- Indexes for table `tb_penjualan`
--
ALTER TABLE `tb_penjualan`
  ADD PRIMARY KEY (`id_penjualan`);

--
-- Indexes for table `tb_penjualan2`
--
ALTER TABLE `tb_penjualan2`
  ADD PRIMARY KEY (`id_penjualan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tb_hitung_jual`
--
ALTER TABLE `tb_hitung_jual`
  MODIFY `id_hitung` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tb_penjualan`
--
ALTER TABLE `tb_penjualan`
  MODIFY `id_penjualan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `tb_penjualan2`
--
ALTER TABLE `tb_penjualan2`
  MODIFY `id_penjualan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
