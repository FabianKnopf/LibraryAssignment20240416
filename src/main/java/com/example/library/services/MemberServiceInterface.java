package com.example.library.services;

import com.example.library.entites.Member;
import java.util.List;

public interface MemberServiceInterface {
    List<Member> getAllMembers();
    Member getMemberById(int id);
    Member addNewMember(Member member);
    Member updateMember(int id, Member member);
    void deleteMemberById(int id);
}
