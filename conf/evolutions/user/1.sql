-- Category schema

-- !Ups
create table "USERS" ("USERNAME" VARCHAR NOT NULL,"PASSWORD" VARCHAR NOT NULL,"ID" BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT);

insert into "USERS" ("USERNAME","PASSWORD")
values
    ('Raphael','pass');

-- !Downs
drop table "Category" if exists;