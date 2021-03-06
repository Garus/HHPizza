INSERT INTO `kategoriat` VALUES (1,'Pizzat'),(2,'Pannupizzat'),(3,'Juomat');
INSERT INTO tuotteet (nimi, hinta, kuvaus) VALUES ('Frutti Di Mare', 25.00, 'Maistuvia merenherkkuja pizzan muodossa. Jaa vaikka kaverin kanssa!'), ('Berlusconi', 20.00, 'Maailman parhaaksi valittu pizza! Savuporo, kantarelli ja pizzapohjan ruiskuitu vakuuttivat niin Amerikan tuomarit kuin italialaisen suomalaisen ruokaosaamisen epäilijänkin.'), ('Pepperoni', 20.50, 'Pepperonimakkaraa tonnikalan seurana. Tuhti makuelämys ei jätä ketään nälkäiseksi.'), ('Special Opera', 21.00, 'Special Operan jokaiseen makuun! Perinteinen, loistokkaan makoisa.'), ('Mozarella', 29.00, 'Kulinaristillekin kelpaa aurinkokuivatulla tomaatilla, salamilla, ananaksella ja mozzarellajuustolla aateloitu erikoisuus. Hienostuneet maut täydentävät toisiaan.');
INSERT INTO tuotteet (nimi, hinta, kuvaus) VALUES ('Pepsi', 5.50, 'Pepsi-Cola 1,5L'), ('Coke', 5.00, 'Coca-Cola 1,5L'), ('Pepsi', 3.50, 'Pepsi-Cola 0,5L');
INSERT INTO pizzat VALUES (1), (2), (3), (4), (5);
INSERT INTO juomat VALUES (6), (7), (8);
INSERT INTO `kategoria_tuotteet` VALUES (1,1),(1,2),(2,3),(2,4),(2,5);
INSERT INTO `kategoria_tuotteet` VALUES (3,6),(3,7),(3,8);
INSERT INTO `roolit` VALUES (1,'admin'),(2,'superuser'),(3,'kayttaja');
INSERT INTO kayttajat(tunnus,nimi,rooli_id) VALUES ('aku','Ankka Admin',1),('saku','Sorsa User',2),('kissa','Kissa Käyttäjä',3);
INSERT INTO `lisa_aineet` (id, nimi, hinta) VALUES (1,'valkosipuli', 1.5),(2,'oregano', 0.5),(3,'kanamuna',2);
