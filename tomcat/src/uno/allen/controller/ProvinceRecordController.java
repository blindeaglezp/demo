package uno.allen.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import uno.allen.Validator.ProvinceRecordValidator;
import uno.allen.model.*;
import java.util.List;

/**
 * Created by allen on 15-12-11.
 */

public class ProvinceRecordController extends Controller{
    public void index(){
//        City city;
//        List<City> cityList = City.dao.find("select * from City");
//        System.out.println(cityList);
//        List<Record> cityList = Db.find("select City.*,County.CountyName from City inner join County on City.id = County.CityID");
        try {
            List<Record> recordList = Db.find("SELECT ProvinceRecord.*,ProvinceRfcName,SubjectName,ProjectName,Budget,Cost,RecordTime FROM ProvinceRecord inner join ProvinceRfc join Subject join Project on ProvinceRecord.ProvinceRfcID=ProvinceRfc.id and ProvinceRecord.SubjectID=Subject.id and ProvinceRecord.ProjectID=Project.id;");
            System.out.println(recordList);
            setAttr("recordList",recordList);
            render("ProvinceRecord.html");
        }catch (Exception e){
            System.out.println(e);
        }

    }
    public void byprovincerfc(){
        int id = getParaToInt(0);
        List<Record> recordList = Db.find("SELECT ProvinceRecord.*,ProvinceRfcName,SubjectName,ProjectName,Budget,Cost,RecordTime FROM ProvinceRecord inner join ProvinceRfc join Subject join Project on ProvinceRecord.ProvinceRfcID=ProvinceRfc.id and ProvinceRecord.SubjectID=Subject.id and ProvinceRecord.ProjectID=Project.id where ProvinceRfcID=?;",id);
        System.out.println(recordList);
        setAttr("recordList",recordList);
        render("ProvinceRecord.html");
    }
    public void bysubject(){
        int id = getParaToInt(0);
        List<Record> recordList = Db.find("SELECT ProvinceRecord.*,ProvinceRfcName,SubjectName,ProjectName,Budget,Cost,RecordTime FROM ProvinceRecord inner join ProvinceRfc join Subject join Project on ProvinceRecord.ProvinceRfcID=ProvinceRfc.id and ProvinceRecord.SubjectID=Subject.id and ProvinceRecord.ProjectID=Project.id where ProvinceRecord.SubjectID=?;",id);
        setAttr("recordList",recordList);
        render("ProvinceRecord.html");
    }
    public void byproject(){
        int id = getParaToInt(0);
        List<Record> recordList = Db.find("SELECT ProvinceRecord.*,ProvinceRfcName,SubjectName,ProjectName,Budget,Cost,RecordTime FROM ProvinceRecord inner join ProvinceRfc join Subject join Project on ProvinceRecord.ProvinceRfcID=ProvinceRfc.id and ProvinceRecord.SubjectID=Subject.id and ProvinceRecord.ProjectID=Project.id where ProvinceRecord.ProjectID=?;",id);
        setAttr("recordList",recordList);
        render("ProvinceRecord.html");
    }
    public void add(){
        try {
            render("add.html");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    @Before(ProvinceRecordValidator.class)
    public void save(){
        try {
            getModel(ProvinceRecord.class,"ProvinceRecord").save();
            String provinceRfcID = getPara("ProvinceRecord.ProvinceRfcID");
            String subjectID = getPara("ProvinceRecord.SubjectID");
            String projectID = getPara("ProvinceRecord.ProjectID");

//            CityRecord cityRecord = getModel(CityRecord.class,"CityRecord");
//            cityRecord.set("ProvinceRfcID",provinceRfcID);
//            cityRecord.set("SubjectID",subjectID);
//            cityRecord.set("ProjectID",projectID);
//            cityRecord.save();
//
//            CountyRecord countyRecord = getModel(CountyRecord.class,"CountyRecord");
//            countyRecord.set("ProvinceRfcID",provinceRfcID);
//            countyRecord.set("SubjectID",subjectID);
//            countyRecord.set("ProjectID",projectID);
//            String cityID = getPara("CityRecord.CityID");
//            countyRecord.set("CityID",cityID);
//            countyRecord.save();

            redirect("/provincerecord");
        }catch (Exception e){
            System.out.println(e);
        }

    }

}
