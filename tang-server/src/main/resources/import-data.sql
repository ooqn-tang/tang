insert into uts_author (author_id,mail,nickname,password,refresh_time,signature,update_time,create_time,username) values ('1','admin@admin.com','admin','$2a$10$mZbVEMls/YLv3cvFkGMoQOpgENyrmUtMnXagfl6qVjHOzOqLrtMbO',now(),'System Admin User',now(),now(),'admin');
insert into uts_author_role (author_role_id,author_id,create_time,role_id) values ('1','1',now(),'1');

insert into uts_role (role_id,role_name,role_value,create_time,refresh_time,update_time) values ('1','admin','ROLE_ADMIN',now(),now(),now());
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('1',now(),'all','/**',9,'get');
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('2',now(),'all','/**',9,'post');
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('3',now(),'all','/**',9,'put');       
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('4',now(),'all','/**',9,'delete');

insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('1',now(),'1','1');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('2',now(),'2','1');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('3',now(),'3','1');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('4',now(),'4','1');


insert into uts_role (role_id,role_name,role_value,create_time,refresh_time,update_time) values ('2','author','ROLE_AUTHOR',now(),now(),now());
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('5',now(),'article','/api/article/**',9,'get');
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('6',now(),'article','/api/article/**',9,'post');
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('7',now(),'article','/api/article/**',9,'put');       
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('8',now(),'article','/api/article/**',9,'delete');

insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('5',now(),'5','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('6',now(),'6','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('7',now(),'7','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('8',now(),'8','2');

insert into uts_resource (resource_id,create_time,name,path,state,type) values ('9',now(),'category','/api/category/**',9,'get');
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('10',now(),'category','/api/category/**',9,'post');
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('11',now(),'category','/api/category/**',9,'put');       
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('12',now(),'category','/api/category/**',9,'delete');

insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('9',now(),'9','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('10',now(),'10','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('11',now(),'11','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('12',now(),'12','2');

insert into uts_resource (resource_id,create_time,name,path,state,type) values ('13',now(),'all','/api/collect/**',9,'get');
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('14',now(),'all','/api/collect/**',9,'post');
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('15',now(),'all','/api/collect/**',9,'put');       
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('16',now(),'all','/api/collect/**',9,'delete');

insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('13',now(),'13','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('14',now(),'14','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('15',now(),'15','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('16',now(),'16','2');

insert into uts_resource (resource_id,create_time,name,path,state,type) values ('17',now(),'essay','/api/essay/**',9,'get');
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('18',now(),'essay','/api/essay/**',9,'post');
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('19',now(),'essay','/api/essay/**',9,'put');       
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('20',now(),'essay','/api/essay/**',9,'delete');

insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('17',now(),'17','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('18',now(),'18','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('19',now(),'19','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('20',now(),'20','2');

insert into uts_resource (resource_id,create_time,name,path,state,type) values ('21',now(),'like','/api/like/**',9,'get');
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('22',now(),'like','/api/like/**',9,'post');
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('23',now(),'like','/api/like/**',9,'put');       
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('24',now(),'like','/api/like/**',9,'delete');

insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('21',now(),'21','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('22',now(),'22','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('23',now(),'23','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('24',now(),'24','2');

insert into uts_resource (resource_id,create_time,name,path,state,type) values ('25',now(),'message','/api/message/**',9,'get');
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('26',now(),'message','/api/message/**',9,'post');
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('27',now(),'message','/api/message/**',9,'put');       
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('28',now(),'message','/api/message/**',9,'delete');

insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('25',now(),'25','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('26',now(),'26','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('27',now(),'27','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('28',now(),'28','2');


insert into uts_resource (resource_id,create_time,name,path,state,type) values ('29',now(),'subject','/api/subject/**',9,'get');
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('30',now(),'subject','/api/subject/**',9,'post');
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('31',now(),'subject','/api/subject/**',9,'put');       
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('32',now(),'subject','/api/subject/**',9,'delete');

insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('29',now(),'29','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('30',now(),'30','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('31',now(),'31','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('32',now(),'32','2');


insert into uts_resource (resource_id,create_time,name,path,state,type) values ('33',now(),'notice','/api/notice/**',9,'get');
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('34',now(),'notice','/api/notice/**',9,'post');
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('35',now(),'notice','/api/notice/**',9,'put');       
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('36',now(),'notice','/api/notice/**',9,'delete');

insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('33',now(),'33','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('34',now(),'34','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('35',now(),'35','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('36',now(),'36','2');


insert into uts_resource (resource_id,create_time,name,path,state,type) values ('37',now(),'author','/api/author/**',9,'get');
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('38',now(),'author','/api/author/**',9,'post');
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('39',now(),'author','/api/author/**',9,'put');       
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('40',now(),'author','/api/author/**',9,'delete');

insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('37',now(),'37','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('38',now(),'38','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('39',now(),'39','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('40',now(),'40','2');


insert into uts_resource (resource_id,create_time,name,path,state,type) values ('41',now(),'fans','/api/fans/**',9,'get');
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('42',now(),'fans','/api/fans/**',9,'post');
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('43',now(),'fans','/api/fans/**',9,'put');       
insert into uts_resource (resource_id,create_time,name,path,state,type) values ('44',now(),'fans','/api/fans/**',9,'delete');

insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('41',now(),'41','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('42',now(),'42','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('43',now(),'43','2');
insert into uts_resource_role (resource_role_id,create_time,resource_id,role_id) values ('44',now(),'44','2');
