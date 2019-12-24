package spring.web;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class Webcontroller {
    @RequestMapping(value = "/data/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MyDataObject findById(@PathVariable long id, HttpServletRequest req, HttpServletResponse res)
    {
        if (req.getHeader("Test") != null) {
            res.addHeader("Test", req.getHeader("Test"));
        }
        return new MyDataObject(id, RandomStringUtils.randomAlphanumeric(10));
    }
}