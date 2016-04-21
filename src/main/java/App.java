import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {

  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // get("/results", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   model.put("template", "templates/results.vtl");
    //
    //   Integer inputtedCents = Integer.parseInt(request.queryParams("userInput"));
    //
    //   Coin myCoin = new Coin();
    //   String exchange = myCoin.runCoin(inputtedCents);
    //
    //   model.put("exchange", exchange);
    //
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

  }
}
