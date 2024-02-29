package com.example.syyoo.member;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 멤버 리포지토리 클래스
 * @author syyoo
 * */
@Repository
public class MemberRepository {

    private static final Map<Long, Member> store = new HashMap<>(); //static
    private static int sequence = 0; //static

    /** 사용자 저장 */
    public Member save(Member member) {
        member.setMemSeq(++sequence);
        store.put(member.getMemSeq(), member);
        return member;
    }

    /** 상세조회(고유번호) */
    public Member findByMemSeq(long memSeq) {
        return store.get(memSeq);
    }

    /** 상세조회 */
    public Member findById(int memId) {
        return store.get(memId);
    }

    /** 전체조회 */
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    /** 수정저장 */
    public void update(long memSeq, Member updateParam) {
        Member findMember = findByMemSeq(memSeq);
        findMember.setMemName(updateParam.getMemName());
        findMember.setMemId(updateParam.getMemId());
        findMember.setMemPass(updateParam.getMemPass());
        findMember.setMemAuth(updateParam.getMemAuth());
        findMember.setUseYn(updateParam.getUseYn());
    }

    /** 맵 데이터 초기화 */
    public void clearStore() {
        store.clear();
    }


}
