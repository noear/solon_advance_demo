package demo.dso;

import org.noear.grit.model.domain.Subject;
import org.noear.grit.solon.SessionBase;

/**
 * @author noear 2014-10-19
 * @since 1.0
 */
public final class Session extends SessionBase {
    private static Session current = new Session();
    public static Session current(){
        return current;
    }

    @Override
    public void loadSubject(Subject subject) throws Exception {
        setSubjectId(subject.subject_id);
        setLoginName(subject.login_name);
        setDisplayName(subject.display_name);
    }
}
