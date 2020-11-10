create database Biblioteca;
use Biblioteca;

create table libro (
idLibro int not null auto_increment,
nombre varchar(50),
idGenero int,
anioLanzamiento int,
idEditorial int,
sinopsis varchar(1000),
isbn varchar(50),
cantidad int,
idTipoLibro int,
edicion varchar(50),
costoCompra double,
costoVenta double,
idAutor int,
urlimagen varchar(50),
urlArchivo varchar(50),
borradoLogico int,
primary key(idLibro));

insert into libro(idLibro,nombre,idGenero,anioLanzamiento,idEditorial,sinopsis,isbn,cantidad,idTipoLibro,edicion,costoCompra,costoVenta,idAutor,urlimagen,urlArchivo,borradoLogico)
values
(1,"El Turno del Ofendido",1,1962,6,"Los poemas que integran El turno del ofendido reflejan con profundo lirismo el interés de Roque Dalton por temas sociales e históricos, al tiempo que critica mordazmente la historia salvadoreña. Afloran además, en este libro, poemas de alto contenido indigenista y religioso, en los que cabe advertir a ratos una postura anticlerical.",
"Pasillo 3",12,1," " ,12.3,16.99,1,"el_turno_del_ofendido.jpg","Libro/PDF/elturno.pdf",1),
(2,"La Llama Doble",1,1993,8,"La llama doble es un ensayo enteramente unitario que, por su importancia en el conjunto de la obra Octavio Paz, resulta comparable a títulos tan decisivos como El arco y la lira o El laberinto de la soledad.",
"Pasillo 6",9,1," " ,23.3,30.99,2,"llamad.jpg","Libro/PDF/llamadoble.pdf",1),
(3,"El Festival de las Blasfemia",4,2017,3,"Cuenta la historia de Melchor, un nigromante; alguien que mata a personas y manipula cadáveres con conocimientos ocultos. ¿Su objetivo? Conseguir una vida 'decente' cuando vaya al infierno. Él se verá sorprendido con una propuesta que podría situarlo en el lugar más envidiable del inframundo o condenarlo a tortura eterna.",
"Pasillo 5",50,1,"",15.99,21.99,8,"festivaldelablasfemia.jpg","Libros/PDF/elfestivaldelablasfemia.pdf",1),
(4,"El Principito",4,1943,2,"El principito es un cuento poético que viene acompañado de ilustraciones hechas con acuarelas por el mismo Saint-Exupéry​ En él, un piloto se encuentra perdido en el desierto del Sahara después de que su avión sufriera una avería, pero para su sorpresa, es allí donde conoce a un pequeño príncipe proveniente de otro planeta.",
"Pasillo  2",10,4,"",10.99,16.99,4,"el_principito.jpg","Libro/PDF/elprincipito.pdf",1),
(5,"Cien Sombras de Grey",6,2011,6,"Es una novela erótica de la autora británica E. L. James del año 2011. Narrada en gran medida en Seattle, es la primera entrega de una trilogía que describe la relación entre una recién graduada de la universidad, Anastasia Steele, y el joven magnate de negocios Christian Grey. Se destaca por sus escenas explícitamente eróticas, con elementos de las prácticas sexuales que involucran: bondage/disciplina, dominación/sumisión, sadismo/masoquismo",
"Pasillo 5",15,6,"",12.99,18.99,5,"cincuenta_sombras.jpg","Libro/PDF/cincuentasombras.pdf",1),
(6,"El Patito Feo",2,1843,4,"Cuando comienza la historia, los huevos de un pato madre nacen. Las otras aves y animales de la granja perciben a uno de los pajaritos como una pequeña criatura fea y sufre mucho abuso verbal y físico. Vaga tristemente desde el corral y vive con patos salvajes y gansos hasta que los cazadores matan a los rebaños. Encuentra un hogar con una anciana, pero su gato y su gallina se burlan de él y se burlan de él sin piedad y, una vez más, se marcha solo.",
"Pasillo 2",20,2,"",5.99,10.99,6,"patito_feo.jpg","Libro/PDF/elpatitofeo.pdf",1),
(7,"La Sirenita",2,1837,4,"La Sirenita vive en un reino submarino con su padre viudo (el rey del mar o Mer-King), su abuela viuda y sus cinco hermanas mayores, cada una de las cuales había nacido con un año de diferencia. Cuando una sirena cumple quince años, se le permite nadar a la superficie por primera vez para vislumbrar el mundo de arriba, y cuando las hermanas alcanzan la edad suficiente, cada una de ellas visita el mundo superior de una en una cada año. A medida que cada uno regresa, la Sirenita escucha con anhelo sus diversas descripciones del mundo habitado por los seres humanos.",
"Pasillo 2",25,2,"",6.99,9.99,6,"lasirenita.jpg","Libro/PDF/lasirenita.pdf",1),
(8,"La Niña de los Fosforos",2,1845,6,"En una congelada Nochevieja, una pobre joven, temblando y descalza, trata de vender fósforos en la calle. Temerosa de ir a casa porque su padre la golpeará por no vender ningún fósforo, ella se acurruca en el ángulo entre dos casas y enciende fósforos para calentarse.",
"Pasillo 2",13,1,"",8.99,12.99,6,"laniñadelosfosforos.jpg","Libro/PDF/laniñadelosfosforos.pdf",1),
(9,"Las Aventuras de Pinocho",2,1882,7,"El carpintero Geppetto es un humilde hombre que siempre había deseado tener un hijo. Un buen día se le ocurre la genial idea de tallar una marioneta de madera con la forma de un niño de verdad. Antes de estar terminada, esta cobra vida inesperadamente y se convierte en un niño travieso y desobediente al que Geppetto llama Pinocho.",
"Pasillo 2",15,1,"",5.99,10,7,"pinocho.jpg","Libros/PDF/lasaventurasdepinocho.pdf",1),
(10,"Cien Años de Soledad",2,1982,6,"Muchos años después, frente al pelotón de fusilamiento, el coronel Aureliano Buendía había de recordar aquella tarde remota en que su padre lo llevó a conocer el hielo. Macondo era entonces una aldea de veinte casas de barro y cañabrava construidas a la orilla de un río de aguas diáfanas que se precipitaban por un lecho de piedras pulidas, blancas y enormes como huevos prehistóricos. El mundo era tan reciente, que muchas cosas carecían de nombre, y para mencionarlas había que señalarlas con el dedo.",
"Pasillo 2",25,2," " ,15.1,19.35,3,"cien_años.jpg","Libro/PDF/ciensoledad.pdf",1),
(11,"Las Manos de Dios",3,2006,9,"En las cercanías del Puig, una pequeña elevación cercana a la ciudad de Játiva, son hallados los cadáveres, brutalmente mutilados, de una pareja de novios. Cuando Manuel Medina, un inspector de la policía nacional rudo, tosco y a punto de jubilarse, acude al lugar de los hechos, se encuentra con un panorama aterrador: el crimen ha sido llevado a cabo siguiendo un esquema concienzudo de ritualismo. La abundancia de elementos extraños en la escena (una crucifixión, una antigua inscripción, una carta de tarot representando a los amantes) no deja duda de que este atroz asesinato encierra mucho más de lo que puede verse a simple vista.",
"Pasillo 1",17,1,"",10.99,15.99,9,"lasmanosdedios.jpg","Libros/PDF/lasmanosdedios.pdf",1),
(12,"Ender's Game",4,1985,1,"En el futuro, la humanidad, habiendo comenzado a explorar el Universo y dominar los vuelos espaciales interplanetarios , se encuentra con una raza alienígena llamada los fórmicos, comúnmente conocidos en la serie como los insectores . El descubrimiento de una base de insecto en el asteroide Eros conduce a la guerra entre las especies que los humanos ganan por poco, lo que resulta en el descubrimiento de tecnología alienígena avanzada, incluida la manipulación de la gravedad. Aparentemente en preparación para otra invasión de insectores, se establece una Flota Internacional (FI) en la Tierra, que crea una Escuela de Batalla en la órbita de la Tierra para desarrollar niños dotados en comandantes capaces de derrotar a los insectores en la próxima guerra",
"Pasillo 6",9,2,"",13.99,18.99,10,"endergame.jpg","Libros/PDF/ender'sgame/pdf",1),
(13,"Altered Carbon",4,2002,6,"En el futuro, los humanos han logrado la inmortalidad virtual. La mayoría de las personas tienen pilas corticales en sus columnas espinales que almacenan su conciencia. Si su cuerpo muere, su pila puede almacenarse indefinidamente. Sus pilas se pueden descargar en nuevos cuerpos, o mangas, después de la muerte. católicos romanosno permita que sus pilas se vuelvan a poner después de la muerte, ya que creen que el alma irá al Cielo cuando mueran, por lo que no pasarán a la nueva manga. Esto hace que los católicos sean blancos fáciles de asesinato, ya que los asesinos saben que su víctima no puede volver a encerrarse para testificar. Al comienzo de la novela, se está debatiendo la Resolución 653 de la ONU. Esta propuesta revierte el precedente y permitiría a las autoridades volver a proteger temporalmente a una mujer católica fallecida para testificar en un juicio por asesinato. La ley de la ONU prohíbe estrictamente el uso de mangas dobles o el control de dos cuerpos con una sola personalidad.",
"Pasillo 6",20,2,"",12.99,16.99,11,"alteredcarbon.jpg","Libros/PDF/altered carbo.PDF",1),
(14,"The Player Of Games",4,1988,4,"Jernau Morat Gurgeh, un famoso jugador hábil de juegos de mesa y otros concursos similares, vive en Chiark Orbital y está aburrido de su exitosa vida. La Cultura 's Circunstancias Especiales indaga sobre su voluntad de participar en un viaje largo, aunque no explicará más a menos Gurgeh de acuerdo en participar. Mientras está considerando esta oferta, uno de sus aviones no tripuladosamigos, Mawhrin-Skel, que había sido expulsado de las circunstancias especiales debido a su personalidad inestable, lo convence de hacer trampa en uno de sus partidos en un intento de ganar de una manera perfecta sin precedentes.",
"Pasillo 6",10,1,"",9.99,13.99,12,"theplayerofgames.jpg","Libros/PDF/The player of games.pdf",1),
(15,"Ernec",5,1185,13,"Erec cuenta la historia de cómo Erec , un caballero en la corte del Rey Arturo , gana la mano de la bella Enite, pero luego, por excesiva devoción a su esposa, descuida sus deberes como caballero y señor. Al darse cuenta de su error, sale de la corte en una serie de aventuras cada vez más desafiantes en las que pone a prueba la lealtad de Enite y obtiene una idea del propósito de la caballería .",
"Pasillo 3",8,1,"",2.99,6.99,13,"erec.jpg","Libros/PDF/erec.pdf",1);
	


create table editorial(
idEditorial int not null auto_increment,
nombre varchar(50),
idPais int,
borradoLogico int,
primary key(idEditorial));

insert into editorial(idEditorial,nombre,idPais,borradoLogico)
values
(1,"Alire",6,1),	
(2,"Mosaic Press",6,1),
(3,"Future Horizons",3,1),
(4,"Universidad del Valle de Guatemala",5,1),
(5,"Editorial Monserrat",5,1),
(6,"Nova Casa",2,1),
(7,"Anama Ediciones",6,1),
(8,"Alfaomega Grupo Editor",6,1),
(9,"Tragaluz Editores S.A.",18,1),
(10,"The University of the West Indies Press",2,1),
(11,"Editorial Alfa",18,1),
(12,"ManuPax Editores",23,1),
(13,"Naïve",36,1),
(14,"Nouvelle Maison",36,1),
(15,"Editorial Omega",23,1),
(16,"Full Editor",25,1),
(17,"Néa Gi Editor",25,1),
(18,"Gute Sicht",9,1),
(19,"Gut Zu Lesen",9,1),
(20,"God Læsning",37,1),
(21,"Visdom",37,1),
(22,"ReadGood Editor",38,1),
(23,"Good to know Editor",38,1),
(24,"Buono Sapersi",39,1),
(25,"Saggezza",39,1),
(26,"Editorial Chavez",35,1),
(27,"Editorial Maduro",35,1);





create table tipoLibro(
idTipoLibro int auto_increment,
tipo varchar(50),
borradoLogico int,
primary key(idTipoLibro));

insert into tipoLibro(idTipoLibro,tipo,borradoLogico)
values
(1,"Digital",1),
(2,"Fisico",1);



create table prestamo(
idPrestamo int not null auto_increment,
inicio date,
fin date,
estado boolean,
idSolicitud int,
borradoLogico int,
primary key(idPrestamo));

create table solicitudPrestamo(
idSolicitud int not null auto_increment,
idCliente int,
idLibro int,
fecha date,
borradoLogico int,
primary key(idSolicitud));


create table penalizacion(
idPenalizacion int not null,
cantidad float,
motivo varchar(50),
idCliente int,
idPrestamo int,
borradoLogico int,
primary key(idPenalizacion)
);

create table cliente(
idCliente int not null auto_increment,
nombre varchar(50),
apellido varchar(50),
direccion varchar(100),
idPais int,
idUsuario int,
borradoLogico int,
primary key(idCliente));

insert into cliente(idCliente,nombre,apellido,direccion,idPais,idUsuario,borradoLogico)
value
(1,"User","Cliente","San Salvador",7,4,1),
(2,"Jimmy","Jocsan","La Libertad",3,5,1),
(3,"Leonardo","Tadeo","San Jose",9,6,1),
(4,"Rocio","Miranda","San vicente",7,8,1),
(5,"Francisco","Hernandez","Sonsonate",7,7,1),
(6,"Ronald","Erazo","Ciudad Delgado",7,10,1),
(7,"Alexander","Valladares","jayaque",7,9,1),
(8,"Edgardo","Martinez","San miguel",7,2,1),
(9,"Nelson","Martinez","San vicente",7,12,1),
(10,"Jacinto","Molina","San salvador",7,13,1);




create table pais(
idPais int not null auto_increment,
nombre varchar(50),
borradoLogico int,
primary key(idPais));


insert into pais(idPais,nombre,borradoLogico)
values
(1,"Canada",1),
(2,"Estados Unidos",1),
(3,"Mexico",1),
(4,"Escosia",1),
(5,"Guatemala",1),
(6,"Honduras",1),
(7,"El Salvador",1),
(9,"Alemania",1),
(10,"Panama",1),
(11,"Colombia",1),
(12,"Brasil",1),
(13,"Argentina",1),
(14,"Perú",1),
(15,"Bolivia",1),
(16,"Chile",1),
(17,"Paraguay",1),
(18,"Mexico",1),
(19,"Guyana",1),
(20,"Uruguay",1),
(21,"Surinam",1),
(22,"Trinidad y Tobago",1),
(23,"España",1),
(24,"Republica Dominicana",1),
(25,"Grecia",1),
(26,"Barbados",1),
(27,"Dominica",1),
(28,"Haití",1),
(29,"Jamaica",1),
(30,"Antigua y Barbuda",1),
(31,"Granada",1),
(32,"Santa Lucia",1),
(33,"San Cristobal y Nieves",1),
(34,"San Vicente y las Granadinas",1),
(35,"Venezuela",1),
(36,"Francia",1),
(37,"Dinamarca",1),
(38,"Inglaterra",1),
(39,"Italia",1);



create table empleado(
idEmpleado int not null auto_increment,
nombre varchar(50),
apellido varchar(50),
direccion varchar(50),
dui varchar(10),
nit varchar(20),
afp varchar(15),
isss varchar(15),
idUsuario int,
borradoLogico int,
primary key(idEmpleado));


insert into empleado(idEmpleado,nombre,apellido,direccion,dui,nit,afp,isss,idUsuario,borradoLogico)
values
(1,"Francisco Edgardo","Hernandez Palacios","Santa Tecla","05153578-5","0507-141098-101-1","012884254415","106912364",2,1),
(2,"Denis Alexander","Valladares Escobar","San Sanvador","00257832-9","0254-241099-332-2","068795412357","587641357",3,1),
(3,"Steven Ronald","Valecia Escobar","San Sanvador","00257782-1","0254-335099-335-2","068795588784","587641358",14,1),
(4,"Ronald Josue","Valladares Martinez","San Vicente","00255897-9","0254-247895-372-2","068795417934","587641359",15,1),
(5,"Rocio Stephanie","Villanueva Munguia","San Miguel","00257946-8","0254-243470-338-2","068795415486","587641397",16,1),
(6,"Alexander Ezequiel","Escobar Erazo","San Sanvador","00256791-7","0254-244848-375-2","068795417796","587641577",17,1),
(7,"Nelson Alexis","Valladares Gallardo","San Jacinto","00257346-9","0254-247897-392-2","068795419725","587649754",18,1),
(8,"Jimmy emmanuel","Santos Escobar","San Sanvador","00278965-1","0254-278645-489-2","068795419751","587641313",19,1),
(9,"Yanci Elizabeth","Hernandez Escobar","Santas Tecla","00257832-9","0254-241099-332-2","068795497456","587631048",20,1),
(10,"Adonay Mauricio","Valelcia Fernandez","San Martin","00976425-9","0274-783156-978-2","068795761348","587647964",21,1);


create table usuarios
(
id int(11) not null primary key auto_increment,
usuario varchar(45) not null,
password varchar(45) not null,
correo varchar(45) not null,
borradoLogico int,
id_tipo int(11)
);


insert into usuarios values(1,"Administrador",Sha1("12345"),"admin@mail.com",1,1);
insert into usuarios values(2,"Edgardo",Sha1("123456"),"edgard@mail.com",1,2);
insert into usuarios values(3,"Denis",Sha1("123456"),"denis@mail.com",1,2);
insert into usuarios values(4,"User",Sha1("123456"),"user@mail.com",1,3);
insert into usuarios values(5,"Jocsan",Sha1("123456"),"jocsan@mail.com",1,3);
insert into usuarios values(6,"Tadeo",Sha1("123456"),"tadeo@mail.com",1,3);
insert into usuarios values(7,"Francisco",sha1("123456"),"Francisco99@mail.com",1,3);
insert into usuarios values(8,"Rocio",sha1("123456"),"Rocio@mail.com",1,3);
insert into usuarios values(9,"Alexander",sha1("123456"),"Alexander@mail.com",1,3);
insert into usuarios values(10,"Ronald",sha1("123456"),"Ronald@mail.com",1,3);
insert into usuarios values(11,"Steven",sha1("123456"),"Steven@mail.com",1,3);
insert into usuarios values(12,"Nelson",sha1("123456"),"Nelson@mail.com",1,3);
insert into usuarios values(13,"Jacinto",sha1("123456"),"Jacinto@mail.com",1,3);
insert into usuarios values(14,"Steven",sha1("123456"),"Steven@mail.com",1,2);
insert into usuarios values(15,"Ronald",sha1("123456"),"RonaldEmpleado@mail.com",1,2);
insert into usuarios values(16,"Rocio",sha1("123456"),"RocioEmpleado@mail.com",1,2);
insert into usuarios values(17,"Alexander",sha1("123456"),"AlexanderEmpleado@mail.com",1,2);
insert into usuarios values(18,"Nelson",sha1("123456"),"NelsonEmpleado@mail.com",1,2);
insert into usuarios values(19,"Jimmy",sha1("123456"),"JimmyEmpleado@mail.com",1,2);
insert into usuarios values(20,"Yanci",sha1("123456"),"YanciEmpleado@mail.com",1,2);
insert into usuarios values(21,"Adonay",sha1("123456"),"AdonayEmpleado@mail.com",1,2);




create table tipo_usuario
(
id int(11) not null primary key auto_increment,
nombre varchar(45) not null);

insert into tipo_usuario values(1,"Administrador");
insert into tipo_usuario values(2,"Empleado");
insert into tipo_usuario values(3,"Cliente");

create table venta(
idVenta int not null auto_increment,
idCliente int,
idLibro int,
fecha date,
cantidad int,
totalPagar float,
idDetalleEnvio int,
idEstadoVenta int,
borradoLogico int,
primary key(idVenta));

create table envio(
idEnvio int not null auto_increment,
costoEnvio double,
destino varchar(100),
borradoLogico int,
primary key(idEnvio));

insert into envio values (1,"2.99","El salvador",1);
insert into envio values (2,"5.99","San miguel",1);

create table detalleEnvio(
idDetalleEnvio int not null auto_increment,
idEnvio int,
idCompra int,
idEstadoEnvio int,
tiempoEnvio varchar(15),
borradoLogico int,
primary key(idDetalleEnvio));


create table estadoEnvio(
idEstadoEnvio int auto_increment,
nombreEstado varchar(50),
borradoLogico int,
primary key(idEstadoEnvio));


insert into estadoEnvio(idEstadoEnvio,nombreEstado,borradoLogico)
values
(1,"En Proceso de Envio",1),
(2,"Envaido",1),
(3,"Entregado",1),
(4,"Cancelado",1);


create table compra(
idCompra int auto_increment,
idEmpleado int,
idEditorial int,
fecha date,
cantidad int,
totalPagar double,
borradoLogico int,
primary key(idCompra));

create table membresia(
idMembresia int auto_increment,
fecha date,
duracion varchar(50),
idCliente int,
idTipoMembresia int,
borradoLogico int,
primary key(idMembresia));

create table tipoMembresia(
idTipoMembresia int primary key auto_increment,
nombre varchar(50)
);

insert into tipoMembresia values (1,"Premium");
insert into tipoMembresia values (2,"Estandar");

create table club(
idClub int auto_increment,
nombre varchar(50),
borradoLogico int,
primary key(idClub));

insert into club values(1,"Platino",1);
insert into club values(2,"Plata",1);
insert into club values(3,"Bronce",1);
insert into club values(4,"Oro",1);
insert into club values(5,"Bronce",1);
insert into club values(6,"Diamante",1);
insert into club values(7,"Cobre",1);
insert into club values(8,"Rubi",1);
insert into club values(9,"Perla",1);
insert into club values(10,"Esmeralda",1);

create table detalleClubCliente(
idDetalle  int primary key auto_increment,
idCliente int,
idClub int
);

create table oferta(
idOferta int auto_increment,
idClub int,
idEmpleado int,
nombre varchar(50),
descuento varchar(10),
borradoLogico int,
primary key(idOferta));

insert into oferta values (1,1,1,"Cliente Platino","17%",2);
insert into oferta values (2,6,2,"Cliente Diamante","15%",2);
insert into oferta values (3,8,3,"Cliente Rubi","14%",1);
insert into oferta values (4,4,4,"Cliente Oro","13%",1);
insert into oferta values (5,2,5,"Cliente Plata","10%",1);


create table notificacion(
idNotificacion int auto_increment,
idOferta int,
estado boolean,
borradoLogico int,
primary key(idNotificacion));

create table autor(
idAutor int auto_increment not null,
nombre varchar(50),
sexo varchar(50),
fechaNacimiento int,
fechaDefuncion int,
idGenero int,
idPais int,
biografia varchar(2000),
imagen varchar(100),
borradoLogico int,
primary key (idAutor));

insert into autor(idAutor,nombre,sexo,fechaNacimiento,fechaDefuncion,idGenero,idPais,biografia,imagen,borradoLogico)
values
(1,"Roque Dalton","Masculino",1935,1975,5,7,"Gabriel García Márquez nació en Aracataca (Colombia) el 6 de marzo de 1927. Sus padres fueron Gabriel García  y Luisa Márquez.
Estudió Derecho en la Universidad Nacional de Colombia, pero lo abandonó para dedicarse al periodismo y la literatura.
En 1955, publicó La hojarasca, su primer novela. En 1961, se instaló en Ciudad de México. El mismo año publicó El coronel no tiene quien le escriba y al año siguiente Los funerales de Mamá Grande. En 1967, mandó publicar en Buenos Aires Cien años de soledad, la obra que lo consagró a nivel mundial. En 1972, ganó el Premio Rómulo Gallegos y en 1982, el Premio Nobel de Literatura.
Otras grandes obras suyas son El otoño del patriarca (1975), Crónica de una muerte anunciada (1981), El amor en los tiempos del cólera (1985) y Noticia de un secuestro (1996). Sus memorias fueron publicadas en 2002 con el título de Vivir para contarla.
En sus últimos años padeció de cáncer linfático, mal que provocó su muerte el 17 de abril de 2014, en Ciudad de México.","Roque_Dalton.jpg",1), 
(2,"Octavio Paz","Masculino",1914,1998,4,3,"Octavio Irineo Paz Lozano (Ciudad de México, 31 de marzo de 1914-Ib., 19 de abril de 1998) fue un poeta, ensayista y diplomático mexicano, Premio Nobel de Literatura en 1990. Se le considera uno de los más influyentes escritores del siglo XX y uno de los grandes poetas hispanos de todos los tiempos.​ Su extensa obra abarcó géneros diversos, entre los que sobresalieron poemas, ensayos y traducciones.
Paz fue introducido a la literatura a una edad temprana gracias a la biblioteca de su abuelo. Hijo y nieto de periodistas políticos, siguió la tradición familiar y se convirtió en escritor, publicando su primer volumen de poesía, Luna silvestre, en 1933. Paz también fue un hábil editor y ayudó a fundar una revista literaria llamada Taller en 1938. Entró en el servicio diplomático en 1945 y más tarde fue nombrado Embajador de México en la India, posición que ocupó de 1962 a 1968. Paz renunció en protesta por el manejo del gobierno mexicano de manifestaciones estudiantiles durante los Juegos Olímpicos
Maestro tanto en la poesía como en la prosa, Paz  desarrolló ambos géneros durante toda su vida. Poesía como «Piedra de sol (1957), y las obras críticas y analíticas, como El Laberinto de la soledad (1950), consolidaron su reputación de maestro del lenguaje y de intelecto agudo. Produjo más de 30 libros y colecciones de poesía en su vida. Paz recibió numerosos premios por su trabajo, incluyendo el Premio Nobel de Literatura en 1990. Murió el 19 de abril de 1998, en la Ciudad de México, México.","paz_octavio_1.jpg",1), 
(3,"Iain  Banks","Masculino",1954,2013,4,4,"fue un autor escocés. Él escribió la ficción convencional bajo el nombre de Iain Banks y la ciencia ficción como Iain M. Banks , incluyendo la inicial de su segundo nombre adoptado Menzies,Después de la publicación y el éxito de The Wasp Factory (1984), Banks comenzó a escribir a tiempo completo. Su primer libro de ciencia ficción, Considere Phlebas , fue lanzado en 1987, marcando el comienzo de la serie Cultura . Sus libros han sido adaptados para teatro, radio y televisión. En 2008, The Times nombró a Banks en su lista de Los 50 mejores escritores británicos desde 1945.  En abril de 2013, Banks anunció que tenía cáncer inoperable y que era poco probable que viviera más de un año.  Murió el 9 de junio de 2013. ",
"iainbanks.jpg",1),
(4,"Antoine de Saint-Exupéry","Masculino",1900,1944,2,36,"Antonie de Saint-Exupery fue un escritor y aviador frances, El 29 de junio de 1900 nació el novelista y aviador francés Antoine de Saint-Exupéry. Desde muy pequeño manifestó interés por la aviación y aprendió el oficio cuando prestó servicio militar.
En 1926 publicó su primera novela breve, El aviador, y obtuvo un contrato como piloto para una agencia privada. Se desempeñó como jefe de estación aérea en el Sahara español y en ese período escribió su segunda novela, Correo del Sur (1929). En los años 30 realizó adaptaciones cinematográficas y otras actividades."
,"antoniesaint.jpg",1),
(5,"Erika Leonard Mitchel","Fememina",1963,"",6,38,"nació el 7 de marzo de 1963, de madre de origen chileno y padre escocés, un camarógrafo de la BBC.7​8 ​Criada en Buckinghamshire, y con una educación privada, James estudió historia en la Universidad de Kent, antes de convertirse en asistente de un director de los estudios del National Film and Television School, en Beaconsfield
Mitchell había trabajado como ejecutiva de televisión.10​Vive en el oeste de Londres con su esposo, el guionista Niall Leonard, y sus dos hijos adolescentes, desde hace más de 20 años.
Durante un tiempo utilizó el apellido de su marido, Erika Leonard.","erikamitchel.jpg",1),
(6,"Hans Christian Andersen ","Masculino",1805,1875,2,37,"fue un autor danés. Aunque es un prolífico escritor de obras de teatro, diarios de viaje , novelas y poemas, es mejor recordado por sus cuentos de hadas . La popularidad de Andersen no se limita a los niños; Sus historias expresan temas que trascienden la edad y la nacionalidad."
,"hanschristian.jpg",1),
(7,"Carlo Collodi","Masculino",1823,1890,1,39,"mejor conocido por el seudónimo Carlo Collodi fue un autor, humorista y periodista italiano ampliamente conocido por su novela de cuento de hadas Las aventuras de Pinocho,Collodi nació en Florencia el 24 de noviembre de 1826. Su madre Angiolina Orzali era costurera de la ciudad de Collodi de la que tomó el seudónimo y su padre, Domenico Lorenzini, era cocinero y ambos trabajaban para el marqués Ginori Lisci.  Collodi era el mayor de la familia  y tenía 10 hermanos, pero siete murieron a una edad temprana. Pasó la mayor parte de su infancia en la ciudad de Collodi, donde nació su madre. Vivía allí con su abuela. Después de asistir a la escuela primaria, fue enviado a estudiar en un seminario llamado Colle Val d'Elsa.",
"carlocollodi.jpg",1),
(8,"Angel david revilla","Masculino",1982,"",4,35,"mejor conocido como Dross Rotzank , es un YouTuber y escritor venezolano que actualmente reside en Buenos Aires, Argentina.Revilla comenzó su carrera escribiendo reseñas de juegos para sitios web como Meristation y GameFAQs, pero rápidamente pasó a crear contenido de blog en El Diario de Dross, donde exploró temas provocativos usando una receta distintiva de narración de cuentos y humor negro.",
"angeldavid.jpg",1),
(9,"Joaquin Cerda Boluda","Masculino",1975,"",3,23,"es un profesor, científico, escritor, ilustrador y divulgador español.Ingeniero de Telecomunicaciones desde el año 1999, en el año 2000 se incorpora como profesor titular de la Escuela Técnica Superior de Ingenieros de Telecomunicación de la Universidad Politécnica de Valencia, donde alternaría sus obligaciones docentes con su actividad investigadora. Paralelamente, obtiene el título de Doctor en Electrónica por la Universidad Politécnica de Valencia en 2004 y, más tarde, el de Licenciado en Ciencias físicas por la UNED en 2008. En el campo de la investigación, ha realizado aportaciones en la técnica de la Tomografía por Emisión de Positrones (PET), los Autómatas Celulares y, más recientemente, en Física Cuántica y Computación Cuántica.",
"joaquincerda.jpg",1),
(10,"Orson Scott Card","Masculino",1921,"",4,2,"crítico, orador, ensayista y columnista estadounidense. Escribe en varios géneros, pero es mejor conocido por la ciencia ficción . Su novela Ender's Game (1985) y su secuela.",
"orsonscott.jpg",1),
(11,"Richard K.Morgan","Masculino",1965,"",4,38,"Nacido en Londres y criado en el pueblo de Hethersett , cerca de Norwich , Morgan estudió historia en el Queens 'College de Cambridge . Después de graduarse, comenzó a enseñar inglés para viajar por el mundo. Después de 14 años y un puesto en la Universidad de Strathclyde , su primera novela fue publicada y se convirtió en escritor a tiempo completo.",
"RichardMorgan.jpg",1),
(12,"Gabriel García Márquez","Masculino",1927,2014,2,11,"Roque Dalton fue un poeta, ensayista, narrador, dramaturgo, periodista y revolucionario salvadoreño que nació el 14 de mayo de 1935 en Quezaltepeque, San Salvador.
Dalton cursó sus primeros estudios en algunos colegios religiosos luego ingresó al Externado de San José, donde en 1953 obtuvo el título de bachiller.
Sus estudios superiores los realizó en México y Chile, pero terminaría regresando a El Salvador a concluirlos. Desde muy joven se dedicó al periodismo y a la literatura, participando en certámenes nacionales y centroamericanos donde obtuvo reconocimientos. Sus primeros poemas los publicó en la revista Hoja y en Diario Latino.
Fue uno de los partícipes de la renovación de la lírica latinoamericana de la década de 1960.
Fue miembro del Circulo Literario Universitario junto con Otto René Castillo, Manlio Argueta, Roberto Armijo y Alfonso Quijada, entre otros, obtuvo en tres ocasiones el Premio Centroamericano de Poesía y el Premio Casa de las Américas por Taberna y otros lugares, considerado como su mejor libro de poemas.A los 22 años Roque Dalton ingresó en el Partido Comunista Salvadoreño. Curiosamente su actividad literaria corre paralela a la militancia revolucionaria y el reconocimiento de su valía como escritor coincide a su vez con las primeras encarcelaciones y exilios en Guatemala, México, Cuba, Checoslovaquia, Corea, Vietnam del Norte y otros países.
Más tarde se convirtió en el fundador del Ejercito Revolucionario del Pueblo (ERP), una base importante para lo que luego sería la guerrilla salvadoreña.
Murió asesinado el 10 de Mayo de 1975, por  sus propios compañeros de esa organización que había fundado.","gabrielgarciamarquez12.jpg",1),
(13,"Hartmann Von Aue","Masculino",1160,1220,1,9,"fue un caballero y poeta alemán . Con sus obras que incluyen Erec , Iwein , Gregorius y Der arme Heinrich , introdujo el romance cortés en la literatura alemana y, con Wolfram von Eschenbach y Gottfried von Strassburg , fue uno de los tres grandes poetas épicos de la literatura alemana de la Alta y Media .",
"hartmannvonaue.jpg",1),
(14,"Homero","Masculino",1800,1900,5,25,"Homero fue un poeta de la Antigua Grecia que nació y vivió en el siglo VIII a.C. Es autor de dos de las principales obras de la antigüedad: Los poemas épicos La Ilíada y La Odisea.",
"homero.jpg",1),
(15,"William Shakespeare","Masculino",1564,1616,5,1,"fue un poeta, dramaturgo y actor inglés, ampliamente considerado como el mejor escritor en inglés y el mejor dramaturgo del mundo. A menudo se le llama poeta nacional de Inglaterra y el Bardo de Avon (o simplemente el Bardo)",
"shakespeare.jpg",1);














create table genero(
idGenero int auto_increment not null,
nombre varchar(50),
descripcion varchar(255),
primary key(idGenero));


insert into genero(idGenero,nombre,descripcion)
values
(1,"Poesia","Composición literaria que se concibe como expresión artística de la belleza por medio de la palabra,en especial aquella que está sujeta a la medida y cadencia del verso."),
(2,"Fantasia"," Un género narrativo basado sobre todo en los elementos de fantasía, dentro del cual se pueden agrupar varios subgéneros, entre los que están la literatura de terror, ciencia ficción o la literatura gótica."),
(3,"Religiosa","Es la literatura de tema religioso, o bien la parte del arte religioso que se expresa literariamente. Su opuesto es la literatura profana."),
(4,"Ciencia Ficcion","Es la denominación de uno de los géneros derivados de la literatura de ficción, junto con la literatura fantástica y la narrativa de terror."),
(5,"Medieval","Es toda aquella que fue producida durante la Edad Media, periodo que se extendió desde el siglo V hasta el siglo XV aproximadamente."),
(6,"Erotica","La literatura erótica comprende historias ficticias y fácticas y relatos de eros (relaciones apasionadas, románticas o sexuales) destinadas a despertar sentimientos similares en los lectores, en contraste con la erótica , que se centra más específicamente en los sentimientos sexuales.");
use Biblioteca;
alter table libro add constraint fkLibroEditorial foreign key(idEditorial) references editorial (idEditorial) on update cascade on delete no action;
alter table libro add constraint fkLibroGenero foreign key(idGenero) references genero(idGenero) on update cascade on delete no action;    

/*alter table libro add constraint fkLibroTipoLibro foreign key(idTipoLibro) references tipoLibro(idTipoLibro) on update cascade on delete no action;*/

alter table prestamo add constraint fkPrestamoSolicitudPrestamo foreign key(idSolicitud) references solicitudPrestamo(idSolicitud) on update cascade on delete no action;
alter table solicitudPrestamo add constraint fkSolicitudPrestamoCliente foreign key(idCliente) references cliente(idCliente) on update cascade on delete no action;
alter table solicitudPrestamo add constraint fkSolicitudPrestamoLibro foreign key(idLibro) references libro(idLibro) on update cascade on delete no action;
alter table penalizacion add constraint fkPenalizacionCliente foreign key(idCliente) references cliente (idCliente) on update cascade on delete no action;
alter table penalizacion add constraint fkPenalizacionPrestamo foreign key(idPrestamo) references prestamo (idPrestamo) on update cascade on delete no action;
alter table cliente add constraint fkClienteUsuario foreign key(idUsuario) references usuarios(id)  on update cascade on delete no action;
alter table empleado add constraint fkEmpleadoUsuario foreign key(idUsuario) references usuarios(id);
alter table cliente add constraint fkClientePais foreign key(idPais) references pais(idPais) on update cascade on delete no action;
alter table detalleEnvio add constraint fkDetalleEnvioCompra foreign key(idCompra) references compra(idCompra) on update cascade on delete no action;
alter table detalleEnvio add constraint fkDetalleEnvioEnvio foreign key(idEnvio) references envio(idEnvio) on update cascade on delete no action;
alter table detalleEnvio add constraint fkDetalleEnvioEstadoEnvio foreign key(idEstadoEnvio) references estadoEnvio(idEstadoEnvio) on update cascade on delete no action;
alter table compra add constraint fkCompraEmpleado foreign key(idEmpleado) references empleado(idEmpleado) on update cascade on delete no action;
alter table compra add constraint fkCompraEditorial foreign key(idEditorial) references editorial(idEditorial) on update cascade on delete no action;
alter table membresia add constraint fkMembresiaCliente foreign key(idCliente) references cliente(idCliente) on update cascade on delete no action;
alter table membresia add constraint fkMembresiaTipo foreign key(idTipoMembresia) references tipoMembresia(idTipoMembresia) on update cascade on delete no action;
alter table oferta add constraint fkOfertaClub foreign key(idOferta) references club(idClub)  on update cascade on delete no action;
alter table oferta add constraint fkOfertaEmpleado foreign key(idEmpleado) references empleado(idEmpleado) on update cascade on delete no action;
alter table notificacion add constraint fkNotificacionOferta foreign key(idOferta) references oferta(idOferta) on update cascade on delete no action;
alter table usuarios add constraint fkTipoUsuario foreign key(id_tipo) references tipo_usuario(id) on update cascade on delete no action;
alter table venta add constraint fkVentaCliente foreign key(idCliente) references cliente(idCliente) on update cascade on delete no action;
alter table venta add constraint fkVentalibro foreign key(idLibro) references libro(idLibro) on update cascade on delete no action;

/*alter table autor add constraint fkautorGenero foreign key(idAutor) references genero(idGenero);*/

alter table libro add constraint fkLibroAutor foreign key(idAutor) references autor(idAutor);
alter table editorial add constraint fkEditorialPais foreign key(idPais) references pais(idPais);
alter table detalleClubCliente add constraint fkdetalleClub foreign key(idClub) references club(idClub);
alter table detalleClubCliente add constraint fkdetalleCliente foreign key(idCliente) references cliente(idCliente);


/* alter table autor add constraint fkAutorPais foreign key(idAutor) references pais(idPais);*/


SELECT * from club LIMIT 3

insert into detalleClubCliente (idCliente,idClub)value (1,1);	