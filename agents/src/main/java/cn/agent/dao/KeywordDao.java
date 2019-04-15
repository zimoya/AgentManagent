package cn.agent.dao;

import cn.agent.pojo.Keyword;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;


/**
 * 使用update和delete的时候一定要加上@Modifying这个注解，在这里使用到事务所有必须加上事务如果不加则会Bug" 爆炸~~~"
 * Query注解中加入nativeQuery=true 属性表示使用原生sql，否则默认是hql（实体类查）
 */
@RepositoryDefinition(domainClass= Keyword.class,idClass=Long.class)
public
interface KeywordDao extends JpaRepository<Keyword,Long> {
    @Query(value = "SELECT * FROM KEYWORD WHERE KWNAME = :kwname",
            countQuery = "SELECT count(*) FROM KEYWORD WHERE KWNAME = :kwname",
            nativeQuery = true)
    Page<Keyword> findByKwnamePage(@Param( "kwname" ) String kwname, Pageable pageable);
}
