package e2e;
import org.junit.Test;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;
import play.test.WithApplication;
import static org.assertj.core.api.Assertions.assertThat;
import static play.test.Helpers.GET;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.route;
//WithApplication boots fake Play app and gives 'app' to put requests against
public class HttpEndpointE2ETest extends WithApplication {
    //happy path:hitting /count return 200 with numeric body
    @Test
    public void countEndpointReturnsOkWithNumber() {
        Http.RequestBuilder request = Helpers.fakeRequest(GET, "/count");
        Result result = route(app, request);
        assertThat(result.status()).isEqualTo(200);
        //body string representation of integer
        String body = contentAsString(result);
        assertThat(body).matches("\\d+");
    }
    //error case:route that doesnt exist should give 404
    @Test
    public void unknownRouteReturns404() {
        Http.RequestBuilder request = Helpers.fakeRequest(GET, "/this-route-does-not-exist");
        Result result = route(app, request);

        assertThat(result.status()).isEqualTo(404);
    }
}