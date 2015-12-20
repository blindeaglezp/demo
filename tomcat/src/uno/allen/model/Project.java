package uno.allen.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * Created by allen on 15-12-11.
 */
public class Project extends Model<Project> {
    public static final Project dao = new Project();
    public Subject getSubject(){
        return Subject.dao.findById(getInt("SubjectID"));
    }
    public String getSubjectName(){
        Subject subject = Subject.dao.findById(getInt("SubjectID"));
        return subject.getStr("SubjectName");
    }
}
