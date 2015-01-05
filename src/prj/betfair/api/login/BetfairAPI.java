package prj.betfair.api.login;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

public class BetfairAPI {
  private static final String LOGIN_TARGET_ENDPOINT = "https://identitysso.betfair.com/api/login";

  /**
   * This is the login function that will handle the authentication towards Betfair.
   * @param username The Betfair username
   * @param password The Betfair password
   * @param appKey An application key
   * @return An application token to be used when executing operations
   */
  public static ApplicationToken login(String username, String password, String appKey) {
    ClientConfig cc = new ClientConfig().register(new JacksonFeature());
    ApplicationToken response =
        ClientBuilder.newClient(cc)
        .target(LOGIN_TARGET_ENDPOINT)
        .queryParam("username", username)
            .queryParam("password", password)
            .request(MediaType.TEXT_PLAIN_TYPE)
            .header("Accept", " application/json")
            .header("X-Application", appKey)
            .post(Entity.entity("content", MediaType.TEXT_PLAIN_TYPE))
            .readEntity(ApplicationToken.class);

    return response;
  }
}
