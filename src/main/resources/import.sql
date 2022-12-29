
INSERT INTO `organizations` (`id`, `org_active`, `org_address`, `org_create_date`, `org_cuit`, `org_email`, `org_name`, `org_phone`, `org_token`) VALUES (1, 1, 'Domicilio del DR 123', '2022-12-13 15:33:24', '20123456780', 'email@server.com', 'Dr. Armando Meza', 3624121212, 'tokendrarmandomeza123456789000');
INSERT INTO `organizations` (`id`, `org_active`, `org_address`, `org_create_date`, `org_cuit`, `org_email`, `org_name`, `org_phone`, `org_token`) VALUES (2, 0, 'Domicilio Party 123', '2022-12-13 18:33:24', '20123456781', 'email_otro@server.com', 'Carpinteria de Esteban Quito', 3624111111, 'tokencarpinteriadeestebanquito123456789');
INSERT INTO `organizations` (`id`, `org_active`, `org_address`, `org_create_date`, `org_cuit`, `org_email`, `org_name`, `org_phone`, `org_token`) VALUES (3, 1, 'Los Sauces 587', '2022-12-14 12:41:26', '27111111111', 'elsapato@email.com', 'Zapateria de Elsa Pato', 3624556677, 'tokenparaelsapato212223242526');
INSERT INTO `organizations` (`id`, `org_active`, `org_address`, `org_create_date`, `org_cuit`, `org_email`, `org_name`, `org_phone`, `org_token`) VALUES (4, 1, 'Los Sauces 587', '2022-12-14 12:41:26', '20111111111', 'andreshito@email.com', 'Andres Hito', 3624556677, 'tokenparaandreshito212223242526');
INSERT INTO `organizations` (`id`, `org_active`, `org_address`, `org_create_date`, `org_cuit`, `org_email`, `org_name`, `org_phone`, `org_token`) VALUES (5, 0, 'Ameghino 2197', '2022-12-14 12:41:26', '27111111113', 'elsapatero@email.com', 'Zapateria de Elsa Patero', 3624556677, 'tokenparaelsapatero212223242526');
INSERT INTO `organizations` (`id`, `org_active`, `org_address`, `org_create_date`, `org_cuit`, `org_email`, `org_name`, `org_phone`, `org_token`) VALUES (6, 1, 'Arturo Illia 1468', '2022-12-14 12:41:26', '23111111111', 'zapatero@email.com', 'Zapateria de Zapatos', 3624556678, 'tokenparaelsapato2122232425268');
INSERT INTO `organizations` (`id`, `org_active`, `org_address`, `org_create_date`, `org_cuit`, `org_email`, `org_name`, `org_phone`, `org_token`) VALUES(7, 1, 'La Llorona N. 467', '2022-12-21 11:34:25', '20123456780', 'email_2@gmail.com', 'Consultorio Médico', 3624234567, 'tokenConsultorio Médicoemail_2@gmail.com');

INSERT INTO `users` (`id`, `user_active`, `user_create_date`, `user_dni`, `user_email`, `org_lastname`, `user_name`, `user_phone`, `user_token`) VALUES(1, 1, '2022-12-19 13:38:43', '24252627', 'email_user-001@gmail.com', 'Torio', 'Susana', 3624555555, 'tokenemail_user-001@gmail.com3624555555');
INSERT INTO `users` (`id`, `user_active`, `user_create_date`, `user_dni`, `user_email`, `org_lastname`, `user_name`, `user_phone`, `user_token`) VALUES(2, 0, '2022-12-19 13:42:03', '24509509', 'email_user-002@gmail.com', 'Queroso', 'Matias', 3624666666, 'tokenemail_user-002@gmail.com3624666666');
INSERT INTO `users` (`id`, `user_active`, `user_create_date`, `user_dni`, `user_email`, `org_lastname`, `user_name`, `user_phone`, `user_token`) VALUES(3, 1, '2022-12-19 13:42:04', '24509204', 'email_user-003@gmail.com', 'Dito', 'Igor', 3625444444, 'tokenemail_user-003@gmail.com3624666666');
INSERT INTO `users` (`id`, `user_active`, `user_create_date`, `user_dni`, `user_email`, `org_lastname`, `user_name`, `user_phone`, `user_token`) VALUES(5, 0, '2022-12-19 18:24:58', '23555777', 'oscar_acol@email', 'Acolito', 'Oscar', 12345543, 'tokenoscar_acol@email12345543');

INSERT INTO `events` (`id`, `event_active`, `event_create_date`, `event_date_finish`, `event_date_init`, `event_location`, `event_name`, `event_type`, `organization_id`) VALUES(1, 1, '2022-12-20 17:36:49', NULL, '2023-01-02 12:00:00', 'Ameghino 2197', 'Reparaciones Varias de Zapatos', b'1', 3);
INSERT INTO `events` (`id`, `event_active`, `event_create_date`, `event_date_finish`, `event_date_init`, `event_location`, `event_name`, `event_type`, `organization_id`) VALUES(2, 1, '2022-12-20 23:45:41', '2022-12-25 10:00:00', '2022-12-25 01:00:00', 'Ruta 16 km 17', 'Festejamos la Navidad con AH', b'0', 4);
INSERT INTO `events` (`id`, `event_active`, `event_create_date`, `event_date_finish`, `event_date_init`, `event_location`, `event_name`, `event_type`, `organization_id`) VALUES(3, 1, '2022-12-20 23:49:49', '2023-01-30 00:00:00', '2022-12-26 08:00:00', 'Pasaje Algarrobo 985', 'Muebles a medida - Ofertas', b'1', 2);
INSERT INTO `events` (`id`, `event_active`, `event_create_date`, `event_date_finish`, `event_date_init`, `event_location`, `event_name`, `event_type`, `organization_id`) VALUES(2, 1, '2022-12-20 23:45:41', '2023-01-01 10:00:00', '2023-01-01 01:00:00', 'Ruta 16 km 17', 'Festejamos el Año Nuevo', b'0', 4);
INSERT INTO `events` (`id`, `event_active`, `event_create_date`, `event_date_finish`, `event_date_init`, `event_location`, `event_name`, `event_type`, `organization_id`) VALUES(4, 1, '2022-12-21 11:31:18', NULL, '2023-01-01 02:00:00', 'Ruta 16 km 17', 'Festejamos el Año Nuevo', b'0', 4);

INSERT INTO `turns` (`id`, `turn_active`, `turn_code`, `turn_create_date`, `turn_date`, `turn_event_name`, `event_id`, `user_id`) VALUES(1, b'1', 'WzRhCtaPXdPHxYskBZcC', '2022-12-21 16:27:35', '2022-12-25 01:00:00', 'Reparaciones Varias de Zapatos', 2, 5);
INSERT INTO `turns` (`id`, `turn_active`, `turn_code`, `turn_create_date`, `turn_date`, `turn_event_name`, `event_id`, `user_id`) VALUES(2, b'1', 'XzEFAXHYszjIJWpiXEeN', '2022-12-29 08:28:44', '2023-01-01 02:00:00', 'año nuevo 2', 4, 1);
INSERT INTO `turns` (`id`, `turn_active`, `turn_code`, `turn_create_date`, `turn_date`, `turn_event_name`, `event_id`, `user_id`) VALUES(3, b'1', 'WOYTuHMeuVkeKvxQAAvg', '2022-12-29 08:28:58', '2023-01-01 02:00:00', 'año nuevo 2', 4, 2);
INSERT INTO `turns` (`id`, `turn_active`, `turn_code`, `turn_create_date`, `turn_date`, `turn_event_name`, `event_id`, `user_id`) VALUES(4, b'1', 'dZkQvsYMcKhGBpmxCYPw', '2022-12-29 08:29:14', '2023-01-01 02:00:00', 'año nuevo ', 4, 3);
INSERT INTO `turns` (`id`, `turn_active`, `turn_code`, `turn_create_date`, `turn_date`, `turn_event_name`, `event_id`, `user_id`) VALUES(5, b'1', 'mefMIdDamshAfQfOeGeZ', '2022-12-29 08:30:05', '2023-01-01 02:00:00', 'año nuevo ', 4, 5);

