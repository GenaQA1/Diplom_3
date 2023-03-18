package api.apicreateuser;

import api.userprofile.UserProfile;
import io.restassured.response.Response;
import staticvalues.StaticValues;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiCreateUser {


    public UserProfile getCorrectUser() {
        return correctUser;
    }

    public UserProfile getIncorrectUserPassword() {
        return IncorrectUserPassword;
    }

    UserProfile correctUser = new UserProfile("gena.chebotar@mail.ru", "GoLittleRockStar", "MusicApple1");
    UserProfile IncorrectUserPassword = new UserProfile("gena.chebotar@mail.ru", "12345", "MusicApple1");

    public Response responseCreateUsers(UserProfile userProfile) {
        Response response = given()
                .header("Content-type", "application/json")
                .body(userProfile).log().all()
                .post(StaticValues.API_REGISTR);
        return response;
    }

    public void checkCorrectResponseCreateUser(Response response){
        response.then().assertThat().body("success", equalTo(true)).and().statusCode(200);
    }

    public void createAgainUser(Response response) {
        response.then()
                .body("message", equalTo("User already exists"))
                .and()
                .statusCode(403);
    }

    public void checkResponseErrorInBody(Response response) {
        response.then().body("message", equalTo("Email, password and name are required fields"))
                .and()
                .statusCode(403);
    }

    public void deleteUser(Response response) {
        if (response.path("accessToken") != null) {
            given()
                    .auth().oauth2(((response.then().extract().path("accessToken")).toString().replace("Bearer ", "")))
                    .delete(StaticValues.API_DELITE)
                    .then().assertThat().body("message", equalTo("User successfully removed"))
                    .and()
                    .statusCode(202);
        }
    }

}
