package prj.betfair.api.session;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

public class BetfairAPI {
  private static final String LOGIN_TARGET_ENDPOINT = "https://identitysso.betfair.com/api/login";
  private static final String LOGOUT_TARGET_ENDPOINT = "https://identitysso.betfair.com/api/logout";
  /**
   * This is the login function that will handle the authentication towards Betfair.
   * @param username The Betfair username
   * @param password The Betfair password
   * @param appKey An application key
   * @return An application token to be used when executing operations
   */
  public static Session login(String username, String password, String appKey) {
    ClientConfig cc = new ClientConfig().register(new JacksonFeature());
    Session response =
        ClientBuilder.newClient(cc)
        .target(LOGIN_TARGET_ENDPOINT)
        .queryParam("username", username)
            .queryParam("password", password)
            .request(MediaType.TEXT_PLAIN_TYPE)
            .header("Accept", " application/json")
            .header("X-Application", appKey)
            .post(Entity.entity("content", MediaType.TEXT_PLAIN_TYPE))
            .readEntity(Session.class);

    return response;
  }
  
  /**
   * Logout
   */
  public static Session logout(Session token) {
    ClientConfig cc = new ClientConfig().register(new JacksonFeature());
    Session response =
        ClientBuilder.newClient(cc)
        .target(LOGOUT_TARGET_ENDPOINT)
            .request(MediaType.TEXT_PLAIN_TYPE)
            .header("Accept", " application/json")
            .header("X-Authentication", token.getToken())
            .post(Entity.entity("content", MediaType.TEXT_PLAIN_TYPE))
            .readEntity(Session.class);

    return response;
  }
}
