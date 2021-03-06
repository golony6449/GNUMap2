-- phpMyAdmin SQL Dump
-- version 4.7.8
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- 생성 시간: 18-03-26 10:35
-- 서버 버전: 5.7.21
-- PHP 버전: 7.0.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 데이터베이스: `gnu_meal`
--

-- --------------------------------------------------------

--
-- 테이블 구조 `map`
--

CREATE TABLE `map` (
  `ID` int(11) NOT NULL,
  `keyword` text NOT NULL,
  `X` float(9,6) NOT NULL,
  `Y` float(9,6) NOT NULL,
  `img` text
) ;

--
-- 테이블의 덤프 데이터 `map`
--

INSERT INTO `map` (`ID`, `keyword`, `X`, `Y`, `img`) VALUES
(1, '1동', 35.153824, 128.101669, 'https://c1.staticflickr.com/3/2934/33291604824_d87e417144_s.jpg'),
(2, '대학본부', 35.153824, 128.101669, 'https://c1.staticflickr.com/3/2934/33291604824_d87e417144_s.jpg'),
(3, '2동', 35.153267, 128.099472, 'https://c1.staticflickr.com/3/2924/33783651010_107848a23a_s.jpg'),
(4, '도서관', 35.153267, 128.099472, 'https://c1.staticflickr.com/3/2924/33783651010_107848a23a_s.jpg'),
(5, '3동', 35.153618, 128.097382, 'https://c1.staticflickr.com/3/2936/33357121953_1bc50bcecd_s.jpg'),
(6, '학생회관', 35.153618, 128.097382, 'https://c1.staticflickr.com/3/2936/33357121953_1bc50bcecd_s.jpg'),
(7, '인재개발원', 35.153618, 128.097382, 'https://c1.staticflickr.com/3/2936/33357121953_1bc50bcecd_s.jpg'),
(8, '4동', 35.153698, 128.096115, 'https://c1.staticflickr.com/3/2932/34093663106_fb08202152_s.jpg'),
(9, '학술정보관', 35.153698, 128.096115, 'https://c1.staticflickr.com/3/2932/34093663106_fb08202152_s.jpg'),
(10, '교육정보전산원', 35.153698, 128.096115, 'https://c1.staticflickr.com/3/2932/34093663106_fb08202152_s.jpg'),
(11, '5동', 35.155407, 128.102982, 'https://c1.staticflickr.com/3/2828/34168395735_5f123f8900_s.jpg'),
(12, '체육관', 35.155407, 128.102982, 'https://c1.staticflickr.com/3/2828/34168395735_5f123f8900_s.jpg'),
(13, '21동', 35.156185, 128.103378, 'http://www.gnu.ac.kr/img/01/c1_2_3_2_img02.gif'),
(14, 'GNU어린이집', 35.156185, 128.103378, 'http://www.gnu.ac.kr/img/01/c1_2_3_2_img02.gif'),
(15, '24동', 35.151779, 128.099075, 'https://c1.staticflickr.com/3/2834/34010971712_8c9881046d_s.jpg'),
(16, '교양학관', 35.151779, 128.099075, 'https://c1.staticflickr.com/3/2834/34010971712_8c9881046d_s.jpg'),
(17, '입학본부', 35.151779, 128.099075, 'https://c1.staticflickr.com/3/2834/34010971712_8c9881046d_s.jpg'),
(18, '25동', 35.151012, 128.100449, 'https://c1.staticflickr.com/3/2840/33783776550_2be6f2a26e_s.jpg'),
(19, '창업보육센터', 35.151012, 128.100449, 'https://c1.staticflickr.com/3/2840/33783776550_2be6f2a26e_s.jpg'),
(20, '27동', 35.153217, 128.094711, 'https://c1.staticflickr.com/3/2918/33326099584_fe7726a018_s.jpg'),
(21, '공동실험실습관', 35.153217, 128.094711, 'https://c1.staticflickr.com/3/2918/33326099584_fe7726a018_s.jpg'),
(22, '28동', 35.153858, 128.095474, 'https://c1.staticflickr.com/3/2855/34127918056_8e0d2e44c0_s.jpg'),
(23, '산학협력센터', 35.153858, 128.095474, 'https://c1.staticflickr.com/3/2855/34127918056_8e0d2e44c0_s.jpg'),
(24, '약학대학', 35.153858, 128.095474, 'https://c1.staticflickr.com/3/2855/34127918056_8e0d2e44c0_s.jpg'),
(25, '29동', 35.154099, 128.098892, 'https://c1.staticflickr.com/3/2806/33783910800_c21ec5ff65_s.jpg'),
(26, '국제어학원', 35.154099, 128.098892, 'https://c1.staticflickr.com/3/2806/33783910800_c21ec5ff65_s.jpg'),
(27, '30동', 35.154488, 128.098495, 'https://c1.staticflickr.com/3/2827/34127968986_8f7ba63131_s.jpg'),
(28, '컴퓨터과학관', 35.154488, 128.098495, 'https://c1.staticflickr.com/3/2827/34127968986_8f7ba63131_s.jpg'),
(29, '31동', 35.156239, 128.099945, 'https://c1.staticflickr.com/3/2948/34168641435_c20891e134_s.jpg'),
(30, '남명학관', 35.156239, 128.099945, 'https://c1.staticflickr.com/3/2948/34168641435_c20891e134_s.jpg'),
(31, '32동', 35.157509, 128.092484, 'https://c1.staticflickr.com/3/2890/33357404593_6a82bc7804_s.jpg'),
(32, '학군단', 35.157509, 128.092484, 'https://c1.staticflickr.com/3/2890/33357404593_6a82bc7804_s.jpg'),
(33, '42동', 35.152027, 128.102890, 'https://c1.staticflickr.com/3/2926/34130107836_9b60e7732f_s.jpg'),
(34, '야외공연장', 35.152027, 128.102890, 'https://c1.staticflickr.com/3/2926/34130107836_9b60e7732f_s.jpg'),
(35, '43동', 35.154736, 128.104446, 'https://c1.staticflickr.com/3/2838/34173485355_9be888de77_s.jpg'),
(36, '대운동장', 35.154736, 128.104446, 'https://c1.staticflickr.com/3/2838/34173485355_9be888de77_s.jpg'),
(37, '44동', 35.150707, 128.099091, 'https://c1.staticflickr.com/3/2947/34013466502_bc40fd886b_s.jpg'),
(38, '파워플랜트', 35.150707, 128.099091, 'https://c1.staticflickr.com/3/2947/34013466502_bc40fd886b_s.jpg'),
(39, '49동', 35.156551, 128.102661, 'http://www.gnu.ac.kr/img/01/c1_2_3_2_img02.gif'),
(40, '테니스장', 35.156551, 128.102661, 'http://www.gnu.ac.kr/img/01/c1_2_3_2_img02.gif'),
(41, '68동', 35.157661, 128.099197, 'https://c1.staticflickr.com/3/2866/34016177172_579e41057e_s.jpg'),
(42, '게스트하우스', 35.157661, 128.099197, 'https://c1.staticflickr.com/3/2866/34016177172_579e41057e_s.jpg'),
(43, '69동', 35.157841, 128.100983, 'https://c1.staticflickr.com/3/2905/34042606251_a9239b6af0_s.jpg'),
(44, 'EnglishVillage', 35.157841, 128.100983, 'https://c1.staticflickr.com/3/2905/34042606251_a9239b6af0_s.jpg'),
(45, '영어캠프강의동', 35.157841, 128.100983, 'https://c1.staticflickr.com/3/2905/34042606251_a9239b6af0_s.jpg'),
(46, '70동', 35.158104, 128.098785, 'https://c1.staticflickr.com/3/2842/34042672641_2e28d5a03b_s.jpg'),
(47, 'LG개척관', 35.158104, 128.098785, 'https://c1.staticflickr.com/3/2842/34042672641_2e28d5a03b_s.jpg'),
(48, '81동', 35.158215, 128.097672, 'http://www.gnu.ac.kr/img/01/c1_2_3_2_img02.gif'),
(49, '부설중학교', 35.158215, 128.097672, 'http://www.gnu.ac.kr/img/01/c1_2_3_2_img02.gif'),
(50, '82동', 35.159073, 128.096573, 'http://www.gnu.ac.kr/img/01/c1_2_3_2_img02.gif'),
(51, '부설고등학교', 35.159073, 128.096573, 'http://www.gnu.ac.kr/img/01/c1_2_3_2_img02.gif'),
(52, '101동', 35.155594, 128.100159, 'https://c1.staticflickr.com/3/2868/34038021291_49916da04f_s.jpg'),
(53, '인문1호관', 35.155594, 128.100159, 'https://c1.staticflickr.com/3/2868/34038021291_49916da04f_s.jpg'),
(54, '인문대학', 35.155594, 128.100159, 'https://c1.staticflickr.com/3/2868/34038021291_49916da04f_s.jpg'),
(55, '102동', 35.155083, 128.099747, 'https://c1.staticflickr.com/3/2868/34038021291_49916da04f_s.jpg'),
(56, '인문2호관', 35.155083, 128.099747, 'https://c1.staticflickr.com/3/2868/34038021291_49916da04f_s.jpg'),
(58, '11동', 35.155476, 128.102158, 'http://www.gnu.ac.kr/img/01/c1_2_3_2_img02.gif'),
(59, '박물관', 35.155476, 128.102158, 'http://www.gnu.ac.kr/img/01/c1_2_3_2_img02.gif'),
(60, '고문헌도서관', 35.155476, 128.102158, 'http://www.gnu.ac.kr/img/01/c1_2_3_2_img02.gif'),
(61, '151동', 35.154713, 128.100372, 'https://c1.staticflickr.com/3/2867/33786155500_7ce685b704_s.jpg'),
(62, '사회과학관', 35.154713, 128.100372, 'https://c1.staticflickr.com/3/2867/33786155500_7ce685b704_s.jpg'),
(63, '사회과학대학', 35.154713, 128.100372, 'https://c1.staticflickr.com/3/2867/33786155500_7ce685b704_s.jpg'),
(64, '201동', 35.153969, 128.099792, 'http://www.gnu.ac.kr/img/01/c1_2_3_2_img02.gif'),
(65, '경영학관', 35.153969, 128.099792, 'http://www.gnu.ac.kr/img/01/c1_2_3_2_img02.gif'),
(66, '경영대학', 35.153969, 128.099792, 'http://www.gnu.ac.kr/img/01/c1_2_3_2_img02.gif'),
(67, '251동', 35.154373, 128.099899, 'https://c1.staticflickr.com/3/2869/34169371155_d23e36d3ba_s.jpg'),
(68, '법학관', 35.154373, 128.099899, 'https://c1.staticflickr.com/3/2869/34169371155_d23e36d3ba_s.jpg'),
(69, '법과대학', 35.154373, 128.099899, 'https://c1.staticflickr.com/3/2869/34169371155_d23e36d3ba_s.jpg'),
(70, '252동', 35.154278, 128.100632, 'http://www.gnu.ac.kr/img/01/c1_2_3_2_img02.gif'),
(71, '대경학술관', 35.154278, 128.100632, 'http://www.gnu.ac.kr/img/01/c1_2_3_2_img02.gif'),
(72, '301동', 35.154404, 128.097412, 'https://c1.staticflickr.com/3/2942/34169404905_aa0d7506ea_s.jpg'),
(73, '교육1호관', 35.154404, 128.097412, 'https://c1.staticflickr.com/3/2942/34169404905_aa0d7506ea_s.jpg'),
(74, '사범대학', 35.154404, 128.097412, 'https://c1.staticflickr.com/3/2942/34169404905_aa0d7506ea_s.jpg'),
(75, '302동', 35.154854, 128.097458, 'https://c1.staticflickr.com/3/2942/34169404905_aa0d7506ea_s.jpg'),
(76, '교육2호관', 35.154854, 128.097458, 'https://c1.staticflickr.com/3/2942/34169404905_aa0d7506ea_s.jpg'),
(77, '사범대학', 35.154854, 128.097458, 'https://c1.staticflickr.com/3/2942/34169404905_aa0d7506ea_s.jpg'),
(78, '303동', 35.154881, 128.099274, 'http://www.gnu.ac.kr/img/01/c1_2_3_2_img02.gif'),
(79, '교육문화센터', 35.154881, 128.099274, 'http://www.gnu.ac.kr/img/01/c1_2_3_2_img02.gif'),
(80, '평생교육원', 35.154881, 128.099274, 'http://www.gnu.ac.kr/img/01/c1_2_3_2_img02.gif'),
(81, '304동', 35.155998, 128.101166, 'https://c1.staticflickr.com/3/2827/34128098356_4cb6609135_s.jpg'),
(82, '예술관', 35.155998, 128.101166, 'https://c1.staticflickr.com/3/2827/34128098356_4cb6609135_s.jpg'),
(83, '351동', 35.155201, 128.095535, 'https://c1.staticflickr.com/3/2810/34037966071_a2bbc04fcc_s.jpg'),
(84, '과학1호관', 35.155201, 128.095535, 'https://c1.staticflickr.com/3/2810/34037966071_a2bbc04fcc_s.jpg'),
(86, '352동', 35.155437, 128.096283, 'https://c1.staticflickr.com/3/2810/34037966071_a2bbc04fcc_s.jpg'),
(87, '과학2호관', 35.155437, 128.096283, 'https://c1.staticflickr.com/3/2810/34037966071_a2bbc04fcc_s.jpg'),
(89, '353동', 35.155037, 128.098572, 'https://c1.staticflickr.com/3/2810/34037966071_a2bbc04fcc_s.jpg'),
(90, '과학3호관', 35.155037, 128.098572, 'https://c1.staticflickr.com/3/2810/34037966071_a2bbc04fcc_s.jpg'),
(92, '354동', 35.156105, 128.096893, 'https://c1.staticflickr.com/3/2810/34037966071_a2bbc04fcc_s.jpg'),
(93, '과학4호관', 35.156105, 128.096893, 'https://c1.staticflickr.com/3/2810/34037966071_a2bbc04fcc_s.jpg'),
(95, '401동', 35.154861, 128.093903, 'https://c1.staticflickr.com/3/2928/33784231190_024f661ed4_s.jpg'),
(96, '공학1호관', 35.154861, 128.093903, 'https://c1.staticflickr.com/3/2928/33784231190_024f661ed4_s.jpg'),
(97, '공과대학', 35.154861, 128.093903, 'https://c1.staticflickr.com/3/2928/33784231190_024f661ed4_s.jpg'),
(98, '402동', 35.155407, 128.093735, 'https://c1.staticflickr.com/3/2928/33784231190_024f661ed4_s.jpg'),
(99, '공학2호관', 35.155407, 128.093735, 'https://c1.staticflickr.com/3/2928/33784231190_024f661ed4_s.jpg'),
(101, '403동', 35.155785, 128.093719, 'https://c1.staticflickr.com/3/2928/33784231190_024f661ed4_s.jpg'),
(102, '공학3호관', 35.155785, 128.093719, 'https://c1.staticflickr.com/3/2928/33784231190_024f661ed4_s.jpg'),
(104, '404동', 35.155796, 128.094635, 'https://c1.staticflickr.com/3/2928/33784231190_024f661ed4_s.jpg'),
(105, '공학4호관', 35.155796, 128.094635, 'https://c1.staticflickr.com/3/2928/33784231190_024f661ed4_s.jpg'),
(107, '405동', 35.155228, 128.094727, 'https://c1.staticflickr.com/3/2928/33784231190_024f661ed4_s.jpg'),
(108, '공학5호관', 35.155228, 128.094727, 'https://c1.staticflickr.com/3/2928/33784231190_024f661ed4_s.jpg'),
(110, '406동', 35.154251, 128.094223, 'https://c1.staticflickr.com/3/2928/33784231190_024f661ed4_s.jpg'),
(111, '공학6호관', 35.154251, 128.094223, 'https://c1.staticflickr.com/3/2928/33784231190_024f661ed4_s.jpg'),
(113, '407동', 35.154209, 128.092911, 'https://c1.staticflickr.com/3/2928/33784231190_024f661ed4_s.jpg'),
(114, '공학7호관(항공우주산학협력관)', 35.154209, 128.092911, 'https://c1.staticflickr.com/3/2928/33784231190_024f661ed4_s.jpg'),
(116, '416동', 35.156326, 128.094910, 'https://c1.staticflickr.com/3/2928/33784231190_024f661ed4_s.jpg'),
(117, '공대부속공장', 35.156326, 128.094910, 'https://c1.staticflickr.com/3/2928/33784231190_024f661ed4_s.jpg'),
(119, '451동', 35.152260, 128.096848, 'https://c1.staticflickr.com/3/2877/34168839845_b21a433623_s.jpg'),
(120, '농생1호관', 35.152260, 128.096848, 'https://c1.staticflickr.com/3/2877/34168839845_b21a433623_s.jpg'),
(121, '농업생명과학대학', 35.152260, 128.096848, 'https://c1.staticflickr.com/3/2877/34168839845_b21a433623_s.jpg'),
(122, '452동', 35.152794, 128.097473, 'https://c1.staticflickr.com/3/2877/34168839845_b21a433623_s.jpg'),
(123, '농생2호관', 35.152794, 128.097473, 'https://c1.staticflickr.com/3/2877/34168839845_b21a433623_s.jpg'),
(125, '453동', 35.152065, 128.097427, 'https://c1.staticflickr.com/3/2877/34168839845_b21a433623_s.jpg'),
(126, '농생3호관', 35.152065, 128.097427, 'https://c1.staticflickr.com/3/2877/34168839845_b21a433623_s.jpg'),
(128, '454동', 35.151463, 128.096741, 'https://c1.staticflickr.com/3/2877/34168839845_b21a433623_s.jpg'),
(129, '농생4호관', 35.151463, 128.096741, 'https://c1.staticflickr.com/3/2877/34168839845_b21a433623_s.jpg'),
(131, '455동', 35.151421, 128.097198, 'https://c1.staticflickr.com/3/2877/34168839845_b21a433623_s.jpg'),
(132, '농생5호관', 35.151421, 128.097198, 'https://c1.staticflickr.com/3/2877/34168839845_b21a433623_s.jpg'),
(134, '456동', 35.153145, 128.095688, 'https://c1.staticflickr.com/3/2877/34168839845_b21a433623_s.jpg'),
(135, '농생6호관', 35.153145, 128.095688, 'https://c1.staticflickr.com/3/2877/34168839845_b21a433623_s.jpg'),
(137, '457동', 35.152199, 128.095428, 'https://c1.staticflickr.com/3/2877/34168839845_b21a433623_s.jpg'),
(138, '농생7호관', 35.152199, 128.095428, 'https://c1.staticflickr.com/3/2877/34168839845_b21a433623_s.jpg'),
(140, '458동', 35.151714, 128.095596, 'https://c1.staticflickr.com/3/2877/34168839845_b21a433623_s.jpg'),
(141, '농생8호관', 35.151714, 128.095596, 'https://c1.staticflickr.com/3/2877/34168839845_b21a433623_s.jpg'),
(143, '459동', 35.152122, 128.095917, 'https://c1.staticflickr.com/3/2877/34168839845_b21a433623_s.jpg'),
(144, '농생과학관', 35.152122, 128.095917, 'https://c1.staticflickr.com/3/2877/34168839845_b21a433623_s.jpg'),
(146, '501동', 35.150490, 128.097244, 'https://c1.staticflickr.com/3/2854/34128897526_a4b15dfc0d_s.jpg'),
(147, '수의1호관', 35.150490, 128.097244, 'https://c1.staticflickr.com/3/2854/34128897526_a4b15dfc0d_s.jpg'),
(148, '수의과대학', 35.150490, 128.097244, 'https://c1.staticflickr.com/3/2854/34128897526_a4b15dfc0d_s.jpg'),
(149, '502동', 35.150925, 128.096802, 'https://c1.staticflickr.com/3/2874/33358255203_442a3b899b_s.jpg'),
(150, '동물병원', 35.150925, 128.096802, 'https://c1.staticflickr.com/3/2874/33358255203_442a3b899b_s.jpg'),
(151, '503동', 35.150810, 128.097244, 'http://www.gnu.ac.kr/img/01/c1_2_3_2_img02.gif'),
(152, '실험동물실습관', 35.150810, 128.097244, 'http://www.gnu.ac.kr/img/01/c1_2_3_2_img02.gif'),
(153, '중앙2식당', 35.153618, 128.097382, 'https://c1.staticflickr.com/3/2936/33357121953_1bc50bcecd_s.jpg'),
(154, '아람관', 35.157349, 128.100967, 'http://www.gnu.ac.kr/img/01/c1_2_3_2_img02.gif'),
(155, '중앙1식당', 35.153618, 128.097382, 'https://c1.staticflickr.com/3/2936/33357121953_1bc50bcecd_s.jpg'),
(156, 'BNIT', 35.153858, 128.095474, 'https://c1.staticflickr.com/3/2855/34127918056_8e0d2e44c0_s.jpg');

--
-- 덤프된 테이블의 인덱스
--

--
-- 테이블의 인덱스 `map`
--
ALTER TABLE `map`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID_2` (`ID`),
  ADD KEY `ID` (`ID`),
  ADD KEY `ID_3` (`ID`);
ALTER TABLE `map` ADD FULLTEXT KEY `keyword` (`keyword`);

--
-- 덤프된 테이블의 AUTO_INCREMENT
--

--
-- 테이블의 AUTO_INCREMENT `map`
--
ALTER TABLE `map`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
