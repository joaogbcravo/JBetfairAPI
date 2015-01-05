JBetfairAPI
===========

A JAVA Implementation of the Betfair exchange API (NG)

####How to use
To be able to use this API implementation you need to have a functioning Betfair account, you can create one at www.betfair.com. Apart from a regular betting account you also need to have an application key to get access to the Betfair REST interface that this API relies on. Information on how to create an application key can be found here: https://api.developer.betfair.com/services/webapps/docs/x/PYAS

The API implementation currently supports the following operations:
- listEventTypes
- listCompetitions
- listTimeRanges
- listEvents
- listMarketTypes
- listCountries
- listVenues
- listMarketCatalogue
- listMarketBook
- listMarketProfitAndLoss
- listCurrentOrders
- listClearedOrders
- placeOrders
- cancelOrders
- replaceOrders
- updateOrders

####Example code
######Login to the Betfair Exchange and retrieve a list of Soccer events in Britain
```Java
    // Login to the betfair API service
    ApplicationToken token = BetfairAPI.login("user", "pass", "appKey");
    // Check that login went OK 
    if (token.getStatus().equals(SimpleTypes.LoginStatusCode.SUCCESS)) {
      System.out.println("Failed to login with StatusCode: " + token.getStatus() + " error: "
          + token.getError());
      System.exit(1);
    }
    
    // Create a executor with the credentials retrieved at login
    Executor exec = new BetfairExecutor();
    exec.setApplicationToken(token);

    // Create an OperationBuilder, this is a convenience class to create operation objects
    OperationBuilder opf = new OperationBuilder(exec);
    
    // Countries to include
    HashSet<String> countries = new HashSet<String>();
    countries.add("GB");
    
    // Create a market filter that filters out inplay Soccer competitions
    MarketFilter filter = new MarketFilter.Builder()
    .withTextQuery("Soccer")
    .withMarketCountries(countries)
    .build();
    
    // Execute the listComptetions operation
    ArrayList<EventResult> results = opf.listEvents(filter).build().execute();
    
    // Print retrieved competitions
    for(EventResult result : results) {
      System.out.println(result.getEvent().getOpenDate().toString() + " " + result.getEvent().getName());
    }
    
  }
```
