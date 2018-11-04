insert into users (f_name, l_name, address, home_phone, m_phone, profession)
values ('Petrov', 'Sergey', 'Vatutina 46/178', '899761', '+79814587325', 'broker');

SELECT * FROM phonebook_db.users;

SELECT f_name, l_name FROM phonebook_db.users where user_id = 1;

update users set m_phone = '+79928743158' where user_id = 1;

delete from users where user_id = 2;

use phonebook_db;