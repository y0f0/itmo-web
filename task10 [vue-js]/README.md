<!-- Output copied to clipboard! -->

<!-----

Yay, no errors, warnings, or alerts!

Conversion time: 0.285 seconds.


Using this Markdown file:

1. Paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β33
* Tue Jan 25 2022 22:20:12 GMT-0800 (PST)
* Source doc: Копия Веб-программирование: практика-10 (2021) [vue.js]
----->


1. Установите nodejs (отсюда [https://nodejs.org/en/](https://nodejs.org/en/), рекомендуется последний LTS). Соглашайтесь на добавление в PATH.

2. Установите `'npm install -g @vue/cli`'. В консоли будет довольно много всего выкачано, настроено.

3. Сделайте где-либо '`vue create test`' (выбрать default (Vue 2)). В консоли будет довольно много всего выкачано, настроено.

4. Убедитесь, что у вас стоит IDEA с поддержкой Vue.js (смотреть список установленных плагинов) или установите WebStorm

Скачайте проект с [https://assets.codeforces.com/files/wp21/10/990c3f043a63a902/lesson10.7z](https://assets.codeforces.com/files/wp21/10/990c3f043a63a902/lesson10.7z)

Сделайте ‘`npm install`’ в директории проекта, чтобы выкачать все модули. Запустите приложение (справа есть панель npm, запустите оттуда цель serve в Debug). Убедитесь в работоспособности приложения: можно зайти (пароль -- любой непустой), выйти, создать пост, изменить текст существующего.

1. 

Для аутентифицированных пользователей выводите в Header не только имя, но и логин. Добавьте в футер вывод статистики: количество зарегистрированных пользователей и количество постов. Обратите внимание, что для этого не нужно передавать в футер сами посты и пользователей, достаточно только их количества.

2.

Добавьте возможность регистрации. Для этого изучите как устроено добавление поста. Вам надо реализовать аналогичную функциональность - добавить пользователя. В форме регистрации нужно указать login и name. Провалидируйте login (длина от 3 до 16, только строчные латинские буквы, логин уникален). Провалидируйте имя (длина от 1 до 32). После регистрации должно редиректить на страницу со входом. Форма регистрации должна визуально быть очень похожа на форму входа.

Сделайте так, чтобы в хидере для аутентифицированного пользователя отображалось не только его имя, но имя и логин в скобках. Например, “Gennady Korotkevich (tourist)”. 

3.

Сделайте страницу со списком пользователей. Страница должна быть доступна и не аутентифицированным пользователям (анонимам). Расположите там просто типичную таблицу (наш datatable) с колонками id, login, name.

4.

Добавьте на главную (Index) вывод всех постов (по убыванию id). Выводите посты в типичном виде (как article, используйте разметку из предыдущих заданий). Выводите правильное количество комментариев.

5. Сделайте отдельную страницу поста. Сделайте туда переход по клику на View all в сайдбаре или по заголовку поста на главной. Выведите на этой странице сам пост и комментарии к нему. Не допускайте копи-пейста при отображении одного поста с пунктом 4.

