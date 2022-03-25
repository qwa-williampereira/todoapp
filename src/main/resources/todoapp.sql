DROP TABLE IF EXISTS `todo`;
CREATE TABLE `todo` (
  `id` varchar(255) NOT NULL,
  `completado` bit(1) DEFAULT NULL,
  `conteudo` varchar(255) DEFAULT NULL,
  `data_atualizao` datetime DEFAULT NULL,
  `data_criacao` datetime DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `todo` VALUES 
('17597adb-bac3-4e06-ba2f-a657bab78114',_binary '\0','6r6g5j0c5i0emwk362v58yusg9g4j5c921q7sircseywjhsxtjr','2022-03-10 19:12:48','2022-03-10 19:12:48','Tobacco Road'),
('4bb23219-87f9-4756-85b4-8163a2942e4d',_binary '\0','asdadasdsasdasdasdjfbai babsakjsasdas','2022-03-10 18:52:09','2022-03-10 18:52:09','Primeiro Todo'),
('70a8e300-92ec-430c-99a1-5e231948e79e',_binary '','1d4y9y1c2u2rghm062d07tqkd3x5d5z277w8svgnesrzhuuxkll','2022-03-10 19:12:53','2022-03-10 19:12:53','Day After, The'),
('992a0035-9ae7-40df-b92b-d782f93c0a35',_binary '','0b0h0u6b1s5uhxb932q72kceo9o3k1o875q9leopxypxcrokzop','2022-03-10 19:12:43','2022-03-10 19:12:43','Harvard Man'),
('b2ede414-9da8-4ca8-ba4e-8d0c282e201a',_binary '','3e1d9m6g6l5lwdo602e46goaj1d9i1s483h8ppnvulpamcteaeq','2022-03-10 19:12:37','2022-03-10 19:12:37','Boys'),
('b82a74a5-51b5-422c-a83c-24f5c88986e5',_binary '\0','asdadasdsasdasdasdjfbai babsakjsasdas','2022-03-10 18:52:21','2022-03-10 18:52:21','Segundo Todo'),
('c25fd5f3-9505-4d21-b1d3-0cdb9751cc79',_binary '\0','9b9f3n0p7f5pafs078l35pimq6d8b6u823h2mrliqfvnbsdzwvy','2022-03-10 19:12:59','2022-03-10 19:12:59','Little Prince, The');
