package co.kr.circus.sauceweb.signup.mapper;

import co.kr.circus.sauceweb.signup.dto.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {
    @Insert("INSERT INTO boss(boss_id, name, phone, birthday, email, username, password, createdAt, updateAt) VALUES(#{member.boss_id}, #{member.name}, #{member.phone}, #{member.birthday}, #{member.email}, #{member.username}, #{member.password}, #{member.createdAt}, #{member.updateAt})")
    int insert(@Param("member") Member member);
}
