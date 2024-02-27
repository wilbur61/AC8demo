package com.example.AC8demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("u")
public class Session_Controller {

    /*
     * Add user in model attribute
     */
    @ModelAttribute("u")
    public User setUpUserForm() {
        System.out.println("IN setUpUserForm()");
        return new User();
    }
   @GetMapping("/dologin")
   public String doLogin(@ModelAttribute("u") User u, Model model) {
	   	   System.out.println("IN Session_Controller");
           model.addAttribute("FormVar", u);
           return "UserForm";
          // We will create UserForm.html page in next step
       }

   @PostMapping("/Getuser")
   public String userInfo(@ModelAttribute("u") User user, Model model) {
       System.out.println("Email: " + user.getEmail());
       System.out.println("First Name: " + user.getName());
       System.out.println("Id: " + user.getId());
       model.addAttribute("stu",user);
       return "showData";
  // We will create showData.html page in next step
   }
}

