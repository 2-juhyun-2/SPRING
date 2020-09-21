package spring.mvc.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.data.BoardDaoInter;
import board.data.BoardDto;

@Controller
public class BoardController {

		@Autowired
		BoardDaoInter dao;
	
		
		//�Խ��� ���
		@GetMapping ("/board/list") //�޴����� �����ϴ� �����ּ� �����
		public ModelAndView list(@RequestParam(value="pageNum",defaultValue="1")int currentPage)
		{
			ModelAndView model=new ModelAndView();
			int totalCount=dao.getTotalCount();
			//����¡ó���� �ʿ��� ����
			int totalPage; //�� ������ ��
			int startNum; //�� �������� ���۹�ȣ
			int endNum; //�� �������� ����ȣ
			int startPage; //���� ����������
			int endPage; //���� ��������
			int no; //����� ���۹�ȣ
			int perPage=5; //�� �������� ������ ���� ����
			int perBlock=5; //�� �������� ������ �������� ����
			
			//�� �������� ���� ���Ѵ�
			totalPage=totalCount/perPage+(totalCount%perPage>0?1:0);
			
			//�������� �ʴ� �������� ��� �������������� ����
			if(currentPage>totalPage)
				currentPage=totalPage;
			
			//�� ���� ������������ �������� ���ϱ�
			//perBlock�� 5�� ���
			//��: ���������� 3�� ��� ���������� 1 �� 5
			//��: ���������� 7�� ��� ���������� 6 �� 10
			//��: ���������� 11�� ��� ���������� 11 �� 15
			
			startPage=(currentPage-1)/perBlock*perBlock+1;
			endPage=startPage+perBlock-1;
			//���������� ���������� �� ���������� ���ƾ���
			if(endPage>totalPage)
				endPage=totalPage;
			
			//�� �������� ���۹�ȣ�� �� ��ȣ ���ϱ�
			//perPage�� 5�� ���
			//��: 1������: ���۹�ȣ:1  ����ȣ:5
			//��: 3������: ���۹�ȣ:1  ����ȣ:15
			startNum=(currentPage-1)*perPage+1;
			endNum=startNum+perPage-1;
			
			//������ �������� �۹�ȣ üũ
			if(endNum>totalCount)
				endNum=totalCount;
			
			//������������ ����� ���۹�ȣ
			//���������� 30�� ��� 1�������� 30, 2�������� 25.....
			no=totalCount-(currentPage-1)*perPage;
			
			//����Ʈ ��������
			List<BoardDto>list=dao.getList(startNum, endNum);
			
			//����¡�� �ʿ��� ������ request�� ����...
			model.addObject("list", list);
			model.addObject("currentPage", currentPage);
			model.addObject("startPage", startPage);
			model.addObject("endPage", endPage);
			model.addObject("no", no);
			model.addObject("totalPage", totalPage);				
			model.addObject("totalCount", totalCount);
			model.setViewName("/board/boardList");
			
			return model;
		}
		
		//�۾��� ������ ���� ���̵���
		@GetMapping("/board/writeform")
		public String form()
		{
			return "/board/boardForm";
		}
		
		
		//���� �� �Է��� ����ǵ���		
		@PostMapping("/board/write")
		public String readData(@ModelAttribute BoardDto dto)
		{
			dao.insertBoard(dto);
			return "redirect:list";
		}
		
		
		//���� ������ content �����
		@GetMapping("/board/content")
		public ModelAndView content(@RequestParam int num,
				@RequestParam int pageNum)
		{
			ModelAndView model=new ModelAndView();
			//��ȸ 1����
			dao.updateReadcount(num);
			//������ ��������
			BoardDto dto=dao.getData(num);
			//�𵨿� ����
			model.addObject("dto", dto);
			model.addObject("pageNum", pageNum);
			model.setViewName("/board/content");
			
			return model;
		}
		
		
		@GetMapping("/board/delete")
		public String delete(@RequestParam int num, 
				@RequestParam String pageNum)
		{
			
			dao.deleteBoard(num);
			return "redirect:list?pageNum="+pageNum;
			
		}
		
		
		 @GetMapping("/board/updateform")
		 public ModelAndView updateform(@RequestParam int num, @RequestParam int pageNum) 
		 { 
			 ModelAndView model=new ModelAndView(); 
			 BoardDto dto=dao.getData(num); 
			 model.addObject("dto", dto);
			 model.addObject("pageNum", pageNum);
			 model.setViewName("/board/updateForm"); 
			 
			 return model;
		 
		 }
		 
		 @PostMapping("/board/update")
		 public String update(@ModelAttribute BoardDto dto, @RequestParam int pageNum)
		 {
			 dao.updateBoard(dto);
			 return "redirect:list?pageNum="+pageNum;
		 }
		
			
		 /*
			 * @GetMapping("/board/updateform") public String updateform() {
			 * 
			 * return "/board/updateForm"; }
			 */
		

	
}
