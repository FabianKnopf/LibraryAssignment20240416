package com.example.library.controllers;

import com.example.library.entites.Member;
import com.example.library.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/members")
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/member/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable int id) {
        Member member = memberService.getMemberById(id);
        return ResponseEntity.ok(member);
    }

    @PutMapping("/updatemember/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable int id, @RequestBody Member member) {
        Member updatedMember = memberService.updateMember(id, member);
        return ResponseEntity.ok(updatedMember);
    }

    @PostMapping("/addmember")
    public ResponseEntity<Member> addNewMember(@RequestBody Member member) {
        Member newMember = memberService.addNewMember(member);
        return new ResponseEntity<>(newMember, HttpStatus.CREATED);
    }

    @DeleteMapping("/deletemember/{id}")
    public ResponseEntity<String> deleteMemberById(@PathVariable int id) {
        memberService.deleteMemberById(id);
        return ResponseEntity.ok("Medlem med ID " + id + " har tagits bort.");
    }
}
