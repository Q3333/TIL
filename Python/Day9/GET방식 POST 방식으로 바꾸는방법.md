# GET방식 POST 방식으로 바꾸는방법



```python
<form action="{% url 'app:choice_vote' q.id c.id %}" method="POST">
    {% csrf_token %}
    <a href="#" onclick="this.parentNode.submit()">투표하기</a>
    <a href="{% url 'app:choice_edit' q.id c.id %}">댓글 수정</a>
    </form>
```



기존 하이퍼링크

```python
<a href="{% url 'app:choice_edit' q.id c.id %}">댓글 수정</a>
```

이었던 값을



전체를 form으로 씌워주고 a태그에 옵션으로 onclick을 부여한다.

```python
<a href="#" onclick="this.parentNode.submit()">투표하기</a>
```

