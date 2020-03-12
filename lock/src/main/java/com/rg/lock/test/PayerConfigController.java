package com.rg.lock.test;

import com.ogwls.bo.req.*;
import com.ogwls.bo.res.OfflinePayChannelBO;
import com.ogwls.bo.res.OfflinePayerConfigBO;
import com.ogwls.bo.res.OnlinePayChannelBO;
import com.ogwls.bo.res.ScanPayConfigBO;
import com.ogwls.common.base.PageBaseData;
import com.ogwls.domain.entity.SysUser;
import com.ogwls.service.OffliinePayManageService;
import com.ogwls.service.OnlinePayManageService;
import com.ogwls.service.SessionTokenService;
import com.ogwls.webapi.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Api(tags = "支付配置接口", value = "/payer-config")
@RequestMapping("/payer-config")
public class PayerConfigController extends BaseController {

  @Autowired
  private OnlinePayManageService onlinePayManageService;

  @Autowired
  private SessionTokenService sessionTokenService;
  @GetMapping("/online-pay-channels/scan")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "Authorization", value = "登录凭证(格式bearer+空格+token值)", dataType = "String", paramType = "header", required = true),
      @ApiImplicitParam(name = "payerType", dataType = "Integer", required = true, paramType = "path", value = "支付配置类型(onlinePay=在线支付 1转账支付 2扫码支付 3钱包支付 4点卡支付)"),
      @ApiImplicitParam(name = "userType", dataType = "Integer", required = true, paramType = "path", value = "会员角色(1=会员, 2=厅主, 3=股东)")
  })
  @ApiOperation(value = "查询线上第三方支付扫码配置信息", code = 200, httpMethod = "GET")
  public ResponseEntity<List<ScanPayConfigBO>> findScanPayConfig(HttpServletRequest request,
      @RequestParam(value = "payerType", required = true) int payerType) throws Exception {

    return null;
  }

  @GetMapping("/offline-payer-configs")
  @ApiImplicitParam(name = "Authorization", value = "登录凭证(格式bearer+空格+token值)", dataType = "String", paramType = "header", required = true)
  @ApiOperation(value = "查询线下银行卡支付配置信息", code = 200, httpMethod = "GET", produces = "application/json")
  public ResponseEntity<List<OfflinePayerConfigBO>> findOfflinePayerConfig(
      HttpServletRequest request, @Valid OfflinePayerBO bo) {

    return null;
  }

  @PostMapping("/third-party-payers")
  @ApiImplicitParam(name = "Authorization", value = "登录凭证(格式bearer+空格+token值)", dataType = "String", paramType = "header", required = true)
  @ApiOperation(value = "添加第三方在线支付商", notes = "添加支付商", code = 201, httpMethod = "Post", produces = "application/json")
  public ResponseEntity<ThirdPartyPayerBO> insertThirdPartyPayer(HttpServletRequest request,
      ThirdPartyPayerBO bo) {

    return null;
  }

  @PutMapping("/third-party-payers")
  @ApiImplicitParam(name = "Authorization", value = "登录凭证(格式bearer+空格+token值)", dataType = "String", paramType = "header", required = true)
  @ApiOperation(value = "修改第三方在线支付商", notes = "修改支付商", code = 201, httpMethod = "Post", produces = "application/json")
  public ResponseEntity<ThirdPartyPayerBO> updateThirdPartyPayer(HttpServletRequest request,
      ThirdPartyPayerBO bo) {

    return null;
  }

  @DeleteMapping("third-party-payers")
  @ApiImplicitParam(name = "Authorization", value = "登录凭证(格式bearer+空格+token值)", dataType = "String", paramType = "header", required = true)
  @ApiOperation(value = " 删除第三方在线支付商", notes = "删除支付商", code = 204, httpMethod = "DELETE", produces = "application/json")
  public ResponseEntity deleteThirdPartyPayer(HttpServletRequest request,
      ThirdPartyPayerDeleteBO bo) {

    return null;
  }

  @PostMapping("/offline-payers")
  @ApiImplicitParam(name = "Authorization", value = "登录凭证(格式bearer+空格+token值)", dataType = "String", paramType = "header", required = true)
  @ApiOperation(value = "新增线下支付商配置", notes = "新增线下支付商", code = 201, httpMethod = "Post", produces = "application/json")
  public ResponseEntity<InsertOfflinePayerBO> insertOfflinePayer(HttpServletRequest request,
      InsertOfflinePayerBO offlinePayerBO) {

    return null;
  }

  @PutMapping("/offline-payers")
  @ApiImplicitParam(name = "Authorization", value = "登录凭证(格式bearer+空格+token值)", dataType = "String", paramType = "header", required = true)
  @ApiOperation(value = "修改线下支付商配置", notes = "修改线下支付商", code = 201, httpMethod = "Post", produces = "application/json")
  public ResponseEntity<UpdateOfflinePayerBO> updateOfflinePayer(HttpServletRequest request,
      UpdateOfflinePayerBO updateOfflinePayerBO) {

    return null;
  }

  @DeleteMapping("/offline-payers")
  @ApiImplicitParam(name = "Authorization", value = "登录凭证(格式bearer+空格+token值)", dataType = "String", paramType = "header", required = true)
  @ApiOperation(value = "删除线下支付商配置", notes = "删除线下支付商", code = 204, httpMethod = "Delete", produces = "application/json")
  public ResponseEntity deleteOfflinePayer(HttpServletRequest request, DeleteOfflinePayerBO bo) {

    return null;
  }

  @PatchMapping("/online-payer-channels/status")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "Authorization", value = "登录凭证(格式bearer+空格+token值)", dataType = "String", paramType = "header", required = true),
      @ApiImplicitParam(name = "ids", value = "支付商编号, 多个id 以逗号隔开", dataType = "String", paramType = "query", required = true),
      @ApiImplicitParam(name = "status", value = "状态", dataType = "Integer", paramType = "query", required = true)
  })
  @ApiOperation(value = "修改支付渠道的状态", notes = "修改支付渠道的状态", code = 200, httpMethod = "Patch")
  public ResponseEntity updateOnlinePayerChannelStatus(HttpServletRequest request,
      @RequestParam(value = "ids", required = true) String ids,
      @RequestParam(value = "status", required = true) Integer status) {

    return null;
  }

  @PatchMapping("/online-payer-channels/operate-status")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "Authorization", value = "登录凭证(格式bearer+空格+token值)", dataType = "String", paramType = "header", required = true),
      @ApiImplicitParam(name = "ids", value = "支付商编号, 多个id 以逗号隔开", dataType = "String", paramType = "query", required = true),
      @ApiImplicitParam(name = "operateStatus", value = "状态", dataType = "Integer", paramType = "query", required = true)
  })
  @ApiOperation(value = "修改支付渠道的操作状态", notes = "修改支付渠道的操作状态", code = 200, httpMethod = "Patch")
  public ResponseEntity updateOnlinePayerChannelOperateStatus(HttpServletRequest request,
      @RequestParam(value = "ids", required = true) String ids,
      @RequestParam(value = "operateStatus", required = true) Integer operateStatus) {

    return null;
  }

  @GetMapping("/online-pay-channels")
  @ApiImplicitParam(name = "Authorization", value = "登录凭证(格式bearer+空格+token值)", dataType = "String", paramType = "header", required = true)
  @ApiOperation(value = "会员线上支付列表", notes = "会员线上支付列表", code = 200, httpMethod = "get")
  public ResponseEntity<PageBaseData<OnlinePayChannelBO>> findAllOnlinePayChannels(
      HttpServletRequest request,@Valid SelectOnlinePayBo selectOnlinePayBo) {

    SysUser sysUser=sessionTokenService.getToken(request);
    return null;
  }

  @GetMapping("/offline-pay-channels")
  @ApiImplicitParam(name = "Authorization", value = "登录凭证(格式bearer+空格+token值)", dataType = "String", paramType = "header", required = true)
  @ApiOperation(value = "会员线下支付列表", notes = "会员线下支付列表", code = 200, httpMethod = "get")
  public ResponseEntity<PageBaseData<OfflinePayChannelBO>> findAllOfflinePayChannels(
      HttpServletRequest request) {

    return null;
  }

}
