package ua.lviv.lgs.selectionCommittee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.lgs.selectionCommittee.domain.Submission;

public interface SubmissionRepository extends JpaRepository<Submission, Integer>{

}
