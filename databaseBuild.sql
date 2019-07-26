DROP TABLE IF EXISTS user_entity cascade ;
DROP TABLE IF EXISTS group_entity;
CREATE TABLE user_entity(
  id bigserial PRIMARY KEY not NULL ,
  login text not NULL ,
  password text not NULL ,
  email text not NULL ,
  created_at date null ,
  is_active boolean
);

CREATE TABLE group_entity(
  id bigserial PRIMARY KEY not null ,
  name text not null ,
  creator_id bigint references user_entity(id),
  is_creator boolean,
  user_id bigint references user_entity(id) on delete cascade ,
  link character (50)
);

insert into user_entity(login, password, email, created_at, is_active) values
('1','1','lolkek@mail.ru','2019-02-02' , true),
('2','2','lolkek@mail.ru','2019-02-02' , true),
('3','3','lolkek@mail.ru','2019-02-02' , true);

insert into group_entity(name,creator_id,is_creator,user_id,link) values
('group 1', 1,true,null,'group_1'),
('group 1', 1,false,3,'group_1'),
('group2', 2,true,null,'group2'),
('group2', 2,false ,3,'group2');
