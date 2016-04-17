##How to Start

```
1. clone the git repository
2. mvn spring-boot:run
3. enjoy!
```

##How to Use

- Generate new board
```
HTTP GET Request to URL:
http://localhost:8080/board/

Response:
{"id":691796,"board":[[7,0,0,0,4,0,5,3,0],[0,0,5,0,0,8,0,1,0],[0,0,8,5,0,9,0,4,0],[5,3,9,0,6,0,0,0,1],[0,0,0,0,1,0,0,0,5],[8,0,0,7,2,0,9,0,0],[9,0,7,4,0,0,0,0,0],[0,0,0,0,5,7,0,0,0],[6,0,0,0,0,0,0,5,0]],"completed":false,"movesMade":29}
```
- Take id of the generated board and make move
```
HTTP POST Request to URL:
http://localhost:8080/board/691796/makeMove/
params: x=0&y=1&value=2

Response:
"VALID"
```
- Check the last state of the board
```
HTTP GET Request to URL:
http://localhost:8080/board/691796/

Response:
{"id":691796,"board":[[7,0,0,0,4,0,5,3,0],[2,0,5,0,0,8,0,1,0],[0,0,8,5,0,9,0,4,0],[5,3,9,0,6,0,0,0,1],[0,0,0,0,1,0,0,0,5],[8,0,0,7,2,0,9,0,0],[9,0,7,4,0,0,0,0,0],[0,0,0,0,5,7,0,0,0],[6,0,0,0,0,0,0,5,0]],"completed":false,"movesMade":30}
```
- Check the same move
```
HTTP POST Request to URL:
http://localhost:8080/board/691796/checkMove/
params: x=0&y=1&value=2

Response:
"INVALID"
```
