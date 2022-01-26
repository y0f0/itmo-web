public class Main {
    public static void main(String[] args) {
        String BASE = "curl 'http://1d3p.wp.codeforces.com/new' \\\n" +
                "  -H 'Connection: keep-alive' \\\n" +
                "  -H 'Cache-Control: max-age=0' \\\n" +
                "  -H 'Upgrade-Insecure-Requests: 1' \\\n" +
                "  -H 'Origin: http://1d3p.wp.codeforces.com' \\\n" +
                "  -H 'Content-Type: application/x-www-form-urlencoded' \\\n" +
                "  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4577.63 Safari/537.36' \\\n" +
                "  -H 'Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9' \\\n" +
                "  -H 'Referer: http://1d3p.wp.codeforces.com/' \\\n" +
                "  -H 'Accept-Language: ru-RU,ru;q=0.9' \\\n" +
                "  -H 'Cookie: JSESSIONID=3CD92FEFB3501F3799D2F80B51CF5C28' \\\n" +
                "  --compressed \\\n" +
                "  --insecure";

        for (String curlCommand : new GeneratorCurls(BASE, 1, 100)) {
            System.out.println(curlCommand);
        }
    }
}

curl 'http://1d3p.wp.codeforces.com/new' \
        -H 'Connection: keep-alive' \
        -H 'Cache-Control: max-age=0' \
        -H 'Upgrade-Insecure-Requests: 1' \
        -H 'Origin: http://1d3p.wp.codeforces.com' \
        -H 'Content-Type: application/x-www-form-urlencoded' \
        -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4577.82 Safari/537.36' \
        -H 'Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9' \
        -H 'Referer: http://1d3p.wp.codeforces.com/' \
        -H 'Accept-Language: ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7' \
        -H 'Cookie: __utmc=71512449; evercookie_png=sqaslgfz75bfuedfzz; evercookie_etag=sqaslgfz75bfuedfzz; evercookie_cache=sqaslgfz75bfuedfzz; 70a7c28f3de=sqaslgfz75bfuedfzz; __utmz=71512449.1631737309.4.3.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); __utma=71512449.408550415.1631173927.1631873489.1631885377.7; JSESSIONID=CE6FF5983E664AA751707C912855D186' \
        --data-raw '_af=34be50b38beccce4&proof=1&amount=1&submit=Submit' \
        --compressed \
        --insecure