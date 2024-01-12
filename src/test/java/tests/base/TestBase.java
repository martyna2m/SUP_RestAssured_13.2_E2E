package tests.base;

import configuration.ConfigProvider;
import helpers.DataFaker;
import io.restassured.RestAssured;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import helpers.StudentFactory;
import tests.providers.methods.MethodsGET;
import tests.providers.methods.MethodsPOST;
import tests.providers.methods.MethodsPUT;

public class TestBase {
    public ConfigProvider configProvider = new ConfigProvider();
    public StudentFactory studentFactory = new StudentFactory();
    public MethodsGET methodsGET = new MethodsGET();
    public MethodsPOST methodsPOST = new MethodsPOST();
    public MethodsPUT methodsPUT = new MethodsPUT();
    public SoftAssertions softAssertions = new SoftAssertions();
    public DataFaker dataFaker = new DataFaker();


    @BeforeEach
    void setUp() {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = configProvider.getConfigProperties("baseUrl");
    }


}
