package spring.mvc.board;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import board.data.BoardDto;
import guest.data.GuestDaoInter;
import guest.data.GuestDto;
import guest.data.SpringFileWriter;

@Controller
public class GuestController {
	
	
	@Autowired
	GuestDaoInter dao;
	
	
	/*
	 * //�޴��� ������ �� ����Ʈ�� �̵�
	 * 
	 * @GetMapping("/guest/list") public String list() { return "/guest/guestList";
	 * //Ÿ���� �ּ� }
	 */
	
	@GetMapping("/guest/list")
	public ModelAndView list(
			@RequestParam(value="pageNum", defaultValue="1")
	int currentPage)
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
		int perPage=3; //�� �������� ������ ���� ����
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
		List<GuestDto>list=dao.getList(startNum, endNum);
		
		//����¡�� �ʿ��� ������ request�� ����...
		model.addObject("list", list);
		model.addObject("currentPage", currentPage);
		model.addObject("startPage", startPage);
		model.addObject("endPage", endPage);
		model.addObject("no", no);
		model.addObject("totalPage", totalPage);				
		model.addObject("totalCount", totalCount);
		model.setViewName("/guest/guestList");
		
		return model;
	}
		
	
	//��ư�� ������ ������ �̵�
	@GetMapping("/guest/form")
	public String form()
	{
		return "/guest/guestForm";
	}
	
	//������ ������ �б�
	@PostMapping("/guest/write")
	public String read(@ModelAttribute GuestDto dto, HttpServletRequest request)
	{
		
		//�ϴ� ���ϸ��� ��� �Ѿ���� �� Ȯ��
		for(MultipartFile f:dto.getUpfile())
		{
			System.out.println("���ϸ�: "+f.getOriginalFilename());
		}
		
		//�̹��� ���ε� ���
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/save");
		System.out.println(path);
		
		//path��ο� �̹�������
		SpringFileWriter filewriter=new SpringFileWriter();
		String imagename="";
		
		for(MultipartFile f:dto.getUpfile())
		{
			//���ڿ��� �ƴ� ���� ����
			if(f.getOriginalFilename().length()>0)
			{
				imagename+=f.getOriginalFilename()+",";
				filewriter.writeFile(f, path, f.getOriginalFilename());
			}
		}
		
		if(imagename.length()==0) //�̹���3�� �� �ϳ��� ���þ����� ��
		{
			imagename="noimage";
		}else
		{
			
			//������ �ĸ� ���� 
			imagename=imagename.substring(0, imagename.length()-1);
		}
		
		//dto�� �̹��� �̸��� ����
		dto.setImagename(imagename);
		
		//db�� ����
		dao.insertGuest(dto);
		
		return "redirect:list";
	}
	
	//���ε��� ���� ����, �������� �����̷�Ʈ	
	@GetMapping("/guest/delete")
	public String delete(@RequestParam int num,
			@RequestParam String pageNum,
			HttpServletRequest request)
	{
		//�̹������ε� ���
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/save");
		System.out.println(path);
		
		//db���� �����ϱ� ���� �̹������� ������ �Ѵ�
		String imagename=dao.getData(num).getImagename();
		if(!imagename.equals("noimage"))
		{
			
			//�̹����� �������� ���, �� �и�
			String [] myimg=imagename.split(",");
			
			for(String s:myimg)
			{
				//���ϰ�ü�� ����
				File f=new File(path+"\\"+s);
				//�����Ѵٸ� ����
				if(f.exists())
					f.delete();
			}
		}
		
		//����
		dao.deleteGuest(num);
		
		
		return "redirect:list?pageNum="+pageNum;
		
	}
	
	

}
