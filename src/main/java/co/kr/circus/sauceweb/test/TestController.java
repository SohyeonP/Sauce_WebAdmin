package co.kr.circus.sauceweb.test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test/v1")
@Api(tags = {"테스트 API "})
@RequiredArgsConstructor
public class TestController {

    @RequestMapping(value = "/")
    @ApiOperation(value = "테스트")
    public String TestAll() {
        return "테스트입니다";
    }
    @RequestMapping(value = "/a")
    @ApiOperation(value = "테스트")
    public String TestOne() {
        return "테스트 입니다";
    }
}