/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.registrationLogin.web;

import com.example.registrationLogin.model.Message;
import com.example.registrationLogin.service.MessageService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sonia
 */
@Controller
public class MessageController {
   @Autowired
   MessageService service;

   
   @RequestMapping({"/", "/message"})
    public String messagePage(Model model) {
    List<Message> listMessages = service.getAllMessages();
    model.addAttribute("listMessages", listMessages);
    return "message";
   }
    
   
   
    
   @RequestMapping("/newMessage")
   public String showNewMessagePage(Model model) {
   Message message = new Message();
   model.addAttribute("message", message);
     
    return "newMessage";
   }
   
   @RequestMapping("/addMessage")
   public String AddMessage(@ModelAttribute("message") Message message) {
   service.saveMessage(message);
   return "redirect:message";
   }
   
   @RequestMapping(value="/deleteMessage")
   public String deleteMessage(@ModelAttribute("message") Message message) {
     long id = message.getId();
    service.deleteMessage(id);
    return "redirect:message";       
    }
 
   
   
   
   @RequestMapping(value = "/editMessage", method = RequestMethod.GET)
    public ModelAndView showMessage(HttpServletRequest request) {
       int id = Integer.parseInt(request.getParameter("id"));
       Message m = service.getMessage(id);
       ModelAndView model = new ModelAndView("newMessage");
       model.addObject("message", m);
 
        return model;
    }
    
    
    @RequestMapping(value = "/addMessage", method = RequestMethod.POST) 
    public String saveUpdate(@ModelAttribute("message")Message m) {
        
		 service.saveMessage(m);
                 
		return "redirect:message";
    }
    
    // view details
    
    @RequestMapping(value = "/viewMessageDetails", method = RequestMethod.GET)
    public String viewDetaisMessage(HttpServletRequest request,Model model) {
       int id = Integer.parseInt(request.getParameter("id"));
       Message m = service.getMessage(id);
       model.addAttribute("message",m);
      
       return "messageDetails";
    }
       
    
}
