/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

create table acc_role
(
    account_id bigint not null,
    role_id    bigint not null
) engine=InnoDB;
create table accounts
(
    id           bigint not null auto_increment,
    email        varchar(255),
    is_available bit,
    password     varchar(255),
    primary key (id)
) engine=InnoDB;
create table address
(
    id       bigint not null auto_increment,
    address  varchar(255),
    users_id bigint,
    primary key (id)
) engine=InnoDB;
create table available
(
    id      bigint not null auto_increment,
    stock   bigint,
    size_id bigint,
    primary key (id)
) engine=InnoDB;
create table category
(
    id         bigint not null auto_increment,
    name       varchar(255),
    clothes_id bigint,
    primary key (id)
) engine=InnoDB;
create table clothes
(
    id   bigint not null auto_increment,
    name varchar(255),
    path varchar(255),
    primary key (id)
) engine=InnoDB;
create table order_details
(
    id         bigint not null auto_increment,
    price      float,
    quantity   integer,
    clothes_id bigint,
    order_id   id,
    sizes_id   bigint,
    primary key (id)
) engine=InnoDB;
create table orders
(
    id         bigint not null auto_increment,
    code       varchar(255),
    address_id id,
    users_id   bigint,
    primary key (id)
) engine=InnoDB;
create table roles
(
    id   bigint not null auto_increment,
    name varchar(255),
    primary key (id)
) engine=InnoDB;
create table size
(
    id         bigint not null auto_increment,
    name       varchar(255),
    clothes_id bigint,
    primary key (id)
) engine=InnoDB;
create table users
(
    id          bigint       not null auto_increment,
    firstname   varchar(255) not null,
    lastname    varchar(255) not null,
    phonenumber varchar(10)  not null,
    photo       varchar(255),
    account_id  bigint,
    primary key (id)
) engine=InnoDB;
alter table acc_role
    add constraint FK7hgoa6w5byi9dadudojliywwk foreign key (role_id) references roles (id);
alter table acc_role
    add constraint FKhbv5b4f1w68obnk540ichbwoy foreign key (account_id) references accounts (id);
alter table address
    add constraint FKls1hr62ne1ffxvi7yayu99wdk foreign key (users_id) references users (id);
alter table available
    add constraint FKksdogdwyn178j43l2t1pgs0qb foreign key (size_id) references size (id);
alter table category
    add constraint FK2uyv8fn1d2lit3jtcrkcjy9pf foreign key (clothes_id) references clothes (id);
alter table order_details
    add constraint FKo3rtekew7ndhw6ndr23h5eu6b foreign key (clothes_id) references clothes (id);
alter table order_details
    add constraint FKjyu2qbqt8gnvno9oe9j2s2ldk foreign key (order_id) references orders (id);
alter table order_details
    add constraint FKa1gysvy4wxm9newk5ycbiryo4 foreign key (sizes_id) references size (id);
alter table orders
    add constraint FKf5464gxwc32ongdvka2rtvw96 foreign key (address_id) references address (id);
alter table orders
    add constraint FKe6k45xxoin4fylnwg2jkehwjf foreign key (users_id) references users (id);
alter table size
    add constraint FK6qhlnpvgq4fbxyf1ry4r3qjyq foreign key (clothes_id) references clothes (id);
alter table users
    add constraint FKfm8rm8ks0kgj4fhlmmljkj17x foreign key (account_id) references accounts (id);
