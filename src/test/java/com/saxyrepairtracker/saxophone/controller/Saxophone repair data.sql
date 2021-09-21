INSERT INTO customer (first_name, last_name, phone) VALUES('Kim', 'Kimminy', '755.223.5969');
INSERT INTO customer (first_name, last_name, phone) VALUES('Jorbjorn', 'Lindholm', '256.399.4665');
INSERT INTO customer (first_name, last_name, phone) VALUES('Reinhardt', 'Wilhelm', NULL);
INSERT INTO customer (first_name, last_name, phone) VALUES('Brigette', 'Lindholm', '328.993.3774');
INSERT INTO customer ( first_name, last_name, phone) VALUES('Zenyatta', 'Mandatta', '399.377.3854');
INSERT INTO customer (first_name, last_name, phone) VALUES('Bom', 'Trady', NULL);
INSERT INTO customer ( first_name, last_name, phone) VALUES('Bell', 'Billacheck', '647.399.2610');
INSERT INTO customer ( first_name, last_name, phone) VALUES('Dave', 'Lee', '219.355.6407');
INSERT INTO customer ( first_name, last_name, phone) VALUES('Bert', 'Ernie', '766.388.3663');
INSERT INTO customer ( first_name, last_name, phone) VALUES('James', 'Earl', '635,968.2611');
INSERT INTO customer (first_name, last_name, phone) VALUES('Irene', 'Ely', NULL);
INSERT INTO customer (first_name, last_name, phone) VALUES('Stephanie', 'Lynn', '766.958.3995');
INSERT INTO customer (first_name, last_name, phone) VALUES('Norm', 'Ely', '133.846.2775');
INSERT INTO customer (first_name, last_name, phone) VALUES('Gavin', 'Van', '733.378.9511');
INSERT INTO customer (first_name, last_name, phone) VALUES('Garth', 'Brocks', '312.753.9994');

INSERT INTO saxophones (customer_fk, serial_number, manufacturer, series , type)  VALUES (1, 15236654, 'Yamaha', 'Custom Z', 'TENOR');
INSERT INTO saxophones (customer_fk, serial_number, manufacturer, series , type)  VALUES (2, 4561323, 'Selmer', 'Custom', 'ALTO');
INSERT INTO saxophones (customer_fk, serial_number, manufacturer, series , type)  VALUES (3, 458226565, 'Yamaha', 'Yazz', 'SOPRANO');
INSERT INTO saxophones (customer_fk, serial_number, manufacturer, series , type)  VALUES (4, 954151233, 'Yamaha', 'Student', 'BARITONE');
INSERT INTO saxophones (customer_fk, serial_number, manufacturer, series , type)  VALUES (5, 75369852, 'Selmer', '65', 'TENOR');

INSERT INTO employee (first_name, last_name, pay_rate)  VALUES ( 'David', 'Bailey', 35);
INSERT INTO employee ( first_name, last_name, pay_rate)  VALUES ( 'John', 'Smith', 22);
INSERT INTO employee ( first_name, last_name, pay_rate)  VALUES ( 'Sam', 'James', 21);
INSERT INTO employee ( first_name, last_name, pay_rate)  VALUES ( 'Brent', 'Jamie', 18);
INSERT INTO employee ( first_name, last_name, pay_rate)  VALUES ( 'Nate', 'Great', 15);
INSERT INTO employee ( first_name, last_name, pay_rate)  VALUES ( 'Alison', 'Abbes', 25);
INSERT INTO employee ( first_name, last_name, pay_rate)  VALUES ( 'Charlie', 'Chop', 20);

INSERT INTO service_ticket ( customer_fk, description, status, estimated_cost) VALUES (4, 'things are sticking', 'WAITING FOR REPAIR', '45'); 
INSERT INTO service_ticket ( customer_fk, description, status, estimated_cost) VALUES (3, 'needs new pads', 'BEING REPAIRED', '85'); 
INSERT INTO service_ticket ( customer_fk, description, status, estimated_cost) VALUES (5, 'Broken', 'AWAITING ARRIVAL', '75'); 
INSERT INTO service_ticket ( customer_fk, description, status, estimated_cost) VALUES (6, 'key fell off', 'WAITING FOR PARTS', '90'); 
INSERT INTO service_ticket ( customer_fk, description, status, estimated_cost, actual_cost) VALUES (7, 'cleaning', 'PICKED-UP', '25', '25'); 
INSERT INTO service_ticket ( customer_fk, description, status, estimated_cost, actual_cost) VALUES (1, 'key bent fell off', 'READY FOR PICK-UP', '85', '115'); 


-- SELECT * FROM saxophones;