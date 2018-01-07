use laboratory_manage;

# drop table inf_news;
# drop table inv_category;
# drop table inv_product;
# drop table sys_permission;
# drop table sys_resource;
# drop table sys_role;
# drop table sys_user;
# drop table sys_user_role;
# drop table web_page;
# drop table web_website;

###############################################################
# 建表
###############################################################

DROP TABLE IF EXISTS `sys_permission`;

# 权限表
create table `sys_permission` (
  `ROLE_ID` int(10) unsigned NOT NULL,
  `RESOURCE_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ROLE_ID`,`RESOURCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `students`;

# 学生表
create table `students` (
  `name` varchar(50) default null,
  `student_id` varchar(20) default null,
  `password` varchar(20) default '123456',
  `sys_role` varchar(10) default null,
  `class` varchar(50) default null,
  primary key (`student_id`)
) engine=InnoDB default charset=utf8;

DROP TABLE IF EXISTS `teachers`;

# 老师表
create table `teachers` (
  `name` varchar(50) default null,
  `teacher_id` varchar(20) default null,
  `password` varchar(20) default '123456',
  `sys_role` varchar(10) default null,
  primary key (`teacher_id`)
) engine=InnoDB default charset=utf8;

DROP TABLE IF EXISTS `sys_role`;

# 角色表
create table `sys_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL default "student",
  `remark` varchar(200) default null,
  primary key (`id`)
) engine=InnoDB default charset=utf8;

DROP TABLE IF EXISTS `laboratory`;

# 实验室信息表
create table `laboratory` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL default 'Laboratory Temp',
  `remark` varchar(200) default null,
  primary key (`id`)
) engine=InnoDB default charset=utf8;

DROP TABLE IF EXISTS `news`;

# 新闻公告表
create table `news` (
  `id` int(10) unsigned not null auto_increment,
  `title` varchar(50) not null default 'news title',
  `content` varchar(500) not null default 'this is content',
  primary key (`id`)
) engine=InnoDB default charset=utf8;

DROP TABLE IF EXISTS `teach_file`;

# 教学材料表
create table `teach_file` (
  `id` int(10) unsigned not null auto_increment,
  `title` varchar(50) not null default 'file temp',
  `remark` varchar(50) default null,
  `content` varchar(500) default null,
  primary key (`id`)
) engine=InnoDB default charset=utf8;

DROP TABLE IF EXISTS `experiment_course`;

# 实验课程表
create table `experiment_course` (
  `id` int(10) unsigned not null auto_increment,
  `title` varchar(50) not null default "experment x",
  `remark` varchar(50) default null,
  `stu_number` int(50) not null default '20',
  `date_` datetime not null,
  primary key (`id`)
) engine=InnoDB default charset=utf8;


####################################################################
# 插入数据
####################################################################

insert into students values("hiro", "2014332860054", "9090", "admin", "14计科3班");
insert into students values("haha", "2014332860056", "9090", "student", "14计科3班");
insert into students values("wang", "2014332860057", "9090", "student", "14计科3班");
insert into students values("jb", "2014332860058", "9090", "student", "14计科3班");

insert into teachers values("赵先生", "19960618", "0000", "admin");
