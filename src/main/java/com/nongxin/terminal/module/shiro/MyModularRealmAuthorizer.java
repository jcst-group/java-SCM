package com.nongxin.terminal.module.shiro;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author clover
 * @date 2019/6/6
 * @description
 */
public class MyModularRealmAuthorizer extends ModularRealmAuthorizer {


    /*@Override
    public boolean isPermitted(PrincipalCollection principals, String permission) {
        assertRealmsConfigured();
        Object primaryPrincipal = principals.getPrimaryPrincipal();
        for (Realm realm : getRealms()) {
            if (!(realm instanceof Authorizer)) continue;
            if (realm instanceof MyRealm) {
                System.out.println("是MyRealm");
                return ((MyRealm) realm).isPermitted(principals, permission);
            }
            if (realm instanceof AppRealm) {
                System.out.println("是AppRealm");
                return ((AppRealm) realm).isPermitted(principals, permission);
            }
            if (realm instanceof ShowRealm) {
                return ((ShowRealm) realm).isPermitted(principals, permission);
            }
        }
        return false;
        //return super.isPermitted(principals, permission);
    }*/

    @Override
    public boolean isPermitted(PrincipalCollection principals, String permission) {
        assertRealmsConfigured();
        // 所有Realm
        Collection<Realm> realms = getRealms();
        HashMap<String, Realm> realmHashMap = new HashMap<>(realms.size());
        for (Realm realm : realms) {
            if (realm instanceof MyRealm) {
                realmHashMap.put("MyRealm", realm);
            } else if (realm instanceof AppRealm) {
                realmHashMap.put("AppRealm", realm);
            } else if (realm instanceof FinanceRealm) {
                realmHashMap.put("FinanceRealm", realm);
            }
        }

        Set<String> realmNames = principals.getRealmNames();
        if (realmNames != null) {
            String realmName = null;
            Iterator it = realmNames.iterator();
            while (it.hasNext()) {
                realmName = ConvertUtils.convert(it.next());
                if (realmName.contains("MyRealm")) {
                    return ((MyRealm) realmHashMap.get("MyRealm")).isPermitted(principals, permission);
                } else if (realmName.contains("AppRealm")) {
                    return ((AppRealm) realmHashMap.get("AppRealm")).isPermitted(principals, permission);
                }else if (realmName.contains("FinanceRealm")) {
                    return ((FinanceRealm) realmHashMap.get("FinanceRealm")).isPermitted(principals, permission);
                }
                break;
            }
        }
        return false;
    }

}
