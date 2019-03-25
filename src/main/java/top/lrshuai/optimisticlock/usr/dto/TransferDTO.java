package top.lrshuai.optimisticlock.usr.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferDTO {
    /**
     * 转账人
     */
    private Long fromUserId;
    /**
     * 给谁转账
     */
    private Long toUserId;

    /**
     * 转账金额
     */
    private BigDecimal amount;
}
