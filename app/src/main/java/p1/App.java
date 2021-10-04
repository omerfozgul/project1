/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package p1;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

  import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        //port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
          }
          sc1.close();
          System.out.println(inputList);


          /*String input2 = req.queryParams("input2").replaceAll("\\s","");

          java.util.Scanner sc2 = new java.util.Scanner(input2);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> input2List = new java.util.ArrayList<>();
          int sum = 0, i = 0;
          int[] numbers = new  int[3];
          while (sc2.hasNext())
          {
            int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
            numbers[i] = value;
            sum += value;
          }
          sc2.close();

          //int input2AsInt = Integer.parseInt(input2);

          boolean result = App.searchTheSum(inputList, numbers[0], numbers[1], numbers[2]);*/

          String input2 = req.queryParams("input2").replaceAll("\\s","");
          int input2AsInt = Integer.parseInt(input2);

          boolean result = App.search(inputList, input2AsInt);

          Map<String, Boolean> map = new HashMap<String, Boolean>();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map<String, String> map = new HashMap<String, String>();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }


    public static boolean search(ArrayList<Integer> array, int e) {
        System.out.println("inside search");
        if (array == null) return false;
  
        for (int elt : array) {
          if (elt == e) return true;
        }
        return false;
    }

    public static boolean searchTheSum(int[] array, int x, int y, int z){
        System.out.println("inside search");
        if (array == null) return false;
  
        for (int elt : array) {
          if (elt == (x+y+z)) return true;
        }
        return false;
    }

}
