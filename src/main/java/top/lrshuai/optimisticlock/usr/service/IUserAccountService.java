package top.lrshuai.optimisticlock.usr.service;

import top.lrshuai.optimisticlock.common.Result;
import top.lrshuai.optimisticlock.usr.dto.TransferDTO;

public interface IUserAccountService {
    /**
     * 转账
     * @param dto
     * @return
     * @throws Exception
     */
    public Result transfter(TransferDTO dto) throws Exception;

}
