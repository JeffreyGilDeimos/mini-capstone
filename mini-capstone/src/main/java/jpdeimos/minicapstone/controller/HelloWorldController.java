package jpdeimos.minicapstone.controller;

import jpdeimos.minicapstone.model.HelloWorldModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/helloworld")
@RequiredArgsConstructor
public class HelloWorldController {

    @GetMapping("")
    public String getHelloWorld() {
        return "HelloWorld";
    }

    @PostMapping("/custom")
    public String addHelloWorld(@RequestBody HelloWorldModel helloWorldModel) {
        return "Hello ".concat(helloWorldModel.getFirstName()).concat(" ").concat(helloWorldModel.getLastName());
    }

    @PutMapping("/{firstName}/{lastName}")
        public String editHelloWorld (@PathVariable String firstName, @PathVariable String lastName){
        return "Hello " .concat(firstName).concat(" ").concat(lastName).concat("!");
    }
}
