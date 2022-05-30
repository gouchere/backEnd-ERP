package com.erp.lymytz.api.repository.jdbc.base.compta;

import com.erp.lymytz.api.model.base.compta.YvsBaseNatureCompte;
import com.erp.lymytz.api.repository.jdbc.CustomJdbcRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.SqlParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JDBCNatureCompteRepo implements JDBCEntityRepo<YvsBaseNatureCompte, Long> {

    @Autowired
    CustomJdbcRepo<YvsBaseNatureCompte> jdbcRepository;

    public JDBCNatureCompteRepo() {
        // TODO Auto-generated constructor stub
    }

    public List<YvsBaseNatureCompte> findAll() {
        String query = "SELECT y.* FROM yvs_base_nature_compte y ORDER BY y.designation";
        return jdbcRepository.loadDataWithJdbc(YvsBaseNatureCompte.class, query);
    }

    public YvsBaseNatureCompte findById(Long id) {
        String query = "SELECT y.* FROM yvs_base_nature_compte y WHERE id=?";
        return jdbcRepository.loadOneWithJdbc(YvsBaseNatureCompte.class, query, new SqlParams[]{new SqlParams(1, id)});
    }
}
