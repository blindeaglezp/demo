package uno.allen.config;

import com.jfinal.config.*;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import uno.allen.controller.CityRecordController;
import uno.allen.controller.ProvinceRecordController;
import uno.allen.controller.IndexController;
import uno.allen.model.*;

/**
 * Created by allen on 15-12-11.
 */
public class demoConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants me) {

        me.setDevMode(true);
//        me.setViewType(ViewType.JSP);
    }

    @Override
    public void configRoute(Routes me) {
        me.add("/", IndexController.class);
        me.add("/provincerecord", ProvinceRecordController.class);
        me.add("/cityrecord", CityRecordController.class);
    }

    @Override
    public void configPlugin(Plugins me) {
        C3p0Plugin cp = new C3p0Plugin("jdbc:mysql://localhost:3306/BFMS",
                "root", "123456");
        me.add(cp);
        ActiveRecordPlugin arp=new ActiveRecordPlugin(cp);
        me.add(arp);
        arp.addMapping("City", City.class);
        arp.addMapping("CityRecord", CityRecord.class);
        arp.addMapping("CityRfc", CityRfc.class);
        arp.addMapping("County", County.class);
        arp.addMapping("CountyRecord", CountyRecord.class);
        arp.addMapping("Project",Project.class);
        arp.addMapping("ProvinceRecord",ProvinceRecord.class);
        arp.addMapping("ProvinceRfc",ProvinceRfc.class);
        arp.addMapping("Subject",Subject.class);

    }

    @Override
    public void configInterceptor(Interceptors me) {

    }

    @Override
    public void configHandler(Handlers me) {

    }
}
