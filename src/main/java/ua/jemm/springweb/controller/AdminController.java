package ua.jemm.springweb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.jemm.springweb.controller.dto.StringDto;

@RestController
@RequestMapping("/administration")
public class AdminController {

    @GetMapping
    public ResponseEntity<StringDto> checkPermission(){
        return ResponseEntity.ok(new StringDto("You have admin permission", "Good evening! We are from Ukraine )))"));
    }


}
