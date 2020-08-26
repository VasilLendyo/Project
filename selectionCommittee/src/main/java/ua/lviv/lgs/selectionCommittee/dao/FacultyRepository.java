package ua.lviv.lgs.selectionCommittee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.lgs.selectionCommittee.domain.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer>{

}
