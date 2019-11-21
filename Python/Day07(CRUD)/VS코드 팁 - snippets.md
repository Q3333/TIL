# VS코드 팁



file -> prefrence -> user snippets



html하고 엔터하면 html.json 편집가능

```json
"post_form": {
		"prefix": "post_form",
		"body": [
			"<form action='' method='POST'>",
			"	{% csrf_token %}",
			"	<input type='submit'>",
			"</form>"
		],
		"description": "form tag"
	},
	"basic_extends": {
		"prefix": "et",
		"body": [
			"{% extends 'base.html' %}",
			"{% block body %}",
			"$0",
			"{% endblock %}"
		],
		"description": "basic extends"
	}
```



이러면 이제 post_form만 입력해도 자동완성



extends는 et



"$0" 는 커서를 바로 위치시켜줌.



