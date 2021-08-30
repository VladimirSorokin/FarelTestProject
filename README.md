# Farel test project
Список тест кейсов: https://docs.google.com/spreadsheets/d/1FkN-6JCgP-2l4m1OwXoEHWNRIybNiBDLTc-wo7SEOLY/edit?usp=sharing

В списке обозначены кейсы которые были автоматизированы.
В данном проекте находятся как APi, так и UI тесты.

Используемый стэк: Java 15 + Selenide + TestNg + Allure + RestAssured

По умолчанию используется браузер Google Chrome и предполагается что он установлен по умолчанию. Для тестирования в других браузерах потребуется их установка и возможно настройка системной переменной.

### Для запуска тестов выполните команду: 
- ```./gradlew clean test```
### Для показа репорта выполните последовательно команды:
- ```./gradlew allureReport```
- ```./gradlew allureServe```
### Кроссбраузерное тестирование
Для изменения браузера используется настройка ```systemProperties["selenide.browser"]``` в файле ```build.gradle``` . Можно указать например ```firefox``` , но этот бразуер должен быть установлен и возможно потребуется настройка системной переменной.
### Параллельный запуск тестов
Для паралелльного запуска тестов используется TestNg профиль ```src/test/resources/testng_profiles/farel.xml```, в котором можно указать количество трэдов и что паралельно запускать тесты или сьюты.

### Общие комментарии
- В списке тестов статусы проставлены на основе результатов API тестов
- Ожидаемые результаты для API и UI тестов разняться, так как непонятны требования. За ожидаемый результат взяты текущие возвращаемые значения.


