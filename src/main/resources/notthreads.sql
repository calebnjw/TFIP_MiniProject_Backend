drop schema if exists notthreads;

select "Creating notthreads database" as "";

create database notthreads;

use notthreads;

select "Creating users table" as "";

create table users (
	id char(8) not null unique,
	username varchar(255) not null unique,
	password varchar(255) not null,
  email varchar(255) not null unique,

	primary key(id)
);

select "Creating profile table" as "";

create table profile (
  id int not null unique auto_increment,
  user_id char(8), 
  display_name varchar(255) not null,
  status_message varchar(255),
  user_location varchar(255),
  profile_img varchar(255),

  primary key(id),
  foreign key (user_id) 
    references users(id)
);

select "Creating posts table" as "";

create table posts (
  id char(8) not null unique,
  user_id int,
  post_date date not null,
  post_content varchar(255) not null,
  image_url varchar(512),
  
  primary key(id),
  foreign key (user_id) 
    references users(id)
);

select "Complete" as "";