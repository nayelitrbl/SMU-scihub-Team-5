package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.departments;


import views.html.frequentlyAskedQuestions;
import views.html.popularQueries;

/**
 * This controller handles department display information.
 * Each menu item mainly renders a corresponding scala.html page.
 */

public class DepartmentController extends Controller {

    /**
     * This method renders departments.scala.html
     * @return
     */
    public Result departmentList() {
        return ok(departments.render());
    }

}
