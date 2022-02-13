package team.mjguri.springboot_hello.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import team.mjguri.springboot_hello.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class MemoryMemberRepositotyTest {

    MemoryMemberRepositoty repositoty = new MemoryMemberRepositoty();

    @AfterEach
    public void afterEach(){
        repositoty.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repositoty.save(member);

        Member result = repositoty.findById(member.getId()).get();
        //System.out.println("result = " + (result == member));
        //Assertions.assertEquals(member, null);
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repositoty.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repositoty.save(member2);

        Member result = repositoty.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repositoty.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repositoty.save(member2);

        List<Member> result = repositoty.findAll();

        assertThat(result.size()).isEqualTo(2);
    }


}
