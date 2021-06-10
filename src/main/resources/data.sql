insert into roles(nombre) values("ROLE_ADMIN");
insert into roles(nombre) values("ROLE_USER");

insert into usuarios(correo,descripcion,edad,username,lastname,password,telefono) values("admin@email.com","admin","34","admin","admin","$2a$10$Mi8sk/DT8B9sEppFFsGS2.S8Odte/ouhAsGdG.bg1j.F2tEiKXSei",123456789);

insert into usuariorol(idrol,idusuario) values(1,1);