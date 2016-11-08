# Concrete Sollutions - Android Challenge.

Os detalhes sobre o desafio original podem ser encontrados neste [link](https://bitbucket.org/marcellogalhardo/concrete-sollutions-android-challenge/src/3c4d761e4886a32a78f14e8fee844e1d57890730/ORIGINAL_README.md?at=master&fileviewer=file-view-default).

## Decisões do Projeto ##

Este aplicativo foi desenvolvido seguindo o padrão de apresentação de Model-View-Presenter (camada Ui), tendo como propósito permitir facilidade na execução no Presenter a partir de suas interfaces mockaveis. Além destes foi criado uma camada de *Model* (Modelos de Domínio), *Service* (Serviços de Consulta na API do Github) e *Util* (Utilitários gerais). Foi utilizado RxJava em conjunto com o Retrofit para realização de tarefas assíncronas e chamadas na API, integrando com GSON para a leitura dos objetos de domínio e configurando o OkHttp para gerenciar caches simples (de até 10 MB). Utilizado a library Dagger 2 para gerenciar a Injeção de Dependência. Foi utilizado a library Glide para carregar as imagens e realizar o cache das mesmas.

As imagens de Mockups foram seguidas, usando os estilos definidos pelo Android (styles.xml) e as especificações do Android Guideline (Material Design). O aplicativo suporta mudanças de orientação. Não implementei testes unitários, por tela ou funcionais.

## Imagens da Implementação ##

![Repository List Portrait](https://bytebucket.org/marcellogalhardo/concrete-sollutions-android-challenge/raw/3c4d761e4886a32a78f14e8fee844e1d57890730/Pictures/repository_list_portrait.png?token=16512cb6833bd1488df1aa3561eb5b42dd1358e3)
![Repository List Landscape](https://bytebucket.org/marcellogalhardo/concrete-sollutions-android-challenge/raw/3c4d761e4886a32a78f14e8fee844e1d57890730/Pictures/repository_list_landscape.png?token=2eaf521638f5578dc6ec1aa4a613d81f5f619e1f)
![Pull Request List Portrait](https://bytebucket.org/marcellogalhardo/concrete-sollutions-android-challenge/raw/3c4d761e4886a32a78f14e8fee844e1d57890730/Pictures/pull_request_list_portrait.png?token=c1c14165d49ea49cdd0145154e90ea8681a0fa18)
![Pull Request List Landscape](https://bytebucket.org/marcellogalhardo/concrete-sollutions-android-challenge/raw/3c4d761e4886a32a78f14e8fee844e1d57890730/Pictures/pull_request_list_landscape.png?token=915e093b91050b4746cc79c6d184a90d68d2bacf)

## Contato ##

Para qualquer contato:

* E-mail: marcello.galhardo@gmail.com
* LinkedIn: https://www.linkedin.com/in/marcellogalhardo
* Github: https://github.com/marcellogalhardo
