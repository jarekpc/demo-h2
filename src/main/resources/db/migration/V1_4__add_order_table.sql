CREATE TABLE IF NOT EXISTS ORDERS
(
    id int(11) NOT NULL ,
    cust_name varchar(50) NOT NULL,
    cust_email varchar(50) NOT NULL,
    PRIMARY KEY (id)
);

insert into orders(id, cust_name, cust_email)
values(1,'Andrew','andrew@gmail.com');
-- insert into orders(id, cust_name, cust_email)
-- values(2,'Paul','paul@gmail.com');
-- insert into orders(id, cust_name, cust_email)
-- values(3,'Jimmy','jimmy@gmail.com');