import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class App {
  public static void main(String[] args){
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response)-> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/rectangle", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int intLength = Integer.parseInt(request.queryParams("length"));
      int intWidth = Integer.parseInt(request.queryParams("width"));
      Rectangle newRectangle = new Rectangle(intLength, intWidth);
      model.put("newRectangle", newRectangle);
      if(newRectangle.isSquare()){
          Cube myCube = new Cube(newRectangle);
          model.put("myCube",myCube);
      }



      

      model.put("template", "templates/rectangle.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
