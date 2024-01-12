package tests.providers.methods;

import com.fasterxml.jackson.databind.ObjectMapper;
import tests.providers.RequestSpecificationProvider;
import tests.providers.ResponseSpecificationProvider;

import java.util.HashMap;

public class MethodsProviderBase {

    protected RequestSpecificationProvider requestSpecificationProvider = new RequestSpecificationProvider();
    protected ResponseSpecificationProvider responseSpecificationProvider = new ResponseSpecificationProvider();


    protected <T> T convertHashMapToObject(HashMap<String, Object> hashMap, Class<T> objectClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(hashMap, objectClass);
    }
}
