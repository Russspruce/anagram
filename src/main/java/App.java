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

    get("/results", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/results.vtl");

      String inputtedWord1 = request.queryParams("inputOne");
      String inputtedWord2 = request.queryParams("inputTwo");

      Anagram myAnagram = new Anagram();
      Boolean verifyAnagram = myAnagram.checkAnagram(inputtedWord1, inputtedWord2);
      String result = "";
      if (verifyAnagram.equals(true)) {
        result = String.format("%s and %s are anagrams of each other!", inputtedWord1, inputtedWord2);
      }
      else {
        result = String.format("%s and %s are not anagrams!  Try again.", inputtedWord1, inputtedWord2);
      }

      model.put("result", result);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
