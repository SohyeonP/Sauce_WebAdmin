package co.kr.circus.sauceweb.test.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("testdao")
public class TestDAOImpl implements TestDAO{

    @Autowired
    @Qualifier(value="mySqlSessionTemplate")
    private SqlSession mySession;


    private String namespace="co.kr.circus.saceweb.testmapper.";

    @Override
    public List<Map<String, Object>> getmyAll()throws Exception{

        return mySession.selectList(namespace+"getmyAll");

    }

}
