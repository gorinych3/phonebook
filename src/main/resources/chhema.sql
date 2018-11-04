select * from users;

insert into users (f_name, l_name, address, home_phone, m_phone, profession) VALUES ('Сидоров', 'Иван', 'Мира 5/145', '457896','+79829868866','директор');

drop table users;

CREATE TABLE users
(
  user_id serial PRIMARY KEY NOT NULL,
  f_name varchar(20) NOT NULL,
  l_name varchar(20) NOT NULL,
  address varchar(30) NOT NULL,
  home_phone varchar(20) DEFAULT 'unknown',
  m_phone varchar(20) DEFAULT 'unknown',
  profession varchar(100) DEFAULT 'unknown'
);

