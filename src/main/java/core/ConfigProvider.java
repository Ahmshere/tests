package core;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();


    static Config readConfig(){
        return ConfigFactory.systemProperties().hasPath("testProfile") ?
                ConfigFactory.load(ConfigFactory.systemProperties().getString("resources")) :
                ConfigFactory.load("app.conf");

        //     return ConfigFactory.systemProperties().hasPath("testProfile")
         //       ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile")) :
          //      ConfigFactory.load("application.properties");
    }

    // Chitaem configuraciu i poluchaem znachenie s kluchom "*"
    String RUTRACKER_ = "https://rutracker.org/forum/index.php";
    // String RUTRACKER_ = readConfig().getString("rt");
    String URL = readConfig().getString("url");
    String URL_RHYME = readConfig().getString("url_rhyme");
    String UOT_URL = readConfig().getString("url_uni");
    String URL_PRESONUS = readConfig().getString("url_presonus");

    String ADMIN_LOGIN = readConfig().getString("usersParams.admin.login");
}
