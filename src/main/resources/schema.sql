create table if not exists mufaza(
    id int primary key not null auto_increment,
    file_name varchar(255),
    content_type varchar(255),
    data binary
);

--create table if not exists mufaza (
--    id bigint identity primary key,
--    file_name varchar(255),
--    content_type varchar(255),
--    data binary
--);