CREATE table city(
	id BIGINT not null auto_increment,
	name varchar(50),
	primary key (id)
);

create table theatre(
	id BIGINT not null auto_increment,
	name varchar(50),
	city_id BIGINT not null,
	primary key (id),
	foreign key (city_id) references city(id)
);

CREATE table movie(
	id BIGINT not null auto_increment,
	name varchar(50),
	primary key (id)
);

create table screen (
	id BIGINT not null auto_increment,
	name varchar(50) not null,
	theatre_id bigint not null,
	seats int not null,
	primary key (id),
	foreign key (theatre_id) references theatre(id)
);

create table shows (
	id BIGINT not null auto_increment,
	movie_id bigint not null,
	screen_id bigint not null,
	show_time datetime not null,
	primary key (id),
	foreign key (movie_id) references movie(id),
	foreign key (screen_id) references screen(id)
);

create table booking(
    id bigint not null auto_increment,
    name varchar(50),
    primary key (id)
);

create table seats (
    id BIGINT not null auto_increment,
    seat_no varchar,
    show_id bigint not null,
    booking_id bigint,
    primary key(id),
    foreign key (show_id) references show(id),
    foreign key (booking_id) references booking(id)
);
