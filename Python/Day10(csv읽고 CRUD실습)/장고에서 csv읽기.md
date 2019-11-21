# 장고에서 csv읽기

템플릿 폴더 위치에 두고



전체폴더(프로젝트, 앱 보유하고 있는 폴더) 기준으로 .찍고 해당 경로까지 입력



```python
 f = open('./movies/templates/movies/data.csv', 'r', encoding='utf-8')
    rdr = csv.reader(f)
    for line in rdr:
        print(line)
    f.close()    

```



이 경우에는 .이 django_movies고 app폴더인 movies/templates/movies/ 안에 있는 csv를 가져올 수 있었다.



csv.reader(f) 대신 DictReader으로 읽어오면 딕셔너리 형태로 읽어온다.