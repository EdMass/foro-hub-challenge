
create table usuarios(
    id bigint not null auto_increment,
    login varchar(100) not null,
    contrasena varchar(255) not null,

    primary key(id)
);