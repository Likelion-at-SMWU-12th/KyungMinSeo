package kyungminseo.crud.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/get-api")
public class GetController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        return "Hello World";
    }

    @GetMapping(value = "/name")
    public String getName() {
        return "minseo";
    }

    @GetMapping(value = "variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }
}
