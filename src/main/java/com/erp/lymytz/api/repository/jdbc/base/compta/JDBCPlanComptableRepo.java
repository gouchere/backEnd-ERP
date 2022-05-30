package com.erp.lymytz.api.repository.jdbc.base.compta;

import com.erp.lymytz.api.model.base.compta.YvsBasePlanComptable;
import com.erp.lymytz.api.repository.jdbc.CustomJdbcRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.SqlParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JDBCPlanComptableRepo implements JDBCEntityRepo<YvsBasePlanComptable, Long> {

    @Autowired
    CustomJdbcRepo<YvsBasePlanComptable> jdbcRepository;

    public JDBCPlanComptableRepo() {
        // TODO Auto-generated constructor stub
    }

    public List<YvsBasePlanComptable> findAll() {
        String query = "SELECT y.* FROM yvs_base_plan_comptable y ORDER BY y.intitule";
        return jdbcRepository.loadDataWithJdbc(YvsBasePlanComptable.class, query);
    }

    public YvsBasePlanComptable findById(Long id) {
        String query = "SELECT y.* FROM yvs_base_plan_comptable y WHERE id=?";
        return jdbcRepository.loadOneWithJdbc(YvsBasePlanComptable.class, query, new SqlParams[]{new SqlParams(1, id)});
    }
}
