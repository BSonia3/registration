/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.registrationLogin.web;

import com.example.registrationLogin.model.Role;
import com.example.registrationLogin.model.User;
import com.example.registrationLogin.service.RoleInterface;
import com.example.registrationLogin.service.SecurityService;
import com.example.registrationLogin.service.UserService;
import com.example.registrationLogin.validator.UserValidator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author sonia
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleInterface roleService;
    
    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        
        
         Role role = new Role();
       
         Set<Role> roles = new HashSet<>();
         role.setName("ROLE_USER");
         roles.add(role);
        userForm.setRoles(roles);
        userService.save(userForm);
        roleService.save(role);
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/message";
    }
    

   @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        return "login";
    }

   
    
    @GetMapping("/adminRegistration")
    public String showAdminPage(Model model) {
        model.addAttribute("adminForm", new User());

        return "adminRegistration";
    }
    
    
    @RequestMapping(value="/adminForm",method= RequestMethod.POST)
    public String adminRegistration(HttpServletRequest req) {
    
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setPassword(req.getParameter("passwordConfirm"));
        // All users have ROLE_USER, only add ROLE_ADMIN if the isAdmin 

         Role role = new Role();
        // Role roleAdmin = new Role();
         Set<Role> roles = new HashSet<>();
         String rolename= req.getParameter("roles");
         
         if (rolename==null ||rolename.equalsIgnoreCase("user")) {
       
          role.setName("ROLE_USER");
          roles.add(role);
         }else if(rolename.equalsIgnoreCase("admin")){
           role.setName("ROLE_ADMIN");
     
          roles.add(role);
          }
         
         user.setRoles(roles);
         userService.save(user);
         roleService.save(role);
         securityService.autoLogin(user.getUsername(), user.getPasswordConfirm());

        return "redirect:/message";
    }
    
    
    @RequestMapping("/users")
    public String userPage(Model model) {
    List<User> listUsers = userService.getAllUsers();
    model.addAttribute("listUsers", listUsers);
    return "users";
     }
    
    
    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public ModelAndView showUser(HttpServletRequest request) {
       int id = Integer.parseInt(request.getParameter("id"));
      User user = userService.getUser(id);
       ModelAndView model = new ModelAndView("editRole");
       model.addObject("adminForm", user);
 
        return model;
    }
    
    
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST) 
    public String saveUpdate(HttpServletRequest req,@ModelAttribute("adminForm") User user) {
      
         Role role = new Role();
         Set<Role> roles = new HashSet<>();
        /*   String rolename= req.getParameter("roles");
         
         if (rolename==null ||rolename.equalsIgnoreCase("user")) {
       
          role.setName("ROLE_USER");
          roles.add(role);
         }else if(rolename.equalsIgnoreCase("admin")){
           role.setName("ROLE_ADMIN");
     
          roles.add(role);
          }*/
       
       // All users have ROLE_USER, only add ROLE_ADMIN if the isAdmin 
        // box is checked
        role.setName("ROLE_USER");
         roles.add(role);
        if (null != req.getParameter("isAdmin")) {
           role.setName("ROLE_ADMIN");
           roles.add(role);
        }
         
         user.setRoles(roles);
         userService.save(user);
         roleService.save(role);
                 
                 
	return "redirect:users";
    }
    
    
    @RequestMapping(value="/deleteUser")
   public String deleteUser(@ModelAttribute("user") User user) {
    long id = user.getId();
    userService.deleteUser(id);
    return "redirect:users";       
    }
   
   
  /*  @RequestMapping(value = "/viewUserDetails", method = RequestMethod.GET)
    public String viewDetaisUser(HttpServletRequest request,Model model) {
       int id = Integer.parseInt(request.getParameter("id"));
       User user = userService.getUser(id);
       model.addAttribute("message",user);
      
       return "userDetails";
    }
  */  
 
   
   @RequestMapping(value = "/viewProfile", method = RequestMethod.GET)
    public ModelAndView showUserProfil(HttpServletRequest request) {
       String username = request.getParameter("username");
      User user = userService.findByUsername(username);
       ModelAndView model = new ModelAndView("userProfile");
       model.addObject("user", user);
 
        return model;
    }
    
    
    @RequestMapping(value = "/editProfile", method = RequestMethod.GET)
    public ModelAndView showregistration(HttpServletRequest request) {
       int id = Integer.parseInt(request.getParameter("id"));
      User user = userService.getUser(id);
       ModelAndView model = new ModelAndView("updateProfile");
       model.addObject("userForm", user);
 
        return model;
    }
    
    @RequestMapping(value = "/updateProfile", method = RequestMethod.POST) 
    public String UpdateProfile(@ModelAttribute("user")User user) {
        
		 userService.save(user);
                 
		return "redirect:message";
    }
    
    
}
