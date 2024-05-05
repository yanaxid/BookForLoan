package repository;


import java.util.ArrayList;
import java.util.List;

import member.Member;

public class RepositoryMember {
    

    public List<Member> getAllMember(){

        List<Member> listMember = new ArrayList<Member>();
        
        Member risman = new Member("M-001", "Risman", "Bandung");
        Member budi = new Member("M-002", "Budi", "Bandung");
        Member resti = new Member("M-003", "Resti", "Kab.Bandung");
        
        listMember.add(risman);
        listMember.add(budi);
        listMember.add(resti);
      
        return listMember;
    }
}
