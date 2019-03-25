package top.lrshuai.optimisticlock.usr.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class UserAccount implements Serializable {
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 余额
     */
    private BigDecimal balance;
    /**
     * 乐观锁版本号
     */
    private Long version;
    private Long createBy;
    private LocalDateTime createTime;

    private Long modifyBy;
    private LocalDateTime modifyTime;
}
