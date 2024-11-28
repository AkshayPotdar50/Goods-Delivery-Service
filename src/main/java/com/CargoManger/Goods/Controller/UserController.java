package com.CargoManger.Goods.Controller;

import com.CargoManger.Goods.Entity.Role;
import com.CargoManger.Goods.Entity.User;
import com.CargoManger.Goods.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody @Valid User user){
        try{
            User registeredUser =userService.registerUser(user);
            return ResponseEntity.ok("User registerd successfully:"+registeredUser.getId());
        }catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }



    @PutMapping("/{userId}/role")
    public ResponseEntity<?> updateUserRole(@PathVariable Long userId, @RequestParam Role newRole){

        try{
            User updatedUser=userService.updateUserRole(userId, newRole);
            return ResponseEntity.ok("user role updated successfully:"+ updatedUser.getRole());

        }catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
