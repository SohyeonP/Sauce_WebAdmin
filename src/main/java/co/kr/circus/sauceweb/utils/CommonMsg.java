package co.kr.circus.sauceweb.utils;

import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;

public class CommonMsg {

    @SuppressWarnings("unchecked")
    public String getRsultListVlues(int resultcode, String msg, boolean isresult, List<Map<String, Object>> body) {

        JSONObject statusItem = new JSONObject();
        JSONObject resultData = new JSONObject();

        resultData.put("isSuccessful", isresult);
        resultData.put("body", body);
        statusItem.put("code", resultcode);
        statusItem.put("message", msg);
        resultData.put("status", statusItem);

        return resultData.toJSONString();

    }
}
