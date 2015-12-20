package uno.allen.controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import uno.allen.model.City;
import uno.allen.model.CityRecord;

import java.util.List;

/**
 * Created by allen on 15-12-16.
 */
public class CityRecordController extends Controller {
    public void index(){
        try {
            List<Record> recordList = Db.find("SELECT CityRecord.*,ProvinceRfcName,SubjectName,ProjectName,CityName,Budget,Cost,RecordTime FROM CityRecord inner join ProvinceRfc join City join Subject join Project on CityRecord.ProvinceRfcID=ProvinceRfc.id and CityRecord.SubjectID=Subject.id and CityRecord.ProjectID=Project.id and CityRecord.CityID=City.id;");
            setAttr("recordList",recordList);
            System.out.println(recordList);
            render("CityRecord.html");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void add(){
        List<Record> cityList=Db.find("SELECT * FROM City");
        setAttr("cityList",cityList);
        render("add.html");
    }
    public void save() {
        try {
            getModel(CityRecord.class, "CityRecord").save();
            redirect("/cityrecord");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void byprovincerfc(){
        try {
            int id = getParaToInt(0);
            List<Record> recordList = Db.find("SELECT CityRecord.*,ProvinceRfcName,SubjectName,ProjectName,CityName,Budget,Cost,RecordTime FROM CityRecord inner join ProvinceRfc join City join Subject join Project on CityRecord.ProvinceRfcID=ProvinceRfc.id and CityRecord.SubjectID=Subject.id and CityRecord.ProjectID=Project.id and CityRecord.CityID=City.id where CityRecord.ProvinceRfcID=?;",id);
            setAttr("recordList",recordList);
            System.out.println(recordList);
            render("CityRecord.html");
        }catch (Exception e){
            System.out.println(e);
        }

    }
    public void bycity(){
        try {
            int id = getParaToInt(0);
            List<Record> recordList = Db.find("SELECT CityRecord.*,ProvinceRfcName,SubjectName,ProjectName,CityName,Budget,Cost,RecordTime FROM CityRecord inner join ProvinceRfc join City join Subject join Project on CityRecord.ProvinceRfcID=ProvinceRfc.id and CityRecord.SubjectID=Subject.id and CityRecord.ProjectID=Project.id and CityRecord.CityID=City.id where CityRecord.CityID=?;",id);
            setAttr("recordList",recordList);
            render("CityRecord.html");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
