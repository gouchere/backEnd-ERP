package com.erp.lymytz.api.repository.jdbc.base.compta;

import com.erp.lymytz.api.model.base.compta.YvsBaseCategorieComptable;
import com.erp.lymytz.api.repository.jdbc.CustomJdbcRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.SqlParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JDBCCategorieComptableRepo implements JDBCEntityRepo<YvsBaseCategorieComptable, Long> {

    @Autowired
    CustomJdbcRepo<YvsBaseCategorieComptable> jdbcRepository;

    public JDBCCategorieComptableRepo() {
        // TODO Auto-generated constructor stub
    }

    public List<YvsBaseCategorieComptable> findAll() {
        String query = "SELECT y.* FROM yvs_base_categorie_comptable y ORDER BY y.designation";
        return jdbcRepository.loadDataWithJdbc(YvsBaseCategorieComptable.class, query);
    }

    public YvsBaseCategorieComptable findById(Long id) {
        String query = "SELECT y.* FROM yvs_base_categorie_comptable y WHERE id=?";
        return jdbcRepository.loadOneWithJdbc(YvsBaseCategorieComptable.class, query, new SqlParams[]{new SqlParams(1, id)});
    }
}
