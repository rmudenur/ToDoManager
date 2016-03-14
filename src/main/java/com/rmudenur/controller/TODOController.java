package com.rmudenur.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rmudenur.business.TODOService;
import com.rmudenur.dto.DetailsDTO;

/**
 * @author rmudenur
 *
 */
@Controller
public class TODOController {

	@Autowired
	private TODOService todoService;
	
	
    @RequestMapping(value="/", method = {RequestMethod.GET})
    public String rootPage(final HttpServletRequest request,
            final ModelMap model) throws Exception {
        return "redirect:getToDOList"; 
    }

	@RequestMapping(value = "/getToDOList", method = { RequestMethod.GET })
	public String getTodoList(ModelMap model) throws Exception {
		// Call the service with the default user id - 1000
		List<DetailsDTO> lstDetailsDTO = todoService.getTodoList("1000");
		model.addAttribute("lstDetailsDTO", lstDetailsDTO);
		model.addAttribute("objDetailsDTO", new DetailsDTO());
		return "ToDoHome";
	}

	@RequestMapping(value = "/saveToDoDetails", method = { RequestMethod.POST })
	public String saveToDoDetails(final String name, final String description, final HttpServletRequest request,
			final HttpServletResponse response, final ModelMap model) throws Exception {

		DetailsDTO objDetailsDTO = new DetailsDTO();
		objDetailsDTO.setDescription(description);
		objDetailsDTO.setTodoName(name);
		objDetailsDTO.setUserID("1000");
		todoService.addTODO(objDetailsDTO);

		return "redirect:getToDOList";

	}

	@RequestMapping(value = "/updateToDoDetails", method = { RequestMethod.POST })
	public String updateToDoDetails(final String name, final String description, final String todoID,
			final HttpServletRequest request, final HttpServletResponse response, final ModelMap model) throws Exception {

		DetailsDTO objDetailsDTO = new DetailsDTO();
		objDetailsDTO.setDescription(description);
		objDetailsDTO.setTodoName(name);
		objDetailsDTO.setUserID("1000");
		objDetailsDTO.setTodoID(todoID);
		todoService.updateToDo(objDetailsDTO);

		return "redirect:getToDOList";

	}

	@RequestMapping(value = "/deleteToDoDetails", method = { RequestMethod.POST })
	public String deleteToDoDetails(final String todoID, final ModelMap model) throws Exception {

		todoService.deleteToDo(todoID);

		return "redirect:getToDOList";

	}

}
