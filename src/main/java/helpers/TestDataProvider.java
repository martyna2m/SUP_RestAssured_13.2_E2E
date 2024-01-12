package helpers;

import configuration.DataFromYaml;

import java.util.Map;

public class TestDataProvider {
    private Map<String, Object> testData;


    public TestDataProvider() {
        setTestDataFromYaml(DataFromYaml.data);
    }

    private void setTestDataFromYaml(Map<String, Object> data) {
        this.testData = (Map<String, Object>) data.get("testData");
    }


    public String getTestData(String key) throws NullPointerException {
        try {
            return testData.get(key).toString();
        } catch (Exception e) {
            System.out.println("Property for keyValue: " + key + " is null. Check yaml file.");
        }
        return null;
    }


    public String getTestDataFromSection(String sectionName, String key) throws NullPointerException {
        try {
            Map<String, Object> sectionMap = getSection(sectionName);
            return sectionMap.get(key).toString();
        } catch (Exception e) {
            System.out.println("Property for keyValue: " + key + " is null. Check yaml file.");
        }
        return null;
    }


    private Map<String, Object> getSection(String sectionName) {
        return (Map<String, Object>) testData.get(sectionName);

    }


}
