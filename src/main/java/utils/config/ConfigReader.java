package utils.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import java.util.Objects;

@Configuration
@PropertySource("classpath:env/${env:local}.properties")
public class ConfigReader {

    @Autowired
    private Environment env;

    @Bean
    public Config config() {
        Config config = new Config();
        config.setAdapterUrl(env.getProperty("Adapter.Url"));
        config.setAdapterPort(Integer.valueOf(Objects.requireNonNull(env.getProperty("Adapter.Port"))));
        config.setAdapterUser(env.getProperty("Adapter.User"));
        config.setAdapterPassword(env.getProperty("Adapter.Password"));
        config.setAdapterIngestEndpoint(env.getProperty("Adapter.IngestEndpoint"));
        return config;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}

