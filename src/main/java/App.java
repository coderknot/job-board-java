import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";
    City portland = new City("Portland");
    City seattle = new City("Seattle");
    City spokane = new City("Spokane");

    get("/", (response, request) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      model.put("cities", City.all());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
