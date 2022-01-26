public class examples {
    public static void main (String[] args) throws java.lang.Exception
    {
        String s = "/images/asdfasd/adsf/as/df/as/df";
        String[] a = s.split("/");
        System.out.println(a.length);
        for (String str : a) {
            System.out.println(str);
        }
    }
}
