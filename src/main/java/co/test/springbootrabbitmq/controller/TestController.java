package co.test.springbootrabbitmq.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/test")
public class TestController {

  /**
   * Test.
   *
   * @return the string
   */
  @GetMapping("")
  public String test() {
    return "Hello springboot-consumer service running...";
  }
}
