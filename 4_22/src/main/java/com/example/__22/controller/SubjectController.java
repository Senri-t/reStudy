package com.example.__22.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.__22.Entity.SubjectEntity;
import com.example.__22.form.SubjectForm;
import com.example.__22.service.SubjectService;

@Controller
public class SubjectController {



@Autowired
    SubjectService subjectService;


 /**
  * @param  
  * @return 
  */
 @RequestMapping("/subject/list")
 public String subjectList(Model model) {
    List<SubjectEntity> subjectlist = subjectService.searchAll();
    model.addAttribute("subjectlist", subjectlist);
   return "subject/list";
 }
 
 /**
 * @param  
 * @return 
 */
@GetMapping("/subject/add")
public String subjectRegister(Model model) {
  model.addAttribute("subjectRequest", new SubjectForm());
  return "subject/add";
}

/**
 * @param 
 * @param  
 * @return  
 */
@PostMapping("/subject/create")
public String subjectCreate(@Validated SubjectForm subjectRequest, BindingResult result, Model model) {
  if (result.hasErrors()) {
    // 入力エラーの場合
    List<String> errorList = new ArrayList<String>();
    for (ObjectError error : result.getAllErrors()) {
      errorList.add(error.getDefaultMessage());
    }
    model.addAttribute("subjectRequest", new SubjectForm());
    model.addAttribute("validationError", errorList);
    return "subject/add";
  }
  subjectService.create(subjectRequest);
  return "redirect:/subject/list";
}
 


/**
 * @param  
 * @param 
 * @return  
 */
@GetMapping("/subject/{id}/edit")
public String userEdit(@PathVariable  Integer id, Model model) {
    SubjectEntity subject = subjectService.findById(id);
    SubjectForm subjectUpdateRequest = new SubjectForm();
    subjectUpdateRequest.setId(subject.getBookid());
    subjectUpdateRequest.setTitle(subject.getTitle());
    subjectUpdateRequest.setName(subject.getName());
    model.addAttribute("subjectUpdateRequest", subjectUpdateRequest);
    return "subject/edit";
}
/**
 * @param  
 * @param  
 * @return  
 */
@PostMapping("/subject/update")
public String subjectUpdate(@Validated  @ModelAttribute  SubjectForm subjectUpdateRequest, BindingResult result, Model model) {
    if (result.hasErrors()) {
        List<String> errorList = new ArrayList<String>();
        for (ObjectError error : result.getAllErrors()) {
            errorList.add(error.getDefaultMessage());
        }
        model.addAttribute("validationError", errorList);
        return "subject/edit";
    }
    subjectService.update(subjectUpdateRequest);
    return "redirect:/subject/list";
}
 

/**
* @param  
* @param  
* @return  
*/
@GetMapping("/subject/{id}/delete")
public String subjectDelete(@PathVariable Integer id, Model model) {
	subjectService.delete(id);
	return "redirect:/subject/list";
}
 
}
