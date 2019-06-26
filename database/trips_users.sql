# Write your MySQL query statement below
CREATE TABLE `Trips` (
  `Id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '',
  `Client_Id` bigint(20) unsigned DEFAULT '1' COMMENT '',
  `device_serial` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '',
  `Driver_Id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '',
  `City_Id` int(10) NOT NULL DEFAULT '0' COMMENT '',
  `Status` enum ('completed', 'cancelled_by_driver', 'cancelled_by_client') DEFAULT 'completed' COMMENT '',
  `Request_at` varchar(256) DEFAULT 'iPhone' COMMENT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `device_serial` (`device_serial`),
  KEY `device_id` (`device_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8

CREATE TABLE `Users` (
  `Users_Id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '',
  `Banned` boolean DEFAULT 'No' COMMENT '',
  `Role` enum ('client', 'driver', 'partner') DEFAULT 'client' COMMENT '',
  PRIMARY KEY (`Users_Id`),
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8

SELECT `U`.`Request_at` AS `Day`, `U`.`Status` AS `Cancellation Rate` FROM `Trips` AS `T` INNER JOIN `Users` AS `U` ON `T`.`Client_Id` = `U`.`User_Id` WHERE `U`.`Role` == 'Client'