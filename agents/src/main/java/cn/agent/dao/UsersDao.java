package cn.agent.dao;

import cn.agent.pojo.Appaddress;
import cn.agent.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;


/**
 * 使用update和delete的时候一定要加上@Modifying这个注解，在这里使用到事务所有必须加上事务如果不加则会Bug" 爆炸~~~"
 * Query注解中加入nativeQuery=true 属性表示使用原生sql，否则默认是hql（实体类查）
 */
@RepositoryDefinition(domainClass= Users.class,idClass=Long.class)
public
interface UsersDao extends JpaRepository<Users,Long> {
    /**
     * 根据用户名查询用户信息，实现登录功能
     * @param username
     * @return
     */
    Users findUsersByUsername(String username);

}
