

INSERT INTO `organizations` (`id`, `org_address`, `org_create_date`, `org_cuit`, `org_email`, `org_name`, `org_phone`, `org_token`) VALUES (NULL, 'Domicilio del DR 123', '2022-12-13 15:33:24.000000', '20123456780', 'email@server.com', 'Dr. Armando Meza', '3624121212', 'tokendrarmandomeza123456789000');
INSERT INTO `organizations` (`id`, `org_address`, `org_create_date`, `org_cuit`, `org_email`, `org_name`, `org_phone`, `org_token`) VALUES (NULL, 'Domicilio Party 123', '2022-12-13 18:33:24.000000', '20123456781', 'email_otro@server.com', 'Carpinteria de Esteban Quito', '3624111111', 'tokencarpinteriadeestebanquito123456789');

INSERT INTO `events` (`id`, `creation_date`, `event_active`, `event_location`, `event_name`, `organizations_id`) VALUES (NULL, '2022-12-13 15:56:06.000000', b'1', 'El Consultorio nro. 2300', 'Consulta medica', '1');