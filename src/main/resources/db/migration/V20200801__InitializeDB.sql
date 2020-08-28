SET NAMES utf8;

DROP TABLE IF EXISTS `transaction`;
SET character_set_client = utf8mb4;
CREATE TABLE `transaction`
(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `amount_in_cents` decimal(20,8) NOT NULL DEFAULT '0.00000000',
    `created_at` datetime DEFAULT NULL,
    `updated_at` datetime DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;