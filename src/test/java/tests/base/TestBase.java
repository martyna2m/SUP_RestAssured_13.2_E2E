package tests.base;

import configuration.ConfigProvider;
import helpers.DataFaker;
import io.restassured.RestAssured;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import helpers.StudentFactory;
import tests.providers.methods.GetMethodsProvider;
import tests.providers.methods.PostMethodsProvider;
import tests.providers.methods.PutMethodsProvider;

public class TestBase {
    public ConfigProvider configProvider = new ConfigProvider();
    public StudentFactory studentFactory = new StudentFactory();
    public GetMethodsProvider getMethodsProvider = new GetMethodsProvider();
    public PostMethodsProvider postMethodsProvider = new PostMethodsProvider();
    public PutMethodsProvider putMethodsProvider = new PutMethodsProvider();
    public SoftAssertions softAssertions = new SoftAssertions();
    public DataFaker dataFaker = new DataFaker();


    @BeforeEach
    void setUp() {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = configProvider.getConfigProperties("baseUrl");
    }


}
