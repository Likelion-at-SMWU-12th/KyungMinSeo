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
    public String getVariable1(@PathVariable("variable") String var) {
        return var;
    }

    @GetMapping(value = "/request1")
    public String GetRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }
}
