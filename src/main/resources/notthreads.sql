drop schema if exists notthreads;

select "Creating notthreads database" as "";

create database notthreads;

use notthreads;

select "Creating users table" as "";

create table users (
	id int not null auto_increment,
	username varchar(255) not null,
	password varchar(255) not null,
  email varchar(255) not null,

	primary key(id)
);

select "Creating posts table" as "";

create table posts (
  id int not null auto_increment,
  user_id int,
  post_date date not null,
  post_content varchar(255) not null,
  image_url varchar(512),
  
  primary key(id),
  foreign key (user_id) 
    references users(id)
);

select "Creating profile table" as "";

create table profile (
  id int not null auto_increment,
  user_id int, 
  display_name varchar(255) not null,
  status_message varchar(255),
  user_location varchar(255),
  profile_img varchar(255),

  primary key(id),
  foreign key (user_id) 
    references users(id)
);

select "Complete" as "";