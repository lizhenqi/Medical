package com.kaishengit.service;

import com.kaishengit.pojo.Role;
import com.kaishengit.pojo.Account;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Administrator on 2016/7/8.
 */
@Named
public class ShiroRealm extends AuthorizingRealm {

    @Inject
    private AccountService accountService;
    @Inject
    private RoleService roleService;

    /**
     * 验证用户是否具有某项权限
     *

     */

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        下面的principalCollection实际就是下面账号验证return new SimpleAuthenticationInfo(user,user.getPassword(),getName())传过来的user;
        Account account = (Account) principalCollection.getPrimaryPrincipal();
        if (account != null) {
//            获取Role对象
            Integer roleid = account.getRole().getId();
            Role role=roleService.findById(roleid);

//           本需求：管理员能看，普通员工不能看
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.addRole(role.getRolename());
            return info;
//            意思即<shiro:hasRole name="经理,员工"></shiro:hasRole>里面的name只有和info利用才能查看里面的内容，多个权限之间用逗号分开。
        }
        return null;
    }


    /**
     * 用来验证用户的账户和密码是否正确
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        authenticationToken是UsernamePasswordToken的父类故要强制类型转换。

        String username = token.getUsername();
        Account account = accountService.findByUsername(username);
        if (account != null) {
            if (!account.getEnable()) {
                throw new LockedAccountException("该账户已被禁用");
//                如果账户被禁用则抛出。
            }

            return new SimpleAuthenticationInfo(account, account.getPassword(), getName());
//            注意上面括号内填写的内容：user、密码和getName()而不是account.getName().此处的getName()是token的
        } else {
            throw new UnknownAccountException("账号或是密码错误！");
        }
    }
}
