# EventsBySicreed

Aplicativo para listar eventos, realizar checkin e compartilhar.

Arquitetura MVVM - Escolhida por ser uma das arquiteturas mais usadas hoje no mercado e também por remover o forte acoplamento entre cada componente. Mais importante ainda, 
nessa arquitetura os filhos não tem referência direta do pai, eles só tem a referência por observáveis.

![image](https://user-images.githubusercontent.com/2738131/149030441-60b2fa1f-c1a3-4f54-8275-8bba8a03a7d9.png)


frameworks:

Hilt - Oferece uma maneira padrão de fazer DI no aplicativo, fornecendo contêineres para cada componente do Android no projeto e gerenciando o ciclo de vida do contêineres
automaticamente. Para uso foi usado o Dagger também.

StateFlow - Com o uso de corrotina, o StateFlow permite que os fluxos emitam atualizações de estado de maneira otimizada e valores para vários consumidores.Ótima opção para classes que precisam manter o estado mutável obersvável.

Retrofit - Além de permitir uma implementação simples e ser um dos frameworks mais usados no mercado, com o OkHttp é tranquilo, por exemplo, interceptar a requisição e mudar da forma que você precisa.
