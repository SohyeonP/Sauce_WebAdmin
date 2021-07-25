package co.kr.circus.sauceweb.test.service;

import java.util.List;
import java.util.Map;

public interface TestService {
    List<Map<String, Object>> getAll()throws Exception;
}
