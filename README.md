# koerichCards

Desafio proposto pela Bianca, para encaminhamento para Leonardo.

Observações do Rafael: Foi bem interessante esse teste, de início foi um pouco complicado compreender o pedido, mas no momento que parei e fiz o desenho do que eu queria fazer, foi
de certa forma, mais fácil seguir o planejamento. Fazer um plano antes de começar é sempre importante. Tive problemas de versões no início, então utilizei um restTemplate meu, e no final,
atualizei para uma versão recente. Estou empolgado para junto com você, escrever uma histórica fantástica durante a próxima década.


***Criar um banco de dados MySQL com o nome "Cartas", faltou uma certa criatividade :)

URL de requisição (utilizei o Postman): http://localhost:8080/api/cartas </br>
Url para busar todos os vencedores: http://localhost:8080/api/cartas/vencedores </br>
Url para buscar pelo jogador vencedor http://localhost:8080/api/cartas/vencedores/Jogador%201 </br>

O desafio consiste em criar um baralho (utilizando a API disponível no fim do arquivo) e montar quatro “mãos” com 5 cartas cada uma, verificando qual “mão” tem a maior somatória.

Se houver empate, retornar só os vencedores empatados.

Regras:
A = 1
K = 13
Q = 12
J = 11

Exemplo:
Jogador 1 = [A,2,3,4,5]
Jogador 2 = [K,Q,J,10,9]
Jogador 3 = [8,9,2,A,J]
Jogador 4 = [2,2,5,7,2]
Vencedor é Jogador 2 com 55 pontos

Requisitos:
Utilizar Spring Boot/ Java 8+;
Utilizar o padrão "REST API";
Será permitido o uso do Feign;
O projeto deverá estar disponível no Github:
Criar commits descritivos;

Testes unitários; (OBRIGATÓRIO)
Salvar em banco de dados; (OBRIGATÓRIO)
Links: https://deckofcardsapi.com/ (API deck de cartas)

Utilizamos o Github para essa questão, por favor, criar o repositório como privado e adicionar os usuários abaixo e você pode concluir até o dia 31/08/24 às 08hrs.
https://github.com/leonardmelo 
