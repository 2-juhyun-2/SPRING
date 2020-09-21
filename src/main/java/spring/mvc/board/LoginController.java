package spring.mvc.board;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.data.MemberDao;

@Controller
public class LoginController {
	
	@Autowired
	MemberDao dao;
	
	
	/*
	 * @GetMapping("/login/login") public String loginform() { return
	 * "/login/loginForm"; }
	 */
	
	@GetMapping("/login/login")
	public ModelAndView loginform(HttpSession session)
	{
		ModelAndView model=new ModelAndView();
		String loginok=(String)session.getAttribute("loginok");
		String id=(String)session.getAttribute("idok");
		String save=(String)session.getAttribute("saveok");
		
		if(loginok==null)
		{
			model.addObject("id", id==null?"":id);
			//처음 세션 사용했을 때 널값이면 대비하기 위해서 
			model.addObject("save",save==null || save.equals("no")?"no":"yes");
			model.setViewName("/login/loginForm");
		}
		else //로그인 성공
		{
			String name=dao.getName(id);
			model.addObject("name", name);
			model.setViewName("/login/logoutForm");
		}
		return model;
	}
	
	//로그인처리
	@PostMapping("/login/loginproc")
	public String loginproc(HttpSession session,
			@RequestParam String id,
			@RequestParam String pass,
			@RequestParam(value="idsave",required = false) String idsave)
	//@RequestParam이 true이므로 아이디 저장상태가 아닐땐 로그인 에러 발생
	{		
		//아이디 저장 체크 안해도 에러 안나게 처리해준 것 
		boolean sw=dao.isLogin(id, pass);
		
		//맞으면 세션에 3가지 저장
		if(sw)
		{
			session.setMaxInactiveInterval(60*60*8); 
			//8시간 동안 세션상태유지 생략하면 30분 유지
			
			session.setAttribute("loginok", "yes");
			session.setAttribute("idok", id);
			
			//아이디저장에 체크안하면 null값이므로
			if(idsave==null)		
				session.setAttribute("saveok", "no");
			else
				session.setAttribute("saveok", "yes");
			
		}
		
		//아이디와 비번이 맞으면 세션저장후 로그아웃폼으로 가야한다
		//맞지않으면 경고메세지 출력후 다시 로그인 
		if(sw)
			return "redirect:login";
		else
		return "/login/passFail";
	}
	
		//로그아웃한 상태...로그아웃누르면 loginok는 지우고 idok는 남겨놓는다
	@GetMapping("/login/logout")	
	public String logout(HttpSession session)
		{
			session.removeAttribute("loginok");  //로그인을삭제
			return "redirect:login";

		}
		
		
}
