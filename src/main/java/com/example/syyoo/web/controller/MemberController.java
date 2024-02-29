package com.example.syyoo.web.controller;

import com.example.syyoo.member.Member;
import com.example.syyoo.member.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
/** 기본 경로로 설정 */
@RequestMapping("/members/member")
/** 생성자 자동 생성 */
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    /** 전체 사용자 조회 */
    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "member/members";
    }

    /** 고유번호로 사용자 조회 */
    @GetMapping("/{memSeq}")
    public String member(@PathVariable("memSeq") long memSeq, Model model) {
        Member member = memberRepository.findByMemSeq(memSeq);
        model.addAttribute("member",member);
        System.out.println("member 요소>>>"+member);
        return "member/member";
    }
    /** 고유번호로 사용자 등록 */
    @GetMapping("/add")
    public String addForm() {
        return "member/addForm";
    }
    /** 고유번호로 사용자 등록 */
    @PostMapping("/add")
    public String add(@ModelAttribute Member member) {
        memberRepository.save(member);
        return "member/addForm";
    }
    /** 고유번호로 사용자 수정
     * PathVariable >>> 경로 변수 설정
     * */
    @GetMapping("/{memSeq}/edit")
    public String editForm(@PathVariable("memSeq") long memSeq, Model model) {
        Member member = memberRepository.findByMemSeq(memSeq);
        model.addAttribute("member",member);
        System.out.println("member 요소>>>"+member);
        return "member/editForm";
    }
    /** 고유번호로 사용자 수정
     * ModelAttribute >>> 모델 값을 파라미터로 전송
     * */
    @PostMapping("/{memSeq}/edit")
    public String edit(@PathVariable("memSeq") long memSeq, @ModelAttribute Member member) {
        memberRepository.update(memSeq,member);
        System.out.println("업데이트 완료!!");
        return "redirect:/members/member/{memSeq}";
    }
    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        memberRepository.save(new Member("syyoo", "1234", "유선영", 0, 'Y'));
        memberRepository.save(new Member("msyoo", "1234", "유민서", 1, 'Y'));
    }
}
