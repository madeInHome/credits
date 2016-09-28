DROP TABLE tcr_credits_detail;
DROP TABLE tcr_credits;
DROP TABLE tcr_payments;
DROP TABLE tcr_customers;
DROP TABLE tcr_payment_period;
DROP TABLE tcr_products;
DROP TABLE tcr_brands;
DROP TABLE tcr_products_type;
DROP TABLE tcr_owners;
DROP TABLE tcr_persons;
DROP TABLE tcr_users;

CREATE TABLE tcr_users (
    CDUSER INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador del usuario.',
    CDPERSON INT NOT NULL COMMENT 'Código de la persona que contiene la información del usuario.',
    CDOWNER INT NOT NULL COMMENT 'Código del propietario del usuario',
    DSUSERNAME VARCHAR(45) NOT NULL COMMENT 'Usuario de la aplicación.',
    DSPASSWORD VARCHAR(500) NOT NULL COMMENT 'Contraseña del usuario.',
    CDSTATE INT NOT NULL COMMENT 'Estado del usuario. 1: Activo, 2: Inactivo.',
    DALAST_LOGIN DATETIME COMMENT 'Fecha de último ingreso del usuario, a la aplicación.',
    PRIMARY KEY (`CDUSER`)
);

CREATE TABLE `tcr_persons` (
  `CDPERSON` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador de la persona',
  `CDPERSON_TYPE` INT NOT NULL COMMENT 'Código del tipo de persona. 0: Persona natural, 1: Establecimento',
  `CDDOCUMENT_TYPE` INT NOT NULL COMMENT 'Tipo de documento de la persona. 0: Cédula, 1: Nit, 2: Cédula extranjería',
  `CDDOCUMENT` VARCHAR(45) NOT NULL COMMENT 'Número de documento de la persona',
  `DSNAMES` VARCHAR(100) NOT NULL COMMENT 'Nombres de la persona',
  `DSLAST_NAMES` VARCHAR(100) NOT NULL COMMENT 'Apellidos de la persona',
  `DSBUSINESS_NAME` VARCHAR(200) NULL COMMENT 'Nombre rezón social, o del negocio. Sólo aplica para persona jurídica.',
  `DSTELEPHONE` VARCHAR(20) NULL COMMENT 'Número de teléfono.',
  `DSCELL_PHONE` VARCHAR(20) NOT NULL COMMENT 'Número de celular',
  `DSADDRESS` VARCHAR(200) NULL COMMENT 'Dirección de la persona.',
  `DSEMAIL` VARCHAR(100) NULL COMMENT 'Correo electrónico de la persona.',
  CDUSER_CREATE INT NOT NULL COMMENT 'Usuario que crea el registro',
  DACREATE DATE NOT NULL COMMENT 'Fecha de creación del registro',
  CDUSER_UPDATE INT COMMENT 'Usuario que actualiza el registro',
  DAUPDATE DATE COMMENT 'Fecha de actualización del registro',
  PRIMARY KEY (`CDPERSON`),
CONSTRAINT `FK_PERSON_USER_CREATE`
    FOREIGN KEY (`CDUSER_CREATE`)
    REFERENCES `tcr_users` (`CDUSER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `FK_PERSON_USER_UPDATE`
    FOREIGN KEY (`CDUSER_UPDATE`)
    REFERENCES `tcr_users` (`CDUSER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE `tcr_owners` (
  `CDOWNER` INT NOT NULL AUTO_INCREMENT COMMENT 'Código del propietario',
  `CDPERSON` INT NULL COMMENT 'Código de la persona.',
  `YNCHECK_CUSTOMER` VARCHAR(1) NOT NULL COMMENT 'Indica si el propietario estudia sus clientes antes de activarlos. Y: Si, N: No',
  CDUSER_CREATE INT NOT NULL COMMENT 'Usuario que crea el registro',
  DACREATE DATE NOT NULL COMMENT 'Fecha de creación del registro',
  CDUSER_UPDATE INT COMMENT 'Usuario que actualiza el registro',
  DAUPDATE DATE COMMENT 'Fecha de actualización del registro',
  PRIMARY KEY (`CDOWNER`),
  INDEX `FK_OWNER_PERSON_idx` (`CDPERSON` ASC),
  CONSTRAINT `FK_OWNER_PERSON`
    FOREIGN KEY (`CDPERSON`)
    REFERENCES `tcr_persons` (`CDPERSON`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `FK_OWNER_USER_CREATE`
    FOREIGN KEY (`CDUSER_CREATE`)
    REFERENCES `tcr_users` (`CDUSER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `FK_OWNER_USER_UPDATE`
    FOREIGN KEY (`CDUSER_UPDATE`)
    REFERENCES `tcr_users` (`CDUSER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE `tcr_customers` (
  `CDCUSTOMER` INT NOT NULL AUTO_INCREMENT COMMENT 'Código único del cliente del OWNER.',
  `CDPERSON` INT NOT NULL COMMENT 'Código de la persona.',
  `CDOWNER` INT NOT NULL COMMENT 'Código del propietario del cliente.',
  `CDSTATE` INT NOT NULL COMMENT 'Código del estado del cliente. 1: Pendiente estudio, 2: Activo, 3: Rechazado, 4: Inactivo',
  CDUSER_CREATE INT NOT NULL COMMENT 'Usuario que crea el registro',
  DACREATE DATE NOT NULL COMMENT 'Fecha de creación del registro',
  CDUSER_UPDATE INT COMMENT 'Usuario que actualiza el registro',
  DAUPDATE DATE COMMENT 'Fecha de actualización del registro',
  INDEX `FK_CUSTOMER_PERSON_idx` (`CDPERSON` ASC),
  INDEX `FK_CUSTOMER_OWNER_idx` (`CDCUSTOMER` ASC),
  PRIMARY KEY (`CDCUSTOMER`),
  CONSTRAINT `FK_CUSTOMER_PERSON`
    FOREIGN KEY (`CDPERSON`)
    REFERENCES `tcr_persons` (`CDPERSON`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_CUSTOMER_OWNER`
    FOREIGN KEY (`CDOWNER`)
    REFERENCES `tcr_owners` (`CDOWNER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `FK_CUSTOMER_USER_CREATE`
    FOREIGN KEY (`CDUSER_CREATE`)
    REFERENCES `tcr_users` (`CDUSER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `FK_CUSTOMER_USER_UPDATE`
    FOREIGN KEY (`CDUSER_UPDATE`)
    REFERENCES `tcr_users` (`CDUSER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE `tcr_credits` (
  `CDCREDIT` INT NOT NULL AUTO_INCREMENT COMMENT 'Código único del crédito',
  `CDCUSTOMER` INT NOT NULL COMMENT 'Código del cliente.',
  `CDOWNER` INT NOT NULL COMMENT 'Código del propietario del crédito.',
  `DACREDIT` DATETIME NOT NULL COMMENT 'Fecha del crédito',
  `NMQUOTES` DECIMAL(5) NOT NULL COMMENT 'Número de cuotas en las que se pagará el crédito.',
  NMTERM DECIMAL(5) NOT NULL COMMENT 'Plazo de pago del crédito.  Indica el número de cuotas que pagará el cliente, de acuerdo al plazo definido para el crédito.',
  DAFIRST_PAYMENT DATETIME COMMENT 'Fecha de inicio de pago del crédito.',
  VRQUOTE DECIMAL(12) NOT NULL COMMENT 'Valor de la cuota a pagar por el crédito.',
  CDUSER_CREATE INT NOT NULL COMMENT 'Usuario que crea el registro',
  DACREATE DATE NOT NULL COMMENT 'Fecha de creación del registro',
  CDUSER_UPDATE INT COMMENT 'Usuario que actualiza el registro',
  DAUPDATE DATE COMMENT 'Fecha de actualización del registro',
  PRIMARY KEY (`CDCREDIT`),
  INDEX `FK_CREDIT_CUSTOMER_idx` (`CDCUSTOMER` ASC),
  INDEX `FK_CREDIT_OWNER_idx` (`CDOWNER` ASC),
  CONSTRAINT `FK_CREDIT_CUSTOMER`
    FOREIGN KEY (`CDCUSTOMER`)
    REFERENCES `tcr_customers` (`CDCUSTOMER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_CREDIT_OWNER`
    FOREIGN KEY (`CDOWNER`)
    REFERENCES `tcr_owners` (`CDOWNER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `FK_CREDIT_USER_CREATE`
    FOREIGN KEY (`CDUSER_CREATE`)
    REFERENCES `tcr_users` (`CDUSER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `FK_CREDIT_USER_UPDATE`
    FOREIGN KEY (`CDUSER_UPDATE`)
    REFERENCES `tcr_users` (`CDUSER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `tcr_products_type` (
  `CDPRODUCT_TYPE` INT NOT NULL AUTO_INCREMENT COMMENT 'Código único del tipo de producto.',
  `CDOWNER` INT NOT NULL COMMENT 'Código del propietario del tipo de producto.',
  `DSPRODUCT_TYPE` VARCHAR(200) NOT NULL COMMENT 'Descripción del tipo de producto.',
  CDUSER_CREATE INT NOT NULL COMMENT 'Usuario que crea el registro',
  DACREATE DATE NOT NULL COMMENT 'Fecha de creación del registro',
  CDUSER_UPDATE INT COMMENT 'Usuario que actualiza el registro',
  DAUPDATE DATE COMMENT 'Fecha de actualización del registro',
  PRIMARY KEY (`CDPRODUCT_TYPE`),
  INDEX `FK_PRODUCT_TYPE_OWNER_idx` (`CDOWNER` ASC),
  CONSTRAINT `FK_PRODUCT_TYPE_OWNER`
    FOREIGN KEY (`CDOWNER`)
    REFERENCES `tcr_owners` (`CDOWNER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `FK_PRO_TYPE_USER_CREATE`
    FOREIGN KEY (`CDUSER_CREATE`)
    REFERENCES `tcr_users` (`CDUSER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `FK_PRO_TYPE_USER_UPDATE`
    FOREIGN KEY (`CDUSER_UPDATE`)
    REFERENCES `tcr_users` (`CDUSER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `tcr_brands` (
  `CDBRAND` INT NOT NULL AUTO_INCREMENT COMMENT 'Código único de la marca.',
  `CDOWNER` INT NOT NULL COMMENT 'Código del propietario de la marca.',
  `DSBRAND` VARCHAR(200) NOT NULL COMMENT 'Descripción de la marca.',
  CDUSER_CREATE INT NOT NULL COMMENT 'Usuario que crea el registro',
  DACREATE DATE NOT NULL COMMENT 'Fecha de creación del registro',
  CDUSER_UPDATE INT COMMENT 'Usuario que actualiza el registro',
  DAUPDATE DATE COMMENT 'Fecha de actualización del registro',
  PRIMARY KEY (`CDBRAND`),
  INDEX `FK_BRANDS_OWNER_idx` (`CDOWNER` ASC),
  CONSTRAINT `FK_BRANDS_OWNER`
    FOREIGN KEY (`CDOWNER`)
    REFERENCES `tcr_owners` (`CDOWNER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `FK_BRAND_USER_CREATE`
    FOREIGN KEY (`CDUSER_CREATE`)
    REFERENCES `tcr_users` (`CDUSER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `FK_BRAND_USER_UPDATE`
    FOREIGN KEY (`CDUSER_UPDATE`)
    REFERENCES `tcr_users` (`CDUSER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `tcr_products` (
  `CDPRODUCT` INT NOT NULL AUTO_INCREMENT COMMENT 'Código único del producto.',
  `CDPRODUCT_TYPE` INT NOT NULL COMMENT 'Código del tipo de producto.',
  `CDOWNER` INT NOT NULL COMMENT 'Código del propietario del producto. Quien lo vende.',
  `CDBRAND` INT NOT NULL COMMENT 'Código de la marca del producto.',
  `DSPRODUCT` VARCHAR(200) NOT NULL COMMENT 'Descripción del producto.',
  `VRCOST` DECIMAL(12) NOT NULL COMMENT 'Valor de costo del producto.',
  `VRSALE_PRICE` DECIMAL(12) NOT NULL COMMENT 'Precio de venta del producto.',
  `DSCOLOR` VARCHAR(20) NULL COMMENT 'Color del producto.',
  `DSSIZE` VARCHAR(20) NULL COMMENT 'Talla del producto.',
  `NMSTOCK` INT NULL COMMENT 'Número de productos en inventario.',
  CDUSER_CREATE INT NOT NULL COMMENT 'Usuario que crea el registro',
  DACREATE DATE NOT NULL COMMENT 'Fecha de creación del registro',
  CDUSER_UPDATE INT COMMENT 'Usuario que actualiza el registro',
  DAUPDATE DATE COMMENT 'Fecha de actualización del registro',
  PRIMARY KEY (`CDPRODUCT`),
  INDEX `KF_PRODUCT_PTYPE_idx` (`CDPRODUCT_TYPE` ASC),
  INDEX `FK_PRODUCT_OWNER_idx` (`CDOWNER` ASC),
  INDEX `FK_PRODUCT_BRAND_idx` (`CDBRAND` ASC),
  CONSTRAINT `KF_PRODUCT_PTYPE`
    FOREIGN KEY (`CDPRODUCT_TYPE`)
    REFERENCES `tcr_products_type` (`CDPRODUCT_TYPE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_PRODUCT_OWNER`
    FOREIGN KEY (`CDOWNER`)
    REFERENCES `tcr_owners` (`CDOWNER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_PRODUCT_BRAND`
    FOREIGN KEY (`CDBRAND`)
    REFERENCES `tcr_brands` (`CDBRAND`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `FK_PRODUCT_USER_CREATE`
    FOREIGN KEY (`CDUSER_CREATE`)
    REFERENCES `tcr_users` (`CDUSER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `FK_PRODUCT_USER_UPDATE`
    FOREIGN KEY (`CDUSER_UPDATE`)
    REFERENCES `tcr_users` (`CDUSER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `tcr_credits_detail` (
  `CDCREDIT_DETAIL` INT NOT NULL AUTO_INCREMENT COMMENT 'Código único del detalle del crédito.',
  `CDCREDIT` INT NOT NULL COMMENT 'Código del crédito',
  `CDOWNER` INT NOT NULL,
  `CDPRODUCT` INT NOT NULL,
  `NMQUANTITY` INT NOT NULL COMMENT 'Cantidad de detalle de crédito del mismo tipo.',
  `VRSALE_PRICE` DECIMAL(12) NOT NULL COMMENT 'Precio del item del crédito.',
  PORATE DECIMAL (5,2) COMMENT 'Tasa de interés del crédito',
  CDUSER_CREATE INT NOT NULL COMMENT 'Usuario que crea el registro',
  DACREATE DATE NOT NULL COMMENT 'Fecha de creación del registro',
  CDUSER_UPDATE INT COMMENT 'Usuario que actualiza el registro',
  DAUPDATE DATE COMMENT 'Fecha de actualización del registro',
  PRIMARY KEY (`CDCREDIT_DETAIL`),
  INDEX `FK_CREDIT_DETAIL_CREDIT_idx` (`CDCREDIT` ASC),
  INDEX `FK_CREDIT_DETAIL_OWNER_idx` (`CDOWNER` ASC),
  INDEX `FK_CREDIT_DETAIL_PRODUCT_idx` (`CDPRODUCT` ASC),
  CONSTRAINT `FK_CREDIT_DETAIL_CREDIT`
    FOREIGN KEY (`CDCREDIT`)
    REFERENCES `tcr_credits` (`CDCREDIT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_CREDIT_DETAIL_OWNER`
    FOREIGN KEY (`CDOWNER`)
    REFERENCES `tcr_owners` (`CDOWNER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_CREDIT_DETAIL_PRODUCT`
    FOREIGN KEY (`CDPRODUCT`)
    REFERENCES `tcr_products` (`CDPRODUCT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `FK_CRE_DETAIL_USER_CREATE`
    FOREIGN KEY (`CDUSER_CREATE`)
    REFERENCES `tcr_users` (`CDUSER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `FK_CRE_DETAIL_USER_UPDATE`
    FOREIGN KEY (`CDUSER_UPDATE`)
    REFERENCES `tcr_users` (`CDUSER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `tcr_payments` (
  `CDPAYMENT` INT NOT NULL AUTO_INCREMENT COMMENT 'Código único del pago',
  `CDOWNER` INT NOT NULL COMMENT 'Código del propietario del pago, quien lo recibe.',
  `CDCUSTOMER` INT NOT NULL COMMENT 'Código del cliente que realiza el pago.',
  `VRAMOUNT` DECIMAL(12) NOT NULL COMMENT 'Valor del monto pagado.',
  `DAPAYMENT` DATETIME NOT NULL COMMENT 'Fecha del pago.',
  CDUSER_CREATE INT NOT NULL COMMENT 'Usuario que crea el registro',
  DACREATE DATE NOT NULL COMMENT 'Fecha de creación del registro',
  CDUSER_UPDATE INT COMMENT 'Usuario que actualiza el registro',
  DAUPDATE DATE COMMENT 'Fecha de actualización del registro',
  PRIMARY KEY (`CDPAYMENT`),
  INDEX `FK_PAYMENT_OWNER_idx` (`CDOWNER` ASC),
  CONSTRAINT `FK_PAYMENT_OWNER`
    FOREIGN KEY (`CDOWNER`)
    REFERENCES `tcr_owners` (`CDOWNER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_PEYMETN_CUSTOMER`
    FOREIGN KEY (`CDCUSTOMER`)
    REFERENCES `tcr_customers` (`CDCUSTOMER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `FK_PAYMENT_USER_CREATE`
    FOREIGN KEY (`CDUSER_CREATE`)
    REFERENCES `tcr_users` (`CDUSER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `FK_PAYMENT_USER_UPDATE`
    FOREIGN KEY (`CDUSER_UPDATE`)
    REFERENCES `tcr_users` (`CDUSER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `tcr_payment_period` (
  `CDPAYMENT_PERIOD` INT NOT NULL AUTO_INCREMENT COMMENT 'Código único del periodo de pago.',
  `CDOWNER` INT NOT NULL COMMENT 'Código del propietario del periodo de pago.',
  `DSPERIOD` VARCHAR(45) NOT NULL COMMENT 'Nombre del periodo.',
  `NMDAYS` INT NOT NULL COMMENT 'Número de días del peirodo.',
  CDUSER_CREATE INT NOT NULL COMMENT 'Usuario que crea el registro',
  DACREATE DATE NOT NULL COMMENT 'Fecha de creación del registro',
  CDUSER_UPDATE INT COMMENT 'Usuario que actualiza el registro',
  DAUPDATE DATE COMMENT 'Fecha de actualización del registro',
  PRIMARY KEY (`CDPAYMENT_PERIOD`),
  INDEX `FK_PAYMENT_PERIOD_OWNER_idx` (`CDOWNER` ASC),
  CONSTRAINT `FK_PAYMENT_PERIOD_OWNER`
    FOREIGN KEY (`CDOWNER`)
    REFERENCES `tcr_owners` (`CDOWNER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `FK_PAY_PERIOD_USER_CREATE`
    FOREIGN KEY (`CDUSER_CREATE`)
    REFERENCES `tcr_users` (`CDUSER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `FK_PAY_PERIOD_USER_UPDATE`
    FOREIGN KEY (`CDUSER_UPDATE`)
    REFERENCES `tcr_users` (`CDUSER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

ALTER TABLE `tcr_credits` 
ADD COLUMN `CDPAYMENT_PERIOD` INT NOT NULL COMMENT 'Periodo de pago programado para el crédito.' AFTER `NMQUOTES`,
ADD INDEX `FK_CREDIT_PAYMENT_PERIOD_idx` (`CDPAYMENT_PERIOD` ASC);
ALTER TABLE `tcr_credits` 
ADD CONSTRAINT `FK_CREDIT_PAYMENT_PERIOD`
  FOREIGN KEY (`CDPAYMENT_PERIOD`)
  REFERENCES `tcr_payment_period` (`CDPAYMENT_PERIOD`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `tcr_customers` 
ADD COLUMN `CDPAYMENT_PERIOD` INT NOT NULL COMMENT 'Periodo de pago configurado para el cliente.' AFTER `CDSTATE`,
ADD INDEX `FK_CUSTOMER_PAYMENT_PERIOD_idx` (`CDPAYMENT_PERIOD` ASC);
ALTER TABLE `tcr_customers` 
ADD CONSTRAINT `FK_CUSTOMER_PAYMENT_PERIOD`
  FOREIGN KEY (`CDPAYMENT_PERIOD`)
  REFERENCES `tcr_payment_period` (`CDPAYMENT_PERIOD`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


-- Datos iniciales
INSERT INTO tcr_users (CDPERSON, CDOWNER, DSUSERNAME, DSPASSWORD, CDSTATE) VALUES (1,1,'system','system',1);


INSERT INTO tcr_persons (`CDPERSON_TYPE`, `CDDOCUMENT_TYPE`, `CDDOCUMENT`, `DSNAMES`, `DSLAST_NAMES`, DSBUSINESS_NAME, `DSTELEPHONE`, `DSCELL_PHONE`, `DSADDRESS`, `DSEMAIL`, CDUSER_CREATE, DACREATE) 
VALUES ('2', '1', '1000000000', 'Sistema', 'Sistema', 'Sistema', '0000000', '0000000000', 'Cra.', 'system@s.com', 1, curdate());

INSERT INTO `tcr_persons` (`CDPERSON_TYPE`, `CDDOCUMENT_TYPE`, `CDDOCUMENT`, `DSNAMES`, `DSLAST_NAMES`, `DSTELEPHONE`, `DSCELL_PHONE`, `DSADDRESS`, `DSEMAIL`, CDUSER_CREATE, DACREATE) 
VALUES ('1', '1', '1037589820', 'JUAN PABLO', 'ESCOBAR CANO', '5982803', '3007831633', 'TRANSVERSAL 35 B SUR 30 40', 'pabloec101@gmail.com', 1, curdate());


INSERT INTO tcr_owners (CDPERSON, `YNCHECK_CUSTOMER`, CDUSER_CREATE, DACREATE) VALUES (2, 'Y', 1, curdate());


INSERT INTO `tcr_payment_period` (`CDOWNER`, `DSPERIOD`, `NMDAYS`, CDUSER_CREATE, DACREATE) VALUES ('1', 'Semanal', '7', 1, curdate());
INSERT INTO `tcr_payment_period` (`CDOWNER`, `DSPERIOD`, `NMDAYS`, CDUSER_CREATE, DACREATE) VALUES ('1', 'Decadal', '10', 1, curdate());
INSERT INTO `tcr_payment_period` (`CDOWNER`, `DSPERIOD`, `NMDAYS`, CDUSER_CREATE, DACREATE) VALUES ('1', 'Quincenal', '15', 1, curdate());
INSERT INTO `tcr_payment_period` (`CDOWNER`, `DSPERIOD`, `NMDAYS`, CDUSER_CREATE, DACREATE) VALUES ('1', 'Mensual', '30', 1, curdate());

INSERT INTO `tcr_customers` (`CDPERSON`, `CDOWNER`, `CDSTATE`, `CDPAYMENT_PERIOD`, CDUSER_CREATE, DACREATE) VALUES ('2', '1', '2', '1', 1, curdate());
commit;