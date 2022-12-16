-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-12-2022 a las 13:17:32
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `chardy_spring_tp_info`
--
CREATE DATABASE IF NOT EXISTS `chardy_spring_tp_info` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `chardy_spring_tp_info`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `events`
--

DROP TABLE IF EXISTS `events`;
CREATE TABLE `events` (
  `id` bigint(20) NOT NULL,
  `creation_date` datetime DEFAULT NULL,
  `event_active` bit(1) DEFAULT NULL,
  `event_location` varchar(255) DEFAULT NULL,
  `event_name` varchar(255) DEFAULT NULL,
  `organizations_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `events`
--

INSERT INTO `events` (`id`, `creation_date`, `event_active`, `event_location`, `event_name`, `organizations_id`) VALUES
(1, '2022-12-13 15:56:06', b'1', 'El Consultorio nro. 2300', 'Consulta medica', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `organizations`
--

DROP TABLE IF EXISTS `organizations`;
CREATE TABLE `organizations` (
  `id` bigint(20) NOT NULL,
  `org_active` tinyint(1) DEFAULT 1,
  `org_address` varchar(255) DEFAULT NULL,
  `org_create_date` datetime DEFAULT NULL,
  `org_cuit` bigint(20) DEFAULT NULL,
  `org_email` varchar(255) DEFAULT NULL,
  `org_name` varchar(30) DEFAULT NULL,
  `org_phone` bigint(20) NOT NULL,
  `org_token` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `organizations`
--

INSERT INTO `organizations` (`id`, `org_active`, `org_address`, `org_create_date`, `org_cuit`, `org_email`, `org_name`, `org_phone`, `org_token`) VALUES
(1, 1, 'Domicilio del DR 123', '2022-12-13 15:33:24', 20123456780, 'email@server.com', 'Dr. Armando Meza', 3624121212, 'tokendrarmandomeza123456789000'),
(2, 1, 'Domicilio Party 123', '2022-12-13 18:33:24', 20123456781, 'email_otro@server.com', 'Carpinteria de Esteban Quito', 3624111111, 'tokencarpinteriadeestebanquito123456789'),
(3, 1, 'Los Sauces 587', '2022-12-14 12:41:26', 27111111111, 'elsapato@email.com', 'Zapateria de Elsa Pato', 3624556677, 'tokenparaelsapato212223242526'),
(4, 1, 'Los Sauces 587', '2022-12-14 12:41:26', 27111111111, 'andreshito@email.com', 'Andres Hito', 3624556677, 'tokenparaandreshito212223242526'),
(5, 0, 'Ameghino 2197', '2022-12-14 12:41:26', 27111111113, 'elsapatero@email.com', 'Zapateria de Elsa Patero', 3624556677, 'tokenparaelsapatero212223242526'),
(6, 1, 'Arturo Illia 1468', '2022-12-14 12:41:26', 23111111111, 'zapatero@email.com', 'Zapateria de Zapatos', 3624556677, 'tokenparaelsapato212223242526');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKj7st5etosp5lga8cym80xd3n2` (`organizations_id`);

--
-- Indices de la tabla `organizations`
--
ALTER TABLE `organizations`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_86qgdin7n8fj1rl9j2qiww2fe` (`org_email`),
  ADD UNIQUE KEY `UK_it9oxa0rmaumshumc3m46lvam` (`org_name`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `events`
--
ALTER TABLE `events`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `organizations`
--
ALTER TABLE `organizations`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `events`
--
ALTER TABLE `events`
  ADD CONSTRAINT `FKj7st5etosp5lga8cym80xd3n2` FOREIGN KEY (`organizations_id`) REFERENCES `organizations` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
