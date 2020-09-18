package member.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	
	@Autowired
	MemberDao dao;
	
	@GetMapping("/member/list")
	public ModelAndView list()
	{
		ModelAndView model=new ModelAndView();
		
		
		List<MemberDto> list=dao.getAllDatas();
		
		model.addObject("cnt", list.size());
		model.addObject("list", list);
		
		model.setViewName("member/memberList");
		
		return model;
	}
	
	@GetMapping("/member/memberform")
	public String inputform()
	{
		return "member/memberForm";
	}
	
	@GetMapping("/member/insert")
	public String insert(@ModelAttribute MemberDto dto)
	{
		dao.insertMember(dto);
		return "redirect: list";
	}
	
	@GetMapping("/member/updateform")
	public ModelAndView updateform(@RequestParam String no)
	{
		ModelAndView model=new ModelAndView();
		MemberDto dto=dao.getData(no);
		model.addObject("dto", dto);
		model.setViewName("member/updateForm");
		
		return model;
	}
	
	@GetMapping("/member/update")
	public String update(@ModelAttribute MemberDto dto)
	{
		dao.updateMember(dto);
		return "redirect: list";
	}

	@GetMapping("/member/delete")
	public String delete(@RequestParam String no)
	{
		dao.deleteMember(no);
		return "redirect: list";
	}
	

}
