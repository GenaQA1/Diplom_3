package api.apiauthuser;

import api.userprofile.UserProfile;
import io.restassured.response.Response;
import urls.URLs;

import static io.restassured.RestAssured.given;

public class ApiAuthUser {

    public Response authUser(UserProfile userProfile){
        Response response = given()
                .header("Content-type", "application/json")
                .body(userProfile)
                .post(URLs.API_AUTH);
        return response;
    }
}
