package controller.comm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;

import model.service.UserManager;
import model.User;

public class DeleteCommunityController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(DeleteCommunityController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		String deleteCommunity = request.getParameter("commId");
    	log.debug("Delete Community : {}", deleteCommunity);

    	UserManager manager = UserManager.getInstance();		
//		HttpSession session = request.getSession();	
//	
//		if ((UserSessionUtils.isLoginUser("admin", session) && 	// �α����� ����ڰ� �������̰� 	
//			 !deleteId.equals("admin"))							// ���� ����� �Ϲ� ������� ���, 
//			   || 												// �Ǵ� 
//			(!UserSessionUtils.isLoginUser("admin", session) &&  // �α����� ����ڰ� �����ڰ� �ƴϰ� 
//			  UserSessionUtils.isLoginUser(deleteId, session))) { // �α����� ����ڰ� ���� ����� ��� (�ڱ� �ڽ��� ����)
				
		manager.removeComm(deleteCommunity);				// ����� ���� ����
//			if (UserSessionUtils.isLoginUser("admin", session))	// �α����� ����ڰ� ������ 	
//				return "redirect:/user/list";		// ����� ����Ʈ�� �̵�
//			else 									// �α����� ����ڴ� �̹� ������
//				return "redirect:/user/logout";		// logout ó��
		
		
		/* ������ �Ұ����� ��� */
		//User user = manager.findUser(deleteId);	// ����� ���� �˻�
		//request.setAttribute("user", user);						
		//request.setAttribute("deleteFailed", true);
		//String msg = (UserSessionUtils.isLoginUser("admin", session)) 
		//		   ? "�ý��� ������ ������ ������ �� �����ϴ�."		
		//		   : "Ÿ���� ������ ������ �� �����ϴ�.";													
		//request.setAttribute("exception", new IllegalStateException(msg));            
		return "redirect:/coummunity/list";		// ����� ���� ȭ������ �̵� (forwarding)	
	}
}
