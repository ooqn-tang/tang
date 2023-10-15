insert into uts_author (author_id,mail,nickname,password,refresh_time,signature,update_time,create_time,username) values ('1','admin@admin.com','管理员','$2a$10$oudwqrtyf8t/abwwdxg7hucymx3.fc7/9ewqw835pmtzj/zbthtbo',sysdate,'System Admin User',sysdate,sysdate,'admin');
insert into uts_author_role (author_role_id,author_id,create_time,role_id) values ('1','1',sysdate,'1');
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('1',sysdate,'all','/**',9,'get');
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('2',sysdate,'all','/**',9,'post');
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('3',sysdate,'all','/**',9,'put');       
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('4',sysdate,'all','/**',9,'delete');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('1',sysdate,'1','1');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('2',sysdate,'2','1');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('3',sysdate,'3','1');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('4',sysdate,'4','1');
insert into uts_role (role_id,create_time,refresh_time,role_name,role_value,update_time) values ('1',sysdate,sysdate,'超级管理员','role_admin',sysdate);