package com.erp.lymytz.api.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.lymytz.api.model.base.YvsDictionnaire;


@Repository
public interface DictionnaireRepo extends JpaRepository<YvsDictionnaire, Long> {

}
