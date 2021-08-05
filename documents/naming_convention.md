# naming conventions

Birbiriyle alakalı veya aynı ekrana ait activity/fragment/adapter/dialog
gibi sınıflar aynı paker ismi altında yer almalıdır.

## JAVA

Tüm sınıflar yaptığı iş veya sorumlu olduğu sürece ait bilgi ve kendi
türü olarak adlandırılmalıdır.

#### Sınıf isimlendirmeleri

```java
ProfileActivity.class 
TransferFragment.class
OrderListActivity.class
OrderListRecyclerViewAdapter.class 
LoginManager.class
User.class //Obje sınıflarına ek bir şey yazmaya gerek yok
```
### XML

#### drawable

#### layout

java sınıfındaki isimlendirmenin aynısı ancak
[**snake case**](https://en.wikipedia.org/wiki/Snake_case) olarak
yapılmalı. Böylece aynı sınıfa ait (adapter içerisindeki view veya
activity içerisinde viewpager fragmentları) layout lar alt alta
duracağından bulmak daha kolay olacaktır.

#### colors

#### dimens

#### strings
**hangi ekranda kullanıldığı + ne iş yaptığı** veya genel ise **general**
tagi

```xml
<string name="profile_fragment_name">isim</string>
<string name="general_ok">Tamam</string>
```

#### styles



```java

profile_activity.xml
transfer_fragment.xml
order_list_activity.xml
order_list_send_fragment.xml
order_list_saved_fragment.xml
order_list_item.xml
```

