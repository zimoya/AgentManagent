package cn.agent.dao;

import cn.agent.pojo.Appaddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 使用update和delete的时候一定要加上@Modifying这个注解，在这里使用到事务所有必须加上事务如果不加则会Bug" 爆炸~~~"
 */
@RepositoryDefinition(domainClass=Appaddress.class,idClass=Long.class)
public
interface AppaddressDao extends JpaRepository<Appaddress,Long> {

    @Query(value = "from Appaddress  a where a.appid=:appid")
    public
    List<Appaddress> getByAppid(@Param( "a" ) Appaddress a);
}
