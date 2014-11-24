INSERT INTO `kategoriat` VALUES (1,'Pizzat'),(2,'Pannupizzat'),(3,'Juomat');
INSERT INTO tuotteet (nimi, hinta, kuvaus) values ('Frutti Di Mare', 25.00, 'Maistuvia merenherkkuja pizzan muodossa. Jaa vaikka kaverin kanssa!'), ('Berlusconi', 20.00, 'Maailman parhaaksi valittu pizza! Savuporo, kantarelli ja pizzapohjan ruiskuitu vakuuttivat niin Amerikan tuomarit kuin italialaisen suomalaisen ruokaosaamisen epäilijänkin.'), ('Pepperoni', 20.50, 'Pepperonimakkaraa tonnikalan seurana. Tuhti makuelämys ei jätä ketään nälkäiseksi.'), ('Special Opera', 21.00, 'Special Operan jokaiseen makuun! Perinteinen, loistokkaan makoisa.'), ('Mozarella', 29.00, 'Kulinaristillekin kelpaa aurinkokuivatulla tomaatilla, salamilla, ananaksella ja mozzarellajuustolla aateloitu erikoisuus. Hienostuneet maut täydentävät toisiaan.');
INSERT INTO `kategoria_tuotteet` VALUES (1,1),(1,2),(2,3),(2,4),(2,5);
INSERT INTO `roolit` VALUES (1,'admin'),(2,'superuser'),(3,'kayttaja');
INSERT INTO kayttajat(tunnus,nimi,rooli_id) VALUES ('aku','Ankka Admin',1),('saku','Sorsa User',2),('kissa','Kissa Käyttäjä',3);
INSERT INTO `lisa_aineet` VALUES (1,'valkosipuli', 1.5),(2,'oregano', 0.5),(3,'kanamuna',2);