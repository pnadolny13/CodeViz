package restservice;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import codeviz.Run;

@RestController
public class Controller {

    @RequestMapping("/start")
    public String start(@RequestParam(value="path") String path) {
    	try {
			Run.runs("start", path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "unsuccessful";
		}
        return "success";
    }
    
    @RequestMapping("/stop")
    public String stop(@RequestParam(value="path") String path) {
    	try {
			Run.runs("stop", path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "unsuccessful";
		}
        return "success";
    }
    
    @RequestMapping("/restart")
    @ResponseBody
    String restart() {
        return "Hello World!";
    }
//    public static void main(String[] args) throws Exception {
//        SpringApplication.run(Controller_new.class, args);
//    }
}