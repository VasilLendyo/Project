package ua.lviv.lgs.selectionCommittee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.selectionCommittee.domain.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer>{

}
