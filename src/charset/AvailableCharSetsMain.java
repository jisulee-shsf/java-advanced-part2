package charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.SortedMap;

public class AvailableCharSetsMain {

    public static void main(String[] args) {
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        for (String charsetName : charsets.keySet()) {
            System.out.println(charsetName);
        }

        Charset charset1 = Charset.forName("MS949");
        System.out.println(charset1);

        Set<String> aliases = charset1.aliases();
        for (String alias : aliases) {
            System.out.println(alias);
        }

        Charset charset2 = Charset.forName("utf-8");
        System.out.println(charset2);

        Charset charset3 = StandardCharsets.UTF_8;
        System.out.println(charset3);

        Charset charset4 = Charset.defaultCharset();
        System.out.println(charset4);
    }
}
