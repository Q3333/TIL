# Hashmap 연습

### 기본 형태 : HashMap<key, value>  변수명 ;

``` java
HashMap<Integer, String> Test1;
		Test1 = new HashMap();
		Test1.put(1,"라면");
		Test1.put(2,"치킨");
		Test1.put(3,"짜장면");
		Test1.put(4,"다코야끼");
		Test1.put(5,"규동");
		for(int i=0 ;i<5; i++)System.out.println(Test1.get(i+1));
```



넣을 때는 put으로 넣고, 뺄 때는 get으로 키 값을 입력하여 빼낸다.



<출력화면>

![](<https://github.com/Q3333/ITL/blob/master/190527/result_190528.PNG>)





### 심화 형태 : Key값이 객체 일 경우

```
public class Item {
	private String name;
	private int price;
} // String의 이름과 int의 가격을 가지고 있는 Item이라는 객체

HashMap<Item, Integer> basket;
basket.put(new Item("사과", 1500),new Integer(6)); // 1500원의 사과를 6개 구입
		basket.put(new Item("라면", 1200),new Integer(3));
		basket.put(new Item("식용유", 3500),new Integer(1));
		basket.put(new Item("과자", 2400),new Integer(5));
		
```

해결방법 : Iterator 사용 //인스턴스의 순차적 접근을 할 때 사용하는 명령어

```
Set<Item> keys = basket.keySet();
		//index로 접근할 수 없는 경우 Iterator객체를 받아와서 요소에 접근할 수 있다.
int no = 1;
		while(iterator.hasNext()){
			System.out.print((no++)+"\t"); // 순번
		   Item key =  (Item)iterator.next(); // Iterator를 사용해서 순차적 접근
		   System.out.print(key.getName()+"\t"); // key에는 (사과,1500)/(라면,1200)순으로
		   System.out.print(key.getPrice()+"\t"); // 들어간다.
		   Integer qty = basket.get(key);
		   System.out.print(qty+"개\n");
		}
		
```



<출력화면>



 ![](<https://github.com/Q3333/ITL/blob/master/190527/result2_190528.PNG>)

