package uno.allen.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * Created by allen on 15-12-11.
 */
public class County extends Model<County> {
    public static final County dao = new County();
    public String getCityName(){
        City city = City.dao.findById(County.dao.getInt("id"));
        return city.getStr("CityName");
    }
}
