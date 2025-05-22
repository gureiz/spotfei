# Spotifei

O *Spotifei* é uma aplicação desktop desenvolvida em Java com Swing que simula uma plataforma de gerenciamento de informações sobre músicas, inspirada no Spotify. O sistema permite que usuários busquem músicas, curtam faixas, organizem playlists e acompanhem um histórico completo das suas interações. Toda a persistência é realizada com PostgreSQL, estruturado segundo a arquitetura MVC.

---

## Objetivo

O projeto Spotifei tem como objetivo oferecer uma plataforma para gerenciamento e visualização de informações sobre músicas. Diferentemente de um streaming real, o Spotifei não executa as faixas — apenas registra e organiza os dados musicais. O foco está no exercício de construção de um sistema completo com funcionalidades reais, interface gráfica e integração com banco de dados.

---

## Tecnologias Utilizadas

- *Java (Swing)* – Interface gráfica  
- *PostgreSQL* – Banco de dados relacional  
- *JDBC* – Conexão entre Java e banco de dados  
- *Arquitetura MVC* – Organização do sistema em camadas (Model - View - Controller)

---

## Funcionalidades e Explicações

### Cadastro de Usuário
Permite que novos usuários se registrem informando nome, e-mail e senha. Os dados são validados e inseridos na tabela usuarios. O e-mail deve ser único.

### Login de Usuário
Valida as credenciais digitadas com os dados armazenados no banco. Ao logar corretamente, o usuário tem acesso ao menu principal, onde pode executar as demais funcionalidades.

### Buscar Músicas
Usuários podem digitar um termo (nome, artista ou gênero) e visualizar uma lista das músicas que correspondem ao critério. A busca retorna ID, nome, artista e gênero da música. Cada busca é registrada no histórico com data e ID da música consultada.

### Curtir Músicas
O usuário pode curtir uma música informando seu ID. A relação entre o e-mail do usuário e o ID da música é armazenada na tabela curtidas. O sistema impede curtidas duplicadas.

### Descurtir Músicas
O usuário pode remover uma música curtida informando seu ID. Ao descurtir, além de excluir da tabela curtidas, essa ação também é registrada no historico_descurtidas.

### Gerenciar Playlists
O usuário pode criar, renomear e excluir playlists, além de adicionar ou remover músicas nelas. Cada playlist é associada ao e-mail do usuário. A relação entre playlists e músicas é mantida por uma tabela intermediária playlist_musicas.

### Visualizar Histórico
O histórico do usuário inclui três componentes:
- Últimas 10 músicas buscadas (armazenadas com timestamp na tabela historico_buscas)
- Músicas curtidas (consultadas diretamente na tabela curtidas)
- Músicas descurtidas (armazenadas na tabela historico_descurtidas)

---

## Banco de Dados

O sistema utiliza o PostgreSQL com as seguintes tabelas principais:

- usuarios: nome, email, senha  
- musicas: id, nome, artista, gênero  
- curtidas: email_usuario + id_musica  
- playlists: id, nome, email_usuario  
- playlist_musicas: id_playlist + id_musica  
- historico_buscas: id, email_usuario, id_musica, data_busca  
- historico_descurtidas: id, email_usuario, id_musica, data_descurtada  

Todas as relações usam chaves estrangeiras e constraints para garantir integridade.

---

## Estrutura de Classes

- Pessoa (classe abstrata): contém nome e email  
- Usuario (herda de Pessoa): possui senha e funcionalidades de autenticação  
- Artista (herda de Pessoa): contém lista de músicas  
- Musica: representa uma faixa musical  
- Playlist: representa uma lista de músicas do usuário  
- Autenticacao (interface): implementada por Usuario  

---

## Como Executar

1. Crie o banco de dados PostgreSQL chamado spotfei  
2. Execute os scripts SQL fornecidos para criar as tabelas  
3. Configure Conexao.java com suas credenciais do PostgreSQL  
4. Abra o projeto no NetBeans  
5. Compile e execute Spotifei.java  

---

## Conclusão

O Spotifei é um sistema completo para gerenciamento de músicas, que aplica na prática conceitos fundamentais como persistência em banco, interface gráfica em Java e arquitetura orientada a objetos. Toda interação do usuário é registrada, e os dados são mantidos mesmo após o encerramento da aplicação.

## Link do vídeo explicativo

https://drive.google.com/file/d/1Au_VORO_-mLJ7o6kb43EWC_qDROIzDDw/view?usp=drive_link

## Gustavo Reis Teixeira RA: 22.124.055-9
