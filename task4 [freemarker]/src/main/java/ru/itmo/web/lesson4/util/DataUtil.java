package ru.itmo.web.lesson4.util;

import ru.itmo.web.lesson4.model.Post;
import ru.itmo.web.lesson4.model.User;
import ru.itmo.web.lesson4.model.Color;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DataUtil {
    private static final List<User> USERS = Arrays.asList(
            new User(1, "MikeMirzayanov", "Mike Mirzayanov", Color.RED),
            new User(6, "pashka", "Pavel Mavrin", Color.RED),
            new User(9, "geranazarov555", "Georgiy Nazarov", Color.GREEN),
            new User(11, "tourist", "Gennady Korotkevich", Color.BLUE)
    );

    public static void addData(HttpServletRequest request, Map<String, Object> data) {
        data.put("users", USERS);
        data.put("posts", POSTS);

        for (User user : USERS) {
            if (Long.toString(user.getId()).equals(request.getParameter("logged_user_id"))) {
                data.put("user", user);
            }
        }
    }

    private static final List<Post> POSTS = Arrays.asList(
            new Post(123,
                    "Технокубок 2022 — олимпиада по программированию для школьников",
                    "Привет!\n" +
                            "Наступил октябрь, а значит, пришло время объявить, что Mail.ru Group совместно с МФТИ, МГТУ им. Н.Э.Баумана и CodeForces запускает седьмой по счету «Технокубок» — олимпиаду за звание самого талантливого молодого программиста среди учеников 8-11 классов!\n" +
                            "\n" +
                            "«Технокубок» входит в проект Перечня олимпиад школьников РСОШ, дающих льготы при поступлении в высшие учебные заведения РФ, как олимпиада I уровня — победители и призеры финального этапа олимпиады смогут поступить в вуз без экзаменов или получить 100 баллов за ЕГЭ по информатике. Кроме того, все победители «Технокубка» получат ценные призы, а также привилегии при поступлении на образовательные проекты Mail.ru Group.\n" +
                            "\n" +
                            "Финал олимпиады пройдет в марте 2022 года. Формат его проведения будет известен позднее в связи с эпидемиологической обстановкой.\n" +
                            "\n",
                    1),
            new Post(322,
                    "Codeforces Round #748 (Div. 3)",
                    "Привет, Codeforces!\n" +
                            "\n" +
                            "Рад пригласить Вас на увлекательный (а мы постарались его сделать таким) Codeforces Round #748 (Div. 3) — раунд для третьего дивизиона, который состоится в среда, 13 октября 2021 г. в 17:35. Это раунд, сделанный мной (MrPaul_TUser), существенный вклад в его создание которого также внесли MikeMirzayanov и BledDest.\n" +
                            "\n" +
                            "Этот раунд содержит 6-8 задач. Задачи подобраны по сложности так, чтобы составить интересное соревнование для участников с рейтингами до 1600. Однако все желающие, чей рейтинг 1600 и выше, могут зарегистрироваться на раунд вне конкурса.\n" +
                            "\n" +
                            "Раунд пройдет по правилам образовательных раундов. Таким образом, во время раунда задачи будут тестироваться на предварительных тестах, а после раунда будет 12-часовая фаза открытых взломов. Мы постарались сделать сильные тесты — так же как и Вы будем весьма удивлены, если у многих попадают решения после окончания контеста.\n" +
                            "\n" +
                            "Вам будет предложено 6-8 задач и 2 часа 15 минут на их решение.\n" +
                            "\n" +
                            "Штраф за неверную попытку в этом раунде (и последующих Div. 3 раундах) будет равняться 10 минутам.\n" +
                            "\n" +
                            "Напоминаем, что в таблицу официальных результатов попадут только достоверные участники третьего дивизиона. Как написано по ссылке — это вынужденная мера для борьбы с неспортивным поведением. Для квалификации в качестве достоверного участника третьего дивизиона надо:\n" +
                            "\n" +
                            "принять участие не менее чем в двух рейтинговых раундах (и решить в каждом из них хотя бы одну задачу),\n" +
                            "не иметь в рейтинге точку 1900 или выше. Независимо от того, являетесь вы достоверными участниками третьего дивизиона или нет, если ваш рейтинг менее 1600, то раунд для вас будет рейтинговым.\n" +
                            "Огромная благодарность _c_k_r_, Vladosiya, spotless, Yousry, powergee101, ncduy0303, I_Remember_Olya_ashmelev, A_Killer, OlegZubkov, mahade31, arjunsanjeev7, и UpS0lver за помощь в тестировании раунда и улучшении задач.\n" +
                            "\n" +
                            "Всем удачи и хорошего настроения!",
                    1),
            new Post(228,
                    "Educational Codeforces Round 115 [рейтинговый для Div. 2]\n",
                    "Привет, Codeforces!\n" +
                            "\n" +
                            "В воскресенье, 10 октября 2021 г. в 12:05 состоится Educational Codeforces Round 115 (рейтинговый для Div. 2). Обратите внимание на необычное время старта раунда.\n" +
                            "\n" +
                            "Продолжается серия образовательных раундов в рамках инициативы Harbour.Space University! Подробности о сотрудничестве Harbour.Space University и Codeforces можно прочитать в посте.\n" +
                            "\n" +
                            "Этот раунд будет рейтинговым для участников с рейтингом менее 2100. Соревнование будет проводиться по немного расширенным правилам ICPC. Штраф за каждую неверную посылку до посылки, являющейся полным решением, равен 10 минутам. После окончания раунда будет период времени длительностью в 12 часов, в течение которого вы можете попробовать взломать абсолютно любое решение (в том числе свое). Причем исходный код будет предоставлен не только для чтения, но и для копирования.\n" +
                            "\n" +
                            "Вам будет предложено 6 или 7 задач на 2 часа. Мы надеемся, что вам они покажутся интересными.\n" +
                            "\n" +
                            "Задачи вместе со мной придумывали и готовили Александр fcspartakm Фролов, Михаил awoo Пикляев и Максим Neon Мещеряков. Также большое спасибо Михаилу MikeMirzayanov Мирзаянову за системы Polygon и Codeforces.\n" +
                            "\n" +
                            "Удачи в раунде! Успешных решений!\n" +
                            "\n",
                    9),
            new Post(666,
                    "Mirror of Bubble Cup 14 Finals on Codeforces",
                    "Hello, Codeforces!\n" +
                            "\n" +
                            "Microsoft Development Center Serbia is thrilled to announce the finals of the 14th edition of Bubble Cup competition! Bubble Cup is an international, ICPC-style team contest aimed at university and high school students.\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "Contest will take place on Saturday, 9th of October at 10AM CEST, in online format. Winners will be announced at the closing ceremony. You can find more info on the BubbleCup website.\n" +
                            "\n" +
                            "Just like the previous editions, this final will be followed by an online mirror competition on Codeforces. Mirror will take place on the same day about an hour after the start of the finals — суббота, 9 октября 2021 г. в 12:05. Contest will last for 4 hours and ICPC rules will be applied. It will be a competition for teams of 1-3 members. There will be at least eight problems.\n" +
                            "\n" +
                            "Just like last year, the finals are divided in two \"divisions\", called Premier League and Rising Stars. The two contests will have most of their problems in common, but the Rising Stars competition will feature some easier tasks targeted at high school contestants.\n" +
                            "\n" +
                            "Both of the contests will be mirrored here on Codeforces, with Premier League mapping to the Div1 contest and Rising Stars mapping to the Div2 contest. The mirror will use native Codeforces ICPC team contest rules. Each team is allowed to use multiple computers.\n" +
                            "\n" +
                            "Both contests will be unrated, due to the format and the length of the mirror being dissimilar to the standard Codeforces rated rounds.\n" +
                            "\n" +
                            "The problems and their solutions were created by employees and interns of Microsoft Development Center Serbia: niksmiljkovic, acac97, renea, BubbleCup, nikolapesic2802, berke00, davidmilicevic97, ijevtic, dj0l3, igzi, Kole, Vasiljko, pavlej and me TadijaSebez.\n" +
                            "\n" +
                            "We give our thanks to Nikolay Kalinin (KAN) and Mike Mirzayanov (MikeMirzayanov) for making these mirror contests possible and for the wonderful Codeforces and Polygon platforms. Special thanks goes to Alexandr Lyashko (knightL) for helping out with problem testing.\n" +
                            "\n" +
                            "You can find problems from previous finals on our Codeforces online mirror competitions:",
                    11));

}
