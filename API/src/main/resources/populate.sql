/*
Populate
 */

/* INSERTS ONLY FOR TEST, TO BE REMOVED AFTER TESTS */
insert into `users` values (null,'inspector','inspector','inspector@test.com',1);
insert into `users` values(null,'test','test','test@test.com',2);
INSERT INTO `users` (`id`, `username`, `password`, `email`, `role`) VALUES
(10, 'Pedro', '$SHA$20bfbd768f311eb5$622ccb5532f2568896c58a56130cdb921298585b6d5e7b0efd17be12c5fbfbed', 'pedro@test.com', 2);

insert into `trains` values(null,20,'Large');
insert into `trains` values(null,15,'Medium');
insert into `trains` values(null,25,'Extra Large');
insert into `trains` values(null,10,'Small');

insert into `seats` values(null,'A1',1);
insert into `seats` values(null,'A2',1);
insert into `seats` values(null,'A3',1);
insert into `seats` values(null,'A4',1);
insert into `seats` values(null,'A5',1);
insert into `seats` values(null,'B1',1);
insert into `seats` values(null,'B2',1);
insert into `seats` values(null,'B3',1);
insert into `seats` values(null,'B4',1);
insert into `seats` values(null,'B5',1);
insert into `seats` values(null,'C1',1);
insert into `seats` values(null,'C2',1);
insert into `seats` values(null,'C3',1);
insert into `seats` values(null,'C4',1);
insert into `seats` values(null,'C5',1);
insert into `seats` values(null,'D1',1);
insert into `seats` values(null,'D2',1);
insert into `seats` values(null,'D3',1);
insert into `seats` values(null,'D4',1);
insert into `seats` values(null,'D5',1);
insert into `seats` values(null,'A1',2);
insert into `seats` values(null,'A2',2);
insert into `seats` values(null,'A3',2);
insert into `seats` values(null,'A4',2);
insert into `seats` values(null,'A5',2);
insert into `seats` values(null,'B1',2);
insert into `seats` values(null,'B2',2);
insert into `seats` values(null,'B3',2);
insert into `seats` values(null,'B4',2);
insert into `seats` values(null,'B5',2);
insert into `seats` values(null,'C1',2);
insert into `seats` values(null,'C2',2);
insert into `seats` values(null,'C3',2);
insert into `seats` values(null,'C4',2);
insert into `seats` values(null,'C5',2);
insert into `seats` values(null,'A1',3);
insert into `seats` values(null,'A2',3);
insert into `seats` values(null,'A3',3);
insert into `seats` values(null,'A4',3);
insert into `seats` values(null,'A5',3);
insert into `seats` values(null,'B1',3);
insert into `seats` values(null,'B2',3);
insert into `seats` values(null,'B3',3);
insert into `seats` values(null,'B4',3);
insert into `seats` values(null,'B5',3);
insert into `seats` values(null,'C1',3);
insert into `seats` values(null,'C2',3);
insert into `seats` values(null,'C3',3);
insert into `seats` values(null,'C4',3);
insert into `seats` values(null,'C5',3);
insert into `seats` values(null,'D1',3);
insert into `seats` values(null,'D2',3);
insert into `seats` values(null,'D3',3);
insert into `seats` values(null,'D4',3);
insert into `seats` values(null,'D5',3);
insert into `seats` values(null,'E1',3);
insert into `seats` values(null,'E2',3);
insert into `seats` values(null,'E3',3);
insert into `seats` values(null,'E4',3);
insert into `seats` values(null,'E5',3);
insert into `seats` values(null,'A1',4);
insert into `seats` values(null,'A2',4);
insert into `seats` values(null,'A3',4);
insert into `seats` values(null,'A4',4);
insert into `seats` values(null,'A5',4);
insert into `seats` values(null,'B1',4);
insert into `seats` values(null,'B2',4);
insert into `seats` values(null,'B3',4);
insert into `seats` values(null,'B4',4);
insert into `seats` values(null,'B5',4);

insert into `stations` values(null,'Porto São Bento',1);
insert into `stations` values(null,'Caide',2);
insert into `stations` values(null,'Régua',3);
insert into `stations` values(null,'Tua',4);
insert into `stations` values(null,'Pocinho',5);

insert into `trips` values(null,'Morning trip','Pocinho','Positive',1);
insert into `trips` values(null,'Noon trip','Pocinho','Positive',2);
insert into `trips` values(null,'After-noon trip','Pocinho','Positive',3);
insert into `trips` values(null,'Night trip','Pocinho','Positive',4);
insert into `trips` values(null,'Morning trip','Porto','Negative',1);
insert into `trips` values(null,'Noon trip','Porto','Negative',2);
insert into `trips` values(null,'After-noon trip ','Porto','Negative',3);
insert into `trips` values(null,'Night trip','Porto','Negative',4);

insert into `steps` values(null,1,2,1,55,5.5,5,1,41,'8:00:00','8:41:00');
insert into `steps` values(null,2,3,2,80,8.0,5,1,60,'8:46:00','9:46:00');
insert into `steps` values(null,3,4,3,45,4.5,5,1,34,'9:51:00','10:25:00');
insert into `steps` values(null,4,5,4,40,4.0,5,1,30,'10:30:00','11:00:00');

insert into `steps` values(null,1,2,1,55,5.5,5,2,41,'12:00:00','12:41:00');
insert into `steps` values(null,2,3,2,80,8.0,5,2,60,'12:46:00','13:46:00');
insert into `steps` values(null,3,4,3,45,4.5,5,2,34,'13:51:00','14:25:00');
insert into `steps` values(null,4,5,4,40,4.0,5,2,30,'14:30:00','15:00:00');

insert into `steps` values(null,1,2,1,55,5.5,5,3,41,'16:00:00','16:41:00');
insert into `steps` values(null,2,3,2,80,8.0,5,3,60,'16:46:00','17:46:00');
insert into `steps` values(null,3,4,3,45,4.5,5,3,34,'17:51:00','18:25:00');
insert into `steps` values(null,4,5,4,40,4.0,5,3,30,'18:30:00','19:00:00');

insert into `steps` values(null,1,2,1,55,5.5,5,4,41,'20:00:00','20:41:00');
insert into `steps` values(null,2,3,2,80,8.0,5,4,60,'20:46:00','21:46:00');
insert into `steps` values(null,3,4,3,45,4.5,5,4,34,'21:51:00','22:25:00');
insert into `steps` values(null,4,5,4,40,4.0,5,4,30,'22:30:00','23:00:00');

insert into `steps` values(null,5,4,1,40,4.0,5,5,30,'8:00:00','8:30:00');
insert into `steps` values(null,4,3,2,45,4.5,5,5,34,'8:35:00','9:09:00');
insert into `steps` values(null,3,2,3,80,8.0,5,5,60,'9:14:00','10:14:00');
insert into `steps` values(null,2,1,4,55,5.5,5,5,41,'10:19:00','11:00:00');

insert into `steps` values(null,5,4,1,40,4.0,5,6,30,'12:00:00','12:30:00');
insert into `steps` values(null,4,3,2,45,4.5,5,6,34,'12:35:00','13:09:00');
insert into `steps` values(null,3,2,3,80,8.0,5,6,60,'13:14:00','14:14:00');
insert into `steps` values(null,2,1,4,55,5.5,5,6,41,'14:19:00','15:00:00');

insert into `steps` values(null,5,4,1,40,4.0,5,7,30,'16:00:00','16:30:00');
insert into `steps` values(null,4,3,2,45,4.5,5,7,34,'16:35:00','17:09:00');
insert into `steps` values(null,3,2,3,80,8.0,5,7,60,'17:14:00','18:14:00');
insert into `steps` values(null,2,1,4,55,5.5,5,7,41,'18:19:00','19:00:00');

insert into `steps` values(null,5,4,1,40,4.0,5,8,30,'20:00:00','20:30:00');
insert into `steps` values(null,4,3,2,45,4.5,5,8,34,'20:35:00','21:09:00');
insert into `steps` values(null,3,2,3,80,8.0,5,8,60,'21:14:00','22:14:00');
insert into `steps` values(null,2,1,4,55,5.5,5,8,41,'22:19:00','23:00:00');

insert into tickets values(null,'c39f78b5-9fdc-4484-8c5b-a18cbf2e69b2',1,5,'2016-03-25',10.5,'2016-03-23',10,4,false, 'A1');
insert into tickets values(null,'757cacbb-f0f8-476e-a6e6-a5a0246b91a3',1,4,'2016-03-25',9.5,'2016-03-23',10,4,false, 'A1');
insert into tickets values(null,'19597f48-4d21-482a-8282-09984ef3c9b9',3,5,'2016-03-25',6.5,'2016-03-23',10,4,false, 'A1');
insert into tickets values(null,'afdcfaae-ad2f-4ea7-bc47-4bee27b7193c',1,5,'2016-03-25',10.5,'2016-03-23',10,2,false, 'A1');
insert into tickets values(null,'56afec74-aa51-48e9-82ea-ba37a02a6b51',4,5,'2016-03-25',2.5,'2016-03-23',10,3,false, 'A1');

INSERT INTO bookings VALUES(NULL,'2016-04-25',12,1,4);
INSERT INTO bookings VALUES(NULL,'2016-04-25',5,2,4);