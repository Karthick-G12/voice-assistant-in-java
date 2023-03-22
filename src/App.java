import java.io.ObjectInputFilter.Config;
import java.net.URI;
import javax.naming.directory.SearchResult;
import java.awt.Desktop;
import edu.cmu.sphinx.api.*;

public class App {
    
    public static void main(String[] args) throws Exception {
        Configuration config = new Configuration();
        config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        config.setDictionaryPath("src\\dic.dic");
        config.setLanguageModelPath("src\\lm.lm");
        try {
            LiveSpeechRecognizer rec = new LiveSpeechRecognizer(config);
            rec.startRecognition(true);
            Desktop desk = Desktop.getDesktop();
            while (rec.getResult() != null) {
                String result = rec.getResult().getHypothesis();
                if (result.toLowerCase().equals("google")){
                    System.out.println("Opening: "+result);
                    URI uri = new URI("http://google.com/");
                    desk.browse(uri);
                }
                if (result.toLowerCase().equals("youtube")){
                    System.out.println("Opening: "+result);
                    URI uri = new URI("http://youtube.com/");
                    desk.browse(uri);
                }
                if (result.toLowerCase().equals("instagram")){
                    System.out.println("Opening: "+result);
                    URI uri = new URI("https://www.instagram.com/");
                    desk.browse(uri);
                }
                if (result.toLowerCase().equals("facebook")){
                    System.out.println("Opening: "+result);
                    URI uri = new URI("https://www.facebook.com/");
                    desk.browse(uri);
                }
                if (result.toLowerCase().equals("linkedin")){
                    System.out.println("Opening: "+result);
                    URI uri = new URI("https://www.linkedin.com/");
                    desk.browse(uri);
                }
                if (result.toLowerCase().equals("github")){
                    System.out.println("Opening: "+result);
                    URI uri = new URI("https://www.github.com/");
                    desk.browse(uri);
                }            
                else if(result.toLowerCase().equals("gmail")){
                    System.out.println("Opening: "+result);
                    URI uri = new URI("https://www.gmail.com/");
                    desk.browse(uri);
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}