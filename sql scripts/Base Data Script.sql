INSERT INTO library.role(role) VALUES('user'),('admin'),('manager');
INSERT INTO library.user_statuses(status) VALUES('active'),('blocked'),('delete');
INSERT INTO library.users(id_status, id_role, password, second_name, last_name, email, count_violations) VALUES(3, 1, 'F662834B04A38856A3F36BD7BA99E5C3', 'General', 'Manager', 'admin_library@gmail.com', 0);

INSERT INTO library.order_statuses(status) VALUES('opened'),('approved'),('rejected'),('arrived'),('closed');

INSERT INTO library.library_statuses(status) VALUES('opened'),('closed');
INSERT INTO library.libraries(city, street, id_status)
	VALUES('Минск', 'пр. Независимости 116', 1),
		  ('Гомель', 'пл. Ленина 1', 1),
		  ('Брест', 'ул. Героев обороны Брестской крепости 60', 2);

INSERT INTO library.card_statuses(status) VALUES('open'),('closed');