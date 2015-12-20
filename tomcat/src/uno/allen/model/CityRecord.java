package uno.allen.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * Created by allen on 15-12-11.
 */
public class CityRecord extends Model<CityRecord> {
    public static final CityRecord dao = new CityRecord();

    public City getCity(){
        return City.dao.findById(get("CityID"));
    }
    public ProvinceRfc getProvinceRfc(){
        return ProvinceRfc.dao.findById(get("ProvinceRfcID"));
    }
    public Subject getSubject(){
        return Subject.dao.findById(get("SubjectID"));
    }
    public Project getProject(){
        return Project.dao.findById(get("ProjectID"));
    }
}
