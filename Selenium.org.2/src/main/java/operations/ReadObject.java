package operations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import pagesDemo.base;

public class ReadObject extends  base{

	Properties p = new Properties();
    public Properties getObjectRepository() throws IOException{
        //Read object repository file
        InputStream stream = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\java\\Objects\\object.properties"));
        //load all objects
        p.load(stream);
         return p;
    }
}
