package uno.allen.Validator;


import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * Created by allen on 15-12-12.
 */
public class ProvinceRecordValidator extends Validator{
    public void validate(Controller c){
        validateRequiredString("ProvinceRecord.ProvinceRfcID","rfcMsg","请输入省文号ID");
        validateRequiredString("ProvinceRecord.SubjectID","subjectMsg","请输入省文号ID");
        validateRequiredString("ProvinceRecord.ProjectID","projectMsg","请输入省文号ID");
        validateRequiredString("ProvinceRecord.Budget","budgetMsg","请输入省文号ID");
    }
    protected void handleError(Controller c){
        c.keepPara();
        c.render("/hello");
    }
}
