package webService;

import DAO.ClassDAO;
import model.Class;

import java.util.Queue;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(endpointInterface = "webService.ClassWS")
public class ClassWSImpl implements ClassWS{

    @Override
    public String addClass(@WebParam String name, @WebParam String code) {
        String result = null;
        ClassDAO classDAO = new ClassDAO();
        Queue<Class> classQueue = classDAO.getClasses();
        if(classQueue.add(new Class(name, code))){
            classDAO.addClass(name, code);
            result = "thành công";
        }else{
            result = "Thêm sinh viên thất bại do class không tồn tại";
        }
        return result;
    }
}
