package co.kr.circus.sauceweb.test.controller;

import co.kr.circus.sauceweb.test.service.TestService;
import co.kr.circus.sauceweb.utils.CommonMsg;
import co.kr.circus.sauceweb.utils.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/test/v1")
@Api(tags = {"테스트 API "})
@RequiredArgsConstructor
public class TestController {

    @Resource(name="testservice")
    private TestService testservice;

    private CommonMsg cms = new CommonMsg();


    @RequestMapping(value="/mytest",method= {RequestMethod.POST,RequestMethod.GET})
    public ResponseEntity<String> getmyAll(){

        try {

            List<Map<String,Object>> resultset = testservice.getAll();
            return Utils.responseentity(cms.getRsultListVlues(200, "Success!", true, resultset));
        }catch(Exception e) {

            e.printStackTrace();
        }
        return null;
    }
}