package spring.mvc.board;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.data.BoardDaointer;
import board.data.BoardDto;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDaointer dao;
	
	//리스트 출력문이 나오는 페이지
	@GetMapping("/list") //index시작 경로와 같다
	public ModelAndView list()
	{
		
		ModelAndView model=new ModelAndView();
		int totalCount=dao.getTotalCount();
		List<BoardDto> list=dao.getAllDatas();
		model.addObject("totalCount", totalCount);
		model.addObject("list", list);
		model.setViewName("board/list");
		return model;
	}
	//폼에 입력시 insert되는 페이지
	@PostMapping("/write") //폼의 액션과 일치
	public String insert(@ModelAttribute BoardDto dto)
	{
		dao.insertBoard(dto);
		return "redirect:list";
	}
	
	//리스트의 글쓰기 버튼을 클릭했을 때 폼이 나오도록 매핑처리
	@GetMapping("/writeform") //리스트의 글쓰기버튼
	public String writeform()
	{
		return "board/writeForm";
	}
	
	//리스트에서 제목을 누르면 content로 연결되도록 매핑
	@GetMapping("/content") //리스트의 제목에 a태그로 연결된 이름
	public ModelAndView content(@RequestParam String num)
	{
		ModelAndView model=new ModelAndView();
		BoardDto dto=dao.getData(num);
		model.addObject("dto", dto);
		model.setViewName("board/content");
		return model;
	}
	
	//수정버튼을 누르면 수정하려는 사람의 데이터가 보인다
	@GetMapping("/updateform")
	public ModelAndView updateform(@RequestParam String num)
	{
		ModelAndView model=new ModelAndView();
		BoardDto dto=dao.getData(num);
		model.addObject("dto", dto);
		model.setViewName("board/updateForm");
		return model;
	}
	
	//수정한 후 db수정 누르면 수정되기
	@GetMapping("/update")
	public String update(@ModelAttribute BoardDto dto)
	{
		
		dao.updateBoard(dto);
		return "redirect:list";
	
	}
	
	//삭제한 후 바로 list
	@GetMapping("/delete")
	public String delete(@RequestParam String num)
	{
		dao.deleteBoard(num);
		return "redirect:list";
	}
	
	
}
