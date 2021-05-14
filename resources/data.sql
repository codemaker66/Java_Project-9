create database prod;
use prod;

CREATE TABLE `patients` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `family_name` varchar(255) NOT NULL,
  `date_of_birth` date NOT NULL,
  `gender` tinytext NOT NULL,
  `postal_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `phone_number` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  PRIMARY KEY (`id`)
);

INSERT INTO `patients` (`id`, `name`, `family_name`, `date_of_birth`, `gender`, `postal_address`, `phone_number`) VALUES
(1, 'Lucas', 'Ferguson', '1968-06-22', 'male', '2 Warren Street', '387-866-1399'),
(2, 'Pippa', 'Rees', '1952-09-27', 'female', '745 West Valley Farms Drive', '628-423-0993'),
(3, 'Edward', 'Arnold', '1952-11-11', 'male', '599 East Garden Ave', '123-727-2779'),
(4, 'Anthony', 'Sharp', '1946-11-26', 'male', '894 Hall Street', '451-761-8383'),
(5, 'Wendy', 'Ince', '1958-06-29', 'female', '4 Southampton Road', '802-911-9975'),
(6, 'Tracey', 'Ross', '1949-12-07', 'female', '40 Sulphur Springs Dr', '131-396-5049'),
(7, 'Claire', 'Wilson', '1966-12-31', 'female', '12 Cobblestone St', '300-452-1091'),
(8, 'Max', 'Buckland', '1945-06-24', 'male', '193 Vale St', '833-534-0864'),
(9, 'Natalie', 'Clark', '1964-06-18', 'female', '12 Beechwood Road', '241-467-9197'),
(10, 'Piers', 'Bailey', '1959-06-28', 'male', '1202 Bumble Dr', '747-815-0557');
COMMIT;

create database test;
use test;

CREATE TABLE `patients` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `family_name` varchar(255) NOT NULL,
  `date_of_birth` date NOT NULL,
  `gender` tinytext NOT NULL,
  `postal_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `phone_number` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  PRIMARY KEY (`id`)
);