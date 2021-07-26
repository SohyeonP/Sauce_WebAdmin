package co.kr.circus.sauceweb.test.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("testservice")
public class TestServiceImpl implements TestService {

    public List<Map<String, Object>> getAll() throws Exception{
        return null;
    }
}
