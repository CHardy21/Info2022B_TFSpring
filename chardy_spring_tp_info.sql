-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-12-2022 a las 08:00:48
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `events`
--

DROP TABLE IF EXISTS `events`;
CREATE TABLE `events` (
  `id` bigint(20) NOT NULL,
  `event_active` tinyint(1) DEFAULT 1,
  `event_create_date` datetime DEFAULT NULL,
  `event_date_finish` datetime DEFAULT NULL,
  `event_date_init` datetime NOT NULL,
  `event_location` varchar(30) DEFAULT NULL,
  `event_name` varchar(30) DEFAULT NULL,
  `event_type` bit(1) NOT NULL,
  `organizations_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `events`
--

INSERT INTO `events` (`id`, `event_active`, `event_create_date`, `event_date_finish`, `event_date_init`, `event_location`, `event_name`, `event_type`, `organizations_id`) VALUES(1, 1, '2022-12-20 17:36:49', NULL, '2023-01-02 12:00:00', 'Ameghino 2197', 'Reparaciones Varias de Zapatos', b'1', 3);
INSERT INTO `events` (`id`, `event_active`, `event_create_date`, `event_date_finish`, `event_date_init`, `event_location`, `event_name`, `event_type`, `organizations_id`) VALUES(2, 1, '2022-12-20 23:45:41', '2022-12-25 10:00:00', '2022-12-25 01:00:00', 'Ruta 16 km 17', 'Festejamos la Navidad con AH', b'0', 4);
INSERT INTO `events` (`id`, `event_active`, `event_create_date`, `event_date_finish`, `event_date_init`, `event_location`, `event_name`, `event_type`, `organizations_id`) VALUES(3, 1, '2022-12-20 23:49:49', '2023-01-30 00:00:00', '2022-12-26 08:00:00', 'Pasaje Algarrobo 985', 'Muebles a medida - Ofertas', b'1', 2);

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
  `org_cuit` varchar(13) DEFAULT NULL,
  `org_email` varchar(255) DEFAULT NULL,
  `org_name` varchar(30) DEFAULT NULL,
  `org_phone` bigint(20) NOT NULL,
  `org_token` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `organizations`
--

INSERT INTO `organizations` (`id`, `org_active`, `org_address`, `org_create_date`, `org_cuit`, `org_email`, `org_name`, `org_phone`, `org_token`) VALUES(1, 1, 'Domicilio del DR 123', '2022-12-13 15:33:24', '20123456780', 'email@server.com', 'Dr. Armando Meza', 3624121212, 'tokendrarmandomeza123456789000');
INSERT INTO `organizations` (`id`, `org_active`, `org_address`, `org_create_date`, `org_cuit`, `org_email`, `org_name`, `org_phone`, `org_token`) VALUES(2, 0, 'Domicilio Party 123', '2022-12-13 18:33:24', '20123456781', 'email_otro@server.com', 'Carpinteria de Esteban Quito', 3624111111, 'tokencarpinteriadeestebanquito123456789');
INSERT INTO `organizations` (`id`, `org_active`, `org_address`, `org_create_date`, `org_cuit`, `org_email`, `org_name`, `org_phone`, `org_token`) VALUES(3, 1, 'Los Sauces 587', '2022-12-14 12:41:26', '27111111111', 'elsapato@email.com', 'Zapateria de Elsa Pato', 3624556677, 'tokenparaelsapato212223242526');
INSERT INTO `organizations` (`id`, `org_active`, `org_address`, `org_create_date`, `org_cuit`, `org_email`, `org_name`, `org_phone`, `org_token`) VALUES(4, 1, 'Los Sauces 587', '2022-12-14 12:41:26', '27111111111', 'andreshito@email.com', 'Andres Hito', 3624556677, 'tokenparaandreshito212223242526');
INSERT INTO `organizations` (`id`, `org_active`, `org_address`, `org_create_date`, `org_cuit`, `org_email`, `org_name`, `org_phone`, `org_token`) VALUES(5, 0, 'Ameghino 2197', '2022-12-14 12:41:26', '27111111113', 'elsapatero@email.com', 'Zapateria de Elsa Patero', 3624556677, 'tokenparaelsapatero212223242526');
INSERT INTO `organizations` (`id`, `org_active`, `org_address`, `org_create_date`, `org_cuit`, `org_email`, `org_name`, `org_phone`, `org_token`) VALUES(6, 1, 'Arturo Illia 1468', '2022-12-14 12:41:26', '23111111111', 'zapatero@email.com', 'Zapateria de Zapatos', 3624556678, 'tokenparaelsapato2122232425268');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turns`
--

DROP TABLE IF EXISTS `turns`;
CREATE TABLE `turns` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `events_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `user_active` tinyint(1) DEFAULT 1,
  `user_create_date` datetime DEFAULT NULL,
  `user_dni` varchar(8) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `org_lastname` varchar(30) DEFAULT NULL,
  `user_name` varchar(30) DEFAULT NULL,
  `user_phone` bigint(20) NOT NULL,
  `user_token` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `user_active`, `user_create_date`, `user_dni`, `user_email`, `org_lastname`, `user_name`, `user_phone`, `user_token`) VALUES(1, 1, '2022-12-19 13:38:43', '24252627', 'email_user-001@gmail.com', 'Torio', 'Susana', 3624555555, 'tokenemail_user-001@gmail.com3624555555');
INSERT INTO `users` (`id`, `user_active`, `user_create_date`, `user_dni`, `user_email`, `org_lastname`, `user_name`, `user_phone`, `user_token`) VALUES(2, 0, '2022-12-19 13:42:03', '24509509', 'email_user-002@gmail.com', 'Queroso', 'Matias', 3624666666, 'tokenemail_user-002@gmail.com3624666666');
INSERT INTO `users` (`id`, `user_active`, `user_create_date`, `user_dni`, `user_email`, `org_lastname`, `user_name`, `user_phone`, `user_token`) VALUES(3, 1, '2022-12-19 13:42:04', '24509204', 'email_user-003@gmail.com', 'Dito', 'Igor', 3625444444, 'tokenemail_user-003@gmail.com3624666666');
INSERT INTO `users` (`id`, `user_active`, `user_create_date`, `user_dni`, `user_email`, `org_lastname`, `user_name`, `user_phone`, `user_token`) VALUES(5, 0, '2022-12-19 18:24:58', '23555777', 'oscar_acol@email', 'Acolito', 'Oscar', 12345543, 'tokenoscar_acol@email12345543');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `organizations`
--
ALTER TABLE `organizations`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_86qgdin7n8fj1rl9j2qiww2fe` (`org_email`),
  ADD UNIQUE KEY `UK_it9oxa0rmaumshumc3m46lvam` (`org_name`);

--
-- Indices de la tabla `turns`
--
ALTER TABLE `turns`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKohwaqpxs4fufrmm0l2ltrfcgn` (`user_id`),
  ADD KEY `FK19b2h2uql7uiiq91k9wy93cul` (`events_id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_shtn4vo1x4qyo606nry4dulcp` (`user_dni`),
  ADD UNIQUE KEY `UK_33uo7vet9c79ydfuwg1w848f` (`user_email`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `events`
--
ALTER TABLE `events`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `organizations`
--
ALTER TABLE `organizations`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `turns`
--
ALTER TABLE `turns`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `turns`
--
ALTER TABLE `turns`
  ADD CONSTRAINT `FK19b2h2uql7uiiq91k9wy93cul` FOREIGN KEY (`events_id`) REFERENCES `events` (`id`),
  ADD CONSTRAINT `FKohwaqpxs4fufrmm0l2ltrfcgn` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
