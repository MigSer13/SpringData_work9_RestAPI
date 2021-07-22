create table category (id bigserial primary key, title varchar(255), created_at timestamp default current_timestamp, updated_at timestamp default current_timestamp );
insert into category(title) values ('Food');

create table products (id bigserial primary key, title varchar(255), price int, category_id bigint references categories (id), created_at timestamp default current_timestamp, updated_at timestamp default current_timestamp );
insert into products (title, price) values
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
('Cheese', 400, 1),

