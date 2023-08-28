use xuexi01;


drop table if exists person;
drop table if exists sector;

create table sector(

                       id               int(20) primary key comment '部门id',
                       sector_name      varchar(20) not null comment '部门名称',
                       sector_address   varchar(20) not null comment '部门办公地点'

)
    engine = InnoDB
    default charset = utf8
    comment '部门表'
;

create table person(


    id                  int  auto_increment primary key comment '人员ID',
    name                varchar(20) not null comment '姓名' ,
    age                 tinyint not null comment '年龄',
    sex                 varchar(1) not null comment '性别',
    birthday            date comment '生日',
    telephone_number    char(11) comment '电话号码',
    email               varchar(30) not null comment'邮箱',
    onboarding_time     datetime not null comment'入职时间',
    post                varchar(50) not null comment'工作岗位',
    monthly_salary      int not null comment '月薪',
    bonus               int not null comment '年终奖',
    sector_id           int(20)  comment '部门id',
    foreign key(sector_id) references sector(id)



)
    engine = InnoDB
    auto_increment = 1
    default charset = utf8
    comment '人员表'
;







