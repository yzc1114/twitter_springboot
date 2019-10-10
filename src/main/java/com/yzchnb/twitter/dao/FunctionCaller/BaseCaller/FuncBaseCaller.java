package com.yzchnb.twitter.dao.FunctionCaller.BaseCaller;

import com.yzchnb.twitter.configs.ExceptionDefinition.InternalException;
import com.yzchnb.twitter.configs.ExceptionDefinition.UserException;
import org.springframework.stereotype.Repository;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Repository
public abstract class FuncBaseCaller {
    protected ArrayList resolveArrayList(Object mapper, Map param) {
        ArrayList res = new ArrayList();
        InternalResolve(mapper, param);
        res.addAll((List)param.get("data"));
        return res;
    }

    protected Integer resolveInteger(Object mapper, Map param) {
        InternalResolve(mapper, param);
        return (Integer) param.get("data");
    }

    protected void resolveVoid(Object mapper, Map param) {
        InternalResolve(mapper, param);
    }

    private void InternalResolve(Object mapper, Map param) {
        try{
            Method ms = mapper.getClass().getMethod("call", Map.class);
            ms.invoke(mapper, param);
        }catch (IllegalAccessException | NoSuchMethodException e){
            System.out.println("mapper called failed... This should never happen.");
            e.printStackTrace();
            throw new InternalException("mapper cannot find method named call");
        }catch (InvocationTargetException e){
            System.out.println("SQL execution failed...");
            e.printStackTrace();
            throwUserException();
        }
        if((int)param.get("return") == 0) {
            throwUserException();
        }

    }

    private void throwUserException(){
        throw new UserException("function call failed: " + this.getClass().getName());
    }
}
