package com.example.library.services;

import com.example.library.entites.Member;
import com.example.library.exceptions.ResourceNotFoundException;
import com.example.library.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemberService implements MemberServiceInterface {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(int id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member", "Id", id));
    }

    @Override
    public Member addNewMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member updateMember(int id, Member member) {
        Member existingMember = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member", "Id", id));

        existingMember.setFirstName(member.getFirstName());
        existingMember.setLastName(member.getLastName());
        existingMember.setEmail(member.getEmail());
        existingMember.setPhoneNumber(member.getPhoneNumber());
        existingMember.setDateOfBirth(member.getDateOfBirth());
        existingMember.setAddress(member.getAddress());

        return memberRepository.save(existingMember);
    }

    @Override
    public void deleteMemberById(int id) {
        memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member", "Id", id));
        memberRepository.deleteById(id);
    }
}
