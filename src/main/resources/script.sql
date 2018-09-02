create table announcements
(
  id        int auto_increment
    primary key,
  title     varchar(20) not null,
  date      date        not null,
  author    varchar(20) not null,
  author_id int         not null,
  content   text        null,
  constraint announcements_id_uindex
  unique (id)
);

create table auth
(
  id       int auto_increment
    primary key,
  username varchar(30) not null,
  salt     varchar(80) not null,
  password varchar(80) not null,
  constraint auth_id_uindex
  unique (id)
);

create table problem
(
  id            int auto_increment
    primary key,
  title         varchar(200)    not null,
  description   text            null,
  input         text            null,
  output        text            null,
  sample_input  text            null,
  sample_output text            null,
  hint          text            null,
  time_limit    int             null,
  mem_limit     int             null,
  submit_num    int default '0' null,
  accept_num    int default '0' null,
  test_case     int default '0' null
);

create table problem_list
(
  id         int auto_increment
    primary key,
  problem_id int          not null,
  title      varchar(200) not null,
  author     varchar(200) null,
  source     varchar(200) null,
  constraint problem_list_id_uindex
  unique (id)
);

create table submissions
(
  id         int auto_increment
    primary key,
  code       text            null,
  username   varchar(200)    not null,
  date       datetime        null,
  problem_id int             not null,
  result     int default '7' null,
  time       double          null,
  memory     int             null,
  length     int             null,
  Language   int             null
);

create table user
(
  id       int auto_increment
    primary key,
  username varchar(20)     not null,
  email    varchar(20)     null,
  solved   int default '0' not null,
  attempt  int default '0' null,
  isAdmin  int default '0' null,
  constraint user_id_uindex
  unique (id)
);


