package configuration;

import java.util.Map;

public class DataFromYaml {
    private static YamlReader yamlReader = new YamlReader();
    public static Map<String, Object> data = yamlReader.readYamlFile("src/main/resources/config.yaml");

    public DataFromYaml() {

    }
}
