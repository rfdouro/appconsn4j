# Projeto de exemplo usando [Retrofit](https://square.github.io/retrofit/)

Retrofit é uma biblioteca para fazer parse de JSON em POJO

Nesse projeto estamos consumindo uma API disponível localmente na URL base (http://localhost:8080/demon4j/),
porém, não devemos usar o localhost em aplicações Android pois a mesma irá considerar o próprio dispositivo onde
a aplicação está rodando. Dado o exposto usamos o endereço IP local (http://10.0.0.154:8080/demon4j/).
