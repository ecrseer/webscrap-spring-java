## Webscrapping do componente organizacional tiss
Tentativa de um servidor spring
com capacidade de acessar o website gov br
baixar o componente organizacional em pdf
e guardar os quadros (30..31..) em forma de api

## Como buildar

Inicie o banco de dados com docker:
```bash
docker-compose up -d
```

## end-points

```
GET
/scrap/quadro/{numeroDoQuadro}
```
Onde `numeroDoQuadro` é o quadro que se deseja os dados.

A api tambem se encontra no heroku
https://ecrseer-webscrap-tiss.herokuapp.com/