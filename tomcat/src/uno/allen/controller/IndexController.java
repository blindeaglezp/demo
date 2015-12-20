package uno.allen.controller;

import com.jfinal.core.Controller;
import uno.allen.model.City;

/**
 * Created by allen on 15-12-11.
 */
public class IndexController extends Controller{
    public void index(){
        render("index.html");
    }
}
