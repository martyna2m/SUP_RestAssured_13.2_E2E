package tests.base;

import configuration.ConfigProvider;
import helpers.DataFaker;
import helpers.StudentFactory;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import tests.providers.methods.MethodsDELETE;
import tests.providers.methods.MethodsGET;
import tests.providers.methods.MethodsPOST;
import tests.providers.methods.MethodsPUT;

public class TestBase {
    public ConfigProvider configProvider = new ConfigProvider();
    public MethodsGET methodsGET = new MethodsGET();
    public MethodsPOST methodsPOST = new MethodsPOST();
    public MethodsDELETE methodsDELETE = new MethodsDELETE();
    public MethodsPUT methodsPUT = new MethodsPUT();
    public StudentFactory studentFactory = new StudentFactory();
    public DataFaker dataFaker = new DataFaker();


    @BeforeEach
    void setUp() {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = configProvider.getConfigProperties("baseUrl");
    }


}
