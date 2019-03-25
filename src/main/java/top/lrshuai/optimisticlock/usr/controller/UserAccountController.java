package top.lrshuai.optimisticlock.usr.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lrshuai.optimisticlock.common.Result;
import top.lrshuai.optimisticlock.usr.dto.TransferDTO;
import top.lrshuai.optimisticlock.usr.service.IUserAccountService;

@RestController
@RequestMapping("/usr/userAccount")
public class UserAccountController {

    @Autowired
    private IUserAccountService userAccountService;

    @PostMapping("/transfter")
    @ApiOperation("转账操作")
    public Result transfter(TransferDTO dto) throws Exception {
        return userAccountService.transfter(dto);
    }
}
