--liquibase formatted sql
--changeset DVKarpov:create-tables

create TABLE public.specification
(id int4 NOT null,
twidth varchar,
heigh varchar,
construct varchar,
tdiameter varchar,
resindex varchar,
speedindex varchar,
abbs varchar,
runflat varchar,
camera varchar,
season varchar,
primary key (id));

create TABLE public.tiers
(id int4 NOT null,
brand varchar,
model varchar,
status varchar,
spec_id int,
primary key (id),
foreign key (spec_id) references public.specification(id));
