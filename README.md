# Proyect_Cine_DB
proyect database 'cine', JAVA springboot course

Pasos para usar la base de datos(---METODO PROVICIONAL---):
-Crear una base de datos en MySQL workbench(u otro gestor), con el nombre: "cine_pruebas"
-Ejecutar la clase "public class OneToManyFind" para inicializar la base de datos
-Realizar los insert a las tablas en el siguiente orden:

1*
insert into cine_pruebas.actor (CodActor, FMuerte, FNacimiento, LMuerte, LNacimiento, Nacionalidad, Nombre)
values (1, NULL, '1955-01-18 00:00:00',null, 'Lywood, California', 'Estados Unidos', 'Kevin Costner'),
(2, NULL, '1929-10-21 00:00:00',null, 'Buenos Aires', 'Argentina', 'Héctor Alterio'),
(3, NULL, '1957-01-16 00:00:00',null, 'Buenos Aires', 'Argentina', 'Ricardo Darín'),
(4, NULL, '1958-10-20 00:00:00',null, 'Manhattan, New York', 'Estados Unidos', 'Viggo Mortensen'),
(5, NULL, '1977-07-01 00:00:00',null, 'Portland, Maine', 'Estados Unidos', 'Liv Tyler');

2*
insert into cine_pruebas.director (CodDirector, FMuerte, FNacimiento, LMuerte, LNacimiento, Nacionalidad, Nombre)
values (1, NULL, '1921-09-05 00:00:00',null, 'Madrid', 'España', 'Achero Mañas'),
       (2, NULL, '1951-09-25 00:00:00',null, 'Calzada de Calatrava', 'España', 'Pedro Almodóvar'),
       (3, NULL, '1972-03-31 00:00:00',null, 'Santiago de Chile', 'Chile','Alejandro Amenábar'),
       (4, NULL, '1965-07-17 00:00:00',null, 'Madrid', 'España', 'Santiago Segura'),
       (5, NULL, '1961-10-31 00:00:00',null, 'Pukerua Bay, North Isla', 'Nueva Zelanda', 'Peter Jackson');
       
3*
insert into cine_pruebas.pelicula (CodPelicula, Distribuidora, Duracion, FechaEstreno, Nacionalidad, Productora,
                                   Taquilla, Titulo, Anyo, Director, Genero)
values (1,'Manga Films S.L.',145,'2001-03-23 00:00:00','Estados Unidos','Beacon Pictures', 1103731.95, '31 dias','2000', 2, null),
       (2,'Alta Classics S.L.',124,'2001-11-23 00:00:00','España Argentina','Tornasol Films, S.A.', 7230415.69, 'El hijo de la novia','2001', 4, null),
       (5,'New Line Cinema',180,'2001-12-19 00:00:00','Nueva Zelanda','Wingnut Films', 31263314.97, 'El Señor de los Anillos. La Comunidad del Anillo','2001', 5, null),
       (6,'C.B. Fimls S.A.',108,'1946-12-19 00:00:00','Estados Unidos','Warner Bros Pictures', 318310.24, 'Casablanca','1942', 1, null),
       (7,'SOGEPAQ S.A.',105,'2004-09-03 00:00:00','España','SOGECINE', 21469765.482, 'Mar Adentro','2004', 3, null);

4*
insert into cine_pruebas.premio (CodPremio, Premio)
values (1,'Espiga de Plata'),(2,'Premio del Público'),(3,'Mejor Banda Sonora'),(4,'Mejor Fotografía'),(5,'Mejor Maquillaje y/o Peluqueria');

5*
insert into cine_pruebas.genero (CodGenero, Nombre, CodPelicula)
values (1, 'Drama', 1),
       (2, 'Crimen', 6),
       (3, 'Romance', 2),
       (4, 'Drama', 7),
       (5, 'Fantasia Medieval', 5);

6*
insert into cine_pruebas.ganapremio (Anyo, CodPremio, CodPelicula)
values (1950, 1, 6),
       (1942, 2, 6),
       (2001, 3, 5),
       (2001, 4, 5),
       (2001, 5, 5);

7*
insert into cine_pruebas.participa (CodPelicula, CodActor)
values (1, 1),(2, 3),(5, 4),(6, 2),(7, 5);

FIN
