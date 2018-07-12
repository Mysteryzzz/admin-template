package test.util;

import java.util.List;

import com.mlearn.util.CacheUtil;
import com.mlearn.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




//@Service
public class EmployeeService {
}
//	// ʵ��ע�� @Resources��@Autowired
////	@Autowired
////	private IEmployeeDao empDao;
////
////	@Autowired
////	private CacheUtil cacheUtil;
////
//	@Override
//	public List<Employee> findAllEmps() {
//		// TODO Auto-generated method stub
//
//		List<Employee> emps = null;
//		try {
//			String info = cacheUtil.hashGet("allemp", "add");
//			if(info == null){
//				emps = empDao.findAll();
//				String jsonInfo = JsonUtil.obj2Json(emps);
//				cacheUtil.hashSet("allemp", "add", jsonInfo);
//			}else{
//				emps = JsonUtil.json2List(info, Employee.class);
//			}
//
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new RuntimeException("��ѯ����Ա������ʧ��");
//		}
//		return emps;
//	}
//
//	@Override
//	public void addEmp(Employee emp) {
//		// TODO Auto-generated method stub
//
//		empDao.add(emp);
//
//
//	}
//
//}
