DROP TABLE IF EXISTS гр1сырьё;
CREATE TABLE гр1сырьё
(
  кодгр1 INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  гр1описание NVARCHAR(255) NOT NULL);

DROP TABLE IF EXISTS сотрудники;
CREATE TABLE сотрудники
(
код INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
фамилия NVARCHAR(255) NOT NULL,
имя NVARCHAR(255) NOT NULL,
пароль NVARCHAR(255) NOT NULL,
уволен BIT NOT NULL DEFAULT 0,
);

INSERT INTO гр1сырьё (SELECT 1, 'Primary');

INSERT INTO сотрудники (SELECT код=1, Фамилия='admin', Имя='admin', Пароль='admin', Уволен=FALSE );
