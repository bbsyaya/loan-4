package test.com.hrbb.loan.pos.biz;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.caucho.hessian.client.HessianProxyFactory;
import com.hrbb.loan.pos.biz.hession.LoanPosBlackBizHession;
import com.hrbb.loan.pos.facade.bean.blacklist.BlacklistInfo;
import com.hrbb.loan.pos.facade.bean.blacklist.QueryBlacklistReq;
import com.hrbb.loan.pos.facade.bean.blacklist.QueryBlacklistRes;


public class BasicClientHession{

    public static void main(String[] args) throws MalformedURLException
    {
//        queryFacade();
        queryMap();
    }

    public static void queryFacade() throws MalformedURLException{
        String url ="http://localhost:8080/loan-pos-web/remoting/blacklisthession";
        HessianProxyFactory factory = new HessianProxyFactory();
        LoanPosBlackBizHession basic = (LoanPosBlackBizHession) factory.create(LoanPosBlackBizHession.class, url);
        QueryBlacklistReq req = new QueryBlacklistReq();
        BlacklistInfo  blacklistInfo= new BlacklistInfo();
        blacklistInfo.setId("201503041014298012025");
        blacklistInfo.setInfoType("1");
        req.setBlacklistInfo(blacklistInfo);
        QueryBlacklistRes res = basic.queryBlackListsHession(req);
        System.out.print(res.toString());
    }

    public static void queryMap() throws MalformedURLException{
        String url ="http://localhost:8080/loan-pos-web/remoting/blacklisthession";
        HessianProxyFactory factory = new HessianProxyFactory();
        LoanPosBlackBizHession basic = (LoanPosBlackBizHession) factory.create(LoanPosBlackBizHession.class, url);
        Map<String,Object> reqMap = new HashMap<String,Object>();

        reqMap.put("infoType","1");
        reqMap.put("startPage", 0);
        reqMap.put("limit", 10);
        List<Map<String,Object>> res= basic.queryBlacklistHession(reqMap);
        System.out.print(res.toString());
    }
}