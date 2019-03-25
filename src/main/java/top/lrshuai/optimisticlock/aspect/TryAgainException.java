package top.lrshuai.optimisticlock.aspect;

import top.lrshuai.optimisticlock.common.ApiException;
import top.lrshuai.optimisticlock.common.ApiResultEnum;

/**
 * 更新重试异常
 */
public class TryAgainException extends ApiException {

    public TryAgainException(ApiResultEnum apiResultEnum) {
        super(apiResultEnum);
    }

}
