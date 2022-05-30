package com.erp.lymytz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.erp.lymytz.api.commons.ConstantesManager;
import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import com.erp.lymytz.api.repository.jdbc.IntrospectEntity;


@SpringBootApplication
public class BackEndErpApplication {

	public static void main(String[] args) {
		//test les regex d'une requete
//		String s="SELECT * from table where name=:Zp1 AND jeux=:etra AND param=:chemp";
//		Pattern pattern=Pattern.compile(ConstantesManager.regexParam);
//		Matcher result=pattern.matcher(s);
//		System.err.println("total: "+result.groupCount());
//		while(result.find()) {
//			System.err.println("W: "+result.group());
//		}
//		IntrospectEntity<YvsBaseArticles> in=new IntrospectEntity<>();
//		in.introspect(new YvsBaseArticles());
		SpringApplication.run(BackEndErpApplication.class, args);
	}

}
