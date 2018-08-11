package com.xyb.pmb;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

public class TransRatioServiceImpl implements TransRatioService {

    @Resource
    private TransRatioService transRatioService;

    @Override
    public void init(Date regDate) {
        initDreamUser(regDate);
    }

    @Override
    public List<Long> selectFirstDreamUsers(Date regDate) {
        return null;
    }

    private void initDreamUser(Date regDate) {
        //获取今天首次创建钱罐的用户
        List<Long> userIds = transRatioService.selectFirstDreamUsers(regDate);

    }
}
