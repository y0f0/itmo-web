<!-- Output copied to clipboard! -->

<!-----

Yay, no errors, warnings, or alerts!

Conversion time: 0.241 seconds.


Using this Markdown file:

1. Paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β33
* Tue Jan 25 2022 22:15:55 GMT-0800 (PST)
* Source doc: Копия Веб-программирование: практика-8 (2021) [spring-1]

WARNING:
You have 4 H1 headings. You may want to use the "H1 -> H2" option to demote all headings by one level.

----->


<p style="color: red; font-weight: bold">>>>>>  gd2md-html alert:  ERRORs: 0; WARNINGs: 1; ALERTS: 0.</p>
<ul style="color: red; font-weight: bold"><li>See top comment block for details on ERRORs and WARNINGs. <li>In the converted Markdown or HTML, search for inline alerts that start with >>>>>  gd2md-html alert:  for specific instances that need correction.</ul>

<p style="color: red; font-weight: bold">Links to alert messages:</p>
<p style="color: red; font-weight: bold">>>>>> PLEASE check and correct alert issues and delete this message and the inline alerts.<hr></p>


Скачайте проект с [https://assets.codeforces.com/files/wp21/8/8944c7fed4.zip](https://assets.codeforces.com/files/wp21/8/8944c7fed4.zip) 

Запустите проект (поправьте src/main/resources/application.properties). Используйте базу данных вида uXX. Запуск создаст таблицу user. Добавьте к ней колонку passwordSha, которая по-умолчанию NULL. Убедитесь, что всё работает - регистрация+вход+выход, просмотр пользователей. 


# Задание 1

Сделайте небольшую страницу с профилем пользователя по ссылке /user/{id}. Для этого используйте параметр в методе с аннотацией @PathVariable (погуглите, это просто). Просто отобразите id, login и creation на отдельной странице (или надпись “No such user”, если такого нет).

Обратите внимание, что сейчас на странице со списком всех пользователей не отображается логотип и иконки языков. Исправьте это.


# Задание 2

Добавьте сущность Notice с тремя полями id, content (используйте аннотацию @Lob), creationTime. Обратите внимание, что Notice не имеет связи с User (пока всё делаем без связей). Добавьте NoticeRepository, NoticeService. В классе Page аналогично с getUser сделайте getNotices (не забудьте аннотацию @ModelAttribute), чтобы все потомки Page добавляли в модель переменную notices. Измените commons.ftlh, чтобы в сайдбаре вместо блока “Pay Attention” была серия подобных блоков, которые отображают все notices. Добавьте несколько notices через базу, убедитесь, что на всех страницах теперь отображаются ваши notices в сайдбаре.


# Задание 3

Добавьте форму добавления Notice. Это должна быть просто одна textarea с кнопкой “Add”. Не забывайте про валидацию.


# Задание 4

Добавьте пользователям колонку/поле disabled, по умолчанию равно false. На страницу /users добавьте колонку с действиями. Там в каждой строчке будет ровно одна кнопка (Disable или Enable в зависимости от текущего статуса). При нажатии кнопки отправляется маленькая форма, которая устанавливает новый статус пользователя. Обратите внимание, что семантика обработки этой формы должна быть “установить заданный статус”, а не “сменить статус на противоположный”. После этого страница перегружается и там уже кнопка для обновленного статуса. Пока не используйте javascript, просто сделайте такие небольшие формы в каждой строке. Добавьте в форму входа сообщение “User is disabled” при попытке входа заблокированного пользователя.

