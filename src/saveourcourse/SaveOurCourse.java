/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveourcourse;

import ParseHTML.ParseHTML;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author hallm8
 */
public class SaveOurCourse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File directory = new File(System.getProperty("user.dir"));
        //get all the files from a directory

        File[] fList = directory.listFiles();

        for (File file : fList) {

            System.out.println(file.getName());

            if (file.isFile() && file.getName().endsWith(".html")) {
                System.out.println(file.getAbsolutePath());
                ParseHTML parser = new ParseHTML(file.getAbsolutePath());
            }
        }
    }
}
