package team.mjguri.springboot_hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import team.mjguri.springboot_hello.repository.MemberRepository;
import team.mjguri.springboot_hello.repository.MemoryMemberRepositoty;
import team.mjguri.springboot_hello.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepositoty();
    }

}
