/**
 * Created by Wovch on 14.05.2016.
 */

import java.net.URL;
import java.net.MalformedURLException;

public class main {
    public static void main(String ar[]) {
        try
        {System.out.println ("ads");
            URL u = new URL("https://www.youtube.com/watch?v=bIZA3m3hO80");
            MediaPanel mp = new MediaPanel(u);

        }
        catch (java.net.MalformedURLException e) {System.out.println ("e");}
    }
}
