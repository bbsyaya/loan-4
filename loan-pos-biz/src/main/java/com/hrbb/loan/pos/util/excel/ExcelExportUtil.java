/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.util.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosBusinessCodeBiz;
import com.hrbb.loan.pos.dao.entity.TBankAccnoInfo;
import com.hrbb.loan.pos.dao.entity.TCreditApply;
import com.hrbb.loan.pos.dao.entity.TPosSerialnoInfo;
import com.hrbb.loan.pos.service.LoanPosCreditApplyService;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.pos.util.constants.BusinessDictionaryConstants;

/**
 * 
 * @author maosheng
 * @version $Id: ExcelExportUtil.java, v 0.1 2015-5-11 上午10:21:29 maosheng Exp $
 */
public class ExcelExportUtil {
    
    private static final Logger logger = Logger.getLogger(ExcelExportUtil.class);

    //业务数据表头
    private static final String[] BIZDATAHEADER  = new String[]{"no","app_date","dealer","biz_center","product","申请编号","partner","corp_name","客户类型","营业执照编号", "capital",
                                                         "主营业务","营业执照有效期起始日","营业执照有效期到期日","biz_addr","state","city","实际经营地址-具体","股东个数",
                                                         "申请人占股","客户编号","客户姓名","applicant_id","gender","education","yrs_expn","mar_stat","kids",
                                                         "微信号","QQ号","电子邮件","res_bizcity","res_non_bizcity","applicant_mobile","applicant_tel",
                                                         "home_addr","contact_addr","spouse","spouse_id","spouse_mobile","电子邮件","联系地址","微信号","QQ号",
                                                         "apply_amt","suggest_amt","apply_term","收款开户行","银联收款账号","商户快钱POS收款账户","贷款用途","customer_app_date",
                                                         "comments","age","stores","lr_flag","formal_app_flag","preapp_flag","preapp_date","biz_city","推荐机构",
                                                         "推荐人","业务状态","内部意见","外部意见"
                                                        };
    //快钱流水数据表头
    private static final String[] KQPOSSERIALHEADER = new String[]{"渠道","申请人姓名","证件号码","商户名称","交易时间","交易金额","数据导出日期"};    
    //四川烟草流水数据表头
    private static final String[] CYPOSSERIALHEADER = new String[]{"商户编号","交易卡发卡行","交易卡号","姓名","身份证号","金额","交易时间","客户评级"};    
    //易宝流水数据表头
    private static final String[] YBPOSSERIALHEADER = new String[]{"商户名称","商户编号","MCC","交易时间","交易金额","卡号后四位","交易卡种","交易类型"};
    //银联月流水数据表头
    private static final String[] UPMPOSSERIALHEADER = new String[]{"商户名称","商户代码","MCC","交易月份","月交易额","月交易笔数","月交易额同比增幅","月消费客户数","信用卡交易占比","借记卡交易占比"};
    //银联日流水数据表头
    private static final String[] UPDPOSSERIALHEADER = new String[]{"商户名称","商户号 ","MCC","交易时间","交易金额","交易卡号","交易卡种","交易类型","信用卡交易占比","借记卡交易占比"};
    
    
    
    private List<Map<String, Object>> channelDictionary;
    private List<Map<String, Object>> provinceList;
    private List<Map<String, Object>> cities;
    private List<Map<String, Object>> bankAccnoInfoList;
    
    
    
    private  LoanPosCreditApplyService loanPosCreditApplyService;
    

    
      
    public ExcelExportUtil(List<Map<String, Object>> channelDictionary,List<Map<String, Object>> provinceList,List<Map<String, Object>> cities,LoanPosCreditApplyService loanPosCreditApplyService){
        this.channelDictionary = channelDictionary;
        this.provinceList = provinceList;
        this.cities = cities;
        this.loanPosCreditApplyService = loanPosCreditApplyService;
    }
    
    
    
    public void exportBizData(List<Map<String, Object>> list,File file) throws IOException{
        Map reqMap = Maps.newHashMap();
        bankAccnoInfoList = loanPosCreditApplyService.selectBankAccMap(reqMap);
        FileOutputStream o = new FileOutputStream(file);
        HSSFWorkbook wb = new HSSFWorkbook();     
       // Map<String, CellStyle> styles = createStyles(wb);
        HSSFSheet sheet = wb.createSheet("业务数据信息表");
        
        int[] columWidth = {8,15,12,12,12,30,15,25,15,20,15,30,30,30,50,15,15,30,20,20,20,15,25,
                            12,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,
                            15,15,15,15,12,15,10,10,10,10,15,15,15,20,10,10,10,25,25};
        for (int i = 0; i < columWidth.length; i++) {
            sheet.setColumnWidth(i, 256 * columWidth[i]);
        }
        Row headerRow = sheet.createRow(0);
        Cell cell = headerRow.createCell(0);
        
        String [] currentHeaderArr = BIZDATAHEADER;
        for (int i = 0; i < currentHeaderArr.length; i++) {
            cell = headerRow.createCell(i);
            cell.setCellValue(currentHeaderArr[i]);
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
        }
        
     // freeze the first row
        sheet.createFreezePane(0, 1);
        Row row;
        int rownum = 1;
        int i = 1;
        if(list!=null&&list.size()>0){
            for(Map<String, Object> map:list){
                int j = 0;
                row = sheet.createRow(rownum);
                
                cell = row.createCell(j);//序号
                cell.setCellValue(i);
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//app_date
                cell.setCellValue(map.get("beginDate")==null?"":map.get("beginDate").toString().substring(0, 10));
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//dealer
                cell.setCellValue("");
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//biz_center
                cell.setCellValue("");
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//product
                String prodName = "";
                if(StringUtils.isNotEmpty((String)map.get("prodId"))){
                    if("1001020306".equals((String)map.get("prodId"))){
                        prodName = "pos";
                    }else if("1001020305".equals((String)map.get("prodId"))){
                        prodName = "cashflow";
                    }
                }                   
                cell.setCellValue(prodName);
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//申请编号
                cell.setCellValue(map.get("loanId")==null?"":map.get("loanId").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//partner
                String itemName = "";
                String channel = map.get("channel")==null?"":map.get("channel").toString();
                if(StringUtils.isNotBlank(channel)){
                    itemName = getItemName(channel);
                }
                cell.setCellValue(StringUtils.trimToEmpty(itemName));
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//corp_name
                cell.setCellValue(map.get("posCustName")==null?"":map.get("posCustName").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//客户类型
                cell.setCellValue("");
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//营业执照编号
                cell.setCellValue(map.get("regiCode")==null?"":map.get("regiCode").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//capital
                cell.setCellValue(map.get("regCapital")==null?"":map.get("regCapital").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//主营业务
                cell.setCellValue(map.get("posCustBusiScope")==null?"":map.get("posCustBusiScope").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//营业执照有效期起始日
                cell.setCellValue("");
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//营业执照有效期到期日
                cell.setCellValue("");
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                String operAddrCode = map.get("operAddrCode")==null?"":map.get("operAddrCode").toString();
                String province = "";
                if(StringUtils.isNotBlank(operAddrCode)){
                     province = getProvince(operAddrCode.substring(0, 2)+"0000");
                }
                String city = "";
                if(StringUtils.isNotBlank(operAddrCode)){
                    city = getCity(operAddrCode.substring(0, 4)+"00");
                }
                
                cell = row.createCell(j);//biz_addr
                String posCustAddress = map.get("posCustAddress").toString()==null?"":map.get("posCustAddress").toString();
                String bizAddr = province+city+posCustAddress;
                cell.setCellValue(bizAddr);
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//state      
                cell.setCellValue(StringUtils.trimToEmpty(province));
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//city
                cell.setCellValue(StringUtils.trimToEmpty(city));
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//实际经营地址-具体
                cell.setCellValue(map.get("posCustAddress")==null?"":map.get("posCustAddress").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//股东个数
                cell.setCellValue("");
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//申请人占股
                cell.setCellValue("");
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//客户编号
                cell.setCellValue(map.get("custId")==null?"":map.get("custId").toString());                
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//name
                cell.setCellValue(map.get("custName")==null?"":map.get("custName").toString());             
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//applicant_id  
                cell.setCellValue(map.get("paperId")==null?"":map.get("paperId").toString()); 
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//gender   
                cell.setCellValue(map.get("sexSign")==null?"":map.get("sexSign").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//education  
                cell.setCellValue(map.get("educSign")==null?"":map.get("educSign").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//yrs_expn   
                cell.setCellValue(map.get("busiYear")==null?"":map.get("busiYear").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//mar_stat    
                cell.setCellValue(map.get("marrSign")==null?"":map.get("marrSign").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//kids
                cell.setCellValue(map.get("childNum")==null?"":map.get("childNum").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//微信号
                cell.setCellValue(map.get("weixinNo")==null?"":map.get("weixinNo").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//QQ号
                cell.setCellValue(map.get("qqNo")==null?"":map.get("qqNo").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//电子邮件
                cell.setCellValue(map.get("email")==null?"":map.get("email").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//res_bizcity
                cell.setCellValue(map.get("localHouseNum")==null?"":map.get("localHouseNum").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//res_non_bizcity
                cell.setCellValue(map.get("otherHouseNum")==null?"":map.get("otherHouseNum").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//applicant_mobile
                cell.setCellValue(map.get("mobilePhone")==null?"":map.get("mobilePhone").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//applicant_te
                cell.setCellValue(map.get("tel")==null?"":map.get("tel").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//home_addr
                cell.setCellValue(map.get("residentDetail")==null?"":map.get("residentDetail").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//contact_addr
                cell.setCellValue(map.get("contactAddrFlag")==null?"":map.get("contactAddrFlag").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//spouse
                cell.setCellValue(map.get("familyCustName")==null?"":map.get("familyCustName").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//spouse_id
                cell.setCellValue(map.get("matePaperId")==null?"":map.get("matePaperId").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//spouse_mobile
                cell.setCellValue(map.get("mateMobilephone")==null?"":map.get("mateMobilephone").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//电子邮件
                cell.setCellValue("");
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//联系地址
                cell.setCellValue("");
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//微信号
                cell.setCellValue("");
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//QQ号
                cell.setCellValue("");
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//apply_amt
                cell.setCellValue(map.get("applyAmt")==null?"":map.get("applyAmt").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//suggest_amt
                cell.setCellValue("");
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//apply_term
                cell.setCellValue(map.get("applyTerm")==null?"":map.get("applyTerm").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//收款开户行
                String bankAccno = map.get("bankAccno")==null?"":map.get("bankAccno").toString();
                String bankName = "";
                if(StringUtils.isNotBlank(bankAccno)){
                    bankName = getBankName(bankAccno);
                }
                cell.setCellValue(bankName);
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//银联收款账号
                cell.setCellValue(map.get("bankAccno")==null?"":map.get("bankAccno").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//商户快钱POS收款账户
                cell.setCellValue("");
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//贷款用途
                cell.setCellValue(map.get("loanUsage")==null?"":map.get("loanUsage").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//customer_app_date
                cell.setCellValue(map.get("beginDate")==null?"":map.get("beginDate").toString().substring(0, 10));
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//comments
                cell.setCellValue("");
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//age
                String birtDate = map.get("birtDate")==null?"":map.get("birtDate").toString();
                if(StringUtils.isNotEmpty(birtDate)){
                    cell.setCellValue(getAge(birtDate));
                }else{
                    cell.setCellValue("");
                }
                
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//stores
                cell.setCellValue("1");
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//lr_flag
                cell.setCellValue("1");
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//formal_app_flag
                cell.setCellValue("1");
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//preapp_flag
                cell.setCellValue("0");
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//preapp_date
                cell.setCellValue("");
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//biz_city
                cell.setCellValue(province+city);
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//recOrg
                cell.setCellValue(map.get("recOrg")==null?"":map.get("recOrg").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//recPerson
                cell.setCellValue(map.get("recPerson")==null?"":map.get("recPerson").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//业务状态--applyStatus  （因为目前只查询applyStatus=20状态的数据，故设值：资料审核）
                cell.setCellValue("资料审核");
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//内部意见
                cell.setCellValue(map.get("apprInfo")==null?"":map.get("apprInfo").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//外部意见
                cell.setCellValue(map.get("apprInfoExt")==null?"":map.get("apprInfoExt").toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                i++;
                rownum ++;
            }
            exportPosSerialData(wb,list);
        }
        try {
            wb.write(o);
        } catch (IOException e) {
            logger.error("导出文件失败",e);
            throw e;
        }finally{
            o.close();
        }
       
    }
    
    
    
    public void exportPosSerialData(HSSFWorkbook wb,List<Map<String, Object>> list){
        List<TPosSerialnoInfo> allList = null;
        List<String> loanIdList = new ArrayList<String>();
        Map<String, Object> reMap = Maps.newHashMap();
        for(Map<String, Object> map : list){
            String loanId= map.get("loanId")==null?"":map.get("loanId").toString();
            if(StringUtils.isNotBlank(loanId)){
                loanIdList.add(loanId);
            }                    
        }
        reMap.put("loanIdList", loanIdList);
        reMap.put("posChannel", "UM");
        reMap.put("posKind", "4");
        allList = loanPosCreditApplyService.selectTPosByMap(reMap);
        HSSFSheet sheet = wb.createSheet("银商月流水表");
        
        int[] columWidth = {25,15,15,15,15,15,15,15,15,15};
        
        for (int i = 0; i < columWidth.length; i++) {
            sheet.setColumnWidth(i, 256 * columWidth[i]);
        }
        Row headerRow = sheet.createRow(0);
        Cell cell = headerRow.createCell(0);
        
        String [] currentHeaderArr = UPMPOSSERIALHEADER;
        for (int i = 0; i < currentHeaderArr.length; i++) {
            cell = headerRow.createCell(i);
            cell.setCellValue(currentHeaderArr[i]);
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
        }
        
     // freeze the first row
        sheet.createFreezePane(0, 1);
        Row row;
        int rownum = 1;
        if(allList!=null&&allList.size()>0){
            for(TPosSerialnoInfo t : allList){
                int j = 0;
                row = sheet.createRow(rownum);               
                
                cell = row.createCell(j);//商户名称
                cell.setCellValue(StringUtils.trimToEmpty(t.getMerchantName()));
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//商户代码
                cell.setCellValue(StringUtils.trimToEmpty(t.getMerchantId()));
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//MCC
                cell.setCellValue(StringUtils.trimToEmpty(t.getMerchantTypeCode()));
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//交易月份
                cell.setCellValue(t.getTradeDate()==null?"":t.getTradeDate().substring(0, 7));
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//月交易额
                cell.setCellValue(t.getTradeAmt()==null?"":t.getTradeAmt().toString());
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                
                cell = row.createCell(j);//月交易笔数
                cell.setCellValue(StringUtils.trimToEmpty(t.getTradeNum()));
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                j++;
                rownum++;
            }
                       
        }
        
        
        
    }
    
    
    
    public String getItemName(String channel){
        String itemName = "";
        for(Map<String,Object> map : channelDictionary){
            if(StringUtils.equals(channel, (String) map.get("itemNo"))){
                itemName = (String) map.get("itemName");
                break;
            }
        }
        
        return itemName;
    }
    
    public String getProvince(String pid){
        String itemName = "";
        for(Map<String,Object> map : provinceList){
            if(StringUtils.equals(pid, (String) map.get("itemNo"))){
                itemName = (String) map.get("itemName");
                break;
            }
        }
        return itemName;
    }
    
    public String getCity(String cid){
        String itemName = "";
        for(Map<String,Object> map : cities){
            if(StringUtils.equals(cid, (String) map.get("itemNo"))){
                itemName = (String) map.get("itemName");
                break;
            }
        }
        return itemName;
    }
    
    public int getAge(String dateStr){
        
        String currentDateStr =  DateUtil.getCurrentTimePattern3();
        return Integer.parseInt(currentDateStr.substring(0, 4))-Integer.parseInt(dateStr.substring(0, 4));
    }
    
    public String getBankName(String bankAccno){
        String bankName = "";
        for(Map<String,Object> map : bankAccnoInfoList){
            if(StringUtils.equals(bankAccno, (String) map.get("bankAccno"))){
                bankName = (String) map.get("bankName");
                break;
            }
        }
        return bankName;
    }
}
