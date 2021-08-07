CREATE table categories (id bigserial primary key, title varchar(255), created_at timestamp default current_timestamp, updated_at timestamp default current_timestamp );
insert into categories(title) values ('Food');

CREATE table products (id bigserial primary key, title varchar(255), price numeric(8, 2) not null, category_id bigint references categories (id), created_at timestamp default current_timestamp, updated_at timestamp default current_timestamp );
insert into products (title, price, category_id) values
('Bread',39, 1),
('Apple',13, 1),
('Pear',17, 1),
('Grape',270, 1),
('Cucumber',15, 1),
('Tomato',15, 1),
('Loaf',40, 1),
('Nuts',150, 1),
('Lemon',150, 1),
('Juice',100, 1),
('Sausage', 310, 1),
('Cookies',95, 1),
('Potato',60, 1),
('Carrot',70, 1),
('Onion',55, 1),
('Garlic',83, 1),
('Pasta',72, 1),
('Rice',72, 1),
('Milk',69, 1),
('Cheese', 400, 1);

CREATE table users (
  id                    bigserial primary key,
  username              varchar(30) not null unique,
  password              varchar(80) not null,
  email                 varchar(50) unique,
  created_at            timestamp default current_timestamp,
  updated_at            timestamp default current_timestamp
);

CREATE table roles (
  id                    bigserial primary key,
  name                  varchar(30) not null,
  created_at            timestamp default current_timestamp,
  updated_at            timestamp default current_timestamp
);

CREATE table users_roles (
 user_id               bigint not null references users (id),
 role_id               bigint not null references roles (id)
 );

 CREATE table orders (
   id                    bigserial primary key,
   price                 numeric(8, 2) not null,
   user_id               bigint references users (id),
   created_at            timestamp default current_timestamp,
   updated_at            timestamp default current_timestamp
 );

 CREATE table order_items (
    id                    bigserial primary key,
    product_id            bigint references products (id),
    order_id              bigint references orders (id),
    position_price        numeric(8, 2) not null,
    price_per_product     numeric(8, 2) not null,
    quantity              int,
    created_at            timestamp default current_timestamp,
    updated_at            timestamp default current_timestamp
  );


insert into users (username, password, email)
values
('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user@gmail.com'),
('admin', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'admin@gmail.com')
;

 insert into roles (name)
 values ('ROLE_USER'), ('ROLE_ADMIN');

insert into users_roles (user_id, role_id)
values
(1, 1),
(2, 2);