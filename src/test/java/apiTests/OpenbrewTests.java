package apiTests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.hc.core5.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

public class OpenbrewTests {

    static RequestSpecification requestSpec;
    static ResponseSpecification responseSpec;

//    @BeforeAll
//    public static void setup() {

//        requestSpec = new RequestSpecBuilder()
//                .setBaseUri("https://jsonplaceholder.typicode.com")
//                .setContentType(ContentType.JSON)
//                .build();
//
//        responseSpec = new ResponseSpecBuilder()
//                .expectResponseTime(Matchers.lessThan(5L), TimeUnit.SECONDS)
//                .expectContentType(ContentType.JSON)
//                .build();
//
//        RestAssured.requestSpecification = requestSpec;
//        RestAssured.responseSpecification = responseSpec;
 //   }

    @Test
    public void getAllUsersTest() {
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void getUserWithIdTest() {
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users/1")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void testGetPosts2() {
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users/1/comments")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void testGetPosts3() {
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users/1/comments?postId=1")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void testGetPosts4() {
        given()
                .when()
                .post("https://jsonplaceholder.typicode.com/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void testGetPosts5() {
        given()
                .when()
                .put("https://jsonplaceholder.typicode.com/posts/10")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void testGetPosts6() {
        given()
                .when()
                .delete("https://jsonplaceholder.typicode.com/posts/10")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }


//    @Test
//    public void testGetPostByIdUsingPathParam() {
//
//        int pathParam = 1;
//        String partialExpectedTitle = "provident";
//
//        RestAssured
//                .given()
//                .pathParam("id", pathParam)
//                .when()
//                .get("posts/{id}")
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.SC_OK)
//                .body("title", Matchers.contains(partialExpectedTitle));
//    }
//
//    @Test
//    public void testGetPostByIdUsingQueryParam() {
//
//        String queryParam = "Veronica_Goodwin@timmothy.net";
//        String expectedTitle = "fugit labore quia mollitia quas deserunt nostrum sunt";
//
//        RestAssured
//                .given()
//                .queryParam("email", queryParam)
//                .when()
//                .get("/comments")
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.SC_OK)
//                .body("name", Matchers.equalTo(expectedTitle));
//    }

}
