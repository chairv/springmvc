package com.xyb.pmb;

import java.util.Date;
import java.util.List;

public interface TransRatioService {

    void init(Date regDate);

    List<Long> selectFirstDreamUsers(Date regDate);
}
