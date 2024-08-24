CREATE TABLE `jogadas` (
        `id` INT(10) AUTO_INCREMENT PRIMARY KEY,
        `nomeJogador` longtext NOT NULL ,
        `cartas` longtext NOT NULL,
        `pontos` INTEGER NOT NULL,
        `rodada` INTEGER NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
