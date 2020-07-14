-- ALTER TABLE USERS ADD COLUMN DISABLED BOOL DEFAULT TRUE;
CREATE TABLE ADDRESSES
(
    id int(11) NOT NULL AUTO_INCREMENT,
    city varchar(100) DEFAULT NULL,
    user_id int(11) NOT NULL,
    PRIMARY KEY (id)
--     CONSTRAINT FK_ADDRESSES_USERS FOREIGN KEY (user_id) REFERENCES USERS(ID)
--     FOREIGN KEY(user_id) REFERENCES (id)
);

alter table ADDRESSES add constraint FKcaf6ht0hfw93lwc13ny0sdmvo foreign key (user_id) references users(id);

-- ALTER TABLE ADDRESSES ADD FOREIGN KEY (user_id)
--         REFERENCES users(id);
-- INSERT INTO USERS(name, email, disabled) values ('Adam','adam@o2.pl', false );
-- insert into USERS(id, name, email,disabled) values(1,'John','john@gmail.com', false);
-- insert into users(id, name, email, disabled) values(2,'Rod','rod@gmail.com', false);
-- insert into users(id, name, email, disabled) values(3,'Renold','renold@gmail.com', true);
--
-- insert into ADDRESSES(id, city,user_id) values (1,'Zywiec',1);
