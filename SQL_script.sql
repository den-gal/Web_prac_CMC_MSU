CREATE TABLE IF NOT EXISTS orders(
	order_id SERIAL PRIMARY KEY,
	car_id integer REFERENCES cars (reg_id),
	client integer,
	test_drive boolean,
	date_of_order date,
	status varchar(30) DEFAULT 'new' CHECK (status = 'new' OR status ='processed' OR status = 'in travel' OR status = 'arrived' OR status = 'issued' OR status = 'returned')
);
CREATE TABLE IF NOT EXISTS clients(
    client_id SERIAL PRIMARY KEY,
    full_name varchar(50) NOT NULL,
	client_inf text,
	login varchar(50) UNIQUE,
	password varchar(50),
	costumer_status varchar(30) DEFAULT 'newcomer' CHECK (costumer_status ='newcomer' OR costumer_status = 'beginner' OR costumer_status = 'senior' OR costumer_status = 'regular' OR costumer_status = 'master')
);
CREATE TABLE IF NOT EXISTS cars(
	reg_id SERIAL PRIMARY KEY,
	brand varchar(50) NOT NULL,
	manufacturer varchar(50) NOT NULL,
	technical_not text,
	addition_devices text,
	costumer_not text,
	mutable_not text,
	price numeric CHECK (price > 0)
);

CREATE TABLE IF NOT EXISTS admin(
	admin_id SERIAL PRIMARY KEY,
	login varchar(50) UNIQUE,
	password varchar(50)
);

CREATE TABLE IF NOT EXISTS cars_clients(
	reg_id integer,
	client_id integer
);





