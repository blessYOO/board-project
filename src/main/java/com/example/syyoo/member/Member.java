package com.example.syyoo.member;

import lombok.Data;

/**
 * 사용자 클래스
 * @author syyoo
 * */
@Data
public class Member {

    private int memSeq;
    private String memId;
    private String memPass;
    private String memName;
    private int memAuth;
    private char useYn;

    public Member() {
    }

    public Member(String memId, String memPass, String memName, int memAuth, char useYn) {
        this.memId = memId;
        this.memPass = memPass;
        this.memName = memName;
        this.memAuth = memAuth;
        this.useYn = useYn;
    }

    public long getMemSeq() {
        return memSeq;
    }

    public void setMemSeq(int memSeq) {
        this.memSeq = memSeq;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getMemPass() {
        return memPass;
    }

    public void setMemPass(String memPass) {
        this.memPass = memPass;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public int getMemAuth() {
        return memAuth;
    }

    public void setMemAuth(int memAuth) {
        this.memAuth = memAuth;
    }

    public char getUseYn() {
        return useYn;
    }

    public void setUseYn(char useYn) {
        this.useYn = useYn;
    }
}
