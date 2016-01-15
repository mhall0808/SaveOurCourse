/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParseHTML;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

/**
 *
 * @author hallm8
 */
public class ParseHTML {

    public ParseHTML() {

    }

    public ParseHTML(String filePath) {
        File input = new File(filePath);
        if (input.exists()) {
            try {
                System.out.println("Hurrah!  It exists!");
                Document doc = Jsoup.parse(input, "UTF-8");

                // Now that we have a basic setup, we just load the files. 
                Element body = doc.getElementById("body");

                Elements href = doc.getElementsByAttribute("href");

                for (Element href1 : href) {
                    if (href1.attributes().get("href").contains("/d2l/le/calendar/")) {
                        href1.unwrap();

                        String html = doc.html();

                        BufferedWriter htmlWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"));
                        System.out.println("\n" + doc.outerHtml());
                        htmlWriter.write(doc.toString());
                        htmlWriter.flush();
                        htmlWriter.close();
                    }
                }

            } catch (IOException ex) {
                System.out.println("Error reading or writing:" + filePath);
                Logger.getLogger(ParseHTML.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
