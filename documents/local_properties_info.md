# local.properties tanımlamaları

### local_git_path : APK NAMING

apk isimleri otomatik olarak verilir, branch ismi, versiyon kodu ve
debug/release type oldugu apk ismine basılır. Bunun düzgün olarak
alınması için local.properties içine **local_git_path** isminde sistemin
git yolunun verilmesi gerekir. Aşağıdaki kodu kopyalayıp, kendi dosya
yolunuzla değiştirip, local.properties içine koyun.

```java
local_git_path=C\:\\Users\\ardak\\AppData\\Local\\Atlassian\\SourceTree\\git_local\\bin\\git.exe
```

<br/>

**örnek apk çıktı ismi**

*development-0.0.0.1-EN_FRAMEWORK-release-unsigned.apk*

<br/>

**eğer bu tanımla yapılmaz ise apk ismi şu şekilde olur**

*LOCAL_GITH_PATH_BULUNAMADI-0.0.0.1-EN_FRAMEWORK-release-unsigned.apk*

### custom_path_for_apks : APK DOSYA DIZINI


apk üretirken sürekli proje içerisinde dosya dizinleri aç aç yaparak
kaybolmak, sıkılmak istemiyorsan aşağıdaki kodu kopyalayıp
**local.properties** içine koy. Dosya dizini olarak da istediğin yeri

belirt. Üretilen apk lar istediğin yere gelsin.

```java
custom_path_for_apks=C\:\\Users\\ardak\\Desktop\\APKS
```

