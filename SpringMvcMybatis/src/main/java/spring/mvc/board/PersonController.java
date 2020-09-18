package spring.mvc.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import person.data.PersonDao;
import person.data.PersonDto;

@Controller
public class PersonController {
   
   @Autowired
   PersonDao dao;
   
   @GetMapping("/person/list")
   public ModelAndView list()
   {
      ModelAndView model = new ModelAndView();
      
      //dao에서 전체데이터를 db로부터 가져온다.
      
      List<PersonDto>list=dao.getAllDatas();
      //request의 list를 추가한다.
      model.addObject("list", list);
      model.addObject("cnt", list.size());
      //포워드할 jsp를 지정한다.
      model.setViewName("person/personList");
      return model;
   }
   
   //자료입력하기 버튼을 누르면 폼이 나오게
   @GetMapping("/person/personform")
   public String inputform()
   {
	   return "person/personForm";
   }
   
   //폼 입력 후 저장 버튼을 누르면 입력한 값이 저장되게
   @GetMapping("/person/insert")
   public String insert(@ModelAttribute PersonDto dto)
   {
	   dao.insertPerson(dto);
	   return "redirect: list";
   }
   
   //리스트에서 수정버튼을 누르면 수정폼이 나오게
   @GetMapping("/person/updateform")
   public ModelAndView updateform(@RequestParam String num)
   
   {
	   ModelAndView model=new ModelAndView();
	   PersonDto dto=dao.getData(num);
	   model.addObject("dto", dto);
	   model.setViewName("person/personUpdateForm"); //jsp파일
	   return model;
   }
   
   //폼 입력 후 수정이 되게 
   @GetMapping("/person/update")
   public String update(@ModelAttribute PersonDto dto)
   {
	   dao.updatePerson(dto);
	   return "redirect: list";
   }
   
   //삭제클릭하면 삭제되게
   @GetMapping("/person/delete")
   public String delete(@RequestParam String num)
   {
	   dao.deletePerson(num);
	   return "redirect:list";
	   
   }
   
}