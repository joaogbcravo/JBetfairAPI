package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import prj.betfair.api.betting.datatypes.MarketProfitAndLoss;
import prj.betfair.api.betting.datatypes.RunnerProfitAndLoss;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MarketProfitAndLossTest {

  @Test
  public void test() throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    MarketProfitAndLoss mpf =
        mapper.readValue(new File("./src/test/resources/ListMarketProfitAndLossOperation.json"),
            MarketProfitAndLoss.class);
    ArrayList<RunnerProfitAndLoss> profitAndLosses = mpf.getProfitAndLosses();
    assertEquals(profitAndLosses.get(0).getIfWin(), -30.0, 0);
    assertEquals(profitAndLosses.get(0).getIfLose(), 0.0, 0);
    assertEquals(profitAndLosses.get(0).getSelectionId(), 48756);
  }

}
