package ua.lviv.lgs.selectionCommittee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.lgs.selectionCommittee.domain.Data;

public interface DataRepository extends JpaRepository<Data, Integer>{

}
