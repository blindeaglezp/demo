package uno.allen.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * Created by allen on 15-12-11.
 */
public class CountyRecord extends Model<County> {
    public static final CountyRecord dao = new CountyRecord();
}
