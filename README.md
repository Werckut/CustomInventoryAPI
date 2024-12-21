# CustomInventoryAPI
## [Read WIKI](https://github.com/Werckut/CustomInventoryAPI/wiki)
---
### Maven
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```
```xml
<dependency>
    <groupId>com.github.Werckut</groupId>
    <artifactId>CustomInventoryAPI</artifactId>
    <version>Tag</version>
</dependency>
```
### Gradle
```gradle
repositories {
  maven { url 'https://jitpack.io' }
}
```
```gradle
dependencies {
        implementation 'com.github.Werckut:CustomInventoryAPI:Tag'
}
```
---
Мне лень тут рассписывать все и я просто расскажу своими словами, что тут происходит.
С помощью плагина я "натянул" текстурку ...назовем это *Слияние* на инвентарь сундука (Это не наковальня. Если присмотреться и вспомнить как выглядит наковальня, то все становиться ясно) и заблокировал все слоты кроме трех, для первых двух (вроде их номер был 10 и 13) я разрешил все действия, а для третьего (его номер вроде был 15) я разрешил только возможность забирать из него предметы. А самое главное, для чего этот плагин и был задуман это у то, что у слотов реализуется механика drag and drop (это когда вы перетаскиваете стак с зажатой лкп и он разбивается по слотам). Пока, что это все, что делат плагин.
### Some pictures 🖼️
> ![image](https://user-images.githubusercontent.com/51494093/175774124-a511a8d5-c132-4ee1-b119-86158286a9bd.png)
> Single drag

> ![image](https://user-images.githubusercontent.com/51494093/175774122-374ab669-8a4d-4793-9870-1b373cf152a7.png)
> Even drag
