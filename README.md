***Criar um banco de dados MySQL com o nome "Cartas", faltou uma certa criatividade :)


O projeto consiste em criar um baralho utilizando a API fornecida no link ao final e distribuir quatro mãos de 5 cartas cada. Em seguida, deve-se verificar qual mão possui a maior soma dos valores.

Em caso de empate, devem ser retornados apenas os vencedores empatados.

Regras para os valores das cartas: A = 1 K = 13 Q = 12 J = 11

Exemplo: Jogador 1 = [A,2,3,4,5] </br>
Jogador 2 = [K,Q,J,10,9] </br>
Jogador 3 = [8,9,2,A,J] </br>
Jogador 4 = [2,2,5,7,2] </br>
O vencedor é o Jogador 2 com 55 pontos. </br>

Requisitos:

Utilizar Spring Boot/Java 8+;
Seguir o padrão REST API;
Feign está permitido;
O projeto deve ser hospedado no GitHub, com commits descritivos;
Realizar testes unitários;
Salvar os resultados em banco de dados.
API do baralho: https://deckofcardsapi.com/



URL de requisição (utilizei o Postman): http://localhost:8080/api/cartas </br>
Resultado: </br>
[
    {
        "id": 70,
                "nomeVencedor": "Jogador 4",
        "valorCartas": "7,11,6,8,12",
        "somaCartas": 44
    },
] </br>
</br>
Url para busar todos os vencedores: http://localhost:8080/api/cartas/vencedores </br>
Resultado: </br>
[ </br>
     { </br>
               "id": 70, </br>
        "nomeVencedor": "Jogador 4", </br>
        "valorCartas": "7,11,6,8,12", </br>
        "somaCartas": 44 </br>
    }, </br>
     "id": 71, </br>
        "nomeVencedor": "Jogador 1", </br>
        "valorCartas": "7,11,6,8,11", </br>
        "somaCartas": 43 </br>
    }, </br>
] </br></br>
Url para buscar pelo jogador vencedor http://localhost:8080/api/cartas/vencedores/Jogador%201 </br>
Resultado: </br>
[ </br>
    { </br>
        "id": 71, </br>
        "nomeVencedor": "Jogador 1", </br>
        "valorCartas": "8,6,12,11,7", </br>
        "somaCartas": 44 </br>
    } </br>
] </br></br>

Front usando a API com react, esse é o Link: </br>
[https://github.com/RafaelDaitx/front_desafio_Cartas](https://github.com/RafaelDaitx/frontend_cards_api_game) </br></br>

