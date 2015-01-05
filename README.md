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

####Dependencies
Add the following to your pom.xml
```
<dependency>
    <groupId>org.glassfish.jersey.core</groupId>
    <artifactId>jersey-client</artifactId>
    <version>2.13</version>
</dependency>
<dependency>
    <groupId>org.glassfish.jersey.media</groupId>
    <artifactId>jersey-media-json-jackson</artifactId>
    <version>2.13</version>
</dependency>
```
####Example code
######Login to the Betfair Exchange and retrieve a list of Soccer events in Britain
```Java
// Login to the betfair API service
ApplicationToken token = BetfairAPI.login("user", "pass", "appKey");
// Check that login went OK 
if (token.getStatus().equals(SimpleTypes.LoginStatusCode.SUCCESS)) {
    System.out.println("Failed to login with StatusCode: " + token.getStatus() + " error: " + token.getError());
    System.exit(1);
}

// Create a executor with the credentials retrieved at login
Executor exec = new BetfairExecutor();
exec.setApplicationToken(token);

// Create an OperationBuilder, this is a convenience class to create operation objects
OperationBuilder opf = new OperationBuilder(exec);

// Countries to include
Set<String> countries = new HashSet<String>();
countries.add("GB");

// Create a market filter that filters out Soccer events in Great Britain (GB)
MarketFilter filter = new MarketFilter.Builder()
    .withTextQuery("Soccer")
    .withMarketCountries(countries)
    .build();
    
// Execute the listEvents operation
ArrayList<EventResult> results = opf.listEvents(filter).build().execute();
    
// Print retrieved competitions
for(EventResult result : results) {
    System.out.println(result.getEvent().getOpenDate().toString() + " " + result.getEvent().getName());
}
```
######Place 100 Currency units at odds 2.5 on marketid = 1, selection = 0

```Java
Executor exec = new BetfairExecutor();
OperationBuilder opf = new OperationBuilder(exec);
String marketId = "1";
long selectionId = 0;

// Create a LimitOrder
LimitOrder limitOrder = new LimitOrder.Builder(2.5, PersistenceType.PERSIST, 100).build();

// Create a placeInstruction with OrderType = LIMIT, OrderType = BACK
PlaceInstruction instruction = new PlaceInstruction.Builder(OrderType.LIMIT, selectionId, Side.BACK).withLimitOrder(limitOrder).build();

// Create a list of PlaceInstructions and add our order
List<PlaceInstruction> instructions = new ArrayList<PlaceInstruction>();
instructions.add(instruction);

// Place Order
PlaceExecutionReport result = opf.placeOrders(marketId, instructions).build().execute();

//Do something with the result.....
```
