package com.nongxin.terminal.util;

import com.nongxin.terminal.entity.crop.CropBatch;
import com.nongxin.terminal.entity.plant.*;
import com.nongxin.terminal.entity.retrospective.RetroCoding;
import com.nongxin.terminal.entity.system.Role;
import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.service.crop.CropBatchService;
import com.nongxin.terminal.service.plan.PrepareItemService;
import com.nongxin.terminal.service.plan.WorkOrderService;
import com.nongxin.terminal.service.retrospective.RetroCodingService;
import com.nongxin.terminal.util.enumUtil.crop.HarvestedTypeEnum;
import com.nongxin.terminal.util.enumUtil.retrospective.RetroCodingTypeEnum;
import com.nongxin.terminal.vo.workorder.BudgetVo;
import com.nongxin.terminal.vo.workorder.BusinessReportVo;
import com.nongxin.terminal.vo.workorder.OrderConditionVo;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Configuration
public class ExportExcelUtil {

    @Autowired
    private PrepareItemService prepareItemService;
    @Autowired
    private WorkOrderService workOrderService;
    @Autowired
    private CropBatchService cropBatchService;
    @Autowired
    private RetroCodingService retroCodingService;

    /**
     * 导出Excel
     * @param title 标题
     * @param values 内容
     * @return
     */
    public static HSSFWorkbook getHSSFWorkbook(String []title, String [][]values){

        HSSFWorkbook wb = new HSSFWorkbook();

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet();

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式

        //声明列对象
        HSSFCell cell = null;
        //创建标题
        for(int i=0;i<title.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
            sheet.setColumnWidth(i, 15 * 256);
        }

        //创建内容
        for(int i=0;i<values.length;i++){
            row = sheet.createRow(i + 1);
            for(int j=0;j<values[i].length;j++){
                //将内容按顺序赋给对应的列对象
                row.createCell(j).setCellValue(values[i][j]);
            }

        }
        sheet.setColumnWidth(1, 25 * 256);
        return wb;
    }

    /**
     * 导出准备事项
     * @param batchId
     * @param year
     * @param response
     */
    public void prepareItemExport(Integer batchId, String year, HttpServletResponse response){

        List<PrepareItem> list = prepareItemService.getPrepareItem(batchId,year);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); //加上时间

        // excel标题
        String[] title = { "农事项目", "农事周期", "最少人数", "物资名称", "单位", "数量","预算费用","到位日期"};

        // excel文件名
        String fileName = System.currentTimeMillis()+".xls";

        String[][] content = new String[list.size()][title.length];
        for (int i = 0; i < list.size(); i++) {
            PrepareItem prepareItem = list.get(i);
            content[i][0] = prepareItem.getFarmingItem().getFarmingName();
            content[i][1] = simpleDateFormat.format(prepareItem.getStartTime())+"至"+simpleDateFormat.format(prepareItem.getEndTime());
            content[i][2] = prepareItem.getMinPerson().toString();
            content[i][3] = prepareItem.getMaterialName();
            content[i][4] = prepareItem.getCompany();
            content[i][5] = prepareItem.getNum().toString();
            content[i][6] = prepareItem.getBudgetCosts().toString();
            content[i][7] = simpleDateFormat.format(prepareItem.getInplaceTime());
        }
        HSSFWorkbook wb = ExportExcelUtil.getHSSFWorkbook(title, content);

        //导出
        OutputStream ouputStream = null;
        try {
            response.setContentType("application/force-download");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition","attachment;fileName="+new String(fileName.getBytes("UTF-8"),"iso-8859-1"));
            ouputStream = response.getOutputStream();
            wb.write(ouputStream);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (ouputStream != null){
                try {
                    ouputStream.flush();
                    ouputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 导出工单
     * @param orderConditionVo
     * @param response
     */
    public void workOrderExport(OrderConditionVo orderConditionVo, HttpServletResponse response) {

        List<WorkOrder> list = workOrderService.exportWorkOrder(orderConditionVo);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); //加上时间

        // excel标题
        String[] title = {"执行日期", "节气", "种植批次", "农事名称", "工单类型", "工单状态", "对应角色", "执行人"};

        // excel文件名
        String fileName = System.currentTimeMillis()+".xls";

        String[][] content = new String[list.size()][title.length];
        for (int i = 0; i < list.size(); i++) {
            WorkOrder workOrder = list.get(i);
            content[i][0] = simpleDateFormat.format(workOrder.getExecutionTime());
            content[i][1] = workOrder.getSolarTerm() != null ? workOrder.getSolarTerm().getDisplayName() : null;
            content[i][2] = workOrder.getCropBatch().getBatchName();
            content[i][3] = workOrder.getFarmingItem().getFarmingName();
            content[i][4] = workOrder.getType().getDisplayName();
            content[i][5] = workOrder.getStatus().getDisplayName();
            StringBuffer roleName = new StringBuffer();
            for (int j = 0; j < workOrder.getRoleList().size(); j++) {
                if (j == (workOrder.getRoleList().size() - 1)) {
                    roleName.append(workOrder.getRoleList().get(j).getName());
                } else {
                    roleName.append(workOrder.getRoleList().get(j).getName() + "、");
                }
            }
            content[i][6] = roleName.toString();
            if (workOrder.getUser() != null){
                content[i][7] = workOrder.getUser().getRealName();
            }
        }
        HSSFWorkbook wb = ExportExcelUtil.getHSSFWorkbook(title, content);

        //导出
        OutputStream ouputStream = null;
        try {
            response.setContentType("application/force-download");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;fileName=" + new String(fileName.getBytes("UTF-8"), "iso-8859-1"));
            ouputStream = response.getOutputStream();
            wb.write(ouputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ouputStream != null) {
                try {
                    ouputStream.flush();
                    ouputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 导出预算报表
     * @param batchIds
     * @param response
     */
    public void budgetExport(int[] batchIds, HttpServletResponse response) {

        List<BudgetVo> list  = prepareItemService.getBudgetByBatchIds(batchIds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); //加上时间

        // excel标题
        String[] title = {"时间","农事","工种",	"人*天","元/人/天","小计","总计","物料名称","物料单位","物料单价",
                "物料数量","物料小计","物料总价","农机名称","农机单位","农机单价","农机数量","农机小计","农机总价","合计(元)"};

        // excel文件名
        String fileName = System.currentTimeMillis()+".xls";
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet();
        HSSFRow row = sheet.createRow(0);
        // 创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        //声明列对象
        HSSFCell cell = null;
        //创建标题
        for(int i=0;i<title.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
            sheet.setColumnWidth(i, 16 * 256);
        }

        //创建内容
        int rowCount = 0;
        for(int i=0;i<list.size();i++){
            BudgetVo budgetVo = list.get(i);
            rowCount += 1;
            row = sheet.createRow(rowCount);

            //行
            int personnelCount = budgetVo.getPersonnelActList().size();
            int materialCount = budgetVo.getMaterialActList().size();
            int deviceCount = budgetVo.getDeviceActList().size();

            //总计
            BigDecimal perTotalPic = new BigDecimal("0");
            BigDecimal matTotalPic = new BigDecimal("0");
            BigDecimal devTotalPic = new BigDecimal("0");

            row.createCell(0).setCellValue(simpleDateFormat.format(budgetVo.getExecutionTime()));
            row.createCell(1).setCellValue(budgetVo.getFarmingName());

            int temp = (personnelCount >= materialCount) ? personnelCount : materialCount;
            int count = (temp >= deviceCount) ? temp : deviceCount;
            int tempCount = rowCount;

            for (int j = 0; j < count; j++) {
                HSSFRow row1 = null;
                if (j == 0){
                    row1 = row;
                }else{
                    tempCount++;
                    row1 = sheet.createRow(tempCount);
                }
                //人员
                if (j < personnelCount){
                    PersonnelAct personnelAct = budgetVo.getPersonnelActList().get(j);
                    perTotalPic = perTotalPic.add(personnelAct.getPreCal());
                    row1.createCell(2).setCellValue(personnelAct.getPersonName());
                    row1.createCell(3).setCellValue(personnelAct.getPreUnitCount().toString());
                    row1.createCell(4).setCellValue(personnelAct.getPreUnitPrice().toString());
                    row1.createCell(5).setCellValue(personnelAct.getPreCal().toString());
                }
                //物料
                if (j < materialCount){
                    MaterialAct materialAct = budgetVo.getMaterialActList().get(j);
                    matTotalPic = matTotalPic.add(materialAct.getPreCal());
                    row1.createCell(7).setCellValue(materialAct.getMaterialName());
                    row1.createCell(8).setCellValue(materialAct.getCompany());
                    row1.createCell(9).setCellValue(materialAct.getPreUnitPrice().toString());
                    row1.createCell(10).setCellValue(materialAct.getPreUnitCount().toString());
                    row1.createCell(11).setCellValue(materialAct.getPreCal().toString());
                }
                //设备
                if (j < deviceCount){
                    DeviceAct deviceAct = budgetVo.getDeviceActList().get(j);
                    devTotalPic = devTotalPic.add(deviceAct.getPreCal());
                    row1.createCell(13).setCellValue(deviceAct.getDeviceName());
                    row1.createCell(14).setCellValue(deviceAct.getCompany());
                    row1.createCell(15).setCellValue(deviceAct.getPreUnitPrice().toString());
                    row1.createCell(16).setCellValue(deviceAct.getPreUnitCount().toString());
                    row1.createCell(17).setCellValue(deviceAct.getPreCal().toString());
                }
            }

            if (tempCount-rowCount>0){
                //合并时间
                sheet.addMergedRegion(new CellRangeAddress(rowCount, tempCount, 0, 0));
                sheet.getRow(rowCount).getCell(0).setCellStyle(style);
                //合并农事
                sheet.addMergedRegion(new CellRangeAddress(rowCount, tempCount, 1, 1));
                sheet.getRow(rowCount).getCell(1).setCellStyle(style);
                //人资总计
                sheet.addMergedRegion(new CellRangeAddress(rowCount, tempCount, 6, 6));
                row.createCell(6).setCellValue(perTotalPic.toString());
                row.getCell(6).setCellStyle(style);
                //物料总计
                sheet.addMergedRegion(new CellRangeAddress(rowCount, tempCount, 12, 12));
                row.createCell(12).setCellValue(matTotalPic.toString());
                row.getCell(12).setCellStyle(style);
                //农机总计
                sheet.addMergedRegion(new CellRangeAddress(rowCount, tempCount, 18, 18));
                row.createCell(18).setCellValue(devTotalPic.toString());
                row.getCell(18).setCellStyle(style);
                //合并合计
                sheet.addMergedRegion(new CellRangeAddress(rowCount, tempCount, 19, 19));
                row.createCell(19).setCellValue(budgetVo.getCostSum().toString());
                sheet.getRow(rowCount).getCell(19).setCellStyle(style);
            }else{
                //时间
                sheet.getRow(rowCount).getCell(0).setCellStyle(style);
                //农事项目
                sheet.getRow(rowCount).getCell(1).setCellStyle(style);
                //人资总计
                row.createCell(6).setCellValue(perTotalPic.toString());
                row.getCell(6).setCellStyle(style);
                //物资总计
                row.createCell(12).setCellValue(matTotalPic.toString());
                row.getCell(12).setCellStyle(style);
                //设备总计
                row.createCell(18).setCellValue(devTotalPic.toString());
                row.getCell(18).setCellStyle(style);
                //合计
                row.createCell(19).setCellValue(budgetVo.getCostSum().toString());
                sheet.getRow(rowCount).getCell(19).setCellStyle(style);
            }
            rowCount = tempCount;
        }

        //导出
        OutputStream ouputStream = null;
        try {
            response.setContentType("application/force-download");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;fileName=" + new String(fileName.getBytes("UTF-8"), "iso-8859-1"));
            ouputStream = response.getOutputStream();
            wb.write(ouputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ouputStream != null) {
                try {
                    ouputStream.flush();
                    ouputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 导出预算报表
     * @param cropBatch
     * @param response
     */
    public void businessExport(CropBatch cropBatch, HttpServletResponse response) {

        List<BusinessReportVo> list  = cropBatchService.getBusinessReport(cropBatch);

        // excel文件名
        String fileName = System.currentTimeMillis()+".xls";
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet();
        HSSFRow row = sheet.createRow(0);
        // 创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);  // 左右居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);  //上下居中

        //声明列对象
        HSSFCell cell = null;
        //创建标题
        cell = row.createCell(0);
        cell.setCellValue("批次名称");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("采收物");
        cell.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 2));//合并单元格

        cell = row.createCell(3);
        cell.setCellValue("农资物料");
        cell.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 3, 4));//合并单元格

        cell = row.createCell(5);
        cell.setCellValue("人力成本");
        cell.setCellStyle(style);

        cell = row.createCell(6);
        cell.setCellValue("年份");
        cell.setCellStyle(style);

        cell = row.createCell(7);
        cell.setCellValue("基地负责人");
        cell.setCellStyle(style);

        for(int i=0;i<9;i++){
            sheet.setColumnWidth(i, 15 * 256);
        }


        //创建内容
        int rowCount = 0;
        for(int i=0;i<list.size();i++){

            BusinessReportVo businessVo = list.get(i);
            rowCount += 1;
            row = sheet.createRow(rowCount);
            int tempCount = rowCount;

            row.createCell(0).setCellValue(businessVo.getBatchName());
            row.createCell(1).setCellValue("产成品名称");
            row.createCell(2).setCellValue("产成品产量");
            row.createCell(3).setCellValue("农资物料名称");
            row.createCell(4).setCellValue("农资物料金额(元)");

            int count = (businessVo.getDeviceCost().size()+businessVo.getMaterielCost().size()) >= businessVo.getHarvested().size() ?
                    (businessVo.getDeviceCost().size()+businessVo.getMaterielCost().size()):businessVo.getHarvested().size();
            //合并物料和设备
            businessVo.getMaterielCost().addAll(businessVo.getDeviceCost());

            System.out.println("count"+businessVo.getMaterielCost().size());

            for (int j = 0; j <count; j++) {
                tempCount ++;
                HSSFRow row1 = sheet.createRow(tempCount);
                if (j < businessVo.getHarvested().size()){
                    row1.createCell(1).setCellValue(((HarvestedTypeEnum)businessVo.getHarvested().get(j).get("type")).getDisplayName()+"-"+
                            businessVo.getHarvested().get(j).get("harvestedName"));
                    row1.createCell(2).setCellValue(businessVo.getHarvested().get(j).get("totalYield").toString());
                }
                if (j < businessVo.getMaterielCost().size()){
                    row1.createCell(3).setCellValue(businessVo.getMaterielCost().get(j).get("materialName").toString());
                    row1.createCell(4).setCellValue(businessVo.getMaterielCost().get(j).get("cost").toString());
                }
            }

            //人力成本
            row.createCell(5).setCellValue(businessVo.getHumanCost().toString());
            //年份
            row.createCell(6).setCellValue(businessVo.getStartYear().toString());
            //地块负责人
            String userName = "";
            for (User user : businessVo.getUserList()) {
                userName+=user.getRealName()+"、";
            }
            row.createCell(7).setCellValue(userName.substring(0,userName.lastIndexOf("、")));
            //合并批次名称
            sheet.addMergedRegion(new CellRangeAddress(rowCount, tempCount, 0, 0));
            sheet.getRow(rowCount).getCell(0).setCellStyle(style);
            //合并人力成本
            sheet.addMergedRegion(new CellRangeAddress(rowCount, tempCount, 5, 5));
            sheet.getRow(rowCount).getCell(5).setCellStyle(style);
            //合并年份
            sheet.addMergedRegion(new CellRangeAddress(rowCount, tempCount, 6, 6));
            sheet.getRow(rowCount).getCell(6).setCellStyle(style);
            //合并基地负责人
            sheet.addMergedRegion(new CellRangeAddress(rowCount, tempCount, 7, 7));
            sheet.getRow(rowCount).getCell(7).setCellStyle(style);

            rowCount = tempCount;
        }

        //导出
        OutputStream ouputStream = null;
        try {
            response.setContentType("application/force-download");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;fileName=" + new String(fileName.getBytes("UTF-8"), "iso-8859-1"));
            ouputStream = response.getOutputStream();
            wb.write(ouputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ouputStream != null) {
                try {
                    ouputStream.flush();
                    ouputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 导出追溯打码
     * @param response
     */
    public void retroCodingExport(RetroCodingTypeEnum type, String batchCode, String retroCode, HttpServletResponse response){

        List<RetroCoding> list = null;
        if (type != null || batchCode == null){
            list = retroCodingService.getRetroCoding(type,batchCode,retroCode);
        }else{
            if (batchCode.indexOf("CS") != -1){
                list = retroCodingService.getRetroCoding(RetroCodingTypeEnum.RECO_BATCH,batchCode,retroCode);
            }else{
                list = retroCodingService.getRetroCoding(RetroCodingTypeEnum.INIT_BATCH,batchCode,retroCode);
            }
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); //加上时间

        // excel标题
        String[] title = { "追溯码", "打码时间", "品种名称", "批次类型", "批次编码", "药材规格","产地","质检员","注意事项"};

        // excel文件名
        String fileName = System.currentTimeMillis()+".xls";

        String[][] content = new String[list.size()][title.length];
        for (int i = 0; i < list.size(); i++) {
            RetroCoding retroCoding = list.get(i);
            content[i][0] = retroCoding.getRetroCode();
            content[i][1] = retroCoding.getCodingTime()==null ? "" : simpleDateFormat.format(retroCoding.getCodingTime());
            content[i][2] = retroCoding.getRetroCodeInfo().getCrop().getCropName();
            content[i][3] = retroCoding.getRetroCodeInfo().getType().getDisplayName();
            if (retroCoding.getRetroCodeInfo().getType()==RetroCodingTypeEnum.RECO_BATCH){
                content[i][4] = retroCoding.getRetroCodeInfo().getRecoveryBatch().getRecoveryCode();
            }else{
                content[i][4] = retroCoding.getRetroCodeInfo().getInitialProBatch().getInitialProcessingCode();
            }
            content[i][5] = retroCoding.getRetroCodeInfo().getSpecifications();
            content[i][6] = retroCoding.getRetroCodeInfo().getProvenance();
            content[i][7] = retroCoding.getRetroCodeInfo().getQc();
            content[i][8] = retroCoding.getRetroCodeInfo().getRemarks();
        }
        HSSFWorkbook wb = ExportExcelUtil.getHSSFWorkbook(title, content);

        //导出
        OutputStream ouputStream = null;
        try {
            response.setContentType("application/force-download");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition","attachment;fileName="+new String(fileName.getBytes("UTF-8"),"iso-8859-1"));
            ouputStream = response.getOutputStream();
            wb.write(ouputStream);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (ouputStream != null){
                try {
                    ouputStream.flush();
                    ouputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

    }

}
