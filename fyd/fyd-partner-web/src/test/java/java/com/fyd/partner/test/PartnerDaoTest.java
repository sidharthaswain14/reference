package java.com.fyd.partner.test;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fyd.partner.bo.TermsAndConditionBo;
import com.fyd.partner.bo.UserBo;
import com.fyd.partner.dao.PartnerDaoImpl;
import com.fyd.partner.dao.PartnerDaoSecurity;

public class PartnerDaoTest {
	
	public static void main(String[] args) {


	
	//ApplicationContext context=new ClassPathXmlApplicationContext("META-INF/config/persistence-beans.xml");
		///WEB-INF/config/security-beans.xml

	/*PartnerDaoImpl dao=context.getBean(PartnerDaoImpl.class);
		List<TermsAndConditionBo> conditions=dao.selectPartnerTermsAndcondition();
		for(TermsAndConditionBo condition:conditions){
			System.out.println(condition);
		}
		
	*/	
	/*	dao.updateTermsAndConditionInPartner(15, 1);
		System.out.println("success");*/
		
		//System.out.println(dao.selectRoleId());
		
		//System.out.println(new Timestamp(System.currentTimeMillis()));
	//System.out.println(dao.countUserIdByUserNameAndActivationCode("sidhartha", "12335"));
//	dao.updatePartnerStatus(26, "D");
	
	
	}
}
