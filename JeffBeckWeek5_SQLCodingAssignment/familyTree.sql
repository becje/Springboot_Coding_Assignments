create database if not exists familyTree;

use familyTree;

drop table if exists familyTree;

create table if not exists people (
	people_id int(100) not null auto_increment,
	firstName varchar(25) not null,
	middleName varchar(25),
	lastName varchar(25) not null,
	maidenName varchar(25),
	gender varchar(10),
	birthDate varchar(25) not null,
	birthCity varchar(50),
	birthState varchar(25),
	birthCountry varchar(50),
	lifeStatus varchar(10) not null,
	deathDate varchar(25),
	causeDeath varchar(100),
	age varchar(5),
	relationshipType varchar(25) not null,
	primary key (people_id)
);

show tables;
desc people;
select * from people;