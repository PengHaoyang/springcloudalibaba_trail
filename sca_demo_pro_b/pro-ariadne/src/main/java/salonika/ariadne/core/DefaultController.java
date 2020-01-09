package salonika.ariadne.core;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: penghaoyang
 * @Date: 2020/1/7 11:33
 * @Description: DefaultController
 */
@RestController
public class DefaultController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("hello, Ariadne");
    }

}
