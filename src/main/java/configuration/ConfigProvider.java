package configuration;

import java.util.Map;

public class ConfigProvider {
    private Map<String, Object> configProperties;

    public ConfigProvider() {
        setConfigProperties(DataFromYaml.data);
    }

    private void  setConfigProperties(Map<String, Object> data) {
        this.configProperties = (Map<String, Object>) data.get("configurationProperties");
    }

    public String getConfigProperties(String key) throws NullPointerException {
        try {
            return configProperties.get(key).toString();
        } catch (Exception e) {
            System.out.println("Property for keyValue: " + key + " is null. Check yaml file.");
        }
        return null;
    }

}
