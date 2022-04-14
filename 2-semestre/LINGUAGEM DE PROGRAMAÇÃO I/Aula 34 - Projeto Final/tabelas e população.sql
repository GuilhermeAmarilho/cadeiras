CREATE TABLE IF NOT EXISTS Setor (
  idSetor INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  PRIMARY KEY (idSetor));

INSERT INTO setor (nome) VALUES ("TI"),("Admin"),("RH"),("Manutenção"),("Segurança"),("Comercial");


CREATE TABLE IF NOT EXISTS Cliente (
  idCliente INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  login VARCHAR(45) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  telefone VARCHAR(11) NOT NULL,
  idSetor INT NOT NULL,
  PRIMARY KEY (idCliente),
  CONSTRAINT idSetorCliente
    FOREIGN KEY (idSetor)
    REFERENCES Setor (idSetor)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

INSERT INTO cliente (nome, login, senha, cpf, telefone, idSetor) values 
    ("Miguel","miguel@gmail.com","miguel123","68244084667","31966177712",1),
    ("Arthur","arthur@gmail.com","arthur123","57393715031","83993665631",2),
    ("Heitor","heitor@gmail.com","heitor123","80697641507","67917538463",3),
    ("Gabriel","gabriel@gmail.com","gabriel123","48892488824","77973775651",4),
    ("Davi","davi@gmail.com","davi123","79085979502","72913585412",5),
    ("Bernardo","bernardo@gmail.com","bernardo123","49385383245","68947234621",1),
    ("Samuel","samuel@gmail.com","samuel123","16080434251","14912986688",2),
    ("João","joao@gmail.com","joao123","81200177757","31988561175",3),
    ("Enzo","enzo@gmail.com","enzo123","96735287600","83919992771",4),
    ("Guilherme","guilherme@gmail.com","guilherme123","29556555365","32982678434",5),
    ("Helena","helena@gmail.com","helena123","23862602224","38932685239",1),
    ("Alice","alice@gmail.com","alice123","69685404503","71932153734",2),
    ("Laura","laura@gmail.com","laura123","26953635835","36921727438",3),
    ("Maria","maria@gmail.com","maria123","17754386356","34963728133",4),
    ("Valentina","valentina@gmail.com","valentina123","74113812201","26962942552",5),
    ("Heloisa","heloisa@gmail.com","heloisa123","56785716978","37976865843",1),
    ("Clara","clara@gmail.com","clara123","80172932271","14943772389",2),
    ("Julia","julia@gmail.com","julia123","12521810681","12964647225",3),
    ("Sophia","sophia@gmail.com","sophia123","93997097979","82974147372",4),
    ("Gabriela","gabriela@gmail.com","gabriela123","63147195345","75954959218",5);


CREATE TABLE IF NOT EXISTS Admin (
  idAdmin INT NOT NULL AUTO_INCREMENT,
  idSetor INT NOT NULL,
  nome VARCHAR(45) NOT NULL,
  login VARCHAR(45) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  cpf VARCHAR(45) NOT NULL,
  PRIMARY KEY (idAdmin),
  CONSTRAINT idSetorAdmin
    FOREIGN KEY (idSetor)
    REFERENCES Setor (idSetor)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

INSERT INTO admin (nome, login, senha, cpf, idSetor) VALUES
    ("Cassiano","cassiano@gmail.com","cassiano123","65945282986",1),
    ("Mariano","mariano@gmail.com","mariano123","65968657248",1),
    ("Daniel","daniel@gmail.com","daniel123","91936274143",2),
    ("Micael","micael@gmail.com","micael123","28992527571",2),
    ("Fábio","fabio@gmail.com","fabio123","68954833227",3),
    ("Joeslei","joeslei@gmail.com","joeslei123","59968573635",3),
    ("Adélia","adelia@gmail.com","adelia123","45923887846",4),
    ("Cristina","cristina@gmail.com","cristina123","52986918545",4),
    ("Aline","aline@gmail.com","aline123","42957768452",5),
    ("Sivia","silvia@gmail.com","Sivia123","77953584843",5),
    ("Rita","rita@gmail.com","rita123","35971337662",6),
    ("Jade","jade@gmail.com","jade123","18952666223",6);


CREATE TABLE IF NOT EXISTS Atendimento (
  idAtendimento INT NOT NULL AUTO_INCREMENT,
  tipoEquipamento VARCHAR(45) NOT NULL,
  idEquipamento VARCHAR(45) NOT NULL,
  descricao VARCHAR(500) NOT NULL,
  urgencia TINYINT NOT NULL,
  setorAtendimento INT NOT NULL,
  horaChamado DATETIME NOT NULL DEFAULT current_timestamp(),
  idAdmin INT NULL,
  status int Default 0,
  PRIMARY KEY (idAtendimento),
  CONSTRAINT idSetorAtendimento
    FOREIGN KEY (setorAtendimento)
    REFERENCES Setor (idSetor)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT idAdminAtendimento
    FOREIGN KEY (idAdmin)
    REFERENCES Admin (idAdmin)
    ON DELETE SET NULL
    ON UPDATE CASCADE);



INSERT INTO Atendimento (tipoEquipamento, idEquipamento, descricao, urgencia, setorAtendimento) values
 ('BUR', 'JA32X8HW0AU701738', 'Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus. Pellentesque at nulla. Suspendisse potenti.', 1, 6),
 ('HQH', '2C3CDXJG5CH920636', 'Aliquam erat volutpat. In congue. Etiam justo. Etiam pretium iaculis justo. In hac habitasse platea dictumst.', 1, 3),
 ('RSYS', '1G4CW54K934705215', 'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.', 1, 1),
 ('WOOD', 'JA32U2FU1FU673642', 'Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet.', 0, 3),
 ('PHK', '1G6DC8EG2A0806438', 'Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla. Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', 1, 6),
 ('FKU', '3N6CM0KN2EK897491', 'Pellentesque ultrices mattis odio. Donec vitae nisi. Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.', 1, 5),
 ('EML', 'WBAKA4C55CC736470', 'Mauris sit amet eros. Suspendisse accumsan tortor quis turpis. Sed ante. Vivamus tortor. Duis mattis egestas metus.', 1, 5),
 ('FLS', 'SAJWA1EK7EM382701', 'Etiam pretium iaculis justo. In hac habitasse platea dictumst.', 0, 2),
 ('VSEC', 'WDDGF5EB4AR314211', 'In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat. Nulla nisl. Nunc nisl. Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa.', 0, 3),
 ('CLRBZ', 'WAUKH68D41A053823', 'Aenean sit amet justo.', 0, 1),
 ('GSL^B', 'WA1WKBFPXBA102398', 'Vivamus vel nulla eget eros elementum pellentesque. Quisque porta volutpat erat.', 0, 5),
 ('NOVT', 'WP0CB2A88CS859823', 'Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus.', 0, 3),
 ('HBP', '1G6DJ8ED2B0220268', 'Proin risus. Praesent lectus. Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.', 1, 3),
 ('TD', '3C6JD7BP4CG512587', 'Curabitur convallis. Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor.', 1, 4),
 ('DOX', '3D4PH6FV1AT725255', 'Duis aliquam convallis nunc.', 1, 3),
 ('WAFD', 'YV4902NC2F1352907', 'Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci.', 0, 4),
 ('C^L', '2G4WE587271439477', 'Suspendisse potenti.', 1, 1),
 ('VTN', '1FTFW1E80AK190219', 'Fusce consequat. Nulla nisl. Nunc nisl.', 0, 2),
 ('CIEN', 'WAUUL68E35A869671', 'Etiam justo. Etiam pretium iaculis justo. In hac habitasse platea dictumst.', 1, 6),
 ('ARW', '3VW4A7AT2CM034827', 'Aliquam erat volutpat. In congue.', 0, 2),
 ('QLYS', '1HGCR2F31FA279320', 'Maecenas pulvinar lobortis est. Phasellus sit amet erat. Nulla tempus.', 1, 6),
 ('BCRX', '4A4AP3AU9EE148802', 'Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus. Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci.', 1, 3),
 ('NSSC', '1GYEK63N16R842533', 'Nunc nisl. Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum. In hac habitasse platea dictumst.', 0, 5),
 ('CDNA', '1G6AB5RA3F0949853', 'Integer ac neque. Duis bibendum. Morbi non quam nec dui luctus rutrum.', 0, 3),
 ('VUSE', '2B3CJ7DJ7BH520881', 'Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus.', 1, 3),
 ('GFNSL', 'JN8AS1MU6AM714814', 'Proin at turpis a pede posuere nonummy.', 1, 4),
 ('MBSD', 'JM1BL1H49A1573455', 'Nulla mollis molestie lorem.', 0, 1),
 ('MNE', '1FTFW1E8XAK339235', 'Praesent blandit lacinia erat.', 0, 2),
 ('ANET', '2LMDJ6JK6BB232878', 'Proin risus.', 1, 6),
 ('CBF', 'WP1AE2A24BL230882', 'Etiam justo. Etiam pretium iaculis justo. In hac habitasse platea dictumst.', 0, 4),
 ('MBVX', '1GYFC16229R659877', 'Morbi non quam nec dui luctus rutrum. Nulla tellus. In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.', 0, 3),
 ('EPAY', '3GYEK62887G478012', 'Etiam justo. Etiam pretium iaculis justo. In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.', 1, 2),
 ('SRCL', '5GAER13708J040547', 'Donec dapibus.', 0, 4),
 ('CMLS', '5TFBW5F14AX204636', 'Nullam molestie nibh in lectus. Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.', 1, 6),
 ('TWOU', 'SCFAB42373K457007', 'Nulla suscipit ligula in lacus. Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla.', 0, 1),
 ('LQ', 'WBAYF8C58FD504270', 'Sed ante. Vivamus tortor. Duis mattis egestas metus. Aenean fermentum. Donec ut mauris eget massa tempor convallis.', 0, 1),
 ('CCK', 'JH4DC53824S689720', 'Maecenas pulvinar lobortis est. Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum.', 0, 5),
 ('BOX', '2G4WS52J841400403', 'Donec quis orci eget orci vehicula condimentum.', 0, 5),
 ('AXP', '1G6AB5S35E0548783', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin risus. Praesent lectus.', 1, 2),
 ('TXRH', '2C3CCAGG4CH583982', 'Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.', 0, 2),
 ('FRAN', '4T1BK1EB8FU195961', 'Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus.', 1, 5),
 ('RHI', '3VW4A7AT0CM080494', 'Integer a nibh.', 0, 1),
 ('TCO^J', 'WBAWB7C5XAP396495', 'Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat. In congue. Etiam justo.', 0, 5),
 ('SBR', 'WBANN73506C841988', 'Etiam pretium iaculis justo. In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.', 0, 1),
 ('CUBE', 'TRUUT28N631744856', 'Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio.', 1, 5),
 ('EXXI', '19XFB2F54CE363125', 'Phasellus in felis. Donec semper sapien a libero.', 0, 3),
 ('SVU', '5FPYK1F40CB749889', 'Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.', 1, 4),
 ('CAMT', 'SCBBP9ZA5AC253581', 'Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero. Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.', 0, 4),
 ('TCI', '2HNYD18903H843111', 'Nunc nisl. Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus.', 0, 5),
 ('AWP', '1GYEK63N12R379450', 'Suspendisse accumsan tortor quis turpis. Sed ante. Vivamus tortor.', 0, 3),
 ('BBT^F', 'WBALW3C58DC798060', 'Praesent lectus. Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.', 1, 1),
 ('EGHT', '5N1AA0NE5EN403676', 'Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum. In hac habitasse platea dictumst.', 1, 1),
 ('MANH', '1GYFC43569R177977', 'Morbi ut odio. Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim.', 1, 6),
 ('BHAC', '3GYT4LEF4BG189924', 'Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus. Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.', 0, 5),
 ('MIME', 'WAUHE78P59A642734', 'In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.', 1, 3),
 ('BPI', 'JN1AZ4EH1EM125057', 'Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim.', 1, 5),
 ('MITT', '1G6AH5S31E0933658', 'Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.', 1, 3),
 ('VLRS', 'WAUKF98E45A428714', 'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat. Praesent blandit.', 1, 6),
 ('ARTW', 'WAULD64B23N809147', 'Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris. Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet.', 1, 2),
 ('IIJI', 'JH4KB16557C113736', 'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat. Curabitur gravida nisi at nibh. In hac habitasse platea dictumst.', 1, 1),
 ('INF', '1GYS3AEF3CR542089', 'Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros.', 1, 3),
 ('JSD', '5N1AR1NBXCC720348', 'Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque. Duis bibendum. Morbi non quam nec dui luctus rutrum.', 1, 6),
 ('PMPT', 'WAUUL98E47A611809', 'Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus. Pellentesque eget nunc.', 0, 1),
 ('BLMT', 'WAUAFAFL1AA132638', 'In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem. Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit. Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue.', 0, 1),
 ('ALL', '1N6AA0EK6FN790957', 'Nulla tellus. In sagittis dui vel nisl. Duis ac nibh.', 0, 1),
 ('BLX', '1N6AA0CC4CN531990', 'Nunc nisl. Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.', 0, 4),
 ('CMCT', '5XYKT3A10DG294573', 'In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus. Nulla ut erat id mauris vulputate elementum.', 0, 4),
 ('SBNB', 'WA1DGAFE1ED382717', 'Nunc nisl. Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa.', 0, 3),
 ('LOCO', '5UXFG83589L622125', 'Nunc purus. Phasellus in felis.', 1, 4),
 ('CBX', '3FAHP0CG6BR415677', 'Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.', 0, 6),
 ('GWRE', 'WAUNE78P58A857130', 'Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', 1, 6),
 ('CVCY', 'WBAVA37517N466956', 'Integer ac neque. Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus. In sagittis dui vel nisl.', 1, 6),
 ('ZIONZ', '1GYFK66897R874660', 'Fusce posuere felis sed lacus.', 0, 3),
 ('EQR', '1G6DA8E51C0526212', 'Etiam justo. Etiam pretium iaculis justo. In hac habitasse platea dictumst. Etiam faucibus cursus urna.', 0, 1),
 ('AEGN', '1C3BC2EB1BN847688', 'Ut at dolor quis odio consequat varius. Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi.', 0, 6),
 ('XHR', '5N1AA0NC2DN259758', 'Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.', 0, 5),
 ('TRVG', 'JHMFA3F22BS731584', 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi.', 1, 4),
 ('FAC', 'JHMFA3F29BS331764', 'Nulla facilisi. Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque. Quisque porta volutpat erat.', 0, 6),
 ('SYNT', '5N1AA0ND3FN104499', 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.', 0, 2),
 ('IMMR', '1GD12YEG1FF236838', 'Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.', 1, 1),
 ('MMP', 'WVWAW7AHXBV645759', 'Phasellus in felis.', 0, 6),
 ('SF', '3D73M4CL8AG348176', 'Suspendisse potenti.', 0, 2),
 ('CYD', 'WAUBNBFB5BN458439', 'Sed ante. Vivamus tortor. Duis mattis egestas metus.', 0, 2),
 ('HFC', '1FTMF1EW2AK513272', 'Aliquam non mauris. Morbi non lectus.', 1, 6),
 ('PPBI', '1G6AC5SX1E0520320', 'Donec quis orci eget orci vehicula condimentum.', 0, 3),
 ('SAB', '1N6BF0KL8FN948010', 'Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.', 1, 2),
 ('INGN', 'WAU3GAFDXFN017941', 'In eleifend quam a odio.', 1, 4),
 ('HIX', '1FADP5AU9EL517949', 'Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.', 1, 3),
 ('BANR', 'WAULF98K19N553095', 'Quisque id justo sit amet sapien dignissim vestibulum.', 0, 6),
 ('GDL', 'SCBZK22E82C317664', 'Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.', 0, 2),
 ('BPOPN', 'JN1CV6EK4BM271296', 'Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla. Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', 0, 2),
 ('NAT', '1HGCP2F31BA360284', 'Aliquam non mauris. Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet.', 0, 4),
 ('EBAYL', 'JH4CU2F6XCC770667', 'Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat.', 1, 2),
 ('OHAI', '1N6AA0CH2EN922411', 'Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula.', 0, 1),
 ('RFDI', 'WBS3R9C58FK101257', 'Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus. Pellentesque eget nunc.', 1, 4),
 ('LLEX', '2HNYD18963H949787', 'Nulla nisl. Nunc nisl. Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus.', 1, 2),
 ('KTN', '3GYFNBEYXBS500646', 'In eleifend quam a odio.', 0, 5),
 ('IVFVC', 'WAUNF98P08A757462', 'Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis.', 1, 4),
 ('VTWO', 'WBA3C3C53EP263544', 'Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat. In congue. Etiam justo.', 0, 6),
 ('ALK', 'WDDGF4HB7EA032199', 'Nunc nisl.', 1, 2);