package api.apicreateuser;

import api.userprofile.UserProfile;
import io.restassured.response.Response;
import urls.URLs;

import static datauser.DataUser.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiUserClient {

    UserProfile correctUser = new UserProfile(EMAIL_USER, PASSWORD_USER,NAME_USER);
    UserProfile incorrectUserPassword = new UserProfile(EMAIL_USER, INCORRECT_PASSWORD_USER, NAME_USER);


    public UserProfile getCorrectUser() {
        return correctUser;
    }

    public UserProfile getIncorrectUserPassword() {
        return incorrectUserPassword;
    }

    public Response createUser(UserProfile userProfile) {
        Response response = given()
                .header("Content-type", "application/json")
                .body(userProfile)
                .post(URLs.API_REGISTR);
        return response;
    }

    public void deleteUser(Response response) {
        if (response.path("accessToken") != null) {
            given()
                    .auth().oauth2(((response.then().extract().path("accessToken")).toString().replace("Bearer ", "")))
                    .delete(URLs.API_DELITE)
                    .then().assertThat().body("message", equalTo("User successfully removed"))
                    .and()
                    .statusCode(202);
        }
    }

}
